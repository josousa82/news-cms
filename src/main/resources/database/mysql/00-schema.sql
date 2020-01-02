CREATE DATABASE newsCmsDB;
GRANT ALL PRIVILEGES ON newsCmsDB.* TO root WITH GRANT OPTION;

USE `newsCmsDB`;

DROP TABLE IF EXISTS `newsCmsDB`.`category`;

CREATE TABLE `newsCmsDB`.`category`(

    `id` VARCHAR(100) DEFAULT NULL,
    `name` VARCHAR(255) DEFAULT NULL

)ENGINE=INNODB DEFAULT CHARSET = utf8;


CREATE TABLE `newsCmsDB`.`system_user`(

    `user_id` VARCHAR(100) DEFAULT NULL,
    `user_identity` VARCHAR(255) DEFAULT NULL,
    `user_name` VARCHAR(255) DEFAULT NULL,
    `user_role` VARCHAR(255) DEFAULT NULL

)ENGINE = INNODB DEFAULT CHARSET = utf8;


CREATE TABLE `newsCmsDB`.`news`(

    `news_id` VARCHAR(100) DEFAULT NULL,
    `news_title` VARCHAR(255) DEFAULT NULL,
    `news_content` MEDIUMTEXT DEFAULT NULL,
    `user_id` VARCHAR(100),
    `review_id` VARCHAR(100),
    `review_status` VARCHAR(100)

) ENGINE = INNODB DEFAULT CHARSET = utf8;

