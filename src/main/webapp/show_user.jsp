<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Détails de l'utilisateur</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>
	<%@ include file="navbar.jsp"%>
	<div class="Aligner" style="height: 100%">
		<div class="card m-3 Aligner-items" style="width: 18rem;">
			<img class="card-img-top" src="${user.getImage_url()}"
				alt="Card
				image cap">
			<div class="card-body">
				<h5 class="card-title">${user.getFullName()}</h5>
				<p class="card-text">
					date d'entrée : ${user.getEnteredAt()} <br />téléphone :
					${user.getNumber()}
				</p>
			</div>
			<div>
				<a class="btn btn-primary btn-block" href="<%=request.getContextPath()+"/dashboard" %>">Retour</a>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>