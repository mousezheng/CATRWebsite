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
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;

/**
 * ¡Ù—‘¥¶¿Ì“≥√Ê
 */
@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String[] tableHead = { "tb_message.id", "tb_user.user_name", "content", "agree_num", "disagree_num", "time", "tb_message.address" };
		String tableName = "tb_message";
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<Message> messages =  ConversionService.object2Message(operation.selectWhere(tableHead, tableName,"tb_user","tb_user.id=tb_message.user_id"), getServletContext());
	
		session.setAttribute("messageList", messages);
		response.sendRedirect("jsp/page/message_board.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
