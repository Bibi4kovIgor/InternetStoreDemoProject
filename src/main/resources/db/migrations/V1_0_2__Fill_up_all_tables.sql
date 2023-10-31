create extension if not exists pgcrypto;

-- documents
insert into documents(tax_id, passport, additional_info) values
(11155544874, '447AAAd', ' '),
(12354542542, 'DD21312', 'Some additional info'),
(11153544874, 'RR34123', 'It is customer'),
(15555544874, '54474', 'It is supplier'),
(22235245622, '7744765', 'Facebook founder'),
(14444456874, '9H7AAAd', 'Some other customer'),
(12378954542, 'DDH1312', 'Some another supplier'),
(18883544874, '7734123', 'additional info'),
(65785544874, '5764474', 'Info'),
(22235090922, '7JJ4765', 'Qwerty');

--create function for getting data from bounded tables
CREATE OR REPLACE FUNCTION get_id_from_table(element_number integer, table_name regclass)
RETURNS uuid AS $$
DECLARE result_id uuid;
BEGIN
    EXECUTE format('SELECT (SELECT id FROM %s LIMIT 1 OFFSET $1)::uuid', table_name)
      INTO result_id
      USING element_number;

    RETURN result_id;
END;
$$ LANGUAGE plpgsql IMMUTABLE;

-- customers
insert into customers(first_name, last_name, phone, birth_date, login, email, password, document_id) values
('Ihor', 'Bibichkov', '+38077478544', '1991-12-22'::timestamp,'Ihor_Bibichkov', 'work.bibi4kov@gmail.com',
 crypt('password_default', gen_salt('bf')), (SELECT * FROM get_id_from_table(0, 'documents'))),
('Tom',  'Delt', '+17854115521', '1993-11-24'::timestamp, 'tom_fun', 'tom.fun@gmail.com',
 crypt('some_password', gen_salt('bf')), (SELECT * FROM get_id_from_table(1, 'documents'))),
('Garry', 'Smith', '+44522589624', '1989-1-1'::timestamp, 'some_email','some.email@gmail.com',
 crypt('password_default_123', gen_salt('bf')), (SELECT * FROM get_id_from_table(2, 'documents'))),
('Jeremy', 'Suckey', '+1589659965', '2000-2-20'::timestamp, 'email_email', 'email@gmail.com',
 crypt('password_default_321', gen_salt('bf')), (SELECT * FROM get_id_from_table(3, 'documents'))),
('Mark', 'Tsuckerberg', '+1589654114', '1979-7-5'::timestamp, 'mark_meta','work_meta@gmail.com',
 crypt('password_default_445', gen_salt('bf')), (SELECT * FROM get_id_from_table(4, 'documents')));

-- suppliers
insert into suppliers(name, organisation_name, phone, email, password, document_id) values
('John Doe', 'Some Great Organisagtion', '+36568845461', 'john.doe@gmail.com',
 crypt('password_customer1', gen_salt('bf')), (SELECT * FROM get_id_from_table(5, 'documents'))),
('Sam Simple', 'Super Company', '+9688574445', 'sam.simple@gmail.com',
 crypt('password_customer2', gen_salt('bf')), (SELECT * FROM get_id_from_table(6, 'documents'))),
('Steve Grain', 'Steves Great Company', '+11123123123', 'steve.grain@gmail.com',
 crypt('password_customer3', gen_salt('bf')), (SELECT * FROM get_id_from_table(7, 'documents'))),
('Gen Ant', 'Gens Ant Corporation', '+9968547851', 'gen.ant@gmail.com',
 crypt('password_customer4', gen_salt('bf')), (SELECT * FROM get_id_from_table(8, 'documents'))),
('Tim Tom', 'Tip Top COmpany', '+4457545111', 'tim.tom@gmail.com',
 crypt('password_customer5', gen_salt('bf')), (SELECT * FROM get_id_from_table(9, 'documents')));

-- categories
insert into categories(name, description) values
('electronics', 'radioelectronics equipment'),
('household', 'different household stuff'),
('food', 'food and drincs'),
('toys', 'All you need for children'),
('appliances', 'other stuffs');

-- products
insert into products(vendor_code, name, description, availability, price, quantity) values
('V157898556', 'Laptop', 'Some powerful laptop', true, 15547.15, 10),
('R178885426', 'Personal Computer', 'Some powerful PC', true, 10854.15, 12),
('SP58898556', 'Hoover', 'Some good hoover', true, 6547.0, 45),
('RR78954726', 'Fridge', 'Some cheap fridge', true, 12854.55, 11),
('TT85471169', 'Juice', 'Orange juice', true, 50.5, 4),
('BB98456638', 'Bread', 'wheat bread', true, 25.7, 77);


-- products_suppliers
insert into products_suppliers(product_id, supplier_id) values
((SELECT * FROM get_id_from_table(0, 'products')), (SELECT * FROM get_id_from_table(0, 'suppliers'))),
((SELECT * FROM get_id_from_table(1, 'products')), (SELECT * FROM get_id_from_table(1, 'suppliers'))),
((SELECT * FROM get_id_from_table(2, 'products')), (SELECT * FROM get_id_from_table(2, 'suppliers'))),
((SELECT * FROM get_id_from_table(3, 'products')), (SELECT * FROM get_id_from_table(3, 'suppliers'))),
((SELECT * FROM get_id_from_table(4, 'products')), (SELECT * FROM get_id_from_table(4, 'suppliers'))),
((SELECT * FROM get_id_from_table(5, 'products')), (SELECT * FROM get_id_from_table(3, 'suppliers')));

-- products_categories
insert into products_categories(product_id, category_id) values
((SELECT * FROM get_id_from_table(0, 'products')), (SELECT * FROM get_id_from_table(0, 'categories'))),
((SELECT * FROM get_id_from_table(1, 'products')), (SELECT * FROM get_id_from_table(1, 'categories'))),
((SELECT * FROM get_id_from_table(2, 'products')), (SELECT * FROM get_id_from_table(2, 'categories'))),
((SELECT * FROM get_id_from_table(3, 'products')), (SELECT * FROM get_id_from_table(3, 'categories'))),
((SELECT * FROM get_id_from_table(4, 'products')), (SELECT * FROM get_id_from_table(4, 'categories'))),
((SELECT * FROM get_id_from_table(5, 'products')), (SELECT * FROM get_id_from_table(3, 'categories')));

-- orders
insert into orders(customer_id, product_id, quantity, order_date) values
((SELECT get_id_from_table(0, 'customers')), (SELECT get_id_from_table(0, 'products')), 1, NOW()::timestamp),
((SELECT get_id_from_table(1, 'customers')), (SELECT get_id_from_table(1, 'products')), 3, NOW()::timestamp),
((SELECT get_id_from_table(3, 'customers')), (SELECT get_id_from_table(2, 'products')), 2, NOW()::timestamp),
((SELECT get_id_from_table(4, 'customers')), (SELECT get_id_from_table(3, 'products')), 1, NOW()::timestamp),
((SELECT get_id_from_table(3, 'customers')), (SELECT get_id_from_table(4, 'products')), 2, NOW()::timestamp),
((SELECT get_id_from_table(2, 'customers')), (SELECT get_id_from_table(5, 'products')), 1, NOW()::timestamp);

-- baskets
insert into baskets(customer_id, product_id, quantity, create_date) values
((SELECT get_id_from_table(0, 'customers')), (SELECT get_id_from_table(0, 'products')), 1.0, NOW()::timestamp),
((SELECT get_id_from_table(1, 'customers')), (SELECT get_id_from_table(1, 'products')), 1.0, NOW()::timestamp),
((SELECT get_id_from_table(2, 'customers')), (SELECT get_id_from_table(2, 'products')), 1.0, NOW()::timestamp),
((SELECT get_id_from_table(3, 'customers')), (SELECT get_id_from_table(3, 'products')), 1.0, NOW()::timestamp),
((SELECT get_id_from_table(4, 'customers')), (SELECT get_id_from_table(4, 'products')), 1.0, NOW()::timestamp),
((SELECT get_id_from_table(0, 'customers')), (SELECT get_id_from_table(5, 'products')), 1.0, NOW()::timestamp);