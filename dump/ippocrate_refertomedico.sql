CREATE DATABASE  IF NOT EXISTS `ippocrate` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ippocrate`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: ippocrate
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `refertomedico`
--

DROP TABLE IF EXISTS `refertomedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refertomedico` (
  `ID` bigint(20) NOT NULL,
  `DATAVISITA` date DEFAULT NULL,
  `DIAGNOSI` varchar(255) DEFAULT NULL,
  `LISTA_IMAGES` varchar(255) DEFAULT NULL,
  `MEDICO_ID` bigint(20) DEFAULT NULL,
  `PAZIENTE_ID` bigint(20) DEFAULT NULL,
  `TIPOVISITA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REFERTOMEDICO_MEDICO_ID` (`MEDICO_ID`),
  KEY `FK_REFERTOMEDICO_TIPOVISITA_ID` (`TIPOVISITA_ID`),
  KEY `FK_REFERTOMEDICO_PAZIENTE_ID` (`PAZIENTE_ID`),
  CONSTRAINT `FK_REFERTOMEDICO_MEDICO_ID` FOREIGN KEY (`MEDICO_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_REFERTOMEDICO_PAZIENTE_ID` FOREIGN KEY (`PAZIENTE_ID`) REFERENCES `paziente` (`ID`),
  CONSTRAINT `FK_REFERTOMEDICO_TIPOVISITA_ID` FOREIGN KEY (`TIPOVISITA_ID`) REFERENCES `prestazione` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refertomedico`
--

LOCK TABLES `refertomedico` WRITE;
/*!40000 ALTER TABLE `refertomedico` DISABLE KEYS */;
INSERT INTO `refertomedico` VALUES (41,'2014-03-01','attività celebrale nella norma',NULL,2,11,40),(42,'2013-01-25','dolore addominale superiore. lacerazioni interne',NULL,6,12,39),(43,'2014-02-20','nessun problema cardiovascolare',NULL,8,13,34),(44,'2014-03-01','alterazione dischi vertebrali',NULL,2,14,37),(45,'2014-03-06','forti palpitazioni',NULL,9,11,34),(51,'2014-07-05','bruciore di stomaco causa gastrite','file2',2,11,36),(101,'2014-07-05','infiammazione della mucosa protettiva delle pareti dello stomaco','file1',2,12,36);
/*!40000 ALTER TABLE `refertomedico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-09 20:21:23
