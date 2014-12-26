package com.somnus.base.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.somnus.base.component.cache.MerAccountCache;
import com.somnus.base.dao.MerAccountDao;
import com.somnus.base.dao.TrnTransactionDao;
import com.somnus.base.domain.MerAccount;
import com.somnus.base.domain.TrnTransaction;
import com.somnus.base.service.BasBizService;
import com.somnus.support.common.MsgCodeList;
import com.somnus.support.exceptions.BizException;
import com.somnus.support.util.JsonUtils;

@Service
public class BasBizServiceImpl implements BasBizService {

    private final Logger          log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessageSourceAccessor msa;
    @Autowired
    private TrnTransactionDao     trnTransactionDao;
    @Autowired
    private MerAccountCache       merAccountCache;
    @Autowired
    private MerAccountDao         merAccountDao;

    @Override
    @Transactional
    public void insertTran(TrnTransaction trnTransaction) {
        trnTransactionDao.insert(trnTransaction);
    }

    @Override
    @Transactional
    public void insertTranNoSerq(TrnTransaction trnTransaction) {
    	log.info("插入TrnTransaction记录：{}",JsonUtils.toString(trnTransaction));
        trnTransactionDao.insertNoSerq(trnTransaction);
    }


    @Override
    public TrnTransaction selectByAppTranNo(String appTranNo) {
        return trnTransactionDao.selectByAppTranNo(appTranNo);
    }

    @Override
    public TrnTransaction selectSuccessTranByAppTranNo(String appTranNo) {
        return trnTransactionDao.selectSuccessTranByAppTranNo(appTranNo);
    }



    @Override
    public MerAccount getMerAccountNoCache(String merCode, String acctCode) {
        MerAccount merAccount = new MerAccount();
        merAccount.setMerCode(merCode);
        merAccount.setAcctCode(acctCode);
        return merAccountDao.selectByConstraints(merAccount);
    }
    /**
	 * 查询出所有协议出款的商户信息
	 * @return
	 */
    public List<MerAccount> selectAllProtocolDrawAccounts(){
    	return merAccountDao.selectAllProtocolDrawAccounts();
    }

    @Override
    public MerAccount getMerAccount(String merCode, String acctCode) {
        MerAccount merAccount = new MerAccount();
        merAccount.setMerCode(merCode);
        merAccount.setAcctCode(acctCode);
        return merAccountCache.selectByConstraints(merAccount);
    }

    /**
     * 验证商户是否存在
     * @param merCode
     * @param merAccCode
     * @return
     */
    @Override
    public boolean checkMerAccountIsExist(String merCode, String merAccCode) {
        MerAccount merAccount = getMerAccountNoCache(merCode, merAccCode);
        if (merAccount == null) {//商户不存在
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getAccTranNo() {
        // 设置记账流水
        return trnTransactionDao.getAccTranNo();
    }

    @Override
    public void accountExists(String merAccCode) {
        List<MerAccount> accountList = merAccountCache.selectByAcctcode(merAccCode);
        if (accountList == null || accountList.isEmpty()) {
            log.error("thirdmerAccCode:{}", new Object[] { merAccCode });
            throw new BizException(msa.getMessage(MsgCodeList.ERROR_302001,
                new Object[] { merAccCode + "商户账户信息" }));
        }
    }

    @Override
    public TrnTransaction selectByOriAppTranNoAndTranCode(String oriAppTranNo, String tranCode) {
        return trnTransactionDao.selectByOrgAppTranNoAndTranCode( oriAppTranNo,  tranCode);
    }
}
