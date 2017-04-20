package com.xatu.servlet.manage.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * 用户表业务处理
 */
@WebServlet("/ManagesServlet")
public class ManagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManagesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		if (request.getParameter("sign_manage") != null && request.getParameter("sign_manage").equals("update")) {
			String id = request.getParameter(TableInfo.manageTableHead[0]);
			String userName = StringChage.encodingChage(request.getParameter(TableInfo.manageTableHead[1]));
			String password = request.getParameter(TableInfo.manageTableHead[2]);
			String[] data = { id, userName, password };
			for (int i = 0; i < data.length; i++) {
				System.out.println(data[i]);
			}
			operation.delete(TableInfo.tableName[0], id);
			operation.insertInto(TableInfo.tableName[0], TableInfo.manageTableHead, data);
		}
		List<String[]> tempStrs = null;
		tempStrs = operation.select(TableInfo.manageTableHead, TableInfo.tableName[0]);
		session.setAttribute("tableHead", TableInfo.manageTableHead);
		session.setAttribute("manages", ManagerService.StringToManage(tempStrs));
		response.sendRedirect("jsp/manage/part/manage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
