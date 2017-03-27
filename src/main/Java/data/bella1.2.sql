/*
 Navicat Premium Data Transfer

 Source Server         : windows
 Source Server Type    : MySQL
 Source Server Version : 50634
 Source Host           : 192.168.10.102
 Source Database       : bella

 Target Server Type    : MySQL
 Target Server Version : 50634
 File Encoding         : utf-8

 Date: 03/26/2017 16:02:21 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `label`
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label` (
  `labelID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `labelName` varchar(255) DEFAULT NULL,
  `iconUrl` varchar(255) DEFAULT NULL,
  `description` text,
  `linkCount` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`labelID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `label`
-- ----------------------------
BEGIN;
INSERT INTO `label` VALUES ('10001', 'Java', null, '四代编程语言', '1');
COMMIT;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `member`
-- ----------------------------
BEGIN;
INSERT INTO `member` VALUES ('3', 'member001', '陈卓', 'sfj33r190-fn2k3nr1r', '263596836@qq.com', '2017-02-28 11:41:42', '0', null, '18456239658', 'sunny'), ('4', 'member002', '小王', 'sfj33r190-fn2k3nr1r', '231332@qq.com', '2017-03-26 15:26:58', '0', null, '18726784578', 'kitty');
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
--  Records of `plat_admin`
-- ----------------------------
BEGIN;
INSERT INTO `plat_admin` VALUES ('0', 'chen', 'chen', '0', '1', '0', '2017-03-14 20:58:51');
COMMIT;

-- ----------------------------
--  Table structure for `plat_func`
-- ----------------------------
DROP TABLE IF EXISTS `plat_func`;
CREATE TABLE `plat_func` (
  `funcid` int(11) unsigned NOT NULL AUTO_INCREMENT,
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
  `status` int(11) DEFAULT '0' COMMENT '显示状态 1：显示 0 ：不显示',
  PRIMARY KEY (`funcid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `plat_func`
-- ----------------------------
BEGIN;
INSERT INTO `plat_func` VALUES ('1', '系统管理', 'linecons-cog', '', '0', '99', '1', '0', null, '测试。。。', null, '1'), ('2', '功能管理', null, '', '1', '1', '1', '1', '测试', null, '2017-03-07 21:15:52', '1'), ('3', '功能列表', '', 'Admin/func/list.do', '1', '1', '0', '0', null, '', null, '1'), ('4', '会员管理', 'linecons-user', '', '0', '0', '0', '0', null, '', null, '1'), ('5', '会员列表', '', 'Admin/member/list.do', '4', '0', '0', '0', null, '', '2017-03-13 23:34:47', '1'), ('6', '清空缓存', '', 'Admin/main/clearCache.do', '1', '99', '0', '0', null, '清空后端系统中的缓存数据', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `post`
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `postID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `authorID` int(11) unsigned DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `content` text,
  `readTimes` int(11) DEFAULT NULL,
  `replyTimes` int(11) DEFAULT NULL,
  PRIMARY KEY (`postID`),
  KEY `authorID` (`authorID`),
  KEY `authorID_2` (`authorID`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`authorID`) REFERENCES `member` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `post`
-- ----------------------------
BEGIN;
INSERT INTO `post` VALUES ('10001', '我爱你', '3', '2017-03-26 15:35:51', '孙桂青', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `post_relate_label`
-- ----------------------------
DROP TABLE IF EXISTS `post_relate_label`;
CREATE TABLE `post_relate_label` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `postID` int(11) unsigned DEFAULT NULL,
  `labelID` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `postID` (`postID`),
  KEY `labelID` (`labelID`),
  CONSTRAINT `post_relate_label_ibfk_1` FOREIGN KEY (`postID`) REFERENCES `post` (`postID`),
  CONSTRAINT `post_relate_label_ibfk_2` FOREIGN KEY (`labelID`) REFERENCES `label` (`labelID`)
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
