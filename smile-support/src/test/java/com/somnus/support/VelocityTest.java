package com.somnus.support;

import org.junit.Test;

import com.somnus.support.holder.ApplicationContextHolder;

public class VelocityTest extends AbstractTestSupport {
	@Test
	public void testVelocity(){
		CommonVelocity temp = (CommonVelocity)ApplicationContextHolder.getBean(CommonVelocity.class);
		try {
			temp.createvelocityFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
