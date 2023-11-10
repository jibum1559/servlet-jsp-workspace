<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.kh.product.ProductDAO" %>
<%@ page import = "com.kh.product.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>제품 상세 페이지</title>
</head>
<body>
	<h1>제품 상세 정보</h1>
	<%
		//String = id 값을 가지고 오겠다.
		String productIdValue = request.getParameter("productId");
		int productId = Integer.parseInt(productIdValue);
		//DAO 작업
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProductId(productId);
		
		
		
	%>
	<p>제품 ID : <%= product.getProductId() %> </p>
	<p>제품명 : <%= product.getProductName() %> </p>
	<p>카테고리 : <%= product.getCategory() %> </p>
	<p>가격 : <%= product.getPrice() %> </p>
	<p>재고수량 : <%= product.getStockQuantity() %> </p>
	
</body>
</html>