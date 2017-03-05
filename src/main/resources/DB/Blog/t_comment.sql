/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-05 23:42:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '���۱�id',
  `userIp` varchar(50) DEFAULT NULL COMMENT '�����ߵ�ip',
  `content` varchar(1000) DEFAULT NULL COMMENT '��������',
  `commentDate` datetime DEFAULT NULL COMMENT '��������',
  `state` int(11) DEFAULT NULL COMMENT '���״̬',
  `blog_id` int(11) DEFAULT NULL COMMENT '����������岩��',
  PRIMARY KEY (`id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('2', '0:0:0:0:0:0:0:1', '阿飞速度', '2017-03-05 23:25:31', '1', '42');
