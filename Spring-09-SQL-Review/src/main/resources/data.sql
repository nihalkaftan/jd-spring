SELECT *
FROM departments;

SELECT *
FROM employees;

SELECT *
FROM regions;

SELECT employee_id,first_name,department
FROM employees;

SELECT *
FROM employees
WHERE department = 'Sports';

SELECT *
FROM employees
WHERE department LIKE '%unit%';

SELECT *
FROM employees
WHERE department LIKE 'F%unit%';

SELECT *
FROM employees
WHERE salary>100000;

SELECT *
FROM employees
WHERE salary<100000;

SELECT *
FROM employees
WHERE salary>=100000;

SELECT *
FROM employees
WHERE salary<=100000;

SELECT *
FROM employees
WHERE department='Clothing'
AND salary>90000;

SELECT *
FROM employees
WHERE department='Clothing'
AND salary>90000
AND region_id=2;

SELECT *
FROM employees
WHERE department='Clothing'
OR salary>90000;

SELECT *
FROM employees
WHERE salary<40000
AND (department='Clothing'
OR department='Pharmacy');

SELECT *
FROM employees
WHERE department != 'Sports';

SELECT *
FROM employees
WHERE department <> 'Sports';

SELECT *
FROM employees
WHERE NOT department <> 'Sports';

SELECT *
FROM employees
WHERE email IS NULL;

SELECT *
FROM employees
WHERE email IS NOT NULL;

SELECT *
FROM employees
WHERE department='Sports'
OR department='First Aid'
OR department='Toys'
OR department='Garden';

SELECT *
FROM employees
WHERE department IN ('Sports', 'First Aid', 'Toys');

SELECT *
FROM employees
WHERE salary BETWEEN 80000 AND 100000;

--Write a query that return a first name and the email of females that work in the tools department
-- having a salary greater than 110000

SELECT first_name
FROM employees
WHERE gender='F'
AND department='Tools'
AND salary>110000;

--Write a query that return first name and hire date of those who are more than 165000
-- as well as those employees that work in the sports department and also happens to be man
SELECT *
FROM employees
WHERE salary>165000
OR (department='Sports' AND gender='M');

SELECT *
FROM employees
ORDER BY employee_id DESC;

SELECT DISTINCT department
FROM employees;

SELECT DISTINCT department
FROM employees
FETCH FIRST 3 ROWS ONLY;

SELECT salary as yearly_salary
FROM employees;

--Write a query that displays the name and the ages of the top 4 of all the students
SELECT *
FROM students
ORDER BY age DESC
FETCH FIRST 4 ROWS ONLY;

--Write a query that returns students based on the following criteria:
--the student must not be older than age 20 if their student_no is either between 3 and 5
--or their student_no is 7.
-- Your query should also return students older thn age 20 but in that case4= they must
--have a student_no that is at least 4

SELECT *
FROM students
WHERE age<=20
AND (student_no BETWEEN 3 and 5 OR student_no=7)
OR (age>20 AND student_no>=4);

SELECT UPPER(first_name) FIRST_NAME, LOWER(department) DEPARTMENT
FROM employees;

SELECT LENGTH(first_name)
FROM employees;

SELECT TRIM('   Hello there       ');

SELECT LENGTH('   Hello there       ');

SELECT LENGTH(TRIM('   Hello there       '));

SELECT first_name || ' ' || last_name as full_name
FROM employees;

SELECT salary>140000
FROM employees;

SELECT (salary>140000) AS highest_paid
FROM employees
ORDER BY salary DESC;

SELECT department, (department LIKE '%oth%')
FROM employees;

SELECT 'This is test data' test_data;

-- find + By + Name() :
SELECT *
FROM employees
WHERE first_name='Nihal';

SELECT SUBSTRING('this is test data' FROM 1 FOR 4) as test_data;

SELECT SUBSTRING('this is test data' FROM 9) as test_data;

SELECT department, REPLACE(department,'Clothing', 'Clothes')
FROM departments;

SELECT MAX(salary)
FROM employees;

SELECT MIN(salary)
FROM employees;

SELECT AVG(salary)
FROM employees;

SELECT ROUND(AVG(salary))
FROM employees;

SELECT COUNT(employee_id)
FROM employees;

SELECT COUNT(email)
FROM employees;

SELECT SUM(salary)
FROM employees
WHERE department='Clothing';

--write a query that returns all of the records and columns from the professor table
--but shortens the department names to only the first three characters in upper case
SELECT last_name, UPPER(SUBSTRING(department,1,3)) as department,salary,hire_date
FROM professors;

--write a query that returns the highest and lowest salary from the professors table excluding the professor named "wilson"
SELECT MAX(salary) max_salary, MIN(salary) min_salary
FROM professors
WHERE last_name != 'Wilson';

SELECT COUNT(*),department
FROM employees
GROUP BY department;

SELECT SUM(salary) total_salary,department
FROM employees
GROUP BY department;

SELECT MIN(salary) min_salary, MAX(salary) max_salary, AVG(salary) as avarage_salary,COUNT(*) total_number_employees,department
FROM employees
GROUP BY department;

SELECT SUM(salary) as total_salary, department
FROM employees
WHERE region_id IN(4,5,6,7)
GROUP BY department;

SELECT department, COUNT(*)
FROM employees
GROUP BY department
ORDER BY department;

SELECT department, COUNT(*)
FROM employees
GROUP BY department
HAVING COUNT(*)<20
ORDER BY department;

-- show all unique domain and number of employees

SELECT COUNT(*),SUBSTRING(email,POSITION('@' IN email)+1) email_domain
FROM employees
WHERE email IS NOT NULL
GROUP BY email_domain;

SELECT e.department, d.department
FROM employees e, departments d;

SELECT department
FROM employees;

SELECT department
FROM departments;

SELECT *
FROM employees
WHERE department NOT IN('Grocery', 'Decor','Sports','Garden');

SELECT *
FROM employees
WHERE department NOT IN(SELECT department FROM departments);

SELECT *
FROM (SELECT * FROM employees WHERE salary>150000) a;

-- Return all employees that work in electronics division

SELECT *
FROM departments;

SELECT *
FROM employees
WHERE department IN (SELECT department FROM departments WHERE division='Electronics');

-- return all employees work in ASIA or CANADA and make more than 130000

SELECT *
FROM employees
WHERE region_id IN(SELECT region_id FROM regions WHERE country='Asia' OR country='Canada');

-- first work in ASIA or CANADA name and how much less making from the highest paid employee in the company

SELECT first_name, (SELECT MAX(salary) FROM employees) - salary
FROM employees
WHERE region_id IN(SELECT region_id FROM regions WHERE country='Asia' OR country='Canada');

-- write a query that return all of those employees that work in the kids division and
-- the dates at which those employees were hired is grater than all the hire dates of employees
-- who work in the maintenance department

SELECT *
FROM employees;

SELECT *
FROM departments;

SELECT *
FROM employees
WHERE department = ANY (SELECT department FROM departments WHERE division='Kids')
AND hire_date > ALL (SELECT hire_date FROM employees WHERE department = 'Maintenance');

-- Write a query that returns the names of those students that are taking the courses Physics and US History

SELECT *
FROM students;

SELECT *
FROM student_enrollment;

SELECT *
FROM courses;

SELECT student_name
FROM students
WHERE student_no IN (SELECT student_no FROM student_enrollment WHERE course_no IN(SELECT course_no FROM courses WHERE course_title = 'Physics' OR course_title = 'US History'))

SELECT student_name
FROM students
WHERE student_no IN
      (SELECT student_no
      FROM student_enrollment
      WHERE course_no IN
            (SELECT course_no
            FROM courses
            WHERE course_title IN( 'Physics','US History')));

SELECT first_name, salary,
CASE
    WHEN salary < 100000 THEN 'UNDER PAID'
    WHEN salary > 100000 THEN 'PAID WELL'
    ELSE 'UNPAID'
END as category
FROM employees;


SELECT category, COUNT(*)
FROM (SELECT first_name, salary,
    CASE
        WHEN salary < 100000 THEN 'UNDER PAID'
        WHEN salary > 100000 AND salary< 160000 THEN 'PAID WELL'
        ELSE 'EXECUTIVE'
    END as category
    FROM employees) a
GROUP BY category;

select * from employees;
select * from regions;

SELECT first_name, country, department
FROM employees e,regions r
WHERE r.region_id = e.region_id;

SELECT first_name,email,division, d.department
FROM employees e, departments d, regions r
WHERE e.department = d.department
AND e.region_id = r.region_id;

SELECT first_name, country
FROM employees INNER JOIN regions
ON employees.region_id=regions.region_id;

SELECT first_name, email, division
FROM employees e INNER JOIN departments d
ON e.department=d.department
WHERE email IS NOT NULL;

SELECT first_name, email, country
FROM employees e INNER JOIN departments d
ON e.department = d.department INNER JOIN regions r
ON e.region_id=r.region_id
WHERE email IS NOT NULL;

SELECT distinct department FROM employees ; --26
SELECT distinct department FROM departments ; --24

SELECT distinct e.department, d.department
FROM employees e INNER JOIN departments d
ON e.department=d.department;

SELECT distinct e.department, d.department
FROM employees e LEFT JOIN departments d
ON e.department=d.department;

SELECT distinct e.department, d.department
FROM employees e RIGHT JOIN departments d
ON e.department=d.department;

SELECT distinct e.department, d.department
FROM employees e FULL JOIN departments d
ON e.department=d.department;

SELECT department
from employees
UNION
select department
from departments;

SELECT department
from employees
UNION
select department
from departments
UNION
SELECT country
FROM regions;

SELECT department
from employees
UNION ALL
select department
from departments;

SELECT department
from employees
EXCEPT
select department
from departments;