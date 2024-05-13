drop table if exists board cascade;
/* 만약에 'board' 테이블이 있다면 삭제해라. */
/* 테이블을 만들때는 drop이 우선이 되어야한다 (민경태쌤 왈) */

create table board(
	num int primary key auto_increment,
	title varchar(50) not null,
	content text not null,
	upload_date datetime default now()
);

