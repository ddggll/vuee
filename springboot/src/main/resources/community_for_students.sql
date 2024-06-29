/*
 Navicat Premium Dump SQL

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80037 (8.0.37)
 Source Host           : localhost:3306
 Source Schema         : community_for_students

 Target Server Type    : MySQL
 Target Server Version : 80037 (8.0.37)
 File Encoding         : 65001

 Date: 29/06/2024 20:37:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '张三', 10, '男', '北京', '123456879');
INSERT INTO `user` VALUES (2, '李四', 20, '男', '宝鸡', '123934579');
INSERT INTO `user` VALUES (3, '李明', 20, '男', '西安', '123446245');
INSERT INTO `user` VALUES (4, '小王', 20, '男', '西安', '13245687');
INSERT INTO `user` VALUES (5, '小杜', 20, '男', '西安', '123456987');
INSERT INTO `user` VALUES (7, '王麻子', 21, '男', '北京', '123456897');
INSERT INTO `user` VALUES (8, '张三四', 21, '女', '北京', '123465432');
INSERT INTO `user` VALUES (9, '小红', 20, '女', '北京', '98756484');
INSERT INTO `user` VALUES (10, '小张', 20, '女', '北京', '123465874');
INSERT INTO `user` VALUES (11, '小李', 20, '男', '西安', '123465487');
INSERT INTO `user` VALUES (12, '小杜', 20, '男', '西安', '1234564631');
INSERT INTO `user` VALUES (23, '杜国亮', 32, '男', '西安', '4654354');

SET FOREIGN_KEY_CHECKS = 1;
