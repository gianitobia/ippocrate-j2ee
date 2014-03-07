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
-- Table structure for table `reparto`
--

DROP TABLE IF EXISTS `reparto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reparto` (
  `ID` bigint(20) NOT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `OSPEDALE_ID` bigint(20) DEFAULT NULL,
  `PRIMARIO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_REPARTO_PRIMARIO_ID` (`PRIMARIO_ID`),
  KEY `FK_REPARTO_OSPEDALE_ID` (`OSPEDALE_ID`),
  CONSTRAINT `FK_REPARTO_OSPEDALE_ID` FOREIGN KEY (`OSPEDALE_ID`) REFERENCES `strutturamedica` (`ID`),
  CONSTRAINT `FK_REPARTO_PRIMARIO_ID` FOREIGN KEY (`PRIMARIO_ID`) REFERENCES `medico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparto`
--

LOCK TABLES `reparto` WRITE;
/*!40000 ALTER TABLE `reparto` DISABLE KEYS */;
INSERT INTO `reparto` VALUES (44,'Reparto analisi biologiche',7,NULL),(45,'Reparto cardiologia',7,NULL),(46,'Reparto rianimazione',10,NULL),(47,'Reparto terapia intensiva',9,NULL),(48,'Reparto radiologia',9,NULL);
/*!40000 ALTER TABLE `reparto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-06 23:14:22
