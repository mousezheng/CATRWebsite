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
 * �ļ������߼�
 * 
 * @author zsl
 *
 */
public class FileService {

	static ServletContext sc;

	/**
	 * �ļ�ת���������ļ�ת��Ϊ�ַ���
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
			System.out.println("��ȡ�ļ�����" + path);
			e.printStackTrace();
		}
		return filtStr;
	}

	/**
	 * ��ȡ�ļ� path�ļ��µ�ͼƬ
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
	 * �ϴ� FileItemp�ļ���pathĿ¼
	 * @param item
	 * @param path
	 * @return
	 */
	public static boolean uploadFile(FileItem item, String path) {
		/**
		 * ������������Ҫ��ȡ �ϴ��ļ�������
		 */
		// ��ȡ·����
		String value = item.getName();
		// ���������һ����б��
		int start = value.lastIndexOf("\\");
		// ��ȡ �ϴ��ļ��� �ַ������֣���1�� ȥ����б�ܣ�
		String filename = value.substring(start + 1);
		// request.setAttribute(name, filename);
		// ����д��������
		// ���׳����쳣 ��exception ��׽
		// item.write( new File(path,filename) );//�������ṩ��
		// �ֶ�д��
		OutputStream out;
		try {
			out = new FileOutputStream(new File(path, filename));

			InputStream in = item.getInputStream();

			int length = 0;
			byte[] buf = new byte[1024];
			System.out.println("��ȡ�ϴ��ļ����ܹ���������" + item.getSize());
			// in.read(buf) ÿ�ζ��������ݴ���� buf ������
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
	 * ����һ���ļ��У�destDirName
	 * @param destDirName
	 * @return
	 */
	public static boolean createDir(String destDirName) {
		File dir = new File(destDirName);
		if (dir.exists()) {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�Ŀ��Ŀ¼�Ѿ�����");
			return false;
		}
		if (!destDirName.endsWith(File.separator)) {
			destDirName = destDirName + File.separator;
		}
		// ����Ŀ¼
		if (dir.mkdirs()) {
			System.out.println("����Ŀ¼" + destDirName + "�ɹ���");
			return true;
		} else {
			System.out.println("����Ŀ¼" + destDirName + "ʧ�ܣ�");
			return false;
		}
	}
}

/**
 * �ļ�������
 * @author zsl
 *
 */
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