--##################################################################
--Oracle UNIQUE index
--##################################################################

--##################################################################
--use Oracle unique index to prevent duplicate values in the indexed column or columns of a table.
--An index can be unique or non-unique. 
--A unique index ensures that no two rows of a table have duplicate values in the indexed column (or columns). 
--A non-unique index does not impose this restriction on the indexed column’s values.
--##################################################################

--##################################################################
--To create a unique index, you use the CREATE UNIQUE INDEX statement:
--##################################################################
CREATE UNIQUE INDEX  i_members_email
ON members(email);

--##################################################################
--The following statement will fail because it attempts to insert a new row whose email already exists:
--##################################################################
INSERT INTO members(first_name, last_name, gender, dob, email)
VALUES('Pegpa','Elce','F',DATE '1990-01-02','pelce0@trellian.com');

--ERROR :- unique constraint (C##MYWORK.SYS_C008346) violated

--##################################################################
--Oracle UNIQUE index on two columns :
--##################################################################

--##################################################################
--creates a new table named demo with two columns a and b:
--##################################################################
CREATE TABLE demo(
    a INT,
    b INT
); 

--##################################################################
--To create a unique index on the two columns a and b  :
--##################################################################
CREATE UNIQUE INDEX i_demo_ab
ON demo(a,b);

--##################################################################
--Insert new rows in demo table :
--##################################################################
INSERT INTO demo(a,b)
VALUES(1,1);

INSERT INTO demo(a,b)
VALUES(1,2);

--##################################################################
--But when we insert same value to Unique index it shows error :
--##################################################################
INSERT INTO demo(a,b)
VALUES(1,1);

--ERROR :- unique constraint (C##MYWORK.I_DEMO_AB) violated

--##################################################################
--Oracle UNIQUE index, Primary Key constraint, and Unique constraint :-
    --When you define a PRIMARY KEY or a UNIQUE constraint for a table, 
    --Oracle automatically creates a unique index on the primary key or unique key columns to enforce the uniqueness.
    --The unique index associated with the constraint always has the name of the constraint, unless specify it explicitly otherwise.
--##################################################################

CREATE TABLE t1 (
    pk1 INT PRIMARY KEY,
    c1 INT
);

--##################################################################
--To show the indexes of the t1 table, you use the following statement :
--##################################################################
SELECT 
    index_name, 
    index_type, 
    visibility, 
    status 
FROM 
    all_indexes
WHERE 
    table_name = 'T1';
    
--##################################################################
--To specify the name for the primary key column, you use the UNIQUE index as shown in the following query :
--##################################################################
CREATE TABLE t2 (
    pk2 INT PRIMARY KEY 
        USING INDEX (
            CREATE INDEX t1_pk1_i ON t2 (pk2)
    ),
    c2 INT
);

SELECT 
    index_name, 
    index_type, 
    visibility, 
    status 
FROM 
    all_indexes
WHERE 
    table_name = 'T2';

--Instead of generating the index name, Oracle just used the one that we provided during table creation.
--##################################################################





