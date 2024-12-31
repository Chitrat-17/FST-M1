-- ACTIVITY 5
UPDATE salesmen 
SET grade = 200
WHERE salesman_city = 'Rome';

UPDATE salesmen 
SET grade = 300
WHERE salesman_name = 'James Hoog';

UPDATE salesmen 
SET salesman_name = 'Pierre'
WHERE salesman_name = 'McLyon';

SELECT * FROM salesman;
