<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ���</title>
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="paginationDAO. *" %>
	<%
		//int pageNumber = (request.getParameter("page") !=null) ? Integer.parseInt(getParameter("page")) : 1;
		int pageNumber = Integer.parseInt(request.getParameter("page"));
		int pageSize = 2;
		
		ProductsDAO pDAO = new ProductsDAO();
		List<Products> pl = pDAO.getAllProducts(pageNumber, pageSize);
	%>
	<table border = "1">
		<tr>
			<th>��ǰ��</th>
			<th>��ǰ�̸�</th>
			<th>ī�װ�</th>
		</tr>
		<% 
			for(Products p : pl){
				
		%>
		<tr>
			}
	</table>
	<%
	//1.���������̼� ��ũ�� �������� ���̰�, ��ũ�� page ���� ���� �ٸ��� ���� ��
	int totalProducts = pDAO.getTotalProducts(); //��ü ��ǰ ��������
	int totalPages = (int)Math.ceil((double)totalProducts/pageSize);
	
	for (int i = 1; i <= totalPages; i++) {
		
	%>
	<a href "<%= request.getRequestURI() %>?page<%= i %>"><%= i %></a>
		
	<% 
	}
	
	%>
</body>
</html>