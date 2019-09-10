<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- Bootstrap DatePicker CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.standalone.min.css"/>
	<!-- Custom CSS -->
	

<title>Merit Bank | Update Profile</title>
</head>
<body>

	<section class="add-form mt-5">
	
		<div class="d-flex justify-content-center align-items-center container">
			<div class="form-group row">
				<div class="col-sm-12">
					<h2>Update Profile Information</h2>
				</div>
			</div>
		</div>
	
		<div class="main-box col-md-6 d-flex justify-content-center align-items-center">
			
			<form:form class="form-row" action="/updateProfile" method="POST" modelAttribute="user">
				<input type="hidden" name="_method" value="put">
				
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
						<form:input path="ssn" type="text" class="form-control" id="ssn" placeholder="SSN Number"/>
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


			  	<div class="form-group col-md-6">
			    	<label for="userAddress.street">Address</label>
			    	<form:input path="userAddress.street" type="text" class="form-control" id="street" placeholder="1234 Main St"/>
			    	<form:errors path="userAddress.street" class="errors"/>
			  	</div>
			  	
			  	<div class="form-group col-md-6">
			    	<label for="userAddress.street2">Address 2</label>
			    	<form:input path="userAddress.street2" type="text" class="form-control" id="street2" placeholder="Apartment, studio, or floor"/>
			    	<form:errors path="userAddress.street2" class="errors"/>
			 	</div>

			    <div class="form-group col-md-6">
			      <label for="userAddress.city">City</label>
			      <form:input path="userAddress.city" type="text" class="form-control" id="city" placeholder="City"/>
			      <form:errors path="userAddress.city" class="errors"/>
			    </div>
				    
			    <div class="form-group col-md-4">
			      <label for="userAddress.state">State</label>
			      <form:select path="userAddress.state" type="text" class="custom-select">
			        <option selected>${userAddress.state}</option>
					  	<option value="AL">Alabama</option>
						<option value="AK">Alaska</option>
						<option value="AZ">Arizona</option>
						<option value="AR">Arkansas</option>
						<option value="CA">California</option>
						<option value="CO">Colorado</option>
						<option value="CT">Connecticut</option>
						<option value="DE">Delaware</option>
						<option value="DC">District Of Columbia</option>
						<option value="FL">Florida</option>
						<option value="GA">Georgia</option>
						<option value="HI">Hawaii</option>
						<option value="ID">Idaho</option>
						<option value="IL">Illinois</option>
						<option value="IN">Indiana</option>
						<option value="IA">Iowa</option>
						<option value="KS">Kansas</option>
						<option value="KY">Kentucky</option>
						<option value="LA">Louisiana</option>
						<option value="ME">Maine</option>
						<option value="MD">Maryland</option>
						<option value="MA">Massachusetts</option>
						<option value="MI">Michigan</option>
						<option value="MN">Minnesota</option>
						<option value="MS">Mississippi</option>
						<option value="MO">Missouri</option>
						<option value="MT">Montana</option>
						<option value="NE">Nebraska</option>
						<option value="NV">Nevada</option>
						<option value="NH">New Hampshire</option>
						<option value="NJ">New Jersey</option>
						<option value="NM">New Mexico</option>
						<option value="NY">New York</option>
						<option value="NC">North Carolina</option>
						<option value="ND">North Dakota</option>
						<option value="OH">Ohio</option>
						<option value="OK">Oklahoma</option>
						<option value="OR">Oregon</option>
						<option value="PA">Pennsylvania</option>
						<option value="RI">Rhode Island</option>
						<option value="SC">South Carolina</option>
						<option value="SD">South Dakota</option>
						<option value="TN">Tennessee</option>
						<option value="TX">Texas</option>
						<option value="UT">Utah</option>
						<option value="VT">Vermont</option>
						<option value="VA">Virginia</option>
						<option value="WA">Washington</option>
						<option value="WV">West Virginia</option>
						<option value="WI">Wisconsin</option>
						<option value="WY">Wyoming</option>
					</form:select>
					<form:errors path="userAddress.state" class="errors"/>
			    </div>
				    
			    <div class="form-group col-md-2">
			      <label for="userAddress.zipcode">Zipcode</label>
			      <form:input path="userAddress.zipcode" type="text" class="form-control" id="zipcode" placeholder="Zipcode"/>
			      <form:errors path="userAddress.zipcode" class="errors"/>
			    </div>
				    
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</section>
	

<!--  
<h1>Update Profile and add address</h1>
<form:form action="/updateProfile" method="POST" modelAttribute="user">
	<input type="hidden" name="_method" value="put">
	<p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="userName">User Name</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
    <p>
        <form:label path="password">Password</form:label>
        <form:errors path="password"/>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="dateOfBirth">dateOfBirth</form:label>
        <form:errors path="dateOfBirth"/>
        <form:input path="dateOfBirth"/>
    </p>
    <p>
        <form:label path="ssn">Social Security Number</form:label>
        <form:errors path="ssn"/>
        <form:input path="ssn"/>
    </p>
    <p>
        <form:label path="primaryPhone">Primary Phone</form:label>
        <form:errors path="primaryPhone"/>
        <form:input path="primaryPhone"/>
    </p>
    <p>
        <form:label path="secondaryPhone">Secondary Phone</form:label>
        <form:errors path="secondaryPhone"/>
        <form:input path="secondaryPhone"/>
    </p>
    <p>
        <form:label path="userAddress.street">street</form:label>
        <form:errors path="userAddress.street"/>
        <form:input path="userAddress.street"/>
    </p>
    <p>
        <form:label path="userAddress.street2">street2</form:label>
        <form:errors path="userAddress.street2"/>
        <form:input path="userAddress.street2"/>
    </p>
    <p>
        <form:label path="userAddress.city">city</form:label>
        <form:errors path="userAddress.city"/>
        <form:input path="userAddress.city"/>
    </p>
    <p>
        <form:label path="userAddress.state">state</form:label>
        <form:errors path="userAddress.state"/>
        <form:input path="userAddress.state"/>
    </p>
    <p>
        <form:label path="userAddress.zipcode">zipcode</form:label>
        <form:errors path="userAddress.zipcode"/>
        <form:input path="userAddress.zipcode"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
 
 -->
 
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