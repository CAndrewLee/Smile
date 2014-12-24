package com.somnus.base.dao;

import java.util.List;

import com.somnus.base.domain.MerAccount;
import com.somnus.support.mybatis.annotation.MyBatisRepository;


/**
 * 交易账户DAO
 * @author bo.zhang
 *
 */
@MyBatisRepository
public interface MerAccountDao {
	
	/**
	 * 根据商户号和交易商户号查询交易账户
	 * */
	MerAccount selectByConstraints(MerAccount meraccount);
	
	/**
	 * 得到主键
	 * @return
	 */
	String getMeraccSequences();
	
	/**
	 * 新增交易账户
	 * @param meraccount
	 */
	void insert(MerAccount meraccount);
	
	/**
	 * 更新交易账户
	 * @param meraccount
	 */
	void updateByPrimaryKeySelective(MerAccount meraccount);
	
	/**
	 * 根据交易账户号查询交易账户
	 * @param acctCode
	 * @return
	 */
	List<MerAccount> selectByAcctcode(String acctCode);
	/**
	 * 查询出所有协议出款的商户信息
	 * @return
	 */
	List<MerAccount> selectAllProtocolDrawAccounts();

	void merge(MerAccount merAccount);
	
	/**
	 * 根据主键删除数据
	 * @param acctId
	 */
	void deleteByPrimaryKey(Long acctId);

}
