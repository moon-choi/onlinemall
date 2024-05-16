CREATE TABLE customer ( -- 고객테이블
customer_id VARCHAR(50) NOT NULL, -- 고객아이디
password VARCHAR(100) NOT NULL, -- 비밀번호
customer_name VARCHAR(100) NOT NULL, -- 고객이름
age INT, -- 나이
rating VARCHAR(20) NOT NULL, -- 등급
occupation VARCHAR(20), -- 직업
reserves INT DEFAULT 0, -- 적립금
PRIMARY KEY (customer_id)
);

CREATE TABLE product ( -- 제품테이블
product_number INT AUTO_INCREMENT, -- 제품번호
product_name VARCHAR(100), -- 제품명
inventory INT, -- 재고량
price INT, -- 가격
manufacturer VARCHAR(100), -- 제조업체
PRIMARY KEY (product_number),
CHECK (inventory > 0 AND inventory <= 10000)
);

CREATE TABLE customer_product ( -- 주문테이블
order_number INT AUTO_INCREMENT, -- 주문번호(독립형PK)
customer_id VARCHAR(50), -- 고객번호
product_number INT, -- 제품번호
quantity INT, -- 수량
order_date DATETIME default now(), -- 주문일자
PRIMARY KEY (order_number),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (product_number) REFERENCES product(product_number)
);
