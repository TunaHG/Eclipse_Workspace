-- SubQuery
select sal from emp where ename='FORD';
select * from emp where sal > 3000;
select * from emp where sal > (select sal from emp where ename='FORD');

select * from emp where sal > (select avg(sal) from emp);
select * from emp where sal = (select min(sal) from emp);

select ename, sal, (select avg(sal) from emp) from emp;

select * from emp where sal = (select max(sal) from emp group by deptno); -- Error 01427
select * from emp where sal in (select max(sal) from emp group by deptno);

select * from emp
where (deptno, sal) in (select deptno, max(sal) from emp group by deptno)
order by deptno;

-- rownum
select rownum, ename, job, sal from emp;
select rownum, ename, job, sal from emp order by sal;

select rownum, ename, job, sal from (select * from emp order by sal); -- from Subquery

select rownum, ename, job, sal
from (select * from emp order by sal desc)
where rownum < 4;

select rownum, ename, job, sal
from (select * from emp order by sal desc)
where rownum between 1 and 5;

select rownum, ename, job, sal
from (select * from emp order by sal desc)
where rownum between 6 and 10; -- Nothing

select *
from (
select rownum row#, ename, job, sal
from (select * from emp order by sal desc)
)
where row# between 6 and 10;