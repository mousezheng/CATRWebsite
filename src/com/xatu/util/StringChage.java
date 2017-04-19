package com.xatu.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * �ַ���ת��������
 * 
 * @author zsl
 *
 */
public class StringChage {

	public static String encodingChage(String str) {
		try {
			if (str == null) {
				return "";
			}
			return new String(str.getBytes("ISO-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("����ת������");
		}
		return str;
	}

	public static String urlEncoding(String str) {
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("URLת��ʧ��");
			e.printStackTrace();
		}
		return str;
	}
}
