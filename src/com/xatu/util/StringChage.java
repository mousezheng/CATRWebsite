package com.xatu.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 字符串转换工具类
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
			System.out.println("数据转换错误");
		}
		return str;
	}

	public static String urlEncoding(String str) {
		try {
			return URLEncoder.encode(str, "utf-8");
		} catch (UnsupportedEncodingException e) {
			System.out.println("URL转码失败");
			e.printStackTrace();
		}
		return str;
	}
}
