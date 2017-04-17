package com.xatu.servlet.page;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.User;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;
import com.xatu.util.Jump;

/**
 * 用户信息业务处理
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserInfoServlet() {
		super();
	}

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
//		// 防止重复加载
//		if (session.getAttribute("user") == null) {
			String[] tableHead = { "id", "user_name", "password", "phone", "name", "sex", "email", "address", "qq_num",
					"photo", "info", "age", "birthday" };
			String tableName = "tb_user";
			String name = "user_name='" + (String) session.getAttribute("username")+"'";
			if (name == null) {
				Jump.jumpToFail(response, "用户名为空,无法查看个人信息,", "用户名为空");
			} else {
				User user = ConversionService.object2User(operation.selectOne(tableHead, tableName, name),
						getServletContext());
				session.setAttribute("user", user);

			}
//		}
		response.sendRedirect("jsp/page/personal_information.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
