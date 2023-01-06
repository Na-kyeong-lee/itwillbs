-- [SQL문법] 1. SELECT 구문을 사용한 데이터 검색
-- DB 전환
use hr;
-- DB 내 table 목록 확인
show tables;
-- 테이블 구조 조회
describe employees;
desc departments;
desc locations;

-- 테이블로부터 데이터 검색
-- [문법] select * | 컬럼1, 컬럼2, 컬럼3
--       from 테이블명;

-- employees 테이블로부터 모든 컬럼 출력
select *
from employees;

-- departments 테이블로부터 모든 컬럼 출력
select *
from departments;

-- departments 테이블로부터 department_id, department_name 컬럼만 출력
select department_id, department_name
from departments;

-- departments 테이블로부터 department_name, manager_id, department_id
-- 순서대로 출력하시오.
select department_name, manager_id, department_id
from departments;

-- 산술연산자 : *, /, +, -
-- 산술연산자 우선순위 규칙 : 1) *, /가 +, -보다 우선순위가 높다.
-- 						2) 괄호() 안이 우선순위가 높다.
-- 산술식(표현식) : 산술연산자를 활용한 계산식
-- select 구문에 산술식 포함된 예제
select last_name, salary, 12*salary+100
from employees;

select last_name, salary, 12*(salary+100)
from employees;

-- [참고] employees 테이블의 commission_pct 컬럼의 데이터가 0으로 되어 있는 경우
-- 1) employees 테이블의  commission_pct 컬럼의 데이터타입 변경
--    => 좌측 Navigator에서 employees 테이블 선택 후 도구 클릭
--    => commission_pct 컬럼 데이터타입 : double(22,0) -> double(22,2) 변경
-- 2) commission_pct 컬럼의 데이터 0을 0.1로 수정
--    => SQL구문 : update employees
-- 				  set commission_pct = 0.1
-- 				  where commission_pct = 0;

-- null값이란? 모르는 값, 알 수 없는 값, 정의되지 않은 값 등등
-- 			 0도 공백도 아닌 하나의 특수한 값, 모든 데이터타입에 사용 가능함.
-- employees 테이블에서 커미션을 받는 사원은 커미션 비율이 저장되고 있고,
-- 커미션을 받지 않는 사원은 null값이 저장되어 있음.
select last_name, job_id, salary, commission_pct
from employees;

-- 100 + null = null
-- 100 - null = null
-- 100 * null = null
-- 100 / null = null
-- 12 * 3000 + 500 / null * 7 = null
-- 산술식에 null값이 포함되어 있는 경우 전체 결과는 무조건 null이다!!!
-- (예제) employees 테이블에서 사원들의 employee_id, last_name, salary, 
--       commission_pct, 1년동안의 수당을 출력하는 구문을 작성하시오.
select employee_id, last_name, salary, commission_pct, 12*salary*commission_pct
from employees;

-- 컬럼 alias : 출력 시 컬럼명을 재지정하는 방법
-- [문법] 컬럼명 as alias
--       컬럼명 alias
--       컬럼명 [as] "별명"  => 한글, 대소문자, 공백포함, 특수문자포함
select employee_id, last_name, salary, commission_pct, 
       12*salary*commission_pct as "연간 수당"
from employees;

select department_id as "부서번호", department_name as "부서명",
       manager_id "부서장의 ID", location_id "부서 위치"
from departments;

-- distinct : 중복된 데이터를 제거하고 한번만 출력해주는 키워드
-- employees 테이블에 있는 직원들이 소속된 부서 종류 출력
select distinct department_id
from employees;

select distinct department_id, job_id
from employees;

-- <연습문제>
-- 1. employees 테이블로부터 employee_id, last_name, job_id, hire_date를 출력하되 
-- 컬럼 제목을 각각 Emp #, Employee, Job, Hire Date로 지정하여 출력하시오.
select employee_id as "Emp #", last_name as "Employee", 
       job_id as "Job", hire_date as "Hire Date"
from employees;

-- 2. employees 테이블로부터 사원들이 담당하고 있는 업무(job_id) 리스트를 출력하시오.
desc employees;

select distinct job_id
from employees;