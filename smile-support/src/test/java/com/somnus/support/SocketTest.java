package com.somnus.support;

import org.junit.Test;

import com.somnus.support.holder.ApplicationContextHolder;
import com.somnus.support.util.socket.SocketManager;

public class SocketTest extends AbstractTestSupport {
	@Test
	public void test1(){
		SocketManager manager = (SocketManager)ApplicationContextHolder.getBean(SocketManager.class);
		try {
			StringBuffer xml = new StringBuffer();
			xml.append("<?xml version=\"1.0\" encoding=\"gbk\"?>");
				xml.append("<MsgText>");
					xml.append("<GrpHdr>");
						xml.append("<Version>1.0.0</Version>");
						xml.append("<SysType>7</SysType>");
						xml.append("<TsfStat>9</TsfStat>");
						xml.append("<BusCd>10001</BusCd>");
						xml.append("<TradSrc>P</TradSrc>");
						xml.append("<Sender>");
							xml.append("<InstId>88888888</InstId>");
						xml.append("</Sender>");
						xml.append("<Recver>");
							xml.append("<InstId></InstId>");
						xml.append("</Recver>");
						xml.append("<Date>20100824</Date>");
						xml.append("<Time>161100</Time>");
					xml.append("</GrpHdr>");
					xml.append("<CorpSeq>12345678901234567890</CorpSeq>");
					xml.append("<Dgst>日切通知机构请求报文</Dgst>");
					xml.append("<CorpNDate>20140729</CorpNDate>");	
				xml.append("</MsgText>");	
									
			manager.connect(xml.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
