/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-06 23:33:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blogtype
-- ----------------------------
DROP TABLE IF EXISTS `t_blogtype`;
CREATE TABLE `t_blogtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '����id',
  `typeName` varchar(30) DEFAULT NULL COMMENT '�������',
  `orderNum` int(11) DEFAULT NULL COMMENT '��������',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blogtype
-- ----------------------------
INSERT INTO `t_blogtype` VALUES ('1', '常见疾病', '11');
INSERT INTO `t_blogtype` VALUES ('2', '科学辟谣', '12');
INSERT INTO `t_blogtype` VALUES ('3', '养生保健', '13');
INSERT INTO `t_blogtype` VALUES ('4', '就医宝典', '14');
INSERT INTO `t_blogtype` VALUES ('5', '医疗前沿', '15');
INSERT INTO `t_blogtype` VALUES ('6', '孕期无忧', '21');
INSERT INTO `t_blogtype` VALUES ('7', '辣妈最爱', '22');
INSERT INTO `t_blogtype` VALUES ('8', '奶爸必看', '23');
INSERT INTO `t_blogtype` VALUES ('9', '萌宝手册', '24');
INSERT INTO `t_blogtype` VALUES ('10', '成长点滴', '25');
INSERT INTO `t_blogtype` VALUES ('11', '咨询医生', '31');
INSERT INTO `t_blogtype` VALUES ('12', '联系我们', '32');
INSERT INTO `t_blogtype` VALUES ('13', '健康档案', '33');
INSERT INTO `t_blogtype` VALUES ('14', '会员中心', '34');
INSERT INTO `t_blogtype` VALUES ('15', '更多精彩', '35');
