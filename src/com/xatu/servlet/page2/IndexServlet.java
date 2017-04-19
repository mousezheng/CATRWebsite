package com.xatu.servlet.page2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Announce;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.TableInfo;

/**
 * ��ʼҳ�洦����Ҫ�ǹ������
 */
@WebServlet("")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<String[]> tempStrs = null;
		tempStrs = operation.select(TableInfo.announceTableHead, TableInfo.tableName[3]);
		List<Announce> announces = ManagerService.StringToAnnounce(tempStrs);
		session.setAttribute("announce", announces.get(0));
		response.sendRedirect("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
