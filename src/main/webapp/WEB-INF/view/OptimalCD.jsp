<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>CD Rate</title>
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
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="/accounts">Dashboard</a>
                    </li>
                    <li class="nav-item active">
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
<div class="row mt-3 background">
 <nav class="col-md-2 d-none d-md-block sidebar tr">
<div class="sidebar-sticky stickypositioning">
<div class="center">
</div>
<div class="center">
<div class="hide">
<br>
<form class = "formMargin">
<label>Opening Deposit</label>
  <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text">$</span>
  </div>
  <input id="amount" type="number" class="form-control" step="0.01" aria-label="Amount (to the nearest dollar)">
  <div class="input-group-append">
  </div>
</div>
  <div class="form-group">
    <label for="exampleInputPassword1">Months</label>
    <select id="months" class="form-control">
</select>
  </div>
  <fieldset disabled>
    <div class="form-group">
      <label>Interest Rate</label>
      <div class="input-group mb-3">
       <div class="input-group-prepend">
    <span class="input-group-text">%</span>
  </div>
      <input type="text" id="disabled" class="form-control" readonly="readonly">
    </div>
    </div>
    </fieldset>
    </form>
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
    <p id="earnings">.</p>
    <a href="#" class="btn btn-primary">Create Account</a>
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
$('#months').change(function(){
	var deposit = document.getElementById("amount");
	var months = document.getElementById("months");
	var showInterest = document.getElementById("disabled");
	showInterest.value = (this.value * deposit.value / 1000) / 1000;
	var x = showInterest.toFixed(2);
	showInterest.value = x;
	var inr=deposit*months*showInterest;
	var inrst = inr/100;
});
function optimalCd2(deposit, months, rate){
	var percentage = (rate/100);
	var result = deposit;
	for(var i = 0; i < months / 12; i++){
		if(result == deposit){
			result += deposit * percentage;
		}
		else if(result != deposit){
			result += result * percentage;
		}
	}
	var trim = result - deposit;
	var x = trim.toFixed(2);
	return trim;
}
function optimalCd() {
	var deposit = document.getElementById("amount");
	var months = document.getElementById("months");
	var showInterest = document.getElementById("disabled");
	var inr=optimalCd2(deposit.value, months.value, showInterest.value);
	var x = inr.toFixed(2)
		var inrst = x/100;
		document.getElementById("earnings").innerHTML= inrst;
}
window.onchange = optimalCd;
</script>
</body>
</html>