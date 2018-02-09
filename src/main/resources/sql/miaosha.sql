/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50547
Source Host           : 192.168.186.133:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2018-02-09 18:05:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for miaosha_user
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_user`;
CREATE TABLE `miaosha_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户名',
  `login_name` varchar(50) DEFAULT NULL COMMENT '登录名',
  `register_phone` varchar(11) DEFAULT NULL COMMENT '注册手机号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码盐值',
  `head` varchar(255) DEFAULT NULL,
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  `last_login_date` datetime DEFAULT NULL COMMENT '上次登录时间',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of miaosha_user
-- ----------------------------
INSERT INTO `miaosha_user` VALUES ('8', '11', '11', '13912341234', 'f07f92efbe769eac6290d9815e4d9da5', '1644cc4babed49849f276d45805a0561', null, '2018-02-09 02:01:35', null, null);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'lixianch');
INSERT INTO `user` VALUES ('3', 'xiaoming');
INSERT INTO `user` VALUES ('4', 'lixianch');
