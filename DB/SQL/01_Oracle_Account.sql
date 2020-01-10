
sqlplus system/1234

alter user hr identified by hr account unlock;

conn hr/hr
sqlplus hr/hr

select * from tab;
select * from employees;


// 테이블 생성
create TABLESPACE mc
datafile 'C:\oraclexe\app\oracle\oradata\XE\mc.dbf'
size 10M
autoextend on next 1M maxsize UNLIMITED;

drop TABLESPACE mc INCLUDING CONTENTS AND Datafiles;


// 계정 생성
create user test01 identified by 1234
default TABLESPACE mc;

// 권한 부여
grant connect, resource, dba to test01;

// 권한 제거
revoke dba from test01;
revoke connect from test01;

// 계정 제거
drop user test01 cascade;


// SCOTT/TIGER 계정 생성
create user SCOTT identified by TIGER
default TABLESPACE mc;

@C:\lib\scott.sql;


// Setting
set linesize 300;
set pagesize 20;

col ename for a12;