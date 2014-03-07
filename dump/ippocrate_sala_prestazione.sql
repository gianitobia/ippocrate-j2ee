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
-- Table structure for table `sala_prestazione`
--

DROP TABLE IF EXISTS `sala_prestazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala_prestazione` (
  `lista_sale_ID` bigint(20) NOT NULL,
  `lista_prestazioni_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`lista_sale_ID`,`lista_prestazioni_ID`),
  KEY `FK_SALA_PRESTAZIONE_lista_prestazioni_ID` (`lista_prestazioni_ID`),
  CONSTRAINT `FK_SALA_PRESTAZIONE_lista_prestazioni_ID` FOREIGN KEY (`lista_prestazioni_ID`) REFERENCES `prestazione` (`ID`),
  CONSTRAINT `FK_SALA_PRESTAZIONE_lista_sale_ID` FOREIGN KEY (`lista_sale_ID`) REFERENCES `sala` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala_prestazione`
--

LOCK TABLES `sala_prestazione` WRITE;
/*!40000 ALTER TABLE `sala_prestazione` DISABLE KEYS */;
INSERT INTO `sala_prestazione` VALUES (56,33),(57,34),(58,36),(61,37),(61,38),(59,39),(60,40);
/*!40000 ALTER TABLE `sala_prestazione` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-06 23:14:20
