-- join
select * from DEPT;
select * from EMP;

select ename, job, sal, deptno, loc from emp; -- Error
select ename, dname, loc from emp, dept where emp.deptno = dept.deptno;

select ename, deptno, dname, loc from emp, dept where emp.deptno = dept.deptno; -- Error
select ename, e.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno;

select ename, sal, loc from emp e, dept d 
where e.deptno = d.deptno and sal > 2000 and deptno = 20;

-- ANSI join, 표준 : , => join / where => on

-- inner join
select ename, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

-- ANSI inner join
select ename, e.deptno, dname, loc
from emp e join dept d
on e.deptno = d.deptno;

select ename, e.deptno, dname, loc
from emp e inner join dept d
on e.deptno = d.deptno;

select ename, sal, loc
from emp e join dept d
on e.deptno = d.deptno
where sal > 2000 and e.deptno = 20;

-- outer join
-- null 쪽에 + 마킹
select ename, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno;

select ename, d.deptno, dname, loc
from emp e, dept d
where e.deptno(+) = d.deptno;
-- oracle에서만 돌아가는 코드

select ename, e.deptno, dname, loc
from emp e, dept d
where e.deptno = d.deptno(+);

-- ANSI outer join
-- right table이 master table이 온다.
select ename, e.deptno, dname, loc
from emp e right outer join dept d
on e.deptno = d.deptno;


-- non equi join
select * from salgrade;

-- oracle join
select ename, sal, grade
from emp, salgrade
where sal between losal and hisal;

-- ANSI join
select ename, sal, grade
from emp join salgrade
on sal between losal and hisal;


-- n개의 table join
-- oracle join
select ename, sal, dname, grade
from emp e, salgrade s, dept d
where e.deptno = d.deptno 
and sal between losal and hisal;

-- ANSI join
select ename, sal, dname, grade
from emp e join dept d on e.deptno = d.deptno
		   join salgrade on sal between losal and hisal
where sal > 1500;


-- self join
-- oracle join
select e.ename as "Employee Name", m.ename as "Manager Name"
from emp e, emp m
where e.mgr = m.empno;

select e.ename as "Employee Name", m.ename as "Manager Name"
from emp e, emp m
where e.mgr = m.empno(+);

select e.ename "Employee Name", e.sal, m.ename "Manager Name", m.sal
from emp e, emp m
where e.mgr = m.empno and e.sal >= m.sal;

-- ANSI join
select e.ename as "Employee Name", m.ename as "Manager Name"
from emp e join emp m
on e.mgr = m.empno;

select e.ename as "Employee Name", m.ename as "Manager Name"
from emp e left join emp m
on e.mgr = m.empno;

select e.ename "Employee Name", e.sal, m.ename "Manager Name", m.sal
from emp e join emp m
on e.mgr = m.empno
where e.sal >= m.sal;
