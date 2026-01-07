-- PROCEDURE 
/*
    MyBatis
    => 리턴형이 없다 
    => CREATE OR REPLACE PROCEDURE proc_name(
         매개변수 ...
       )
       IS 
        지역변수 
       BEGIN
         기능 처리 
       END 
       /
*/
-- 목록 출력 / 댓글  => 트리거 
-- 일반 JDBC : CURSOR (ResultSet)
-- MyBatis : Map
CREATE OR REPLACE PROCEDURE foodListData(
   pStart NUMBER,
   pResult OUT SYS_REFCURSOR
)
IS
BEGIN
   OPEN pResult FOR
     SELECT fno,poster,name
     FROM menupan_food
     ORDER BY fno ASC
     OFFSET pStart ROWS FETCH NEXT 12 ROWS ONLY;
END;
/
/*
   FNO              NOT NULL NUMBER
 NAME               NOT NULL VARCHAR2(200)
 TYPE               NOT NULL VARCHAR2(100)
 PHONE              VARCHAR2(20)
 ADDRESS            NOT NULL VARCHAR2(500)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 PRICE                                              VARCHAR2(50)
 TIME                                               VARCHAR2(100)
 PARKING                                            VARCHAR2(100)
 POSTER                                    NOT NULL VARCHAR2(260)
 IMAGES                                             CLOB
 CONTENT                                            CLOB
 HIT                                                NUMBER
 JJIMCOUNT                                          NUMBER
 LIKECOUNT                                          NUMBER
 REPLYCOUNT       
 NUMBER
 
  C언어 => Java가 C언어 형식으로 변경
          ------------------------
          printf() / 람다 ->
                     단순화 (간결하게)
  Runable r=new Runable(){
     public void run(){
       처리 
     }
     default / static 
  }
  
  Runable r=()->{처리} => security 
*/
CREATE OR REPLACE PROCEDURE foodDetailData(
   pNo NUMBER,
   pResult OUT SYS_REFCURSOR
)
IS
BEGIN
  OPEN pResult FOR 
    SELECT * FROM menupan_food
    WHERE fno=pNo;
END;
/






