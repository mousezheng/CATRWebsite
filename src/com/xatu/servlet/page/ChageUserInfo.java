package com.xatu.servlet.page;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xatu.dao.DBOperation;
import com.xatu.util.Jump;

/**
 * 个人信息修改服务页面
 */
@SuppressWarnings("serial")
@WebServlet("/ChageUserInfo")
public class ChageUserInfo extends HttpServlet {

	public ChageUserInfo() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("username");
		DBOperation operation = DBOperation.getMyDB();
		String id = operation.getIdString("tb_user", "user_name", "id", name);
		// 从request当中获取流信息
		InputStream fileSource = req.getInputStream();
		String tempFileName = "E:/tempFile";
		// tempFile指向临时文件
		File tempFile = new File(tempFileName);
		// outputStram文件输出流指向这个临时文件
		FileOutputStream outputStream = new FileOutputStream(tempFile);
		byte b[] = new byte[1024];
		int n;
		while ((n = fileSource.read(b)) != -1) {
			outputStream.write(b, 0, n);
		}
		// 关闭输出流、输入流
		outputStream.close();
		fileSource.close();

		// 获取上传文件的名称
		RandomAccessFile randomFile = new RandomAccessFile(tempFile, "r");
		// l = new String(l.getBytes("8859_1"),"gbk");
		String str2 = randomFile.readLine();
		// 编码转换
		str2 = new String(str2.getBytes("8859_1"), "utf-8");
		System.out.println(str2);
		String str = randomFile.readLine();
		str = new String(str.getBytes("8859_1"), "utf-8");
		System.out.println(str);
		String filename = "head_" + id + ".jpg";
		System.out.println("filename:" + filename);

		// 重新定位文件指针到文件头
		randomFile.seek(0);
		long startPosition = 0;
		int i = 1;
		// 获取文件内容 开始位置
		while ((n = randomFile.readByte()) != -1 && i <= 4) {
			if (n == '\n') {
				startPosition = randomFile.getFilePointer();
				i++;
			}
		}
		startPosition = randomFile.getFilePointer() - 1;
		// 获取文件内容 结束位置
		randomFile.seek(randomFile.length());
		long endPosition = randomFile.getFilePointer();
		int j = 1;
		while (endPosition >= 0 && j <= 2) {
			endPosition--;
			randomFile.seek(endPosition);
			if (randomFile.readByte() == '\n') {
				j++;
			}
		}
		endPosition = endPosition - 1;

		// 设置保存上传文件的路径
		// 路径可以自行设置
		String path = "/resources/user_head_img/";
		ServletContext sc = req.getServletContext();
		path = sc.getRealPath(path);
		String realPath = path;
		// String realPath = getServletContext().getRealPath("/") + "images";
		File fileupload = new File(realPath);
		System.out.println(realPath);
		if (!fileupload.exists()) {
			fileupload.mkdir();
		}
		File saveFile = new File(realPath, filename);
		RandomAccessFile randomAccessFile = new RandomAccessFile(saveFile, "rw");
		// 从临时文件当中读取文件内容（根据起止位置获取）
		randomFile.seek(startPosition);
		while (startPosition < endPosition) {
			randomAccessFile.write(randomFile.readByte());
			startPosition = randomFile.getFilePointer();
		}
		// 关闭输入输出流、删除临时文件
		randomAccessFile.close();
		randomFile.close();
		tempFile.delete();

		session.invalidate();
		Jump.jumpToSuccess(response, "上传成功了", "成功");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
