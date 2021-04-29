DROP TABLE IF EXISTS `trains`;
CREATE TABLE `trains` (
  `train_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `manufacturer` varchar(40) DEFAULT NULL,
  `model` varchar(40) DEFAULT NULL,
  `number_of_seats` int(11) DEFAULT NULL,
  `train_type` enum('signature', 'express', 'passenger'),
  PRIMARY KEY (`train_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `stations`;
CREATE TABLE `stations` (
  `station_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `station_name` varchar(40) DEFAULT NULL,
  `city` varchar(40) DEFAULT NULL,
  `country` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`station_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `trips`;
CREATE TABLE `trips` (
  `trip_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `departure_time` time DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `train_id` bigint(20) DEFAULT NULL,
  `departure_station_id` bigint(20) DEFAULT NULL,
  `arrival_station_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`trip_id`),
  FOREIGN KEY (`train_id`)  REFERENCES `trains` (`train_id`),
  FOREIGN KEY (`departure_station_id`)  REFERENCES `stations` (`station_id`),
  FOREIGN KEY (`arrival_station_id`)  REFERENCES `stations` (`station_id`)
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
  `trip_id` bigint(20) NOT NULL,
  `passenger_id` bigint(20) NOT NULL,
  `seat` int(11) NOT NULL,
  `date` date NOT NULL,
  `ticket_price` decimal NOT NULL,
  PRIMARY KEY (`ticket_id`),
  FOREIGN KEY (`trip_id`)  REFERENCES `trips` (`trip_id`),
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