SELECT IFNULL(
    (SELECT DISTINCT salary
     FROM (
         SELECT DISTINCT salary, DENSE_RANK() OVER (ORDER BY salary DESC) AS rnk
         FROM Employee
     ) ranked
     WHERE rnk = 2),
    NULL
) AS SecondHighestSalary;