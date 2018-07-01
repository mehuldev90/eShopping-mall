<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Mehul Maldahiyar">

<title>eShoppingMall - ${title}</title>

<script>
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<link href="${css}/jquery.dataTables.css" rel="stylesheet">


</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="${contextRoot}/home">Online
				Shopping</a>
		</div>
	</nav>

	<!-- Page Content -->

	<div class="container">
		<!-- If the credentials are wrong -->
		<c:if test="${not empty message}">
			
			<div class="row">
				
				<div class="col-md-6 offset-3">
					
					<div class="alert alert-danger">${message}</div>
					
				</div>
				
			</div>
		
		</c:if>
		
		<!-- If the user has logout-->
		<c:if test="${not empty logout}">
			
			<div class="row">
				
				<div class="col-md-6 offset-3">
					
					<div class="alert alert-success">${logout}</div>
					
				</div>
				
			</div>
		
		</c:if>
		
		<div class="content">

			<div class="row">

				<div class="col-md-6 offset-md-3">

					<div class="mt-4 card">

						<div class="card-header">
							<h4>Login</h4>
						</div>

						<div class="card-body">
							<form action="${contextRoot}/login" method="POST"
								class="form-horizontal" id="loginForm">
								<div class="row form-group">
									<label for="username" class="col-md-4 control-label">Email:
									</label>
									<div class="col-md-8">
										<input type="text" name="username" id="username" class="form-control" />
									</div>
								</div>
								<div class="row form-group">
									<label for="password" class="col-md-4 control-label">Password:
									</label>
									<div class="col-md-8">
										<input type="password" name="password" id="password" class="form-control" />
									</div>
								</div>
								
								<div class="row form-group">
									<div class="col-md-8 offset-4">
										<input type="submit" value="Login" class="btn btn-primary" />
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									</div>
								</div>
								
							</form>

						</div>
						<div class="card-footer">
							<div class="text-right">
								New User - <a href="${contextRoot}/register">Register Here</a>
							</div>
						</div>
						

					</div>

				</div>

			</div>

		</div>

	</div>


	<!-- /.container -->


	<!-- Footer -->
	<%@include file="./shared/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/jquery.min.js"></script>

	<!-- jquery validator -->
	<script src="${js}/jquery.validate.js"></script>

	<script src="${js}/bootstrap.bundle.min.js"></script>

	<script src="${js}/myapp.js"></script>

</body>

</html>
