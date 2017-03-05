/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-05 23:42:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blogger
-- ----------------------------
DROP TABLE IF EXISTS `t_blogger`;
CREATE TABLE `t_blogger` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `username` varchar(50) NOT NULL COMMENT '��������',
  `password` varchar(100) NOT NULL COMMENT '��������',
  `profile` text COMMENT '������Ϣ',
  `nickname` varchar(50) DEFAULT NULL COMMENT '�����ǳ�',
  `sign` varchar(100) DEFAULT NULL COMMENT '����ǩ��',
  `imagename` varchar(100) DEFAULT NULL COMMENT '����ͷ��·��',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blogger
-- ----------------------------
