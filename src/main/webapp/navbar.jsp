<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<nav class="navbar  navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="<%=request.getContextPath() + "/dashboard"%>">
		Interface de gestion d'utilisateurs</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav ml-auto">
			<c:choose>
				<c:when test="${sessionScope.user != null }">

					<li class="nav-item dropdown "><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Connecté (<c:out
								value="${sessionScope.user.getLogin()}"></c:out>)
					</a>
						<div class="dropdown-menu dropdown-menu-right"
							aria-labelledby="navbarDropdownMenuLink">
							 <a
								class="dropdown-item"
								href="<%=request.getContextPath() + "/logout"%>">Se
								déconnecter</a>
						</div></li>
				</c:when>
				<c:otherwise>
					<li class="nav-item align-right"><a class="nav-link"
						href="<%=request.getContextPath() + "/login"%>">Se connecter</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>