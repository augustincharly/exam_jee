<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Page de login</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<h1 class="text-center my-5">Bienvenue
		${sessionScope.user.getFullName()}</h1>
	<br />
	<c:if test="${sessionScope.user.getRole().equals('admin')}">
		<div class="container">
			<a href="<%=request.getContextPath() + "/admin/create_user"%>" class="btn btn-primary">Ajouter un utilisateur</a>
		</div>
		</c:if>
	<div class="container d-flex">
		

		<c:forEach items="${users}" var="u">
			<div class="card m-3" style="width: 18rem;">
				<img class="card-img-top" src="${ u.getImage_url()}"
					alt="Card
				image cap">
				<div class="card-body">
					<h5 class="card-title">${u.getFullName()}</h5>
					<p class="card-text">
						date d'entrée : ${u.getEnteredAt()} <br />téléphone :
						${u.getNumber()} <br /> <a
							href="<%=request.getContextPath() + "/dashboard/show_user?id="%>${u.getId()}">Détails</a>
					</p>
				</div>
			</div>

		</c:forEach>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>