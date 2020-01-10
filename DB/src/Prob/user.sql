
-- users 테이블 생성
drop table users;
create table users(
	id varchar2(20) primary key,
	pw varchar2(20) not null,
	name varchar2(20),
	role varchar2(20) default 'user'
);

-- 회원 등록
insert into users values ('asdf0185', '1q2w3e001', '김하균', 'admin');
insert into users (id, pw, name) values ('asdf0001', '1q2w3e002', '김현호');
insert into users (id, pw, name) values ('asdf0002', '1q2w3e003', '최시영');
insert into users (id, pw, name) values ('asdf0003', '1q2w3e004', '심재영');
insert into users (id, pw, name) values ('asdf0004', '1q2w3e005', '이건하');
select * from users;

-- 로그인
-- id와 pw는 결국 input받는 값.
select * from users where id=1 and pw='1q2w3e001'; -- O
select * from users where id=2 and pw='1q2w3e001'; -- X