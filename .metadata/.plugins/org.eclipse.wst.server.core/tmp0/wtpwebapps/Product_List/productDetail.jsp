<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.kh.product.ProductDAO" %>
<%@ page import = "com.kh.product.Product" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ������</title>
</head>
<body>
	<h1>��ǰ �� ����</h1>
	<%
		//String = id ���� ������ ���ڴ�.
		String productIdValue = request.getParameter("productId");
		int productId = Integer.parseInt(productIdValue);
		//DAO �۾�
		
		ProductDAO productDAO = new ProductDAO();
		Product product = productDAO.getProductId(productId);
		
		
		
	%>
	<p>��ǰ ID : <%= product.getProductId() %> </p>
	<p>��ǰ�� : <%= product.getProductName() %> </p>
	<p>ī�װ��� : <%= product.getCategory() %> </p>
	<p>���� : <%= product.getPrice() %> </p>
	<p>������� : <%= product.getStockQuantity() %> </p>
	
</body>
</html>