<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

	<title>Merit Bank | Dashboard</title>
	
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- Custom CSS -->
	<link rel='stylesheet' href='/CSS/main-styles.css' />
	<link rel='stylesheet' href='/CSS/header-styles.css'/>
	<link rel='stylesheet' href='/CSS/box-styles.css' />

</head>
<body>
	
	<c:out value="${error}"/>
	
	<!-- Header Section -->
	<section class="container-fluid container-header">
		<div class="site-header">
			<div class="row justify-content-md-center">
				<div class="col-md-auto mt-2">
					<img src="Images/MeritBank_MD_HorzW.png" alt="Company Logo">
				</div>
			</div>
		</div>
	</section>
	
	
	<!-- NavBar Section -->
    <section class="container-fullwidth">
        <!-- Top Nav Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto nav-pills">
                    <li class="nav-item active">
                        <a class="nav-link" href="/accounts">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/updateProfile">Settings</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-sub pull-right">
                    <li class="nav-item">
                    	<a class="nav my-2" href="/logout">Logout</a>
                    </li>                    
                </ul>
            </div>
        </nav>
    </section>

	<!-- Horizontal Tab Navigation Section --> 
    <section class="container-fluid">
    
		<div class="row mt-3">
			<div class="col-2">
			  <ul class="nav flex-column nav-tabs">
			  	<li class="inactive"><a href="/accounts">Accounts</a></li>
			  	<li class="inactive"><a href="/accountsInv">Investments</a></li>
			  	<li class="active"><a href="/cdRate">CD Rates</a></li>
			  </ul>
		  	</div>
		  	
		  
		  <div class="col-10">
		    <div class="tab-content" id="v-pills-tabContent">		    		    
		      <div class="tab-pane fade show active" id="v-pills-accounts" role="tabpanel" aria-labelledby="v-pills-accounts-tab">
				
				<div class="container">
					<div class="row d-flex justify-content-center">
						<div class="col col-md-4 d-flex align-items-stretch">
							<div class="card shadow mb-3" style="width: 25rem;">
							  	<div class="card-header">
							    	<h4 class="font-weight-light">Principle Deposit</h4>
							  	</div>
								<div class="card-body">
								    
								    <br>
										<form:form class = "formMargin" action="/calculate_earnings" method="post" modelAttribute="CalculateEarnings">
										<label>Opening Deposit</label>
										  <div class="input-group mb-3">
										  <div class="input-group-prepend">
										    <span class="input-group-text">$</span>
										  </div>
										  	<form:input path="amount" type="number"  class="form-control"  placeholder="Opening Deposit" aria-label="Amount (to the nearest dollar)"/>
											<form:errors path="amount" />
										  <div class="input-group-append">
										  </div>
										</div>
										  <div class="form-group">
										    <label for="exampleInputPassword1">Months</label>
										    <form:select path="month" id="months" class="form-control">
											</form:select>
										  </div>
										  
										    <button class="btn btn-primary mr-2">Calculate Earnings</button>
										</form:form>
									<br>
								    
								    
								</div>
							</div>
						</div>
						<div class="col col-md-4 d-flex align-items-stretch">
							<div class="card shadow mb-3" style="width: 25rem;">
							  	<div class="card-header">
							    	<h4 class="font-weight-light">Estimated Earnings</h4>
							  	</div>
								<div class="card-body">
								    
								    <h5 class="card-title">Here are your earnings with the options you selected!</h5>
								    <p id="earnings">${earnings} USD at Rate : ${interestRate} % for ${CalculateEarnings.month} months</p>
								    <a href="/accounts" class="btn btn-primary">Create Account</a>
								    <br>
								    
								    
								</div>
							</div>
						</div>
					</div>
				</div>

		      </div>
		      
		      <span class="errors"><c:out value="${error}"/></span>
		       
		    </div>
		  </div>
		</div>
 
    </section>
    


	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<!-- jQuery for account summary -->
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/83141/jquery.maskedinput.min.js'></script>
	<!-- Custom JS -->
	<script type="text/javascript" src="/JavaScript/dashboard.js"></script>
	<!-- Font Awesome -->
	<script src="https://kit.fontawesome.com/a6aa666e27.js"></script>

	<script>
	for(var i=2; i<=120; i+=2){
	    var select = document.getElementById("months");
	    var option = document.createElement("OPTION");
	    select.options.add(option);
	    option.setAttribute("id", "month");
	    option.text = i + " Months";
	    option.value = i;
	    if(i >= 12){
	    	i+=10;
	    }
	}
	</script>



</body>
</html>