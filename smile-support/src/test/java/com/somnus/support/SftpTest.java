package com.somnus.support;

import org.junit.Test;

import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.sftp.SftpManager;


public class SftpTest extends AbstractTestSupport {
	@Test
	public void test1(){
		SftpManager manager = (SftpManager)ApplicationContextHolder.getBean(SftpManager.class);
		try {
			manager.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
