# StoreWeb

## 1. Introduction
A brief demo for a web store constructed by JSP, Servlet, Mysql

## 2. Library
### 2.1 Jar lib
     - commons-dbutils-1.7.jar
     - druid-1.0.15.jar
     - java.jdbc-0.7.10.jar
     - lombok-1.18.12.jar
     - mysql-connector-java-8.0.18.jar
     - jstl-1.2.jar

## 3. Database - Mysql
### 3.1 Initialize DB
Use the following commands to create Database

     # Create database
     CREATE DATABASE storeweb_db;
     USE storeweb_db;
     
     # admin_table Initilization
     CREATE TABLE `admin_table` (
      `aid` int NOT NULL AUTO_INCREMENT,
      `adminName` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
      `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
      PRIMARY KEY (`aid`) USING BTREE,
      UNIQUE KEY `UNIQUE_adminName` (`adminName`) USING BTREE
     ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
     
     # Add two administrators
     INSERT INTO `storeweb_db`.`admin_table`(`aid`, `adminName`, `pwd`) VALUES (1, 'Bruce Li', '666');
     INSERT INTO `storeweb_db`.`admin_table`(`aid`, `adminName`, `pwd`) VALUES (2, 'John liu', '222');

    