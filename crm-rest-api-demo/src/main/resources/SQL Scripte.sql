DROP TABLE IF EXISTS customers;

CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `customers` VALUES 
	(1,'Leslie','Andrews','leslie@demo.com'),
	(2,'Emma','Baumgarten','emma@demo.com'),
	(3,'Avani','Gupta','avani@demo.com'),
	(4,'Yuri','Petrov','yuri@demo.com'),
	(5,'Juan','Vega','juan@demo.com');