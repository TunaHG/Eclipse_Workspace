-- Prob03

-- users 테이블 생성
drop table users;
create table users(
	id number(6) primary key,
	pw varchar2(20) not null,
	name varchar2(20),
	role varchar2(20) default 'user'
);

-- board 테이블 생성
drop table board;
create table board(
	seq number(6) primary key,
	title varchar2(20) not null,
	content varchar2(100),
	regdate date default sysdate,
	cnt number(6),
	id number(6) 
);

alter table board add constraint board_fk_users foreign key(id) references users;

-- 회원 등록
insert into users values (1, '1q2w3e001', '김하균', 'admin');
insert into users (id, pw, name) values (2, '1q2w3e002', '김현호');
insert into users (id, pw, name) values (3, '1q2w3e003', '최시영');
insert into users (id, pw, name) values (4, '1q2w3e004', '심재영');
insert into users (id, pw, name) values (5, '1q2w3e005', '이건하');
select * from users;

-- 회원 정보 수정
update users set pw='1q2w3e4r' where name='김현호';
select * from users;

-- 로그인
-- id와 pw는 결국 input받는 값.
select * from users where id=1 and pw='1q2w3e001'; -- O
select * from users where id=2 and pw='1q2w3e001'; -- X

-- 게시판 글 등록
insert into board values (1, '첫 글', '게시판 첫 글이네요', '2019/12/20', 0, 1);
insert into board values (2, '뭐임?', '이 게시판 언제 생긴거임?', '2019/12/21', 0, 3);
insert into board values (3, '이 문제 보셈', '로그인 어떻게함?', '2019/12/22', 0, 2);
insert into board values (4, '똥글', 'ㅈㄱㄴ', '2019/12/23', 0, 5);
insert into board values (5, '이글 미래', '곧 삭제됨', '2019/12/24', 0, 1);
insert into board values (6, '실화?', '오늘 크리스마스임', '2019/12/25', 0, 4);
insert into board (seq, title, content, cnt, id) values (7, '끝', '그만 만들자..', 0, 1);
select * from board;

-- 글 수정
update board set content='똥글 각' where seq=4;
update board set regdate='2019/10/20' where seq=1;
update board set regdate='2019/11/01' where seq=2;
update board set regdate='2019/11/09' where seq=3;
update board set regdate='2019/11/14' where seq=5;


-- 게시판 글 삭제
delete from board where seq=4;
delete from board where title='똥글';

-- 전체 등록글 수
select count(*) "등록글 수" from board;

-- 사용자별 등록글 수
select name, count(*) "등록글 수" from board b join users u on b.id = u.id group by u.name;

-- 월별 게시글 수
select to_char(regdate, 'mm') "등록 월", count(*) "등록글 수" from board group by to_char(regdate, 'mm');

-- 사용자별 게시글 검색
select name, title, content from board b join users u on b.id = u.id where name='김하균';
select name, title, content from board b join users u on b.id = u.id where name='김현호';
select name, title, content from board b join users u on b.id = u.id where name='최시영';
select name, title, content from board b join users u on b.id = u.id where name='심재영';
select name, title, content from board b join users u on b.id = u.id where name='이건하';

-- 제목으로 게시글 검색
select * from board where title like '%글%';
select * from board where title like '%?%';
select * from board where title like '%이%';