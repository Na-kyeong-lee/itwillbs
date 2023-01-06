-- [SQL문법] 5-3. 단일행함수 - 변환 함수, 제어 흐름 함수, 시스템 정보 함수
use hr;

-- 변환 함수
-- DATE_FORMAT(날짜, 형식) : 날짜를 형식에 맞게 출력하는 함수
select date_format(now( ), '%Y-%M-%d') as "Now";
select date_format(now(), '%Y/%M/%d %H:%i:%s') as "Now";
select employee_id, hire_date, date_format(hire_date, '%Y-%M-%d %W') as "입사일"
from employees;

-- CAST(값 AS 데이터타입) : 값을 지정된 데이터타입으로 변환하는 함수
select cast('123' as signed), cast('-123.45' as signed);
select cast('123' as unsigned), cast('123.45' as unsigned);
select cast('2022/03/18' as date) as "날짜";
select cast('2022@03@18' as date) as "날짜";
select cast('2022-01-02 21:24:33.123' as date) as "DATE", 
       cast('2022-01-02 21:24:33.123' as time) as "TIME", 
       cast('2022-01-02 21:24:33.123' as datetime) as "DATETIME";
       
-- 제어 흐름 함수
-- IF(논리식, 참일 때 값, 거짓일 때 값) : 논리식이 참이면 두번째 인수, 거짓이면 세번째 인수를 반환함.
select if(100>200, '참이다', '거짓이다') as "결과";
select employee_id, salary, if(salary>10000, '1등급', '2등급') as "급여 등급"
from employees;

-- IFNULL(수식1, 수식2) : 수식1이 NULL이 아니면 수식1이 반환되고, NULL이면 수식2가 반환되는 함수
select ifnull(null, '널이군요') as "결과1", ifnull(100, '널이군요') as "결과2";
select employee_id, last_name, salary, commission_pct, ifnull(commission_pct, 0)
from employees;

-- (예제) employees 테이블에서 사원들의 employee_id, last_name, salary, commission_pct와
-- 연봉을 출력하시오. [연봉공식 : (12*salary) + (12*salary*commission_pct)]
select employee_id, last_name, salary, commission_pct,
       round((12*salary)+(12*salary*ifnull(commission_pct, 0))) as "연봉"
from employees;
-- (==)
select employee_id, last_name, salary, commission_pct,
       round(ifnull((12*salary)+(12*salary*commission_pct), (12*salary))) as "연봉"
from employees;

-- case 표현식
-- [문법] CASE 비교값 WHEN 값1 THEN 결과1
--                 WHEN 값2 THEN 결과2
--                 ... ... 
--                 ELSE 기본값
--       END
-- SQL구문에서 if-then-else의 논리를 적용할 수 있는 연산자
select employee_id, last_name, department_id, 
       case department_id when 10 then '부서 10' 
                          when 50 then '부서 50' 
                          when 100 then '부서 100' 
                          when 150 then '부서 150' 
                          when 200 then '부서 200' 
                          else '기타 부서' 
		end as "부서 정보"
from employees;

-- 시스템 정보 함수
-- user(), current_user(), session_user() : 사용자 정보
-- database(), schema() : 데이터베이스 정보
-- version() : mysql 버전 정보
select user(), current_user(), session_user();
select database(), schema();
select version();

-- (연습문제)
-- 1. 
select last_name, ifnull(commission_pct, 'No Commission') COMM
from employees;
-- (==)
select last_name, if(commission_pct is not null, commission_pct, 'No Commission') COMM
from employees;
-- (==)
select last_name, if(commission_pct is null, 'No Commission', commission_pct) COMM
from employees;

-- 2. 
select employee_id, last_name, job_id, CASE job_id WHEN 'AD_PRES' THEN 'A'
													WHEN 'ST_MAN' THEN 'B'
													WHEN 'IT_PROG' THEN 'C'
													WHEN 'SA_REP' THEN 'D'
													WHEN 'ST_CLERK' THEN 'E'
													ELSE '0' END as "GRADE"
from employees;
