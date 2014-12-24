/**
 * 
 */
package com.somnus.support.common;

/**
 * 300xxx 系统错误 301xxx 报文错误 302xxx 日间交易异常 303xxx 日终异常
 * 
 * @Title: ErrorCode
 * @Package: com.ips.core.bacs.common.common
 * @Description: 错误信息编码合集
 * @author: cjliu
 * @date: 2012-9-14下午2:03:01
 * @version: 1.0
 */
public class MsgCodeList {
	/**
	 * 处理成功
	 */
	public static final String SUCCESS_000000 = "000000";
	/**
	 * 处理失败
	 */
	public static final String FAILED_222222 = "222222";
	/**
	 * 处理中
	 */
	public static final String HANDING_111111 = "111111";

	/**
	 * 系统异常
	 */
	public static final String ERROR_999999 = "999999";

	/**
	 * 系统错误：系统配置文件{0}不存在！
	 */
	public static final String ERROR_300001 = "300001";

	/**
	 * 系统错误：ACTION返回报文实例为NULL！
	 */
	public static final String ERROR_300002 = "300002";

	/**
	 * 系统错误: 报文内容签名与签名字段不符合，报文被篡改！
	 */
	public static final String ERROR_300003 = "300003";

	/**
	 * 系统错误: 报文签名验证异常！
	 */
	public static final String ERROR_300004 = "300004";
	/**
	 * 借贷函数调用异常！
	 */
	public static final String ERROR_300005 = "300005";

	/**
	 * 系统错误:解密失败!
	 */
	public static final String ERROR_300007 = "300007";

	/**
	 * 系统错误:{0}获取密钥失败!
	 */
	public static final String ERROR_300008 = "300008";
	/**
	 * 报文中，关键字段{0}不可为空！
	 */
	public static final String ERROR_301001 = "301001";

	/**
	 * 报文中，关键字段{0}必须为数字或金额！
	 */
	public static final String ERROR_301002 = "301002";

	/**
	 * 报文中，关键字段{0}格式必须为{1}！
	 */
	public static final String ERROR_301003 = "301003";

	/**
	 * 报文中，{0}元素个数超过限制，最多{1}个！
	 */
	public static final String ERROR_301004 = "301004";

	/**
	 * 报文中，{0}元素长度不正确！
	 */
	public static final String ERROR_301005 = "301005";

	/**
	 * 报文中，当前报文交易代码未指定！
	 */
	public static final String ERROR_301006 = "301006";

	/**
	 * 数据错误: 当前交易未开通使用权限！
	 */
	public static final String ERROR_301007 = "301007";
	/**
	 * 报文中，字段{0}无效！
	 */
	public static final String ERROR_301008 = "301008";
	/**
	 * 
	 * 报文中，字段发生额(tranamt)不可为负数！
	 */
	public static final String ERROR_301010 = "301010";

	/**
	 * 
	 * 报文中，关键字段{0}必须为金额或格式不正确！
	 */
	public static final String ERROR_301009 = "301009";

	/**
	 * 报文中，关键字段{0}必须为整数！
	 */
	public static final String ERROR_301011 = "301011";
	
	/**
	 * 报文中，关键字段{0}必须为正整数！
	 */
	public static final String ERROR_301012 = "301012";

	/**
	 * 
	 * 交易异常:{0}不可为空！
	 */
	public static final String ERROR_302001 = "302001";

	/**
	 * 交易异常:{0}账户信息无效
	 */
	public static final String ERROR_302002 = "302002";

	/**
	 * 交易异常:记账服务调用异常
	 */
	public static final String ERROR_302003 = "302003";

	/**
	 * 交易异常：{0}交易流水已经生成台帐
	 */
	public static final String ERROR_302004 = "302004";

	/**
	 * 交易异常：{0}交易流水台帐已完全记账
	 */
	public static final String ERROR_302005 = "302005";

	/**
	 * 交易出款帐户必须为同一个账户！
	 */
	public static final String ERROR_302006 = "302006";

	/**
	 * 本批次的{0}与实际数据不符！
	 */
	public static final String ERROR_302007 = "302007";

	/**
	 * 交易异常：{0}应当为{1}，而不是{2}
	 */
	public static final String ERROR_302008 = "302008";

	/**
	 * 本批次{0}报文的总金额与前置流水的总笔数不相等
	 */
	public static final String ERROR_302009 = "302009";

	/**
	 * 本批次{0}存在失败的账务前置流水
	 */
	public static final String ERROR_302010 = "302010";

	/**
	 * 本批次{0}手续费总额与账务前置主流水的总手续费不相等
	 */
	public static final String ERROR_302011 = "302011";

	/**
	 * 转账不可以重复{0}
	 */
	public static final String ERROR_302012 = "302012";
	/**
	 * 交易异常：批次号 {0} 没有需要处理的交易信息
	 */
	public static final String ERROR_302013 = "302013";
	/**
	 * 交易异常：转账中商户账户号和对方交易账户号不能相同！
	 */
	public static final String ERROR_302014 = "302014";
	/**
	 * 交易异常：不能成功扣取手续费！
	 */
	public static final String ERROR_302015 = "302015";
	
	/**
	 * 更新异常： 余额不为0不可销户！余额为：{}
	 */
	public static final String ERROR_302018 = "302018";

	/**
	 * 交易异常：台账条数为： {0} ，此交易台账生成条数应为1条
	 */
	public static final String ERROR_302017 = "302017";
	/**
	 * 交易异常： 取手续费失败！
	 */
	public static final String ERROR_302016 = "302016";

	public static final String ERROR_303001 = "303001";

	/**
	 * 定时程序调用返回异常
	 */
	public static final String ERROR_303002 = "303002";

	/**
	 * 当前交易未开通使用权限！
	 */
	public static final String ERROR_303003 = "303003";

	/**
	 * 校验台帐流水失败
	 */
	public static final String ERROR_303004 = "303004";

	/**
	 * 校验台帐与账户失败
	 */
	public static final String ERROR_303005 = "303005";

	/**
	 * 总账核对失败
	 */
	public static final String ERROR_303006 = "303006";

	/**
	 * 账户余额不足！
	 */
	public static final String ERROR_304001 = "304001";

	/**
	 * 余额更新失败！
	 */
	public static final String ERROR_304002 = "304002";

	/**
	 * 账户明细录入失败
	 */
	public static final String ERROR_304003 = "304003";

	/**
	 * 批次请求操作的账户不一致！
	 */
	public static final String ERROR_304004 = "304004";

	/**
	 * 批次请求操作的借贷方向不一致！
	 */
	public static final String ERROR_304005 = "304005";
	/**
	 * 台账分录类型未注册，非法分录！
	 */
	public static final String ERROR_304006 = "304006";

	/**************** 开户交易异常 ************/
	public static final String ERROR_305001 = "305001";// 参数{0}不能为空，交易失败！

	public static final String ERROR_305002 = "305002";// 记录{0}不存在，交易失败！

	public static final String ERROR_305003 = "305003";// 记录{0}存在，交易失败！

	public static final String ERROR_305004 = "305004";// 参数{0}日期格式错误，交易失败！

	public static final String ERROR_305005 = "305005";// 一级总户号和二级总户号不一致{0}，交易失败！

	/** 无法调用创建商户并建立与角色组的关联服务，关键字段{0}为空! */
	public static final String ERROR_305007 = "305007";
	/** 调用创建商户并建立与角色组的关联服务失败! */
	public static final String ERROR_305008 = "305008";

	/** 没有找到机构号{0}对应的机构名称 */
	public static final String ERROR_305006 = "305006";

	/*****************************************/
	public static final String ERROR_307001 = "307001";

	public static final String ERROR_307002 = "307002";

	public static final String ERROR_307003 = "307003";

	public static final String ERROR_307004 = "307004";

	/**************** posp交易异常 ************/
	public static final String ERROR_505001 = "505001";// 参数{0}不能为空，交易失败！

	public static final String ERROR_505002 = "505002";// 记录{0}不存在，交易失败！

	public static final String ERROR_505003 = "505003";// 记录{0}存在，交易失败！

	public static final String ERROR_505004 = "505004";// 参数{0}日期格式错误，交易失败！

	public static final String ERROR_505005 = "505005";// 参数{0}不是数字，交易失败！

	public static final String ERROR_505006 = "505006";// 参数{0}无交易账户号！

	public static final String ERROR_505007 = "505007";// 报文批次、处理 日期与文件內容不一致

	public static final String ERROR_505008 = "505008";// 机构代码{0}无对应银行号！

	public static final String ERROR_505009 = "505009";// 文件{0}下载失败！

	public static final String ERROR_505010 = "505010";// 文件{0}解压失败！

	public static final String ERROR_505011 = "505011";// 导入流水失败！

	public static final String ERROR_505012 = "505012";// 导入结算失败！

	public static final String ERROR_505013 = "505013";// 导入差错失败！
	
	public static final String ERROR_505014 = "505014";// 导入划款失败！
	
	public static final String ERROR_505015 = "505015";// 台帐试算不平衡！
	public static final String ERROR_505016 = "505016";// "{0}商户账户信息不存在！"
	public static final String ERROR_505017 = "505017";// {0}出款功能被关闭，无法完成您申请的操作!
	public static final String ERROR_505018 = "505018";// 交易账户号{0}基础产品{1}配置信息不存在！
	public static final String ERROR_505019 = "505019";// "调用内部账户开通失败！"
	public static final String ERROR_505020 = "505020";// {0}不能进行收单!

}
