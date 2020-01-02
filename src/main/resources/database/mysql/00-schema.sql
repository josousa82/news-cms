CREATE DATABASE newsCmsDB;
GRANT ALL PRIVILEGES ON newsCmsDB.* TO root WITH GRANT OPTION;

USE `newsCmsDB`;

DROP TABLE IF EXISTS `category`;

CREATE TABLE `system_user` (
   `user_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   `user_identity` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `user_name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
   `user_role` int(11) DEFAULT NULL,
   PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `category` (

    `id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
     PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `news` (
    `news_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `news_content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `news_title` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    `author_user_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`news_id`),
    KEY `fk_author_user_id` (`author_user_id`),
    CONSTRAINT `fk_author_user_id` FOREIGN KEY (`author_user_id`) REFERENCES `system_user` (`user_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `news_categories` (

   `news_news_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   `categories_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
   PRIMARY KEY (`news_news_id`,`categories_id`),
   UNIQUE KEY `UK_2hcaqio01osd60g37t6cgi665` (`categories_id`),
   CONSTRAINT `FK2p4mrgmiillrjfxakiam8ibg` FOREIGN KEY (`news_news_id`) REFERENCES `news` (`news_id`),
   CONSTRAINT `FKm0ll73aae2iuw60qsrhvs6ddx` FOREIGN KEY (`categories_id`) REFERENCES `category` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `news_mandatory_reviewers` (
    `news_news_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    `mandatory_reviewers_user_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
    PRIMARY KEY (`news_news_id`,`mandatory_reviewers_user_id`),
    UNIQUE KEY `UK_4ssp08k23d533nytflrpuf0jk` (`mandatory_reviewers_user_id`),
    CONSTRAINT `FK3q0sjew4ekcx1p8a844fkr780` FOREIGN KEY (`mandatory_reviewers_user_id`) REFERENCES `system_user` (`user_id`),
    CONSTRAINT `FKn15px808p9vdh61vca3npk6ev` FOREIGN KEY (`news_news_id`) REFERENCES `news` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `news_reviewers` (
  `news_news_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `review_status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  KEY `FKd1weeo17hj2wwu0qobgon0qdq` (`news_news_id`),
  CONSTRAINT `FKd1weeo17hj2wwu0qobgon0qdq` FOREIGN KEY (`news_news_id`) REFERENCES `news` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `news_tags` (
     `news_news_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
     `value` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
     KEY `FKift1ljiokcu5xog272tauet68` (`news_news_id`),
     CONSTRAINT `FKift1ljiokcu5xog272tauet68` FOREIGN KEY (`news_news_id`) REFERENCES `news` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


