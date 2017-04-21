package com.xatu.servlet.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.util.TableInfo;

/**
 * 管理员业务处理
 * 
 * @author zsl
 *
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ManageServlet() {
		super();
	}

	/**
	 * 主要对 jsp/manage/manage.jsp 的业务处理 左侧标签切换，对应不同的数据页面
	 * 完成一些存储跳转操作，跳转目的地主要是servlet 因为需要动态的去加载数据源
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		String sign = request.getParameter("sign");
		// System.out.println(sign);
		switch (sign) {
		case "1":
			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[1]);
			break;
		case "2":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[2]);
			break;
		case "3":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[3]);
			break;
		case "4":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[4]);
			break;
		case "5":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[5]);
			break;
		case "6":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[6]);
			break;
		case "7":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[7]);
			break;
		case "0":

			response.sendRedirect("jsp/manage/manage.jsp?urlName=" + TableInfo.servletName[0]);
			break;

		default:
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
