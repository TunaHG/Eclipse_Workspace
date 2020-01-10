-- Order by
select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp order by sal;
select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp order by sal desc;
select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp order by sal desc, comm;

select ename from emp order by sal;

select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp where comm is not null order by sal asc, comm desc;
select ename, sal, comm, sal + nvl(comm, 0) as "총급여" from emp where sal + nvl(comm, 0) >= 2000 order by 3;
