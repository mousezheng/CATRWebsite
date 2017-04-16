package com.xatu.servlet.page2;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

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
 * ��½ҵ����
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringChage.encodingChage(request.getParameter("name"));
		String password = StringChage.encodingChage(request.getParameter("password"));
		String type = StringChage.encodingChage(request.getParameter("position"));
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();

		if (type.equals("user") && operation.userIsExist(name, password)) {
			System.out.println("�û���¼��֤ͨ��");
			response.sendRedirect("index.jsp"); // ��ת���û���½�ɹ�ҳ��
			session.setAttribute("username", name); // �����û�session
			String id = operation.getIdString("tb_user", "user_name", "id", name);
			session.setAttribute("id", id); // �����û�session
		} else if (type.equals("manager") && operation.managerIsExist(name, password)) {
			System.out.println("����Ա��֤ͨ��");
			response.sendRedirect("jsp/manage/manage.jsp"); // ��ת������Աҳ��
		} else {
			Jump.jumpToFail(response, "��½��֤ʧ�ܣ�", "��¼ʧ��");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
