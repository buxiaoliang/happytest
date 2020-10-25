-- CREATE SCHEMA "test" ---------------------
CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 collate utf8_general_ci;

use test;

-- CREATE TABLE "user_info" ------------------------------------
CREATE TABLE `user_info` (
	`id` BigInt( 255 ) NOT NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL)
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------

-- CREATE TABLE "service_info" ------------------------------------
CREATE TABLE `service_info` (
	`id` BigInt( 255 ) NOT NULL,
	`name` VarChar( 255 ) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL)
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------

-- CREATE TABLE "user_service_info" ------------------------------------
CREATE TABLE `user_service_info` (
	`id` BigInt( 255 ) NOT NULL,
	`user_info_id` BigInt( 255 ) NOT NULL,
	`service_info_id` BigInt( 255 ) NOT NULL)
CHARACTER SET = utf8
COLLATE = utf8_general_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------