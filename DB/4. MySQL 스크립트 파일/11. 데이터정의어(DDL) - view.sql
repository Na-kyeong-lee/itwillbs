-- [SQL문법] - 데이터정의어(DDL) - view(뷰)
use hr;
-- view란?
-- 데이터베이스 객체(object) 유형 중 하나임.
-- 하나 이상의 테이블을 기준(기반)으로 생성은 되나 물리적으로 존재하지 않고
-- DB사전에 정의만 되어 있는 가상의 논리적인 테이블임.
-- 사용 목적 : 공간효율성, 보안성, 편의성

-- 1. 뷰 생성 : create view
-- [문법] create view 뷰명
--       as select 컬럼명1, 컬럼명2, 컬럼명3
--          from 테이블명
--          where 조건문;

-- (예제1)
create view empvu80
as select employee_id, last_name, salary, department_id
   from employees
   where department_id = 80;
   
desc empvu80;

select *
from empvu80;

-- (예제2)
create view deptvu
as select *
   from departments
   where department_id > 200; 
   
desc deptvu;

select *
from deptvu;

-- 뷰를 통한 insert 작업 => 결론적으로 base table에 삽입됨.
insert into deptvu
values (350, 'AAA', null, 1700);

select *
from deptvu;

select *
from departments;

-- (예제3) 보안성 예제
use shopdb;

create view member_vu
as select member_id, member_name, birth, job
   from members;
 
desc member_vu;

select *
from member_vu;

-- (예제4) 편의성 예제
use hr;

create view dept_sal_vu
as select d.department_name, sum(e.salary) as "급여 합계", 
          avg(e.salary) as "급여 평균", min(e.salary) as "최소 급여", 
		  max(e.salary) as "최대 급여"
   from employees e join departments d
   on e.department_id = d.department_id
   group by d.department_name
   order by d.department_name;
 
desc dept_sal_vu; 

select *
from dept_sal_vu;

-- 2. 뷰 수정 : alter view
alter view empvu80
as select employee_id, last_name, salary, email, department_id
   from employees
   where department_id = 80; 

desc empvu80;
   
select *
from empvu80;

-- 3. 뷰 수정 : drop view
-- 뷰를 삭제하더라도 base table의 데이터에 미치는 영향은 없음.
drop view empvu80;

-- 4. 뷰 정보 조회
use information_schema;

show tables; 

select *
from views
where table_schema = 'hr';

select *
from views
where table_schema = 'shopdb';