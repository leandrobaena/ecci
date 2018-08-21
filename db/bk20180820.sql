-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ecci
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `calificacion`
--

DROP TABLE IF EXISTS `calificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calificacion` (
  `idcalificacion` int(11) NOT NULL AUTO_INCREMENT,
  `idsoftware` int(11) NOT NULL,
  `idetiqueta` int(11) NOT NULL,
  `porcentaje` smallint(6) NOT NULL,
  PRIMARY KEY (`idcalificacion`),
  KEY `FK_calificacion_software_idx` (`idsoftware`),
  KEY `FK_calificacion_etiqueta_idx` (`idetiqueta`),
  CONSTRAINT `FK_calificacion_etiqueta` FOREIGN KEY (`idetiqueta`) REFERENCES `etiqueta` (`idetiqueta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_calificacion_software` FOREIGN KEY (`idsoftware`) REFERENCES `software` (`idsoftware`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calificacion`
--

LOCK TABLES `calificacion` WRITE;
/*!40000 ALTER TABLE `calificacion` DISABLE KEYS */;
INSERT INTO `calificacion` VALUES (1,2,1,90);
/*!40000 ALTER TABLE `calificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escolaridad`
--

DROP TABLE IF EXISTS `escolaridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `escolaridad` (
  `idescolaridad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idescolaridad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escolaridad`
--

LOCK TABLES `escolaridad` WRITE;
/*!40000 ALTER TABLE `escolaridad` DISABLE KEYS */;
INSERT INTO `escolaridad` VALUES (1,'Primaria'),(2,'Secundaria'),(3,'Técnico'),(4,'Tecnológico'),(5,'Profesional'),(6,'Especialización');
/*!40000 ALTER TABLE `escolaridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiqueta`
--

DROP TABLE IF EXISTS `etiqueta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etiqueta` (
  `idetiqueta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`idetiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiqueta`
--

LOCK TABLES `etiqueta` WRITE;
/*!40000 ALTER TABLE `etiqueta` DISABLE KEYS */;
INSERT INTO `etiqueta` VALUES (1,'Salud');
/*!40000 ALTER TABLE `etiqueta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `etiquetanecesidad`
--

DROP TABLE IF EXISTS `etiquetanecesidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `etiquetanecesidad` (
  `idetiquetanecesidad` int(11) NOT NULL AUTO_INCREMENT,
  `idetiqueta` int(11) NOT NULL,
  `idnecesidad` int(11) NOT NULL,
  PRIMARY KEY (`idetiquetanecesidad`),
  KEY `FK_etiquetanecesidad_etiqueta_idx` (`idetiqueta`),
  KEY `FK_etiquetanecesidad_necesidad_idx` (`idnecesidad`),
  CONSTRAINT `FK_etiquetanecesidad_etiqueta` FOREIGN KEY (`idetiqueta`) REFERENCES `etiqueta` (`idetiqueta`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_etiquetanecesidad_necesidad` FOREIGN KEY (`idnecesidad`) REFERENCES `necesidad` (`idnecesidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etiquetanecesidad`
--

LOCK TABLES `etiquetanecesidad` WRITE;
/*!40000 ALTER TABLE `etiquetanecesidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `etiquetanecesidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grupo` (
  `idgrupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idgrupo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
INSERT INTO `grupo` VALUES (1,'Administradores',1),(3,'Profesores',1);
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modulo`
--

DROP TABLE IF EXISTS `modulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modulo` (
  `idmodulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idmodulo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modulo`
--

LOCK TABLES `modulo` WRITE;
/*!40000 ALTER TABLE `modulo` DISABLE KEYS */;
INSERT INTO `modulo` VALUES (1,'Usuarios',1),(2,'Grupos',1),(3,'Niveles de acceso',1),(4,'Módulos',1),(5,'Escolaridades',1),(6,'Profesiones',1),(7,'Softwares',1),(8,'Necesidades',1),(9,'Etiquetas',1),(10,'Solicitudes',1);
/*!40000 ALTER TABLE `modulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `necesidad`
--

DROP TABLE IF EXISTS `necesidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `necesidad` (
  `idnecesidad` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `idnecesidadpadre` int(11) DEFAULT NULL,
  PRIMARY KEY (`idnecesidad`),
  KEY `FK_necesidad_padre_idx` (`idnecesidadpadre`),
  CONSTRAINT `FK_necesidad_padre` FOREIGN KEY (`idnecesidadpadre`) REFERENCES `necesidad` (`idnecesidad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `necesidad`
--

LOCK TABLES `necesidad` WRITE;
/*!40000 ALTER TABLE `necesidad` DISABLE KEYS */;
INSERT INTO `necesidad` VALUES (1,'1','Software para estudiantes',NULL),(2,'1.1','Desarrollar un software que redacte todo lo que se le diga con alto alcance por ejemplo en una clase',1),(3,'1.2','Software que contenga miles de plantillas para redactar documentos y solo necesitamos ingresar los datos y el asunto',1),(4,'2','Software para cuidado del medio ambiente',NULL),(5,'2.1','Un software que se pueda emplear para poder descontaminar el agua',4),(6,'2.2','Software que determine en qué grado se encuentra el agua y regule',4),(7,'2.3','Software para el control y cuidado de los parques',4),(8,'3','Software para vehículos',NULL),(9,'3.1','Alarma para motos',8),(10,'3.2','Un robot que indica a las personas cuando vayan a conducir, si tiene nivel de alcohol y no les permita encender el vehículo',8),(11,'3.3','Software que determine en qué momento un auto presenta fallas',8),(12,'3.4','Software que determine la cantidad máxima de pasajeros que deben entrar en Transmilenio',8),(13,'3.5','Software que informe cuando presenta inestabilidad una moto',8),(14,'4','Software para el hogar',NULL),(15,'4.1','Desarrollar un software que ayude en el hogar a distribuir los alimentos en los lugares que deben ocupar además el mínimo tiempo de consumo y ayude a porcionar según los miembros de la familia',14),(16,'4.2','Un software que haga que las estufas funcionen por medio de la voz',14),(17,'4.3','Implementar luz solar en todos los hogares (con la ayuda del software)',14),(18,'4.4','Software para el control de aseo de los hogares',14),(19,'4.5','Software que detecte e informe cuando es el momento de hacer aseo',14),(20,'4.6','Software que determine en qué momento se deben encender las luces',14),(21,'4.7','Software que permita monitorear las mascotas por medio de paneles',14),(22,'4.8','Software para la comunicación por chat con las mascotas',14),(23,'5','Software para la comunicación',NULL),(24,'5.1','Desarrollar un software que vocalice palabras que no les entendemos a los niños',23),(25,'5.2','Desarrollar un software que traduce a lenguaje de señas lo que queremos decir y nos muestre el paso a paso de expresarla',23),(26,'6','Software para la salud',NULL),(27,'6.1','Software que según las tareas que realicemos en el día nos programe pausas activas por salud',26),(28,'6.2','Desarrollar un software que al tocar el celular reconozca nuestros signos vitales y nos de los datos',26),(29,'6.3','Desarrollar un software que emita una alerta cuando la persona sobrepasa los decibeles permitidos de audición en el ser humano',26),(30,'6.4','Unas gafas que indiquen las pulsaciones de una persona, y también, que indique cuándo va a tener una recaída de cualquier tipo de enfermedad',26),(31,'7','Software de ocio',NULL),(32,'7.1','FIESTEROS ADICTOS: Y para esos que les gusta pasar de fiesta en fiesta otra App para celular donde pueden ver las fiestas que se encuentran alrededor de él',31),(33,'7.2','RECORDATORIO: Una aplicación que avise al consumidor que es lo que tiene que hacer en el día avisándolos',31),(34,'7.3','MENTIRAS:  Cuántas veces nos hemos metido en problemas y no encontramos una excusa adecuada para cada situación está una App que ayude a las personas a salir de problemas no está mal',31),(35,'7.4','Software que indique cuando un jugador realiza trampa',31),(36,'7.5','Software para que todos los juegos online sean gratis',31),(37,'7.6','Un software para crear videojuegos de alta gama',31),(38,'7.7','Un software que busque películas, series, novelas etc. Para ver más fácil lo anterior',31),(39,'7.8','Un software para ver todos los partidos de fútbol soccer de cualquier liga o copa totalmente gratis',31),(40,'8','Software para uso comercial ',NULL),(41,'8.1','ARTÍCULOS DE INTERÉS: Para aquellas y aquellos aficionados a comprar y vender por qué no crear una App para celular especial donde ellos donde podrán comunicarse como grupo para comprar y venta de artículos',40),(42,'8.2','Software para llevar la contabilidad de un negocio',40),(43,'8.3','Software para inventario en locales comerciales',40),(44,'9','Software para android',NULL),(45,'9.1','MAS RAPIDO TU ANDROID: Sí, hay muchas aplicaciones que prometen poner más rápido tu android, pero lo que hacen es ponerlo aún más lento',44),(46,'9.2','CARGA TU ANDROID:  Que tan fastidioso es que estemos trabajando en el computador o simplemente chateando en nuestro celular y de un momento a otro nos salgan un anuncio que dice “batería baja”, Una aplicación donde almacene una parte de batería, para después poder utilizarla. Solucionaría este problema',44),(47,'9.3','VIDEO BEN EN EL BOLSILLO:  Cada que tenemos una presentación, nos gusta presentarla en una pantalla, pero un video Ben es muy caro, porque no crear una aplicación para que un celular pueda proyectar nuestro trabajo',44),(48,'9.4','CUANTO TIEMPO DURA TU BATERIA:  Un programa donde indique con exactitud cuánto tiempo durará la carga de tu dispositivo, que indique si está o no dañada la batería del celular',44),(49,'9.5','REALIDAD AUMENTADA:  Cuando tengamos que hacer un plano, deberíamos presentarlo en 3D, por ejemplo, hacerlo en una Tablet y al empezar a grabar con un celular podamos ver el plano en 3D',44),(50,'9.6','QUITA PUBLICACIONES:  Odio que me salgan publicaciones en el celular a las esquinas de las páginas y lo que más odio de eso es hacer clic por error a ellas, una aplicación para quitar esto estaría bien',44),(51,'9.7','TRADUCTOR MUNDIAL:  Sería bueno una aplicación donde traduzca al mismo tiempo lo que nos hablan los extranjeros y que les traduzcan también lo que nosotros decimos a ellos',44),(52,'10','Software de seguridad',NULL),(53,'10.1','BUENO O MALO: Cuántas veces estamos inseguros de una decisión difícil, una aplicación para el celular donde las personas cuenten sus experiencias de problemas similares que otros tienen, para así dar un consejo y poder ayudarlos',52),(54,'10.2','VERDAD O MENTIRA:  Si, porque no ayudar a la ley de vez en cuando. Una aplicación que diga si un delincuente está diciendo la verdad o en realidad está mintiendo',52),(55,'10.3','RECONOCIMIENTO DE AMIGOS:  Nunca sabemos si estamos hablando con un conocido o no, por eso se debería crear un programa donde diga si en realidad es la forma de escribir de la persona con quien estamos hablando',52),(56,'10.4','Desarrollar un software que nos bloquee el celular cuando desconozca la redacción de la persona',52),(57,'10.5','Software que active una alarma de seguridad desde cualquier parte',52),(58,'10.6','Software de vigilancia que nos alerte de personas desconocidas por reconocimiento de rostros',52),(59,'10.7','Que todos los celulares tengan un software antirrobos',52),(60,'10.8','Software que bloquee el celular al momento de sentir huella dactilar errónea',52),(61,'11','Software Internet',NULL),(62,'11.1','AUMENTO DE SEÑAL WIFI:  Todos odiamos que cuando nos alejamos de nuestro modem la señal disminuya y tengamos que esperar mucho tiempo para que nuestras páginas carguen, sería una buena idea crear un programa que aumente la capacidad de señal de nuestros portátiles o celulares',61),(63,'11.2','UNOS MINUTOS MÁS DE INTERNET:  Siempre que tenemos una emergencia es bueno tener a la mano nuestro celular con plan o minutos, una aplicación que regale unos minutos de plan cuando tengamos una emergencia no estaría mal',61),(64,'12','HERRAMIENTAS PARA PC',NULL),(65,'12.1','CONTROLA TU PC DESDE TU ANDROID:  No poder controlar nuestro PC por que se nos quedó es lo peor que puede pasar porque no crear una App donde podamos ver nuestro escritorio desde nuestro celular',64),(66,'12.2','SALVA VIDAS: Que es peor que hacer el trabajo y se nos haya quedado, una solución a esto es crear un programa para que nosotros podamos enviar de nuestro ordenador a nuestro celular archivos',64),(67,'12.3','REALIDAD VIRTUAL:  Odiamos que alguien nos espié por detrás cuando estamos en el computador, una solución para esto sería crear una aplicación que apague la pantalla y que con unas gafas solo nosotros podamos ver lo que se encuentra la pantalla',64),(68,'12.4','Un software para guardar archivos y aplicaciones, ejemplo: cuando vayas a formatear el PC o MAC poder guardar los archivos, carpetas o aplicaciones que no quieras borrar al formatear',64),(69,'12.5','Un software que emplee un disco duro en un servidor',64),(70,'13','Software de ubicación',NULL),(71,'13.1','Software que ayude a los invidentes a ubicarse',70),(72,'14','SOFTWARE PARA LA SEGURIDAD INFORMÁTICA',NULL),(73,'15','Software libre para bibliotecas',NULL),(74,'16','Software libre para gestión empresarial',NULL);
/*!40000 ALTER TABLE `necesidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivelacceso`
--

DROP TABLE IF EXISTS `nivelacceso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nivelacceso` (
  `idnivelacceso` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idnivelacceso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivelacceso`
--

LOCK TABLES `nivelacceso` WRITE;
/*!40000 ALTER TABLE `nivelacceso` DISABLE KEYS */;
INSERT INTO `nivelacceso` VALUES (1,'Listar'),(2,'Insertar'),(3,'Editar'),(4,'Eliminar');
/*!40000 ALTER TABLE `nivelacceso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permiso`
--

DROP TABLE IF EXISTS `permiso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permiso` (
  `idpermiso` int(11) NOT NULL AUTO_INCREMENT,
  `idgrupo` int(11) NOT NULL,
  `idnivelacceso` int(11) NOT NULL,
  `idmodulo` int(11) NOT NULL,
  PRIMARY KEY (`idpermiso`),
  KEY `FK_permiso_grupo_idx` (`idgrupo`),
  KEY `FK_permiso_nivelacceso_idx` (`idnivelacceso`),
  KEY `FK_permiso_modulo_idx` (`idmodulo`),
  CONSTRAINT `FK_permiso_grupo` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_modulo` FOREIGN KEY (`idmodulo`) REFERENCES `modulo` (`idmodulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_nivelacceso` FOREIGN KEY (`idnivelacceso`) REFERENCES `nivelacceso` (`idnivelacceso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permiso`
--

LOCK TABLES `permiso` WRITE;
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesion`
--

DROP TABLE IF EXISTS `profesion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profesion` (
  `idprofesion` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`idprofesion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesion`
--

LOCK TABLES `profesion` WRITE;
/*!40000 ALTER TABLE `profesion` DISABLE KEYS */;
INSERT INTO `profesion` VALUES (1,'Ingeniero');
/*!40000 ALTER TABLE `profesion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `software`
--

DROP TABLE IF EXISTS `software`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `software` (
  `idsoftware` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `licencia` varchar(45) NOT NULL,
  `url` varchar(250) NOT NULL,
  `version` varchar(45) NOT NULL,
  PRIMARY KEY (`idsoftware`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `software`
--

LOCK TABLES `software` WRITE;
/*!40000 ALTER TABLE `software` DISABLE KEYS */;
INSERT INTO `software` VALUES (1,'MySQL','Motor de base de datos','GPL','https://www.mysql.com/','8.0.12'),(2,'Netbeans','IDE de desarrollo para distinos lenguajes. Como java, php, entre otros.','GPL','https://netbeans.org/','8.2');
/*!40000 ALTER TABLE `software` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicitud` (
  `idsolicitud` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `idescolaridad` int(11) NOT NULL,
  `idprofesion` int(11) NOT NULL,
  PRIMARY KEY (`idsolicitud`),
  KEY `FK_solicitud_escolaridad_idx` (`idescolaridad`),
  KEY `FK_solicitud_labor_idx` (`idprofesion`),
  CONSTRAINT `FK_solicitud_escolaridad` FOREIGN KEY (`idescolaridad`) REFERENCES `escolaridad` (`idescolaridad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_solicitud_profesion` FOREIGN KEY (`idprofesion`) REFERENCES `profesion` (`idprofesion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicitud`
--

LOCK TABLES `solicitud` WRITE;
/*!40000 ALTER TABLE `solicitud` DISABLE KEYS */;
INSERT INTO `solicitud` VALUES (1,'2018-08-16 00:00:00','Leandro','leandrobaena@gmail.com',5,1);
/*!40000 ALTER TABLE `solicitud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `solicituddetalle`
--

DROP TABLE IF EXISTS `solicituddetalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solicituddetalle` (
  `idsolicituddetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idsolicitud` int(11) NOT NULL,
  `necesidad` varchar(1000) NOT NULL,
  `justificacion` varchar(5000) DEFAULT NULL,
  `herramientaActual` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idsolicituddetalle`),
  KEY `FK_solicituddetalle_solicitud_idx` (`idsolicitud`),
  CONSTRAINT `FK_solicituddetalle_solicitud` FOREIGN KEY (`idsolicitud`) REFERENCES `solicitud` (`idsolicitud`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `solicituddetalle`
--

LOCK TABLES `solicituddetalle` WRITE;
/*!40000 ALTER TABLE `solicituddetalle` DISABLE KEYS */;
INSERT INTO `solicituddetalle` VALUES (1,1,'Una prueba de funcionalidad y de salud','Prueba unitaria','Nada');
/*!40000 ALTER TABLE `solicituddetalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `contrasenia` varchar(32) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','Leandro','Baena Torres','692fafa4a478e34f21afe3b14a0c50f5',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuariogrupo`
--

DROP TABLE IF EXISTS `usuariogrupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuariogrupo` (
  `idusuariogrupo` int(11) NOT NULL AUTO_INCREMENT,
  `idusuario` int(11) NOT NULL,
  `idgrupo` int(11) NOT NULL,
  PRIMARY KEY (`idusuariogrupo`),
  KEY `FK_usuario_grupo_usuario_idx` (`idusuario`),
  KEY `FK_usuario_grupo_grupo_idx` (`idgrupo`),
  CONSTRAINT `FK_usuario_grupo_grupo` FOREIGN KEY (`idgrupo`) REFERENCES `grupo` (`idgrupo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usuario_grupo_usuario` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuariogrupo`
--

LOCK TABLES `usuariogrupo` WRITE;
/*!40000 ALTER TABLE `usuariogrupo` DISABLE KEYS */;
INSERT INTO `usuariogrupo` VALUES (5,1,1);
/*!40000 ALTER TABLE `usuariogrupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_calificacion`
--

DROP TABLE IF EXISTS `vw_calificacion`;
/*!50001 DROP VIEW IF EXISTS `vw_calificacion`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_calificacion` AS SELECT 
 1 AS `idcalificacion`,
 1 AS `idsoftware`,
 1 AS `nombreSoftware`,
 1 AS `descripcion`,
 1 AS `licencia`,
 1 AS `url`,
 1 AS `version`,
 1 AS `idetiqueta`,
 1 AS `nombreEtiqueta`,
 1 AS `porcentaje`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_etiquetanecesidad`
--

DROP TABLE IF EXISTS `vw_etiquetanecesidad`;
/*!50001 DROP VIEW IF EXISTS `vw_etiquetanecesidad`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_etiquetanecesidad` AS SELECT 
 1 AS `idetiquetanecesidad`,
 1 AS `idetiqueta`,
 1 AS `nombre`,
 1 AS `idnecesidad`,
 1 AS `codigo`,
 1 AS `descripcion`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_permiso`
--

DROP TABLE IF EXISTS `vw_permiso`;
/*!50001 DROP VIEW IF EXISTS `vw_permiso`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_permiso` AS SELECT 
 1 AS `idpermiso`,
 1 AS `idgrupo`,
 1 AS `grupo`,
 1 AS `grupoActivo`,
 1 AS `idnivelacceso`,
 1 AS `nivelacceso`,
 1 AS `idmodulo`,
 1 AS `modulo`,
 1 AS `moduloActivo`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_solicitud`
--

DROP TABLE IF EXISTS `vw_solicitud`;
/*!50001 DROP VIEW IF EXISTS `vw_solicitud`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_solicitud` AS SELECT 
 1 AS `idsolicitud`,
 1 AS `fecha`,
 1 AS `nombre`,
 1 AS `email`,
 1 AS `idescolaridad`,
 1 AS `escolaridad`,
 1 AS `idprofesion`,
 1 AS `profesion`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vw_usuariogrupo`
--

DROP TABLE IF EXISTS `vw_usuariogrupo`;
/*!50001 DROP VIEW IF EXISTS `vw_usuariogrupo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_usuariogrupo` AS SELECT 
 1 AS `idusuario`,
 1 AS `login`,
 1 AS `nombres`,
 1 AS `apellidos`,
 1 AS `usuarioActivo`,
 1 AS `idgrupo`,
 1 AS `nombre`,
 1 AS `grupoActivo`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_calificacion`
--

/*!50001 DROP VIEW IF EXISTS `vw_calificacion`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_calificacion` AS select `c`.`idcalificacion` AS `idcalificacion`,`c`.`idsoftware` AS `idsoftware`,`s`.`nombre` AS `nombreSoftware`,`s`.`descripcion` AS `descripcion`,`s`.`licencia` AS `licencia`,`s`.`url` AS `url`,`s`.`version` AS `version`,`c`.`idetiqueta` AS `idetiqueta`,`e`.`nombre` AS `nombreEtiqueta`,`c`.`porcentaje` AS `porcentaje` from ((`calificacion` `c` join `software` `s` on((`c`.`idsoftware` = `s`.`idsoftware`))) join `etiqueta` `e` on((`c`.`idetiqueta` = `e`.`idetiqueta`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_etiquetanecesidad`
--

/*!50001 DROP VIEW IF EXISTS `vw_etiquetanecesidad`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_etiquetanecesidad` AS select `en`.`idetiquetanecesidad` AS `idetiquetanecesidad`,`en`.`idetiqueta` AS `idetiqueta`,`e`.`nombre` AS `nombre`,`en`.`idnecesidad` AS `idnecesidad`,`n`.`codigo` AS `codigo`,`n`.`descripcion` AS `descripcion` from ((`etiquetanecesidad` `en` join `etiqueta` `e` on((`en`.`idetiqueta` = `e`.`idetiqueta`))) join `necesidad` `n` on((`en`.`idnecesidad` = `n`.`idnecesidad`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_permiso`
--

/*!50001 DROP VIEW IF EXISTS `vw_permiso`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_permiso` AS select `p`.`idpermiso` AS `idpermiso`,`p`.`idgrupo` AS `idgrupo`,`g`.`nombre` AS `grupo`,`g`.`activo` AS `grupoActivo`,`p`.`idnivelacceso` AS `idnivelacceso`,`na`.`nombre` AS `nivelacceso`,`p`.`idmodulo` AS `idmodulo`,`m`.`nombre` AS `modulo`,`m`.`activo` AS `moduloActivo` from (((`permiso` `p` join `grupo` `g` on((`p`.`idgrupo` = `g`.`idgrupo`))) join `nivelacceso` `na` on((`p`.`idnivelacceso` = `na`.`idnivelacceso`))) join `modulo` `m` on((`p`.`idmodulo` = `m`.`idmodulo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_solicitud`
--

/*!50001 DROP VIEW IF EXISTS `vw_solicitud`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_solicitud` AS select `s`.`idsolicitud` AS `idsolicitud`,`s`.`fecha` AS `fecha`,`s`.`nombre` AS `nombre`,`s`.`email` AS `email`,`s`.`idescolaridad` AS `idescolaridad`,`e`.`nombre` AS `escolaridad`,`s`.`idprofesion` AS `idprofesion`,`p`.`nombre` AS `profesion` from ((`solicitud` `s` join `escolaridad` `e` on((`s`.`idescolaridad` = `e`.`idescolaridad`))) join `profesion` `p` on((`s`.`idprofesion` = `p`.`idprofesion`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vw_usuariogrupo`
--

/*!50001 DROP VIEW IF EXISTS `vw_usuariogrupo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_usuariogrupo` AS select `u`.`idusuario` AS `idusuario`,`u`.`login` AS `login`,`u`.`nombres` AS `nombres`,`u`.`apellidos` AS `apellidos`,`u`.`activo` AS `usuarioActivo`,`g`.`idgrupo` AS `idgrupo`,`g`.`nombre` AS `nombre`,`g`.`activo` AS `grupoActivo` from ((`usuario` `u` join `usuariogrupo` `ug` on((`u`.`idusuario` = `ug`.`idusuario`))) join `grupo` `g` on((`ug`.`idgrupo` = `g`.`idgrupo`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-08-20 20:14:02
