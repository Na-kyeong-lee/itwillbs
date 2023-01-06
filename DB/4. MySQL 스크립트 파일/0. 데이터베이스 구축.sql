-- 데이터베이스 구축
-- 1. Mysql 설치
-- 2. DB(스키마) 생성
-- 3. table 생성
-- 4. 데이터 삽입
-- 5. 데이터 검색

-- shopdb 데이터베이스 생성
create schema shopdb;

-- members 테이블 생성
create table members
( member_id int primary key,
  member_name varchar(8) not null,
  birth date not null,
  job varchar(20),
  phone varchar(20) unique,
  address varchar(80) );
  
desc members;

-- products 테이블 생성
create table products
 ( prod_id int primary key, 
   prod_name varchar(20) not null, 
   price int check (price > 0), 
   make_date date, 
   company varchar(10) not null );

desc products;

-- now() 함수 : 현재 날짜와 시간을 반환해주는 함수
select now()
from dual;

-- orders 테이블 생성
create table orders
( order_num int,
  member_id int,
  prod_id int,
  order_date datetime default now(),
  primary key(order_num),
  foreign key(member_id) references members(member_id),
  foreign key(prod_id) references products(prod_id) );
  
desc orders;

-- auto_increment 속성
-- 1부터 시작해서 1씩 증가하는 값을 자동으로 반환해 주는 속성
-- pk, uk 제약조건이 선언된 숫자형식의 컬럼에만 사용 가능함.
-- 시작값, 증가값 변경 가능함.
-- stu20 테이블 생성(auto_increment 속성 포함)
create table stu20
 (stu_id int auto_increment primary key, 
  stu_name varchar(5) not null, 
  age int check (age > 19));

desc stu20;

-- 데이터 삽입(insert)
-- members 테이블에 데이터 삽입
desc members;

-- 테이블명 뒤에 컬럼 리스트 생략한 경우 -> values절에 기본컬럼 순서대로 모든 값 나열!
insert into members
values (100, '홍길동', '1991-12-30', '학생', '010-1111-1111', '부산 부산진구 부전동');

-- 테이블명 뒤에 컬럼 리스트 작성한 경우 -> values절의 값 리스트와 갯수/순서 동일해야함!
-- 생략된 컬럼에는 자동으로 null값 삽입됨.
insert into members(member_id, member_name, birth, phone) 
values (101, '김민수', '1990-03-05', '010-2222-2222');

-- 테이블명 뒤에 컬럼 리스트 작성 시 not null 제약조건이 선언된 컬럼은 생략하면 안됨!
insert into members(member_id, member_name, birth, phone, address) 
values (102, '최아영', '1987-11-23', '010-3333-3333', '서울 강남구 선릉로');

insert into members(member_id, member_name, birth, job, phone) 
values (103, '홍길동', '1988-05-10', '회사원', '010-4444-4444');

insert into members(member_id, member_name, birth, job) 
values (104, '강주영', '1998-08-09', '대학생');

insert into members(member_id, member_name, birth, job, phone, address) 
values (105, '고승현', '1995-07-10', '트레이너', '010-5555-5555', '경기도 부천시 원미구');

-- 추가 데이터 삽입하기
insert into members(member_id, member_name, birth, job, phone)
values (106, '정유빈', '1970-02-04', '회사원', '010-6666-6666');

insert into members(member_id, member_name, birth, phone)
values (107, '이영수', '1988-12-06', '010-7777-7777');

insert into members(member_id, member_name, birth, phone, address)
values (108, '김철수', '1999-01-15', '010-8888-8888', '부산 해운대구 센텀로');

insert into members
values (109, '최승현', '1995-04-22', '간호사', '010-9999-9999', '서울 강북구 수유동'),
       (110, '한주연', '2001-08-24', '승무원', '010-1010-1010', '대구 수성구 수성로');

select *
from members;

-- products 테이블에 데이터 삽입
-- null값을 명시적으로 삽입하는 방법
desc products;

insert into products
values (10, '냉장고', 500, null, '삼성');

insert into products
values (20, '컴퓨터', 150, '2022-01-13', '애플'),
	   (30, '세탁기', 250, '2020-03-10', 'LG'),
       (40, 'TV', 200, '2021-09-30', 'LG'),
	   (50, '전자렌지', 50, '2019-06-20', '삼성'),
       (60, '건조기', 300, '2021-07-09', 'LG');
       
select *
from products;

-- orders 테이블에 데이터 삽입
-- 특히, orders 테이블의 member_id와 prod_id 컬럼에는 fk 제약조건(외래키)이 
-- 선언되어 있으므로 데이터 삽입 시 부모 컬럼에 있는 데이터만 삽입 가능함!
desc orders;

insert into orders
values (1, 101, 20, '2022-02-01');

insert into orders
values (2, 107, 40, '2022-02-05 17:51');

insert into orders
values (3, 106, 50, now());

-- orders테이블의 order_date컬럼은 default값이 선언된 컬럼이므로
-- 생략 시 자동으로 default값 삽입됨.
insert into orders(order_num, member_id, prod_id)
values (4, 103, 10);

-- 수동으로 default값 삽입하는 방법
insert into orders
values (5, 108, 50, default);

insert into orders
values (6, 103, 30, default);

insert into orders
values (7, 105, 60, default);

insert into orders
values (8, 110, 40, '2021-12-30 10:30:45'),
	   (9, 107, 30, default),
       (10, 101, 60, now());

select *
from orders;

-- stu20 테이블에 데이터 삽입
desc stu20;

-- auto_increment 속성이 선언된 컬럼에 데이터 삽입
insert into stu20
values (null, '김온달', 28);

insert into stu20
values (null, '이평강', 24);

delete from stu20
where stu_id >= 3;

-- 입력값(시작값) 변경하는 방법
alter table stu20 auto_increment = 100;

insert into stu20
values (null, '최찬미', 29);

insert into stu20
values (null, '김동희', 31);

-- 증가값(증가사이즈) 변경
set @@auto_increment_increment = 5;
 
insert into stu20
values (null, '박혜경', 22);

insert into stu20
values (null, '문진원', 27);

select *
from stu20;

-- 데이터 수정(update)
-- products 테이블의 모든 상품의 가격을 50씩 인상하시오.
update products
set price = price + 50;

select *
from products;

-- products 테이블의 TV 가격을 30 인상하시오.
update products
set price = price + 30
where prod_name = 'TV';

select *
from products;

-- members 테이블의 105번 사원 전화번호를 010-5050-5050으로 변경하시오.
update members
set phone = '010-5050-5050'
where member_id = 105;

select *
from members;

-- orders 테이블의 2번 주문의 주문자(member_id)를 120으로 변경 => fk제약조건 위배로 작업 실패
-- 109로 변경 => 존재하는 회원이므로 변경 가능
update orders
set member_id = 109
where order_num = 2;

select *
from orders;

-- 특정 데이터(레코드)를 null값으로 수정하는 방법
update members
set phone = null
where member_id = 109;

select *
from members;

-- 데이터 삭제(delete)
-- stu20 테이블에서 나이가 25세 이하인 학생을 삭제하시오.
delete from stu20
where age <= 25;

select *
from stu20;

-- DML(insert, update, delete) 작업 후 저장 및 취소
-- auto-commit 설정 : DML 후 자동 저장됨.
-- auto-commit 해제 : DML 후 commit(저장), rollback(취소)을 실행해야함.

-- (auto-commit 해제)
-- stu20 테이블에서 모든 학생 삭제하시오.
delete from stu20;

select *
from stu20;  -- 미리보기

rollback;   -- 작업을 실수 했다면 취소 가능함.

-- (auto-commit 해제)
insert into stu20
values (null, '김영수', 30),
       (null, '이영희', 25);
       
select *
from stu20;   -- 미리보기

commit;      -- 작업을 영구히 저장함.

-- 테이블의 데이터 조회(select)
-- [문법] select * | 컬럼1, 컬럼2, 컬럼3
--       from 테이블명
--      [where 조건문]; 

-- 테이블로부터 모든 컬럼, 모든 행 조회
select *
from members;

select *
from products;

select *
from orders;

select order_num, order_date, member_id, prod_id
from orders;

-- 테이블로부터 특정 컬럼 조회
select member_id, member_name, phone
from members;

select company, prod_name, price
from products;

select order_num, order_date
from orders;

-- 산술연산자를 활용한 select 구문
select prod_id, prod_name, price, price + 50
from products;

-- 산술연산자와 컬럼 alias를 활용한 select 구문
select prod_id, prod_name, price as "현재 가격", price + 50 as "인상 예정 가격"
from products;

-- 테이블로부터 특정 행 조회
-- [문법] select 컬럼1, 컬럼2, 컬럼3
--       from 테이블명
--       where   좌변   비교연산자   우변 ;
--             (컬럼명)            (값) -> 숫자, '문자', '날짜'

-- 비교연산자 : 단일행비교연산자(=, >, >=, <, <=, <>)를 활용한 구문
select *
from members
where member_id = 105;

select *
from members
where member_name = '홍길동';

select *
from members
where job <> '회사원';

select prod_name, price
from products
where price >= 300;

select *
from members
where birth < '1990-01-01';

-- 비교연산자 : between A and B 를 활용한 구문
-- between A and B : 범위 검색, A 이상 B 이하의 값을 비교해주는 연산자
select prod_name, price
from products
where price between 300 and 500;
-- (==)
select prod_name, price
from products
where price >= 300 and price <= 500;

select member_id, member_name, birth
from members
where birth between '1990-01-01' and '1991-12-31';

select *
from members
where member_name between '김민수' and '이영수';

-- not between A and B : A 미만 B 초과의 값을 비교해주는 연산자
select prod_name, price
from products
where price not between 300 and 500;
-- (==)
select prod_name, price
from products
where price < 300 and price > 500;

select member_id, member_name, birth
from members
where birth not between '1990-01-01' and '1991-12-31';

select *
from members
where member_name not between '김민수' and '이영수';

-- 비교연산자 - like를 활용한 구문
-- like : 패턴 일치 여부를 비교해주는 연산자
-- like 연산자 우변에 패턴 작성 시 활용되는 기호
-- 1. % : 0개 또는 여러개의 문자를 의미하는 기호
-- 2. _ : 반드시 1개의 문자가 와야한다는 의미의 기호
-- a로 시작하는 문자열 : 'a%'
-- a가 포함된 문자열 : '%a%'
-- a로 끝나는 문자열 : '%a'
-- 두번째 문자가 a인 문자열 : '_a%'
-- 끝에서 세번째 문자가 a인 문자열 : '%a__'

select *
from members
where address like '부산%';

select member_id, member_name, birth, phone
from members
where member_name like '%영%';

select member_id, member_name, birth, phone
from members
where member_name like '_영%';

select *
from products
where make_date like '2021%';

-- not like : 작성된 패턴과 일치하지 않는지를 비교하는 연산자
select *
from members
where address not like '서울%';

select *
from members
where birth not like '19__%';

-- 비교연산자 : is null을 활용한 구문
-- is null : 값이 null인지를 비교해주는 연산자
select *
from members
where phone is null;

select *
from members
where job is null;

select *
from products
where make_date is null;

-- is not null : 값이 null이 아닌것을 찾아주는 연산자
select *
from members
where address is not null;

-- where절에 여러 조건문 작성하는 방법
-- and, or 논리연산자로 연결
select prod_name, price 
from products
where price >= 300 and price <= 500;

select * 
from members
where birth < '1990-01-01' or birth > '1991-12-31';

select *
from members
where address like '부산%' and job = '학생';

select *
from products
where company = 'LG' and price <=300;

-- where절에 and와 or가 함께 사용된 경우 우선순위가 높은 논리연산자는 and임.
-- 우선순위를 지정하고자하는 경우 괄호 사용.
-- and 연산자가 or 연산자보다 우선순위가 높다. 
select *
from products
where company = 'LG' or company = '삼성' and price <= 300;

-- or 연산을 먼저하고 싶으면 괄호로 묶어 준다.
select *
from products
where (company = 'LG' or company = '삼성') and price <= 300;

-- hr DB 전환
-- employees 테이블 구조 조회
desc employees;

-- employees 테이블로부터 모든 컬럼, 모든 행 조회
select *
from employees;

-- employees 테이블로부터 담당업무(job_id)가 IT_PROG인 사원들의
-- employee_id, last_name, job_id, salary, department_id를 출력하시오.
select employee_id, last_name, job_id, salary, department_id
from employees
where job_id = 'IT_PROG';

-- employees 테이블로부터 담당업무에 REP가 포함되어 있고, 
-- 급여는 7000이상 10000이하인 사원들의 
-- employee_id, last_name, job_id, salary를 출력하시오.
select employee_id, last_name, job_id, salary
from employees
where job_id like '%REP%'
and   salary between 7000 and 10000;

-- 테이블로부터 데이터 조회 시 정렬하기
-- [문법] select 컬럼1, 컬럼2, 컬럼3
--       from 테이블명
--      [where 조건문]
--      [order by 기준컬럼명 [asc | desc]]; 
-- 숫자가 저장된 컬럼 기준 정렬 예제
select *
from products
order by price asc;

select *
from products
order by price desc;

-- 정렬 방식(asc, desc) 생략 시 기본은 asc(오름차순)로 자동 지정됨.
-- 날짜가 저장된 컬럼 기준 정렬 예제
select *
from products
order by make_date; 

select *
from products
order by make_date desc; 

select *
from products
where make_date is not null
order by make_date desc; 

-- 문자가 저장된 컬럼 기준 정렬 예제
select *
from members
order by member_name;

select *
from members
order by member_name desc; 

-- 여러 컬럼 기준 정렬 예제
select *
from products
order by company, price desc;

select *
from products
order by company desc, price desc;

-- 정렬에 기준이 되는 컬럼이 반드시 select절에 포함될 필요는 없음.(문법 오류 아님)
-- 단, 정렬에 기준이 되는 컬럼을 함께 출력하지 않으면 정렬 여부를 눈으로 확인하기
-- 힘들어서 함께 출력하는 것을 권장함.
select prod_id, prod_name
from products
order by price;

select prod_id, prod_name, price
from products
order by price;