DROP TABLE IF EXISTS `bank_accounts`;
CREATE TABLE `bank_accounts` (
  `bank_account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `money_amount` decimal NOT NULL,
  PRIMARY KEY (`bank_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `trains`;
CREATE TABLE `trains` (
  `train_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number_of_seats` int(11) DEFAULT NULL,
  PRIMARY KEY (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `routes`;
CREATE TABLE `routes` (
  `route_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `train_id` bigint(20) DEFAULT NULL,
  `time` time DEFAULT NULL,
  `station` varchar(40) DEFAULT NULL,
  `price` decimal NOT NULL,
  `next_route_id` bigint(20) NOT NULL,
  PRIMARY KEY (`route_id`),
  FOREIGN KEY (`train_id`)  REFERENCES `trains` (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `passengers`;
CREATE TABLE `passengers` (
  `passenger_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(40) DEFAULT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `passport_number` varchar(15) DEFAULT NULL,
  `phone_number` varchar(15) DEFAULT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`passenger_id`),
  FOREIGN KEY (`user_id`)  REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `tickets`;
CREATE TABLE `tickets` (
  `ticket_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `train_id` bigint(20) NOT NULL,
  `passenger_id` bigint(20) NOT NULL,
  `departure_station` varchar(40) NOT NULL,
  `arrival_station` varchar(40) NOT NULL,
  `seat` int(11) NOT NULL,
  `departure_date` timestamp NOT NULL,
  `arrival_date` timestamp NOT NULL,
  `ticket_price` decimal NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`train_id`)  REFERENCES `trains` (`train_id`),
  FOREIGN KEY (`passenger_id`)  REFERENCES `passengers` (`passenger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(40) NOT NULL UNIQUE,
  `password` varchar(40) NOT NULL,
  `username` varchar(40) NOT NULL UNIQUE,
  `role` enum('user', 'admin'),
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;