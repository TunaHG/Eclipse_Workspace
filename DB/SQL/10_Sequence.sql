
--시퀀스란?
-- 유일(UNIQUE)한 값을 생성해주는 오라클 객체이다. 
-- 시퀀스를 생성하면 기본키와 같이 순차적으로 증가하는 컬럼을 자동적으로 생성 할 수 있다. 
-- 보통 PRIMARY KEY 값을 생성하기 위해 사용 한다. 
-- 메모리에 Cache되었을 때 시퀀스값의 액세스 효율이 증가 한다. 
-- 시퀀스는 테이블과는 독립적으로 저장되고 생성된다.

select * from dept2;
select * from emp2;

delete from dept2;
delete from emp2;

select * from dept2;

create sequence dept_seq;
insert into dept2(deptno, dname, loc) values(dept_seq.nextval, 'EDU', 'SEOUL');

select dept_seq.currval from dual;
select dept_seq.nextval from dual;

create sequence dept_seq start with 10 increment by 10;
insert into dept2 (deptno, dname, loc) 
values ((select nvl(max(deptno), 0) + 1 from dept2), 'EDU', 'SEOUL');
select nvl(max(deptno), 0) + 10 from dept2;

