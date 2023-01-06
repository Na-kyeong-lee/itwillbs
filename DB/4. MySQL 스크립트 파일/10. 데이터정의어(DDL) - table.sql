-- [SQL문법] 9. 데이터정의어(DDL) - Table
use hr;

-- <SQL구문 유형>
-- DQL(데이터질의어) : select
-- DML(데이터조작어) : insert, update, delete
-- DDL(데이터정의어) : create, alter, drop, truncate
-- DCL(데이터제어어) : grant, revoke

-- DDL(데이터정의어) 구문이란?
-- object(객체)를 생성, 수정, 삭제, 절단하는 명령어
-- 작업단위 : object(객체)
-- object 종류 : 테이블, 뷰, 인덱스 등등

-- 9-1. create table : 테이블 생성
-- 테이블 생성 시 기본 정보 : 테이블명, 컬럼명, 데이터타입
-- 데이터타입 정리
-- 1) 숫자 - 정수형 : int, bigint
--        - 실수형 : double(p,s), float(s)
-- 2) 문자 - varchar(가변), char(고정)
-- 3) 날짜 - date(년월일), datetime(년월일시분초)
-- 테이블 생성 시 옵션 : default값, 제약조건
-- [문법] create table 테이블명
--      (컬럼명1 데이터타입,
--       컬럼명2 데이터타입 default 기본값,
--       컬럼명3 데이터타입 제약조건);

use shopdb;
-- default값이 포함된 테이블 생성 예제
create table dept
(deptno int,
 dname varchar(14),
 loc varchar(13),
 create_date datetime default now());

desc dept;

-- default값이 선언된 테이블에 데이터 삽입 예제
insert into dept
values (10, 'AAA', 'A100', '2022-09-20 11:30');
-- default값이 선언된 컬럼은 생략 시 default값 삽입됨.
insert into dept(deptno, dname, loc)
values (20, 'BBB', 'B100');   

insert into dept(deptno, dname)
values (30, 'CCC');

-- default값이 선언된 컬럼에 default값을 명시적으로 삽입하는 방법
insert into dept
values (40, 'DDD', 'D100', default);

select *
from dept;

-- 제약조건 : nn, uk, pk, fk, ck
-- [제약조건1] not null
-- not null 제약조건이 선언된 컬럼에는 null값이 삽입/수정되는 것을 막아줌.
-- 테이블의 필수 컬럼에 많이 선언함.
-- (ex) 회원번호, 사번, 이름, 주민번호, 전화번호 등등
create table test1
(id int not null, 
 name varchar(30) not null, 
 jumin varchar(13) not null, 
 job varchar(20), 
 email varchar(20), 
 phone varchar(20) not null, 
 start_date date);
 
desc test1;

-- [제약조건2] unique
-- unique 제약조건이 선언된 컬럼에는 중복된 값이 들어오는 것을 막아줌.
-- 고유한 값만 들어와야하는 컬럼에 사용됨.
-- (ex) 주민번호, 전화번호, 메일주소, 계좌번호 등등
create table test2
(id int not null unique, 
 name varchar(30) not null, 
 jumin varchar(13) not null unique, 
 job varchar(20), 
 email varchar(20) unique, 
 phone varchar(20) not null unique, 
 start_date date);

desc test2;

-- [제약조건3] primary key(기본키)
-- not null + unique의 성격을 모두 가지고 있는 제약조건
-- primary key 제약조건이 선언된 컬럼에는 null값, 중복값 모두 허용하지 않음.
-- 단, 테이블당 한번만 선언할 수 있음!!!
-- (ex) "학생" 테이블
-- | 학번 | 이름 | 학년 | 주민번호 | 전화번호 | 메일 |
-- ------------------------------------------
--   pk    nn    nn     nn       nn      uk
--                      uk       uk
-- => not null + unique의 성격을 가져야하는 학번, 주민번호, 전화번호 컬럼 중
--    개인정보가 아닌 컬럼을 primary key(기본키, 대표컬럼) 제약조건으로 변경하는
--    설계를 많이 사용함.
create table test3
(id int primary key, 
 name varchar(30) not null, 
 jumin varchar(13) not null unique, 
 job varchar(20), 
 email varchar(20) unique, 
 phone varchar(20) not null unique, 
 start_date date); 
 
desc test3;

-- [제약조건4] foreign key(외래키)
-- 자기 자신 테이블이나 다른 테이블의 특정 컬럼(PK, UK)을 참조하는 제약조건
-- FK 제약조건이 선언된 컬럼 -> 자식 컬럼
-- FK 제약조건이 참조하는 컬럼 -> 부모 컬럼
-- 자식 컬럼(FK)에는 부모 컬럼에 있는 값만 삽입/수정할 수 있는 제약조건
-- 단, not null 제약조건이 없다는 전제하에 null값은 허용함.
create table test4
(t_num int primary key, 
 t_id int, 
 title varchar(20) not null, 
 story varchar(100) not null, 
 foreign key(t_id) references test3(id));   -- 테이블 레벨 문법

desc test4;

-- [제약조건5] check
-- 해당 컬럼이 만족해야하는 조건을 자유자재로 지정할 수 있는 제약조건
-- (ex1) 주민번호 char(13) check (length(주민번호) = 13)
-- (ex2) 성별 varchar(10) check (성별 in ('남', '여'))
-- (ex3) 입사일 date check (입사일 >= '2000-01-01')
-- (ex4) email varchar(50) check (email like '%@%')
-- (ex5) name varchar(20) check (name is not null) (==) name varchar(20) not null
create table test5
(id int(10) primary key,
 name varchar(30) not null, 
 jumin varchar(13) not null unique check (length(jumin)=13), 
 job varchar(20), 
 email varchar(20) unique, 
 phone varchar(20) not null unique, 
 start_date date check (start_date >= '2005-01-01'));

desc test5;

-- Data Dictionary로부터 테이블 정보 조회하기
show databases;
use information_schema;
show tables;
-- test5 테이블에 선언된 제약조건 정보 조회
select *
from table_constraints
where table_name = 'test5';
-- shopdb 스키마(데이터베이스)에 존재하는 테이블에 선언된 제약조건 정보 조회
select *
from table_constraints
where constraint_schema = 'shopdb';

-- 서브쿼리를 활용한 테이블 생성
-- [문법] create table 테이블명
--       as 서브쿼리;
-- 서브쿼리로부터 반환된 구조와 데이터를 그대로 가지는 복사본의 테이블이 생성됨.
-- 단, 제약조건은 not null 제약조건만 복사됨.
-- 테스트용 테이블 생성 및 백업 시 사용됨.
use hr;

create table dept80
as select employee_id, last_name, salary*12 as annsal, hire_date
   from employees
   where department_id = 80;
   
desc dept80;

select *
from dept80;

-- 복사본 테이블 또는 백업용 테이블 생성 예제
create table copy_dept
as select *
   from departments;
   
desc copy_dept;

select *
from copy_dept;

-- (연습문제) p48
use shopdb;
-- 1. title 테이블 생성
create table title
(title_id int primary key,
 title varchar(60) not null,
 description varchar(400) not null,
 rating varchar(4) check (rating in ('G','PG','R','NC17','NR')),
 category varchar(20) check (category in ('DRAMA', 'COMEDY', 'ACTION',
										  'CHILD', 'SCIFI', 'DOCUMENTARY')),
 release_date date);
 
desc title;

-- 2. title_copy 테이블 생성
create table title_copy
(copy_id int,
 title_id int,
 status varchar(15) not null check (status in ('available', 'destroyed',
											   'rented', 'reserved')),
 primary key(copy_id, title_id),
 foreign key(title_id) references title(title_id));

desc title_copy;

-- 연습문제에서 생성한 테이블 정보 조회
-- 대표 DB 사전 : table_constraints, check_constraints, key_column_usage
use information_schema;
show tables;

-- check 제약조건 정보 확인하기
desc check_constraints;

select *
from check_constraints
where constraint_schema = 'shopdb';

-- PK, FK 제약조건 정보 확인하기
desc key_column_usage;

select *
from key_column_usage
where table_name = 'title';

select *
from key_column_usage
where table_name = 'title_copy';

-- 제약조건 정보 조회하기(not null 제외)
select *
from table_constraints
where table_name = 'test4';

select *
from table_constraints
where table_name = 'test5';

-- 9-2. alter table : 테이블 수정
-- 컬럼 추가, 컬럼 수정, 컬럼 삭제, 제약조건 추가, 제약조건 삭제
use hr;
-- 1) 컬럼 추가 : alter table 테이블명 add ----;
-- (예제1) job_id 컬럼 추가
alter table dept80
add job_id varchar(9);
-- 새롭게 추가된 컬럼은 기본적으로 마지막 컬럼으로 추가됨.
desc dept80;
-- 데이터는 자동으로 null값 삽입됨.
select *
from dept80;

-- (예제2) email 컬럼 추가(default값이 있는 컬럼 추가)
alter table dept80
add email varchar(30) default '미입력';
-- 새롭게 추가된 컬럼은 기본적으로 마지막 컬럼으로 추가됨.
desc dept80;
-- default값이 있는 컬럼은 자동으로 default값이 삽입됨.
select *
from dept80;

-- (예제3) 테이블 가장 앞에 컬럼 추가
alter table dept80
add emp_number int first;

desc dept80;

-- (예제4) 특정 컬럼 뒤에 컬럼 추가
alter table dept80
add salary int default 300 not null after last_name;

desc dept80;

select *
from dept80;

-- (예제5) 컬럼 추가 시 not null 제약조건 선언한 경우 삽입되는 데이터 확인하기
alter table dept80
add dept_id int not null;         -- 자동으로 null값 대신 0 삽입됨.

alter table dept80
add text varchar(20) not null;    -- 자동으로 null값 대신 공백 삽입됨.

alter table dept80
add start_date date not null;     -- 자동으로 null값 대신 0000-00-00 삽입됨.

desc dept80;

select *
from dept80;

-- 2) 컬럼 수정 : alter table 테이블명 modify ---;
-- 데이터타입, 컬럼사이즈, default값, not null 제약조건 변경 가능함.
desc dept80;
-- salary int default 300 not null -> salary bigint
-- 데이터 타입 변경, default 삭제, not null 삭제되는 작업임.
alter table dept80
modify salary bigint;
desc dept80;
-- not null 제약조건이 선언된 컬럼 변경 시 not null 제약조건 작성해야함.
alter table dept80
modify last_name varchar(30) not null;
desc dept80;
-- default값 변경 시 저장된 데이터가 변경되는게 아니라 이후 삽입부터 적용됨.
alter table dept80
modify salary bigint default 500 not null;

select *
from dept80;

-- [참고] 컬럼명 변경 : alter table 테이블명 rename ---;
alter table dept80
rename column hire_date to h_date;

desc dept80;

-- 3) 컬럼 삭제 : alter table 테이블명 drop ---;
alter table dept80
drop emp_number;

desc dept80;

-- 4) 제약조건 추가
-- alter table 테이블명 add ---;    : PK, FK, UK, CK
-- alter table 테이블명 modify ---; : NN(not null)
select *
from dept80;
-- primary key 추가(unique 추가 문법 동일함)
alter table dept80
add primary key(employee_id);
-- check 추가
alter table dept80
add check (salary >= 100);
-- foreign key 추가
alter table dept80
add foreign key(employee_id) references employees(employee_id);
-- not null 추가
alter table dept80
modify email varchar(30) default '미입력' not null;

desc dept80;

-- 5) 제약조건 삭제 : alter table 테이블명 drop ---;
-- 제약조건 삭제 시 제약조건명을 알아야 삭제 가능함.
-- 단, primary key 제약조건은 테이블당 하나만 존재하는 제약조건이므로 제약조건유형으로 삭제 가능함.
-- 또한 not null 제약조건은 modify절을 사용해서 추가/삭제 가능함.
-- DB사전에서 제약조건명 확인하기
use information_schema;
select *
from table_constraints
where table_name  = 'dept80';

-- PK 제약조건 삭제
alter table dept80
drop primary key;

-- FK 제약조건 삭제
alter table dept80
drop foreign key dept80_ibfk_1;

-- [alter table] 정리
-- 컬럼 추가		: alter table 테이블명 add ---;
-- 컬럼 수정		: alter table 테이블명 modify ---;
-- 컬럼 삭제		: alter table 테이블명 drop ---;
-- 제약조건 추가	: alter table 테이블명 add ---;	 			 <-- pk,fk,uk,ck
--                alter table 테이블명 modify ---; 			 <-- nn
-- 제약조건 삭제	: alter table 테이블명 drop primary key; 		 <-- pk
-- 				  alter table 테이블명 drop 제약조건유형 제약조건명; <-- fk,uk,ck
-- 				  alter table 테이블명 modify ---;			 <-- nn
-- 컬럼명 변경    : alter table 테이블명 rename 기존컬럼명 to 새컬럼명;

-- 9-3. drop table : 테이블 삭제
-- DB로부터 테이블을 삭제하는 명령어
-- 테이블 구조, 테이블에 선언된 제약조건, 테이블의 데이터까지 모두 삭제됨.
use shopdb;
drop table test1;
desc test1;   -- 테이블 존재하지 않음!

-- 9-4. truncate table : 테이블 절단
-- 테이블의 모든행을 삭제하는 명령어
-- 테이블의 구조만 남기고 테이블을 비울때 사용함.
use hr;
truncate table dept80; -- (==) delete from dept80;
-- truncate : rollback X <--> delete : rollback O
desc dept80;
select *
from dept80;