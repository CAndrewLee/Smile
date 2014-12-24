package com.somnus.base.component.cache;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.somnus.base.common.CacheConstants;
import com.somnus.base.dao.MerAccountDao;
import com.somnus.base.domain.MerAccount;

@Component
public class MerAccountCache {

    @Autowired
    private MerAccountDao merAccountDao;

    @Cacheable(value = CacheConstants.CACHE_MERACCOUNT, key = "#p0.merCode+'|'+#p0.acctCode")
    public MerAccount selectByConstraints(MerAccount meraccount){
        return merAccountDao.selectByConstraints(meraccount);
    }
    @Cacheable(value = CacheConstants.CACHE_MERACCOUNT, key = "#p0")
	public List<MerAccount> selectByAcctcode(String merAccCode) {
		return merAccountDao.selectByAcctcode(merAccCode);
	}

}
