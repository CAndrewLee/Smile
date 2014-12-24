package com.somnus.support.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.compress.archivers.ArchiveException;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 压缩/解压缩工具类
 * @author caobin
 * @date 2013-5-22
 * @version 1.0
 */
public class CompressUtil {
	
	private final static Logger LOG = LoggerFactory.getLogger(CompressUtil.class);
	
	/**
	 * @Description 解压文件(tar.gz)到当前目录
	 * @param sourceFile 指定解压文件
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 * @throws ArchiveException
	 * @author caobin
	 */
	public static void unTargzFile(File sourceFile) throws FileNotFoundException, IOException, ArchiveException{
		unTargzFile(sourceFile, null);
	}
	
	/**
	 * @Description 解压文件(tar.gz)到指定目录
	 * @param sourceFile  指定解压文件
	 * @param targetDir 目标目录(null为当前目录)
	 * @author caobin
	 * @throws java.io.IOException
	 * @throws java.io.FileNotFoundException
	 * @throws ArchiveException 
	 */
	public static void unTargzFile(File sourceFile, File targetDir) throws FileNotFoundException, IOException, ArchiveException{
		Validate.notNull(sourceFile, "source file is required.");
		Validate.isTrue(sourceFile.isFile(), "source File [%s] is not a valid file.", sourceFile);
		GZIPInputStream gzipis = new GZIPInputStream(new BufferedInputStream(new FileInputStream(sourceFile)));
		ArchiveInputStream ais = new ArchiveStreamFactory().createArchiveInputStream("tar", gzipis);
		BufferedInputStream bis = new BufferedInputStream(ais);
		TarArchiveEntry entry = null;
		BufferedOutputStream bos = null;
		while((entry = (TarArchiveEntry)ais.getNextEntry()) != null){
			String dir = null;
			if(targetDir == null){
				dir = sourceFile.getParent();
			}else{
				targetDir.mkdirs();
				dir = targetDir.getAbsolutePath();
			}
			if(!StringUtils.endsWith("dir", "/") && !StringUtils.endsWith("dir", "\\")){
				dir += "/";
			}
			LOG.debug("uncompressing file to: {}", new Object[]{dir + entry.getName()});
			File newFile = new File(dir.concat(entry.getName()));
			if(!newFile.getParentFile().exists()){
				boolean dirCreated = newFile.getParentFile().mkdirs();
				if(!dirCreated){throw new IOException("create directory failed.");}
			}
			boolean fileCreated = newFile.createNewFile();
			if(!fileCreated){throw new IOException("create file failed.");}
			try{
				bos = new BufferedOutputStream(new FileOutputStream(newFile));
				IOUtils.copy(bis, bos);
			}finally{
				IOUtils.closeQuietly(bos);
			}
		}
		IOUtils.closeQuietly(bis);
	}
	
	/**
	 * @Description 将指定文件打为tar.gz包
	 * @param sourceFiles 指定打包文件
	 * @param targetFile 目标文件(.tar,压缩后即为.tar.gz)
	 * @throws Throwable
	 * @author caobin
	 */
	public static void targzFiles(File[] sourceFiles, File targetFile) throws Throwable{
		tarFiles(sourceFiles, targetFile, "UTF-8");
		gzip(targetFile, true);
	}
	
	/**
	 * @Description 将指定目录打为tar.gz包
	 * @param sourceDir 指定打包目录
	 * @param targetFile 目标文件(.tar,压缩后即为.tar.gz)
	 * @throws Throwable
	 * @author caobin
	 */
	public static void targzDir(File sourceDir, File targetFile) throws Throwable{
		tarDir(sourceDir, targetFile, null, "UTF-8");
		gzip(targetFile, true);
	}


	/**
	 * @Description 将指定目录打为tar包
	 * @param sourceDir 指定打包目录
	 * @param targetFile 目标文件
	 * @param tarDir 包中目录(为null责不建立目录)
	 * @param encoding 编码
	 * @author caobin
	 * @throws java.io.IOException
	 */
	public static void tarDir(File sourceDir, File targetFile, String tarDir, String encoding) throws IOException{
		//validate
		Validate.notNull(sourceDir, "source directory is required.");
		Validate.isTrue(sourceDir.isDirectory(), "source directory [%s] is not a valid directory.", sourceDir);
		Validate.notNull(targetFile, "target file is required.");
		Validate.notNull(encoding, "encoding is required.");
		TarArchiveOutputStream taos = new TarArchiveOutputStream (new BufferedOutputStream(new FileOutputStream(targetFile)), encoding);
		try{
			if(StringUtils.isNotEmpty(tarDir)){
				tarDir += File.separator;
			}	
			tar(taos, sourceDir, tarDir);
		}finally{
			IOUtils.closeQuietly(taos);
		}	
	}
	
	/**
	 * @Description 将指定文件打为tar包
	 * @param sourceFiles 指定打包文件
	 * @param targetFile 目标文件
	 * @param encoding 编码
	 * @throws java.io.IOException
	 * @author caobin
	 */
	public static void tarFiles(File[] sourceFiles, File targetFile, String encoding) throws IOException{
		Validate.notNull(targetFile, "target file is required.");
		Validate.notNull(encoding, "encoding is required.");
		if(sourceFiles == null || sourceFiles.length < 1)return;
		TarArchiveOutputStream taos = new TarArchiveOutputStream (new BufferedOutputStream(new FileOutputStream(targetFile)), encoding);
		try{			
			for(File sourceFile : sourceFiles){
				Validate.notNull(sourceFile, "source file is required.");
				Validate.isTrue(sourceFile.isFile(), "source file [%s] is not a valid file.", sourceFile);
				TarArchiveEntry entry = new TarArchiveEntry(sourceFile.getName());
				entry.setSize(sourceFile.length());
				taos.putArchiveEntry(entry);
				IOUtils.copy(new FileInputStream(sourceFile), taos);
				taos.closeArchiveEntry();	
			}
		}finally{
			IOUtils.closeQuietly(taos);
		}
		
		
		
	}
	
	/**
	 * @Description 目录/文件打包
	 * @param taos
	 * @param dir
	 * @param tarDir
	 * @throws java.io.IOException
	 * @author caobin
	 */
	private static void tar(TarArchiveOutputStream taos, File dir, String tarDir) throws IOException{
		File[] files = dir.listFiles();
		if(files == null || files.length < 1)return;
		for(File file : files){
			if(file.isDirectory()){
				tar(taos, file, StringUtils.defaultString(tarDir).concat(file.getName()).concat(File.separator));
			}else{
				TarArchiveEntry entry = new TarArchiveEntry(StringUtils.defaultString(tarDir).concat(file.getName()));
				entry.setSize(file.length());
				taos.putArchiveEntry(entry);
				IOUtils.copy(new FileInputStream(file), taos);
				taos.closeArchiveEntry();
			}
		}	
	}
	
	/**
	 * @Description gzip压缩指定文件
	 * @param deleteSourceFile 是否删除
	 * @param sourceFile 源文件
	 * @author caobin
	 * @throws Throwable 
	 */
	public static void gzip(File sourceFile, boolean deleteSourceFile) throws Throwable{
		//validate
		Validate.notNull(sourceFile, "source file is required.");
		Validate.isTrue(sourceFile.isFile(), "source file [%s] is not a valid file.", sourceFile);
		
		File targetFile = new File(sourceFile.getAbsolutePath().concat(".gz"));
		InputStream is = new FileInputStream(sourceFile);
		GZIPOutputStream gzipos = new GZIPOutputStream(new FileOutputStream(targetFile));
		try{
			byte[] bArr = new byte[1024];
			int number = -1;
			while((number = is.read(bArr, 0, bArr.length)) != -1){
				gzipos.write(bArr, 0, number);
			}			
		}catch(Throwable t){
			deleteSourceFile = false;
			throw t;
		}finally{
			IOUtils.closeQuietly(is);
			IOUtils.closeQuietly(gzipos);
			if(deleteSourceFile){
				if(sourceFile.canWrite()){
					boolean r = sourceFile.delete();
					if(!r){
						throw new IOException(String.format("delete file [%s] failed.", sourceFile.getAbsolutePath()));
					}
				}else{
					throw new IOException(String.format("file [%s] cannot be written.", sourceFile.getAbsolutePath()));
				}
			}	
		}	
	}
	
	
	/**
	 * @Description gunzip解压缩指定文件
	 * @param sourceFile 源文件
	 * @param deleteSourceFile 是否删除
	 * @throws Throwable
	 * @author caobin
	 */
	public static void gunzip(File sourceFile, boolean deleteSourceFile) throws Throwable{
		Validate.notNull(sourceFile, "source file is required.");
		Validate.isTrue(sourceFile.isFile(), "source File [%s] is not a valid file.", sourceFile);
		GZIPInputStream gzipis = null;
		BufferedOutputStream bos = null;
		try{
			gzipis = new GZIPInputStream(new BufferedInputStream(new FileInputStream(sourceFile)));
			bos = new BufferedOutputStream(new FileOutputStream(new File(sourceFile.getAbsolutePath().replaceAll("\\.gz$", ""))));
			IOUtils.copy(gzipis, bos);
		}catch(Throwable t){
			deleteSourceFile = false;
			throw t;
		}finally{
			IOUtils.closeQuietly(gzipis);
			IOUtils.closeQuietly(bos);
			if(deleteSourceFile){
				if(sourceFile.canWrite()){
					boolean r = sourceFile.delete();
					if(!r){
						throw new IOException(String.format("delete file [%s] failed.", sourceFile.getAbsolutePath()));
					}
				}else{
					throw new IOException(String.format("file [%s] cannot be written.", sourceFile.getAbsolutePath()));
				}
			}	
		}
	}
	
	public static void main(String[] args) throws Throwable{
		//gunzip(new File("c:/CreateMchtAccIn_20130521.txt.gz"), false);
		gzip(new File("c:/CreateMchtAccIn_20130521.txt"), false);
	}
}
