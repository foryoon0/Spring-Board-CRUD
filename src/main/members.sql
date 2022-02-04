CREATE TABLE members(
memberNum number(6) primary key NOT NULL,
memberId varchar2(50) unique NOT NULL,
memberPassword varchar2(100) NOT NULL,
memberName varchar2(100) NOT NULL,
memberEmail varchar2(200),
memberPhone varchar2(13) NOT NULL
);

INSERT INTO members VALUES(10001, 'admin','1234','������','admin@green.com','010-1234-5678');
INSERT INTO members VALUES(10002, 'park','1234','�ڹ���','park@green.com','010-1234-5679');
INSERT INTO members VALUES(10003, 'kim','1234','�輭��','kim@green.com','010-1234-5680');
INSERT INTO members VALUES(10004, 'lee','1234','�̼���','lee@green.com','010-1234-5681');
INSERT INTO members VALUES(10005, 'jung','1234','������','jung@green.com','010-1234-5682');
INSERT INTO members VALUES(10006, 'choi','1234','�ֿ���','choi@green.com','010-1234-5683');
INSERT INTO members VALUES(10007, 'jo','1234','������','jo@green.com','010-1234-5684');

SELECT * FROM members;

DROP TABLE members;
DROP TABLE boards;
DROP TABLE Comments;


CREATE TABLE boards (
     qnaBoardNum number(6) NOT NULL PRIMARY KEY,
     memberNum number(6) NOT NULL,
     qnaBoardTitle varchar2(1000) NOT NULL,
     qnaBoardContent varchar2(4000),
     qnaBoardRegdate date default sysdate,
     qnaBoardCount number(10) default 0
     CONSTRAINT FK_boards FOREIGN KEY(memberNum)
    REFERENCES members(memberNum)
    );

DROP TABLE boards;
     
INSERT INTO boards VALUES(101, 10002,'������ �ֽ��ϴ�','�������ݿ��� � ���� �ֳ���?', '2020-09-15', 5);
INSERT INTO boards VALUES(102, 10003,'DB ������ �ֽ��ϴ�','�ε��� �ָ��峪��','2020-10-13', 4);
INSERT INTO boards VALUES(103, 10007,'�������� �����ؼ� ������ �ֽ��ϴ�.','�������� ������ ��Ʈ�� ���̴¹��ϱ�?', '2020-10-21', 6);
INSERT INTO boards VALUES(104, 10005,'���� �ñ��Ѱ� �־��','������̼� ���� ������ ��� �ϳ���', '2020-11-03', 3);
INSERT INTO boards VALUES(105, 10004,'HTML�� �ñ��Ѱ� �ֽ��ϴ�.','META��ũ�� ���� � �����ֳ���', '2020-11-16', 7);
INSERT INTO boards VALUES(106, 10003,'DB ���� ������ �ֽ��ϴ�.','���ΰ� ���������� � ��쿡 ����ϳ���', '2020-11-27', 5);
INSERT INTO boards VALUES(107, 10004,'CSS�� �������','�ؽ�Ʈ�� ���� ��� ���� �ϰ������ �������', '2020-12-05', 6);
INSERT INTO boards VALUES(108, 10006,'�ڹٽ�ũ��Ʈ ����!','��¼����¼�� �ڹٽ�ũ��Ʈ', '2020-12-13', 4);
INSERT INTO boards VALUES(109, 10002,'��������','URL �� URI�� ���̰� ����?', '2021-01-07', 7);
INSERT INTO boards VALUES(110, 10005,'JSP���� ������ �̵����� �����־��','������� �����̷�Ʈ�� ���� � ��쿡 ����ϴ���', '2021-01-18', 3);
INSERT INTO boards VALUES(111, 10006,'DOM ��������!','���� ���� ��带 ȭ�鿡 ����� ������ ��� �����ֳ���', '2021-02-20', 4);
INSERT INTO boards VALUES(112, 10007,'������ �ʹ� �������','������ ������ �����̰� ��� ����ϴ°�?', '2021-03-02', 5);

SELECT * FROM boards;

CREATE TABLE Comments(
    commentNum number(6) NOT NULL PRIMARY KEY,
    quaBoarNum number(6) NOT NULL,
    commentContent varchar2(4000) NOT NULL,
    commnetRegdate date default sysdate );
    
INSERT INTO Comments VALUES(1,101,'�������ݿ��� HTTP,HTTPS���� �ֽ��ϴ�','2020-09-16');
INSERT INTO Comments VALUES(2,102,'���� ������ �˻��� ���ؼ� �ʿ��մϴ�.','2020-10-14');
INSERT INTO Comments VALUES(3,105,'META �±״� ȭ�鿡 ������� �ʴ� ������ �⺻ ������ �ۼ��մϴ�.','2020-11-17');
INSERT INTO Comments VALUES(4,104,'WEB.XML�� �̿��մϴ�.','2020-11-17');
INSERT INTO Comments VALUES(5,103,'������ ������ ���� ����ȭ �� ���� ������ ��Ʈ�Դϴ�.','2020-11-17');

SELECT * FROM Comments;


/** ���� 1 **/



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

SELECT * FROM members;

DROP TABLE boards;

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

DROP SEQUENCE boards_seq;

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
VALUES(boards_seq.NEXTVAL,10007,'������ �������','������ ������ �����̰� ��� ����ϴ� �ǰ���?','2020-03-02',5);

SELECT * FROM boards;



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

SELECT * FROM comments;

