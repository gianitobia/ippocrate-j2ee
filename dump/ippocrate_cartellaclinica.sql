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
-- Table structure for table `cartellaclinica`
--

DROP TABLE IF EXISTS `cartellaclinica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartellaclinica` (
  `ID` bigint(20) NOT NULL,
  `ANAMNESI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartellaclinica`
--

LOCK TABLES `cartellaclinica` WRITE;
/*!40000 ALTER TABLE `cartellaclinica` DISABLE KEYS */;
INSERT INTO `cartellaclinica` VALUES (3,'Scoliosi evidente.  Il padre all’età di 45 anni è stato colpito da angina pectoris, Il nonno materno era diabetico.'),(4,'Nella fase infantile è stata soggetta a tutte le malattie infantili, compresa la rosolia.  All’età di anni 16 si è manifestata l’allergia al glutine. Sin dall’età di 18 anni si è manifestata ipertensione  arteriosa.'),(5,'Nell’anno 2000 ha subito appendicectomia.  Nell’anno 2005 intervento per spina ossea all’arcata dentale superiore.  Nell’anno 2011 Angioplastica PTCA + Stent.'),(6,'Durante l’anno 2004 accusava problemi respiratori che intensificavano con l’abbassarsi della temperatura  atmosferica.  Nonostante la vaccinazione anti-influenzale, è stata colpita da sindrome influenzale nel mese di marzo.');
/*!40000 ALTER TABLE `cartellaclinica` ENABLE KEYS */;
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
