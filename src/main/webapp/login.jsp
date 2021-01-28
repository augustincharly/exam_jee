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
	<div class="Aligner" style="height: 100%">
		<div class="container formulaire mt-5 Aligner-items">
			<form method="post" class="my-4 mx-4">
				<div class="form-group">
					<label for="login">Login</label> <input autofocus="true"
						type="text" name="user" class="form-control" id="login"
						aria-describedby="loginHelp" placeholder="Inserez votre login">
					<small id="loginHelp" class="form-text text-muted">Ne
						partagez vos informations qu'avec des tiers de confiance.</small>
				</div>
				<div class="form-group">
					<label for="password">Mot de passe</label> <input type="password"
						class="form-control" name="password" id="password"
						placeholder="Mot de Passe">
				</div>
				<button type="submit" class="btn btn-block btn-primary mt-3">Connexion</button>
			</form>
			<c:if test="${errors != null }">
				<c:forEach items="${errors}" var="error">
					<div class="alert alert-danger" role="alert">${error}</div>
				</c:forEach>

			</c:if>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>