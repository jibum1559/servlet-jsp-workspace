<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제품 목록</title>
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
			<th>제품명</th>
			<th>제품이름</th>
			<th>카테고리</th>
		</tr>
		<% 
			for(Products p : pl){
				
		%>
		<tr>
			}
	</table>
	<%
	//1.페이지네이션 링크를 생성해줄 것이고, 링크는 page 값에 따라서 다르게 보일 것
	int totalProducts = pDAO.getTotalProducts(); //전체 제품 가져오기
	int totalPages = (int)Math.ceil((double)totalProducts/pageSize);
	
	for (int i = 1; i <= totalPages; i++) {
		
	%>
	<a href "<%= request.getRequestURI() %>?page<%= i %>"><%= i %></a>
		
	<% 
	}
	
	%>
</body>
</html>