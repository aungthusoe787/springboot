/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 5.7.25-log : Database - delivery_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`delivery_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `delivery_system`;

/*Table structure for table `area_list` */

DROP TABLE IF EXISTS `area_list`;

CREATE TABLE `area_list` (
  `area_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) NOT NULL,
  PRIMARY KEY (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `area_list` */

insert  into `area_list`(`area_id`,`area_name`) values 
(1,'malviya nager'),
(2,'Sidharth Nager'),
(3,'Jagatpura');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `area_id` bigint(20) NOT NULL,
  `vehicle_type` varchar(50) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_order_area_id` (`area_id`),
  CONSTRAINT `fk_order_area_id` FOREIGN KEY (`area_id`) REFERENCES `area_list` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `orders` */

insert  into `orders`(`order_id`,`product_id`,`area_id`,`vehicle_type`) values 
(1,1,3,'van'),
(2,1,2,'van'),
(3,2,3,'bike');

/*Table structure for table `route` */

DROP TABLE IF EXISTS `route`;

CREATE TABLE `route` (
  `route_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_id` bigint(20) NOT NULL,
  `sequence` bigint(20) NOT NULL,
  PRIMARY KEY (`route_id`),
  KEY `fk_route_area_id` (`area_id`),
  CONSTRAINT `fk_route_area_id` FOREIGN KEY (`area_id`) REFERENCES `area_list` (`area_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `route` */

insert  into `route`(`route_id`,`area_id`,`sequence`) values 
(1,1,1),
(2,2,2),
(3,3,3);

/*Table structure for table `vehicle` */

DROP TABLE IF EXISTS `vehicle`;

CREATE TABLE `vehicle` (
  `vehicle_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `max_order_capacity` bigint(20) NOT NULL,
  `vehicle_type` varchar(50) NOT NULL,
  `route_id` bigint(20) NOT NULL,
  PRIMARY KEY (`vehicle_id`),
  KEY `fk_vehicle_route_id` (`route_id`),
  CONSTRAINT `fk_vehicle_route_id` FOREIGN KEY (`route_id`) REFERENCES `route` (`route_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `vehicle` */

insert  into `vehicle`(`vehicle_id`,`max_order_capacity`,`vehicle_type`,`route_id`) values 
(1,2,'bike',1),
(2,5,'van',2),
(3,33,'bike',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
