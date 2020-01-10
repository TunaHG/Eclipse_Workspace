-- after DDL create (line 46)
-- insert
insert into book (bookno, title, author, pubdate)
values(1, 'java', '홍길동', sysdate);

commit;

select * from book;

insert into book (bookno, title, author, pubdate)
values(2, 'sql', null, null);

rollback;

insert into book (bookno, title, author, pubdate)
values(2, 'sql', null, '2019/01/01');

insert into book (bookno, title, author, pubdate)
values(3, 'spring', '고길동', to_date('01/01/2019', 'mm/dd/yyyy'));

commit;

insert into book (bookno, title) values(4, 'html5');
insert into book values(1, 'java', '홍길동', sysdate);

-- delete
delete from book;
rollback;

delete from book where bookno=4;
commit;

delete from book where bookno=1;
rollback;

-- update
update book set title='~~~~~';
rollback;

update book set title='~~~~~~' where bookno=1;
rollback;

update book set title='~~~~~~', author='kim' where bookno=1;
commit;

update book set title='html' where title='~~~~~~';

-- after DDL ALTER add (line 51)
update book set price=0;
commit;

update book set price=99.99;
commit;

update book set price=null;
commit;

-- after DDL ALTER modify (line 53)
update book set price=99.99;
commit;


-- after DDL create emp2 table (line 69, 70)
insert into dept (deptno, dname, loc) values (10, 'EDU', 'SEOUL'); -- X Error 00001
insert into dept2 (deptno, dname, loc) values (10, 'EDU', 'SEOUL'); -- O

insert into dept (deptno, dname, loc) values (50, 'EDU', 'SEOUL'); -- O
insert into dept2 (deptno, dname, loc) values (50, 'EDU', 'SEOUL'); -- O
commit;

insert into dept (deptno, dname, loc) values (50, 'EDU', 'SEOUL'); -- X Error 00001
insert into dept2 (deptno, dname, loc) values (50, 'EDU', 'SEOUL'); -- O

insert into dept (deptno, dname, loc) values (null, 'EDU', 'SEOUL'); -- X Error 01400
insert into dept2 (deptno, dname, loc) values (null, 'EDU', 'SEOUL'); -- O
rollback;

insert into emp(empno, ename, sal, deptno) values (999, '홍', 2100, 90); -- X Error 02291
insert into emp2(empno, ename, sal, deptno) values (999, '홍', 2100, 90); -- O
commit;

insert into emp(empno, ename, sal, deptno) values (999, '홍', 2100, 50); -- O

select ename, dname, loc
from emp e, dept d
where e.deptno = d.deptno and ename = '홍';

select ename, dname, loc
from emp2 e, dept d
where e.deptno = d.deptno and ename = '홍';


-- after 제약조건 (DDL line 85)
insert into book (bookno, title, author, price) values (1, 'java', '홍길동', 900);
rollback;

insert into book (bookno, title, author, price) values (2, 'sql', '홍길동', 900);
commit;
select * from book;

