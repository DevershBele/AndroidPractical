# DBMS Lab Assignment 2 - Solution Key

## Table References
- client_master
- product_master

## Solutions

### 1. Change the selling price of '1.44 floppy drive'
```sql
UPDATE product_master 
SET sell_price = 1150.00 
WHERE description = '1.44 Drive';
```
**Explanation:** This query updates the sell_price of the product with description '1.44 Drive' to 1150.00.

### 2. Delete client record 0001
```sql
DELETE FROM client_master 
WHERE client_no = '0001';
```
**Explanation:** This removes the record of client with client_no '0001' from the client_master table.

### 3. Change city for client 0005
```sql
UPDATE client_master 
SET city = 'Bombay' 
WHERE client_no = '0005';
```
**Explanation:** Updates the city field to 'Bombay' for the client with client_no '0005'.

### 4. Change balance due for client 0001
```sql
UPDATE client_master 
SET bal_due = 1000 
WHERE client_no = '0001';
```
**Explanation:** Sets the bal_due amount to 1000 for client with client_no '0001'.

### 5. Products with selling price > 1500 and calculate new price
```sql
SELECT description, 
       sell_price AS original_price, 
       sell_price * 15 AS new_price 
FROM product_master 
WHERE sell_price > 1500;
```
**Explanation:** This query:
- Filters products with selling price > 1500
- Shows original price and calculates new price (original * 15)
- Displays description and both prices

### 6. Clients with second letter 'a' in city
```sql
SELECT * FROM client_master 
WHERE city LIKE '_a%';
```
**Explanation:** The underscore (_) represents any single character, followed by 'a' and % for any remaining characters.

### 7. Clients with second letter 'a' in name
```sql
SELECT name FROM client_master 
WHERE name LIKE '_a%';
```
**Explanation:** Similar to previous query but searches in the name field instead of city.

### 8. Products sorted by description
```sql
SELECT * FROM product_master 
ORDER BY description;
```
**Explanation:** Returns all products sorted alphabetically by their description.

### 9. Count total number of orders
```sql
SELECT COUNT(*) AS total_orders 
FROM product_master;
```
**Explanation:** Counts all records in the product_master table.

### 10. Average price of products
```sql
SELECT AVG(sell_price) AS average_price 
FROM product_master;
```
**Explanation:** Calculates the average of sell_price for all products.

### 11. Minimum product price
```sql
SELECT MIN(sell_price) AS minimum_price 
FROM product_master;
```
**Explanation:** Finds the lowest sell_price among all products.

### 12. Maximum and minimum prices with renamed columns
```sql
SELECT MAX(sell_price) AS max_price, 
       MIN(sell_price) AS min_price 
FROM product_master;
```
**Explanation:** 
- Returns both highest and lowest sell_prices
- Renames the output columns as requested

### 13. Count products with price >= 1500
```sql
SELECT COUNT(*) AS expensive_products 
FROM product_master 
WHERE sell_price >= 1500;
```
**Explanation:** Counts the number of products that have a sell_price of 1500 or more.

## Key SQL Concepts Used

1. **Data Modification Commands:**
   - UPDATE: Questions 1, 3, 4
   - DELETE: Question 2

2. **Query Commands:**
   - SELECT
   - WHERE
   - ORDER BY
   - LIKE
   
3. **Aggregate Functions:**
   - COUNT()
   - AVG()
   - MIN()
   - MAX()

4. **String Pattern Matching:**
   - LIKE with wildcards (_, %)

5. **Arithmetic Operations:**
   - Multiplication (*)
   - Column aliasing (AS)

## Best Practices Demonstrated

1. **Clarity:**
   - Clear, readable query structure
   - Proper indentation
   - Meaningful alias names

2. **Safety:**
   - Specific WHERE clauses for updates and deletes
   - Precise condition matching

3. **Efficiency:**
   - Appropriate use of aggregate functions
   - Proper column selection

4. **Style:**
   - Consistent SQL keyword capitalization
   - Clear separation of clauses
   - Proper use of whitespace

