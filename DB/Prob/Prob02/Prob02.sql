col employee_id for 999;
col first_name for a12;
col last_name for a12;
col email for a12;
col phone_number for a12;
col hire_date for a8;
col job_id for a12;
col salary for 99999;
col commission_pct 99.99;
col manager_id for 999;

-- Q1.
-- Oracle Join
select e.employee_id 사원번호, e.first_name 사원이름, department_name 부서명, m.first_name 매니저이름
from employees e, departments d, employees m
where e.department_id = d.department_id(+) and e.manager_id = m.employee_id(+)
order by e.employee_id;
-- ANSI Join
select e.employee_id, e.first_name, d.department_name, m.first_name 
from EMPLOYEES e left join departments d on e.department_id = d.department_id
				 left join employees m on e.manager_id = m.employee_id
order by e.employee_id;
				 
-- Q2.
-- Oracle Join
select e.last_name, e.salary
from employees e, employees m
where e.manager_id = m.employee_id and e.salary > m.salary;
-- ANSI Join
select e.last_name, e.salary
from employees e join employees m
on e.manager_id = m.employee_id
where e.salary > m.salary;

-- Q3.
-- Oracle Join
select first_name, last_name, salary
from EMPLOYEES e, jobs j
where e.job_id = j.job_id and job_title = 'Sales Representative' and salary between 9000 and 10000;
-- ANSI Join
select first_name, last_name, salary
from EMPLOYEES e join jobs j
on e.job_id = j.job_id
where job_title = 'Sales Representative' and salary between 9000 and 10000;

-- Q4.
-- Oracle Join
select e.employee_id, e.last_name, e.hire_date
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date < m.hire_date;
-- ANSI Join
select e.employee_id, e.last_name, e.hire_date
from employees e join employees m
on e.manager_id = m.employee_id
where e.hire_date < m.hire_date;

-- Q5.
-- Oracle Join
select e.first_name, e.hire_date, m.employee_id, m.first_name
from employees e, employees m
where e.manager_id(+) = m.employee_id and e.hire_date like '08%';
-- ANSI Join
select e.first_name, e.hire_date, m.employee_id, m.first_name
from employees e right join employees m
on e.manager_id = m.employee_id
where e.hire_date like '08%';

-- Q6.
-- Oracle Join
select first_name, salary, department_name
from employees e, departments d
where e.department_id = d.department_id and department_name = 'Sales';
-- ANSI Join
select first_name, salary, department_name
from employees e join departments d
on e.department_id = d.department_id
where department_name = 'Sales';

-- Q7.
select to_char(hire_date, 'mm') as "월", count(employee_id) as "입사자수"
from employees
group by to_char(hire_date, 'mm')
order by to_char(hire_date, 'mm');