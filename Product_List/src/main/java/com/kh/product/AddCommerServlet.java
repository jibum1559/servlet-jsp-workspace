package com.kh.product;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddCommerServlet
 */
@WebServlet("/AddCommerServlet")
public class AddCommerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp ������ ������ ������ ���������
		int productId = Integer.parseInt(request.getParameter("productId"));
		String commenterName = request.getParameter("commenterName");
		String commentText = request.getParameter("commentText");
		Timestamp commentDate = new Timestamp(System.currentTimeMillis());
		
		//ProductComment ��ü ����
		ProductComment comment = new ProductComment(0, productId, commenterName, commentText, commentDate);
		//ProductDAO�� ����ؼ� ��� �߰�
		ProductDAO productDAO = new ProductDAO();
		productDAO.addComment(comment);
		
		//��� �߰� �� ���� ���������� �ٽ� �����ϴ� �����̷�Ʈ �ۼ����ֱ�
		response.sendRedirect("productDetail.jsp?productId" + productId);
		
	}

}
