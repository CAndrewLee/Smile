package com.somnus.support.common;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;

/**
 * 缓存管理器
 * 
 * @author cjliu
 */
public class CacheManagerUtil {

	public static CacheManager cacheManager;
	

	public static CacheManager getEhCacheCacheManager() {
		return cacheManager;
	}

	public static void setEhCacheCacheManager(EhCacheCacheManager ehCacheCacheManager) {
		CacheManagerUtil.cacheManager = ehCacheCacheManager.getCacheManager();
	}

	/**
	 * 从缓存中获取对象
	 * 
	 * @param cache_name
	 * @param key
	 * @return
	 */
	public static Serializable get(String cache_name, Serializable key) {
		Cache cache = getCache(cache_name);
		if (cache != null) {
			Element elem = cache.get(key);
			if (elem != null && !cache.isExpired(elem))
				return (Serializable)elem.getObjectValue();
		}
		return null;
	}

	/**
	 * 把对象放入缓存中
	 * 
	 * @param cache_name
	 * @param key
	 * @param value
	 */
	public synchronized static void put(String cache_name, Serializable key, Serializable value) {
		Cache cache = getCache(cache_name);
		if (cache != null) {
			cache.remove(key);
			Element elem = new Element(key, value);
			cache.put(elem);
		}
	}

	/**
	 * 获取指定名称的缓存
	 * 
	 * @param cache
	 * @return
	 * @throws IllegalStateException
	 */
	public static Cache getCache(String cache) throws IllegalStateException {
		return cacheManager.getCache(cache);
	}
	
	/**
	 * 获取指定名称的cache包装类缓存
	 * 
	 * @param cache
	 * @return
	 * @throws IllegalStateException
	 */
	public static CacheWrapper getCacheWrapper(String cache) throws IllegalStateException {
		return new CacheWrapper(cacheManager.getCache(cache));
	}
	
	/**
	 * 清除指定名称的缓存的所有key
	 * 
	 * @param cache
	 * @return
	 * @throws IllegalStateException
	 */
	public synchronized static void clearCache(String cache) throws IllegalStateException {
		if(cacheManager.cacheExists(cache)){
			cacheManager.getCache(cache).removeAll();
		}
	}
	
	/**
	 * 清除所有缓存的所有key
	 *
	 * @return
	 * @throws IllegalStateException
	 */
	public synchronized static void clearAllCache() throws IllegalStateException {
		for(String cacheName:cacheManager.getCacheNames()){
			cacheManager.getCache(cacheName).removeAll();
		}
	}
	
	

	/**
	 * 获取缓存中的信息
	 * 
	 * @param cache
	 * @param key
	 * @return
	 * @throws IllegalStateException
	 * @throws CacheException
	 */
	public static Element getElement(String cache, Serializable key) throws IllegalStateException, CacheException {
		Cache cCache = getCache(cache);
		return cCache.get(key);
	}
}