package com.xatu.servlet.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.util.StringChage;

/**
 * 个人信息修改业务
 */
@WebServlet("/ChangeInfo")
public class ChangeInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpServletRequest request;

	public ChangeInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.request = request;
		String info[] = { getString("name"), getValue("sex"), getString("age"), getString("address"), getString("phone"),
				getString("year")+"年"+getString("month")+"月", getString("email")+getString("selector"), getString("info"), };
		for (int i = 0; i < info.length; i++) {
			System.out.println(info[i]);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getString(String input) {
		return StringChage.encodingChage(request.getParameter(input));
	}
	private String getValue(String input){
		return StringChage.encodingChage(request.getParameterValues(input)[0]);
	}
}





