
-- ################################################################
-- 1.  Display all the information of the EMP table?
-- ################################################################
SELECT
    empno,ename,hiredate,job,mgr,sal,branchno,deptno,comm
FROM
    emp;
    
-- ################################################################
-- 2.  Display unique Jobs from EMP table?
-- ################################################################
SELECT
    DISTINCT job
FROM
    emp;
    
-- ################################################################
-- 3.   List the emps in the asc order of their Salaries?
-- ################################################################
SELECT
    empno,ename,hiredate,job,mgr,sal,branchno,deptno,comm
FROM
    emp
ORDER BY
    sal;

-- ################################################################
-- 4.    List the details of the emps in asc order of the Dptnos and desc of Jobs?
-- ################################################################    
SELECT 
    empno,ename,hiredate,job,mgr,sal,branchno,deptno,comm
FROM 
    emp
ORDER BY 
    deptno,job desc;
    
-- ################################################################
-- 5.     Display all the unique job groups in the descending order?
-- ################################################################   
SELECT 
    DISTINCT job
FROM
    emp
ORDER BY
    job desc;
    
-- ################################################################
-- 6.    Display all the details of all ‘Mgrs’
-- ################################################################    
SELECT 
    empno,ename,hiredate,job,mgr,sal,branchno,deptno,comm
FROM 
    emp
WHERE
    empno IN (SELECT mgr FROM emp);
 
-- ################################################################
-- 7.   List the emps who joined before 1981
-- ################################################################   
SELECT
    empno,ename,hiredate,job,mgr,sal,branchno,deptno,comm
FROM
    emp
WHERE
    hiredate<'01-01-1981';

-- ################################################################
-- 8.    List the Empno, Ename, Sal, Daily sal of all emps in the asc order of Annsal
-- ################################################################   
SELECT
    empno,ename,sal,sal/30 daily_sal,12*sal annsal
FROM
    emp
ORDER BY
    annsal desc;

-- ################################################################
-- 9.   Display the Empno, Ename, job, Hiredate, Exp of all Mgrs
-- ################################################################
SELECT 
    empno,ename,job,hiredate,MONTHS_BETWEEN(SYSDATE,HIREDATE) AS EXP
FROM
    emp
WHERE
    empno IN (SELECT mgr FROM emp);
    

-- ################################################################
-- 10.    List the Empno, Ename, Sal, Exp of all emps working for Mgr 7369
-- ################################################################
SELECT
    empno,ename,sal,MONTHS_BETWEEN(SYSDATE,HIREDATE)  EXP
FROM
    emp
WHERE
    mgr=7369;

-- ################################################################
-- 11.    Display all the details of the emps whose Comm  Is more than their Sal
-- ################################################################
SELECT
     empno,ename,hiredate,job,mgr,sal,deptno,comm
FROM
    emp
WHERE 
    comm>sal;

-- ################################################################
-- 12.    List the emps along with their Exp and Daily Sal is more than Rs 100
-- ################################################################
SELECT 
      empno,ename,hiredate,job,mgr,sal,deptno,comm,MONTHS_BETWEEN(SYSDATE,HIREDATE)  EXP
FROM
    emp
WHERE
    sal/30>100;

-- ################################################################
-- 13.    List the emps along with their Exp and Daily Sal is more than Rs 100
-- ################################################################
SELECT 
      empno,ename,hiredate,job,mgr,sal,deptno,comm,MONTHS_BETWEEN(SYSDATE,HIREDATE)  EXP
FROM
    emp
WHERE
    sal/30>100;

-- ################################################################
-- 14.   List the emps who are either ‘CLERK’ or ‘ANALYST’ in the Desc order
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    job='CLERK' OR job='ANALYST'
ORDER BY
    job desc;
    
-- ################################################################
-- 15.    List the emps who joined on 1-MAY-81,3-DEC-81,17-DEC-81,19-JAN-80 in asc order of seniority
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    hiredate IN ('01-MAY-81','3-DEC-81','17-DEC-81','19-JAN-80')
ORDER BY
    hiredate ;

-- ################################################################
-- 16.    List the emp who are working for the Deptno 10 or20
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE 
    deptno IN (10,20);

-- ################################################################
-- 17.    List the emps who are joined in the year 81
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    hiredate BETWEEN '01-JAN-81' AND '31-DEC-81';

-- ################################################################
-- 18.    List the emps Who Annual sal ranging from 22000 and 45000
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    sal*12 BETWEEN 22000 AND 45000;

-- ################################################################
-- 19.    List the Enames those are having five characters in their Names
-- ################################################################
SELECT
    ename
FROM
    emp
WHERE
    length(ename)=5;
    
-- ################################################################
-- 20.    List the Enames those are starting with ‘S’ and with five characters
-- ################################################################
SELECT 
    ename
FROM 
    emp
WHERE
    ename LIKE 'S%'  AND LENGTH(ename)=5;

-- ################################################################
-- 21.    List the emps those are having four chars and third character must be ‘r’
-- ################################################################
SELECT 
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    LENGTH(ename)=4 AND ename LIKE '__R%';

-- ################################################################
-- 22.    List the Five character names starting with ‘S’ and ending with ‘H’
-- ################################################################
SELECT
    ename,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    LENGTH(ename)=5 AND ename LIKE 'S%H';

-- ################################################################
-- 23.    List the emps who joined in January
-- ################################################################
SELECT
    ename,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    TO_CHAR(hiredate,'MON') = 'JAN';
    
-- ################################################################
-- 24.    List the emps whose names having a character set ‘ll’ together
-- ################################################################
SELECT
    ename,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    ename LIKE '%LL%';

-- ################################################################
-- 25.    List the emps who does not belong to Deptno 20
-- ################################################################
SELECT
    ename,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    deptno NOT IN (20);

-- ################################################################
-- 26.   List all the emps except ‘PRESIDENT’ & ‘MGR” in asc order of Salaries
-- ################################################################
SELECT
    ename,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    job NOT IN ('PRESIDENT' , 'MANAGER')
ORDER BY
    sal;

-- ################################################################
-- 27.    List the emps whose Empno not starting with digit78
-- ################################################################
SELECT
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    empno NOT LIKE '78%';

-- ################################################################
-- 28.   List the emps who are working under ‘MGR’
-- ################################################################
SELECT
    e.ename ,  m.ename
FROM 
    emp e , emp m
WHERE
    e.mgr = m.empno;

-- ################################################################
-- 29.    List the emps who joined in any year but not belongs to the month of March
-- ################################################################
SELECT
    empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    to_char(hiredate,'MON') NOT IN ('MAR');

-- ################################################################
-- 30.    List all the Clerks of Deptno 20
-- ################################################################
SELECT
     empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    job='CLERK' AND deptno=20;

-- ################################################################
-- 31.    List the emps of Deptno 30 or 10 joined in the year 1981
-- ################################################################
SELECT
     empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    to_char(hiredate,'YY')='81' AND ( deptno IN(10,30) );

-- ################################################################
-- 32.   Display the details of SMITH
-- ################################################################
SELECT
     empno,ename,hiredate,job,mgr,sal,comm,deptno
FROM
    emp
WHERE
    ename='SMITH';

-- ################################################################
-- 33.    Display the location of SMITH
-- ################################################################
SELECT
    location
FROM 
    emp JOIN dept
    ON emp.deptno=dept.deptno
    JOIN branch
    ON dept.branchno=branch.branchno
WHERE emp.ename='SMITH';

-- ################################################################ 
--LIST BRANCHNAME,DNAME,SUM OF SAL FOR THOSE BRANCH AND DEPT WHERE THE SUM IS >5000
-- ################################################################ 
SELECT
    branchname,dname,SUM(sal)
FROM
    emp  e JOIN dept d 
    ON e.deptno=d.deptno
    JOIN branch b
    ON d.branchno=b.branchno
GROUP BY
branchname,dname
HAVING
sum(sal)>5000;

