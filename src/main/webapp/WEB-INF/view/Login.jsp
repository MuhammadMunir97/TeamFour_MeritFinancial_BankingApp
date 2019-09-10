<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Merit bank</title>
<link rel='stylesheet' href='CSS/header-styles.css' />
<link rel='stylesheet' href='CSS/main-styles.css' />
<link rel='stylesheet' href='CSS/box-styles.css' />
<link rel='stylesheet' href='CSS/footer-styles.css' />
</head>
<body>
	<!-- <div class="site-header">
        <div class=" site-logo">
            <img src="Images/MeritBankingLogo.png" alt="Merit Banking Logo">
        </div>-->
	</div>
	<p>
		<c:out value="${error}" />
	</p>
	<div class="login-page">

		<div class="logincontainer">

			<div class=" site-logo">
				<img src="Images/MeritBankingLogo.png" alt="Merit Banking Logo">
			</div>
			<div class="login-box">
				<form:form class="loginform" action="/login" method="POST">
					<ul class="toggle-login">
						<li id="login-active"><a href="#login">Log In</a></li>
						<li id="register-tab"><a href="#signup">Sign Up</a></li>
					</ul>
					<div class="login-active-gradient">
						<div class="login-input">
							<label>Username<input type="text" name="username" placeholder="Username" /></label>
							<label>Password<input type="password" name="password" placeholder="Password"></label>
						</div>
						<button>Log in</button>
					</div>
				</form:form>
				<form:form class="registerform" action="/updateProfile"
					method="POST" modelAttribute="user">
					<ul class="toggle-register">
						<li id="login-tab"><a href="#login">Log In</a></li>
						<li id="register-active"><a href="#signup">Sign Up</a></li>
					</ul>
					<div class="register-active-gradient">
						<form:label path="firstName">First Name</form:label>
						<form:errors path="firstName" />
						<form:input type="text" path="firstName" placeholder="First Name" />
						<form:label path="lastName">Last Name</form:label>
						<form:errors path="lastName" />
						<form:input type="text" path="lastName" placeholder="Last Name" />
						<form:label path="email">Email</form:label>
						<form:errors path="email" />
						<form:input type="text" path="email" placeholder="Email" />
						<form:label path="password">Password</form:label>
						<form:errors path="password" />
						<form:input type="password" path="password" placeholder="Password"/>
						<button>Create</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<footer class="site-footer">
		<p>
			Copyright &copy;
			<script>
                document.write(new Date().getFullYear());
            </script>
			, Merit Banking
		</p>
		<ul class="team-name">
			<li><a href="#">Name</a></li>
			<li><a href="#">Name</a></li>
			<li><a href="https://www.linkedin.com/in/vitranm/">Vi Tran</a></li>
			<li><a href="#">Name</a></li>
			<li><a href="#">Name</a></li>
		</ul>
	</footer>
	<script>
        var loginform = document.querySelector('.loginform');
        var registerform = document.querySelector('.registerform');

        document.querySelector('#login-tab').addEventListener('click', function () {
            loginform.style.display = "block";
            registerform.style.display = "none";

        });
        document.querySelector('#register-tab').addEventListener('click', function () {
            loginform.style.display = "none";
            registerform.style.display = "block";

        });
    </script>
</body>
</html>