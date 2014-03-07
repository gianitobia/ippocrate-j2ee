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
-- Table structure for table `medico_paziente`
--

DROP TABLE IF EXISTS `medico_paziente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico_paziente` (
  `MedicoEsterno_ID` bigint(20) NOT NULL,
  `lista_pazienti_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`MedicoEsterno_ID`,`lista_pazienti_ID`),
  KEY `FK_MEDICO_PAZIENTE_lista_pazienti_ID` (`lista_pazienti_ID`),
  CONSTRAINT `FK_MEDICO_PAZIENTE_lista_pazienti_ID` FOREIGN KEY (`lista_pazienti_ID`) REFERENCES `paziente` (`ID`),
  CONSTRAINT `FK_MEDICO_PAZIENTE_MedicoEsterno_ID` FOREIGN KEY (`MedicoEsterno_ID`) REFERENCES `medico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_paziente`
--

LOCK TABLES `medico_paziente` WRITE;
/*!40000 ALTER TABLE `medico_paziente` DISABLE KEYS */;
INSERT INTO `medico_paziente` VALUES (2,11),(2,12),(9,13),(10,14);
/*!40000 ALTER TABLE `medico_paziente` ENABLE KEYS */;
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
