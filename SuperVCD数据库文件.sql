-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 123.206.49.150    Database: supervcd
-- ------------------------------------------------------
-- Server version	5.5.44

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `AddressID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `Label` varchar(45) DEFAULT NULL,
  `isDefault` int(11) NOT NULL,
  PRIMARY KEY (`AddressID`,`UserID`),
  KEY `UserToAddress_idx` (`UserID`),
  CONSTRAINT `UserToAddress` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (0,9,'内蒙古自治区呼和浩特市赛罕区大学西路内蒙古大学','学校',0),(2,9,'内蒙古自治区呼和浩特市赛罕区大学西路内蒙古大学','学校',0),(3,9,'内蒙古自治区呼和浩特市赛罕区大学西路内蒙古大学','学校',0),(4,9,'内蒙古自治区呼和浩特市赛罕区大学西路内蒙古大学','学校',0),(5,9,'内蒙古自治区呼和浩特市赛罕区大学西路235号内蒙古大学','家',1),(8,1,'123','12',0),(9,10,';;;;;',';;;;;',0),(10,10,'afaf','afaf',1),(11,10,'adad','adasf',0);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderid` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `vcdid` varchar(45) NOT NULL,
  `addressid` varchar(45) NOT NULL,
  `ordertime` datetime NOT NULL,
  PRIMARY KEY (`orderid`,`userid`,`vcdid`,`addressid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (8,10,'9','10','2018-10-18 01:04:43'),(9,9,'9','0','2018-10-18 01:13:44'),(10,9,'9','5','2018-10-18 11:14:59');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `singer`
--

DROP TABLE IF EXISTS `singer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `singer` (
  `SingerID` int(11) NOT NULL,
  `SingerName` varchar(45) NOT NULL,
  `SingerDis` varchar(100) NOT NULL,
  PRIMARY KEY (`SingerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `singer`
--

LOCK TABLES `singer` WRITE;
/*!40000 ALTER TABLE `singer` DISABLE KEYS */;
INSERT INTO `singer` VALUES (1,'段奥娟','段奥娟，2001年12月23日出生于四川省成都市，中国流行乐女歌手、女子演唱组合火箭少女101成员。'),(2,'好妹妹乐队','好妹妹，中国内地民谣双人演唱组合，由秦昊、张小厚组成'),(3,'花粥','花粥，1993年7月21日出生在新疆乌鲁木齐，中国内地民谣女歌手、独立音乐人。'),(4,'火箭少女101','火箭少女101是由哇唧唧哇娱乐、海南周天娱乐有限公司于2018年推出的中国内地女子演唱组合');
/*!40000 ALTER TABLE `singer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(45) NOT NULL,
  `Name` varchar(45) DEFAULT NULL,
  `UserAge` int(11) DEFAULT NULL,
  `Password` varchar(45) NOT NULL,
  `UserType` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `UserName_UNIQUE` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'123','魏志林',20,'12','user'),(2,'admin','魏志林',20,'12','admin'),(9,'12','魏志林',20,'123','user'),(10,'1234','魏志林',20,'1234','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vcdinfo`
--

DROP TABLE IF EXISTS `vcdinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vcdinfo` (
  `VCDID` int(11) NOT NULL AUTO_INCREMENT,
  `VCDName` varchar(45) NOT NULL,
  `VCDIcon` varchar(45) NOT NULL,
  `VCDUnitPrice` int(11) NOT NULL,
  `VCDDescribe` varchar(45) NOT NULL,
  `SingerID` int(11) NOT NULL,
  `VCDType` int(11) NOT NULL,
  PRIMARY KEY (`VCDID`,`SingerID`),
  UNIQUE KEY `VCDName_UNIQUE` (`VCDName`),
  KEY `SingerToVcdInfo_idx` (`SingerID`),
  CONSTRAINT `SingerToVcdInfo` FOREIGN KEY (`SingerID`) REFERENCES `singer` (`SingerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vcdinfo`
--

LOCK TABLES `vcdinfo` WRITE;
/*!40000 ALTER TABLE `vcdinfo` DISABLE KEYS */;
INSERT INTO `vcdinfo` VALUES (9,'段奥娟专辑','/image/段奥娟.jpg',50,'好听',1,1),(10,'花粥专辑1','/image/花粥.jpg',70,'好听',3,3),(11,'花粥专辑2','/image/花粥.jpg',80,'好听',3,3),(12,'花粥专辑3','/image/花粥.jpg',90,'好听',3,3),(13,'好妹妹专辑','/image/好妹妹乐队.jpg',30,'好听',2,2),(17,'火箭少女101','/image/火箭少女101.jpg',59,'好听',4,2);
/*!40000 ALTER TABLE `vcdinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vcdsong`
--

DROP TABLE IF EXISTS `vcdsong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vcdsong` (
  `vcdsongid` int(11) NOT NULL,
  `vcdsongname` varchar(45) NOT NULL,
  `vcdSongPath` varchar(100) NOT NULL,
  `vcdSongTime` int(11) NOT NULL,
  `vcdId` int(11) NOT NULL,
  PRIMARY KEY (`vcdsongid`,`vcdId`),
  KEY `VcdinfoToVcdsong_idx` (`vcdId`),
  CONSTRAINT `VcdinfoToVcdsong` FOREIGN KEY (`vcdId`) REFERENCES `vcdinfo` (`VCDID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vcdsong`
--

LOCK TABLES `vcdsong` WRITE;
/*!40000 ALTER TABLE `vcdsong` DISABLE KEYS */;
INSERT INTO `vcdsong` VALUES (1,'陪我长大','D:\\CloudMusic\\段奥娟 - 陪我长大.mp3',236,9),(2,'陪我长大(伴奏)','D:\\CloudMusic\\段奥娟 - 陪我长大 (伴奏).mp3',236,9),(3,'二十岁的某一天','D:\\CloudMusic\\花粥 - 二十岁的某一天.mp3',145,10),(4,'我说我当不了县长','D:\\CloudMusic\\花粥 - 我说我当不了县长.mp3',190,11),(5,'小相思（demo）','D:\\CloudMusic\\花粥 - 小相思（demo）.mp3',184,12),(6,'一封家书','D:\\CloudMusic\\好妹妹乐队 - 一封家书.mp3',279,13),(7,'卡路里 ','D:\\CloudMusic\\火箭少女101 - 卡路里.mp3',232,17),(8,'卡路里 (伴奏)','D:\\CloudMusic\\火箭少女101 - 卡路里 (伴奏).mp3',232,17);
/*!40000 ALTER TABLE `vcdsong` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-18 12:48:25
