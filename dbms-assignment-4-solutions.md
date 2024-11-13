
# Assignment No. 4 - Answer Key

## Question 1: Create the following tables

### Table: Challan_Header
```sql
CREATE TABLE Challan_Header (
    Challan_no VARCHAR2(6) PRIMARY KEY,
    s_order_no VARCHAR2(6) REFERENCES sales_order(s_order_no),
    challan_date DATE NOT NULL,
    billed_yn CHAR(1) DEFAULT 'N' CHECK (billed_yn IN ('Y', 'N'))
);
```

### Table: Challan_Details
```sql
CREATE TABLE Challan_Details (
    Challan_no VARCHAR2(6) REFERENCES Challan_Header(Challan_no),
    Product_no VARCHAR2(6) REFERENCES product_master(Product_no),
    Qty_disp NUMBER(4, 2) NOT NULL,
    PRIMARY KEY (Challan_no, Product_no)
);
```

## Question 2: Insert values into the challan header and challan details tables

### (i) Insert data into `Challan_Header`
```sql
INSERT INTO Challan_Header (Challan_no, s_order_no, challan_date, billed_yn) VALUES
('CH9001', '019001', TO_DATE('12-DEC-95', 'DD-MON-YY'), 'Y'),
('CH865', '046865', TO_DATE('12-NOV-95', 'DD-MON-YY'), 'Y'),
('CH3965', '010008', TO_DATE('12-OCT-95', 'DD-MON-YY'), 'Y');
```

### (ii) Insert data into `Challan_Details`
```sql
INSERT INTO Challan_Details (Challan_no, Product_no, Qty_disp) VALUES
('CH9001', 'P00001', 4),
('CH9001', 'P07965', 1),
('CH9001', 'P07885', 1),
('CH6865', 'P07868', 3),
('CH6865', 'P03453', 4),
('CH6865', 'P00001', 10),
('CH3965', 'P00001', 5),
('CH3965', 'P07975', 2);
```

## Objective – Answer the following Questionaries

### Q1. Make the primary key to `client_no` in `client_master`.
```sql
ALTER TABLE client_master
ADD PRIMARY KEY (client_no);
```

### Q2. Add a new column `phone_no` in the `client_master` table.
```sql
ALTER TABLE client_master
ADD phone_no VARCHAR2(15);
```

### Q3. Add the NOT NULL constraint in the `product_master` table with the columns `description`, `profit_percent`, `sell_price`, and `cost_price`.
```sql
ALTER TABLE product_master
MODIFY (description VARCHAR2(100) NOT NULL,
        profit_percent NUMBER(5, 2) NOT NULL,
        sell_price NUMBER(10, 2) NOT NULL,
        cost_price NUMBER(10, 2) NOT NULL);
```

### Q4. Change the size of `client_no` field in the `client_master` table.
```sql
ALTER TABLE client_master
MODIFY client_no VARCHAR2(8);
```

### Q5. Select `product_no`, `description` where `profit_percent` is between 20 and 30 both inclusive.
```sql
SELECT product_no, description
FROM product_master
WHERE profit_percent BETWEEN 20 AND 30;
```
