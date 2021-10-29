-- INSERT INTO PRODUCT (PRODUCT_NAME, MANUFACTURING_DATE, MANUFACTURING_TIME, DUE_DATE)
-- VALUES ('lela', 'lala', 'lala', 'lala'),
--       ('LJH', 'UKHF', 'JGFF', 'JFGFJ'),
--       ('l9la', 'l0la', 'lal3', 'lal8');
--
-------------------------------------------------------------------------------
 INSERT INTO WAREHOUSE (NAME, ADDRESS, SIZE)
 VALUES ('MELI', 'RUA HUM', '2'),
        ('MERCADO', 'RUA TRES', '7');

-- --------------------------------------------------------------------------------
 INSERT INTO REPRESENTATIVE (NAME, CPF, WAREHOUSE_ID)
 VALUES ('SILAS', '789.456.789.45', 1),
        ('IVO', '321.456.789.45', 2);

----------------------------------------------------------------------------------

 INSERT INTO SECTION(SECTION_ID, WAREHOUSE_ID)
 VALUES(1, 1);

-- --------------------------------------------------------------------------------
 INSERT INTO IN_BOUND_ORDER (ORDER_NUMBER , REPRESENTATIVE_REPRESENTATIVE_ID, SECTION_ID)
 VALUES(1, 1, 1);

-- --------------------------------------------------------------------------------
 INSERT INTO BATCH_STOCK (CURRENT_QUALITY, CURRENT_TEMPERATURE, INITIAL_QUALITY , MINIMUM_TEMEPRATURE, INBOUNDORDER_ORDER_NUMBER )
 VALUES(1, 1, '23', '67', 1);

--------------------------------------------------------------------------------
 INSERT INTO PRODUCT (PRODUCT_ID)
 VALUES(1);
--------------------------------------------------------------------------------
INSERT INTO SELLER (SELLER_ID)
VALUES(1);
--------------------------------------------------------------------------------
 INSERT INTO BATCH_STOCK_ITEM (ID, QUANTITY, BATCHSTOCK_BATCH_NUMBER, PRODUCTID, SELLER_ID   )
 VALUES(1, 1, 1, 1, 1);
