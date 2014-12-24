package com.somnus.support.util.socket;

import java.io.InputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * 对数据进行签名、验签
 * 2014-7-28
 */
@Component
public class DigitSignature {
	private final static Logger log = LoggerFactory.getLogger(DigitSignature.class);
	private final static String PUBLIC_KEY = "license/public_connect.cer";
	private final static String PRIVATE_KEY = "license/private_connect.key";
	
	@Value("${somnus.signature.keyAlgorithm}")
	private String keyAlgorithm ;//秘钥生成算法
	
	@Value("${somnus.signature.signAlgorithm}")
	private String signAlgorithm ;//签名生成算法
	
	@Value("${somnus.signature.signLength}")
	private int signLength ;//数字签名的长度,单位是：byte
	
	/**
	 * 验证签名
	 * @param data 含有签名的消息体
	 * @return 验签是否成功
	 * @throws Exception
	 */
	public boolean validate(byte[] data) throws Exception {
		try {
			int begin= data.length - signLength;
			byte[] signArr= new byte[signLength];
			byte[] msgArr= new byte[begin];
			System.arraycopy(data, begin, signArr, 0, signLength);
			System.arraycopy(data, 0, msgArr, 0, begin);
			
			PublicKey publicKey = GeneratePublicKey();
			Signature sig = Signature.getInstance(signAlgorithm);
			sig.initVerify(publicKey);
			sig.update(msgArr);
			return sig.verify(signArr);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw e;
		}
	}

	/**
	 * 生成签名
	 * @param data 对该数据进行签名
	 * @return 签名
	 */
	public byte[] genValiInfo(byte[] data) {
		try {
			PrivateKey privateKey = GeneratePrivateKey();
			Signature sig = Signature.getInstance(signAlgorithm);
			sig.initSign(privateKey);
			sig.update(data);
			return sig.sign();
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}

		return null;
	}

	/**
	 * 生成公钥
	 * @return 公钥
	 * @throws Exception
	 */
	public PublicKey GeneratePublicKey() throws Exception {
		InputStream input = getClass().getClassLoader().getResourceAsStream(PUBLIC_KEY);
			byte[] encodedpubkey = new byte[input.available()];
			input.read(encodedpubkey);
			input.close();
			X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(
					encodedpubkey);
			KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
			PublicKey pubKey = keyFactory.generatePublic(pubKeySpec);
			return pubKey;
		
	}
	/**
	 * 生成私钥
	 * @return 私钥
	 * @throws Exception
	 */
	public PrivateKey GeneratePrivateKey() throws Exception {
		
			InputStream input = getClass().getClassLoader().getResourceAsStream(PRIVATE_KEY);
			byte[] encodedprikey = new byte[input.available()];
			input.read(encodedprikey);
			input.close();
			PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(
					encodedprikey);
			KeyFactory keyFactory = KeyFactory.getInstance(keyAlgorithm);
			PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);
			return priKey;
		
	}



	public String getKeyAlgorithm() {
		return keyAlgorithm;
	}



	public String getSignAlgorithm() {
		return signAlgorithm;
	}



	public int getSignLength() {
		return signLength;
	}

	
	
}