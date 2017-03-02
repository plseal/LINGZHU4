/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-02 23:02:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_access_token
-- ----------------------------
DROP TABLE IF EXISTS `t_access_token`;
CREATE TABLE `t_access_token` (
  `id` int(100) DEFAULT NULL,
  `access_token` varchar(600) NOT NULL,
  `expires_in` varchar(100) NOT NULL,
  `create_time` bigint(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_access_token
-- ----------------------------
INSERT INTO `t_access_token` VALUES ('1', 'tTg4t3zn3Rc82nnKf3-GJZOXGp0pM0evuTkoXbV_IldGUTAjC2u6fOx1rL_cEeTSGKL_pUiVnD3kl1exjqjh8YSfycbYlrXMXfU5uFgaEXXaSA-eUFC0uqZhOjDnrBltQTKcAAAHKB', '7200', '1488461774506');
