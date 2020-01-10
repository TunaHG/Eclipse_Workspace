conn SCOTT/TIGER

select * from emp;
select * from dept;
select * from salgrade;

desc emp;

select ename, sal, deptno from emp;
select ename, hiredate from emp;
select deptno, dname from dept;

-- as
select distinct job from emp;
select ename, sal, sal*12 from emp;
select ename, sal, sal*12 as "연봉" from emp;

-- nvl
select ename, job, sal, comm from emp;
select ename, job, sal, sal+comm, nvl(comm, -1) from emp;
select ename, job, sal, comm, sal+nvl(comm, 0) as "실급여" from emp;

select empno, ename, nvl(mgr, '<<CEO>>') from emp; -- Error
select empno, ename, nvl(to_char(mgr), '<<CEO>>') as "매니저코드" from emp;

-- ||
select ename || ' ' || job from emp;

-- dual
select 20*20*4 from dual;
select sysdate from dual;
select user from dual;

-- where
select ename, job, deptno from emp where deptno = 10;
select ename, job, deptno from emp where job = 'manager'; -- no row selected (lower case)
select ename, job, deptno from emp where job = 'MANAGER';
select ename, job, deptno from emp where upper(job) = upper('manager');
select ename, job, deptno from emp where lower(job) = lower('manager');

-- Comparation Operator
select ename, hiredate from emp where hiredate > '82/01/01';
select ename, hiredate from emp where hiredate != '81/05/01';
select ename, hiredate from emp where hiredate <> '81/05/01'; -- not equal

-- between and
select ename, sal from emp where sal >= 2450 and sal <= 3000;
select ename, sal from emp where sal between 2450 and 3000;
select ename, sal from emp where sal between 5000 and 3000;

-- in
select ename, job, deptno from emp where deptno = 10 or deptno = 20;
select ename, job, deptno from emp where deptno in(10, 20);
select * from dept where (deptno, loc) in((20, 'DALLAS'), (30, 'CHICAGO'));

-- like
select * from emp where ename = 'A';
select * from emp where ename like 'A%';
select * from emp where upper(ename) like '%A%';

select * from emp where hiredate like '81%';

-- where null
select * from emp where mgr is null;
select * from emp where mgr is not null;
select * from emp where comm is null;
select * from emp where comm is not null;

select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp where sal + nvl(comm, 0) >= 2000;

conn hr/hr
select * from employees;

conn SCOTT/TIGER

-- 단일행 함수
select dname, lower(dname), loc, lower(loc) from dept;
select round(44.55), round(44.55, 1), trunc(44.55) from dual;

select sal, trunc(sal * 0.03) as "TAX" from emp

select ename, hiredate, substr(hiredate, 4, 2) as "month" from emp;
select ename, hiredate from emp where substr(hiredate, 4, 2) = '12';


select sysdate, sysdate + 30 from dual;

select sysdate, substr(sysdate, 4, 2) from dual;
select sysdate, to_char(sysdate, 'YY') from dual;
select sysdate, to_char(sysdate, 'YYYY') from dual;
select sysdate, to_char(sysdate, 'day') from dual;
select sysdate, to_char(sysdate, 'mm') from dual;
select sysdate, to_char(sysdate, 'dd') from dual;

-- emp에서 사원 들의 사원명, 입사월, 요일 정보를 출력하세요.
select ename, hiredate, to_char(hiredate, 'day') as "요일" from emp order by to_char(hiredate, 'mm');

select sysdate, to_date('2019/12/24') from dual;
select sysdate, to_date('2019-12-24') from dual;
select sysdate, to_date('2019 12 24') from dual;

select sysdate, to_date('12/24/19', 'mm/dd/yy') from dual;

-- decode function
select ename, sal, deptno, decode(deptno, 10, sal*1.2, 20, sal*0.7, sal) from emp order by deptno;
