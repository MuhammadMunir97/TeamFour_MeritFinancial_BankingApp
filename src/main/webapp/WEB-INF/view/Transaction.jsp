<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<title>Account Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel='stylesheet' href='/CSS/trstyle.css' />
<link rel='stylesheet' href='/CSS/header-styles.css'/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body onload="hideTransactionField()">
<c:out value="${message}" />
<div class="background">
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
    <div class="row">
    <nav class="col-md-2 d-none d-md-block sidebar tr">
<div class="sidebar-sticky stickypositioning">
<div class="center">
<br>
<button type="button" class="btn btn-primary btn-lg transactionButton formMargin" onclick="transactionShow()">Make a Transaction</button>
</div>
<div class="center">
<div class="hide">
<br>
<form:form class="formMargin" action="/accounts/${account.id}" method="POST" modelAttribute="tranasction">
<span class="errors"><c:out value="${error}"/></span>
<div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:errors class="errors" path="amount"/>
        <form:input class="form-control input-lg" placeholder="Enter Amount" path="amount"/>
        </div>
        <div class="form-group dropdown">
	<form:select class="form-control" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" path="transactionType" onchange="transactionCheck(this)">
		<c:forEach items="${transactionTypes}" var="type">
			 <form:option value="${type.id}">
			 	${type.transactionTypeName}
			 </form:option>
    	</c:forEach>
	</form:select>
	</div>
	<div class="form-group">
	<div class="ifTransaction">
        <form:label class="translabel" path="AccountInternalTransferTo">Account Number</form:label>
        <form:errors class="errors" path="AccountInternalTransferTo"/>
        <form:input class="form-control input-lg" placeholder="Enter Account Number" path="AccountInternalTransferTo"/>
    </div>
    </div>
    <input class="btn btn-primary btn-lg" type="submit" value="Done"/>
</form:form>
<br>
</div>
</div>
</div>
</nav>   
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">	
    <br>
		      	<div class="card ml-3">
				  	<div class="card-header">
				    	<h4 class="font-weight-light">Summary</h4>
				  	</div>
					<div class="card-body">
					    <div class="table-responsive">
<table class="table table-sm">
    <thead>
        <tr>
            <th class="accountTableColor"><h3>Account Number</h3></th>
            <th class="accountTableColor"><h3>Present Balance</h3></th>
            <th class="accountTableColor"><h3>Account Type</h3></th>
        </tr>
    </thead>
    <tbody>
       <tr>
       	<td class="accountInfo"><c:out value="${account.accountNumber}"/></td>
       	<td class="accountInfo">$ <c:out value="${account.presentBalance}"/></td>
       	<td class="accountInfo"><c:out value="${account.accountType.accTypeName}"/></td>
       </tr>
    </tbody>
</table>
</div>
					</div>
				</div>
<!-- <div class="table-responsive">
<table class="table table-sm">
    <thead>
        <tr>
            <th class="accountTableColor"><h3>Account Number</h3></th>
            <th class="accountTableColor"><h3>Present Balance</h3></th>
            <th class="accountTableColor"><h3>Account Type</h3></th>
        </tr>
    </thead>
    <tbody>
       <tr>
       	<td class="accountInfo"><c:out value="${account.accountNumber}"/></td>
       	<td class="accountInfo"><c:out value="${account.presentBalance}"/></td>
       	<td class="accountInfo"><c:out value="${account.accountType.accTypeName}"/></td>
       </tr>
    </tbody>
</table>
</div> -->
<br>
<div class="card ml-3">
				  	<div class="card-header">
				    	<h4 class="font-weight-light">Transactions</h4>
				  	</div>
					<div class="card-body">
					    <div class="table-responsive">
<table class="table table-striped">
    <thead>
        <tr>
            <th class="accountTableColor2"><h3>Transaction Type</h3></th>
            <th class="accountTableColor2"><h3>Amount</h3></th>
            <th class="accountTableColor2"><h3>Date</h3></th>
        </tr>
    </thead>
    <tbody>
	    <c:forEach items="${account.transactionLogs}" var="transaction">
			<tr>
				<td><c:out value="${transaction.transactionType.transactionTypeName}"/></td>
				<td>$ <c:out value="${transaction.amount}"/></td>
				<td><c:out value="${transaction.postDate}"/></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
</div>
</div>
</div>
</main>
<br>
<div class="noShow center container">
<br>
<button type="button" class="btn btn-primary btn-lg transactionButton" onclick="transactionShow()">Make a Transaction</button>
<div class="center">
<div class="hide">
<br>
<form:form class="formMargin" action="/accounts/${account.id}" method="POST" modelAttribute="tranasction">
<span class="errors"><c:out value="${error}"/></span>
<div class="form-group">
        <form:label path="amount">Amount</form:label>
        <form:errors class="errors" path="amount"/>
        <form:input class="form-control input-lg" placeholder="Enter Amount" path="amount"/>
        </div>
        <div class="form-group dropdown">
	<form:select class="form-control" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" path="transactionType" onchange="transactionCheck(this)">
		<c:forEach items="${transactionTypes}" var="type">
			 <form:option value="${type.id}">
			 	${type.transactionTypeName}
			 </form:option>
    	</c:forEach>
	</form:select>
	</div>
	<div class="form-group">
	<div class="ifTransaction">
        <form:label class="translabel" path="AccountInternalTransferTo">Account Number</form:label>
        <form:errors class="errors" path="AccountInternalTransferTo"/>
        <form:input class="form-control input-lg" placeholder="Enter Account Number" path="AccountInternalTransferTo"/>
    </div>
    </div>
    <input class="btn btn-primary btn-lg" type="submit" value="Done"/>
</form:form>
<br>
</div>
</div>
</div>
</div>
<br>
</div>
<script>
$( ".hide" ).hide();
$( ".transactionButton" ).click(function( event ) {
  event.preventDefault();
  $( ".hide" ).show("slow");
});
function hideTransactionField(){
	$(".ifTransaction").hide();
	$(".transLabel").hide();
	$(".hide").hide();
}
function transactionCheck(that) {
	if (that.value == "3") {
        $(".ifTransaction").show("slow");
        $(".transLabel").show("slow");
    } else {
    	$(".ifTransaction").hide("slow");
    	$(".transLabel").hide("slow");
    }
}
</script>
<script src="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"></script>
<script src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>