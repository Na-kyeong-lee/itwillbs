-- [SQL문법] 6. 그룹함수와 그룹화
use hr;

-- 그룹함수 => 특성 : null값은 제외하고 작업함!
-- MIN(행그룹) : 최소값 반환, 모든 데이터타입에 사용 가능
-- MAX(행그룹) : 최대값 반환, 모든 데이터타입에 사용 가능
select min(salary) as "최소 급여", max(salary) as "최대 급여"
from employees;

select min(hire_date) as "가장 오래된 입사일", max(hire_date) as "가장 최근 입사일"
from employees;

select min(last_name) as "name1", max(last_name) as "name2"
from employees;

-- SUM(행그룹) : 합계를 구해주는 함수
-- AVG(행그룹) : 평균을 구해주는 함수
select sum(salary) as "급여 합계", avg(salary) as "평균 급여"
from employees;

select sum(salary) as "급여 합계", avg(salary) as "평균 급여"
from employees
where job_id like '%REP%';

-- COUNT 함수
-- <employees>
-- emp_id | ... | com_pct | dept_id | salary
-- ------------------------------------------
-- 100				null      10	  3000
-- 101              .1        80	  5000
-- 102              .1        10	  4500
-- 103              null      10	  3500
-- 104              null      80	  6000
-- 105              .2        80	  2000
-- -------------------------------------------
-- count(*) : 모든 컬럼을 기준으로 count 작업을 함.
--            null값 포함, 중복값 포함
select count(*)    -- 전체 직원수를 구하시오.
from employees;    -- [위 예제 테이블 기준]결과 : 6

-- count(컬럼명) : 특정 컬럼을 기준으로 count 작업을 함.
--               null값 제외, 중복값 포함
select count(employee_id)      -- 전체 직원수를 구하시오.
from employees;                -- [위 예제 테이블 기준]결과 : 6

select count(commission_pct)   -- 커미션을 받는 직원수를 구하시오.
from employees;                -- [위 예제 테이블 기준]결과 : 3

-- count(distinct 컬럼명) : 특정 컬럼을 기준으로 count 작업을 하되 중복값 제외하고 count함.
--                         null값 제외, 중복값 제외
select count(distinct department_id)    -- 직원들이 소속된 부서의 수를 구하시오.
from employees;							-- [위 예제 테이블 기준]결과 : 2

-- (예제) employees 테이블에서 전 직원의 커미션 평균을 출력하시오.
-- [오답] 커미션을 받는 사원들의 커미션 평균이 출력됨!
select avg(commission_pct) as "전 직원의 커미션 평균"
from employees;
-- [정답]
select avg(ifnull(commission_pct, 0)) as "전 직원의 커미션 평균"
from employees;
-- (==)
select sum(commission_pct) / count(employee_id) as "전 직원의 커미션 평균"
from employees;

-- 그룹화 : group by절
-- [문법] select 컬럼명1, 컬럼명2, 컬럼명3
--       from 테이블명
--      [where 조건문]
--      [group by 그룹화의 기준이 되는 컬럼명]
--      [order by 정렬의 기준이 되는 컬럼명];
-- !!!group by절 작성 시 주의사항!!!
-- select절의 컬럼 리스트 중 그룹함수에 포함된 컬럼과 그룹함수에 포함되지 않은 컬럼이 같이 출력되려면
-- 그룹함수에 포함되지 않는 컬럼은 반드시 group by절에 포함되어 있어야 문법 오류가 발생하지 않음!!!

-- 부서별 평균급여를 출력하시오.
select department_id, avg(salary)
from employees
group by department_id;

-- 부서 내 업무별 평균급여를 출력하시오.
select department_id, job_id, avg(salary)
from employees
group by department_id, job_id
order by department_id;

-- 부서별 사원의 수를 출력하시오.
select department_id, count(last_name)
from employees
group by department_id;

-- 부서 내 업무별 사원의 수를 출력하시오.
select department_id, job_id, count(last_name)
from employees
group by department_id, job_id;

-- 그룹 제한 : having절
-- 조건절 1) where : 행 제한 조건문 작성
--      2) having : 행그룹 제한 조건문 작성(그룹함수가 들어가는 조건문)
-- [문법] select 컬럼명1, 컬럼명2, 컬럼명3
--       from 테이블명
--      [where 행 제한 조건문]
--      [group by 컬럼명]
--      [having 행그룹 제한 조건문]
--      [order by 컬럼명 [asc | desc]];
select job_id, sum(salary) payroll
from employees
where job_id not like '%REP%'
group by job_id
having sum(salary) > 13000
order by payroll;

-- (연습문제)
-- 1.
select round(avg(ifnull(commission_pct, 0)),2) as avg_comm
from employees;

-- 2.
SELECT job_id, ROUND(MAX(salary),0) "Maximum",
			   ROUND(MIN(salary),0) "Minimum",
			   ROUND(SUM(salary),0) "Sum",
			   ROUND(AVG(salary),0) "Average"
FROM employees
GROUP BY job_id;

-- 3.
SELECT job_id, COUNT(*)
FROM employees
GROUP BY job_id;

-- 4.
SELECT manager_id, MIN(salary)
FROM employees
WHERE manager_id IS NOT NULL
GROUP BY manager_id
HAVING MIN(salary) > 6000
ORDER BY MIN(salary) DESC;

-- 5.
SELECT MAX(salary) - MIN(salary) DIFFERENCE
FROM employees;

-- 6.
SELECT COUNT(*) total, SUM(if(year(hire_date)=1995,1,0)) "1995", 
		               SUM(if(year(hire_date)=1996,1,0)) "1996",
                       SUM(if(year(hire_date)=1997,1,0)) "1997",
                       SUM(if(year(hire_date)=1998,1,0)) "1998"
FROM employees;