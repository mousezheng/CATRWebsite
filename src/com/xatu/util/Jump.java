package com.xatu.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * 跳转工具类
 * 
 * @author zsl
 *
 */
public class Jump {

	public static void jumpToFail(HttpServletResponse response, String masssage, String pagename)
			throws UnsupportedEncodingException, IOException {
		response.sendRedirect("jsp/page2/failure.jsp?pagename=" + URLEncoder.encode(pagename, "utf-8") + "&massage="
				+ URLEncoder.encode(masssage, "utf-8"));
	}

	public static void jump(String url,HttpServletResponse response) throws IOException{
		response.sendRedirect(url);
	}
	
	public static void jumpToSuccess(HttpServletResponse response, String masssage, String pagename)
			throws UnsupportedEncodingException, IOException {
		response.sendRedirect("jsp/page2/success.jsp?pagename=" + URLEncoder.encode(pagename, "utf-8") + "&massage="
				+ URLEncoder.encode(masssage, "utf-8"));
	}
}
