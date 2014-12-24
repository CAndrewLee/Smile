package com.somnus.message.account;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.somnus.message.Message;


/**
 * IncomeRequest 银行卡收单记账请求
 * 
 * @author IH745
 * @version 1.0 13-10-9
 */
public class IncomeRequest extends Message {

	private static final long serialVersionUID = 1L;
	/** 基础产品代码 */
    @NotEmpty
    private String tranCode;
	@NotEmpty
	private String prdCode;
	
	/** IPS订单号 */
	private String ipsBillNo;
    
    /** 应用交易流水号 */
    @NotEmpty
	private String appTranNo;
    
    /** 应用交易时间 */
	@NotNull
	private Date appTranDate;
	
	/** 商户订单号 */
	@NotEmpty
	private String merBillNo;
	
	/** 支付流水号 */
	private String payTranNo;
	
	/** 发起方标识 */
	@NotEmpty
	private String initiatorFlg;
	
	/** 收款方代码 */
	@NotEmpty
	private String payeeCode;
	
	/** 收款方类型 */
	@NotEmpty
	private String payeeType;
	
	/** 收款方账户号 */
	@NotEmpty
	private String payeeAccCode;
	
	/** 交易类型 */
	@NotEmpty
	private String tranType;
	
	/** 支付通道号 */
	@NotEmpty
	private String channelCode;
	
	/** 支付供应商编号 */
	@NotEmpty
	private String supplierCode;
	
	/** 币种 */
	@NotEmpty
	private String ccyCode;
	
	/** 交易金额 */
	@NotNull
	@DecimalMin("0.01") 
	private BigDecimal tranAmt;
	
	/** 订单金额 */
	@NotNull
	@DecimalMin("0")
	private BigDecimal ordAmt;
	
	/** 手续费是否已计算 */
	@NotEmpty
	private String isFee;
	
	/** 手续费承担方 */
	@NotEmpty
	@Pattern(regexp = "^[123]$",message = "must be either 1, 2, or 3" )
	private String feeWay;
	
	/** 手续费 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal feeAmt;
	
	/** 手续费计算方式 */
	@NotEmpty
	@Pattern(regexp = "^[12]$",message = "must be either 1, 2" )
	private String feeType;
	
	/** 手续费费率 */
	@NotNull
	private BigDecimal feeRate;
	
	/** 第三方手续费账户 */
	private String thdAccCode;
	
	/** 手续费结算模式 */
	@NotEmpty
    @Pattern(regexp = "^[123]$",message = "must be either 1, 2, or 3" )
	private String feeStlMode;
	
	/** 退款是否退手续 */
	@NotEmpty
	private String refundFeeBk;
	
	/** 银行成本 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal bankCost;
	
	/** 通道对应银行收款账号 */
	@NotEmpty
	private String bankAccCode;
	
	/** 通道费率计算方式 */
	@NotEmpty
	private String bankFeeType;
	
	/** 通道费率 */
	@NotNull
	private BigDecimal bankFeeRate;
	
	/** 交易备注 */
	private String tranRemark;
	
	/** 保证金 */
	@NotNull
	@DecimalMin("0") 
	private BigDecimal securityDeposit;
	
	/** 保证金返还期限 */
	private int depositDeadLine;

    public String getTranCode() {
        return tranCode;
    }

    public void setTranCode(String tranCode) {
        this.tranCode = tranCode;
    }
	public String getPrdCode() {
		return prdCode;
	}

	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}

	public String getIpsBillNo() {
		return ipsBillNo;
	}

	public void setIpsBillNo(String ipsBillNo) {
		this.ipsBillNo = ipsBillNo;
	}

	public String getAppTranNo() {
		return appTranNo;
	}

	public void setAppTranNo(String appTranNo) {
		this.appTranNo = appTranNo;
	}

	public Date getAppTranDate() {
		return appTranDate;
	}

	public void setAppTranDate(Date appTranDate) {
		this.appTranDate = appTranDate;
	}

	public String getMerBillNo() {
		return merBillNo;
	}

	public void setMerBillNo(String merBillNo) {
		this.merBillNo = merBillNo;
	}

	public String getPayTranNo() {
		return payTranNo;
	}

	public void setPayTranNo(String payTranNo) {
		this.payTranNo = payTranNo;
	}

	public String getPayeeCode() {
		return payeeCode;
	}

	public void setPayeeCode(String payeeCode) {
		this.payeeCode = payeeCode;
	}

	public String getPayeeType() {
		return payeeType;
	}

	public void setPayeeType(String payeeType) {
		this.payeeType = payeeType;
	}

	public String getPayeeAccCode() {
		return payeeAccCode;
	}

	public void setPayeeAccCode(String payeeAccCode) {
		this.payeeAccCode = payeeAccCode;
	}

	public String getTranType() {
		return tranType;
	}

	public void setTranType(String tranType) {
		this.tranType = tranType;
	}

	public String getChannelCode() {
		return channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getCcyCode() {
		return ccyCode;
	}

	public void setCcyCode(String ccyCode) {
		this.ccyCode = ccyCode;
	}

	public BigDecimal getTranAmt() {
		return tranAmt;
	}

	public void setTranAmt(BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}

	public BigDecimal getOrdAmt() {
		return ordAmt;
	}

	public void setOrdAmt(BigDecimal ordAmt) {
		this.ordAmt = ordAmt;
	}

	public String getFeeWay() {
		return feeWay;
	}

	public void setFeeWay(String feeWay) {
		this.feeWay = feeWay;
	}

	public BigDecimal getFeeAmt() {
		return feeAmt;
	}

	public void setFeeAmt(BigDecimal feeAmt) {
		this.feeAmt = feeAmt;
	}

	public String getThdAccCode() {
		return thdAccCode;
	}

	public void setThdAccCode(String thdAccCode) {
		this.thdAccCode = thdAccCode;
	}

	public BigDecimal getBankCost() {
		return bankCost;
	}

	public void setBankCost(BigDecimal bankCost) {
		this.bankCost = bankCost;
	}

	public String getTranRemark() {
		return tranRemark;
	}

	public void setTranRemark(String tranRemark) {
		this.tranRemark = tranRemark;
	}

	public String getInitiatorFlg() {
		return initiatorFlg;
	}

	public void setInitiatorFlg(String initiatorFlg) {
		this.initiatorFlg = initiatorFlg;
	}

	public String getIsFee() {
		return isFee;
	}

	public void setIsFee(String isFee) {
		this.isFee = isFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public BigDecimal getFeeRate() {
		return feeRate;
	}

	public void setFeeRate(BigDecimal feeRate) {
		this.feeRate = feeRate;
	}

	public String getFeeStlMode() {
		return feeStlMode;
	}

	public void setFeeStlMode(String feeStlMode) {
		this.feeStlMode = feeStlMode;
	}

	public String getRefundFeeBk() {
		return refundFeeBk;
	}

	public void setRefundFeeBk(String refundFeeBk) {
		this.refundFeeBk = refundFeeBk;
	}

	public String getBankAccCode() {
		return bankAccCode;
	}

	public void setBankAccCode(String bankAccCode) {
		this.bankAccCode = bankAccCode;
	}

	public String getBankFeeType() {
		return bankFeeType;
	}

	public void setBankFeeType(String bankFeeType) {
		this.bankFeeType = bankFeeType;
	}

	public BigDecimal getBankFeeRate() {
		return bankFeeRate;
	}

	public void setBankFeeRate(BigDecimal bankFeeRate) {
		this.bankFeeRate = bankFeeRate;
	}

	public BigDecimal getSecurityDeposit() {
		return securityDeposit;
	}

	public void setSecurityDeposit(BigDecimal securityDeposit) {
		this.securityDeposit = securityDeposit;
	}

	public int getDepositDeadLine() {
		return depositDeadLine;
	}

	public void setDepositDeadLine(int depositDeadLine) {
		this.depositDeadLine = depositDeadLine;
	}

}
