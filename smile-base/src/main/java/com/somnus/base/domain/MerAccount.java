package com.somnus.base.domain;

import java.math.BigDecimal;
import java.util.Date;

public class MerAccount extends Entity {
    private Long acctId;

    private String acctCode;

    private String merCode;

    private String acctName;

    private String currency;

    private String bankCode;

    private String bankName;

    private String bankKey;

    private String branchCode;

    private String branchName;

    private String bankAcctNo;

    private String bankAcctName;

    private String stlType;

    private BigDecimal balFloor;

    private Short autoTransfer;

    private BigDecimal minTransfer;

    private String transferPeriod;

    private String isAutoStl;

    private String beginTransfer;

    private Integer transferPriority;

    private String allowIn;

    private String allowOut;

    private String outFlag;

    private String remark;

    private Integer version;

    private String status;

    private String operFlag;

    private String effectDate;

    private String loseEffectDate;

    private String modifyBy;

    private Date modifyTime;

    public Long getAcctId() {
        return acctId;
    }

    public void setAcctId(Long acctId) {
        this.acctId = acctId;
    }

    public String getAcctCode() {
        return acctCode;
    }

    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode == null ? null : acctCode.trim();
    }

    public String getMerCode() {
        return merCode;
    }

    public void setMerCode(String merCode) {
        this.merCode = merCode == null ? null : merCode.trim();
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName == null ? null : acctName.trim();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode == null ? null : bankCode.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankKey() {
        return bankKey;
    }

    public void setBankKey(String bankKey) {
        this.bankKey = bankKey == null ? null : bankKey.trim();
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getBankAcctNo() {
        return bankAcctNo;
    }

    public void setBankAcctNo(String bankAcctNo) {
        this.bankAcctNo = bankAcctNo == null ? null : bankAcctNo.trim();
    }

    public String getBankAcctName() {
        return bankAcctName;
    }

    public void setBankAcctName(String bankAcctName) {
        this.bankAcctName = bankAcctName == null ? null : bankAcctName.trim();
    }

    public String getStlType() {
        return stlType;
    }

    public void setStlType(String stlType) {
        this.stlType = stlType == null ? null : stlType.trim();
    }

    public BigDecimal getBalFloor() {
        return balFloor;
    }

    public void setBalFloor(BigDecimal balFloor) {
        this.balFloor = balFloor;
    }

    public Short getAutoTransfer() {
        return autoTransfer;
    }

    public void setAutoTransfer(Short autoTransfer) {
        this.autoTransfer = autoTransfer;
    }

    public BigDecimal getMinTransfer() {
        return minTransfer;
    }

    public void setMinTransfer(BigDecimal minTransfer) {
        this.minTransfer = minTransfer;
    }

    public String getTransferPeriod() {
        return transferPeriod;
    }

    public void setTransferPeriod(String transferPeriod) {
        this.transferPeriod = transferPeriod == null ? null : transferPeriod.trim();
    }

    public String getIsAutoStl() {
        return isAutoStl;
    }

    public void setIsAutoStl(String isAutoStl) {
        this.isAutoStl = isAutoStl == null ? null : isAutoStl.trim();
    }

    public String getBeginTransfer() {
        return beginTransfer;
    }

    public void setBeginTransfer(String beginTransfer) {
        this.beginTransfer = beginTransfer == null ? null : beginTransfer.trim();
    }

    public Integer getTransferPriority() {
        return transferPriority;
    }

    public void setTransferPriority(Integer transferPriority) {
        this.transferPriority = transferPriority;
    }

    public String getAllowIn() {
        return allowIn;
    }

    public void setAllowIn(String allowIn) {
        this.allowIn = allowIn == null ? null : allowIn.trim();
    }

    public String getAllowOut() {
        return allowOut;
    }

    public void setAllowOut(String allowOut) {
        this.allowOut = allowOut == null ? null : allowOut.trim();
    }

    public String getOutFlag() {
        return outFlag;
    }

    public void setOutFlag(String outFlag) {
        this.outFlag = outFlag == null ? null : outFlag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOperFlag() {
        return operFlag;
    }

    public void setOperFlag(String operFlag) {
        this.operFlag = operFlag == null ? null : operFlag.trim();
    }

    public String getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(String effectDate) {
        this.effectDate = effectDate == null ? null : effectDate.trim();
    }

    public String getLoseEffectDate() {
        return loseEffectDate;
    }

    public void setLoseEffectDate(String loseEffectDate) {
        this.loseEffectDate = loseEffectDate == null ? null : loseEffectDate.trim();
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}