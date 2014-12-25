/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : smile

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2014-12-24 17:40:20
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tcim_mer_account`
-- ----------------------------
DROP TABLE IF EXISTS `tcim_mer_account`;
CREATE TABLE `tcim_mer_account` (
  `ACCT_ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '账户ID',
  `ACCT_CODE` varchar(40) NOT NULL COMMENT '交易账户号',
  `MER_CODE` varchar(40) NOT NULL COMMENT '商户号',
  `ACCT_NAME` varchar(256) NOT NULL COMMENT '交易账户名',
  `CURRENCY` varchar(8) NOT NULL COMMENT '币种_156：人民币',
  `BANK_CODE` varchar(40) NOT NULL COMMENT '开户银行',
  `BANK_NAME` varchar(256) NOT NULL COMMENT '开户银行名称',
  `BANK_KEY` varchar(40) NOT NULL COMMENT '银行联行号',
  `BRANCH_CODE` varchar(40) NOT NULL COMMENT '分行编号_开户行编号',
  `BRANCH_NAME` varchar(256) NOT NULL COMMENT '分行名称_开户行名称',
  `BANK_ACCT_NO` varchar(40) NOT NULL COMMENT '商户银行账号',
  `BANK_ACCT_NAME` varchar(256) NOT NULL COMMENT '商户银行户名',
  `STL_TYPE` varchar(8) NOT NULL COMMENT '清算类型_1:对公 2：对私',
  `BAL_FLOOR` decimal(24,4) NOT NULL COMMENT '余额下限',
  `AUTO_TRANSFER` int(1) NOT NULL COMMENT '是否开通协议划款_0：否 1：是',
  `MIN_TRANSFER` decimal(24,4) DEFAULT NULL COMMENT '最低划款金额',
  `TRANSFER_PERIOD` varchar(8) DEFAULT NULL COMMENT '划款周期_1:工作日划款 2:一周两次 3:一周一次',
  `IS_AUTO_STL` char(1) DEFAULT NULL COMMENT '是否自动出款_0：否 1：是',
  `BEGIN_TRANSFER` varchar(10) DEFAULT NULL COMMENT '开始划款日期',
  `TRANSFER_PRIORITY` int(8) NOT NULL COMMENT '出款优先级_1,2,3',
  `ALLOW_IN` char(1) NOT NULL COMMENT '是否允许收款_0：否 1：是',
  `ALLOW_OUT` char(1) NOT NULL COMMENT '是否允许出款_0：否 1：是',
  `OUT_FLAG` varchar(8) DEFAULT NULL COMMENT '出款标志_区分是风控的冻结还是公安的冻结 二进制“01”表示风控允许出款；二进制“10”表示公安允许出款；“11”表示都允许出款；“00”表示都不允许出款',
  `REMARK` varchar(256) DEFAULT NULL COMMENT '备注',
  `VERSION` decimal(8,0) DEFAULT NULL COMMENT '版本',
  `STATUS` varchar(8) DEFAULT NULL COMMENT '版本状态_1:审核中 2:有效 3:无效',
  `OPER_FLAG` varchar(8) DEFAULT NULL COMMENT '操作标志_1:被删除 2:被新版本替换',
  `EFFECT_DATE` varchar(10) DEFAULT NULL COMMENT '生效日期',
  `LOSE_EFFECT_DATE` varchar(10) DEFAULT NULL COMMENT '失效日期',
  `MODIFY_BY` varchar(10) DEFAULT NULL COMMENT '修改人',
  `MODIFY_TIME` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`ACCT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2000002555 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tcim_mer_account
-- ----------------------------
INSERT INTO tcim_mer_account VALUES ('2000002493', '1020550016', '102055', '开发环境Q1-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '111111', '1', '10.0000', '1', '1.0000', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, '2014-12-24 13:47:33');
INSERT INTO tcim_mer_account VALUES ('2000002494', '1000720019', '100072', '开发环境Q0-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002495', '1000730018', '100073', '开发环境R0-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002496', '1000740017', '100074', '开发环境S0-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002497', '1000750016', '100075', '开发环境T0-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002498', '1020550016', '102055', '开发环境Q1-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '111111', '1', '10.0000', '1', '1.0000', '1', '1', '1', '1', '1', '1', '1', null, null, null, null, null, null, null, '2014-12-24 13:47:33');
INSERT INTO tcim_mer_account VALUES ('2000002499', '1000770014', '100077', '开发环境R1-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002500', '1000780013', '100078', '开发环境S1-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002501', '1000790012', '100079', '开发环境T1-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002502', '1000800019', '100080', '开发环境Q05-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002503', '1000810018', '100081', '开发环境R05-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002504', '1000820017', '100082', '开发环境S05-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002505', '1000830016', '100083', '开发环境T05-0423', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-13', '2015-05-12', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002542', '1000840015', '100084', '开发环境Q0-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002543', '1000850014', '100085', '开发环境R0-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002544', '1000860013', '100086', '开发环境S0-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002545', '1000870012', '100087', '开发环境T0-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002546', '1000880011', '100088', '开发环境Q1-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002547', '1000890010', '100089', '开发环境R1-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002548', '1000900017', '100090', '开发环境S1-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002549', '1000910016', '100091', '开发环境T1-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002550', '1000920015', '100092', '开发环境Q05-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002551', '1000930014', '100093', '开发环境R05-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002552', '1000950012', '100095', '开发环境S05-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002553', '1000940013', '100094', '开发环境T05-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '10.0000', '1', '11.0000', '1', null, null, '1', '1', '0', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
INSERT INTO tcim_mer_account VALUES ('2000002554', '1009760040', '100976', '开发环境T05-0427', '156', '1100', '中国工商银行', '11', '1111', '龙华分行', '11111', '1111', '1', '1.0000', '1', '5.0000', '1', null, null, '1', '1', '1', null, null, null, null, null, '2014-05-14', '2015-05-01', null, null);
