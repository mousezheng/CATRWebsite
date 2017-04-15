package com.xatu.servlet.page;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Hotel;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;

/**
 * 酒店服务业务处理
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("GBK");
		String[] tableHead = { "id", "time", "contact_phone", "name", "contact_name", "prices", "address" };
		String tableName = "td_hotel";
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<Hotel> hotels = ConversionService.object2Hotel(operation.select(tableHead, tableName), getServletContext());

		session.setAttribute("hotelList", hotels);
		response.sendRedirect("jsp/page/hotel_reservation.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
