<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��μ���</title>
<script>
	//3�� �� Ȩ�������� �̵��ϴ� javascript
	setTimeout(function() {
		//�̵��� ������ ��� ����
		window.location.href="home.jsp";
	}, 3000); //3000 = 3��
</script>
</head>
<body>
<!--  �α��� ������ ��� ���ǿ� ����� ����� �̸� �������� -->
<% String memail = (String) session.getAttribute("memail"); %>

	<p> ȯ���մϴ�. <%=memail %> ��!</p>
	<p> 3�� �� Ȩ�������� �̵��մϴ�.</p>
	<p><a href="logout">�α׾ƿ�</a>
</body>
</html>