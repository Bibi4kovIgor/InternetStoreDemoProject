create extension if not exists "uuid-ossp";

create table if not exists documents (
   id uuid default uuid_generate_v4(),
   tax_id bigint unique not null,
   passport varchar not null,
   additional_info varchar,
   primary key (id)
);

create table if not exists customers (
    id uuid default uuid_generate_v4 (),
    first_name varchar not null,
    last_name varchar not null,
    phone varchar not null,

--  timestamp means that date will be converted to milliseconds
--  it store milliseconds count from January 1, 1970 to given data
    birth_date timestamp with time zone,

    login varchar not null,
    email varchar not null,
    password varchar not null,
    document_id uuid,
    primary key (id),
    foreign key(document_id) references documents(id)
);

create table if not exists suppliers (
    id uuid default uuid_generate_v4(),
    name varchar not null,
    organisation_name varchar not null,
    email varchar not null,
    password varchar not null,
    phone varchar not null,
    document_id uuid,
    primary key (id),
    foreign key(document_id) references documents(id)
);


create table if not exists products (
    id uuid default uuid_generate_v4(),
    name varchar not null,
    vendor_code varchar unique not null,
    quantity double precision DEFAULT 1.0,
    availability boolean DEFAULT FALSE,
    price numeric not null,
    description varchar,
    primary key (id)
);

create table if not exists products_suppliers(
    product_id uuid not null,
    supplier_id uuid not null,
    primary key (product_id, supplier_id),
    foreign key(product_id) references products(id),
    foreign key(supplier_id) references suppliers(id)
);

create table if not exists categories (
    id uuid default uuid_generate_v4(),
    name varchar not null,
    description varchar not null,
    primary key (id)
);

create table if not exists products_categories (
    category_id uuid not null,
    product_id uuid not null,
    primary key (category_id, product_id),
    foreign key(category_id) references categories(id),
    foreign key(product_id) references products(id)
);

create table if not exists orders (
    customer_id uuid not null,
    product_id uuid not null,
    quantity integer DEFAULT 1,
    order_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    primary key (customer_id, product_id, order_date),
    foreign key(customer_id) references customers(id),
    foreign key(product_id) references products(id)
);

create table if not exists baskets (
--  This field is not unique
--  It is used for union customers
--  products choices into one place
    id uuid default uuid_generate_v4(),
    customer_id uuid not null,
    product_id uuid not null,
    quantity double precision DEFAULT 1.0,
    create_date timestamp with time zone DEFAULT CURRENT_TIMESTAMP,
    primary key (id, customer_id, product_id),
    foreign key(customer_id) references customers(id),
    foreign key(product_id) references products(id)
);














