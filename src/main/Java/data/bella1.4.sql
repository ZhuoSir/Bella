/*
Navicat MySQL Data Transfer

Source Server         : 本地连接
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : bella

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-05-28 10:43:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bel_label
-- ----------------------------
DROP TABLE IF EXISTS `bel_label`;
CREATE TABLE `bel_label` (
  `labelID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `labelName` varchar(255) DEFAULT NULL,
  `iconUrl` varchar(255) DEFAULT NULL,
  `description` text,
  `linkCount` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`labelID`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bel_label
-- ----------------------------
INSERT INTO `bel_label` VALUES ('10001', 'Java', null, '四代编程语言', '1');

-- ----------------------------
-- Table structure for bel_post
-- ----------------------------
DROP TABLE IF EXISTS `bel_post`;
CREATE TABLE `bel_post` (
  `postID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `authorID` int(11) unsigned DEFAULT NULL,
  `content` text,
  `readTimes` int(11) DEFAULT NULL,
  `replyTimes` int(11) DEFAULT NULL,
  `status` int(8) DEFAULT '0' COMMENT '帖子状态：0 正常发布，-1隐藏 ,  -8 禁止回复，-9 删除',
  `lastReplyMemberID` int(11) unsigned DEFAULT NULL COMMENT '最后一个回复者ID',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `lastReplyTime` datetime DEFAULT NULL COMMENT '最后一次恢复时间',
  PRIMARY KEY (`postID`),
  KEY `authorID` (`authorID`),
  KEY `authorID_2` (`authorID`),
  KEY `lastReplyMemberID` (`lastReplyMemberID`),
  CONSTRAINT `bel_post_ibfk_1` FOREIGN KEY (`authorID`) REFERENCES `member` (`ID`),
  CONSTRAINT `bel_post_ibfk_2` FOREIGN KEY (`lastReplyMemberID`) REFERENCES `member` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10004 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bel_post
-- ----------------------------
INSERT INTO `bel_post` VALUES ('10001', '我爱你', '3', 'PyCharm 2017.1 正式发布了，新版有一个更快的调试器，改进的 Python 和 JavaScript 单元测试，并支持 six Library。其中，专业版对于 Web 开发也有了更大的支持，例如支持 Django, Flask，Pyramid，以及 Vue 等框架。\n\n部分更新内容：\n\nPython 调试器调试 Python 3.6 的项目快了四十倍，对于旧版本的 Python 来说，Python 调试器的速度提高了两倍', '1', '1', '0', null, '2017-04-26 15:35:51', null);
INSERT INTO `bel_post` VALUES ('10002', 'sss', '3', 'ould not find key \'spring.liveBeansView.mbeanDomain\' in any property source', '2', '2', '-1', null, '2017-04-26 20:49:17', null);
INSERT INTO `bel_post` VALUES ('10003', '是吗', '3', 'MYSQL中TIMESTAMP类型可以设定默认值，就像其他类型一样。', '3', '3', '-8', null, '2017-04-26 20:49:35', null);

-- ----------------------------
-- Table structure for bel_reply
-- ----------------------------
DROP TABLE IF EXISTS `bel_reply`;
CREATE TABLE `bel_reply` (
  `replyID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `postID` int(11) unsigned NOT NULL,
  `memberID` int(11) unsigned NOT NULL,
  `replyContent` text,
  `status` int(8) DEFAULT '0' COMMENT '回复状态：0 正常，-9 删除',
  `replyTime` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`replyID`,`postID`),
  KEY `postID` (`postID`),
  KEY `memberID` (`memberID`),
  CONSTRAINT `bel_reply_ibfk_1` FOREIGN KEY (`postID`) REFERENCES `bel_post` (`postID`),
  CONSTRAINT `bel_reply_ibfk_2` FOREIGN KEY (`memberID`) REFERENCES `member` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bel_reply
-- ----------------------------
INSERT INTO `bel_reply` VALUES ('1', '10001', '4', '我是大帅哥', '-9', '2017-03-26 21:34:59');
INSERT INTO `bel_reply` VALUES ('2', '10002', '4', 'hello world', '0', '2017-03-26 21:35:13');
INSERT INTO `bel_reply` VALUES ('3', '10001', '3', '兄弟们你们好吗', '-9', '2017-03-26 21:35:26');
INSERT INTO `bel_reply` VALUES ('4', '10001', '3', '是否接受的福建省地方了房价的房价的减肥的时间发大水', '0', '2017-03-26 21:35:39');
INSERT INTO `bel_reply` VALUES ('5', '10003', '4', '的说法了房间打开房间的房价的减肥的时间', '0', '2017-03-26 21:35:54');

-- ----------------------------
-- Table structure for member
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
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('3', 'member001', '陈卓', 'sfj33r190-fn2k3nr1r', '263596836@qq.com', '2017-02-28 11:41:42', '0', null, '18456239658', 'sunny');
INSERT INTO `member` VALUES ('4', 'member002', '小王', 'sfj33r190-fn2k3nr1r', '231332@qq.com', '2017-03-26 15:26:58', '0', null, '18726784578', 'kitty');

-- ----------------------------
-- Table structure for member_info
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
-- Records of member_info
-- ----------------------------

-- ----------------------------
-- Table structure for member_link_label
-- ----------------------------
DROP TABLE IF EXISTS `member_link_label`;
CREATE TABLE `member_link_label` (
  `RID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `memberID` int(11) unsigned DEFAULT NULL,
  `labelID` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`RID`),
  KEY `memberID` (`memberID`),
  KEY `labelID` (`labelID`),
  CONSTRAINT `member_link_label_ibfk_1` FOREIGN KEY (`memberID`) REFERENCES `member` (`ID`),
  CONSTRAINT `member_link_label_ibfk_2` FOREIGN KEY (`labelID`) REFERENCES `bel_label` (`labelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member_link_label
-- ----------------------------

-- ----------------------------
-- Table structure for plat_admin
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
-- Records of plat_admin
-- ----------------------------
INSERT INTO `plat_admin` VALUES ('0', 'chen', 'oaiId5Os/BmRgqZJ6QXaqw==', '0', '1', '0', '2017-03-28 22:49:20');

-- ----------------------------
-- Table structure for plat_func
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of plat_func
-- ----------------------------
INSERT INTO `plat_func` VALUES ('1', '系统管理', 'linecons-cog', '', '0', '99', '1', '0', null, '测试。。。', null, '1');
INSERT INTO `plat_func` VALUES ('2', '功能管理', null, '', '1', '1', '1', '1', '测试', null, '2017-03-07 21:15:52', '1');
INSERT INTO `plat_func` VALUES ('3', '功能列表', '', 'Admin/func/list.do', '2', '1', '0', '0', null, '', null, '1');
INSERT INTO `plat_func` VALUES ('4', '会员管理', 'linecons-user', '', '0', '0', '0', '0', null, '', null, '1');
INSERT INTO `plat_func` VALUES ('5', '会员列表', '', 'Admin/member/list.do', '4', '0', '0', '0', null, '', '2017-03-13 23:34:47', '1');
INSERT INTO `plat_func` VALUES ('6', '清空缓存', '', 'Admin/main/clearCache.do', '1', '99', '0', '0', null, '清空后端系统中的缓存数据', null, '1');
INSERT INTO `plat_func` VALUES ('7', '帖子管理', 'fa-edit', '', '0', '1', '0', '0', null, '论坛帖子管理', null, '1');
INSERT INTO `plat_func` VALUES ('8', '帖子列表', '', 'Admin/post/list.do', '7', '0', '0', '0', null, '', '2017-03-26 19:00:36', '1');

-- ----------------------------
-- Table structure for post_relate_label
-- ----------------------------
DROP TABLE IF EXISTS `post_relate_label`;
CREATE TABLE `post_relate_label` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `postID` int(11) unsigned DEFAULT NULL,
  `labelID` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`rid`),
  KEY `postID` (`postID`),
  KEY `labelID` (`labelID`),
  CONSTRAINT `post_relate_label_ibfk_1` FOREIGN KEY (`postID`) REFERENCES `bel_post` (`postID`),
  CONSTRAINT `post_relate_label_ibfk_2` FOREIGN KEY (`labelID`) REFERENCES `bel_label` (`labelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post_relate_label
-- ----------------------------

-- ----------------------------
-- Table structure for web_info
-- ----------------------------
DROP TABLE IF EXISTS `web_info`;
CREATE TABLE `web_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `webName` varchar(255) DEFAULT NULL,
  `version` varchar(255) DEFAULT NULL,
  `descrption` varchar(255) DEFAULT NULL,
  `logoPath` varchar(255) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(8) DEFAULT NULL COMMENT '1 当前 0 非当前',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_info
-- ----------------------------

-- ----------------------------
-- Table structure for web_member
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

-- ----------------------------
-- Records of web_member
-- ----------------------------

-- ----------------------------
-- Table structure for web_navigation
-- ----------------------------
DROP TABLE IF EXISTS `web_navigation`;
CREATE TABLE `web_navigation` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `managerID` int(8) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `managerID` (`managerID`),
  CONSTRAINT `web_navigation_ibfk_1` FOREIGN KEY (`managerID`) REFERENCES `plat_admin` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_navigation
-- ----------------------------
INSERT INTO `web_navigation` VALUES ('1', 'Java', '0', '2017-05-28 10:30:36', '0');
