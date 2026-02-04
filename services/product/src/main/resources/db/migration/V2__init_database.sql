-- =========================
-- CATEGORY DATA
-- =========================

INSERT INTO category (category_id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Electronic gadgets and devices'),
    (nextval('category_seq'), 'Books', 'Books across various genres'),
    (nextval('category_seq'), 'Clothing', 'Men and Women clothing');


-- =========================
-- PRODUCT DATA
-- =========================

-- Electronics
INSERT INTO product (
    product_id,
    name,
    description,
    available_quantity,
    price,
    category_id
)
VALUES
    (
        nextval('product_seq'),
        'iPhone 15',
        'Apple smartphone',
        10,
        79999.00,
        (SELECT category_id FROM category WHERE name = 'Electronics')
    ),
    (
        nextval('product_seq'),
        'Samsung Galaxy S24',
        'Samsung flagship phone',
        15,
        74999.00,
        (SELECT category_id FROM category WHERE name = 'Electronics')
    );


-- Books
INSERT INTO product (
    product_id,
    name,
    description,
    available_quantity,
    price,
    category_id
)
VALUES
    (
        nextval('product_seq'),
        'Clean Code',
        'A Handbook of Agile Software Craftsmanship',
        20,
        499.00,
        (SELECT category_id FROM category WHERE name = 'Books')
    ),
    (
        nextval('product_seq'),
        'Design Patterns',
        'Elements of Reusable Object-Oriented Software',
        12,
        699.00,
        (SELECT category_id FROM category WHERE name = 'Books')
    );


-- Clothing
INSERT INTO product (
    product_id,
    name,
    description,
    available_quantity,
    price,
    category_id
)
VALUES
    (
        nextval('product_seq'),
        'Men T-Shirt',
        'Cotton round neck t-shirt',
        30,
        599.00,
        (SELECT category_id FROM category WHERE name = 'Clothing')
    ),
    (
        nextval('product_seq'),
        'Women Jeans',
        'Slim fit denim jeans',
        25,
        1299.00,
        (SELECT category_id FROM category WHERE name = 'Clothing')
    );
