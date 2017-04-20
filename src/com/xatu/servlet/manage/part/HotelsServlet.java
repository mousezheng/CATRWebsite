package com.xatu.servlet.manage.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Car;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * 用户表业务处理
 */
@WebServlet("/HotelsServlet")
public class HotelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HotelsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String sign = request.getParameter("sign_car");
		System.out.println("=====================" + sign);
		if (sign != null) {
			if (sign.equals("delete")) {
				String id = request.getParameter("item_id");
				operation.delete(TableInfo.tableName[5], id);
			}
			if (sign.equals("updata")) {
				String id = request.getParameter(TableInfo.carTableHead[0]);
				String time = request.getParameter(TableInfo.carTableHead[1]);
				String contact_phone = request.getParameter(TableInfo.carTableHead[2]);
				String name = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[3]));
				String contact_name = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[4]));
				String price = request.getParameter(TableInfo.carTableHead[5]);
				String address = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[6]));
				String[] data = { id, time, contact_phone, name, contact_name, price, address };
//				 for (int i = 0; i < data.length; i++) {
//				 System.out.println(data[i]);
//				 }
				operation.delete(TableInfo.tableName[5], id);
				operation.insertInto(TableInfo.tableName[5], TableInfo.carTableHead, data);
			}
		} else if (request.getParameter(TableInfo.carTableHead[0]) != null)
			makeAdd(request, response, operation);

		List<String[]> tempStrs = null;
		String query = request.getParameter("query");
		if (query != null && !query.equals("")) {
			query = StringChage.encodingChage(query);
			tempStrs = operation.selectLike(TableInfo.carTableHead, TableInfo.tableName[5],
					"id like '%" + query + "%' or " + "name like '%" + query + "%' or " + "address like '%" + query
							+ "%' or " + "contact_name like '%" + query + "%'");
		} else {
			tempStrs = operation.select(TableInfo.carTableHead, TableInfo.tableName[5]);
		}
		List<Car> cars = ManagerService.StringToCar(tempStrs);
		session.setAttribute("cars", cars);
		session.setAttribute("tableHead", TableInfo.carTableHead);
		response.sendRedirect("jsp/manage/part/hotel.jsp");
	}

	/**
	 * 处理增加操作
	 * 
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		String id = request.getParameter(TableInfo.carTableHead[0]);
		String time = request.getParameter(TableInfo.carTableHead[1]);
		String contact_phone = request.getParameter(TableInfo.carTableHead[2]);
		String name = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[3]));
		String contact_name = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[4]));
		String price = request.getParameter(TableInfo.carTableHead[5]);
		String address = StringChage.encodingChage(request.getParameter(TableInfo.carTableHead[6]));
		String[] data = { id, time, contact_phone, name, contact_name, price, address };
//		 for (int i = 0; i < data.length; i++) {
//		 System.out.println(data[i]);
//		 }
		operation.insertInto(TableInfo.tableName[5], TableInfo.carTableHead, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
