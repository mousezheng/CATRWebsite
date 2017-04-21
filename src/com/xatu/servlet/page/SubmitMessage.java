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
 * �ύ���Դ���ҳ��
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
			Jump.jumpToFail(response, "�û���δ��¼�޷����ԣ�", "�޷��ύ���ԣ����ȵ�¼");
		} else {
			String message = request.getParameter("message");
			System.out.println(message);
			SimpleDateFormat df = new SimpleDateFormat("yyyy��MM��dd HH:mm:ss");// �������ڸ�ʽ
			String time = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			String id = operation.getIdString("tb_user", "user_name", "id", name);
			String strs[] = { "null", "'" + id + "'", "'" + message + "'", "'" + "0" + "'", "'" + "0" + "'",
					"'" + time + "'" };
			String heads[] = { "id", "user_id", "content", "agree_num", "disagree_num", "time" };
			if (operation.insert(null, strs, heads, "tb_message")) {
				response.sendRedirect("MessageServlet?sign=1");
			} else {
				Jump.jumpToFail(response, "���Գ����ˣ�( ��-�� )���������ԣ�", "���Գ���");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
