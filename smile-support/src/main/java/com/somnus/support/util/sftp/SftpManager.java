package com.somnus.support.util.sftp;

import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPOutputStream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SftpManager {
	@Value("${somnus.sftp.username}")
	private String username; // FTP 登录用户名

	@Value("${somnus.sftp.password}")
	private String password = null; // FTP 登录密码

	@Value("${somnus.sftp.host}")
	private String host; // FTP 服务器地址IP地址

	@Value("${somnus.sftp.port}")
	private int port; // FTP 端口

	@Value("${somnus.sftp.destPath}")
	private String destPath;// ftp端文件上传路径

	private SFTPUtil sfputil;

	public void connect() throws Exception {
		if (sfputil == null) {
			sfputil = new SFTPUtil(username, password, host, port);// 用密码联接
		}
		sfputil.connect();
	}

	public void disConnect() {
		if (sfputil != null) {
			sfputil.disconnect();
		}
	}

	/**
	 * 将byte[]，采用gzip压缩后，上传到sftp。自动给文件名加上.gz <br>
	 * 例如文件名STL01_20131227 , 压缩并上传后,名称为STL01_20131227.gz
	 * 
	 * @param childDir
	 *            如果要上传到指定的子目录，此处填子目录名，例如“20140730”。如果不需要传到子目录，此处填null
	 * @param sftpFileName
	 *            文件名
	 * @param byteArr
	 *            待上传的字节数组
	 * @throws Exception
	 * @see gzip压缩: http://snowolf.iteye.com/blog/643010
	 */
	public void upload(String childDir, String sftpFileName, byte[] byteArr) throws Exception {
		// 用gzip方式压缩
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		GZIPOutputStream gos = new GZIPOutputStream(baos);

		gos.write(byteArr, 0, byteArr.length);
		gos.finish();
		gos.flush();
		gos.close();
		byte[] ByteArr_gz = baos.toByteArray();
		// 设置文件名。如果文件名后缀不是".gz",就加上".gz"
		String sftpFileName_gz;
		if (sftpFileName.lastIndexOf(".gz") != sftpFileName.length() - 3) {
			sftpFileName_gz = sftpFileName + ".gz";
		} else {
			sftpFileName_gz = sftpFileName;
		}
		String path;
		if (childDir != null) {
			path = destPath + "/" + childDir;
		} else {
			path = destPath;
		}
		sfputil.upload(path, sftpFileName_gz, ByteArr_gz);
	}

}