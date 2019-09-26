<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Merit Bank | CD Rates</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel='stylesheet' href='/CSS/trstyle.css' />
<link rel='stylesheet' href='/CSS/header-styles.css'/>
<link rel='stylesheet' href='/CSS/cdstyle.css'/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="background">
<section class="container-fluid container-header">
		<div class="site-header">
			<div class="row justify-content-md-center">
				<div class="col-md-auto mt-2">
					<img src="/Images/MeritBank_MD_HorzW.png" alt="Company Logo">
				</div>
			</div>
		</div>
	</section>
<section class="container-fullwidth">
        <!-- Top Nav Bar -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light shadow">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto nav-pills">
                    <li class="nav-item">
                        <a class="nav-link" href="/accounts">Dashboard</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/updateProfile">Settings</a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/cdRate">Predict CD Earnings</a>
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
<div class="row mt-3 background">
 <nav class="col-md-2 d-none d-md-block sidebar tr">
<div class="sidebar-sticky stickypositioning">
<div class="center">
</div>
<div class="center">
<div class="hide">
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
</nav>  
		  <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
<div class="card text-center">
  <div class="card-header">
    Earnings
  </div>
  <div class="card-body">
    <h5 class="card-title">Here are your earnings with the options you selected!</h5>
    <p id="earnings">${earnings} USD at Rate : ${interestRate} % for ${CalculateEarnings.month} months</p>
    <a href="/accounts" class="btn btn-primary">Create Account</a>
    <br>
</div>
</div>
</main>
</div>
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