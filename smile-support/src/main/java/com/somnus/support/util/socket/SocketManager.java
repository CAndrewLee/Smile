package com.somnus.support.util.socket;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class SocketManager {
	@Value("${somnus.socket.socketIP}")
	private String socketIP;

	@Value("${somnus.socket.socketPort}")
	private int socketPort;
	
	@Autowired
	private DigitSignature digitSignature;
	
	private final static Logger log = LoggerFactory.getLogger(SocketManager.class);
	
	public void connect(String xmlString) throws Exception{
		Socket socket = null;
		DataOutputStream output= null;
		DataInputStream input= null;
		try {
			socket = new Socket(socketIP, socketPort);
			output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			log.info("socket链接," + socketIP+ ":" + socketPort);
		} catch (Exception e) {
			log.error("创建连接失败：" + e.getMessage(), e);
			throw e;
		}
		log.info("socket连接成功");
		byte[] sendArr = xmlString.getBytes("GBK");// 将字符串编码成gbk字节码
		byte[] receiveArr = null;
		// 这只是xml数据。还要加上签名
		byte[] signArr = digitSignature.genValiInfo(sendArr);
		log.info("数字签名成功");
		int len = 0;// 接收报文长度
		try {
			output.writeInt(sendArr.length + signArr.length);// 消息体长度,等于xml长度加签名长度
			
			log.info("发送报文xml：" + new String(sendArr,"GBK"));
			output.write(sendArr);// 发送xml数据
			
			log.info("发送签名xml：" + new String(signArr,"GBK"));
			output.write(signArr);// 发送签名
			
			output.flush();
			log.info("我方报文发送完毕。");
			
			log.info("开始读取返回结果。");
			len = input.readInt();
			log.info("应答报文长度：" + len);
			
			receiveArr = new byte[len];// 返回报文
			
			input.read(receiveArr);
			
		} catch (Exception e) {
			log.error("对方socket异常结束");
			throw e;
		} finally {
			output.close();
			input.close();
			socket.close();
		}
		// 解析xml报文
		byte[] xmlArr = new byte[len - digitSignature.getSignLength()];
		System.arraycopy(receiveArr, 0, xmlArr, 0, xmlArr.length);
		String xmlStr = new String(xmlArr, "GBK");
		log.info("收到报文xml：" + xmlStr);

		// 验证签名
		log.info("开始验证签名");
		boolean signSucc = digitSignature.validate(receiveArr);
		if (!signSucc) {
			throw new Exception("工行报文，签名验证不通过！");
		} else {
			log.info("验证签名通过！");
		}

		Document receiveDoc = DocumentHelper.parseText(xmlStr);
		char tsfStat = receiveDoc.selectSingleNode("/MsgText/GrpHdr/TsfStat").getText().charAt(0);
		char transFlag = receiveDoc.selectSingleNode("/MsgText/Rst/TransFlag").getText().charAt(0);
		String code = receiveDoc.selectSingleNode("/MsgText/Rst/Code").getText();
		String info = receiveDoc.selectSingleNode("/MsgText/Rst/Info").getText();
		
		log.info(tsfStat+"|"+transFlag+"|"+code+"|"+info);
	}
}
