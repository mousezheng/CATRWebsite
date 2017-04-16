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
import com.xatu.bean.Car;
import com.xatu.dao.DBOperation;
import com.xatu.service.ConversionService;

/**
 * �⳵����ҵ����
 */
@WebServlet("/CarServiceServlet")
public class CarServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CarServiceServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");

		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		// ��ֹ�ظ�����
		if (session.getAttribute("carList") == null) {
			String[] tableHead = { "id", "time", "contact_phone", "name", "contact_name", "prices", "address" };
			String tableName = "tb_car";
			List<Car> cars = ConversionService.object2Car(operation.select(tableHead, tableName), getServletContext());
			session.setAttribute("carList", cars);
		}
		/*
		 * 2017��4��16��11:49:28 �޸���ֱ�ӵ���Ƶ�/�⳵ҳ��ʱ���޷���ȷ��ʾĿ�ĵ�
		 */
		if (session.getAttribute("attractionList") == null) {
			String[] tableHead1 = { "id", "name", "info", "see_num", "query_num", "img_file", "ticket_prices",
					"address" };
			String tableName1 = "tb_attractions";
			List<Attraction> attractions = ConversionService.object2Attraction(operation.select(tableHead1, tableName1),
					getServletContext());

			session.setAttribute("attractionList", attractions);
		}
		response.sendRedirect("jsp/page/car_rental_service.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
