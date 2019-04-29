-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: zmy
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `merchants`
--

DROP TABLE IF EXISTS `merchants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `merchants` (
  `mer_id` int(11) NOT NULL AUTO_INCREMENT,
  `mer_username` varchar(20) NOT NULL,
  `mer_password` varchar(20) NOT NULL,
  `mer_shopName` varchar(20) NOT NULL,
  `mer_mobile` varchar(20) NOT NULL,
  `mer_address` varchar(50) NOT NULL,
  `mer_status` int(11) DEFAULT '0',
  PRIMARY KEY (`mer_id`),
  UNIQUE KEY `merchants_mer_username_uindex` (`mer_username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchants`
--

LOCK TABLES `merchants` WRITE;
/*!40000 ALTER TABLE `merchants` DISABLE KEYS */;
INSERT INTO `merchants` VALUES (1,'m1','970811','Cherry','15911111111','四川省成都市',1),(2,'chenrui','asdasda','Dell','15922222222','四川省德阳市',0),(3,'asd','asdasd','asdasd','13215645645','四川省内江市',0);
/*!40000 ALTER TABLE `merchants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_name` varchar(100) NOT NULL,
  `pro_price` double NOT NULL,
  `pro_inventory` int(11) NOT NULL,
  `pro_img` varchar(255) DEFAULT NULL,
  `pro_bought` int(11) DEFAULT '0',
  `mer_id` int(11) NOT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `mer_id` (`mer_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`mer_id`) REFERENCES `merchants` (`mer_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Huawei/华为 P10 Plus4G',1159,116605,'https://gd3.alicdn.com/imgextra/i3/2418395878/TB2PW4UltcnBKNjSZR0XXcFqFXa_!!2418395878.jpg_400x400.jpg',51,1),(2,'360 n7Pro 360旗舰手机 全面屏',770,48,'https://gd1.alicdn.com/imgextra/i2/3350973938/O1CN011exeAWv19VRqfP8_!!3350973938.jpg_400x400.jpg',34,1),(3,'Xiaomi/小米 小米8年度旗舰全面屏',1099,283,'https://gd3.alicdn.com/imgextra/i3/2200682299828/O1CN01s5YBJr2MTH1xqiMX1_!!2200682299828.jpg_400x400.jpg',123,1),(4,'Huawei/华为 畅享7s 4G全网通',760,615,'https://gd2.alicdn.com/imgextra/i2/4171421604/O1CN011Nifkp1MV0BtLSD_!!4171421604.jpg_400x400.jpg',346,1),(5,'OPPO R17 Pro王者定制版屏幕指纹版',1198,292,'https://gd4.alicdn.com/imgextra/i4/2200682299828/O1CN01GfMHyy2MTH222pZ8H_!!2200682299828.jpg_400x400.jpg',534,1),(6,'Huawei/华为 nova 4e 超广角摄像头',1198,50,'https://gd1.alicdn.com/imgextra/i1/3174739641/O1CN01RyNIj92L5cyYMudOy_!!3174739641.jpg_400x400.jpg',134,1),(7,'honor/荣耀 荣耀8青春版移动/联通',558,487,'https://gd3.alicdn.com/imgextra/i2/450343538/TB2_9ympnqWBKNjSZFxXXcpLpXa_!!450343538.jpg_400x400.jpg',583,1),(8,'Apple/苹果 iPhone X',4300,1161,'https://gd4.alicdn.com/imgextra/i2/682163095/O1CN01TRJZaC1YjYKwRT00O_!!682163095.jpg_400x400.jpg',23,1),(9,'Apple/苹果 iPhone Xs Max',9088,1117,'https://img.alicdn.com/imgextra/i2/2616970884/O1CN01Bvkalm1IOudVsQTwA_!!0-item_pic.jpg_430x430q90.jpg',34,1),(10,'vivo X27 4800万广角夜景三摄',3198,2956,'https://img.alicdn.com/imgextra/i2/883737303/O1CN01SP6PN623ooylUebFu_!!883737303.jpg_430x430q90.jpg',55,1),(11,'华为HONOR/荣耀 荣耀20i',1599,2048,'https://img.alicdn.com/imgextra/i3/1114511827/O1CN01WfnvRc1PMo84zZdjo_!!1114511827.jpg_430x430q90.jpg',324,1),(12,'Apple/苹果 iPhone 8 Plus',2840,1392,'https://gd2.alicdn.com/imgextra/i2/3897739684/O1CN01OPN2j52LPK0zdPEEw_!!3897739684.jpg_400x400.jpg',456,1),(13,'Xiaomi/小米 小米9手机全面屏',2999,7157,'https://img.alicdn.com/imgextra/i2/2024314280/O1CN01apRRzW1hUHexn6tPR_!!2024314280.jpg_430x430q90.jpg',543,1),(14,'vivo iQOO手机 vivoiqoo',2998,567,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i4/268451883/O1CN01UuQw521PmSICLCHZZ_!!268451883.jpg_430x430q90.jpg',123,1),(15,'Meizu/魅族 16th Plus ',2698,870,'https://img.alicdn.com/imgextra/i2/1695308781/TB2aqPnJL9TBuNjy0FcXXbeiFXa_!!1695308781.jpg_430x430q90.jpg',767,1),(16,'Apple/苹果 MacBook Air',5788,48,'https://img.alicdn.com/imgextra/i1/2616970884/O1CN0124D7lI1IOub0ps4CP_!!2616970884.jpg_430x430q90.jpg',123,2),(17,'2018新款 Apple/苹果 MacBook Pro',13888,25,'https://img.alicdn.com/imgextra/i3/2616970884/O1CN017mxmJ01IOub0Db7Yh_!!2616970884.jpg_430x430q90.jpg',758,2),(18,'Lenovo/联想 G50-80',2680,132409,'https://gd2.alicdn.com/imgextra/i4/1072551970/O1CN01rGBFMw1QQIlclexnJ_!!1072551970.jpg_400x400.jpg',456,2),(19,'Dell/戴尔 灵越7000',7298.95,320,'https://img.alicdn.com/imgextra/i2/379092568/O1CN011UqBZ9lBxPFzi8E_!!379092568.jpg_430x430q90.jpg',44,2),(20,'Dell/戴尔 G3 GTX1060MQ',7098.95,387,'https://img.alicdn.com/imgextra/i3/379092568/O1CN01MhQCKf1UqBa0zNHaU_!!379092568.jpg_430x430q90.jpg',44,2),(21,'Dell/戴尔 燃7000 II 八代i5',5598.95,134,'https://img.alicdn.com/imgextra/i4/379092568/O1CN011UqBZ9TA1pazA2t_!!379092568.jpg_430x430q90.jpg',44,2),(22,'HP/惠普 畅游人 游戏本 i5光影精灵',6799,107,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/133668489/O1CN01uJr6IQ2Ca0gZK8Szo_!!133668489.jpg_430x430q90.jpg',564,2),(23,'hp/惠普 星系列14青春版商务办公超薄',4299,589,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i4/4015964904/O1CN010XKADm1m64oqtSnwZ_!!4015964904.jpg_430x430q90.jpg',4,2),(24,'HP/惠普暗影精灵4代光影精灵笔记本',5599,5643,'https://img.alicdn.com/imgextra/i3/3626455794/O1CN01rTqRGS1sfhIhz4CmY_!!3626455794.jpg_430x430q90.jpg',235,2),(25,'Asus/华硕 灵耀S2代S4300FN',4399,1137,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i1/686773455/O1CN014G6v7W1bOQu7dJuUu_!!686773455.jpg_430x430q90.jpg',23,2),(26,'Asus华硕灵耀S2代S4300 8代i5',5299,25,'https://img.alicdn.com/imgextra/i4/2616970884/O1CN01NEbBSL1IOubWhmUxL_!!0-item_pic.jpg_430x430q90.jpg',23,2),(27,'Asus/华硕 顽石Y5000 轻薄商务',3379,662,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i2/2301731819/O1CN01xXZBN61PJ8xKlwgWX_!!2301731819.jpg_430x430q90.jpg',4,2),(28,'外星人alienware15R4',9999,1111,'https://img.alicdn.com/imgextra/i2/2510050218/O1CN01uj1nVC1DTspYVuk9p_!!0-item_pic.jpg_430x430q90.jpg',3,2),(29,'外星人alienware全新m15',16999,36,'https://img.alicdn.com/imgextra/i1/2510050218/O1CN01gpP0vR1DTspqQExbT_!!2510050218.jpg_430x430q90.jpg',795,2),(30,'外星人笔记本电脑17R4',10889.01,1518,'https://gd3.alicdn.com/imgextra/i3/178528126/O1CN01clTfiL29tkvyUqA3G_!!178528126.jpg_400x400.jpg',23,2),(32,'Razer雷蛇蝰蛇',159,745,'https://img.alicdn.com/imgextra/i2/1085315961/O1CN011Tnfrj1tuBS03kCcg_!!0-item_pic.jpg_430x430q90.jpg',23,3),(33,'Razer雷蛇锐蝮蛇竞技版',419,115,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/1085315961/O1CN01T39EwT1tuBRc4L6gS_!!1085315961.jpg_430x430q90.jpg',5,3),(34,'Razer雷蛇巴塞利斯蛇',389,67,'https://img.alicdn.com/imgextra/i3/3488300717/O1CN011HAQRPgrCVotBYN_!!3488300717.jpg_430x430q90.jpg',4,3),(35,'雷柏i35无线蓝牙鼠标',45,34,'https://img.alicdn.com/imgextra/i3/3489034658/TB27IBWseSSBuNjy0FlXXbBpVXa_!!3489034658.jpg_430x430q90.jpg',456,3),(36,'雷柏1680无线鼠标',29.9,416,'https://img.alicdn.com/imgextra/i2/249789133/O1CN01JBCjCh2HKxl7kVFYp_!!0-item_pic.jpg_430x430q90.jpg',567,3),(37,'雷柏M217无线鼠标',39.8,492039,'https://img.alicdn.com/imgextra/i2/1645053348/TB2HX_zeXXXXXb5XXXXXXXXXXXX_!!1645053348.jpg_430x430q90.jpg',578,3),(38,'罗技G502游戏鼠标',379,227,'https://img.alicdn.com/imgextra/i3/2616970884/O1CN01o6uHme1IOuasSy2Fo_!!2616970884.jpg_430x430q90.jpg',23,3),(39,'罗技GPRO WIRELESS',659,227,'https://img.alicdn.com/imgextra/i2/2957170490/O1CN01MX8yp01FUSYWShS4c_!!2957170490.jpg_430x430q90.jpg',67,3),(40,'罗技G102有线电竞机械吃鸡RGB发光游戏鼠标',129,89,'https://img.alicdn.com/imgextra/i2/2616970884/O1CN01UjAiPb1IOucGzlEZZ_!!2616970884.jpg_430x430q90.jpg',95,3),(41,'达尔优牧马人鼠标EM915',209,1629,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i1/690218342/O1CN01y29qEV2BUgT99aJ6D_!!690218342.jpg_430x430q90.jpg',68,3),(42,'达尔优牧马人有线鼠标EM925Pro',369,1196,'https://img.alicdn.com/imgextra/i2/4184875483/O1CN01VbiwNt1qNG9LZxea4_!!0-item_pic.jpg_430x430q90.jpg',85,3),(43,'达尔优牧马人鼠标VX10RGB',99,935,'https://img.alicdn.com/imgextra/https://img.alicdn.com/imgextra/i3/2457181281/O1CN01ESjmwn1LKjsASOAUF_!!2457181281.jpg_430x430q90.jpg',89,3),(44,'英菲克无线可充电鼠标',39.9,1105,'https://img.alicdn.com/imgextra/i1/843421904/O1CN019G7TQV1Pw4bMqbyKh_!!0-item_pic.jpg_430x430q90.jpg',685,3),(45,'英菲克电竞鼠标有线电脑吃鸡宏鼠标',39.8,15385,'https://img.alicdn.com/imgextra/i2/1589613703/O1CN01ZLLKEn1dE19Y9B0Lq_!!0-item_pic.jpg_430x430q90.jpg',0,3),(46,'小米无线鼠标',64,160,'https://img.alicdn.com/imgextra/i4/2616970884/O1CN01ZZuIrG1IOudtt1tIM_!!0-item_pic.jpg_430x430q90.jpg',23,3);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_carts`
--

DROP TABLE IF EXISTS `shopping_carts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shopping_carts` (
  `cart_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `pro_num` int(11) NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `pro_id` (`pro_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `shopping_carts_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_carts`
--

LOCK TABLES `shopping_carts` WRITE;
/*!40000 ALTER TABLE `shopping_carts` DISABLE KEYS */;
INSERT INTO `shopping_carts` VALUES (12,29,8,1),(13,29,14,1),(14,29,8,1),(20,8,1,1);
/*!40000 ALTER TABLE `shopping_carts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_orders`
--

DROP TABLE IF EXISTS `user_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_orders` (
  `ord_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `pro_id` int(11) NOT NULL,
  `ord_time` varchar(50) NOT NULL,
  `ord_address` varchar(50) NOT NULL,
  `ord_status` int(11) DEFAULT '0',
  PRIMARY KEY (`ord_id`),
  KEY `pro_id` (`pro_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `user_orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_orders`
--

LOCK TABLES `user_orders` WRITE;
/*!40000 ALTER TABLE `user_orders` DISABLE KEYS */;
INSERT INTO `user_orders` VALUES (5,8,1,'Fri Apr 26 11:13:13 CST 2019','四川省',0),(6,8,2,'Fri Apr 26 11:13:13 CST 2019','四川省',0),(7,8,1,'Fri Apr 26 11:13:13 CST 2019','四川省',0),(8,8,2,'Fri Apr 26 11:13:13 CST 2019','四川省',0),(9,8,1,'Fri Apr 26 11:14:27 CST 2019','四川省',0),(10,8,2,'Fri Apr 26 11:14:27 CST 2019','四川省',0),(11,8,1,'Fri Apr 26 11:14:27 CST 2019','四川省',0),(12,8,2,'Fri Apr 26 11:14:27 CST 2019','四川省',0),(13,8,2,'Fri Apr 26 11:21:32 CST 2019','四川省',0),(14,8,1,'Fri Apr 26 11:21:32 CST 2019','四川省',0),(15,8,2,'Fri Apr 26 11:21:32 CST 2019','四川省',0),(16,8,2,'Fri Apr 26 11:22:41 CST 2019','四川省',0),(17,8,1,'Fri Apr 26 11:22:41 CST 2019','四川省',0),(18,8,2,'Fri Apr 26 11:22:41 CST 2019','四川省',0),(19,8,2,'Fri Apr 26 11:43:46 CST 2019','四川省',0),(20,8,1,'Fri Apr 26 11:43:46 CST 2019','四川省',0),(21,8,2,'Fri Apr 26 11:43:46 CST 2019','四川省',0),(22,8,2,'Fri Apr 26 11:45:39 CST 2019','四川省',0),(23,8,1,'Fri Apr 26 11:45:39 CST 2019','四川省',0),(24,8,2,'Fri Apr 26 11:45:39 CST 2019','四川省',0),(25,8,2,'Fri Apr 26 11:45:57 CST 2019','四川省',0),(26,8,1,'Fri Apr 26 11:45:57 CST 2019','四川省',0),(27,8,2,'Fri Apr 26 11:45:57 CST 2019','四川省',0),(28,8,2,'Fri Apr 26 11:46:53 CST 2019','四川省',0),(29,8,1,'Fri Apr 26 11:46:53 CST 2019','四川省',0),(30,8,2,'Fri Apr 26 11:46:53 CST 2019','四川省',0),(31,8,2,'Fri Apr 26 11:47:56 CST 2019','四川省',0),(32,8,1,'Fri Apr 26 11:47:56 CST 2019','四川省',0),(33,8,2,'Fri Apr 26 11:47:56 CST 2019','四川省',0),(34,8,2,'Fri Apr 26 11:48:36 CST 2019','四川省',0),(35,8,1,'Fri Apr 26 11:48:36 CST 2019','四川省',0),(36,8,2,'Fri Apr 26 11:48:36 CST 2019','四川省',0),(37,8,2,'Fri Apr 26 11:50:42 CST 2019','四川省',0),(38,8,1,'Fri Apr 26 11:50:42 CST 2019','四川省',0),(39,8,2,'Fri Apr 26 11:50:42 CST 2019','四川省',0),(40,8,1,'Fri Apr 26 11:51:12 CST 2019','四川省',0),(41,8,2,'Fri Apr 26 11:51:12 CST 2019','四川省',0),(42,8,1,'Fri Apr 26 11:51:12 CST 2019','四川省',0),(43,8,2,'Fri Apr 26 11:51:16 CST 2019','四川省',0),(44,8,1,'Fri Apr 26 11:53:38 CST 2019','四川省',0),(45,8,2,'Fri Apr 26 11:53:38 CST 2019','四川省',0),(46,8,1,'Fri Apr 26 11:53:38 CST 2019','四川省',0),(47,8,2,'Fri Apr 26 11:53:38 CST 2019','四川省',0),(48,8,2,'Fri Apr 26 15:01:57 CST 2019','四川省',0),(49,8,1,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(50,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(51,8,1,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(52,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(53,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(54,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(55,8,1,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(56,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(57,8,1,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(58,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(59,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(60,8,2,'Fri Apr 26 15:44:52 CST 2019','四川省',0),(61,8,1,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(62,8,2,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(63,8,1,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(64,8,2,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(65,8,2,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(66,8,2,'Fri Apr 26 16:02:26 CST 2019','四川省',0),(67,8,1,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(68,8,2,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(69,8,1,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(70,8,2,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(71,8,2,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(72,8,2,'Fri Apr 26 16:39:43 CST 2019','四川省',0),(73,8,2,'Sun Apr 28 09:56:05 CST 2019','四川省',0),(74,8,1,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(75,8,2,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(76,8,1,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(77,8,2,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(78,8,2,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(79,8,2,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(80,8,2,'Sun Apr 28 09:57:29 CST 2019','四川省',0),(81,8,2,'Sun Apr 28 11:59:05 CST 2019','四川省',0),(82,8,2,'Sun Apr 28 11:59:21 CST 2019','四川省',0),(83,8,1,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(84,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(85,8,1,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(86,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(87,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(88,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(89,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(90,8,2,'Sun Apr 28 12:05:23 CST 2019','四川省',0),(91,8,1,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(92,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(93,8,1,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(94,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(95,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(96,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(97,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(98,8,2,'Sun Apr 28 12:10:15 CST 2019','四川省',0),(99,8,1,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(100,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(101,8,1,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(102,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(103,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(104,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(105,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(106,8,2,'Sun Apr 28 12:13:58 CST 2019','四川省',0),(107,8,2,'Sun Apr 28 12:14:16 CST 2019','四川省',0),(108,8,2,'Sun Apr 28 15:34:46 CST 2019','四川省',0),(109,8,8,'Sun Apr 28 15:34:46 CST 2019','四川省',0),(110,29,1,'Mon Apr 29 10:36:59 CST 2019','成都市',0),(111,8,3,'Mon Apr 29 12:03:21 CST 2019','四川省',0),(112,8,3,'Mon Apr 29 12:03:21 CST 2019','四川省',0),(113,8,3,'Mon Apr 29 12:03:21 CST 2019','四川省',0),(114,8,11,'Mon Apr 29 14:37:11 CST 2019','四川省',0),(115,8,2,'Mon Apr 29 14:37:27 CST 2019','四川省',0);
/*!40000 ALTER TABLE `user_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_product`
--

DROP TABLE IF EXISTS `user_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_product` (
  `user_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_product`
--

LOCK TABLES `user_product` WRITE;
/*!40000 ALTER TABLE `user_product` DISABLE KEYS */;
INSERT INTO `user_product` VALUES (27,32),(19,29),(29,35),(27,36),(29,41),(19,27),(27,43),(29,38),(27,37),(19,23),(29,34),(19,26),(27,40),(29,42),(19,18),(18,26),(20,18),(28,38),(18,22),(20,29),(28,35),(18,29),(20,25),(28,45),(20,27),(18,19),(28,43),(20,19),(18,25),(28,40),(9,8),(2,9),(10,5),(9,14),(10,13),(2,13),(9,12),(10,2),(2,4),(9,15),(10,3),(2,8),(9,9),(10,10),(2,11),(30,37),(13,25),(14,29),(30,41),(14,19),(13,22),(30,43),(13,29),(14,23),(30,38),(14,24),(13,24),(30,33),(13,17),(14,20),(3,8),(4,12),(23,34),(4,15),(3,14),(23,42),(4,4),(3,15),(23,38),(3,4),(4,8),(23,41),(4,14),(3,12),(23,33),(22,37),(12,25),(5,9),(22,45),(12,18),(5,2),(12,22),(22,41),(5,10),(22,33),(12,27),(5,5),(22,44),(12,17),(5,6),(15,26),(16,17),(15,21),(17,23),(16,29),(15,29),(17,18),(16,25),(15,25),(17,17),(16,27),(15,19),(17,27),(16,24),(24,34),(17,29),(25,32),(24,38),(25,44),(8,10),(24,41),(25,37),(8,2),(24,45),(25,36),(8,3),(24,32),(25,33),(8,6),(6,9),(7,8),(8,11),(6,10),(7,4),(6,7),(26,34),(7,13),(26,38),(6,2),(7,9),(6,6),(26,41),(7,15),(26,45),(26,39);
/*!40000 ALTER TABLE `user_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_score`
--

DROP TABLE IF EXISTS `user_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_score`
--

LOCK TABLES `user_score` WRITE;
/*!40000 ALTER TABLE `user_score` DISABLE KEYS */;
INSERT INTO `user_score` VALUES (1,29,8,2),(2,29,8,6),(3,29,14,2),(4,29,14,6),(5,29,1,2),(6,29,1,10),(7,29,8,2),(8,29,8,6),(9,8,3,2),(10,8,3,6),(11,8,3,2),(12,8,3,6),(13,8,3,6),(14,8,3,10),(15,8,3,10),(16,8,3,10),(17,8,3,2),(18,8,10,2),(19,8,2,2),(20,8,3,2),(21,8,11,2),(22,8,11,6),(23,8,11,10),(24,8,2,2),(25,8,2,6),(26,8,2,10),(27,8,1,2),(28,8,1,6);
/*!40000 ALTER TABLE `user_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(20) NOT NULL,
  `user_mobile` varchar(20) NOT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `users_user_name_uindex` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'testModify','asd123','15933333333','四川省成都市'),(5,'asdasd','asd123','15988888888','四川省成都市'),(7,'zmy','123','12345678909','山东省'),(8,'cr','123456','12345679898','四川省'),(9,'asd','asdasd','11112222123','成都'),(10,'fds','fsdfds','11112222321','成都'),(11,'dgh','dgfh','11112224565','成都'),(12,'jkgj','assd','33332222123','asdasd'),(13,'qwe','qwe','4564654654','成都'),(14,'ghdg','dghdg','5456456456456','成都'),(15,'zmy1','123456','15719496256','成都市'),(16,'zmy2','123456','15719496256','成都市'),(17,'zmy3','123456','15719496256','成都市'),(18,'zmy4','123456','15719496256','成都市'),(19,'zmy5','123456','15719496256','成都市'),(20,'zmy6','123456','15719496256','成都市'),(21,'zmy7','123456','15719496256','成都市'),(22,'zmy8','123456','15719496256','成都市'),(23,'zmy9','123456','15719496256','成都市'),(24,'zmy10','123456','15719496256','成都市'),(25,'zmy11','123456','15719496256','成都市'),(26,'zmy12','123456','15719496256','成都市'),(27,'zmy13','123456','15719496256','成都市'),(28,'zmy14','123456','15719496256','成都市'),(29,'zmy15','123456','15719496256','成都市'),(30,'zmy16','123456','15719496256','成都市'),(31,'zmy17','123456','15719496256','成都市'),(32,'zmy18','123456','15719496256','成都市'),(33,'zmy19','123456','15719496256','成都市'),(34,'zmy20','123456','15719496256','成都市'),(35,'zmy21','123456','15719496256','成都市');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-29 14:52:59
