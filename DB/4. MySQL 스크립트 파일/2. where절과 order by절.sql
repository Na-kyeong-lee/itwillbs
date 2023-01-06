-- [SQL문법] 2. where절과 order by절
use hr;

-- 2-1. where절
-- [문법1] 테이블로부터 모든행 출력! 
--        select * | 컬럼명1, 컬럼명2, 컬럼명3     
--        from 테이블명;
-- [문법2] 테이블로부터 특정행 출력!
--        select * | 컬럼명1, 컬럼명2, 컬럼명3     
--        from 테이블명
--        where 조건문;

-- where 뒤 조건문 작성방법
-- where   좌변      =       우변
--      (컬럼명) (비교연산자) (리터럴값) -> '문자', '날짜', 숫자

select employee_id, last_name, job_id, department_id
from employees
where department_id = 90;

select last_name, job_id, department_id
from employees
where last_name = 'WHALEN';

select last_name, job_id, department_id
from employees
where last_name = 'king';

select employee_id, last_name, hire_date
from employees
where hire_date = '1996-02-17';

select employee_id, last_name, hire_date
from employees
where hire_date >= '2000-01-01';

select last_name, salary
from employees
where salary <= 3000;

-- 비교연산자 종류
-- 단일행비교연산자 : =, >, >=, <, <=, <>, !=
-- 추가 비교연산자 : between, in, like, is null

-- [비교연산자1] between A and B
-- 범위 검색 비교연산자로 A(하한값)이상 B(상한값)이하의 값을 비교함.
select employee_id, last_name, salary
from employees
where salary between 2500 and 3500;
-- (==)
select employee_id, last_name, salary
from employees
where salary >= 2500 and salary <= 3500;

select employee_id, last_name, hire_date, department_id
from employees
where hire_date between '1998-01-01' and '1999-12-31';

select employee_id, last_name
from employees
where last_name between 'abel' and 'dehaan';

-- [비교연산자2] in
-- 다중행 비교연산자로 우변의 값리스트와 비교해서 하나이상 같으면 true를 반환함.
-- (=,OR)의 성격을 내포하는 비교연산자
select employee_id, last_name, salary, manager_id, department_id
from employees
where manager_id in (100, 101, 201);
-- (==)
select employee_id, last_name, salary, manager_id, department_id
from employees
where manager_id = 100 or manager_id = 101 or manager_id = 201;

-- [비교연산자3] like
-- 패턴 일치 여부를 비교하는 연산자
-- like 비교연산자와 함께 사용되는 기호 1) % : 0 또는 여러개 char
--                               2) _ : 반드시 1개 char
-- a로 시작되는 문자열 : 'a%'
-- a가 포함된 문자열 : '%a%'
-- a로 끝나는 문자열 : '%a'
-- 두번째 문자가 a인 문자열 : '_a%'
-- 끝에서 세번째 문자가 a인 문자열 : '%a__'
select employee_id, last_name
from employees
where last_name like '_o%';

select employee_id, last_name, job_id, department_id
from employees
where job_id like '%it%';

select employee_id, last_name, hire_date
from employees
where hire_date like '1997%';

select employee_id, last_name, hire_date
from employees
where hire_date like '%01';

-- [비교연산자4] is null
-- 값이 null인지 여부를 비교해주는 연산자
-- employees 테이블에서 사장(회사 대표)의 정보를 출력하시오.
select employee_id, last_name, job_id, department_id
from employees
where manager_id is null;

-- employees 테이블에서 커미션(commission_pct)을 받지 않는 사원들의
-- employee_id, last_name, salary, commission_pct를 출력하시오.
select employee_id, last_name, salary, commission_pct
from employees
where commission_pct is null;

-- 논리연산자 : and, or, not
-- where절에 여러개의 조건문 작성 시 and, or로 나열
-- 우선순위 : not > and > or
select employee_id, last_name, salary, department_id
from employees
where department_id = 50
or department_id = 30
and salary >= 10000;

select employee_id, last_name, salary, department_id
from employees
where (department_id = 50
or department_id = 30)
and salary >= 10000;
-- (==)
select employee_id, last_name, salary, department_id
from employees
where department_id in (50, 30)
and salary >= 10000;

-- 비교연산자 정리
-- = 				<-->	<>, !=
-- >, >=			<-->	<, <=
-- between A and B	<-->	not between A and B
-- in : (=, OR)		<-->	not in : (<>, AND)
-- like				<-->	not like
-- is null			<-->	is not null

select employee_id, last_name, salary
from employees
where salary not between 10000 and 20000;

select employee_id, last_name, job_id
from employees
where job_id not in ('SA_REP', 'IT_PROG', 'ST_MAN');

select employee_id, last_name
from employees
where last_name not like 'a%';

select employee_id, last_name, salary, commission_pct
from employees
where commission_pct is not null;

-- 2-2. order by절
-- [문법] select 컬럼1, 컬럼2, 컬럼3
--       from 테이블명
--       where 조건문
--       order by 정렬의기준이될컬럼명 [asc | desc];
select employee_id, last_name, hire_date, department_id
from employees
order by hire_date desc;

select employee_id, last_name, salary, department_id
from employees
order by department_id, salary desc;

-- <연습문제>
-- 1. employees 테이블로부터 2000년도에 입사한 모든 사원의 last_name과 hire_date를 출력하시오.
select last_name, hire_date
from employees
where hire_date like '2000%';
-- (==)
select last_name, hire_date
from employees
where hire_date between '2000-01-01' and '2000-12-31';

-- 2. employees 테이블로부터 커미션을 받지 않는 모든 사원의 last_name, salary, 
-- commission_pct를 출력하되 salary를 기준으로 내림차순 정렬하시오.
select last_name, salary, commission_pct
from employees
where commission_pct is null
order by salary desc;