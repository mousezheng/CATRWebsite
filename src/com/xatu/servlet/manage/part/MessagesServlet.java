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
import com.xatu.bean.Car;
import com.xatu.bean.Message;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * 用户表业务处理
 */
@WebServlet("/MessagesServlet")
public class MessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MessagesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		String sign = request.getParameter("sign_message");
		System.out.println("=====================" + sign);
		if (sign != null) {
			if (sign.equals("delete")) {
				String id = request.getParameter("item_id");
				operation.delete(TableInfo.tableName[4], id);
			}
			if (sign.equals("updata")) {
				String id = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[0]));
				String user_id = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[1]));
				String content = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[2]));
				String agree_num = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[3]));
				String disagree_num = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[4]));
				String time = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[5]));
				String address = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[6]));
				String[] data = { id, user_id, content, agree_num, disagree_num, time, address };
				// for (int i = 0; i < data.length; i++) {
				// System.out.println(data[i]);
				// }
				operation.delete(TableInfo.tableName[4], id);
				operation.insertInto(TableInfo.tableName[4], TableInfo.messageTableHead, data);
			}
		} else if (request.getParameter(TableInfo.messageTableHead[0]) != null)
			makeAdd(request, response, operation);

		List<String[]> tempStrs = null;
		String query = request.getParameter("query");
		if (query != null && !query.equals("")) {
			query = StringChage.encodingChage(query);
			tempStrs = operation.selectLike(TableInfo.messageTableHead, TableInfo.tableName[4],
					"id like '%" + query + "%' or " + "content like '%" + query + "%' or " + "time like '%" + query
							+ "%' or " + "address like '%" + query + "%'");
		} else {
			tempStrs = operation.select(TableInfo.messageTableHead, TableInfo.tableName[4]);
		}
		List<Message> messages = ManagerService.StringToMessage(tempStrs);
		session.setAttribute("messages", messages);
		session.setAttribute("tableHead", TableInfo.messageTableHead);
		response.sendRedirect("jsp/manage/part/message.jsp");
	}

	/**
	 * 处理增加操作
	 * 
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		String id = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[0]));
		String user_id = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[1]));
		String content = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[2]));
		String agree_num = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[3]));
		String disagree_num = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[4]));
		String time = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[5]));
		String address = StringChage.encodingChage(request.getParameter(TableInfo.messageTableHead[6]));
		String[] data = { id, user_id, content, agree_num, disagree_num, time, address };
		// for (int i = 0; i < data.length; i++) {
		// System.out.println(data[i]);
		// }
		operation.insertInto(TableInfo.tableName[4], TableInfo.messageTableHead, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
