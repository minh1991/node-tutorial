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
    
    -- Field Values Array
    TYPE Fieldvalue IS TABLE OF VARCHAR2 (4000) INDEX BY BINARY_INTEGER;
    t_field         Fieldvalue;
  

BEGIN
    fno := UTL_FILE.FOPEN('CSV_INPUT_DIR', iFileName, 'R');

    LOOP
        UTL_FILE.GET_LINE(fno, iData);
        iData   :=  iData ||   ','; 
        FOR I IN 1 .. 8
        LOOP
            t_field(I)   :=      COMMON_COVER_PKG.Getstring(iData,I,FALSE,',');
            /*Func Getstring ？？？c ？？nh ngh？a trong PACKAGE COMMON_COVER_PKG*/
            DBMS_OUTPUT.PUT_LINE(t_field(I));

        END LOOP;
        BEGIN
           DBMS_OUTPUT.PUT_LINE('DAWQQ');
                       /*----------------START COVER---------------------*/ 
           
                
              
             /*----------------END COVER---------------------*/
            /*----------------------------------------------------------------------------*/ 
            /*----------------START VALIDATE---------------------*/ 
                -- CHECK NUMBER EMPLOYEE_ID
           -- /*IF  regexp_like(t_field(1), '^\d+(\.\d+)?$') THEN
               -- T05_EMP.EMPLOYEE_ID :=  t_field(1);
           -- ELSE
               -- errMsg					:=	'EMPLOYEE_ID NOT NUMBER TYPE';
               -- RAISE USER_ERROR;
          --  END IF;*/
            
            --CHECK FIRST_NAME LENGTH
            IF LENGTHB(t_field(2)) > 255 THEN
                errMsg					:=	'FIRST_NAME LENGTH ERR';
                RAISE USER_ERROR;
            END IF;
            
            --CHECK LAST_NAME LENGTH
            IF LENGTHB(t_field(3)) > 255 THEN
                errMsg					:=	'LAST_NAME LENGTH ERR';
                RAISE USER_ERROR;
            END IF;
            
            --CHECK EMAIL LENGTH
            IF LENGTHB(t_field(4)) > 255 THEN
                errMsg					:=	'EMAIL LENGTH ERR';
                RAISE USER_ERROR;
            END IF;
            
            --CHECK PHONE LENGTH
            IF LENGTHB(t_field(5)) > 50 THEN
                errMsg					:=	'PHONE LENGTH ERR';
                RAISE USER_ERROR;
            END IF;
            
            --CHECK HIRE_DATE TYPE
            /*IF CHECK_DATE(t_field(6)) = 0 THEN
                errMsg					:=	'HIRE_DATE TYPE ERR';
                RAISE USER_ERROR;
            END IF;*/
            
            -- CHECK NUMBER MANAGER_ID
            /*IF  regexp_like(t_field(7), '^\d+(\.\d+)?$') THEN
                T05_EMP.MANAGER_ID :=  F_DATA_T05_EMP(7);
            ELSE
                errMsg					:=	'EMPLOYEE_ID NOT NUMBER TYPE';
                RAISE USER_ERROR;
            END IF;*/
            
            --CHECK JOB_TITLE LENGTH
            IF LENGTHB(t_field(8)) > 50 THEN
                errMsg					:=	'JOB_TITLE LENGTH ERR';
                RAISE USER_ERROR;
            END IF;
            /*----------------END VALIDATE---------------------*/ 
            /*----------------------------------------------------------------------------*/
            
            /*----------------------------------------------------------------------------*/
            Total_REC_Count     :=      Total_REC_Count  +   1;
            /*----------------START INSERT---------------------*/
            INSERT INTO T05_EMP(
                EMPLOYEE_ID
                ,FIRST_NAME
                ,LAST_NAME
                ,EMAIL
                ,PHONE
                ,HIRE_DATE
                ,MANAGER_ID
                ,JOB_TITLE
            )
            VALUES(
                TO_NUMBER(t_field(1))
                ,t_field(2)
                ,t_field(3)
                ,t_field(4)
                ,t_field(5)
                ,t_field(6)
                ,t_field(7)
                ,t_field(8)
            );
            /*----------------END INSERT---------------------*/ 
            Total_REC_Processed     :=      Total_REC_Processed +   1;
            /*----------------------------------------------------------------------------*/
            EXCEPTION
                WHEN UTL_FILE.INVALID_PATH THEN
                    errMsg					:=	'ファイルオープンエラー:' || 'INVALID_PATH';
                    RAISE USER_ERROR;
                WHEN UTL_FILE.INVALID_MODE THEN
                    errMsg					:=	'ファイルオープンエラー:' || 'INVALID_MODE';
                    RAISE USER_ERROR;
                WHEN UTL_FILE.INVALID_OPERATION THEN
                    errMsg					:=	'ファイルオープンエラー:' || 'INVALID_OPERATION';
                    RAISE USER_ERROR;
                WHEN UTL_FILE.INVALID_MAXLINESIZE THEN
                    errMsg					:=	'ファイルオープンエラー:' || 'INVALID_MAXLINESIZE';
                    RAISE USER_ERROR;
        END;
    END LOOP;

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

