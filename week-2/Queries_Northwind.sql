--###########################################################################################################################
--1. Get a list of latest order IDs for all customers by using the max function on Order_ID column.
--###########################################################################################################################
SELECT 
    t.customerid,t.orderid,t.orderdate
FROM 
    orders t
    INNER JOIN(
        SELECT customerid, MAX(orderdate) as latestdate
        FROM orders m
        GROUP BY customerid
    ) tm ON t.customerid = tm.customerid AND t.orderdate = tm.latestdate;
    
--###########################################################################################################################
--2. Find suppliers who sell more than one product to Northwind Trader.
--###########################################################################################################################   
SELECT
    SupplierId,COUNT(productid)
FROM
    Products
GROUP BY
    SupplierId
HAVING
    COUNT( productid) > 1;
    
--###########################################################################################################################
--3. Create a function to get latest order date for entered customer_id
--########################################################################################################################### 
SELECT
    CustomerID, OrderDate
FROM
    Orders
Order by
    OrderDate DESC;

--###########################################################################################################################
--4. Get the top 10 most expensive products.
--########################################################################################################################### 
SELECT
  productname,unitprice
FROM
    (
        SELECT productname,unitprice FROM products ORDER BY unitprice desc 
    )
WHERE 
    rownum<=10;

--###########################################################################################################################
--5. Rank products by the number of units in stock in each product category.
--###########################################################################################################################
SELECT
    productname,categoryid,unitsinstock,
    RANK() OVER(PARTITION BY categoryid ORDER BY unitsinstock desc)
FROM 
    products
ORDER BY
    categoryid,unitsinstock desc;

--###########################################################################################################################
--6. Rank customers by the total sales amount within each order date
--###########################################################################################################################
SELECT
   customerid,categoryid,unitsinstock,
    RANK() OVER(PARTITION BY categoryid ORDER BY unitsinstock desc)
FROM 
    products
ORDER BY
    categoryid,unitsinstock desc;

--###########################################################################################################################
--7. Rank customers by the total sales amount within each order date
--###########################################################################################################################
SELECT orderid,SUM(UnitPrice * Quantity * (1 - Discount)) AS subtotal
FROM orderdetails
GROUP BY
    orderid
ORDER BY
    orderid;

--###########################################################################################################################
--8. Sales by Year for each order.
--###########################################################################################################################
SELECT
    orders.shippeddate,orders.orderid,SUM(orderdetails.unitprice *orderdetails.quantity * (1 - orderdetails.discount)) AS subtotal 
FROM
    orderdetails JOIN orders
    ON orderdetails.orderid = orders.orderid
ORDER BY
    orders.orderid;

--###########################################################################################################################
--9. Get Employee sales by country names
--###########################################################################################################################
SELECT DISTINCT b.*, a.CategoryName
FROM 
    Categories a 
    INNER JOIN Products b
    ON a.CategoryID = b.CategoryID
WHERE
    b.Discontinued = 'N'
ORDER BY 
    b.ProductName;

--###########################################################################################################################
--10. Alphabetical list of products
--###########################################################################################################################
SELECT
    productid,productname,supplierid,categoryid,quantityperunit,unitprice
FROM
    products
ORDER BY
    productname;
    
--###########################################################################################################################
--11. Display the current Productlist
--###########################################################################################################################
SELECT
    productid,productname
FROM
    products
WHERE
    discontinued=1
ORDER BY
    productname;
    
--###########################################################################################################################
--12. Calculate sales price for each order after discount is applied.
--###########################################################################################################################
SELECT DISTINCT
    o.orderid, o.productid,  p.productname, o.unitprice,  o.quantity,  o.discount, 
    ROUND(o.unitprice * o.quantity * (1 - o.discount), 2) AS extendedprice
FROM 
    products p INNER JOIN orderdetails o 
    ON p.productid = o.productid
ORDER BY
    o.orderid;

--###########################################################################################################################
--13. Sales by Category: For each category, we get the list of products sold and the total sales amount..
--###########################################################################################################################
SELECT 
    DISTINCT a.CategoryID, a.CategoryName,  b.ProductName, 
    SUM(ROUND(y.UnitPrice * y.Quantity * (1 - y.Discount), 2)) AS "ProductSales"
FROM
    OrderDetails y
INNER JOIN 
    Orders d
    ON d.OrderID = y.OrderID
INNER JOIN
    Products b
    ON b.ProductID = y.ProductID
INNER JOIN Categories a
    ON a.CategoryID = b.CategoryID
WHERE
    d.OrderDate between date('1997/1/1') and date('1997/12/31')
GROUP BY
    a.CategoryID, a.CategoryName, b.ProductName
ORDER BY
    a.CategoryName, b.ProductName, ProductSales;
-- ###############################################################################################
14.1. vwProducts_Above_Average_Price
Displays products(productname,unitprice) who?s price is greater than avg(price)
-- ###############################################################################################
CREATE VIEW vwProducts_Above_Average_Price
AS 
SELECT 
    DISTINCT ProductName, UnitPrice
FROM
    Products
WHERE
    UnitPrice > (select avg(UnitPrice) from Products)
ORDER BY
    UnitPrice;
-- ###############################################################################################
14.2 vwQuarterly_Orders_by_Product
Display product(productname), customers(companyname), orders(orderyear)
-- ###############################################################################################
CREATE VIEW vwQuarterly_Orders_by_Product
AS
SELECT 
    product.productname, customers.companyname, orders.orderyear
FROM
    product
INNER JOIN 
    

-- ###############################################################################################
14.4 vw10Most_Expensive_Products
Display top 10 expensive products
-- ###############################################################################################
CREATE VIEW vw10Most_Expensive_Products 
AS
SELECT
    ProductName,UnitPrice
FROM
    products
ORDER BY
    UnitPrice DESC
FETCH FIRST 10 ROWS ONLY;




