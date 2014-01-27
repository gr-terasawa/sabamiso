DROP TABLE IF EXISTS persistent_logins;
CREATE TABLE `persistent_logins` (
  `username` varchar(255) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS users;
CREATE TABLE `users` (
  `user_id` int(10) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `password` varchar(64) NOT NULL,
  `company_id` int(10) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `enabled` tinyint(1) DEFAULT '1',
  `entry_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT INTO `users` (
  `user_name`,
  `password`,
  `company_id`,
  `nickname`
)
VALUES (
  'takeharu.terasawa@gmo-research.jp',
  '9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08',
  1,
  '寺沢岳春'
);
