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

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		int num = 0;
		List<Attraction> attractions = null;
		String[] nameStr = null;
//		// 防止重复加载
//		if (session.getAttribute("attractionList") == null || session.getAttribute("nameStr") == null) {
			String[] tableHead = { "id", "name", "info", "see_num", "query_num", "img_file", "ticket_prices",
					"address" };
			String tableName = "tb_attractions";
			attractions = ConversionService.object2Attraction(operation.select(tableHead, tableName),
					getServletContext());
			session.setAttribute("attractionList", attractions);
			nameStr = operation.select4DESC();
			session.setAttribute("nameStr", nameStr);
		// } else {
		// attractions = (List<Attraction>)
		// session.getAttribute("attractionList");
		// nameStr = (String[]) session.getAttribute("nameStr");
		// }
		num = attractions.size() / 5;
		response.sendRedirect("jsp/page/tourist_attractions.jsp?sum=" + num + "&now=0");
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
