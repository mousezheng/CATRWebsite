package com.xatu.servlet.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Activity;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;

/**
 * 多日有业务处理
 */
@WebServlet("/ActivityServlet")
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivityServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("GBK");
		String[] tableHead = { "id", "name", "number","prices","info","image_file", "one", "two", "three", "four", "five", "six", "seven" };
		String tableName = "td_activity";
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<Activity> activitys = ConversionService.object2Activity(operation.select(tableHead, tableName),
				getServletContext());
		session.setAttribute("activityList", activitys);
		response.sendRedirect("jsp/page/three_day_swim.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
