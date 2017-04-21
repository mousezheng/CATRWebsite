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
 * 注册业务处理，将用户信息注册到数据库中 同时随机生成一个头像给用户
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
			Jump.jumpToFail(response, "手机号码或者用户名已存在，无法注册,", "注册失败");
		} else {
			// 随机头像
			Random random = new Random();
			int temp = 1 + random.nextInt(3);
			/*
			 * 2017年4月21日11:09:07 
			 * 修改随即头像功能去掉
			 */
			String headImgPath = "resources/head_img/head_" + temp + ".jpg";
//			String toPath = "resources/head_img/head_" + temp + ".jpg";
			operation.userRegistered(name, password, phone, headImgPath);
			Jump.jumpToSuccess(response, name+"已经成功注册，", "注册成功");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
