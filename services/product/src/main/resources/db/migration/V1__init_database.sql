create table if not exists category(
    category_id integer not null primary key,
    description varchar(255),
    name varchar(255)
);

create table if not exists product(
    product_id integer not null primary key,
    description varchar(255),
    name varchar(255),
    available_quantity integer,
    price double precision not null,
    category_id integer constraint fk_category_cons references category(category_id)
);

create sequence if not exists category_seq increment by 50;

create sequence if not exists product_seq increment by 50;
