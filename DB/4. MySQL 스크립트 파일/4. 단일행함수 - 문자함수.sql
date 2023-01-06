-- [SQL문법] 5-1. 단일행함수 - 문자함수
-- 함수란? 인수를 받아서 정해진 조작을 한 다음 반드시 하나의 결과를 반환함.
-- SQL함수 유형 : 단일행함수, 다중행함수(=그룹함수)

use hr;

-- ascii(문자) : 문자의 아스키코드값 반환함.
-- char(숫자) : 숫자의 아스키코드값 반환함.
select ascii('A'), char(65);

-- length(문자열) : 문자열의 byte 수
-- bit_length(문자열) : 문자열에 할당된 bit 크기
-- char_length(문자열) : 문자의 개수
select length('abc'), bit_length('abc'), char_length('abc'); 
select length('가나다'), bit_length('가나다'), char_length('가나다'); 

-- CONCAT(문자열1, 문자열2, ...) : 문자열을 연결해 주는 함수
-- CONCAT_WS(구분자, 문자열1, 문자열2, ...) : 구분자와 함께 문자열을 연결해 주는 함수
select employee_id, concat(first_name, last_name) as "이름"
from employees;

select employee_id, concat(first_name, ' ', last_name) as "이름"
from employees;

select employee_id, 
       concat(first_name, ' ',  last_name, ' ', job_id, ' ', email) as "결과값"
from employees;
-- (==)
select employee_id, 
       concat_ws(' ', first_name, last_name, job_id, email) as "결과값"
from employees;

select concat_ws('--', last_name, job_id, salary) as "결과값"
from employees;

-- instr(기준문자열, 특정문자열) : 기준 문자열에서 특정 문자열의 첫번째 위치값 반환함.
select instr('하나둘셋', '둘');
select last_name, instr(last_name, 'a')
from employees;

-- UPPER(문자열) : 문자열을 대문자로 변환해 주는 함수
-- LOWER(문자열) : 문자열을 소문자로 변환해 주는 함수
select lower('abcdEFGH'), upper('abcdEFGH');

select employee_id, upper(last_name) as "L-name", lower(job_id) as "Job", 
       phone_number, lower(email) as "E-mail"
from employees;

select concat('The job id for ' , upper(last_name) , ' is ' , lower(job_id))
from employees;

-- LEFT(문자열, 길이) : 왼쪽에서 문자열의 길이만큼 반환
-- RIGHT(문자열, 길이) : 오른쪽에서 문자열의 길이만큼 반환
select last_name, left(last_name, 2), right(last_name, 2)
from employees;

-- LPAD(문자열, 길이, 채울 문자) : 문자열을 길이만큼 늘린 후 빈곳을 왼쪽부터 
--                            채울 문자로 채워주는 함수, 오른쪽 정렬 함수
-- RPAD(문자열, 길이, 채울 문자) : 문자열을 길이만큼 늘린 후 빈곳을 오른쪽부터 
--                            채울 문자로 채워주는 함수, 왼쪽 정렬 함수
select lpad('가나다', 5, '#'), rpad('가나다', 5, '#');
select lpad(last_name, 20, '_') as "L-name", 
       rpad(first_name, 20, '_') as "F-name"
from employees;

-- LTRIM(문자열) : 문자열의 왼쪽 공백을 제거해 주는 함수
-- RTRIM(문자열) : 문자열의 오른쪽 공백을 제거해 주는 함수
-- TRIM(문자열) 문자열의 앞/뒤 공백을 제거해 주는 함수
-- TRIM(방향 자를문자열 FROM 문자열) : 문자열로부터 해당 방향의 자를 문자열을 제거함.
--                                leading(앞), trailing(뒤), both(양쪽)
select ltrim(' SQL 문법 '), rtrim(' SQL 문법 ');
select trim(' SQL 문법 '), trim(both '_' from '__SQL_문법___');

-- REPLACE(문자열, 기존문자열, 바꿀문자열) : 문자열에 기존 문자열을 바꿀 문자열로 교체함.
select employee_id, phone_number, replace(phone_number, '.', '-') as "전화번호"
from employees;

-- SPACE(길이) : 길이만큼의 공백을 반환해 주는 함수
select concat('MySQL', space(10), 'DBMS');

-- SUBSTR(문자열, 시작위치, 길이) : 문자열의 일부분을 반환해 주는 함수
select substr('대한민국만세', 3, 2);
select last_name, substr(last_name, 2, 3), substring(last_name, 2, 3)
from employees;

-- 시작위치에 음수가 있는 경우 : 시작위치를 끝에서부터 찾아옴.
select last_name, substr(last_name, -3, 2)
from employees;

-- 반환할 문자수가 생략된 경우 : 시작위치에서 끝까지 반화됨.
select last_name, substr(last_name, 3)
from employees;

-- <연습문제>
-- 1.
SELECT last_name as "Name", LENGTH(last_name) as "Length"
FROM employees
WHERE last_name LIKE 'J%'
OR last_name LIKE 'M%'
OR last_name LIKE 'A%'
ORDER BY last_name;

-- 2.
SELECT last_name, LPAD(salary, 15, '$') as SALARY
FROM employees;

-- 3.
-- 백의 자리는 반올림해서 처리하는 방식
SELECT salary, CONCAT(last_name, RPAD(' ', salary/1000+1, '*')) 
       as EMPLOYEES_AND_THEIR_SALARIES
FROM employees
ORDER BY salary DESC;

-- 백의 자리는 버림해서 처리하는 방식
SELECT salary, CONCAT(last_name, RPAD(' ', truncate(salary/1000,0)+1, '*')) 
       as EMPLOYEES_AND_THEIR_SALARIES
FROM employees
ORDER BY salary DESC;