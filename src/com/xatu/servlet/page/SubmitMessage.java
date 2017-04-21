package com.xatu.servlet.page;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.util.Jump;

/**
 * 提交留言处理页面
 */
@WebServlet("/SubmitMessage")
public class SubmitMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubmitMessage() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");

		DBOperation operation = DBOperation.getMyDB();
		if (name == null || name.equals("")) {
			Jump.jumpToFail(response, "用户还未登录无法留言，", "无法提交留言，请先登录");
		} else {
			String message = request.getParameter("message");
			System.out.println(message);
			SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");// 设置日期格式
			String time = df.format(new Date());// new Date()为获取当前系统时间
			String id = operation.getIdString("tb_user", "user_name", "id", name);
			String strs[] = { "null", "'" + id + "'", "'" + message + "'", "'" + "0" + "'", "'" + "0" + "'",
					"'" + time + "'" };
			String heads[] = { "id", "user_id", "content", "agree_num", "disagree_num", "time" };
			if (operation.insert(null, strs, heads, "tb_message")) {
				response.sendRedirect("MessageServlet?sign=1");
			} else {
				Jump.jumpToFail(response, "留言出错了，( ▼-▼ )，，请重试，", "留言出错");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
