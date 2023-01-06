-- [SQL문법] 4. 조인(join)
-- 여러 테이블의 데이터를 함께 출력하는 방법
use hr;
-- employees 테이블 : 직원 정보가 저장된 테이블
desc employees;
select employee_id, last_name, salary, department_id
from employees;

-- departments 테이블 : 부서 정보가 저장된 테이블
desc departments;
select department_id, department_name
from departments;

-- 사원들의 employee_id, last_name, salary, department_id, department_name을
-- 함께 출력하시오.(employees, departments 테이블 사용)
select employee_id, last_name, salary, employees.manager_id, 
       departments.department_id, department_name
from employees join departments
on employees.department_id = departments.department_id;

-- department_id, department_name과 부서가 위치하고 있는 city명을
-- 함께 출력하시오.(departments, locations 테이블 사용)
select department_id, department_name, city
from departments join locations
on departments.location_id = locations.location_id
order by department_id;

-- 사원들의 정보(employee_id, last_name, job_id)와 
-- 담당업무의 전체 이름(job_title)을 함께 출력하시오.(employees, jobs 테이블 사용)
select employee_id, last_name, employees.job_id, job_title
from employees join jobs
on employees.job_id = jobs.job_id;

-- 테이블 alias 활용하기
-- employees 테이블과 departments 테이블을 사용해서 employee_id, last_name,
-- salary, job_id, department_id, department_name을 함께 출력하시오.
-- [방법1]
select employee_id, last_name, salary, job_id, 
       employees.department_id, department_name
from employees join departments
on employees.department_id = departments.department_id;

-- [방법2] 
select employees.employee_id, employees.last_name, employees.salary, 
       employees.job_id, employees.department_id, departments.department_name
from employees join departments
on employees.department_id = departments.department_id;

-- [방법3]  테이블 alias 활용
select e.employee_id, e.last_name, e.salary, 
       e.job_id, e.department_id, d.department_name
from employees e join departments d
on e.department_id = d.department_id;

-- N개의 테이블 조인하기
--  테이블수  | 조인조건수
-- -------------------
--    2          1
--    3          2
--    N         N-1
-- employees, departments, locations 테이블 사용해서
-- 직원 정보(employee_id, last_name, salary)와 
-- 직원이 소속된 부서 정보(department_id, department_name)와
-- 부서의 위치 정보(location_id, city)를 함께 출력하시오.
select e.employee_id, e.last_name, e.salary, d.department_id,
       d.department_name, l.location_id, l.city
from employees e join departments d 
on e.department_id = d.department_id
join locations l
on d.location_id = l.location_id;

-- Self-join(자체조인)
-- 자기 자신 테이블과 조인하는 유형
-- 하나의 테이블을 마치 다른 테이블인듯 테이블 alias를 다르게 부여해서 조인을 진행함.

-- employees 테이블로부터 사원들의 정보(employee_id, last_name, manager_id)와 
-- 매니저의 이름를 함께 출력하시오.
select e1.employee_id, e1.last_name as "직원 이름", 
       e1.manager_id, e2.last_name as "매니저 이름"
from employees e1 join employees e2
on e1.manager_id = e2.employee_id;

-- <연습문제>
-- 1.
select e.employee_id, e.last_name, e.salary, e.department_id, d.department_name
from employees e join departments d
on e.department_id = d.department_id;
-- (==)
select e.employee_id, e.last_name, e.salary, d.department_id, d.department_name
from employees e join departments d
on e.department_id = d.department_id;

-- 2.
select e1.last_name as "Employee", e1.employee_id as "Emp#", 
       e2.last_name as "Manager", e1.manager_id as "Mgr#" 
from employees e1 join employees e2
on e1.manager_id = e2.employee_id;
-- (==)
select e1.last_name as "Employee", e1.employee_id as "Emp#", 
       e2.last_name as "Manager", e2.employee_id as "Mgr#" 
from employees e1 join employees e2
on e1.manager_id = e2.employee_id;

-- [오답] 직원 정보와 직원의 매니저 이름과 매니저의 매니저 ID가 출력되는 구문임.
select e1.last_name as "Employee", e1.employee_id as "Emp#", 
       e2.last_name as "Manager", e2.manager_id as "Mgr#" 
from employees e1 join employees e2
on e1.manager_id = e2.employee_id;

-- <추가 연습문제> : "hr" 데이터베이스 사용
-- employees 테이블과 departments 테이블을 사용하여 작업하시오.
-- 부서정보(department_id, department_name, manager_id)와
-- 부서의 매니저 이름(last_name)을 함께 출력하시오.
select d.department_id, d.department_name, 
       d.manager_id as "부서 매니저 ID", e.last_name as "부서 매니저 이름"
from departments d join employees e
on d.manager_id = e.employee_id;

select d.department_id, d.department_name, 
       d.manager_id as "부서 매니저 ID", e.last_name as "부서 매니저 이름"
from  employees e join departments d
on e.employee_id = d.manager_id;

-- <추가 연습문제> : "hr" 데이터베이스 사용
-- employees 테이블과 departments 테이블을 사용하여 작업하시오.
-- 직원 정보(employee_id, last_name, salary)와
-- 직원이 소속된 부서정보(department_id, department_name, manager_id)와
-- 각 부서의 매니저 이름(last_name)을 함께 출력하시오.
select e.employee_id, e.last_name as "직원 이름", e.salary, 
       d.department_id, d.department_name, d.manager_id,
       m.last_name as "부서의 매니저 이름" 
from employees e join departments d
on e.department_id = d.department_id
join employees m
on d.manager_id = m.employee_id
order by e.employee_id;

-- <조인 추가 문법>
-- inner join : 내부조인, 조인조건을 만족하는 행만 반환함.
-- outer join : 외부조인, 조인조건을 만족하는 행과 만족하지 않는 행까지 반환함.
--              종류 : left outer join, right outer join

-- inner join(기본 조인 유형) 결과
-- 106행 출력
-- emp - 부서를 배정 받지 못한 직원 1명 미출력
-- dept - 소속된 직원이 없는 빈부서 16개 미출력
select e.employee_id, e.last_name, e.salary, 
       e.department_id, d.department_name
from employees e join departments d
on e.department_id = d.department_id;

-- left outer join 결과
-- 107행 출력
-- emp - 왼쪽 테이블인 employess 테이블의 모든 행 출력
-- dept - 소속된 직원이 없는 빈부서 16개 미출력
select e.employee_id, e.last_name, e.salary, 
       e.department_id, d.department_name
from employees e left outer join departments d
on e.department_id = d.department_id;

-- right outer join 결과
-- 122행 출력 (106행 + 16행(빈부서))
-- emp - 부서를 배정 받지 못한 직원 1명 미출력
-- dept - 오른쪽 테이블인 departments 테이블의 모든 행 출력
select e.employee_id, e.last_name, e.salary, 
       e.department_id, d.department_name
from employees e right outer join departments d
on e.department_id = d.department_id;

-- <추가 연습문제> : "shopdb" 데이터베이스 사용
desc members;
select * from members;

desc products;
select * from products;

desc orders;
select * from orders;

-- 1. members, orders 테이블 사용
-- 주문 정보(order_num, member_id, order_date)와
-- 주문자의 정보(member_name, phone, address)를 함께 출력하시오.
-- 출력형식 : order_num, order_date, member_id, member_name, phone, address
select o.order_num, o.order_date, o.member_id, 
       m.member_name, m.phone, m.address
from orders o join members m
on o.member_id = m.member_id;

-- 2. products, orders 테이블 사용
-- 주문 정보(order_num, member_id, prod_id, order_date)와
-- 제품 정보(prod_name, price)를 함께 출력하시오.
-- 출력형식 : order_num, member_id, prod_id, prod_name, price, order_date
select o.order_num, o.member_id, o.prod_id,
       p.prod_name, p.price, o.order_date
from orders o join products p
on o.prod_id = p.prod_id
order by order_num;

-- 3. members, products, orders 테이블 사용
-- 주문 정보(order_num, order_date)와
-- 주문자의 정보(member_name, phone, address)와
-- 주문한 제품의 정보(prod_name, price, company)을 함께 출력하시오.
-- 출력 형식 : order_num, order_date, member_name, phone, address, 
--           prod_name, price, company
select o.order_num, o.order_date, m.member_name, m.phone, m.address,
       p.prod_name, p.price, p.company
from orders o join members m
on o.member_id = m.member_id
join products p
on o.prod_id = p.prod_id
order by o.order_num;