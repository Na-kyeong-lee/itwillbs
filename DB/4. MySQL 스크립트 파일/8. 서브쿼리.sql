-- [SQL문법] 7. 서브쿼리(subquery)
use hr;

-- 서브쿼리란? 
-- 쿼리구문 안에 또다시 쿼리구문이 들어가 있는 형태
-- 사용목적 : 모르는 값을 기준으로 쿼리구문을 작성해야하는 경우 서브쿼리 구문으로 대신할 수 있음.
-- 서브쿼리가 사용 가능한 곳 : group by절을 제외한 쿼리구문 전체 사용 가능함.
-- [문법] where절 사용 문법 : 연산자의 오른쪽에 괄호로 묶어서 작성함.
--       select 컬럼명1, 컬럼명2, 컬럼명3
--       from 테이블명
--       where 좌변 = (select 컬럼명
--                    from 테이블명
--                    where 조건문);
-- 서브쿼리 유형 : 단일행 서브쿼리, 다중행 서브쿼리, 단일컬럼 서브쿼리, 다중컬럼 서브쿼리

-- employees 테이블에서 'Abel'(last_name)보다 급여를 더 많이 받는 사원의
-- employee_id, last_name, salary를 출력하시오.
select employee_id, last_name, salary
from employees
where salary > (select salary
			    from employees
                where last_name = 'Abel');
                
-- 서브쿼리 유형1 : 단일행 서브쿼리 + 단일컬럼 서브쿼리
-- 서브쿼리로부터 메인쿼리로 오직 한행이 반환되는 경우
-- 단일행 비교연산자 사용해야함.
-- 단일행 비교연산자 : =, >, >=, <, <=, <>

-- where절에 서브쿼리가 사용된 예제
-- 141번 직원과 같은 업무 담당자를 출력하되, 비교의 대상이었던 141번 직원은 제외하시오.
SELECT employee_id, last_name, job_id
FROM employees
WHERE job_id = (SELECT job_id
			    FROM employees
                WHERE employee_id = 141)
and employee_id <> 141;

-- employees 테이블에서 최소 급여를 받는 사원의 employee_id, last_name, salary를 출력하시오.
select employee_id, last_name, salary
from employees
where salary = (select min(salary)
			    from employees);
                
-- employees 테이블에서 last_name이 'Lee'인 직원과 동일 업무를 담당하면서
-- 급여는 더 많이 받는 사원을 출력하시오.
SELECT last_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id
				FROM employees
				WHERE last_name = 'Lee')
AND salary > (SELECT salary
			  FROM employees
			  WHERE last_name = 'Lee');
              
-- having절에 서브쿼리가 사용된 예제
-- 부서별 최소 급여를 출력하되, 30번 부서의 최소 급여보다 큰 부서만 출력하시오.
SELECT department_id, MIN(salary)
FROM employees
WHERE department_id is not null
GROUP BY department_id
HAVING MIN(salary) > (SELECT MIN(salary) 
					  FROM employees
                      WHERE department_id = 30);
                      
-- 오류 원인 : 단일행 비교연산자가 작성되어 있는데 서브쿼리에서 하나 이상의 행이 반환됨.
SELECT employee_id, last_name
FROM employees
WHERE salary = (SELECT MIN(salary) 
			    FROM employees
			    GROUP BY department_id);
                
-- [수정] = ---> IN 으로 재작성
SELECT employee_id, last_name
FROM employees
WHERE salary IN (SELECT MIN(salary) 
			     FROM employees
			     GROUP BY department_id);
                 
-- 결과가 나오지 않는 원인 : 단일행 서브쿼리로부터 null값이 반환된 경우 메인쿼리 결과도 null이다!
SELECT last_name, job_id
FROM employees
WHERE job_id = (SELECT job_id
			    FROM employees
				WHERE last_name = 'Haas');

-- 서브쿼리 유형2 : 다중행 서브쿼리 + 단일컬럼 서브쿼리
-- 서브쿼리로부터 메인쿼리로 여러개의 행이 반환되는 유형
-- 메인쿼리에 다중행 비교연산자 사용해야함.
-- 다중행 비교연산자 : in, not in, any, all
-- =any   : (=, OR)  (==) in : (=, OR)	
-- >any   : (>, OR)	   -> 최소값보다 큰지를 비교함.		
-- >=any  : (>=, OR)   -> 최소값보다 크거나 같은지를 비교함.
-- <any   : (<, OR)    -> 최대값보다 작은지를 비교함.
-- <=any  : (<=, OR)   -> 최대값보다 작거나 같은지를 비교함.
-- <>any  : (<>, OR)   -> 연산자로써의 성격이 없음! 사용안됨!!!
-- =all   : (=, AND)   -> 연산자로써의 성격이 없음! 사용안됨!!!
-- >all   : (>, AND)   -> 최대값보다 큰지를 비교함.
-- >=all  : (>=, AND)  -> 최대값보다 크거나 같은지를 비교함.
-- <all   : (<, AND)   -> 최소값보다 작은지를 비교함.
-- <=all  : (<=, AND)  -> 최소값보다 작거나 같은지를 비교함.
-- <>all  : (<>, AND) (==) not in : (<>, AND)

SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ANY (SELECT salary
				    FROM employees
				    WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';

SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL (SELECT salary 
					FROM employees
					WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';


SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary < ALL (SELECT salary 
				    FROM employees
				    WHERE job_id = 'IT_PROG')
AND job_id <> 'IT_PROG';

-- 서브쿼리 유형3 : 다중컬럼 서브쿼리
-- 서브쿼리 유형의 조합 : 단일행 서브쿼리		 다중행 서브쿼리
-- 					(단일행비교연선자)		(다중행비교연산자)

-- 					단일컬럼 서브쿼리		 다중컬럼 서브쿼리
-- 					  (비쌍비교)			    (쌍비교)

-- 다중컬럼 서브쿼리 + 다중행 서브쿼리 예제
SELECT employee_id, first_name, department_id, salary
FROM employees
WHERE (department_id, salary) IN (SELECT department_id, min(salary) 
								  FROM employees
								  GROUP BY department_id)
ORDER BY department_id;

-- 자기 자신이 매니저가 아닌 직원들을 출력하시오.
-- 결과가 나오지 않는 원인은? 서브쿼리로부터 넘어오는 값리스트에 null값이 포함되어 있는데
--                      메인쿼리에 AND의 성격을 가지는 비교연산자를 사용했기때문임!
SELECT employee_id, last_name
FROM employees
WHERE employee_id NOT IN (SELECT manager_id
						  FROM employees);
-- [수정]
SELECT employee_id, last_name
FROM employees
WHERE employee_id NOT IN (SELECT manager_id
						  FROM employees
                          WHERE manager_id is not null);

-- (연습문제)
-- 1. 
SELECT last_name, hire_date
FROM employees
WHERE department_id = (SELECT department_id
					   FROM employees
					   WHERE last_name = 'Abel')
AND last_name <> 'Abel';

-- 2.
SELECT employee_id, last_name, salary
FROM employees
WHERE salary >= (SELECT AVG(salary)
 	             FROM employees)
ORDER BY salary;

-- 3.
SELECT employee_id, last_name
FROM employees
WHERE department_id IN (SELECT department_id
						FROM employees
						WHERE last_name like '%u%');

-- 4. 
SELECT employee_id, last_name, department_id, job_id
FROM employees
WHERE department_id IN (SELECT department_id
                        FROM departments
                        WHERE location_id = 1700);

-- 5. 
SELECT employee_id, last_name, salary
FROM employees
WHERE department_id IN (SELECT department_id
                        FROM employees
                        WHERE last_name like '%u%')
AND salary >= (SELECT AVG(salary)
               FROM employees);

-- 6. 
SELECT employee_id, last_name
FROM employees
WHERE employee_id IN (SELECT manager_id
                      FROM employees);

-- 7. 
SELECT department_id, department_name
FROM departments
WHERE department_id NOT IN (SELECT department_id
							FROM employees
                            WHERE department_id is not null);
                            
                            
                            
                            
