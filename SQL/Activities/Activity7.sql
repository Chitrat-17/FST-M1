-- ACTIVITY 7

select * from orders;

SELECT SUM(PURCHASE_AMOUNT) total_purchase_amt FROM orders;

SELECT AVG(PURCHASE_AMOUNT) avg_purchase_amt FROM orders;

SELECT MAX(PURCHASE_AMOUNT) max_purchase_amt FROM orders;

SELECT MIN(PURCHASE_AMOUNT) min_purchase_amt FROM orders;

SELECT COUNT(DISTINCT SALESMAN_ID) HEADCOUNT FROM orders;