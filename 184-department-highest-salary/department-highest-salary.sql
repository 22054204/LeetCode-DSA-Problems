# Write your MySQL query statement below
select t2.name as Department, t1.name as Employee, t1.salary as Salary from Employee t1
Join Department t2
ON t1.departmentId = t2.id
WHERE t1.salary = (
    SELECT MAX(t2.salary)
    FROM Employee t2
    WHERE t2.departmentId = t1.departmentId
);