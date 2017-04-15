package com.xatu.servlet.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.xatu.bean.Attraction;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;
import com.xatu.service.FileService;

/**
 * 景点浏览业务处理
 */
@WebServlet("/AttractionsServlet")
public class AttractionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AttractionsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String[] tableHead = { "id", "name", "info", "see_num", "query_num", "img_file", "ticket_prices", "address" };
		String tableName = "tb_attractions";
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<Attraction> attractions = ConversionService.object2Attraction(operation.select(tableHead, tableName),
				getServletContext());

		session.setAttribute("attractionList", attractions);
		response.sendRedirect("jsp/page/tourist_attractions.jsp");
		// 测试使用
		// String str = FileService.fileToString("resources/大雁塔/describe.txt",
		// getServletContext());
		// PrintWriter pw = response.getWriter();
		// pw.println(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
