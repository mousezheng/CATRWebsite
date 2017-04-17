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
import com.xatu.bean.Hotel;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;

/**
 * �Ƶ����ҵ����
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		response.setCharacterEncoding("GBK");
		// ��ֹ�ظ�����
		if (session.getAttribute("hotelList") == null) {
			String[] tableHead = { "id", "time", "contact_phone", "name", "contact_name", "prices", "address" };
			String tableName = "td_hotel";
			List<Hotel> hotels = ConversionService.object2Hotel(operation.select(tableHead, tableName),
					getServletContext());
			session.setAttribute("hotelList", hotels);
		}
//		/*
//		 * 2017��4��16��11:49:28 �޸���ֱ�ӵ���Ƶ�/�⳵ҳ��ʱ���޷���ȷ��ʾĿ�ĵ�
//		 */
//		if (session.getAttribute("attractionList") == null) {
			String[] tableHead1 = { "id", "name", "info", "see_num", "query_num", "img_file", "ticket_prices",
					"address" };
			String tableName1 = "tb_attractions";
			List<Attraction> attractions = ConversionService.object2Attraction(operation.select(tableHead1, tableName1),
					getServletContext());

			session.setAttribute("attractionList", attractions);
//		}
		response.sendRedirect("jsp/page/hotel_reservation.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
