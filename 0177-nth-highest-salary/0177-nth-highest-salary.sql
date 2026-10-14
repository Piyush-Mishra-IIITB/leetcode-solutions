CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      

      with t as(
        select id,salary,
         Dense_Rank() over( order by salary desc) as no 
        from Employee 
      )
      select salary 
      from t
      where no=N
      limit 1

  );
END