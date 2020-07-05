/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : sim_db_sys

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 06/07/2020 00:26:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(20) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `icon` char(100) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `href` char(100) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `perms` char(100) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `spread` char(10) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` char(20) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `role_remark` char(255) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` int(11) DEFAULT NULL,
  `menu_id` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(60) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `password` char(32) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `phone` char(15) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `email` char(30) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_work
-- ----------------------------
DROP TABLE IF EXISTS `user_work`;
CREATE TABLE `user_work`  (
  `user_id` int(11) DEFAULT NULL,
  `work_id` int(11) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` char(20) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `content` text CHARACTER SET utf32 COLLATE utf32_general_ci,
  `origin` char(255) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `due_time` date DEFAULT NULL,
  `due_time_alt` char(20) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `finished` tinyint(2) DEFAULT NULL,
  `other` char(255) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for work_info
-- ----------------------------
DROP TABLE IF EXISTS `work_info`;
CREATE TABLE `work_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `wid` int(11) DEFAULT NULL,
  `info` text CHARACTER SET utf32 COLLATE utf32_general_ci,
  `status` int(11) DEFAULT NULL,
  `finished` tinyint(2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `bgs_comment` char(100) CHARACTER SET utf32 COLLATE utf32_general_ci DEFAULT NULL,
  `modify_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf32 COLLATE = utf32_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
