package com.xatu.servlet.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.util.Jump;
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
		String info[] = { getString("name"), getValue("sex"), getString("age"), getString("address"),
				getString("phone"),
				(getString("year").equals("null") || getString("month").equals("null")) ? "null"
						: getString("year") + "年" + getString("month") + "月",
				getString("email").equals("null") ? "null" : getString("email") + getString("selector"),
				getString("info"), };
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String tableName = "tb_user";
		String whereStr = "id='"+id+"'";
		String tableHead[] = {"name","sex","age","address","phone","birthday","email","info"};
		if (operation.updateTable(tableName,tableHead,info,whereStr)) {
			response.sendRedirect("UserInfoServlet");
		}else{
			Jump.jumpToFail(response, "修改失败，请重试，", "修改失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String getString(String input) {
		return StringChage.encodingChage(request.getParameter(input) == null||request.getParameter(input).equals("") ? "null" : request.getParameter(input));
	}

	private String getValue(String input) {
		return StringChage.encodingChage(request.getParameterValues(input)[0]);
	}
}
