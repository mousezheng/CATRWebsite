package com.xatu.servlet.manage.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.Activity;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * ���ҵ����
 */
@WebServlet("/ActivitysServlet")
public class ActivitysServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ActivitysServlet() {
		super();
	}

	/**
	 * �Ի����һЩ����Ա������ҵ��
	 * 
	 * ��Ҫ������ɾ�Ĳ�
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		//��ȡ����ı�־ָ�� sign
		String sign = request.getParameter("sign_activity");
		System.out.println("=====================" + sign);
		if (sign != null) {	
			//ɾ��ָ��
			if (sign.equals("delete")) {	
				String id = request.getParameter("item_id");
				operation.delete(TableInfo.tableName[7], id);
			}
			//����ָ��
			if (sign.equals("updata")) {
				String id = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[0]));
				String name = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[1]));
				String number = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[2]));
				String prices = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[3]));
				String info = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[4]));
				String one = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[5]));
				String two = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[6]));
				String three = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[7]));
				String four = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[8]));
				String five = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[9]));
				String six = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[10]));
				String seven = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[11]));
				String[] data = { id, name, number, prices, info, one, two, three, four, five, six, seven };
				for (int i = 0; i < data.length; i++) {
					System.out.println(data[i]);
				}
				//���²���һ��һɾ���ķ�ʽ���򵥵�
				operation.delete(TableInfo.tableName[7], id);
				operation.insertInto(TableInfo.tableName[7], TableInfo.activityTableHead, data);
			}
			//û��ָ��Ĭ��Ϊaddָ��ж��Ƿ����������
		} else if (request.getParameter(TableInfo.activityTableHead[0]) != null)
			makeAdd(request, response, operation);

		List<String[]> tempStrs = null;
		String query = request.getParameter("query");
		//�жϲ�ѯ�����Ƿ������ݣ��Ƿ���Ҫ���в�ѯ����
		if (query != null && !query.equals("")) {
			query = StringChage.encodingChage(query);
			tempStrs = operation.selectLike(TableInfo.activityTableHead, TableInfo.tableName[7],
					"id like '%" + query + "%' or " + "name like '%" + query + "%' or " + "info like '%" + query
							+ "%' or " + "number like '%" + query + "%' or " + "one like '%" + query + "%' or "
							+ "two like '%" + query + "%' or " + "three like '%" + query + "%' or " + "four like '%"
							+ query + "%' or " + "six like '%" + query + "%' or " + "seven like '%" + query + "%'");
		} else {
			tempStrs = operation.select(TableInfo.activityTableHead, TableInfo.tableName[7]);
		}
		// ��List<String[]> --> List<Activity>��ӳ�佻��service�����
		List<Activity> activitys = ManagerService.StringToActivity(tempStrs);
		//��������Դ
		session.setAttribute("activitys", activitys);
		session.setAttribute("tables", TableInfo.oneToSeven);
		session.setAttribute("tableHead", TableInfo.activityTableHead);
		//��ת
		response.sendRedirect("jsp/manage/part/activity.jsp");
	}

	/**
	 * �������Ӳ���
	 * 
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		String id = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[0]));
		String name = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[1]));
		String number = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[2]));
		String prices = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[3]));
		String info = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[4]));
		String one = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[5]));
		String two = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[6]));
		String three = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[7]));
		String four = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[8]));
		String five = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[9]));
		String six = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[10]));
		String seven = StringChage.encodingChage(request.getParameter(TableInfo.activityTableHead[11]));
		String[] data = { id, name, number, prices, info, one, two, three, four, five, six, seven };
		// for (int i = 0; i < data.length; i++) {
		// System.out.println(data[i]);
		// }
		operation.insertInto(TableInfo.tableName[7], TableInfo.activityTableHead, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
