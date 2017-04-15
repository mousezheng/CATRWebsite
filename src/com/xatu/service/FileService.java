package com.xatu.service;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;

/**
 * �ļ������߼�
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
			System.out.println("��ȡ�ļ�����" + path);
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
	// ��дaccept����,����ָ���ļ��Ƿ�Ӧ�ð�����ĳһ�ļ��б���
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		// ��������ֵ
		// ����ɸѡ����
		// endWith(String str);�ж��Ƿ�����ָ����ʽ��β��
		if (name.toLowerCase().endsWith(".jpg")) {
			// ������trueʱ,��ʾ������ļ���������
			return true;
		} else {
			return false;
		}
		// ���ض���ķ���ֵ

	}
}