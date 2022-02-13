--###########################################################################################
--09Feb22 Assignment :-
--A. Oracle Synonym
--B. Oracle Sequence
--C. More on Groupings
--###########################################################################################

--###########################################################################################
--(A). Oracle synonyms 

    --racle synonyms that help you create aliases for schema objects such as tables, views, materialized views, sequences, procedures, and stored function.
    --Synonyms provide a level of security by hiding the name and owner of a schema object such as a table or a view.
    --Synonyms can be public or private.
    --A public synonym is accessible to every user in a database and owned by a specified group named PUBLIC 
    --while a private synonym is stored a specific schema owned by a specific user and available only to that user.
--###########################################################################################
SELECT * FROM color;
--###########################################################################################
--CREATE SYNONYM
--Use the Oracle CREATE SYNONYM statement to create an alternative name for a database object
--SYNTAX :-
    --CREATE [OR REPLACE] [PUBLIC] SYNONYM schema.synonym_name
    --FOR schema.object;
--###########################################################################################
CREATE PUBLIC SYNONYM syn_members
    FOR members;

SELECT * FROM syn_members;

----------------------------------------------------------------

CREATE PUBLIC SYNONYM syn_color
    FOR C##ADUSER.color;

SELECT * FROM syn_color;

--###########################################################################################
--Oracle DROP SYNONYM
--###########################################################################################
DROP PUBLIC SYNONYM syn_color;

DROP PUBLIC SYNONYM syn_members;

--###########################################################################################
--(B). Oracle Sequence
    --A sequence is a list of integers in which their orders are important.
--###########################################################################################
CREATE SEQUENCE product_id
INCREMENT BY 1
MAXVALUE 1000
MINVALUE 1
CACHE 20;


CREATE TABLE product(
pid NUMBER PRIMARY KEY,
pname VARCHAR2 (20) NOT NULL
);

INSERT INTO product VALUES (PRODUCT_ID.nextval,'pepsi');
INSERT INTO product VALUES (PRODUCT_ID.nextval,'mazza');
INSERT INTO product VALUES (PRODUCT_ID.nextval,'7up');
INSERT INTO product VALUES (PRODUCT_ID.nextval,'sosyo');

SELECT * FROM product;

--###########################################################################################
--Creating a sequence
    --Note that Oracle 12c automatically generates a sequence object associated with the identity column of the table.
--###########################################################################################

SELECT PRODUCT_ID.currval from product;

--###########################################################################################
--Drop Sequence
--###########################################################################################
DROP SEQUENCE product_id;

--###########################################################################################
--(C). More on Groupings
    --a. Grouping sets – introduce you to the grouping set concepts and show you how to generate multiple grouping sets in a query.
    --b. CUBE – learn how to use CUBE to generate subtotals for all possible combinations of a specified group of dimensions.
    --c. ROLLUP – describe how to calculate multiple levels of subtotals across a specified group of dimensions.
    --d. PIVOT – show you how to transpose rows to columns to make the crosstab reports.
    --e. UNPIVOT – a guide to rotating columns into rows.
--###########################################################################################























