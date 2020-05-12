-- HEADER PACKAGE
CREATE OR REPLACE PACKAGE COMMON_COVER_PKG
IS
/*  NAME:                F_CSV_EDIT_STRING                                    */
/*  引数                ：I_EDIT_TYPE       :(IN)  編集タイプ                  */
/*                                                0:数値項目                  */
/*                                                1:文字項目                  */
/*                                                2:日付形式                  */
/*                      ：I_EDIT_STRING     :(IN)  編集対象文字列              */
    FUNCTION F_CSV_EDIT_STRING (
        I_EDIT_TYPE   IN  CHAR,
        I_EDIT_STRING IN  CHAR
    )RETURN CHAR;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/    
    --CHECK DATE
    FUNCTION CHECK_DATE (
      I_STR IN VARCHAR2
      ,I_FORMAT IN VARCHAR2
    )RETURN NUMBER;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
    FUNCTION GetString (Source_string    IN VARCHAR2,
                       Field_position   IN NUMBER,
                       UnTerminated     IN BOOLEAN DEFAULT FALSE,
                       Delimiter        IN VARCHAR2 DEFAULT ',')
    RETURN VARCHAR2;


END COMMON_COVER_PKG;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/
--BODY PACKAGE
CREATE OR REPLACE PACKAGE BODY COMMON_COVER_PKG IS

/*  NAME:                F_CSV_EDIT_STRING                                    */
/*  引数                ：I_EDIT_TYPE       :(IN)  編集タイプ                  */
/*                                                0:数値項目                  */
/*                                                1:文字項目                  */
/*                                                2:日付形式                  */
/*                      ：I_EDIT_STRING     :(IN)  編集対象文字列              */
    FUNCTION F_CSV_EDIT_STRING(
          I_EDIT_TYPE   IN  CHAR,
          I_EDIT_STRING IN  CHAR
    )RETURN CHAR IS
          vEDIT_RESULT    VARCHAR(8000) := NULL;
          vERR_MSG        VARCHAR(8000) := NULL;
          vFLAG           NUMBER;
    BEGIN
        IF I_EDIT_TYPE ='0' THEN
            --GIU NGUYEN
            vEDIT_RESULT := I_EDIT_STRING;
        ELSIF  I_EDIT_TYPE ='1'  THEN
          IF  LENGTHB(RTRIM(I_EDIT_STRING)) <> 0 THEN
            BEGIN
              vFLAG :=  TO_NUMBER(REPLACE(I_EDIT_STRING,'/',''));
              vEDIT_RESULT  :=  '"' || I_EDIT_STRING ||  '"';
            EXCEPTION
              WHEN OTHERS THEN
                vEDIT_RESULT  :=  REPLACE(I_EDIT_STRING,'"', '""');
                vEDIT_RESULT  :=  REPLACE(vEDIT_RESULT, Chr(13) || Chr(10), ' ');
                vEDIT_RESULT  :=  '"' || vEDIT_RESULT ||  '"';
            END;
          ELSE
            vEDIT_RESULT  :=  REPLACE(I_EDIT_STRING,'"', '""');
            vEDIT_RESULT  :=  REPLACE(vEDIT_RESULT, Chr(13) || Chr(10), ' ');
            vEDIT_RESULT  :=  '"' || vEDIT_RESULT ||  '"';
          END IF;
        ELSIF I_EDIT_TYPE ='2' THEN
          vEDIT_RESULT  :=  REPLACE(I_EDIT_STRING,'"', '""');
          vEDIT_RESULT  :=  '"' || vEDIT_RESULT ||  '"';
        END IF;
        RETURN vEDIT_RESULT;
    EXCEPTION
        WHEN OTHERS THEN
            vERR_MSG	:= '発生場所：COMMON_COVER_PKG F_CSV_EDIT_STRING';
            vERR_MSG	:= vERR_MSG || 'エラー内容：' || SUBSTRB(SQLERRM, 1,255);
            RAISE;
    END F_CSV_EDIT_STRING;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/ 
/*CHECK DATE*/
    FUNCTION CHECK_DATE (
          I_STR IN VARCHAR2
          ,I_FORMAT IN VARCHAR2
        )RETURN NUMBER AS
        I_DATE DATE;
      BEGIN
        I_DATE := TO_DATE(I_STR, I_FORMAT);
        RETURN 1;
      EXCEPTION
        WHEN OTHERS THEN
          RETURN 0;
      END CHECK_DATE;
/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/ 
    FUNCTION GetString (Source_string    IN VARCHAR2,
                          Field_position   IN NUMBER,
                          UnTerminated     IN BOOLEAN DEFAULT FALSE,
                          Delimiter        IN VARCHAR2 DEFAULT ',')
          RETURN VARCHAR2
      IS
          iPtrEnd           PLS_INTEGER := 0;
          iPtrStart         PLS_INTEGER := 0;
          vcSourceStrCopy   VARCHAR2 (2000) := Source_string;
      BEGIN
          IF UnTerminated
          THEN
            vcSourceStrCopy := vcSourceStrCopy || Delimiter;
          END IF;

          IF Field_Position > 1
          THEN
            iPtrStart :=
                INSTR (vcSourceStrCopy,
                      Delimiter,
                      1,
                      Field_Position - 1)
                + LENGTH (Delimiter);
          ELSE
            iPtrStart := 1;
          END IF;

          iPtrEnd :=
            INSTR (vcSourceStrCopy,
                    Delimiter,
                    1,
                    Field_Position);
          RETURN SUBSTR (vcSourceStrCopy, iPtrStart, (iPtrEnd - iPtrStart));
      END GetString; 

END;

