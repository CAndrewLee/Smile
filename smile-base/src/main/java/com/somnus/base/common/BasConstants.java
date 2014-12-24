/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building, 
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.base.common;

/**
 * BasConstants
 * 
 * @author IH745
 * @version 1.0 13-10-08
 */
public class BasConstants {
	
	/**出款标志-风控允许出款*/
	public final static String MER_ACC_OUT_FLAG01 ="01";
	/**出款标志-公安允许出款*/
	public final static String MER_ACC_OUT_FLAG10 ="10";
	/**出款标志-都允许出款*/
	public final static String MER_ACC_OUT_FLAG11 ="11";
	/**出款标志-都不允许出款*/
	public final static String MER_ACC_OUT_FLAG00 ="00";
	
	/** 0：全额退款  */
	public final static String REF_KIND_ALL ="0";
	/** 1：部分退款 */
	public final static String REF_KIND_PART ="1";
	
	/** 协议出款类型 01协议出款*/
	public static final String BIZTYPE_PROTOCOLDRAW="01";
	/** 协议出款类型 02提现*/
	public static final String BIZTYPE_WITHDRAW="02";
	/** 协议出款类型 03即时下发*/
	public static final String BIZTYPE_ISSUED_IMMEDIATE_DRAW="03";
	/** 协议出款类型 04快速下发*/
	public static final String BIZTYPE_ISSUED_RAPID_DRAW="04";
	
	/**非协议出款出款优先级默认值*/
	public static final String DRAW_PRI_NO_DEFAULT = "1";
	
	/** 是否产生实时余额 : 0：产生  */
	public final static String IS_REAL_BAL_TURE = "0";
	/** 是否产生实时余额 : 1：不产生 */
	public final static String IS_REAL_BAL_FALSE = "1";
	/**
	 * cdFlag
	 */
	public final static String CD_FLAG_D = "D";
	public final static String CD_FLAG_C = "C";

	/**
	 * 0 普通余额更新、1 业务冻结、2 监管冻结
	 */
	public final static String BAL_UPDTFLAG_COMMON = "0";
	public final static String BAL_UPDTFLAG_BUSINESS = "1";
	public final static String BAL_UPDTFLAG_SUPERVISE = "2";

	/** 记账状态 0：待处理  */
	public final static String ACC_STATUS_HANDLING = "0";
	/** 记账状态 1：正常记账   */
	public final static String ACC_STATUS_SUCCESS = "1";
	/** 记账状态 2：差错记账  【商户不存在】 */
	public final static String ACC_STATUS_FAIL = "2";

	/** 科目发生额类型: 0:交易金额  */
	public final static String SUB_AMT_TYPE_TRAN = "0";
	/** 科目发生额类型: 1:订单金额  */
	public final static String SUB_AMT_TYPE_ORDER = "1";
	/** 科目发生额类型:  2:手续费  */
	public final static String SUB_AMT_TYPE_FEE = "2";
	/** 科目发生额类型:  3:保证金  */
	public final static String SUB_AMT_TYPE_BAIL = "3";
	/** 科目发生额类型:  4:银行成本 */
	public final static String SUB_AMT_TYPE_COST = "4";
	
	/** 科目方向: 1:付款方 */
	public final static String SUB_DIR_PAY = "1";
	/** 科目方向: 2:收款方   */
	public final static String SUB_DIR_REC = "2";
	/** 科目方向: 3:第三方 */
	public final static String SUB_DIR_THD = "3";

	/**
	 * 手续费收取方向: 1	付款人承担2	收款人承担3	第三方承担

	 */
	/** 手续费收取方向: 0 默认 */
	public final static String FEE_FLAG_DEFAULT = "0";
	/** 手续费收取方向: 2 收款人承担 */
	public final static String FEE_FLAG_REC = "2";
	/** 手续费收取方向: 1 付款人承担 */
	public final static String FEE_FLAG_PAY = "1";
	/** 手续费收取方向: 3 第三方承担 */
	public final static String FEE_FLAG_THD = "3";

	/** 科目类型:1：客户 */
	public final static String SUB_TYPE_CUS = "1";
	/** 科目类型:0：内部*/ 
	public final static String SUB_TYPE_INNER = "0";

	/** 是否红字:1是 */
	public final static String IS_RED_TRUE = "1";
	/** 是否红字:0否  */
	public final static String IS_RED_FALSE = "0";
	
	/** 发起方标识 0:收款方  */
	public final static String INITIATOR_FLG_REC = "0";
	/** 发起方标识  1：付款方 */
	public final static String INITIATOR_FLG_PAY = "1";
	/** 发起方标识  2：其他 */
	public final static String INITIATOR_FLG_OTHER = "2";

	/** 记账模式 1：同步  */
	public final static String ACC_MODE_SYN = "1";
	/** 记账模式  2：异步 */
	public final static String ACC_MODE_ASYN = "2";

	/** 手续费结算方式 0：默认 */
	public final static String FEE_STL_MODE_DEFAULT = "0";
	/** 手续费结算方式 1：日结 */
	public final static String FEE_STL_MODE_TRAN = "1";
	/** 手续费结算方式 2：预付费 */
	public final static String FEE_STL_MODE_PRE = "2";
	/** 手续费结算方式 3：后结算 */
	public final static String FEE_STL_MODE_AFTER = "3";
	
	/**商户类型  0：个人 */
	public final static String BIZ_KIND_PERSON = "0";
	/**商户类型  1：商户 */
	public final static String BIZ_KIND_CUS = "1";
	/**商户类型  2：银行或IPS */
	public final static String BIZ_KIND_BANKORIPS = "2";
	/**
	 * 默认发生机构：迅付
	 */
	public final static String DEFAULT_SUPPLIER_CODE = "10000";

	/** 是否保证金交易: 1：保证金交易 */
	public final static String IS_DEPOSIT_TRUE = "1";
	/** 是否保证金交易:0:非保证金交易  */
	public final static String IS_DEPOSIT_FALSE = "0";
	
	/** 保证金缴纳状态:0:未缴纳  */
	public final static String DEPOSIT_STATUS_NOTGATHER = "0";
	/** 保证金缴纳状态:1：已缴纳 */
	public final static String DEPOSIT_STATUS_GATHERED = "1";
	/** 保证金缴纳状态: 2：已返还 */
	public final static String DEPOSIT_STATUS_BACK = "2";
	/*** 入账状态 0：未入账 */
	public final static String BLN_STATUS_NOTENTER = "0";
	/*** 入账状态 1：已入账 */
	public final static String BLN_STATUS_ENTERED = "1";
	/*** 入账状态 2：无需入账 */
	public final static String BLN_STATUS_NOTNEED = "2";
	/*** 入账状态 3：可内部入账 */
	public final static String BLN_STATUS_INNERENTER = "3";
	/*** 入账状态 4：不可入账 */
	public final static String BLN_STATUS_CANNOT = "4";
	/**
	 * 默认操作员
	 */
	public final static String DEFAULT_OPERATOR = "GUEST";
	/**
	 * 默认系统号
	 */
	public final static String DEFAULT_SYSCODE = "1005";
	
	public final static String DEFAULT_BRCCODE = "1000";
	
	public final static String DEFAULT_CHANNELNO = "06";

	/**
	 * CUTCODE
	 */
	public static final String CORE_CUT_CODE = "BACS";
	/**
	 * ALLOW_IN
	 */
	public static final String ALLOW_IN_TRUE = "1";
	/**
	 * ALLOW_OUT 允许出款
	 */
	public static final String ALLOW_OUT_TRUE = "1";
	/** 入账模式 0：默认 */
	public static final String BLN_MODE_DEFAULT = "0";
	/** 入账模式 1:T+0实时入账 */
	public static final String BLN_MODE_NOW = "1";
	/** 入账模式  2：T+0延时入账*/
	public static final String BLN_MODE_DELAY = "2";
	/** 入账模式  3：T+N入账  */
	public static final String BLN_MODE_N = "3";
	/** 入账模式  4：人工触发入账 */
	public static final String BLN_MODE_HAND = "4";
	/**
	 * 分录类型:1：记账分录 2：入账分录 3：结算分录
	 */
	/**  分录类型: 2：入账分录 */
	public static final String ACC_ENTRY_TYPE_ENTER = "2";
	/**
	 * 收款方日扣手续费会计分录
	 */
	public static final String ACC_ENTRY_CODE_HANDCHARGE = "1211100501";
	/**
	 * 收取保证金
	 */
	public static final String ACC_ENTRY_CODE_GATHERDEPOSIT = "1211102401";
	
	
	/**
	 * 手续费是否已计算 0:未计算 1：已计算
	 */
	public static final String IS_FEE_TRUE = "1";
	/**
	 * 计费模式 0:计算 1：查询（包量和累计时不累记量）
	 */
	public static final String FEE_MODE_CALC = "0";
	
	/** 处理状态	STATUS	0:正常  */
	public static final String STATUS_NORMAL = "0";
	
	/** 处理状态	STATUS	1:退款 */
	public static final String STATUS_REFUND = "1";
	
	/** 处理状态	STATUS	2:拒付 */
	public static final String STATUS_REFUSE = "2";
	
	/** 处理状态	STATUS	3:部分退款、部分拒付 */
	public static final String STATUS_REFUND_PART = "3";
	
	/** 处理状态	STATUS	4:冻结 */
	public static final String STATUS_FREEZE = "4";
	
	/**客户流动资金户科目号*/
	public static final String REL_SUB_CODE_FREE = "82";
	
	/**应收银行科目号*/
    public static final String REL_SUB_CODE_BANK = "31";
    
	/** 入账状态   1：可入账 */
	public static final String IN_ACC_STATUS_CAN = "1";
	/** 入账状态   0：可入账 */
	public static final String IN_ACC_STATUS_CANNOT = "0";
	/**
	 * 1：可透支 0：不可透支
	 */
	public static final String OVER_FLAG_TRUE = "1";
	public static final String OVER_FLAG_FALSE = "0";
	/**
	 * 0 线下，1 线上， 2 线上优先线下备用
	 */
	public static final String IS_ONLINE_TRUE = "1";
	public static final String IS_ONLINE_FALSE = "0";

	/**01协议出款、02提现、03即时下发 04快速下发 05划扣*/
	public static final String BIZTYPE_BUCKLEDRAW="05";

    /**冻结标识  冻结*/
    public static final String FROZEN_YES="1";
    /**冻结标识  未冻结*/
    public static final String FROZEN_NO="0";

    /** 业务类型 1:监管  */
    public static final String FREEZE_BIZ_TYPE_MAG = "1";
    /** 业务类型  2:业务 */
    public static final String FREEZE_BIZ_TYPE_BIZ = "2";
    /** 业务类型  3:下发冻结 */
    public static final String FREEZE_BIZ_TYPE_PAYABLE = "3";

    /** 状态 1:已冻结 */
    public static final String FREEZE_STATUS_FREEZE = "1";
    /** 状态  2:已解冻 */
    public static final String FREEZE_STATUS_UNFREEZE = "2";
    
    /** 状态 0:冻结 */
    public static final String FEECHARGE_STATUS_FREEZE = "0";
    /** 状态 1:成功 */
    public static final String FEECHARGE_STATUS_SUCCESS = "1";
    
    /** 账务核对差错表处理状态 1:已处理 */
    public static final String DIFF_TRANINFO_STATUS_YES = "1";
    /** 账务核对差错表处理状态 0:未处理 */
    public static final String DIFF_TRANINFO_STATUS_NO = "0";
    
    /** 账务核对差错表差错类别 1:台账异常 */
    public static final String DIFF_TRANINFO_ERR_KIND_LEDGER = "1";
    /** 账务核对差错表差错类别 0:流水异常 */
    public static final String DIFF_TRANINFO_ERR_KIND_TRAN = "0";
    
    /** 银行收单前缀*/
    public final static String ENTRY_KEY_INCOME_PRE = "1101";
    
    /** 清算类型：对公 */
    public static final String ACC_STL_TYPE_PUBLICK = "1";
    /** 清算类型：对私 */
    public static final String ACC_STL_TYPE_PRIVATE = "2";
    
    /** 清算类型：对公 */
    public static final String STL_TYPE_PUBLICK = "0";
    /** 清算类型：对私 */
    public static final String STL_TYPE_PRIVATE = "1";
    
    /** posp系统编码*/
    public final static String POST_SYS_CODE="1101";
    
    /** 冲正处理状态  0：受理中  */
    public final static String REVERSE_STATUS_HANDING= "0";
    /** 冲正处理状态  1：已冲正 */
    public final static String REVERSE_STATUS_REVERSEED = "1";
    /** 冲正处理状态  2：已撤销冲正 */
    public final static String REVERSE_STATUS_CANCELED = "2";
    /** 冲正处理状态  3：冲正受理中已撤销冲正 */
    public final static String REVERSE_STATUS_HANDING_CANCELED = "3";
    /** 冲正交易码 */
    public final static String REVERSE_TRAN_CODE="1803";

}
