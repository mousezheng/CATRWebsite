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
 * ����Աҵ����
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
	 * ��Ҫ�� jsp/manage/manage.jsp ��ҵ���� ����ǩ�л�����Ӧ��ͬ������ҳ��
	 * ���һЩ�洢��ת��������תĿ�ĵ���Ҫ��servlet ��Ϊ��Ҫ��̬��ȥ��������Դ
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
