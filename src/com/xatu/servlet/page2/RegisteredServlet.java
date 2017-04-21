package com.xatu.servlet.page2;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.dao.DBOperation;
import com.xatu.util.Jump;
import com.xatu.util.StringChage;

/**
 * ע��ҵ�������û���Ϣע�ᵽ���ݿ��� ͬʱ�������һ��ͷ����û�
 */
@WebServlet("/RegisteredServlet")
public class RegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisteredServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = StringChage.encodingChage(request.getParameter("username"));
		String password = StringChage.encodingChage(request.getParameter("password"));
		String phone = StringChage.encodingChage(request.getParameter("phone"));
		DBOperation operation = DBOperation.getMyDB();
		if (!operation.phoneIsExist(phone,name)) {
			Jump.jumpToFail(response, "�ֻ���������û����Ѵ��ڣ��޷�ע��,", "ע��ʧ��");
		} else {
			// ���ͷ��
			Random random = new Random();
			int temp = 1 + random.nextInt(3);
			/*
			 * 2017��4��21��11:09:07 
			 * �޸��漴ͷ����ȥ��
			 */
			String headImgPath = "resources/head_img/head_" + temp + ".jpg";
//			String toPath = "resources/head_img/head_" + temp + ".jpg";
			operation.userRegistered(name, password, phone, headImgPath);
			Jump.jumpToSuccess(response, name+"�Ѿ��ɹ�ע�ᣬ", "ע��ɹ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
