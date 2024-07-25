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

 Date: 25/07/2024 20:47:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `sex` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `studentId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '学号',
  `academy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '学院',
  `major` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '专业',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门',
  `cardNumber` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '银行卡',
  `qq` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT 'qq',
  `weiXin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '微信',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '123' COMMENT '密码',
  `superAdmin` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '超级管理员',
  PRIMARY KEY (`id`, `studentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (23, '小杜', '男', '3220921038', '计算机科学与工程', '软件工程', '15111111111', 'java开发', '123456789', '2244444444', '5555555555', '2313155555@qq.com', '123', 'yes');
INSERT INTO `admin` VALUES (25, '小颜', '男', '3220921037', '计算机科学与工程', '软件工程', '15111111111', '前端', '132456789', '2244444444', '4444444444', '4444444444', '123', 'yes');
INSERT INTO `admin` VALUES (27, '小刘', '男', '3220921036', '计算机科学与工程', '软件工程', '15122222222', '前端', '1324567', '2222222222', '2222222222', '2222222222', '123', 'no');
INSERT INTO `admin` VALUES (28, '小李', '男', '3220921035', '计算机', '计算机', '15129663920', '前端', '65547854524', '', '', '2245731645@qq.com', '123', 'yes');
INSERT INTO `admin` VALUES (29, '小宋', '男', '3220921034', '计算机科学与工程', '软件工程', '15155555555', '前端', '1112223333446655', '522222222', '2222222222', '2222222222', '123', 'no');

-- ----------------------------
-- Table structure for application
-- ----------------------------
DROP TABLE IF EXISTS `application`;
CREATE TABLE `application`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '申请人',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `academy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '使用学院',
  `number` int NULL DEFAULT NULL COMMENT '活动人数',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '活动内容',
  `usetime` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '活动时间',
  `site` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '活动场地',
  `equipment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '使用设备',
  `teacher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '指导老师',
  `opinion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '部门意见',
  `teaTime` datetime NULL DEFAULT NULL COMMENT '指导老师时间',
  `opTime` datetime NULL DEFAULT NULL COMMENT '处理时间',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id` DESC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application
-- ----------------------------
INSERT INTO `application` VALUES (4, '小杜', '15129663920', '计算机', 18, '预约会议室', '2024-07-17 22:47:06', NULL, NULL, '张老师', '通过', NULL, NULL, 'yes');
INSERT INTO `application` VALUES (3, '小李', '15125555555', NULL, NULL, '会议室', '2024-07-17 22:47:14', '11号楼11楼', NULL, '张老师', '通过', NULL, NULL, 'yes');
INSERT INTO `application` VALUES (1, '小张', '15129663920', NULL, NULL, '参观军事设施', '2024-07-17 22:42:48', '11号楼8楼', NULL, '张老师', '', NULL, NULL, 'no');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '编号',
  `headline` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '状态',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `time` datetime NULL DEFAULT NULL COMMENT '时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (1, '西安理工大学', 'https://www.xaut.edu.cn/', NULL, '7月16日至7月19日，学校2024年新任处级干部培训班在陕西延安干部学院顺利举办，2024年以来新提任的处级干部参加培训。\r\n\r\n7月15日至18日，第十一届全国大学生机械创新设计大赛全国决赛在华中科技大学举行。我校参赛作品在该赛两个阶段的评审中脱颖而出，共荣获国家一等奖1项、二等奖1项、三等奖1项，获奖列全省高校第三、省属高校第一，为全省唯一获得国家一等奖的省属高校。\r\n\r\n全国大学生机械创新设计大赛由教育部高等教育司指导，是教育部、财政部通过“质量工程”资助的全国大学生竞赛项目，是全国普通高校大学生竞赛排行榜榜单赛事，每两年举办一次。本届大赛以“机械创新推进农业现代化、自然和谐迈向仿生新高度”为主题，共有32个赛区730所高校的5600支队伍参赛，涉及学生人数达10万余人，共评出全国一等奖168项，二等奖267项，三等奖234项。\r\n\r\n学校高度重视该赛事，为做好大赛的组织工作，教务处、机仪学院成立了竞赛工作专班，通过整合资源、搭建平台、设立专项经费等，促进师生团队备赛。在近两年备赛过程中，积极邀请校内外专家解析赛题、项目打磨，为选拔优秀项目、不断优化和提升作品打下坚实基础。通过指导教师悉心指导，参赛团队经过方案调研、作品设计、制作等，实现了由创意到产品的全流程实践，学生实践创新能力和团队协作精神得到了有效提升。学校共有来自机仪、材料、印包、国工、自动化等学院的350余名学生参加了本届大赛。。', NULL, NULL);
INSERT INTO `message` VALUES (3, '西安邮电大学', 'https://www.xiyou.edu.cn/', NULL, '西安邮电大学官网', NULL, NULL);
INSERT INTO `message` VALUES (9, '西安工业大学', 'https://www.xatu.edu.cn/', '', '西安工业大学官网', NULL, '');

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
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, '李明', 20, '男', '西安', '123446245');
INSERT INTO `user` VALUES (4, '小王', 20, '男', '西安', '13245687');
INSERT INTO `user` VALUES (5, '小杜', 20, '男', '西安', '15111111111');
INSERT INTO `user` VALUES (7, '王麻子', 21, '男', '北京', '123456897');
INSERT INTO `user` VALUES (8, '张三四', 21, '女', '北京', '123465432');
INSERT INTO `user` VALUES (9, '小红', 20, '女', '北京', '98756484');
INSERT INTO `user` VALUES (10, '小张', 20, '女', '北京', '123465874');
INSERT INTO `user` VALUES (11, '小李', 20, '男', '西安', '123465487');
INSERT INTO `user` VALUES (34, '杜国亮', 20, '男', '西安', '15111111111');
INSERT INTO `user` VALUES (44, '杜国亮', 20, '男', '西安', '15122233338');
INSERT INTO `user` VALUES (46, '杜国亮', 21, '男', '西安', '15129999999');
INSERT INTO `user` VALUES (48, '杜国亮', 21, '男', '西安', '15129999998');

SET FOREIGN_KEY_CHECKS = 1;
