CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `livro`
--

DROP TABLE IF EXISTS `livro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `livro` (
  `titulo` varchar(50) NOT NULL,
  `edicao` varchar(2) NOT NULL,
  `autor` varchar(30) NOT NULL,
  `editora` varchar(20) NOT NULL,
  PRIMARY KEY (`titulo`,`edicao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `livro`
--

LOCK TABLES `livro` WRITE;
/*!40000 ALTER TABLE `livro` DISABLE KEYS */;
INSERT INTO `livro` VALUES ('A Cartomante','12','Machados de Assis','Principio'),('Cálculo - Vol. 1','7','James Stewart','Milha'),('Cálculo - Vol. 2','7','James Stewart','Milha'),('Cálculo - Vol. 3','7','James Stewart','Milha'),('Capitães de Areia','7','Jorge Amado','Companhia das Letras'),('Dom Casmurro','9','Machados de Assis','Principio'),('Grande Sertão Veredas','10','Guimarães Rosa','Globo Livros'),('Harry Potter e a Câmara Secreta','10','J. K. Rowling','Rocco'),('Harry Potter e a Ordem da Fênix','10','J. K. Rowling','Rocco'),('Harry Potter e a Pedra Filosofal','10','J. K. Rowling','Rocco'),('Harry Potter e as Relíquias da Morte','10','J. K. Rowling','Rocco'),('Harry Potter e as Relíquias da Morte','6','J. K. Rowling','Rocco'),('Harry Potter e o Cálice de Fogo','10','J. K. Rowling','Rocco'),('Harry Potter e o Enigma do Príncipe','10','J. K. Rowling','Rocco'),('Harry Potter e o Prisioneiro de Askaban','10','J. K. Rowling','Rocco'),('Harry Potter e o Prisioneiro de Askaban','6','J. K. Rowling','Rocco'),('Java Como Programar','8','Paul Deitel','Pearson'),('Memorias Póstumas de Brás Cubas','18','Machados de Assis','Marin Claret'),('O Senhor dos Anéis - A Sociedade do Anel','5','J. R. R. Tolkien','Selo Martins'),('O Senhor dos Anéis - As Duas Torres','5','J. R. R. Tolkien','Selo Martins'),('O Senhor dos Anéis - O Retorno do Rei','5','J. R. R. Tolkien','Selo Martins'),('Programação Orientada a Objetos em Java','1','I. Boratti','Visual Boooks'),('Quincas Borba','13','Machados de Assis','Principio'),('Sagarana','3','Guimarães Rosa','Globo Livros'),('Thinking in Java','3','B. Eckel','Prentice Hall');
/*!40000 ALTER TABLE `livro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locar`
--

DROP TABLE IF EXISTS `locar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locar` (
  `email` varchar(30) NOT NULL,
  `titulo` varchar(50) NOT NULL,
  `edicao` varchar(2) NOT NULL,
  `data_locacao` date NOT NULL,
  `data_devolucao` date DEFAULT NULL,
  PRIMARY KEY (`email`,`titulo`,`edicao`),
  KEY `titulo` (`titulo`,`edicao`),
  CONSTRAINT `locar_ibfk_1` FOREIGN KEY (`email`) REFERENCES `usuario` (`email`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `locar_ibfk_2` FOREIGN KEY (`titulo`, `edicao`) REFERENCES `livro` (`titulo`, `edicao`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locar`
--

LOCK TABLES `locar` WRITE;
/*!40000 ALTER TABLE `locar` DISABLE KEYS */;
INSERT INTO `locar` VALUES ('amanda@gmail.com','Cálculo - Vol. 3','7','2022-08-15',NULL),('victor@gmail.com','Cálculo - Vol. 1','7','2022-08-24',NULL),('victor@gmail.com','Cálculo - Vol. 2','7','2022-08-19','2022-08-23');
/*!40000 ALTER TABLE `locar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `email` varchar(30) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `nascimento` date NOT NULL,
  `rua` varchar(25) DEFAULT NULL,
  `numero` varchar(5) DEFAULT NULL,
  `cidade` varchar(20) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('amanda@gmail.com','Amanda','manda0101','2000-06-17','Rua Manoel Ramiro de Lima','1723','Jataí'),('carol@gmail.com','Carolina','2318Carol','1973-07-30','Rua 1008','172','Goiânia'),('francisco@gmail.com','Francisco','1234','2000-01-01','Rua 13','1009','Brasília'),('jpedro@gmail.com','João Pedro','joao_21Pedro','2000-02-21','Av. T15',NULL,'Goiânia'),('leonora@gmail.com','Leonora','leoNora','2008-07-07','Rua do Lazer',NULL,'Pirenópolis'),('lucas@gmail.com','Lucas','07lUcAs$18','2001-12-18','Rua J-002','0490','Goiânia'),('pedroh@gmail.com','Pedro Henrique','ph1290','2001-01-07','Av. T63','156','Goiânia'),('rodrigo@gmail.com','Rodrigo','Rodrigao2318','1967-06-14','Av. das Mangueiras','811','Brasília'),('victor@gmail.com','Victor','12vi34','2000-02-23','Av. Leblon',NULL,'Goiânia'),('vinicius@gmail.com','Vinicius','65vini_','1994-03-13','Alameda Palmeiras',NULL,'Goiânia');
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

-- Dump completed on 2022-08-28 19:10:02
