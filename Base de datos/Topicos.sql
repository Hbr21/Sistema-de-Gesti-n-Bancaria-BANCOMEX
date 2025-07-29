-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: topicos
-- ------------------------------------------------------
-- Server version	9.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int NOT NULL AUTO_INCREMENT,
  `nombre_cliente` varchar(50) NOT NULL,
  `nip_cliente` varbinary(32) NOT NULL,
  `numero_tarjeta` varchar(20) NOT NULL,
  `saldo` decimal(10,2) NOT NULL DEFAULT '0.00',
  `correo_cliente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `nip_cliente` (`nip_cliente`),
  UNIQUE KEY `numero_tarjeta` (`numero_tarjeta`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'JUAN',_binary '\€ˇSA¨≠^*X\€N˝^r\‚Ÿ†®C¢é±<h-\n:=\Ê','41114321432143214321',2000.00,'garciaheber138@gmail.com'),(2,'DIEGO',_binary '˛\ZΩ\Z!SS\¬3\÷\‡	a>ï\Ó\ƒ%82ßaØ(ˇ7¨Z','41111234123412341234',6000.00,'garciabautistaheberdejesus@gmail.com'),(4,'OSCAR',_binary 'z]ıˇ†\ﬁ\¬\"çê∏–†Ò∞v{tã\nA1L0u∏(ûN?','41114321432143214444',1007000.00,'oalbinodiaz@gmail.com'),(5,'CHRISTIAN',_binary 'aa≤Éè˙l\·{Ñ\€;E¥¯CxU\ÏÙ>u\ﬁ-\Z\–\0é™\È\Z†','41114321432143214333',1000.00,'electrofashioon03@gmail.com'),(6,'Tomas',_binary 'àçÚZ\„WrBJVqR°\ﬁyD@\‡\Í\\˛\Ê((3:EjPn','45774978503040078857',0.00,'garciabautistaheber@gmail.com'),(7,'RENE',_binary '¡Û0–ØÛá@?CGº\¬\Zˇ|ôr55Ú≥#p%%','41116051573132525588',0.00,'garciabautistaheberejesus@gmail.com'),(8,'RENE',_binary '≥(*/*(u{:´É=\·júTQåÙì\„ß\œ	8o2j','47288776106244977253',15000.00,'garciabautistaheberdejesus@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimientos`
--

DROP TABLE IF EXISTS `movimientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimientos` (
  `id_movimiento` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `tipo` enum('Transferencia','Retiro','Deposito') NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `tarjeta_relacionada` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_movimiento`),
  KEY `id_cliente` (`id_cliente`),
  CONSTRAINT `movimientos_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimientos`
--

LOCK TABLES `movimientos` WRITE;
/*!40000 ALTER TABLE `movimientos` DISABLE KEYS */;
INSERT INTO `movimientos` VALUES (4,1,'Transferencia',-1000.00,'2025-07-24 03:36:33','41111234123412341234'),(5,2,'Transferencia',1000.00,'2025-07-24 03:36:33','41114321432143214321'),(6,2,'Retiro',-1000.00,'2025-07-24 03:38:18',NULL),(7,2,'Retiro',-1000.00,'2025-07-24 03:42:17',NULL),(8,1,'Transferencia',-1000.00,'2025-07-24 11:26:18','41111234123412341234'),(9,2,'Transferencia',1000.00,'2025-07-24 11:26:18','41114321432143214321'),(10,1,'Deposito',1000.00,'2025-07-24 12:35:32',NULL),(11,1,'Deposito',3000.00,'2025-07-24 16:07:39','41114321432143214321'),(12,1,'Retiro',-2000.00,'2025-07-24 16:08:39',NULL),(13,1,'Retiro',-1000.00,'2025-07-24 16:10:07','41114321432143214321'),(14,2,'Retiro',-2000.00,'2025-07-25 12:20:55','41111234123412341234'),(15,2,'Deposito',1000.00,'2025-07-25 12:22:39','41111234123412341234'),(16,2,'Retiro',-1000.00,'2025-07-25 12:24:23','41111234123412341234'),(17,4,'Deposito',5000.00,'2025-07-25 13:05:50','41114321432143214444'),(18,4,'Deposito',1000000.00,'2025-07-25 13:06:53','41114321432143214444'),(19,5,'Retiro',-9000.00,'2025-07-25 13:10:03','41114321432143214333'),(20,8,'Deposito',15000.00,'2025-07-29 01:25:36','47288776106244977253'),(21,2,'Retiro',-1000.00,'2025-07-29 01:31:26','41111234123412341234');
/*!40000 ALTER TABLE `movimientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Gerente'),(2,'Cajero');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(50) NOT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `contrase√±a` varchar(50) DEFAULT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario` (`usuario`),
  KEY `fk_rol` (`id_rol`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Heber','Hbr','Heber@gmail.com','Hbr132454#',1),(2,'Sergio','Sergi5','Ser5@gmail.com','SeRgIo12345$',2),(3,'Alan','AlanITO','Alterlemur78@gmail.com','Alan789A#$',2),(4,'Gabriel','Gabrielito789','garciabautistaheberdejesus@gmail.com','Gabtriel456##',1),(5,'Diego','Diego123',NULL,NULL,NULL),(11,'Bancomex','BANCOMEX','bancomexavisos@gmail.com','Hola123!',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-29  2:28:53
