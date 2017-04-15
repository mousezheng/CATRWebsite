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
 * �޸�����ҵ������ ����session��ȡ�û���������û���Ϊ�գ��򷵻ش���ҳ�棩 ���������������
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
			Jump.jumpToFail(response, "�û���δ��¼�޷��޸����룬", "�޸�����ʧ��");
		} else {
			String password = StringChage.encodingChage(request.getParameter("password"));
			String newPassword = StringChage.encodingChage(request.getParameter("new_password"));
			if (operation.changePassword(name, password, newPassword)) {
				Jump.jumpToSuccess(response, name+"�Ѿ��ɹ��޸����룬�����µ�½", "������ɹ�");
				session.removeAttribute("username");
			}else{
				Jump.jumpToFail(response, "������������޷��޸ģ�", "�޸��������");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
