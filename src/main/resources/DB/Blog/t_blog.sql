/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : lingzhu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2017-03-05 23:42:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_blog
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '��������',
  `title` varchar(200) NOT NULL COMMENT '������Ŀ',
  `summary` varchar(400) DEFAULT NULL COMMENT '����ժҪ',
  `releaseDate` datetime DEFAULT NULL COMMENT '��������',
  `clickHit` int(11) DEFAULT NULL COMMENT '���۴���',
  `replyHit` int(11) DEFAULT NULL COMMENT '�ظ�����',
  `content` text COMMENT '��������',
  `keyWord` varchar(200) DEFAULT NULL COMMENT '�ؼ���',
  `type_id` int(11) DEFAULT NULL COMMENT '��������������',
  PRIMARY KEY (`id`),
  KEY `type_id` (`type_id`),
  CONSTRAINT `t_blog_ibfk_1` FOREIGN KEY (`type_id`) REFERENCES `t_blogtype` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_blog
-- ----------------------------
INSERT INTO `t_blog` VALUES ('35', '2321', '123123', '2017-03-05 22:14:44', '0', '0', '<p>123123</p><p><img src=\"/static/userImages/20170305/1488719679642075948.png\" title=\"1488719679642075948.png\" alt=\"msplits_logo.png\"/></p>', '', '1');
INSERT INTO `t_blog` VALUES ('36', '2321', '123123', '2017-03-05 22:14:49', '0', '0', '<p>123123</p><p><img src=\"/static/userImages/20170305/1488719679642075948.png\" title=\"1488719679642075948.png\" alt=\"msplits_logo.png\"/></p>', '', '1');
INSERT INTO `t_blog` VALUES ('37', '1', '1', '2017-03-05 22:18:21', '1', '0', '<p>1</p>', '', '1');
INSERT INTO `t_blog` VALUES ('38', '??????', '121212???', '2017-03-05 22:19:36', '2', '0', '<p>121212</p><p>???</p><p><img src=\"/static/userImages/20170305/1488719974172051746.png\" title=\"1488719974172051746.png\" alt=\"msplits_logo.png\"/></p>', '', '1');
INSERT INTO `t_blog` VALUES ('39', ' ????', '?????? ??? ', '2017-03-05 22:20:43', '1', '0', '<p>??????<br/></p><p><img src=\"/static/userImages/20170305/1488720035565051695.png\" title=\"1488720035565051695.png\" alt=\"msplits_logo.png\"/></p><p><br/></p><p>&nbsp;???&nbsp;</p>', '', '1');
INSERT INTO `t_blog` VALUES ('40', ' 阿斯顿发生点', '发动司法', '2017-03-05 22:25:04', '2', '0', '<p>发动司法<img src=\"/static/userImages/20170305/1488720302257032723.png\" title=\"1488720302257032723.png\" alt=\"msplits_logo.png\"/></p>', '', '1');
INSERT INTO `t_blog` VALUES ('41', '阿骨打发送阿斯顿', '', '2017-03-05 22:26:43', '1', '0', '<p><img src=\"/static/userImages/20170305/1488720359348056719.png\" title=\"1488720359348056719.png\" alt=\"msplits_logo.png\"/></p>', '', '1');
INSERT INTO `t_blog` VALUES ('42', '我的', '发大水发', '2017-03-05 23:25:06', '12', '1', '<p>发大水发</p><p><br/></p><p><img src=\"/Blog//static/userImages/20170305/1488723898705017766.jpg\" title=\"1488723898705017766.jpg\" alt=\"Jellyfish.jpg\" width=\"436\" height=\"205\"/></p>', '', '1');
