# Write your MySQL query statement below

SELECT T1.name as Employee FROM Employee as T1,Employee as T2 Where(
    T1.managerId=T2.id and T1.salary>T2.salary
)