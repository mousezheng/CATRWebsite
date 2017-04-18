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
		makeAdd(request,response);
		List<String[]> tempStrs = operation.select(TableInfo.userTableHead, TableInfo.tableName[1]);
		List<User> users = null;
		users = ManagerService.StringToUser(tempStrs);
		session.setAttribute("users", users);
		session.setAttribute("tableHead", TableInfo.userTableHead);
		response.sendRedirect("jsp/manage/part/user.jsp");
	}

	/**
	 * 处理增加操作
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter(TableInfo.userTableHead[0]);
		String userName = request.getParameter(TableInfo.userTableHead[1]);
		String password = request.getParameter(TableInfo.userTableHead[2]);
		String phone = request.getParameter(TableInfo.userTableHead[3]);
		System.out.println(userName);
		System.out.println(id);
		System.out.println(password);
		System.out.println(phone);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
