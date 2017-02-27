/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost
 Source Database       : bella

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 02/27/2017 21:49:16 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `accountID` varchar(255) NOT NULL COMMENT '账户ID',
  `accountName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `addTime` datetime DEFAULT NULL,
  `status` int(8) DEFAULT NULL COMMENT '状态：0生效；1禁用',
  `headPicFileURL` varchar(255) DEFAULT NULL,
  `mobilePhone` varchar(255) DEFAULT NULL,
  `nickName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`,`accountID`,`accountName`,`email`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `member`
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES ('1', 'member0001', '', 'wertyierwwoo', '111111@qq.com', '2017-02-06 09:19:58', '0', null, '18745695623', '小凤凰');
COMMIT;

-- ----------------------------
--  Table structure for `member_info`
-- ----------------------------
DROP TABLE IF EXISTS `member_info`;
CREATE TABLE `member_info` (
  `MemberID` int(11) unsigned NOT NULL,
  `IdentityCard` varchar(255) NOT NULL COMMENT '身份证号',
  `Sex` int(8) DEFAULT NULL COMMENT '0 : 男，1：女',
  `MemberProfile` varchar(255) DEFAULT NULL COMMENT '用户职业',
  `MemberWebUrl` varchar(255) DEFAULT NULL COMMENT '用户私人主页',
  `MemberBirthDay` datetime DEFAULT NULL,
  PRIMARY KEY (`MemberID`,`IdentityCard`),
  CONSTRAINT `member_info_ibfk_1` FOREIGN KEY (`MemberID`) REFERENCES `member` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `plat_admin`
-- ----------------------------
DROP TABLE IF EXISTS `plat_admin`;
CREATE TABLE `plat_admin` (
  `ID` int(11) NOT NULL,
  `adminName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `adminType` int(8) DEFAULT NULL COMMENT '管理员类型：\n1 超级管理员\n3 管理员\n',
  `status` int(8) DEFAULT NULL COMMENT '状态: 1正常 2禁用 3删除',
  `creatorID` int(11) DEFAULT NULL,
  `addTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `plat_func`
-- ----------------------------
DROP TABLE IF EXISTS `plat_func`;
CREATE TABLE `plat_func` (
  `funcid` int(11) NOT NULL,
  `funcName` varchar(255) DEFAULT NULL,
  `funcIcon` varchar(255) DEFAULT NULL,
  `funcUrl` varchar(255) DEFAULT NULL,
  `parentFuncID` int(11) DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  `levelNum` int(11) DEFAULT NULL,
  `menuFlag` int(8) DEFAULT '1' COMMENT '是否菜单项：1是 0不是',
  `remark` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `addTime` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`funcid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `web_member`
-- ----------------------------
DROP TABLE IF EXISTS `web_member`;
CREATE TABLE `web_member` (
  `webMemberID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `tempVerifyMsisdn` varchar(12) DEFAULT NULL COMMENT '手机',
  `tempVerifyCode` varchar(255) DEFAULT NULL COMMENT '临时验证码',
  `memberUserID` int(11) unsigned DEFAULT NULL,
  `addTime` datetime DEFAULT NULL,
  `tempVerifyTime` datetime DEFAULT NULL COMMENT '验证码截至有效期（临时使用）',
  PRIMARY KEY (`webMemberID`),
  KEY `memberUserID` (`memberUserID`),
  CONSTRAINT `web_member_ibfk_1` FOREIGN KEY (`memberUserID`) REFERENCES `member` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
