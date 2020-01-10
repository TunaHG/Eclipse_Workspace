-- GROUP BY
select ename, round(sal) from emp;
select ename, avg(sal) from emp; -- Error 00937

select round(avg(sal))||'원' 전체평균급여 from emp;
select deptno, round(avg(sal)) from emp group by deptno;
select ename, round(avg(sal)) from emp group by deptno; -- Error 00979

select avg(sal), count(*), min(sal), max(sal), count(mgr) from emp;
select avg(sal), count(*), min(sal), max(sal), count(mgr) from emp where deptno=10;
select avg(sal), count(*), min(sal), max(sal), count(mgr) from emp where deptno=40;

select avg(sal), count(*), min(sal), max(sal), count(mgr) from emp group by deptno;
select deptno, avg(sal), count(*), min(sal), max(sal), count(mgr) from emp group by deptno;

select dname, avg(sal), count(*), min(sal), max(sal), count(mgr) 
from emp join dept on emp.deptno = dept.deptno group by dept.dname;

select e.deptno, dname, avg(sal), count(*), min(sal), max(sal)
from emp e, dept d
where e.deptno = d.deptno
group by e.deptno, dname;

select e.deptno, dname, round(avg(sal)) AverageSalary
from emp e, dept d
where e.deptno = d.deptno
group by e.deptno, dname
having avg(sal) > 2000;