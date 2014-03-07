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
-- Table structure for table `prescrizionemedica`
--

DROP TABLE IF EXISTS `prescrizionemedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prescrizionemedica` (
  `ID` bigint(20) NOT NULL,
  `CONSEGNATA` varchar(255) DEFAULT NULL,
  `DATA_PRESCRIZIONE` date DEFAULT NULL,
  `DATA_SCADENZA` date DEFAULT NULL,
  `MEDICINALE` varchar(255) DEFAULT NULL,
  `NUMERO_CONFEZIONI` int(11) DEFAULT NULL,
  `MEDICO_ID` bigint(20) DEFAULT NULL,
  `PAZIENTE_ID` bigint(20) DEFAULT NULL,
  `REFERTO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRESCRIZIONEMEDICA_MEDICO_ID` (`MEDICO_ID`),
  KEY `FK_PRESCRIZIONEMEDICA_REFERTO_ID` (`REFERTO_ID`),
  KEY `FK_PRESCRIZIONEMEDICA_PAZIENTE_ID` (`PAZIENTE_ID`),
  CONSTRAINT `FK_PRESCRIZIONEMEDICA_MEDICO_ID` FOREIGN KEY (`MEDICO_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_PRESCRIZIONEMEDICA_PAZIENTE_ID` FOREIGN KEY (`PAZIENTE_ID`) REFERENCES `paziente` (`ID`),
  CONSTRAINT `FK_PRESCRIZIONEMEDICA_REFERTO_ID` FOREIGN KEY (`REFERTO_ID`) REFERENCES `refertomedico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prescrizionemedica`
--

LOCK TABLES `prescrizionemedica` WRITE;
/*!40000 ALTER TABLE `prescrizionemedica` DISABLE KEYS */;
INSERT INTO `prescrizionemedica` VALUES (51,'si','2014-03-01','2014-03-22','Tegretol',2,2,11,41),(52,'no','2014-03-03','2014-03-06','Milicom',1,6,12,42),(53,'no','2014-03-18','2014-03-22','Benazepril',5,8,13,43),(54,'si','2013-07-24','2014-07-26','Meclizina',3,10,14,44),(55,'no','2014-03-21','2014-07-19','Palexia',6,6,11,45);
/*!40000 ALTER TABLE `prescrizionemedica` ENABLE KEYS */;
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
