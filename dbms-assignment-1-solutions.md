# DBMS Lab Assignment 1 - Solutions

## Table Creation and Data Insertion

### Q1. Creating Required Tables

#### i) Client Master Table
```sql
CREATE TABLE client_master (
    client_no VARCHAR2(6),
    name VARCHAR2(20),
    address1 VARCHAR2(30),
    address2 VARCHAR2(30),
    city VARCHAR2(15),
    state VARCHAR2(15),
    pincode NUMBER(6),
    bal_due NUMBER(10,2)
);
```

#### ii) Product Master Table
```sql
CREATE TABLE product_master (
    product_no VARCHAR2(6),
    description VARCHAR2(15),
    profit_percent NUMBER(4,2),
    unit_measure VARCHAR2(10),
    qty_on_hand NUMBER(8),
    reorder_lvl NUMBER(8),
    sell_price NUMBER(8,2),
    cost_price NUMBER(8,2)
);
```

### Q2. Data Insertion

#### Client Master Data
```sql
INSERT INTO client_master VALUES 
('0001', 'Ivan', 'Bombay', NULL, 'Bombay', 'Maharashtra', 400054, 15000);
INSERT INTO client_master VALUES 
('0002', 'Vandana', NULL, NULL, 'Madras', 'Tamilnadu', 780001, 0);
INSERT INTO client_master VALUES 
('0003', 'Pramada', NULL, NULL, 'Bombay', 'Maharashtra', 400057, 5000);
INSERT INTO client_master VALUES 
('0004', 'Basu', NULL, NULL, 'Bombay', 'Maharashtra', 400056, 0);
INSERT INTO client_master VALUES 
('0005', 'Ravi', NULL, NULL, 'Delhi', NULL, 100001, 2000);
INSERT INTO client_master VALUES 
('0006', 'Rukmini', NULL, NULL, 'Bombay', 'Maharashtra', 400050, 0);
```

#### Product Master Data
```sql
INSERT INTO product_master VALUES 
('P00001', '1.44floppies', 5, 'piece', 100, 20, 525, 500);
INSERT INTO product_master VALUES 
('P03453', 'Monitors', 6, 'piece', 10, 3, 12000, 11200);
INSERT INTO product_master VALUES 
('P06734', 'Mouse', 5, 'piece', 20, 5, 1050, 500);
INSERT INTO product_master VALUES 
('P07865', '1.22 floppies', 5, 'piece', 100, 20, 525, 500);
INSERT INTO product_master VALUES 
('P07868', 'Keyboards', 2, 'piece', 10, 3, 3150, 3050);
INSERT INTO product_master VALUES 
('P07885', 'CD Drive', 2.5, 'piece', 10, 3, 5250, 5100);
INSERT INTO product_master VALUES 
('P07965', '540 HDD', 4, 'piece', 10, 3, 8400, 8000);
INSERT INTO product_master VALUES 
('P07975', '1.44 Drive', 5, 'piece', 10, 3, 1050, 1000);
INSERT INTO product_master VALUES 
('P08865', '1.22 Drive', 5, 'piece', 2, 3, 1050, 1000);
```

### Q3. Queries and Solutions

#### i) Find names of all clients
**Query:**
```sql
SELECT name FROM client_master;
```
**Output:**
- Ivan
- Vandana
- Pramada
- Basu
- Ravi
- Rukmini

#### ii) List of names and cities of all clients
**Query:**
```sql
SELECT name, city FROM client_master;
```
**Output:**
```
NAME                 CITY
-------------------- ---------------
Ivan                 Bombay
Vandana              Madras
Pramada              Bombay
Basu                 Bombay
Ravi                 Delhi
Rukmini              Bombay
```

#### iii) List of available products
**Query:**
```sql
SELECT description FROM product_master;
```
**Output:**
```
DESCRIPTION
---------------
1.44floppies
Monitors
Mouse
1.22 floppies
Keyboards
CD Drive
540 HDD
1.44 Drive
1.22 Drive
```

#### iv) Clients located in Bombay
**Query:**
```sql
SELECT * FROM client_master WHERE city = 'Bombay';
```
**Output:**
```
CLIENT_NO  NAME      CITY     STATE        BAL_DUE
---------  --------  -------  -----------  -------
0001       Ivan      Bombay   Maharashtra  15000
0003       Pramada   Bombay   Maharashtra  5000
0004       Basu      Bombay   Maharashtra  0
0006       Rukmini   Bombay   Maharashtra  0
```

#### v) Information for client no 0001 and 0002
**Query:**
```sql
SELECT * FROM client_master WHERE client_no IN ('0001', '0002');
```
**Output:**
```
CLIENT_NO  NAME      CITY     STATE        BAL_DUE
---------  --------  -------  -----------  -------
0001       Ivan      Bombay   Maharashtra  15000
0002       Vandana   Madras   Tamilnadu    0
```

#### vi) Products with description as '1.44 drive' and '1.22 Drive'
**Query:**
```sql
SELECT * FROM product_master 
WHERE description IN ('1.44 Drive', '1.22 Drive');
```
**Output:**
```
PRODUCT_NO  DESCRIPTION  PROFIT_PERCENT  SELL_PRICE  COST_PRICE
----------  -----------  -------------   ----------  ----------
P07975      1.44 Drive  5              1050        1000
P08865      1.22 Drive  5              1050        1000
```

#### vii) Products with sell price > 5000
**Query:**
```sql
SELECT * FROM product_master WHERE sell_price > 5000;
```
**Output:**
```
PRODUCT_NO  DESCRIPTION  SELL_PRICE
----------  -----------  ----------
P03453      Monitors     12000
P07885      CD Drive     5250
P07965      540 HDD      8400
```

#### viii) Clients in Bombay, Delhi, or Madras
**Query:**
```sql
SELECT * FROM client_master 
WHERE city IN ('Bombay', 'Delhi', 'Madras');
```
**Output:**
```
CLIENT_NO  NAME      CITY     STATE
---------  --------  -------  -----------
0001       Ivan      Bombay   Maharashtra
0002       Vandana   Madras   Tamilnadu
0003       Pramada   Bombay   Maharashtra
0004       Basu      Bombay   Maharashtra
0005       Ravi      Delhi    NULL
0006       Rukmini   Bombay   Maharashtra
```

#### ix) Products with selling price between 2000 and 5000
**Query:**
```sql
SELECT * FROM product_master 
WHERE sell_price > 2000 AND sell_price <= 5000;
```
**Output:**
```
PRODUCT_NO  DESCRIPTION  SELL_PRICE
----------  -----------  ----------
P07868      Keyboards    3150
```

#### x) Clients not in Maharashtra
**Query:**
```sql
SELECT name, city, state 
FROM client_master 
WHERE state != 'Maharashtra' OR state IS NULL;
```
**Output:**
```
NAME        CITY    STATE
----------  ------  ---------
Vandana     Madras  Tamilnadu
Ravi        Delhi   NULL
```

## Important Notes:

1. **Data Types Used:**
   - VARCHAR2: For text data
   - NUMBER: For numeric data with specified precision and scale

2. **SQL Concepts Demonstrated:**
   - Table Creation (DDL)
   - Data Insertion (DML)
   - Data Retrieval (DQL)
   - WHERE clause for filtering
   - Comparison operators
   - Logical operators (AND, OR)
   - IN operator for multiple values
   - NULL handling

3. **Best Practices:**
   - Proper indentation in queries
   - Consistent naming conventions
   - Appropriate use of constraints
   - Efficient query writing

