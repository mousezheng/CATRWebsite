package com.xatu.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FileUtils;

/**
 * 文件处理逻辑
 * 
 * @author zsl
 *
 */
public class FileService {

	static ServletContext sc;

	/**
	 * 文件转化器，将文件转换为字符串
	 * @param path
	 * @param sc
	 * @return
	 */
	public static String fileToString(String path, ServletContext sc) {
		FileService.sc = sc;
		path = sc.getRealPath(path);
		String filtStr = null;
		try {
			filtStr = FileUtils.readFileToString(new File(path));
		} catch (IOException e) {
			System.out.println("读取文件错误：" + path);
			e.printStackTrace();
		}
		return filtStr;
	}

	/**
	 * 获取文件 path文件下的图片
	 * @param path
	 * @param sc
	 * @return
	 */
	public static String[] getImageFile(String path, ServletContext sc) {
		FileService.sc = sc;
		String pathReal = sc.getRealPath(path);
		File[] files = new File(pathReal).listFiles(new fileFilter());
		String[] fileNames = new String[files.length];
		for (int i = 0; i < fileNames.length; i++) {
			fileNames[i] = path + "/" + files[i].getName();
		}
		return fileNames;
	}

	/**
	 * 上传 FileItemp文件到path目录
	 * @param item
	 * @param path
	 * @return
	 */
	public static boolean uploadFile(FileItem item, String path) {
		/**
		 * 以下三步，主要获取 上传文件的名字
		 */
		// 获取路径名
		String value = item.getName();
		// 索引到最后一个反斜杠
		int start = value.lastIndexOf("\\");
		// 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
		String filename = value.substring(start + 1);
		// request.setAttribute(name, filename);
		// 真正写到磁盘上
		// 它抛出的异常 用exception 捕捉
		// item.write( new File(path,filename) );//第三方提供的
		// 手动写的
		OutputStream out;
		try {
			out = new FileOutputStream(new File(path, filename));

			InputStream in = item.getInputStream();

			int length = 0;
			byte[] buf = new byte[1024];
			System.out.println("获取上传文件的总共的容量：" + item.getSize());
			// in.read(buf) 每次读到的数据存放在 buf 数组中
			while ((length = in.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
			in.close();
			out.close();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 创建一个文件夹，destDirName
	 * @param destDirName
	 * @return
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// 创建目录
		if (dir.mkdirs()) {
			System.out.println("创建目录" + destDirName + "成功！");
			return true;
		} else {
			System.out.println("创建目录" + destDirName + "失败！");
			return false;
		}
	}
}

/**
 * 文件过滤器
 * @author zsl
 *
 */
class fileFilter implements FilenameFilter {
	@Override
	// 重写accept方法,测试指定文件是否应该包含在某一文件列表中
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		// 创建返回值
		// 定义筛选条件
		// endWith(String str);判断是否是以指定格式结尾的
		if (name.toLowerCase().endsWith(".jpg")) {
			// 当返回true时,表示传入的文件满足条件
			return true;
		} else {
			return false;
		}
		// 返回定义的返回值

	}
}