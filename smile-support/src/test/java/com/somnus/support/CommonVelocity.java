package com.somnus.support;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.somnus.support.domain.User;
import com.somnus.support.util.velocity.VelocityUtils;

@Component
public class CommonVelocity {
	@Autowired
	private VelocityEngine velocityEngine;
	
	public void createvelocityFile(){
		List<User> list = new ArrayList<User>();
		for(int i=1;i<=100;i++){
			User user = new User();
			user.setId(i);
			user.setUsername("username"+i);
			user.setPassword("password"+i);
			list.add(user);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		VelocityUtils.mergeTemplate(velocityEngine, "META-INF/template/vm/velocity.vm" , map, output, "GBK");
		try {
			OutputStream os = new FileOutputStream("E://velocity");
			BufferedOutputStream bos = new BufferedOutputStream(os);
			bos.write(output.toByteArray());
			bos.close();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
