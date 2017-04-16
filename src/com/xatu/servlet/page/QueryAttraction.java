package com.xatu.servlet.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Attraction;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;
import com.xatu.util.StringChage;

/**
 * 景点搜索业务处理
 */
@WebServlet("/QueryAttraction")
public class QueryAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAttraction() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String sign = StringChage.encodingChage(request.getParameter("sign"));
		System.out.println(sign);
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		int num = 0;
		List<Attraction> attractions = null;
		String[] nameStr = null;

		String[] tableHead = { "id", "name", "info", "see_num", "query_num", "img_file", "ticket_prices", "address" };
		String tableName = "tb_attractions";
		attractions = ConversionService.object2Attraction(
				operation.selectLike(tableHead, tableName,
						"address like '%" + sign + "%' or name like '%" + sign + "%' or info like '%" + sign + "%'"),
				getServletContext());
		session.setAttribute("attractionList", attractions);
		nameStr = operation.select4DESC();
		session.setAttribute("nameStr", nameStr);   
		num = attractions.size() / 5;
		response.sendRedirect("jsp/page/tourist_attractions.jsp?sum=" + num + "&now=0");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
