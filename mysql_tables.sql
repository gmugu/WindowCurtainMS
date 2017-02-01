CREATE DATABASE  IF NOT EXISTS `windowcurtainms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `windowcurtainms`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: windowcurtainms
-- ------------------------------------------------------
-- Server version	5.6.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `after_sales_service`
--

DROP TABLE IF EXISTS `after_sales_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `after_sales_service` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `time` datetime DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cur_ass_idx` (`customer_id`),
  KEY `fk_emp_ass_idx` (`employee_id`),
  CONSTRAINT `fk_cur_ass` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_emp_ass` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='售后服务';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `business`
--

DROP TABLE IF EXISTS `business`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `sign_time` datetime DEFAULT NULL,
  `business_type` varchar(45) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `appointment_time` datetime DEFAULT NULL,
  `state` varchar(45) NOT NULL,
  `acceptance_time` datetime DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `comments_reg` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`),
  KEY `fk_cus_bus_idx` (`customer_id`),
  CONSTRAINT `fk_cus_bus` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='业务登记';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `curtain`
--

DROP TABLE IF EXISTS `curtain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curtain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `specifications` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `color` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `name` varchar(200) NOT NULL,
  `contact_person` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `comments` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `dept` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `idcard_no` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `unit` varchar(45) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `producing_area` varchar(45) DEFAULT NULL,
  `ingredient` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `curtain_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `location` varchar(45) DEFAULT NULL,
  `height` double DEFAULT NULL,
  `width` double DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_order_od_idx` (`order_id`),
  KEY `fk_cur_od_idx` (`curtain_id`),
  CONSTRAINT `fk_cur_od` FOREIGN KEY (`curtain_id`) REFERENCES `curtain` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_od` FOREIGN KEY (`order_id`) REFERENCES `orderl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='窗帘定做明细';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `orderl`
--

DROP TABLE IF EXISTS `orderl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `order_time` datetime DEFAULT NULL,
  `customer_id` int(11) NOT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `downpayment` double DEFAULT NULL,
  `state` varchar(45) NOT NULL,
  `acceptance_time` datetime DEFAULT NULL,
  `amount_paid` double DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `comments_sign` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`),
  KEY `fk_cus_order_idx` (`customer_id`),
  CONSTRAINT `fk_cus_order` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='定做登记';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `procurement`
--

DROP TABLE IF EXISTS `procurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procurement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `buy_date` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `total_paid` double DEFAULT '0',
  `amount_paid` double DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`),
  KEY `fk_employee_idx` (`operator_id`),
  KEY `fk_warehouse_procurement_idx` (`warehouse_id`),
  KEY `fk_supplier_procurement_idx` (`supplier_id`),
  CONSTRAINT `fk_employee_procurement` FOREIGN KEY (`operator_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_supplier_procurement` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_warehouse_procurement` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `procurement_detail`
--

DROP TABLE IF EXISTS `procurement_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `procurement_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `procurement_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `counts` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_pro_prode_idx` (`procurement_id`),
  KEY `fk_met_prode_idx` (`material_id`),
  CONSTRAINT `fk_met_prode` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pro_prode` FOREIGN KEY (`procurement_id`) REFERENCES `procurement` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `return_detail`
--

DROP TABLE IF EXISTS `return_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `return_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `counts` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_rer_rd_idx` (`return_id`),
  KEY `fk_me_rd_idx` (`material_id`),
  CONSTRAINT `fk_me_rd` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_rer_rd` FOREIGN KEY (`return_id`) REFERENCES `returnl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `returnl`
--

DROP TABLE IF EXISTS `returnl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `returnl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `return_date` datetime DEFAULT NULL,
  `operator_id` int(11) NOT NULL,
  `warehouse_id` int(11) NOT NULL,
  `supplier_id` int(11) NOT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`),
  KEY `fk_return_emp_idx` (`operator_id`),
  KEY `fk_sup_emp_idx` (`supplier_id`),
  KEY `fk_warh_return_idx` (`warehouse_id`),
  CONSTRAINT `fk_emp_return` FOREIGN KEY (`operator_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_sup_retuen` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_warh_return` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) NOT NULL,
  `year` varchar(20) DEFAULT NULL,
  `month` varchar(20) DEFAULT NULL,
  `basic` double DEFAULT NULL COMMENT '基本工资',
  `performance` double DEFAULT '0' COMMENT '绩效工资',
  `bonus` double DEFAULT '0' COMMENT '奖金',
  `cut` double DEFAULT '0' COMMENT '扣款',
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_emp_salary_idx` (`employee_id`),
  CONSTRAINT `fk_emp_salary` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='员工薪资';
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `name` varchar(200) NOT NULL,
  `contact_person` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `area` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `zip_code` varchar(45) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `use_material_detail`
--

DROP TABLE IF EXISTS `use_material_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `use_material_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `material_id` int(11) NOT NULL,
  `counts` int(11) NOT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_or_umd_idx` (`order_id`),
  KEY `fk_ma_umd_idx` (`material_id`),
  CONSTRAINT `fk_ma_umd` FOREIGN KEY (`material_id`) REFERENCES `material` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_or_umd` FOREIGN KEY (`order_id`) REFERENCES `orderl` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用料明细';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `use_material_detail`
--

LOCK TABLES `use_material_detail` WRITE;
/*!40000 ALTER TABLE `use_material_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `use_material_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `au_basic` int(11) DEFAULT '1' COMMENT '基本资料管理权限',
  `au_store` int(11) DEFAULT '1' COMMENT '材料管理管理权限',
  `au_order` int(11) DEFAULT '1' COMMENT '订单管理权限',
  `au_business` int(11) DEFAULT '1' COMMENT '业务管理权限',
  `au_financial` int(11) DEFAULT '1' COMMENT '财务管理管理权限',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `comments` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `no_UNIQUE` (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-01 22:48:59
