<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<iframe src="http://172.30.1.17:8081/Podo/Book2.jsp" allow="autoplay *" width="100%" height="1000px"></iframe>

<%
	response.setHeader("Feature-Policy", "autoplay *");

%>

</body>
</html>