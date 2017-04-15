package com.xatu.servlet.page2;

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
 * 修改密码业务处理啊， 根据session获取用户名（如果用户名为空，则返回错误页面） 否则进行重置密码
 */
@WebServlet("/RepasswordServlet")
public class RepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RepasswordServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		DBOperation operation = DBOperation.getMyDB();
		String name = (String) session.getAttribute("username");
		
		if (name == null || name.equals("")) {
			Jump.jumpToFail(response, "用户还未登录无法修改密码，", "修改密码失败");
		} else {
			String password = StringChage.encodingChage(request.getParameter("password"));
			String newPassword = StringChage.encodingChage(request.getParameter("new_password"));
			if (operation.changePassword(name, password, newPassword)) {
				Jump.jumpToSuccess(response, name+"已经成功修改密码，请重新登陆", "改密码成功");
				session.removeAttribute("username");
			}else{
				Jump.jumpToFail(response, "密码输入错误，无法修改，", "修改密码错误");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
