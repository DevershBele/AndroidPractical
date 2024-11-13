# DBMS Lab Assignment 3 - Solution Key

## Objective
To implement restrictions on database tables using various constraints.

## Table Creations

### 1. Sales Master Table
```sql
CREATE TABLE sales_master (
    salesman_no VARCHAR2(6),
    sal_name VARCHAR2(20) NOT NULL,
    address VARCHAR2(30) NOT NULL,
    city VARCHAR2(20),
    state VARCHAR2(20),
    pincode NUMBER(6),
    sal_amt NUMBER(8,2) NOT NULL,
    tgt_to_get NUMBER(6,2) NOT NULL,
    ytd_sales NUMBER(6,2) NOT NULL,
    remarks VARCHAR2(30),
    CONSTRAINT pk_salesman PRIMARY KEY (salesman_no),
    CONSTRAINT chk_salesman_no CHECK (salesman_no LIKE 'S%'),
    CONSTRAINT chk_sal_amt CHECK (sal_amt != 0),
    CONSTRAINT chk_tgt_amt CHECK (tgt_to_get != 0),
    CONSTRAINT chk_ytd CHECK (ytd_sales != 0)
);
```

### 2. Sales Order Table
```sql
CREATE TABLE sales_order (
    s_order_no VARCHAR2(6),
    s_order_date DATE,
    client_no VARCHAR2(6),
    dely_add VARCHAR2(25),
    salesman_no VARCHAR2(6),
    dely_type CHAR(1) DEFAULT 'F',
    billed_yn CHAR(1),
    dely_date DATE,
    order_status VARCHAR2(10),
    CONSTRAINT pk_sorder PRIMARY KEY (s_order_no),
    CONSTRAINT fk_client FOREIGN KEY (client_no) 
        REFERENCES client_master(client_no),
    CONSTRAINT fk_salesman FOREIGN KEY (salesman_no) 
        REFERENCES sales_master(salesman_no),
    CONSTRAINT chk_order_no CHECK (s_order_no LIKE 'O%'),
    CONSTRAINT chk_dely_type CHECK (dely_type IN ('P', 'F')),
    CONSTRAINT chk_order_status CHECK (order_status IN 
        ('in process', 'fulfilled', 'back order', 'canceled')),
    CONSTRAINT chk_dely_date CHECK (dely_date >= s_order_date)
);
```

### 3. Sales Order Details Table
```sql
CREATE TABLE sales_order_details (
    s_order_no VARCHAR2(6),
    product_no VARCHAR2(6),
    qty_order NUMBER(8),
    qty_disp NUMBER(8),
    product_rate NUMBER(10,2),
    CONSTRAINT pk_sorder_details PRIMARY KEY (s_order_no, product_no),
    CONSTRAINT fk_sorder FOREIGN KEY (s_order_no) 
        REFERENCES sales_order(s_order_no),
    CONSTRAINT fk_product FOREIGN KEY (product_no) 
        REFERENCES product_master(product_no)
);
```

## Data Insertion

### 1. Sales Master Data
```sql
INSERT INTO sales_master VALUES (
    '500001', 'Kiran', 'A/14 worli', 'Bombay', 'Mah', 400002,
    3000, 100, 50, 'Good'
);

INSERT INTO sales_master VALUES (
    '500002', 'Manish', '65,nariman', 'Bombay', 'Mah', 400001,
    3000, 200, 100, 'Good'
);

INSERT INTO sales_master VALUES (
    '500003', 'Ravi', 'P-7 Bandra', 'Bombay', 'Mah', 400032,
    3000, 200, 100, 'Good'
);

INSERT INTO sales_master VALUES (
    '500004', 'Ashish', 'A/5 Juhu', 'Bombay', 'Mah', 400044,
    3500, 200, 150, 'Good'
);
```

### 2. Sales Order Data
```sql
INSERT INTO sales_order VALUES (
    '019001', '12-JAN-96', '0001', 'F', 'N', '50001',
    '20-JAN-96', 'Ip'
);

INSERT INTO sales_order VALUES (
    '019002', '25-JAN-96', '0002', 'P', 'N', '50002',
    '27-JAN-96', 'C'
);

-- Continue with remaining records...
```

### 3. Sales Order Details Data
```sql
INSERT INTO sales_order_details VALUES (
    '019001', 'P00001', 4, 4, 525
);

INSERT INTO sales_order_details VALUES (
    '019001', 'P07965', 2, 1, 8400
);

-- Continue with remaining records...
```

## Key Concepts Implemented

### 1. Primary Key Constraints
- Used in all three tables
- Single column in sales_master and sales_order
- Composite key in sales_order_details

### 2. Foreign Key Constraints
- sales_order references client_master and sales_master
- sales_order_details references sales_order and product_master

### 3. Check Constraints
- Salesman number starting with 'S'
- Delivery type must be 'P' or 'F'
- Non-zero amounts in sales_master
- Valid order status values
- Delivery date validation

### 4. Not Null Constraints
- Applied to essential fields like sal_name, address
- Ensures data integrity for critical business information

### 5. Default Values
- Default 'F' for delivery type in sales_order

## Important Notes

1. **Table Relationships:**
   - Three interconnected tables forming a complete sales system
   - Proper referential integrity maintained through foreign keys

2. **Data Validation:**
   - Multiple check constraints ensure data quality
   - Business rules enforced at database level

3. **Date Handling:**
   - Proper date comparisons in constraints
   - Date format consistency maintained

4. **Naming Conventions:**
   - Consistent constraint naming pattern
   - Clear and descriptive column names

5. **Error Prevention:**
   - Constraints prevent invalid data entry
   - Default values reduce data entry errors

