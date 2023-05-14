CREATE TABLE `ORDER`
(
    `ORDER_ID` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '주문 ID',
    `MEMBER_ID` INT UNSIGNED NOT NULL COMMENT '고객 ID (FK)',
    `ORDER_NO` INT UNSIGNED NOT NULL  COMMENT '주문 번호',
    `ORDER_TYPE_CODE` VARCHAR(10) NOT NULL COMMENT '주문 타입코드',
    `ORDER_STATUS_CODE` VARCHAR(10) NOT NULL COMMENT '주문 상태코드',
    `ITEM_TOTAL_AMOUNT` INT UNSIGNED NOT NULL COMMENT '상품 총액',
    `DELIVERY_FEE_AMOUNT` INT UNSIGNED NOT NULL COMMENT '배송비',
    `ORDER_TOTAL_AMOUNT` INT UNSIGNED NOT NULL COMMENT '주문 총액',

    `CREATED_DATE_TIME` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '생성 일자',
    `CREATED_BY` INT UNSIGNED NULL COMMENT '생성자 ID',
    `UPDATED_DATE_TIME` DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '수정 일자',
    `UPDATED_BY` INT UNSIGNED NULL COMMENT '수정자 ID',
    PRIMARY KEY(`ORDER_ID`)
) COMMENT = '주문';

-- flyway naming rule - https://flywaydb.org/documentation/concepts/migrations#naming-1