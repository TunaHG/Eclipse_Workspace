
--뷰란?
-- 뷰는 하나의 가상 테이블이라 생각 하면 된다. 
-- 뷰는 실제 데이터가 저장 되는 것은 아니지만 뷰를 통해 데이터를 관리 할수 있다. 
-- 뷰는 복잡한 Query를 통해 얻을 수 있는 결과를 간단한 Query로 얻을 수 있게 한다. 
-- 한 개의 뷰로 여러 테이블에 대한 데이터를 검색 할 수 있다. 
-- 특정 평가 기준에 따른 사용자 별로 다른 데이터를 액세스할 수 있도록 한다. 

-- 각 부서에서 최대 급여를 받는 사원의 목록 
select * from emp 
where (deptno, sal) in (select deptno, max(sal) from emp group by deptno)
order by deptno;

create or replace view max_dept
as
select * from emp 
where (deptno, sal) in (select deptno, max(sal) from emp group by deptno)
order by deptno;

select * from max_dept;
select * from max_dept where deptno=10;

create or replace view page_emp
as
select *
from (
select rownum row#, ename, job, sal
from (select * from emp order by sal desc)
);

select * from page_emp;

select * from page_emp
where row# between 6 and 10;

