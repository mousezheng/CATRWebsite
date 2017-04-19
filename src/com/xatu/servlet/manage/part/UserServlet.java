package com.xatu.servlet.manage.part;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.bean.User;
import com.xatu.dao.DBOperation;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * 用户表业务处理
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		// 这些属于私密信息，不允许管理员修改
		// ,"birthday","name","sex","email","address","info","age"
		// 输入信息不为空添加一条记录
		String sign = request.getParameter("sign_user");
		System.out.println("=====================" + sign);
		if (sign != null) {
			if (sign.equals("delete")) {
				String id = request.getParameter("item_id");
				operation.delete("tb_user", id);
			}
			if (sign.equals("updata")) {
				String id = request.getParameter(TableInfo.userTableHead[0]);
				String userName = StringChage.encodingChage(request.getParameter(TableInfo.userTableHead[1]));
				String password = request.getParameter(TableInfo.userTableHead[2]);
				String phone = request.getParameter(TableInfo.userTableHead[3]);
				String[] data = { id, userName, password, phone };
				for (int i = 0; i < data.length; i++) {
					System.out.println(data[i]);
				}
				operation.delete("tb_user", id);
				operation.insertInto(TableInfo.tableName[1], TableInfo.userTableHead, data);
			}
		} else if (request.getParameter(TableInfo.userTableHead[0]) != null)
			makeAdd(request, response, operation);

		List<String[]> tempStrs = null;
		String query = request.getParameter("query");
		if (query != null&& !query.equals("")) {
			query = StringChage.encodingChage(query);
			tempStrs = operation.selectLike(TableInfo.userTableHead, "tb_user", "id like '%" + query + "%' or "
					+ "user_name like '%" + query + "%' or " + "phone like '%" + query + "%'");
		} else {
			tempStrs = operation.select(TableInfo.userTableHead, TableInfo.tableName[1]);
		}
		List<User> users = ManagerService.StringToUser(tempStrs);
		session.setAttribute("users", users);
		session.setAttribute("tableHead", TableInfo.userTableHead);
		response.sendRedirect("jsp/manage/part/user.jsp");
	}

	/**
	 * 处理增加操作
	 * 
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		String id = request.getParameter(TableInfo.userTableHead[0]);
		String userName = StringChage.encodingChage(request.getParameter(TableInfo.userTableHead[1]));
		String password = request.getParameter(TableInfo.userTableHead[2]);
		String phone = request.getParameter(TableInfo.userTableHead[3]);
		String[] data = { id, userName, password, phone };
		// for (int i = 0; i < data.length; i++) {
		// System.out.println(data[i]);
		// }
		operation.insertInto(TableInfo.tableName[1], TableInfo.userTableHead, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
