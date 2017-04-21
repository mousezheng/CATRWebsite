package com.xatu.servlet.manage.part;

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
 * 公告表业务处理
 */
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnnounceServlet() {
		super();
	}

	/**
	 * 对公告表的一些管理员操作的业务，
	 * 
	 * 由于公告只有一条，所以没有增删等工作，只有修改业务
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		//根据输入标题去判断是否需要要插入记录
		if (title != null && !title.equals("")) {
			String time = request.getParameter("time");
			String content = request.getParameter("content");
			operation.delete(TableInfo.tableName[3], "1");
			String data[] = { "1", title, content, time };
			//执行插入操作
			operation.insertInto(TableInfo.tableName[3], TableInfo.announceTableHead, data);
		}
		List<String[]> tempStrs = null;
		//执行查询操作
		tempStrs = operation.select(TableInfo.announceTableHead, TableInfo.tableName[3]);
		//从数据到bean的映射交给service层完成
		List<Announce> announces = ManagerService.StringToAnnounce(tempStrs);
		//设置session
		session.setAttribute("announce", announces.get(0));
		//跳转
		response.sendRedirect("jsp/manage/part/announce.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
