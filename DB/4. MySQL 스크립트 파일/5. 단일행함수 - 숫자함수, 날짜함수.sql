-- [SQL문법] 5-2. 단일행함수 - 숫자함수, 날짜함수
use hr;
-- 숫자함수
-- ROUND(숫자, 반올림할 자리) : 숫자를 반올림할 자리까지 반올림을 해주는 함수
-- TRUNCATE(숫자, 버림할 자리) : 숫자를 버림할 자리까지 남기고 버림을 해주는 함수
-- (숫자)  1    2    3   .   4   5   6
-- (자리) -2   -1    0       1   2   3

select round(45.923, 2), round(45.923, 0), round(45.923, -1);
select truncate(45.923, 2), truncate(45.923, 0), truncate(45.923, -1);

-- [예제]
-- employees 테이블로부터 last_name과 급여 액수를 별표(*)로 나타내는 query를 작성하시오. 
-- 각 별표는 $1,000를 의미하며 백단위 이하는 표시하지 않습니다. 
-- 또한 급여의 내림차순으로 데이터를 정렬하여 출력하고 컬럼 제목(column alias)을 
-- EMPLOYEES_AND_THEIR_SALARIES로 지정하시오.
select concat(last_name, rpad(' ', truncate(salary/1000,0)+1, '*')) 
       as "EMPLOYEES_AND_THEIR_SALARIES"
from employees
order by salary desc;
-- (==)
select concat(last_name, ' ', rpad('*', truncate(salary/1000,0), '*')) 
       as "EMPLOYEES_AND_THEIR_SALARIES"
from employees
order by salary desc;

-- CEIL(숫자) : 숫자보다 크거나 같은 최소의 정수를 반환해 주는 함수
--             일의 자리로 올림을 해주는 함수
-- FLOOR(숫자) : 숫자보다 작거나 같은 최소의 정수를 반환해 주는 함수
--              일의 자리까지 버림을 해주는 함수 (=) truncate(숫자, 0)
select ceil(45.923), ceil(52.1);
select floor(45.923), floor(52.1);

-- MOD(숫자1, 숫자2) : 숫자1을 숫자2로 나눈 나머지를 반환해 주는 함수
select mod(157, 10), 157 mod 10, 157 % 10, 157 / 10;

select last_name, salary, mod(salary, 5000)
from employees
where job_id = 'SA_REP';

-- 값이 짝수인지 홀수인지를 확인하는 용도로도 활용됨. 
select employee_id, mod(employee_id, 2)
from employees;

-- ABS(숫자) : 숫자의 절대 값을 반환해 주는 함수
select abs(-5), abs(5), abs(-4.5);

-- POWER(숫자, 제곱값) = POW(숫자, 제곱값) : 숫자의 제곱 값을 계산하여 반환해 주는 함수
select power(2, 3), power(8, 3);
select power(4, 1), power(4, 2), power(4, 3), power(4, 4), power(4, 5);

-- SIGN(숫자) : 숫자가 양수이면 1, 음수이면 –1, 0이면 0을 반환해 주는 함수
select sign(3), sign(-3), sign(4.26), sign(-4.26), sign(0);

-- 날짜함수
-- now(), sysdate(), current_timestamp() : 현재 날짜와 시간 반환함.
select now(), sysdate(), current_timestamp();

-- current_date() : 현재 날짜 반환함.
-- current_time() : 현재 시간 반환함.
select current_timestamp(), current_date(), current_time();

-- YEAR(날짜) : 날짜/시간에서 년도를 반환해 주는 함수
-- MONTH(날짜) : 날짜/시간에서 월을 반환해 주는 함수
-- DAY(날짜) : 날짜/시간에서 일을 반환해 주는 함수
-- HOUR(시간) : 날짜/시간에서 시간을 반환해 주는 함수
-- MINUTE(시간) : 날짜/시간에서 분을 반환해 주는 함수
-- SECOND(시간) : 날짜/시간에서 초를 반환해 주는 함수
select now(), year(now()), month(now()), day(now()), 
       hour(now()), minute(now()), second(now());
       
select last_name, hire_date, year(hire_date), month(hire_date), day(hire_date)
from employees
where department_id = 90;

-- [예제] employees 테이블에서 1987년에 입사한 사원들의 employee_id, last_name,
-- hire_date, salary를 출력하시오.
-- [방법1] between 연산자
select employee_id, last_name, hire_date, salary
from employees
where hire_date between '1987-01-01' and '1987-12-31';

-- [방법2] like 연산자
select employee_id, last_name, hire_date, salary
from employees
where hire_date like '1987%';

-- [방법3] year() 함수
select employee_id, last_name, hire_date, salary
from employees
where year(hire_date) = 1987;

-- DATE(날짜와 시간) : 날짜/시간에서 날짜를 반환해 주는 함수(년/월/일)
-- TIME(날짜와 시간) : 날짜/시간에서 시간을 반환해 주는 함수(시/분/초)
select now(), date(now()), time(now());

-- ADDDATE(날짜, 차이) = DATE_ADD(날짜, 차이) : 날짜에서 차이를 더한 날짜를 반환해 주는 함수
-- SUBDATE(날짜, 차이) = DATE_SUB(날짜, 차이) : 날짜에서 차이를 뺀 날짜를 반환해 주는 함수
select adddate('2022-01-01', interval 35 day), 
       adddate('2022-01-01', interval 2 month), 
       date_add('2022-01-01', interval 1 year);
       
select subdate('2022-01-01', interval 35 day), 
       subdate('2022-01-01', interval 2 month), 
       date_sub('2022-01-01', interval 1 year);
       
select last_name, hire_date, 
	   adddate(hire_date, interval 6 month) as "입사 6개월 후", 
       subdate(hire_date, interval 7 day) as "입사 7일전"
from employees
where department_id = 60;

-- ADDTIME(날짜와 시간, 시간) : 날짜/시간에서 시간을 더한 결과를 반환하는 함수
-- SUBTIME(날짜와 시간, 시간) : 날짜/시간에서 시간을 뺀 결과를 반환하는 함수
select addtime('2022-01-01 23:59:59', '1:1:1'), addtime('15:00:00', '2:10:10');
select subtime('2022-01-01 23:59:59', '1:1:1'), subtime('15:00:00', '2:10:10');

-- DATEDIFF(날짜1, 날짜2) : 날짜1 - 날짜2를 반환하는 함수
-- TIMEDIFF(시간1, 시간2) : 시간1 – 시간2를 반환하는 함수 
select datediff('2022-12-31', now()), abs(datediff(now(), '2022-12-31'));
select timediff('23:23:59', '12:11:10'), timediff('12:11:10', '23:23:59');

select last_name, hire_date, datediff(now(), hire_date) as "근무한 일수"
from employees;

-- DAYOFWEEK(날짜) : 날짜의 요일을 반환해 주는 함수
--                  (1-일, 2-월, 3-화, 4-수, 5-목, 6-금, 7-토)
-- MONTHNAME(날짜) : 날짜의 월의 영문 이름을 반환해 주는 함수
-- DAYOFYEAR(날짜) : 날짜가 1년 중 몇 번째 날짜인지를 반환해 주는 함수
select dayofweek(now()), monthname(now()), dayofyear(now());

select employee_id, last_name, hire_date, monthname(hire_date)
from employees;

-- LAST_DAY(날짜) : 날짜가 속한 월의 마지막 날짜를 반환하는 함수
select last_day(now());
select last_day('2022-04-03');

select employee_id, last_name, hire_date, last_day(hire_date)
from employees;

-- QUARTER(날짜) : 날짜가 4분기 중에서 몇 분기인지를 반환하는 함수
select quarter('2022-01-31'), quarter('2022-02-05'), quarter('2022-03-15'), 
       quarter('2022-04-02'), quarter('2022-05-10'), quarter('2022-06-25'), 
       quarter('2022-07-10'), quarter('2022-08-09'), quarter('2022-09-16'), 
       quarter('2022-10-14'), quarter('2022-11-11'), quarter('2022-12-25');
       
-- <연습문제>
-- 1.
select employee_id, last_name, salary, round(salary*1.155, 0) as "New Salary"
from employees;
       
-- 2.        
select employee_id, last_name, salary, round(salary*1.155, 0) as "New Salary",
       round(salary*0.155, 0) as "Increase"
from employees;

-- 3.
select employee_id, last_name, job_id, hire_date, department_id
from employees
where month(hire_date) = 2;

-- 4.
select employee_id, last_name, hire_date, salary, department_id
from employees
where year(hire_date) between 1990 and 1995;

-- 5.
select last_name, hire_date, datediff(now(), hire_date) as "근무한 일수",
       floor(datediff(now(), hire_date)/7) as "근무한 주수"
from employees
where datediff(now(), hire_date)/7 < 1200;

-- 6. 
select employee_id, last_name, hire_date, 
       concat(quarter(hire_date), '분기') as "입사한 분기"
from employees;