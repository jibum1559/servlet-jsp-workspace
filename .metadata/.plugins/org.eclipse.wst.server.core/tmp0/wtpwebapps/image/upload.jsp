<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�̹��� ���ε�</title>
</head>
<body>
	<h1>�̹��� ���ε�</h1>
	
	<!--
		* action = �� �����Ͱ� ����� �� �ش� �����͸� ó���� ������ �����ϴ� �Ӽ�, ������ �������� �� �����Ͱ� ����
		* method = "post" �������͸� ������ ������ �� ����� HTTP �޼��带 �����ϴ� �Ӽ�
		* anctype = �� �����Ͱ� ���� ���ε�� ���� ���̳ʸ� �����͸� ������ �� ���Ǵ� ���ڵ� Ÿ���� �����ϴ� �Ӽ�
					multipart/form-data ���� ���ε带 ���� ǥ�� ���ڵ� ���
										�����̳� �Ϲ� �ؽ�Ʈ�� �Բ� ������ �� ����
	 -->
	<form action="UploadServlet" method="Post" enctype="multipart/form-data">
		<label for="title">����</label>
		<input type="text" name="title" id="title" required><br>
		<label for="content">����</label>
		<input type="text" name="content" id="content" required><br>
		
		<label>�̹��� :</label>
		<input type="file" name="image" id="image" required><br>
		
		<button type="submit">���ε�</button>
		
		
	</form>
</body>
</html>