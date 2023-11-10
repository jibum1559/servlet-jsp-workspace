package com.kh.imageUpload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadServlet")
@MultipartConfig
		/*
		(fileSizeThreshold = 1024 * 1024,	 // => 1MB
		//���� �����͸� ��ũ�� ����� �����ϱ� ���� �޸𸮿� �����Ǵ� �ִ�ũ��(1MB)
		maxFileSize = 1024 * 1024 * 5,		 //���ε��� ������ �ִ� ũ��(5MB)
		maxRequestSize = 1024 * 1024 * 10,   // ��û �������� �ִ� ũ��
		location="/tmp" 					 //������ ��ũ�� ����� �ӽ� ���͸�
		)*/ 


//������ �ø��� ���� ���� ���� �����ϴ� ����
public class UploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String jdbcUser = "khcafe";
		String jdbcPW = "khcafe";

		/*
	 ����ڰ� ��û�� �� �����͸� ó���ϴµ� ����ϴ� ����
	 jsp title �Ķ���͸� �������ͼ� title ���ڿ� ������ ����
	 ������ �Էµ� ������ ��Ÿ��
	 String title = request.getParameter("title");
	  
		 */
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Part imagePart = request.getPart("image");
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPW);
			String sql = "INSERT INTO Board (board_id, title, content, image, created_at, author)"
					+ "VALUES (board_sequence.nextval, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
				ps.setString(1, title);
				ps.setString(2, content);
				ps.setBinaryStream(3, imagePart.getInputStream(), (int)imagePart.getSize()); //������ �⺻������ long���� �Ǿ��־ int�� ��ȯ
				ps.setTimestamp(4, new Timestamp(new Date().getTime()));
				ps.setString(5, "author name");
				
				
				ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("imageList.jsp");
	}
	
}