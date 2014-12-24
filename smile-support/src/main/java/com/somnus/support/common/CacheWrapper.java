/*
 * Copyright 2010 by IPS. Floor 3,Universal Industrial Building,
 * Tian Yaoqiao Road 1178,Shanghai, P.R. China，200300. All rights reserved.
 *
 * This software is the confidential and proprietary information of IPS
 * ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the terms
 * of the license agreement you entered into with IPS.
 */
package com.somnus.support.common;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import org.apache.commons.lang3.StringUtils;

/**
 * CacheWrapper
 *
 * @author: cjliu
 * @version: 2013-09-25
 */
public class CacheWrapper {

	private  Cache cache;
	
	public CacheWrapper(Cache cache){
		this.cache=cache;
	}

    /**
     * 插入List到缓存
     *
     * @param key
     * @param obj
     */
	public void put(String key, Object obj) {
		if (StringUtils.isEmpty(key) || obj == null) {
			return;
		}
		cache.put(new Element(key, obj));
		
	}

    /**
     * 返回缓存大小
     *
     * @return
     */
	public  int getSize() {
		return cache.getSize();
	}

    /**
     * 根据key查找缓存中数据
     *
     * @param key
     * @return
     */
	public  Object get(String key) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		Element element = cache.get(key);
		return element != null ? (Serializable)element.getObjectValue() : null;
	}

    /**
     * 删除缓存数据
     *
     * @param key
     * @return
     */
	public  boolean remove(String key) {
		if (StringUtils.isEmpty(key)) {
			return false;
		}
		return cache.remove(key);
	}

    /**
     * 删除缓存数据
     *
     * @return
     */
	public  void removeAll() {
		cache.removeAll();
	}

    /**
     * spring注入cache
     *
     * @param cache
     */
	public void setCache(Cache cache) {
		this.cache = cache;
	}
}
