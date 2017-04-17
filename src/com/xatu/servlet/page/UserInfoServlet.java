package com.xatu.servlet.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Message;
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
		// // 防止重复加载
		// if (session.getAttribute("user") == null) {
		String[] tableHead = { "id", "user_name", "password", "phone", "name", "sex", "email", "address", "qq_num",
				"photo", "info", "age", "birthday" };
		String tableName = "tb_user";
		String name = "user_name='" + (String) session.getAttribute("username") + "'";
		if (name == null) {
			Jump.jumpToFail(response, "用户名为空,无法查看个人信息,", "用户名为空");
		} else {
			User user = ConversionService.object2User(operation.selectOne(tableHead, tableName, name),
					getServletContext());
			session.setAttribute("user", user);
			String[] tableHead1 = { "tb_message.id", "tb_user.user_name", "content", "agree_num", "disagree_num",
					"time", "tb_message.address", "tb_message.user_id" };
			String tableName1 = "tb_message";
			List<Message> messages = ConversionService.object2Message(operation.selectWhere(tableHead1, tableName1,
					"tb_user", "tb_user.id=tb_message.user_id  and tb_user.id='"+(String) session.getAttribute("id")+"'  order by tb_message.id"), getServletContext());
			session.setAttribute("messageList", messages);
		}
		// }
		response.sendRedirect("jsp/page/personal_information.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
