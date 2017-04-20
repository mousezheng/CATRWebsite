package com.xatu.servlet.manage.part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xatu.bean.Attraction;
import com.xatu.dao.DBOperation;
import com.xatu.service.FileService;
import com.xatu.service.ManagerService;
import com.xatu.util.StringChage;
import com.xatu.util.TableInfo;

/**
 * �������
 */
@WebServlet("/AttractionServlet")
public class AttractionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AttractionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		DBOperation operation = DBOperation.getMyDB();
		HttpSession session = request.getSession();
		List<String[]> tempStrs = null;
		String sign = request.getParameter("sign_attraction");
		System.out.println("=====================" + sign);
		if (sign != null) {
			if (sign.equals("delete")) {
				delete(request, response, operation);
			}
			if (sign.equals("updata")) { // ����
				updata(request, response, operation);
			}
			if (sign.equals("queryadd"))
				makeAdd(request, response, operation);
		}
		if (sign != null && sign.equals("query")) {
			tempStrs = query(request, response, operation);
			if (tempStrs.size() < 0)
				tempStrs = operation.select(TableInfo.attractionTableHead, TableInfo.tableName[2]);
			List<Attraction> attractions = ManagerService.StringToAttraction(tempStrs, request.getServletContext());
			session.setAttribute("attractions", attractions);
			session.setAttribute("tableHead", TableInfo.attractionTableHead);
			response.sendRedirect("jsp/manage/part/attraction.jsp");
		} else {
			tempStrs = operation.select(TableInfo.attractionTableHead, TableInfo.tableName[2]);
			List<Attraction> attractions = ManagerService.StringToAttraction(tempStrs, request.getServletContext());
			session.setAttribute("attractions", attractions);
			session.setAttribute("tableHead", TableInfo.attractionTableHead);
			response.sendRedirect("jsp/manage/part/attraction.jsp");
		}
	}

	private List<String[]> query(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		List<String[]> result = new ArrayList<>();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getServletContext().getRealPath("/resources");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = null;
		try {
			list = (List<FileItem>) upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		if (list != null)
			for (FileItem item : list) {
				String name = item.getFieldName();
				if (name.equals("query")) {
					String query = StringChage.encodingChage(item.getString());
					result = operation.selectLike(TableInfo.attractionTableHead, TableInfo.tableName[2],
							"id like '%" + query + "%' or " + "name like '%" + query + "%' or " + "info like '%" + query
									+ "%' or " + "address like '%" + query + "%'");
				}
			}

		return result;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
//		DiskFileItemFactory factory = new DiskFileItemFactory();
//		String path = request.getServletContext().getRealPath("/resources");
//		factory.setRepository(new File(path));
//		factory.setSizeThreshold(1024 * 1024);
//		ServletFileUpload upload = new ServletFileUpload(factory);
//		List<FileItem> list = null;
//		try {
//			list = (List<FileItem>) upload.parseRequest(request);
//		} catch (FileUploadException e) {
//			e.printStackTrace();
//		}
//		for (FileItem item : list) {
//			String name = item.getFieldName();
//			if (name.equals("id"))
		String id = request.getParameter("item_id");
		operation.delete(TableInfo.tableName[2], id);
//		}

	}

	private void updata(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		String path = request.getServletContext().getRealPath("/resources");
		factory.setRepository(new File(path));
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		List<FileItem> list = null;
		try {
			list = (List<FileItem>) upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		String data[] = new String[8];
		String tempdata = null;
		int cunter = 0;
		for (FileItem item : list) {
			// ��ȡ������������
			String name = item.getFieldName();
			System.out.println("item=============" + name);
			// temp = -1;
			switch (name) {
			case "id":
				tempdata = item.getString();
				break;
			case "name":
				tempdata = item.getString();
				break;
			case "info":
				FileService.uploadFile(item, path);
				tempdata = "info";
				break;
			case "see_num":
				tempdata = item.getString();
				break;
			case "query_num":
				tempdata = item.getString();
				break;
			case "image":
				FileService.uploadFile(item, path);
				tempdata = "img";
				break;
			case "image1":
				FileService.uploadFile(item, path);
				tempdata = "null";
				break;
			case "image2":
				FileService.uploadFile(item, path);
				tempdata = "null";
				break;
			case "ticket_prices":
				tempdata = item.getString();
				break;
			case "address":
				tempdata = item.getString();
				break;
			default:
				System.out.println("= = = = = = = = = = = = = = = = = = = = = = ƥ������ˣ�����������");
				break;
			}
			if (tempdata != null && !tempdata.equals("null")) {
				data[cunter++] = StringChage.encodingChage(tempdata);
				System.out.println(data[cunter - 1]);
			}
		}
		path = path + "/" + data[2];
		FileService.createDir(path);
		data[2] = "resources/" + data[1] + "/describe.txt";
		data[5] = "resources/" + data[1];
		operation.delete(TableInfo.tableName[2], data[0]);
		operation.insertInto(TableInfo.tableName[2], TableInfo.attractionTableHead, data);
	}

	/**
	 * �������Ӳ���
	 * 
	 * @param request
	 * @param response
	 */
	private void makeAdd(HttpServletRequest request, HttpServletResponse response, DBOperation operation) {
		// ��ô����ļ���Ŀ����
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ��ȡ�ļ���Ҫ�ϴ�����·��
		String path = request.getServletContext().getRealPath("/resources");
		System.out.println(path);
		// ���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬
		// ������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ
		/**
		 * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ� ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem
		 * ��ʽ�� Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����
		 */
		factory.setRepository(new File(path));
		// ���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��
		factory.setSizeThreshold(1024 * 1024);

		// ��ˮƽ��API�ļ��ϴ�����
		ServletFileUpload upload = new ServletFileUpload(factory);

		// �����ϴ�����ļ�
		List<FileItem> list = null;
		try {
			list = (List<FileItem>) upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		String data[] = new String[8];
		String tempdata = null;
		int cunter = 0;
		for (FileItem item : list) {
			// ��ȡ������������
			String name = item.getFieldName();
			System.out.println("item=============" + name);
			// temp = -1;
			switch (name) {
			case "id":
				tempdata = item.getString();
				break;
			case "name":
				tempdata = item.getString();
				break;
			case "info":
				FileService.uploadFile(item, path);
				tempdata = "info";
				break;
			case "see_num":
				tempdata = item.getString();
				break;
			case "query_num":
				tempdata = item.getString();
				break;
			case "image":
				FileService.uploadFile(item, path);
				tempdata = "img";
				break;
			case "image1":
				FileService.uploadFile(item, path);
				tempdata = "null";
				break;
			case "image2":
				FileService.uploadFile(item, path);
				tempdata = "null";
				break;
			case "ticket_prices":
				tempdata = item.getString();
				break;
			case "address":
				tempdata = item.getString();
				break;
			default:
				System.out.println("= = = = = = = = = = = = = = = = = = = = = = ƥ������ˣ�����������");
				break;
			}
			if (tempdata != null && !tempdata.equals("null")) {
				data[cunter++] = StringChage.encodingChage(tempdata);
				System.out.println(data[cunter - 1]);
			}

		}
		path = path + "/" + data[2];
		FileService.createDir(path);
		data[2] = "resources/" + data[1] + "/describe.txt";
		data[5] = "resources/" + data[1];
		operation.insertInto(TableInfo.tableName[2], TableInfo.attractionTableHead, data);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
