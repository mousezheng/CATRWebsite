package com.xatu.servlet.page;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.util.Jump;

/**
 * ��ͬ���߲���ͬ����
 */
@WebServlet("/AgreeOrDisagree")
public class AgreeOrDisagree extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AgreeOrDisagree() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sign = request.getParameter("sign");
		String id = request.getParameter("id");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("username");

		if (name == null || name.equals("")) {
			Jump.jumpToFail(response, "�û���δ��¼�޷����ԣ�", "�޷��ύ���ԣ����ȵ�¼");
		} else {
			if (sign != null && sign.equals("agree")) {
				operation.queryplus("agree_num", id + "", "tb_message");
			} else if (sign != null && sign.equals("disagree")) {
				operation.queryplus("disagree_num", id + "", "tb_message");
			}
			response.sendRedirect("MessageServlet");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
