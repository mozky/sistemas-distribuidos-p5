-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: practica5
-- ------------------------------------------------------
-- Server version	5.5.58-log

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
-- Table structure for table `equipos`
--

CREATE DATABASE distribuidos;
USE distribuidos;

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `equipos` (
  `ID` int(5) NOT NULL,
  `IP` varchar(50) DEFAULT NULL,
  `Nombre` varchar(70) DEFAULT NULL,
  `Latencia` float DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horacentral`
--

DROP TABLE IF EXISTS `horacentral`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horacentral` (
  `ID` int(5) NOT NULL,
  `hUTC` varchar(20) DEFAULT NULL,
  `hLocal` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horacentral`
--

LOCK TABLES `horacentral` WRITE;
/*!40000 ALTER TABLE `horacentral` DISABLE KEYS */;
/*!40000 ALTER TABLE `horacentral` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horaequipos`
--

DROP TABLE IF EXISTS `horaequipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `horaequipos` (
  `ID` int(5) NOT NULL,
  `IDhUTC` int(5) DEFAULT NULL,
  `IDEquipo` int(5) DEFAULT NULL,
  `hEquipo` varchar(20) DEFAULT NULL,
  `aEquipo` varchar(20) DEFAULT NULL,
  `ralentizar` float DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `HEquiEqui` (`IDEquipo`),
  KEY `HEquiCen` (`IDhUTC`),
  CONSTRAINT `HEquiCen` FOREIGN KEY (`IDhUTC`) REFERENCES `horacentral` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `HEquiEqui` FOREIGN KEY (`IDEquipo`) REFERENCES `equipos` (`ID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horaequipos`
--

LOCK TABLES `horaequipos` WRITE;
/*!40000 ALTER TABLE `horaequipos` DISABLE KEYS */;
/*!40000 ALTER TABLE `horaequipos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29 20:40:20
