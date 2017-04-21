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
 * �����ҵ����
 */
@WebServlet("/AnnounceServlet")
public class AnnounceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AnnounceServlet() {
		super();
	}

	/**
	 * �Թ�����һЩ����Ա������ҵ��
	 * 
	 * ���ڹ���ֻ��һ��������û����ɾ�ȹ�����ֻ���޸�ҵ��
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String title = request.getParameter("title");
		//�����������ȥ�ж��Ƿ���ҪҪ�����¼
		if (title != null && !title.equals("")) {
			String time = request.getParameter("time");
			String content = request.getParameter("content");
			operation.delete(TableInfo.tableName[3], "1");
			String data[] = { "1", title, content, time };
			//ִ�в������
			operation.insertInto(TableInfo.tableName[3], TableInfo.announceTableHead, data);
		}
		List<String[]> tempStrs = null;
		//ִ�в�ѯ����
		tempStrs = operation.select(TableInfo.announceTableHead, TableInfo.tableName[3]);
		//�����ݵ�bean��ӳ�佻��service�����
		List<Announce> announces = ManagerService.StringToAnnounce(tempStrs);
		//����session
		session.setAttribute("announce", announces.get(0));
		//��ת
		response.sendRedirect("jsp/manage/part/announce.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
