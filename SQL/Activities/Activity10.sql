-- ACTIVITY 10


select * from orders where salesman_id = (select salesman_id from orders where customer_id = 3007);

select * from orders where salesman_id IN (select salesman_id from salesman where salesman_city = 'New York');

select grade, count(*) headcount from customers group by grade having grade> (select avg(grade) from customers where CITY = 'New York'  group by city);

select * from orders where salesman_id  IN (select salesman_id from salesman where commission = (select max(commission) from salesman));