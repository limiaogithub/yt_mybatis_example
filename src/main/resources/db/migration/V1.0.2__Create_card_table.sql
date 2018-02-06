CREATE TABLE `CardT` (
  `cardId` varchar(36) NOT NULL COMMENT 'card ID',
  `memberId` varchar(36) NOT NULL COMMENT '会员ID',
  `cardName` varchar(100) DEFAULT NULL COMMENT '会员名称',
  `founderId` varchar(36) DEFAULT '' COMMENT '创建人ID',
  `founderName` varchar(30) DEFAULT '' COMMENT '创建人姓名',
  `modifierId` varchar(36) DEFAULT '' COMMENT '修改人ID',
  `modifierName` varchar(30) DEFAULT '' COMMENT '修改人姓名',
  `createDateTime` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '创建时间',
  `modifyDateTime` datetime NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT '修改时间',
  `deleteFlag` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除 0 否 1是',
  PRIMARY KEY (`cardId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

