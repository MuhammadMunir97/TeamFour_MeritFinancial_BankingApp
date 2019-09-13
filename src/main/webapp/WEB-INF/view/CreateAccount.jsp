<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>

	<title>Merit Bank | Registration</title>
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- Bootstrap DatePicker CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.standalone.min.css"/>
	<!-- Custom CSS -->
	<link rel='stylesheet' href='CSS/main-styles.css' />
	<link rel='stylesheet' href='header-styles.css'/>
	<link rel='stylesheet' href='CSS/box-styles.css' />
	<link rel='stylesheet' href='CSS/footer-styles.css' />

</head>
<body>
	
	<div class="registration-section">		
		<!-- Registration Container Main Background -->
	    <div class="container col-md-8 registration-container">
	        <!-- Registration Form Group -->
			<form:form class="form-row" action="/create_account" method="POST" modelAttribute="user">
			
				<!-- company Logo and Title -->
				<div class="container">
					<div class="row justify-content-md-center">
						<div class="col-md-auto">
							<img class="logo mb-2" src="Images/MeritBank_MD_Vert.png" alt="Company Logo">
	           				<h4 class="mb-4 font-weight-light">New User Account Registration</h4>
						</div>
					</div>
				</div>
	        	
				
				<!-- Registration Form Capture Fields -->	
				<div class="form-row">
					<div class="form-group col-md-3">
						<label for="firstName">First Name</label>
						<form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="First Name"/>
						<form:errors path="firstName" class="errors"/>
					</div>
					
					<div class="form-group col-md-3">
						<label for=lastName>Last Name</label>
						<form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="Last Name"/>
						<form:errors path="lastName" class="errors"/>
					</div>
					
					<div class="form-group col-md-3">
						<label for=dateOfBirth>Date of Birth</label>
						<div class="input-group">
						    <form:input type="text" path="dateOfBirth" class="form-control" id="datepicker" placeholder="mm-dd-yyyy" data-date-today-Btn="linked" data-date-autoclose="true"></form:input>
						    <form:errors path="dateOfBirth" class="errors"/>
						    <div class="input-group-append">
						    	<div class="input-group-text"><span><i class="fas fa-calendar-alt fa-lg"></i></span></div>
						    </div>
						</div>
					</div>
					
					<div class="form-group col-md-3">
						<label for=ssn>SSN Number</label>
						<form:input path="ssn" type="text" class="form-control" id="ssn" placeholder="XXX-XX-XXXX"/>
						<form:errors path="ssn" class="errors"/>
					</div>
			
					<div class="form-group col-md-3">
						<label for=userName>Username</label>
						<form:input path="userName" type="text" class="form-control" id="userName" placeholder="Username"/>
						<form:errors path="userName" class="errors"/>
					</div>
					
					<div class="form-group col-md-3">
						<label for=password>Password</label>
						<form:input path="password" type="password" class="form-control" id="password" placeholder="Password"/>
						<form:errors path="password" class="errors"/>
					</div>
					
					<div class="form-group col-md-6">
			    		<label for="email">Email Address</label>
			    		<form:input path="email" type="text" class="form-control" id="email" placeholder="Email Address"/>
			    		<form:errors path="email" class="errors"/>
			  		</div>
	
				</div>
				
				
				<div class="register-btn">
	                <button class="btn btn-primary mr-2">Register User</button>
	            </div>
	            
	            <div class="back2login-btn">
	                <a class="btn btn-primary" href="/login">Back to Login</a>
	            </div>
	            
				
			</form:form>
	    </div>
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
			<li><a href="#">Jose Caridad</a></li>
			<li><a href="#">Robert Scott</a></li>
			<li><a href="#">Muhammad Munir</a></li>
			<li><a href="https://www.linkedin.com/in/vitranm/">Vi Tran</a></li>
		</ul>
	</footer>
	
	
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- Bootstrap DatePicker JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
	<!-- Custom JS for DatePicker -->
	<script type="text/javascript" src="JavaScript/date_ssn_app.js"></script>
	<!-- Font Awesome -->
	<script src="https://kit.fontawesome.com/a6aa666e27.js"></script>
	
 
</body>
</html>