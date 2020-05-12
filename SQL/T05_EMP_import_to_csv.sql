create or replace PROCEDURE T05_EMP_import_to_csv(
  iFileName	    IN  VARCHAR2
  ,errMsg			OUT VARCHAR2
)IS
    Total_REC_Count				        NUMBER	:= 0;
    Total_REC_Processed                 NUMBER  := 0;
    fno							        UTL_FILE.FILE_TYPE;
    iData                               VARCHAR2 (32765);
    Linebuf                             VARCHAR2 (4000);
    USER_ERROR					        EXCEPTION;
    FILE_END_ARRIVAL			        EXCEPTION;
    -- t?o ra m?t OBJ wT05_EMP c? c?c tr??ng v? type t??ng ?ng v?i b?ng T05_EMP
    wT05_EMP                            T05_EMP%ROWTYPE;
    
/*
T?o ra  PROCEDURE P_DATA_T05EMP     c? c?c nhi?m v?
    Ch?a function cover th?nh d?ng data chu?n
    validate data ??u v?o
    Gh?p t?ng d?ng data v?o OBJ wT05_EMP
*/
PROCEDURE P_DATA_T05EMP (
    vBuf				IN 	VARCHAR2
) IS
    FUNCTION F_DATA_T05EMP(iPos IN INTEGER) RETURN VARCHAR2 IS
	vRet				VARCHAR2(512);
	BEGIN
        vRet								:=	regexp_substr(vBuf, '[^,]+', 1, iPos);
        vRet								:=	REPLACE(vRet, '"', '');
        vRet								:=	REPLACE(vRet, '—‚b‚n‚l—', ',');
        vRet								:=	REPLACE(vRet, '—‚c‚p—', '"');
        vRet								:=	REPLACE(vRet, '—‚b‚q—', chr(10));
		RETURN TRIM(vRet);

	END F_DATA_T05EMP;
BEGIN
        --CHECK FIRST_NAME LENGTH
        IF LENGTHB(F_DATA_T05EMP(2)) > 255 THEN
            errMsg					:=	'FIRST_NAME LENGTH ERR';
            RAISE USER_ERROR;
        END IF;
        
        --CHECK LAST_NAME LENGTH
        IF LENGTHB(F_DATA_T05EMP(3)) > 255 THEN
            errMsg					:=	'LAST_NAME LENGTH ERR';
            RAISE USER_ERROR;
        END IF;
        
        --CHECK EMAIL LENGTH
        IF LENGTHB(F_DATA_T05EMP(4)) > 255 THEN
            errMsg					:=	'EMAIL LENGTH ERR';
            RAISE USER_ERROR;
        END IF;
        
        --CHECK PHONE LENGTH
        IF LENGTHB(F_DATA_T05EMP(5)) > 50 THEN
            errMsg					:=	'PHONE LENGTH ERR';
            RAISE USER_ERROR;
        END IF;
    --Gh?p c?c gi? tr? v?o OBJ wT05_EMP 
    wT05_EMP.EMPLOYEE_ID        :=  F_DATA_T05EMP(1);
    wT05_EMP.FIRST_NAME         :=  F_DATA_T05EMP(2);
    wT05_EMP.LAST_NAME          :=  F_DATA_T05EMP(3);
    wT05_EMP.EMAIL              :=  F_DATA_T05EMP(4);
    wT05_EMP.PHONE              :=  F_DATA_T05EMP(5);
    wT05_EMP.HIRE_DATE          :=  F_DATA_T05EMP(6);
    wT05_EMP.MANAGER_ID         :=  F_DATA_T05EMP(7);
    wT05_EMP.JOB_TITLE          :=  F_DATA_T05EMP(8);
END P_DATA_T05EMP;


/*
T?o ra PROCEDURE P_INS_T05_EMP con c? c?c nhi?m v?
    insert d? li?u v?o b?ng T05_EMP
*/
PROCEDURE P_INS_T05_EMP (
    I IN wT05_EMP%ROWTYPE
)IS
    BEGIN
        INSERT INTO T05_EMP (
            EMPLOYEE_ID
            ,FIRST_NAME
            ,LAST_NAME
            ,EMAIL
            ,PHONE
            ,HIRE_DATE
            ,MANAGER_ID
            ,JOB_TITLE
        ) VALUES (
            I.EMPLOYEE_ID
            ,I.FIRST_NAME
            ,I.LAST_NAME
            ,I.EMAIL
            ,I.PHONE
            ,I.HIRE_DATE
            ,I.MANAGER_ID
            ,I.JOB_TITLE
        );
END P_INS_T05_EMP;

BEGIN
    BEGIN
    -- M? file CSV ??u v?o
		fno := UTL_FILE.FOPEN('CSV_INPUT_DIR', iFileName, 'R');
    -- Ngo?i tr? c?c tr??ng h?p l?i li?n quan ??n vi?c m? file
        EXCEPTION
        WHEN UTL_FILE.INVALID_PATH THEN
            errMsg					:=	'FILE OPEN ERR:' || 'INVALID_PATH';
            RAISE USER_ERROR;
        WHEN UTL_FILE.INVALID_MODE THEN
            errMsg					:=	'FILE OPEN ERR:' || 'INVALID_MODE';
            RAISE USER_ERROR;
        WHEN UTL_FILE.INVALID_OPERATION THEN
            errMsg					:=	'FILE OPEN ERR:' || 'INVALID_OPERATION';
            RAISE USER_ERROR;
        WHEN UTL_FILE.INVALID_MAXLINESIZE THEN
            errMsg					:=	'FILE OPEN ERR:' || 'INVALID_MAXLINESIZE';
            RAISE USER_ERROR;
	END;

    LOOP
    /*
        Th?c hi?n ??c d? li?u sau khi ?? m? file csv
        chuy?n d? li?u v?o b? nh? ??m iData
    */
        BEGIN
			UTL_FILE.GET_LINE(fno, iData);
            --DBMS_OUTPUT.PUT_LINE(iData);
		EXCEPTION
		WHEN NO_DATA_FOUND THEN
			EXIT;
		END;
    -- Loop t?ng d?ng v? g?i ??n Procedue P_DATA_T05EMP
        P_DATA_T05EMP(iData);
        --DBMS_OUTPUT.PUT_LINE(iData);
        --DBMS_OUTPUT.PUT_LINE(wT05_EMP.toString);

     -- Loop t?ng d?ng v? g?i ??n Procedue P_INS_T05_EMP
        P_INS_T05_EMP(wT05_EMP);

    END LOOP;
    
     /*
        ??ng file
    */
    IF      UTL_FILE.IS_OPEN(fno) 
    THEN    UTL_FILE.FCLOSE(fno);
	END IF;

EXCEPTION
    WHEN FILE_END_ARRIVAL THEN
        IF      UTL_FILE.IS_OPEN(fno) 
        THEN    UTL_FILE.FCLOSE(fno);
        END IF;
        IF      Total_REC_Processed > 0
        THEN
            COMMIT;
            DBMS_OUTPUT.PUT_LINE('DONE');
        END IF;
    
    WHEN USER_ERROR THEN
        ROLLBACK;
        UTL_FILE.FCLOSE_ALL;
        DBMS_OUTPUT.PUT_LINE('USER_ERROR  ERR');

    WHEN OTHERS THEN
        ROLLBACK; 
        IF      UTL_FILE.IS_OPEN(fno) 
        THEN    UTL_FILE.FCLOSE(fno);
        END IF;  
        errMsg := 'ERR CODE:' || SQLCODE || 'MSG:' || SUBSTRB(SQLERRM, 1,255);
        DBMS_OUTPUT.PUT_LINE('OTHERS  ERR');






END T05_EMP_import_to_csv;