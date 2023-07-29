-- MySQL dump 10.13  Distrib 5.7.42, for Win64 (x86_64)
--
-- Host: localhost    Database: booksys
-- ------------------------------------------------------
-- Server version	5.7.41

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
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_info` (
  `admin_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `admin_name` varchar(50) DEFAULT NULL COMMENT '管理员名称',
  `password` varchar(50) NOT NULL COMMENT '密码',
  PRIMARY KEY (`admin_id`) USING BTREE,
  UNIQUE KEY `admin_name` (`admin_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES (2,'admin','123456'),(3,'root','123456');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_info`
--

DROP TABLE IF EXISTS `book_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_info` (
  `book_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '书籍ID',
  `book_name` varchar(50) NOT NULL DEFAULT '' COMMENT '书名',
  `isbn` varchar(50) NOT NULL DEFAULT '' COMMENT 'ISBN',
  `author` varchar(50) NOT NULL DEFAULT '' COMMENT '作者',
  `press` varchar(50) NOT NULL DEFAULT '' COMMENT '出版社',
  `publication_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出版日期',
  `price` decimal(10,2) unsigned DEFAULT NULL COMMENT '价格',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '在馆状态',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上架时间',
  `type` int(10) unsigned NOT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  UNIQUE KEY `book_id` (`book_id`) USING BTREE,
  KEY `book_info_FK` (`type`),
  CONSTRAINT `book_info_FK` FOREIGN KEY (`type`) REFERENCES `type_info` (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1056 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_info`
--

LOCK TABLES `book_info` WRITE;
/*!40000 ALTER TABLE `book_info` DISABLE KEYS */;
INSERT INTO `book_info` VALUES (1019,'巴黎圣母院','9787560575667','[法]雨果 著 李玉民 译','西安交通大学出版社','2023-07-16 00:00:00',37.80,_binary '\0','2023-07-16 12:33:03',3),(1020,'失乐园','9787555257035','渡边淳一[著]  林少华[译]','青岛出版社','2023-07-16 00:00:00',45.00,_binary '\0','2023-07-16 12:33:03',6),(1021,'假面之夜+假面饭店+假面前夜','25286485','东野圭吾','南海出版公司','2023-07-16 00:00:00',115.90,_binary '\0','2023-07-16 12:33:03',5),(1022,'布隆夫曼脱单历险记','9787559431394','[美]丹尼尔·华莱士 著 宁蒙 译 时代华语','江苏凤凰文艺出版社','2023-07-16 00:00:00',35.80,_binary '','2023-07-16 12:33:03',5),(1023,'光与影','9787555269397','渡边淳一','青岛出版社','2023-07-16 13:36:17',32.00,_binary '\0','2023-07-16 12:33:03',1),(1024,'三体：全三册','23579654','刘慈欣','重庆出版社','2023-07-16 13:36:17',55.80,_binary '\0','2023-07-16 12:33:03',1),(1025,'鲛在水中央','9787540490645','孙频','湖南文艺出版社','2023-07-16 13:36:17',42.70,_binary '\0','2023-07-16 12:33:03',1),(1026,'彼得·林奇点评版股票作手回忆录','9787515303628','[美]杰西·利弗莫尔','中国青年出版社','2023-07-16 13:36:17',32.20,_binary '\0','2023-07-16 12:33:03',1),(1027,'财务自由之路（全三册）','26511903','[德]博多·舍费尔','现代出版社','2023-07-16 13:36:17',121.10,_binary '\0','2023-07-16 12:33:03',1),(1028,'稻盛和夫阿米巴经营经典套装（理论+实践）','9787520202824','[日]稻盛和夫','中国大百科全书出版社','2023-07-16 13:36:17',74.70,_binary '\0','2023-07-16 12:33:03',1),(1029,'斯坦福极简经济学','24010635','[美]泰勒','湖南人民出版社','2023-07-16 13:36:17',45.50,_binary '\0','2023-07-16 12:33:03',1),(1030,'工匠精神：向价值型员工进化——精装典藏新版','9787515814940','付守永','中华工商联合出版社','2023-07-16 13:36:17',37.00,_binary '\0','2023-07-16 12:33:03',1),(1031,'高效能学习：思维力+学习力（套装共2册）','26514401','王世民','电子工业出版社','2023-07-16 13:36:17',101.40,_binary '\0','2023-07-16 12:33:03',1),(1032,'谈判：如何在博弈中获得更多','9787513918930','[英] 盖温·肯尼迪 (Gavin Kennedy)','民主与建设出版社','2023-07-16 13:36:17',40.50,_binary '\0','2023-07-16 12:33:03',1),(1033,'曾国藩的正面与侧面','27856398','张宏杰','岳麓出版社','2023-07-16 13:36:17',134.60,_binary '\0','2023-07-16 12:33:03',1),(1034,'第二性（ⅠⅡ 全两册）','23429879','[法]西蒙娜德波伏瓦','上海译文出版社','2023-07-16 13:36:17',68.60,_binary '\0','2023-07-16 12:33:03',1),(1035,'易经杂说','9787520707862','南怀瑾','东方出版社','2023-07-16 13:36:17',45.50,_binary '\0','2023-07-16 12:33:03',1),(1036,'中国文史哲大辞典（全六册）','25282178','郑天挺、谭其骧、钱仲联、章培恒、傅璇琮、张岱年等','上海辞书出版社','2023-07-16 13:36:17',945.60,_binary '\0','2023-07-16 12:33:03',1),(1037,'范志红健康日历','9787122327475','范志红','化学工业出版社','2023-07-16 13:36:17',70.50,_binary '\0','2023-07-16 12:33:03',1),(1038,'闪电增肌','9787121359552','仰望尾迹云','电子工业出版社','2023-07-16 13:36:17',46.80,_binary '\0','2023-07-16 12:33:03',1),(1039,'你不懂茶','9787559430076','[日]三宅贵男','江苏凤凰文艺出版社','2023-07-16 13:36:17',39.50,_binary '\0','2023-07-16 12:33:03',1),(1040,'男人这东西','9787555269410','渡边淳一','青岛出版社','2023-07-16 13:36:17',39.00,_binary '\0','2023-07-16 12:33:03',1),(1041,'孩子受益一生的思维力','9787554613122','杨瑜君 万玲','古吴轩出版社','2023-07-16 13:36:17',44.30,_binary '\0','2023-07-16 12:33:03',1),(1042,'刚刚好的养育：如何培养高情商的孩子','9787555277750','鱼爸 ','青岛出版社','2023-07-16 13:36:17',40.10,_binary '\0','2023-07-16 12:33:03',1),(1043,'四大名著','25111286','[清]曹雪芹、[明]吴承恩、[明]罗贯中、[明]施耐庵','民主与建设出版社','2023-07-16 13:36:17',97.74,_binary '\0','2023-07-16 12:33:03',1),(1044,'中华上下五千年','9787570404506','刘敬余主编','北京教育出版社','2023-07-16 13:36:17',89.70,_binary '\0','2023-07-16 12:33:03',1),(1045,'古史·文言·今论','9787303227259','杨洋','北京师范大学出版社','2023-07-16 13:36:17',65.30,_binary '\0','2023-07-16 12:33:03',1),(1046,'星火英语六级真题试卷','9787313086716','汪开虎','上海交通大学出版社','2023-07-16 13:36:17',36.80,_binary '\0','2023-07-16 12:33:03',1),(1047,'现代汉语词典(第7版)','9787100124508','中国社会科学院语言研究所词典编辑室 ','商务印书馆','2023-07-16 13:36:17',93.00,_binary '\0','2023-07-16 12:33:03',1),(1048,'居里夫人传','9787512655942','[法]玛丽.居里','团结出版社','2023-07-16 13:36:17',21.60,_binary '\0','2023-07-16 12:33:03',1),(1049,'艺术的故事','9787807463726','[英] 贡布里希','广西美术出版社','2023-07-16 13:36:17',182.00,_binary '\0','2023-07-16 12:33:03',1),(1050,'梵高：化世间痛苦为激情洋溢的美','9787568041638','[法]扬·布朗','华中科技大学出版社','2023-07-16 13:36:17',353.80,_binary '\0','2023-07-16 12:33:03',1),(1051,'林徽因传：人生从来都靠自己成全','9787202134948','程碧','河北人民出版社','2023-07-16 13:36:17',51.60,_binary '\0','2023-07-16 12:33:03',1),(1052,'三毛典藏全集','9787530216545','三毛 ','北京十月文艺出版社','2023-07-16 13:36:17',336.00,_binary '\0','2023-07-16 12:33:03',1),(1053,'雨夜短文','9787545536829','余秋雨','天地出版社','2023-07-16 13:36:17',55.70,_binary '\0','2023-07-16 12:33:03',1),(1054,'鲁迅全集','9787547711101','鲁迅','北京日报出版社','2023-07-16 13:36:17',457.50,_binary '\0','2023-07-16 12:33:03',1);
/*!40000 ALTER TABLE `book_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrow_info`
--

DROP TABLE IF EXISTS `borrow_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `borrow_info` (
  `borrow_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `reader_id` bigint(20) unsigned NOT NULL COMMENT '读者ID',
  `book_id` int(10) unsigned NOT NULL COMMENT '书籍ID',
  `borrow_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借阅时间',
  `expire_time` datetime NOT NULL COMMENT '到期时间',
  PRIMARY KEY (`borrow_id`) USING BTREE,
  UNIQUE KEY `borrow_id` (`reader_id`,`book_id`) USING BTREE,
  KEY `reader_id_2` (`reader_id`) USING BTREE,
  KEY `book_id` (`book_id`) USING BTREE,
  CONSTRAINT `borrow_info_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader_info` (`reader_id`) ON UPDATE CASCADE,
  CONSTRAINT `borrow_info_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrow_info`
--

LOCK TABLES `borrow_info` WRITE;
/*!40000 ALTER TABLE `borrow_info` DISABLE KEYS */;
INSERT INTO `borrow_info` VALUES (8,2020052,1022,'2023-07-16 21:36:44','2023-10-16 21:36:44');
/*!40000 ALTER TABLE `borrow_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reader_info`
--

DROP TABLE IF EXISTS `reader_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reader_info` (
  `reader_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '读者ID',
  `reader_name` varchar(50) NOT NULL COMMENT '读者姓名',
  `phone` varchar(11) NOT NULL DEFAULT '' COMMENT '手机号码',
  `status` bit(1) NOT NULL DEFAULT b'0' COMMENT '读者状态',
  `fine` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '欠款金额',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`reader_id`) USING BTREE,
  UNIQUE KEY `reader_id` (`reader_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2020059 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reader_info`
--

LOCK TABLES `reader_info` WRITE;
/*!40000 ALTER TABLE `reader_info` DISABLE KEYS */;
INSERT INTO `reader_info` VALUES (2020052,'张三','13154697895',_binary '\0',0.80,'2023-07-16 12:33:03'),(2020053,'李四','12345678911',_binary '\0',0.00,'2023-07-16 12:33:03'),(2020054,'jack','12547896547',_binary '',0.00,'2023-07-16 12:33:03'),(2020055,'王五','15369987456',_binary '\0',12.50,'2023-07-16 12:33:03'),(2020056,'李华','13154698745',_binary '\0',0.00,'2023-07-16 12:33:03');
/*!40000 ALTER TABLE `reader_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `return_info`
--

DROP TABLE IF EXISTS `return_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `return_info` (
  `r_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `reader_id` bigint(20) unsigned NOT NULL COMMENT '读者ID',
  `book_id` int(10) unsigned NOT NULL COMMENT '书籍ID',
  `borrow_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '借阅时间',
  `return_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '归还时间',
  PRIMARY KEY (`r_id`) USING BTREE,
  KEY `reader_id_2` (`reader_id`) USING BTREE,
  KEY `book_id` (`book_id`) USING BTREE,
  CONSTRAINT `return_info_ibfk_1` FOREIGN KEY (`reader_id`) REFERENCES `reader_info` (`reader_id`) ON UPDATE CASCADE,
  CONSTRAINT `return_info_ibfk_2` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=REDUNDANT;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `return_info`
--

LOCK TABLES `return_info` WRITE;
/*!40000 ALTER TABLE `return_info` DISABLE KEYS */;
INSERT INTO `return_info` VALUES (1,2020052,1020,'2023-07-16 12:54:57','2023-07-16 12:55:37'),(2,2020052,1020,'2023-07-16 12:55:41','2023-07-16 12:59:28'),(3,2020052,1022,'2023-07-16 13:00:02','2023-07-16 21:36:27'),(5,2020052,1021,'2023-07-16 12:59:57','2023-07-29 16:20:40');
/*!40000 ALTER TABLE `return_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type_info`
--

DROP TABLE IF EXISTS `type_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type_info` (
  `type_id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '书籍类型ID',
  `type_name` varchar(50) NOT NULL COMMENT '书籍类型名称',
  PRIMARY KEY (`type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type_info`
--

LOCK TABLES `type_info` WRITE;
/*!40000 ALTER TABLE `type_info` DISABLE KEYS */;
INSERT INTO `type_info` VALUES (1,'未分类'),(2,'休闲爱好 '),(3,'小说'),(4,'文学'),(5,'经济管理'),(6,'艺术'),(7,'计算机'),(8,'人文');
/*!40000 ALTER TABLE `type_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'booksys'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-29 16:31:48
