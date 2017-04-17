package com.xatu.servlet.manage.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.User;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.TableInfo;

/**
 * 用户表业务处理
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		// 这些属于私密信息，不允许管理员修改
		// ,"birthday","name","sex","email","address","info","age"

		List<String[]> tempStrs = operation.select(TableInfo.userTableHead, TableInfo.tableName[2]);
		List<User> users = null;
		users = ManagerService.StringToUser(tempStrs);
		session.setAttribute("users", users);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
