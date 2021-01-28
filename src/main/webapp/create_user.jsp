<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Admin - utilisateurs - ajout</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<%@ include file="navbar.jsp"%>
	

	<div class="Aligner" style="height: 100%">
	
	<form class="container formulaire Aligner-items" method="post"
		enctype="multipart/form-data">
		<h2 class="text-center my-5">Ajout d'un utilisateur</h2>
		<div class="form-group">
			<input class="form-control" type="text" id="login" name="login"
				placeholder="login" autofocus="true">
		</div>
		<div class="form-group">
			<input class="form-control" type="text" id="password" name="password"
				placeholder="password">
		</div>
		<div class="form-group">
			<input class="form-control" type="text" id="lastname" name="lastname"
				placeholder="lastname">
		</div>
		<div class="form-group">
			<input class="form-control" type="text" id="firstname"
				name="firstname" placeholder="firstname">
		</div>
		<div class="form-group">
			<input class="form-control" type="date" id="entered_at"
				name="entered_at" placeholder="entered_at">
		</div>
		<div class="form-group">
			<input class="form-control" type="text" id="number" name="number"
				placeholder="number">
		</div>
		<div class="form-group">
			<select class="form-control" name="role" id="role">
				<option value="user">user</option>
				<option value="admin">admin</option>
			</select>
		</div>
		<div class="form-group">
			<div>image</div>
			<input type="file" accept="image/jpeg" class="form-control"
				id="image" name="image" placeholder="Veuillez upload un fichier">
		</div>
		<button type="submit" class="btn btn-success btn-block mx-auto">Ajouter</button>

		<div>
			<a class="btn btn-info btn-block mt-3"
				href="<%=request.getContextPath() + "/list_users"%>">precedent</a>
		</div>

	</form>
	</div>
	

	<%@ include file="footer.jsp"%>
</body>
</html>
>
