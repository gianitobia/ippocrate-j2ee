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
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico` (
  `ID` bigint(20) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `COGNOME` varchar(255) DEFAULT NULL,
  `DATA_NASCITA` date DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PIN_CODE` varchar(255) DEFAULT NULL,
  `SPECIALIZZAZIONE` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `VISITE_ID` bigint(20) DEFAULT NULL,
  `STUDIOMEDICO_ID` bigint(20) DEFAULT NULL,
  `NUM_UFFICIO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MEDICO_STUDIOMEDICO_ID` (`STUDIOMEDICO_ID`),
  KEY `FK_MEDICO_VISITE_ID` (`VISITE_ID`),
  CONSTRAINT `FK_MEDICO_STUDIOMEDICO_ID` FOREIGN KEY (`STUDIOMEDICO_ID`) REFERENCES `strutturamedica` (`ID`),
  CONSTRAINT `FK_MEDICO_VISITE_ID` FOREIGN KEY (`VISITE_ID`) REFERENCES `agenda` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (2,'MedicoEsterno','Rossi','1960-12-01','Mario','1','1','Oculista','rossi',1,8,NULL),(3,'MedicoOspedaliero','Neri','1952-07-19','Franco','1','1','Chirurgo','neri',6,NULL,'25'),(6,'MedicoOspedaliero','Bianchi','1962-12-01','Matteo','1','1','Cardiologo','bianchi',2,NULL,'26'),(8,'MedicoOspedaliero','Blu','1958-11-11','Carlo','1','1','Urologo','blu',3,NULL,'28'),(9,'MedicoEsterno','Verdi','1961-05-14','Paolo','1','1','Anestesista','verdi',4,12,NULL),(10,'MedicoEsterno','Gialli','1959-11-18','Francesco','1','1','Fisiatra','gialli',5,11,NULL),(11,'MedicoOspedaliero','Marrone','1966-01-15','Sereno','1','1','Fisioterapista','marrone',7,NULL,'29');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-06 23:14:21
