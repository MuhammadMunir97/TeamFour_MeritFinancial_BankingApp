<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>

	<title>Merit Bank | Transaction Details</title>

	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- jQuery to initiate transaction controls -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<!-- Custom CSS -->
	<link rel='stylesheet' href='/CSS/trstyle.css' />
	<link rel='stylesheet' href='/CSS/header-styles.css'/>

</head>
<body class="background" onload="hideTransactionField()">

<c:out value="${message}" />

	<!-- Header Section -->
	<section class="container-fluid container-header">
		<div class="site-header">
			<div class="row justify-content-md-center">
				<div class="col-md-auto mt-2">
					<img src="/Images/MeritBank_MD_HorzW.png" alt="Company Logo">
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
                     <li class="nav-item">
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
    
    
    <section class="container-fluid mb-4">
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
			</nav>  
	
	    	<section role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">	
		      	<div class="card ml-3 mt-4">
				  	<div class="card-header">
				    	<h4 class="font-weight-light"><c:out value="${account.accountType.accTypeName}"/> <c:out value="...(${account.accountNumber})"/></h4>
				  	</div>
					<div class="card-body">
					    <div class="table-responsive">
							<table class="table table-sm">
							    <thead>
							        <tr>
							        	<th class="accountTableColor">Total Deposits</th>
							            <th class="accountTableColor">Total Withdraws</th>
							            <th class="accountTableColor">Present Balance</th>						            
							        </tr>
							    </thead>
							    <tbody>
							       <tr>
							       	<td class="accountInfo">					   
										<c:set var="total" value="${0}"/>
										<c:forEach var="transaction" items="${account.transactionLogs}">										
											<c:if test="${transaction.amount > 0}">
										    	<c:set var="total" value="${total + transaction.amount}" />
										    </c:if>									    
										</c:forEach>
										+ <fmt:formatNumber type="currency" maxIntegerDigits="12" value="${total}" />
							       	</td>
							       	<td class="accountInfo">
							       		<c:set var="total" value="${0}"/>
										<c:forEach var="transaction" items="${account.transactionLogs}">
												<c:if test="${transaction.amount < 0}">
										    	<c:set var="total" value="${total + transaction.amount}" />
										    </c:if>									    
										</c:forEach>
										<fmt:formatNumber type="currency" maxIntegerDigits="12" value="${total}" />
							       	</td>
							       	<td class="accountInfo"><fmt:formatNumber type="currency" maxIntegerDigits="12" value="${account.presentBalance}" /></td>						  
							       </tr>
							    </tbody>
							</table>
						</div>
					</div>
				</div>
				
					
				<div class="card ml-3 mt-4">
				  	<div class="card-header">
				    	<h4 class="font-weight-light">Transaction Detail</h4>
				  	</div>
					<div class="card-body">
					    <div class="table-responsive">
							<table class="table table-sm table-hover">
							    <thead class="thead-dark">
							        <tr>
							            <th scope="col">Transaction Type</th>
							            <th scope="col">Amount</th>
							            <th scope="col">Date</th>
							        </tr>
							    </thead>
							    <tbody>
								    <c:forEach items="${account.transactionLogs}" var="transaction">
										<tr>
											<td scope="row"><c:out value="${transaction.transactionType.transactionTypeName}"/></td>
											<td scope="row"><fmt:formatNumber type="currency" maxIntegerDigits="12" value="${transaction.amount}" /></td>
											<td scope="row"><fmt:formatDate pattern="MM-dd-yyyy hh:mm a" value="${transaction.postDate}"/></td>
										</tr>
									</c:forEach>
							    </tbody>
							</table>
						</div>
					</div>
				</div>
			</section>
				
				
		</div>	
	</section>



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
	<!-- Bootstrap JS -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>