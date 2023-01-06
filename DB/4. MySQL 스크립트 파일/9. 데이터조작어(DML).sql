-- [SQL문법 ] 8. 데이터조작어(DML)
-- insert : 테이블에 데이터를 삽입함.
-- update : 테이블의 데이터를 수정함.
-- delete : 테이블의 데이터를 삭제함.

-- 8-1. insert : 데이터 삽입
-- [문법1] 테이블명 뒤에 컬럼리스트 생략한 경우 values절에 기본 컬럼 순서대로 모든 값 나열해야함.
-- insert into 테이블명
-- values (값1, 값2, 값3, ...);

-- [문법2] 테이블명 뒤에 컬럼리스트 작성한 경우 values절의 값리스트와 일치(개수, 데이터타입 등)해야함.
-- insert into 테이블명(컬럼명1, 컬럼명2, 컬럼명3, ....)
-- values (값1, 값2, 값3, ....);

desc departments;

insert into departments
values (280, 'Mysql', 107, 1700);

insert into departments(department_name, location_id, manager_id, department_id)
values ('Oracle', 1700, 108, 290);

-- null값을 자동(암시적)으로 삽입하기
insert into departments(department_id, department_name)
values (300, 'Java');

-- null값을 수동(명시적)으로 삽입하기
insert into departments
values (310, 'Jsp', null, null);

-- 여러행 삽입하기
insert into departments
values (320, 'AAA', 200, 1700),
	   (330, 'BBB', 201, null),
	   (340, 'CCC', null, 1700);
       
select *
from departments;

-- insert + 서브쿼리
-- insert 구문에 서브쿼리가 사용된 경우 다른 테이블의 데이터를 복사해서 삽입함.
-- (예제1)
create table sales_reps
(id int,
 name varchar(20),
 salary int,
 commission_pct double(10,2));
 
desc sales_reps;
 
insert into sales_reps(id, name, salary, commission_pct)
	select employee_id, last_name, salary, commission_pct
    from employees
    where job_id like '%REP%';

select *
from sales_reps;

-- (예제2)
-- employees 테이블과 구조가 동일한 테이블 생성함.
create table copy_emp
as select *
   from employees
   where 1=2;
   
desc copy_emp;

-- employees 테이블로부터 전체 사원의 데이터를 복사해서 삽입함.
insert into copy_emp
	select *
    from employees;

select *
from copy_emp;

-- 8-2. update : 데이터 수정
-- [문법] update 테이블명
--       set 컬럼명1 = 값1[, 컬럼명2 = 값2]
--      [where 조건문];

update employees
set department_id = 50
where employee_id = 113;

select employee_id, last_name, department_id
from employees
where employee_id = 113;

-- [Query] - [Auto-commit 해제] 후 실습하기
-- update 시 where절 생략하면 모든행이 수정됨.
-- 전체 직원의 부서가 110으로 변경됨.
update copy_emp
set department_id = 110;
-- 작업 후 미리보기
select employee_id, last_name, department_id
from copy_emp;
-- 작업 취소
rollback;
-- 취소 확인
select employee_id, last_name, department_id
from copy_emp;
-- where절 추가해서 다시 update 작업 진행
update copy_emp
set department_id = 110
where job_id = 'ST_MAN';
-- 작업 후 미리보기
select employee_id, last_name, department_id
from copy_emp
where job_id = 'ST_MAN';
-- 작업 저장
commit;
-- [Query] - [Auto-commit 체크] 후 실습하기

-- copy_emp테이블의 전체 직원 급여를 10% 인상시키는 작업을 진행하시오.
update copy_emp
set salary = salary * 1.1;

select employee_id, last_name, salary
from copy_emp;

-- update + 서브쿼리
-- 다른 테이블의 데이터를 기준으로 해당 테이블의 데이터를 업데이트함.
-- (예제1) employees테이블 205번 사원의 job_id, salary를 기준으로
--        copy_emp테이블 113번 사원의 job_id, salary를 변경하시오.
update copy_emp
set job_id = (select job_id
			  from employees
			  where employee_id = 205),
	salary = (select salary
			  from employees
              where employee_id = 205)
where employee_id = 113;

select employee_id, last_name, job_id, salary, department_id
from copy_emp
where employee_id in (113, 205);

-- (예제2) copy_emp테이블에서 location_id가 1800인 부서에 소속된 사원들의 
--        급여를 10%로 인상하시오.
update copy_emp
set salary = salary * 1.1
where department_id = (select department_id
					   from departments
					   where location_id = 1800);
                       
select employee_id, last_name, salary, department_id
from copy_emp
where department_id = (select department_id
					   from departments
                       where location_id = 1800);

-- 8-3. delete : 데이터 삭제
-- [문법1] 테이블의 모든행 삭제
-- delete from 테이블명;

-- [문법2] 테이블의 특정행 삭제
-- delete from 테이블명
-- where 조건문;

-- departments 테이블에서 300번 부서를 삭제하시오.
delete from departments
where department_id = 300;

select *
from departments;

-- [Query] - [Auto-commit 해제] 후 작업하기
-- where절 없이 delete 구문 실행 -> copy_emp 테이블의 모든행 삭제됨.
delete from copy_emp; 
-- 작업 결과 미리보기
select *
from copy_emp;
-- 작업 취소
rollback;
-- 작업 취소 확인
select *
from copy_emp;
-- where절 추가해서 delete 구문 실행
delete from copy_emp
where department_id = 20;
-- 작업 결과 미리보기
select *
from copy_emp
where department_id = 20;
-- 작업 저장
commit;
-- [Query] - [Auto-commit 체크] 후 작업하기

-- delete + 서브쿼리
delete from copy_emp
where department_id = (select department_id
					   from departments
					   where location_id = 1800);
                       
-- 8-4. 트랜잭션제어어(TCL)
-- 트랜잭션이란? 
-- 하나의 논리적인 작업 단위
-- 하나 이상의 DML이 모여서 하나의 트랜잭션을 구성함.(insert, update, delete)
-- 하나의 DDL이 하나의 트랜잭션을 구성함.(create, alter, drop, truncate)
-- 하나의 DCL이 하나의 트랜잭션을 구성함.(grant, revoke)
-- 트랜잭션 제어명령어(TCL) : commit, rollback, savepoint
-- 트랜잭션 시작 - 첫번째 DML 구문이 실행될때
-- 트랜잭션 종료 - commit, rollback 명령어 실행될때

-- (위의 작업은 모두 저장됨)
-- 트랜잭션 시작 -> update ----;
--               insert ----;
-- 트랜잭션 종료 -> commit;
-- 트랜잭션 시작 -> insert ----;
--               delete ----;
--               delete ----;
-- 트랜잭션 종료 -> rollback;
-- 트랜잭션 시작/종료 -> create table ---;(DDL)
--                  (autocommit 내포함)
-- 트랜잭션 시작/종료 -> grant ---;(DCL)
--                  (autocommit 내포함)

-- savepoint란? 저장점, 트랜잭션 진행 중 되돌아갈 지점(기점, 포인트)을 생성하는 명령어
-- (savepoint 활용 예제)
-- [Query] - [Auto-commit 해제] 후 실습하기
update copy_emp
set salary = 27000
where employee_id = 107;   -- 트랜잭션 시작

select employee_id, last_name, salary
from copy_emp
where employee_id = 107;  -- 미리보기

savepoint test1;   -- 저장점 생성함.

update copy_emp
set salary = 25000
where employee_id = 125;

select employee_id, last_name, salary
from copy_emp
where employee_id = 125;  -- 미리보기

rollback to test1;  -- 저장점으로 되돌림(부분 취소). 트랜잭션 종료와는 상관없음!

select employee_id, last_name, salary
from copy_emp
where employee_id in (107, 125);

commit;  -- 트랜잭션 종료

-- (연습문제)
-- [Query] - [Auto-commit 해제] 후 실습하기
-- 1.
CREATE TABLE my_employee
 (id int PRIMARY Key,
 last_name VARCHAR(25),
 first_name VARCHAR(25),
 userid VARCHAR(8),
 salary int);
-- 2.
DESCRIBE my_employee;
-- 3.
INSERT INTO my_employee
VALUES (1, 'Patel', 'Ralph', 'rpatel', 895);

INSERT INTO my_employee (id, last_name, first_name, userid, salary)
VALUES (2, 'Dancs', 'Betty', 'bdancs', 860);

INSERT INTO my_employee
VALUES (3, 'Biri', 'Ben', 'bbiri', 1100),
       (4, 'Newman', 'Chad', 'cnewman', 750);
-- 4.
SELECT *
FROM my_employee;
-- 5.
commit; 
-- ------------------------
-- 6.
UPDATE my_employee
SET last_name = 'Drexler'
WHERE id = 3;
-- 7.
UPDATE my_employee
SET salary = 1000 
WHERE salary < 900;
-- 8.
SELECT *
FROM my_employee;
-- 9.
DELETE
FROM my_employee 
WHERE last_name = 'Dancs';
-- 10.
SELECT *
FROM my_employee;
-- 11.
commit;
-- ------------------------
-- 12.
INSERT INTO my_employee
VALUES (5, 'Ropeburn', 'Audrey', 'aropebur', 1550);
-- 13.
SELECT *
FROM my_employee;
-- 14.
SAVEPOINT step_17;
-- 15. 
DELETE 
FROM my_employee;
-- 16.
SELECT *
FROM my_employee;
-- 17.
ROLLBACK TO step_17;
-- 18.
SELECT *
FROM my_employee;
-- 19.
commit;