

/* members���̺� ���� */
CREATE TABLE members(
memberNum NUMBER(6) PRIMARY KEY,
memberId VARCHAR2(50) UNIQUE,
memberPassword VARCHAR2(100) NOT NULL,
memberName VARCHAR2(100) NOT NULL,
memberEmail VARCHAR2(200),
memberPhone VARCHAR2(13) NOT NULL);

/* members ���� ������ */
INSERT INTO members
VALUES(10001,'admin','1234','������','admin@green.com','010-1234-5678');
INSERT INTO members
VALUES(10002,'park','1234','�ڹ���','park@green.com','010-1234-5679');
INSERT INTO members
VALUES(10003,'kim','1234','�輭��','kim@green.com','010-1234-4680');
INSERT INTO members
VALUES(10004,'lee','1234','�̼���','lee@green.com','010-1234-5681');
INSERT INTO members
VALUES(10005,'jung','1234','������','jung@green.com','010-1234-5682');
INSERT INTO members
VALUES(10006,'choi','1234','�ֿ���','choi@green.com','010-1234-5683');
INSERT INTO members
VALUES(10007,'jo','1234','������','jo@green.com','010-1234-5684');



/* boards���̺� ���� */
CREATE TABLE boards(
qnaBoardNum NUMBER(6) PRIMARY KEY,
memberNum NUMBER(6) NOT NULL,
qnaBoardTitle VARCHAR2(1000) NOT NULL,
qnaBoardContent VARCHAR2(4000),
qnaBoardRegdate DATE DEFAULT SYSDATE,
qnaBoardCount NUMBER(10) DEFAULT 0,
CONSTRAINT FK_BOARDS FOREIGN KEY(memberNum)
REFERENCES members(memberNum)
);



/* boards������ */
CREATE SEQUENCE boards_seq
START WITH 101
NOCACHE;

/* boards���� ������ */
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10002,'������ �ֽ��ϴ�.','�������ݿ��� � ���� �ֳ���?','2020-09-15',5);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10003,'DB ������ �ֽ��ϴ�','�ε����� ����� ������ �����ΰ���?','2020-10-13',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10007,'�������� �����ؼ� ������ �ֽ��ϴ�.','�������� ������ ��Ʈ�� ���̰� �����ΰ���?','2020-10-21',6);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10005,'���� �ñ��� �� �־��','������̼� ���� ������ ��� �ϳ���?','2020-11-03',3);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10004,'HTML�� �ñ��� �� �ֽ��ϴ�.','meta�±״� �����̸� � ������ ��� �ֳ���?','2020-11-16',7);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10003,'DB ���� ������ �ֽ��ϴ�.','���ΰ� ���� ������ � ��쿡 ����ϳ���?','2020-11-27',5);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10004,'CSS�� �������','�ؽ�Ʈ�� ���� ��� ������ �ϰ� ������ ��� �ϳ���?','2020-12-05',6);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10006,'�ڹ� ��ũ��Ʈ �����̿�','selectQuery�� getElementById�� ���̿� � ��쿡 ����ϴ� �� �ñ��մϴ�.','2020-12-13',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10002,'������ �ֽ��ϴ�.','URL�� URI�� ���̴� �����ΰ���?','2021-01-07',7);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10005,'JSP���� ������ �̵��� �����ؼ� ������ �ֽ��ϴ�.','������� �����̷�Ʈ�� ���̿� � ��쿡 ���Ǵ��� �˷��ּ���.','2021-01-18',3);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10006,'DOM�� �����ؼ� ������ �־��','���� ���� ��带 ȭ�鿡 ����� ������ ��� ���� �־�� �ϳ���?','2021-02-20',4);
INSERT INTO boards
VALUES(boards_seq.NEXTVAL,10007,'������ �������','������ ������ �����̰� ��� ����ϴ� �ǰ���?','2021-03-02',5);


/* comments���̺� ���� */
CREATE TABLE comments(
commentNum NUMBER(6) PRIMARY KEY,
qnaBoardNum NUMBER(6) NOT NULL,
commentContent VARCHAR2(4000),
commentRegdate DATE DEFAULT SYSDATE,
CONSTRAINT FK_COMMENTS FOREIGN KEY(qnaBoardNum)
REFERENCES boards(qnaBoardNum)
);



/* comments������ */
CREATE SEQUENCE comments_seq
START WITH 1
NOCACHE;

/* comments���� ������ */
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,101,'�������ݿ��� HTTP,HTTPS���� �ֽ��ϴ�.','2020-09-16');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,102,'���� ������ �˻��� ���ؼ� �ʿ��մϴ�.','2020-10-14');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,105,'meta �±״� ȭ�鿡 ������� �ʴ� ������ �⺻������ �ۼ��մϴ�.','2020-11-17');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,104,'web.xml�� �̿��մϴ�.','2020-11-17');
INSERT INTO comments
VALUES(comments_seq.NEXTVAL,103,'������ ������ ���� ����ȭ �� ���� ������ ��Ʈ�Դϴ�.','2020-11-17');


DROP TABLE boards;
DROP TABLE members;
DROP TABLE comments;
DROP SEQUENCE comments_seq;
DROP SEQUENCE boards_seq;
DROP SEQUENCE members_seq;