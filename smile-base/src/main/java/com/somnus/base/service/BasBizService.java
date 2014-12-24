package com.somnus.base.service;

import java.util.List;

import com.somnus.base.domain.MerAccount;
import com.somnus.base.domain.TrnTransaction;

public interface BasBizService {
    public void insertTran(TrnTransaction trnTransaction);

    public void insertTranNoSerq(TrnTransaction trnTransaction);

    public TrnTransaction selectByAppTranNo(String appTranNo);

    public TrnTransaction selectSuccessTranByAppTranNo(String appTranNo);


    public MerAccount getMerAccountNoCache(String merCode, String acctCode);

    public MerAccount getMerAccount(String merCode, String acctCode);

    /**
     * 验证商户是否存在
     * @param merCode
     * @param merAccCode
     * @return
     */
    public boolean checkMerAccountIsExist(String merCode, String merAccCode);

    public String getAccTranNo();

    public void accountExists(String merAccCode);

    public TrnTransaction selectByOriAppTranNoAndTranCode(String oriAppTranNo, String tranCode);

    public List<MerAccount> selectAllProtocolDrawAccounts();
}
