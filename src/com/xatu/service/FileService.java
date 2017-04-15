package com.xatu.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

/**
 * 文件处理逻辑
 * 
 * @author zsl
 *
 */
public class FileService {

	static ServletContext sc;

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

	public static String[] getImageFile(String path) {
		String pathReal = sc.getRealPath(path);
		File[] files = new File(pathReal).listFiles(new fileFilter());
		String[] fileNames = new String[files.length];
		for (int i = 0; i < fileNames.length; i++) {
			fileNames[i] = path+"/" + files[i].getName();
		}
		return fileNames;
	}
}

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