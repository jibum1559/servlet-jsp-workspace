<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "com.kh.product.ProductDAO" %>
<%@ page import = "com.kh.product.Product" %>
<%@ page import = "com.kh.product.ProductComment" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �� ������</title>
  <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 0;
            padding: 0;
             text-align: center;
        }

        h1 {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
        }

        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            background-color: #fff;
        }

        table, th, td {
            border: 1px solid #ccc;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e0e0e0;
        }
    </style>
</head>
<body>
	<h1>��ǰ �� ����</h1>
	<%
			String ProductIdParam = request.getParameter("productId");
			Product product = null;
			ArrayList<ProductComment> commentList = null;
			
			//String = id ���� ������ ���ڴ�.
			String productIdValue = request.getParameter("productId");
			if (productIdParam != null) {
				
			int productId = Integer.parseInt(productIdParam);
			//DAO �۾�
			ProductDAO productDAO = new ProductDAO();
			Product product = productDAO.getProductId(productId);
			
			commentList = productDAO.getCommentByProductId(product.getProductId());
            
    %>

    <p>��ǰ ID: <%= product.getProductId() %></p>
    <p>��ǰ��: <%= product.getProductName() %></p>
    <p>ī�װ�: <%= product.getCategory() %></p>
    <p>����: <%= product.getPrice() %></p>
    <p>��� ����: <%= product.getStockQuantity() %></p>
    <a href="update_product.jsp?productId=<%= product.getProductId() %>">��ǰ �����ϱ�</a>
    <%
        } else {
    %>
    <p>��ǰ�� ã�� �� �����ϴ�..</p>	
    <%
        }
    %>
    
	<!-- ��� ��� ǥ�� -->	
	<h3>��� ���</h3>
	<%
		//���� ����� �����Ѵٸ� (if)
		if (commentList != null) {
			for (ProductComment comment : commnetList) {
	%>
	<!-- �ۼ����̸� (�ۼ��ѽð�) : ��۳��� </p> -->
	<p>
	<%= comment.getCommenterName() %> : (<%=comment.getCommentDate() %>) :
	<%= comment.getCommentText() %>
	</p>
	<% 				
			}
		}
	%>
	<form action="AddCommerServlet" method="post">
	<!--  ���� �߰� �� �ۼ� -->
		<input type="hidden" name="productId" value="<%=product.getProductId() %>"><br>
		
		<label for = "commentName">�̸� :</label>
		<input type="text" name="commentName" required>
		
		<label for="commentText">��� ���� :</label>
		<textarea name="commentText" required></textarea>
		<br>
		
		<input type="submit" value="����߰�">		
	
	</form>
</body>
</html>