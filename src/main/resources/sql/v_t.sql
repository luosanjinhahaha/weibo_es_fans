/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : weibo

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 09/10/2019 19:23:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for v_t
-- ----------------------------
DROP TABLE IF EXISTS `v_t`;
CREATE TABLE `v_t`  (
  `id` int(11) NOT NULL,
  `v_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `v_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `v_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `concern_amount` int(11) NULL DEFAULT NULL,
  `fans_amount` int(11) NULL DEFAULT NULL,
  `sex` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lv` int(11) NULL DEFAULT NULL,
  `image_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of v_t
-- ----------------------------
INSERT INTO `v_t` VALUES (1, '2354644175', '牟星', '演员，代表作《利刃出击》《藏地密码》《特种兵之霹雳火》等', 391, 11577328, 'm', 48, 'group1/M00/00/00/wKgAbF2bNrmAB_nVAARvkq3494o898.jpg');
INSERT INTO `v_t` VALUES (2, '5033393722', '任天野', '演员，代表作《我是特种兵》《特警力量》《特种兵之霹雳火》', 81, 2385302, 'm', 37, 'group1/M00/00/00/wKgAbF2bUmCAYqFzAAH4ON52f3Y701.jpg');
INSERT INTO `v_t` VALUES (3, '1737650455', '张进', '演员，代表作《特种兵之霹雳火》', 900, 8829523, 'm', 48, 'group1/M00/00/00/wKgAbF2bVD-AVeLAAAN8CnmW5c4491.jpg');
INSERT INTO `v_t` VALUES (4, '1620119650', '李飞', '演员，代表作《特种兵之霹雳火》', 1384, 1411242, 'm', 48, 'group1/M00/00/00/wKgAbF2bV-WAJsqoAASjEOGRG1A938.jpg');
INSERT INTO `v_t` VALUES (5, '1629359974', '杨烁', '演员，代表作《利刃出击》《我是特种兵》', 380, 807178, 'm', 48, 'group1/M00/00/00/wKgAbF2bWdeAHNGCAADPoaRE2mk608.jpg');
INSERT INTO `v_t` VALUES (6, '2302129312', '方君荐电影', '方聿南，也许是影迷。 秘密都在@方君的怪奇录像厅', 463, 9996506, 'm', 48, 'group1/M00/00/00/wKgAbF2bNuuAC7wXAAPo0h57F8c723.jpg');
INSERT INTO `v_t` VALUES (7, '3901429666', '谷阿莫', '我說故事，你聽故事，B站：https://space.bilibili.com/8578857#!/', 75, 11176052, 'm', 14, 'group1/M00/00/00/wKgAbF2bNvKAGdkSAAIbeL--cWc228.jpg');
INSERT INTO `v_t` VALUES (8, '1992769421', '迷影心生', '下面由心生给来点好玩的', 547, 9304098, 'm', 48, 'group1/M00/00/00/wKgAbF2bNvuAdjIIAANc4YmnkUI986.jpg');
INSERT INTO `v_t` VALUES (9, '1407722902', '桃桃淘电影', '我的公共号：ttfilm。合作可联系邮箱359327501@qq.com', 440, 5605135, 'm', 48, 'group1/M00/00/00/wKgAbF2bNwSAeHGiAAU7-oPHxfU532.jpg');
INSERT INTO `v_t` VALUES (10, '5639849121', '影视大魔王', '有态度的影评（我就不上我就逼逼！）', 316, 7711674, 'm', 42, 'group1/M00/00/00/wKgAbF2bNwyAKnSGAAOUHY7Tt00854.jpg');

SET FOREIGN_KEY_CHECKS = 1;
