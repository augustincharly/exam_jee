<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Erreur 404</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
<%@ include file="navbar.jsp"%>
	<div class="jumbotron jumbotron-fluid Aligner">
		<div class="container text-center Aligner-item">
			<h1 class="display-4">Erreur 404</h1>
			<p class="lead">ressource non trouvée</p>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>