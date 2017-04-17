package com.xatu.servlet.page.relation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xatu.util.DateUtil;
import com.xatu.util.Jump;

/**
 * Ԥ��Ʊ����
 */
@WebServlet("/AddTicket")
public class AddTicket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddTicket() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String time = request.getParameter("time");
		String[] date = time.split("-");
		if (date.length!=3) {
			Jump.jumpToFail(response, "���������������������", "���ڽ�������");
		}else if(DateUtil.isReightDate(date)){
			response.sendRedirect("UserInfoServlet");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
