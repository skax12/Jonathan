DROP SEQUENCE TESTSQ;
DROP TABLE TEST;
DROP SEQUENCE GROUPSQ;

CREATE SEQUENCE TESTSQ;
CREATE SEQUENCE GROUPSQ;

CREATE TABLE TEST(
NUM NUMBER PRIMARY KEY,
GROUPNO NUMBER NOT NULL,
GROUPSQ NUMBER NOT NULL,
TITLETAB NUMBER NOT NULL,
NAME VARCHAR2(50) NOT NULL,
TITLE VARCHAR2(2000) NOT NULL,
CONTENT VARCHAR2(4000) NOT NULL,
DDATE DATE NOT NULL
);
SELECT * FROM TEST;

insert into test values(testsq.nextval, groupsq.nextval,1,0,'dd','응','아니야',sysdate);
SELECT * FROM(
SELECT ROWNUM AS RW, A.* FROM(SELECT * FROM TEST ORDER BY GROUPNO DESC,GROUPSQ)A)AA;