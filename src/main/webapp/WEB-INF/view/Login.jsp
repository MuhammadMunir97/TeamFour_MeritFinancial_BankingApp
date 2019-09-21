<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	
	<title>Merit Bank | Login</title>
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- Custom CSS -->
	<link rel='stylesheet' href='/CSS/main-styles.css' />
	<link rel='stylesheet' href='/CSS/box-styles.css' />
	<link rel='stylesheet' href='/CSS/footer-styles.css' />
	
</head>
<body>

	<!-- Login Container Main Background -->
    <div class="login-container d-flex align-items-center justify-content-center">
        <form:form class="login-form text-center" action="/login" method="POST">

            <!-- Logo and Title -->
            <img class="logo mb-5" src="Images/MeritBank_MD_Vert.png" alt="Company Logo">
            
            <h4 class="mb-4 font-weight-light">Welcome</h4>

            <!-- Credentials Capture Form Group -->
			<div class="form-group" >
                <span class="errors"><c:out value="${error}"/></span>
            </div>
	
            <div class="form-group">
                <input type="text" class="form-control" name="username" id="username" placeholder="Username">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
            </div>
            <div class="login-btn mb-3">
                <button class="btn btn-primary btn-block">Login</button>
            </div>
            
           	<!-- Registration Group -->
            <div class="d-flex align-items-center justify-content-center border-top">
                <p class="register-now mt-3 font-weight-normal">Don't have an account? <a href="/create_account">Register Now</a>
                </p>
            </div>
        </form:form>
    </div>
	
	<footer class="site-footer">
		<p>
			Copyright &copy;
			<script>
                document.write(new Date().getFullYear());
            </script>
			, Merit Bank
		</p>
		<ul class="team-name">
			<li><a href="https://www.linkedin.com/in/joseacaridad/">Jose Caridad</a></li>
			<li><a href="https://www.linkedin.com/in/robertscott600/">Robert Scott</a></li>
			<li><a href="https://www.linkedin.com/in/muhammad-munir-5b20a9141/">Muhammad Munir</a></li>
			<li><a href="https://www.linkedin.com/in/vitranm/">Vi Tran</a></li>
		</ul>
	</footer>
	
</body>
</html>