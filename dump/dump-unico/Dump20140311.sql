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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `agenda` (
  `ID` bigint(20) NOT NULL,
  `CLIENT_ID` varchar(255) DEFAULT NULL,
  `DEVELOPER_KEY` varchar(255) DEFAULT NULL,
  `ID_CALENDARIO` varchar(255) DEFAULT NULL,
  `NOME_UTENTE` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SECRET_KEY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL),(2,NULL,NULL,NULL,NULL,NULL,NULL),(3,NULL,NULL,NULL,NULL,NULL,NULL),(4,NULL,NULL,NULL,NULL,NULL,NULL),(5,NULL,NULL,NULL,NULL,NULL,NULL),(6,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `cartellaclinica` VALUES (3,'Scoliosi evidente.  Il padre all\'età di 45 anni è stato colpito da angina pectoris, Il nonno materno era diabetico.'),(4,'Nella fase infantile è stata soggetta a tutte le malattie infantili, compresa la rosolia.  All\'età di anni 16 si è manifestata l\'allergia al glutine. Sin dall\'età di 18 anni si è manifestata ipertensione  arteriosa.'),(5,'Nell\'anno 2000 ha subito appendicectomia.  Nell\'anno 2005 intervento per spina ossea all\'arcata dentale superiore.  Nell\'anno 2011 Angioplastica PTCA + Stent.'),(6,'Durante l\'anno 2004 accusava problemi respiratori che intensificavano con l\'abbassarsi della temperatura  atmosferica.  Nonostante la vaccinazione anti-influenzale, è stata colpita da sindrome influenzale nel mese di marzo.');
/*!40000 ALTER TABLE `cartellaclinica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartellaclinica_refertomedico`
--

DROP TABLE IF EXISTS `cartellaclinica_refertomedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartellaclinica_refertomedico` (
  `CartellaClinica_ID` bigint(20) NOT NULL,
  `lista_referti_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`CartellaClinica_ID`,`lista_referti_ID`),
  KEY `FK_CARTELLACLINICA_REFERTOMEDICO_lista_referti_ID` (`lista_referti_ID`),
  CONSTRAINT `CARTELLACLINICA_REFERTOMEDICO_CartellaClinica_ID` FOREIGN KEY (`CartellaClinica_ID`) REFERENCES `cartellaclinica` (`ID`),
  CONSTRAINT `FK_CARTELLACLINICA_REFERTOMEDICO_lista_referti_ID` FOREIGN KEY (`lista_referti_ID`) REFERENCES `refertomedico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartellaclinica_refertomedico`
--

LOCK TABLES `cartellaclinica_refertomedico` WRITE;
/*!40000 ALTER TABLE `cartellaclinica_refertomedico` DISABLE KEYS */;
INSERT INTO `cartellaclinica_refertomedico` VALUES (3,41),(4,42),(5,43),(6,44),(3,45),(3,51),(4,101);
/*!40000 ALTER TABLE `cartellaclinica_refertomedico` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `medico_prestazione`
--

DROP TABLE IF EXISTS `medico_prestazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `medico_prestazione` (
  `miePrestazioni_ID` bigint(20) NOT NULL,
  `lista_medici_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`miePrestazioni_ID`,`lista_medici_ID`),
  KEY `FK_MEDICO_PRESTAZIONE_lista_medici_ID` (`lista_medici_ID`),
  CONSTRAINT `FK_MEDICO_PRESTAZIONE_lista_medici_ID` FOREIGN KEY (`lista_medici_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_MEDICO_PRESTAZIONE_miePrestazioni_ID` FOREIGN KEY (`miePrestazioni_ID`) REFERENCES `prestazione` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_prestazione`
--

LOCK TABLES `medico_prestazione` WRITE;
/*!40000 ALTER TABLE `medico_prestazione` DISABLE KEYS */;
INSERT INTO `medico_prestazione` VALUES (36,2),(34,6),(39,8),(34,9),(36,9),(39,10),(39,11);
/*!40000 ALTER TABLE `medico_prestazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paziente`
--

DROP TABLE IF EXISTS `paziente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paziente` (
  `ID` bigint(20) NOT NULL,
  `CF` varchar(255) DEFAULT NULL,
  `COGNOME` varchar(255) DEFAULT NULL,
  `DATA_NASCITA` date DEFAULT NULL,
  `INDIRIZZO` varchar(255) DEFAULT NULL,
  `LUOGO_NASCITA` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `SESSO` varchar(255) DEFAULT NULL,
  `REPARTO_RICOVERATO_ID` bigint(20) DEFAULT NULL,
  `STUDIOMEDICO_ID` bigint(20) DEFAULT NULL,
  `CARTELLA_CLINICA_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PAZIENTE_CARTELLA_CLINICA_ID` (`CARTELLA_CLINICA_ID`),
  KEY `FK_PAZIENTE_STUDIOMEDICO_ID` (`STUDIOMEDICO_ID`),
  KEY `FK_PAZIENTE_REPARTO_RICOVERATO_ID` (`REPARTO_RICOVERATO_ID`),
  CONSTRAINT `FK_PAZIENTE_CARTELLA_CLINICA_ID` FOREIGN KEY (`CARTELLA_CLINICA_ID`) REFERENCES `cartellaclinica` (`ID`),
  CONSTRAINT `FK_PAZIENTE_REPARTO_RICOVERATO_ID` FOREIGN KEY (`REPARTO_RICOVERATO_ID`) REFERENCES `reparto` (`ID`),
  CONSTRAINT `FK_PAZIENTE_STUDIOMEDICO_ID` FOREIGN KEY (`STUDIOMEDICO_ID`) REFERENCES `strutturamedica` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paziente`
--

LOCK TABLES `paziente` WRITE;
/*!40000 ALTER TABLE `paziente` DISABLE KEYS */;
INSERT INTO `paziente` VALUES (11,'11','Busso','1988-05-08','Via Gottardo','Torino','Marco','1','M',NULL,NULL,3),(12,'12','Varesano','1988-09-27','Corso Salvemini','Torino','Marco','1','M',NULL,NULL,4),(13,'13','Giani','1988-03-09','Via Ulderico Mattoccia','Velletri','Tobia','1','M',NULL,NULL,5),(14,'14','Basile','1988-08-22','Corso Regina Margherita','Bari','Alessandro','1','M',NULL,NULL,6);
/*!40000 ALTER TABLE `paziente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prenotazione` (
  `ID` bigint(20) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `DATA_PRENOTAZIONE` date DEFAULT NULL,
  `PAZIENTE_ID` bigint(20) DEFAULT NULL,
  `STRUTTURA_MEDICA_ID` bigint(20) DEFAULT NULL,
  `SALA_ID` bigint(20) DEFAULT NULL,
  `TIPO_PRESTAZIONE_ID` bigint(20) DEFAULT NULL,
  `MEDICO_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRENOTAZIONE_MEDICO_ID` (`MEDICO_ID`),
  KEY `FK_PRENOTAZIONE_SALA_ID` (`SALA_ID`),
  KEY `FK_PRENOTAZIONE_STRUTTURA_MEDICA_ID` (`STRUTTURA_MEDICA_ID`),
  KEY `FK_PRENOTAZIONE_TIPO_PRESTAZIONE_ID` (`TIPO_PRESTAZIONE_ID`),
  KEY `FK_PRENOTAZIONE_PAZIENTE_ID` (`PAZIENTE_ID`),
  CONSTRAINT `FK_PRENOTAZIONE_MEDICO_ID` FOREIGN KEY (`MEDICO_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_PRENOTAZIONE_PAZIENTE_ID` FOREIGN KEY (`PAZIENTE_ID`) REFERENCES `paziente` (`ID`),
  CONSTRAINT `FK_PRENOTAZIONE_SALA_ID` FOREIGN KEY (`SALA_ID`) REFERENCES `sala` (`ID`),
  CONSTRAINT `FK_PRENOTAZIONE_STRUTTURA_MEDICA_ID` FOREIGN KEY (`STRUTTURA_MEDICA_ID`) REFERENCES `strutturamedica` (`ID`),
  CONSTRAINT `FK_PRENOTAZIONE_TIPO_PRESTAZIONE_ID` FOREIGN KEY (`TIPO_PRESTAZIONE_ID`) REFERENCES `prestazione` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (81,'PrenotazioneMedico','2016-05-13',11,10,NULL,34,6);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `prescrizionemedica` VALUES (51,'si','2014-03-01','2014-03-22','Tegretol',2,2,11,41),(52,'no','2014-07-05','2014-09-05','aspirina',1,2,11,51),(53,'no','2014-03-18','2014-03-22','Benazepril',5,8,13,43),(55,'no','2014-03-21','2014-07-19','Palexia',6,6,11,45),(102,'no','2014-07-05','2014-09-05','Maalox',3,2,12,101);
/*!40000 ALTER TABLE `prescrizionemedica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestazione`
--

DROP TABLE IF EXISTS `prestazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestazione` (
  `ID` bigint(20) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `DURATA` int(11) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestazione`
--

LOCK TABLES `prestazione` WRITE;
/*!40000 ALTER TABLE `prestazione` DISABLE KEYS */;
INSERT INTO `prestazione` VALUES (33,'PrestazioneSala',30,'Esame urine'),(34,'PrestazioneMedico',30,'Visita cardiologica'),(36,'PrestazioneMedico',30,'Gastroscopia'),(37,'PrestazioneSala',15,'Risonanza magnetica'),(38,'PrestazioneSala',30,'TAC'),(39,'PrestazioneMedico',15,'Ecografia addominale'),(40,'PrestazioneSala',30,'Elettroencefalogramma');
/*!40000 ALTER TABLE `prestazione` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `refertomedico_prescrizionemedica`
--

DROP TABLE IF EXISTS `refertomedico_prescrizionemedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refertomedico_prescrizionemedica` (
  `RefertoMedico_ID` bigint(20) NOT NULL,
  `lista_prescrizioni_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`RefertoMedico_ID`,`lista_prescrizioni_ID`),
  KEY `REFERTOMEDICOPRESCRIZIONEMEDICAlistaprescrizioniID` (`lista_prescrizioni_ID`),
  CONSTRAINT `REFERTOMEDICOPRESCRIZIONEMEDICAlistaprescrizioniID` FOREIGN KEY (`lista_prescrizioni_ID`) REFERENCES `prescrizionemedica` (`ID`),
  CONSTRAINT `REFERTOMEDICO_PRESCRIZIONEMEDICA_RefertoMedico_ID` FOREIGN KEY (`RefertoMedico_ID`) REFERENCES `refertomedico` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refertomedico_prescrizionemedica`
--

LOCK TABLES `refertomedico_prescrizionemedica` WRITE;
/*!40000 ALTER TABLE `refertomedico_prescrizionemedica` DISABLE KEYS */;
INSERT INTO `refertomedico_prescrizionemedica` VALUES (41,51),(51,52),(43,53),(45,55),(101,102);
/*!40000 ALTER TABLE `refertomedico_prescrizionemedica` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `reparto_medico`
--

DROP TABLE IF EXISTS `reparto_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reparto_medico` (
  `Reparto_ID` bigint(20) NOT NULL,
  `lista_medici_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`Reparto_ID`,`lista_medici_ID`),
  KEY `FK_REPARTO_MEDICO_lista_medici_ID` (`lista_medici_ID`),
  CONSTRAINT `FK_REPARTO_MEDICO_lista_medici_ID` FOREIGN KEY (`lista_medici_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_REPARTO_MEDICO_Reparto_ID` FOREIGN KEY (`Reparto_ID`) REFERENCES `reparto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparto_medico`
--

LOCK TABLES `reparto_medico` WRITE;
/*!40000 ALTER TABLE `reparto_medico` DISABLE KEYS */;
INSERT INTO `reparto_medico` VALUES (44,3),(46,3),(47,6),(48,8),(45,11);
/*!40000 ALTER TABLE `reparto_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sala`
--

DROP TABLE IF EXISTS `sala`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sala` (
  `ID` bigint(20) NOT NULL,
  `TIPOLABORATORIO` varchar(255) DEFAULT NULL,
  `REPARTO_ID` bigint(20) DEFAULT NULL,
  `STUDIOMEDICO_ID` bigint(20) DEFAULT NULL,
  `AGENDA_ID` bigint(20) DEFAULT NULL,
  `MEDICO_RESPONSABILE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SALA_MEDICO_RESPONSABILE_ID` (`MEDICO_RESPONSABILE_ID`),
  KEY `FK_SALA_AGENDA_ID` (`AGENDA_ID`),
  KEY `FK_SALA_REPARTO_ID` (`REPARTO_ID`),
  KEY `FK_SALA_STUDIOMEDICO_ID` (`STUDIOMEDICO_ID`),
  CONSTRAINT `FK_SALA_AGENDA_ID` FOREIGN KEY (`AGENDA_ID`) REFERENCES `agenda` (`ID`),
  CONSTRAINT `FK_SALA_MEDICO_RESPONSABILE_ID` FOREIGN KEY (`MEDICO_RESPONSABILE_ID`) REFERENCES `medico` (`ID`),
  CONSTRAINT `FK_SALA_REPARTO_ID` FOREIGN KEY (`REPARTO_ID`) REFERENCES `reparto` (`ID`),
  CONSTRAINT `FK_SALA_STUDIOMEDICO_ID` FOREIGN KEY (`STUDIOMEDICO_ID`) REFERENCES `strutturamedica` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sala`
--

LOCK TABLES `sala` WRITE;
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT INTO `sala` VALUES (55,'Sala analisi bio',NULL,8,NULL,2),(56,'Sala analisi bio ospedale',44,NULL,NULL,6),(57,'Sala operatoria',45,NULL,NULL,6),(58,'Sala di gastrenterologia',NULL,11,NULL,2),(59,'Sala rianimazione',46,NULL,NULL,8),(60,'Sala terapia intensiva',NULL,12,NULL,6),(61,'Sala raggi',NULL,11,NULL,8);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('SEQ_GEN',200);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strutturamedica`
--

DROP TABLE IF EXISTS `strutturamedica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `strutturamedica` (
  `ID` bigint(20) NOT NULL,
  `DTYPE` varchar(31) DEFAULT NULL,
  `INDIRIZZO` varchar(255) DEFAULT NULL,
  `NOME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strutturamedica`
--

LOCK TABLES `strutturamedica` WRITE;
/*!40000 ALTER TABLE `strutturamedica` DISABLE KEYS */;
INSERT INTO `strutturamedica` VALUES (7,'Ospedale','Piazza Carducci','Molinette'),(8,'StudioMedico','Corso Francia','Centro Salute'),(9,'Ospedale','Via Gottardo','Giovanni Bosco'),(10,'Ospedale','Via Magellano','Mauriziano'),(11,'StudioMedico','Via Duca degli Abruzzi','Villa Montallegro'),(12,'StudioMedico','Via Po','De stefanis');
/*!40000 ALTER TABLE `strutturamedica` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-11 18:53:32
