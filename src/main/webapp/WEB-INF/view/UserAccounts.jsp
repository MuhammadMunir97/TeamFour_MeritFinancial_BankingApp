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
	<!-- Bootstrap DatePicker CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker.standalone.min.css"/>
	<!-- Custom CSS -->
	<link rel='stylesheet' href='/CSS/main-styles.css' />
	<link rel='stylesheet' href='/CSS/header-styles.css'/>
	<link rel='stylesheet' href='/CSS/box-styles.css' />
	<link rel='stylesheet' href='/CSS/footer-styles.css' />

</head>
<body>
	
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


	<!-- Accounts Summary Section -->
	<div class="container-fluid mt-3 my-wallet">
		<div class="loading"></div>

		<div class="add-account-modal">
			<div class="overlay"></div>

			<div class="account new-account">
				<form:form action="/newBankAccount" method="POST" modelAttribute="accountInternal">
					<form:select  path="accountType">
						<c:forEach items="${account_types}" var="type">
							 <form:option value="${type.id}">
							 	${type.accTypeName}
							 </form:option>
				    	</c:forEach>
					</form:select>
				    <input type="submit" value="Submit"/>
				</form:form>
			</div>

		</div>

		<div class="container my-wallet-sidebar">
			<h1 class="my-wallet-title">My Accounts<div class="add-account">&#43;</div></h1>

			<div class="active-account"></div>
			<div class="accounts-container">
				<c:forEach items="${allAccounts}" var="account">
					<div class="account" data-account="${account.id}">
						${account.accountType.accTypeName}
						<p>${account.accountNumber}</p>
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="account-details-container">

			<c:forEach items="${allAccounts}" var="account">
				<div class="account-details" data-account="${account.id}">
					
					
					<div class="account-balance">
						Current Balance
						<div class="value-unit">
							<fmt:formatNumber type="currency" maxIntegerDigits="8" value="${account.presentBalance}" />
						</div>
						
						<div class="more-details">
							<a href="accounts/${account.id}">View More Details</a>
						</div>
						
					</div>
					
					
					<div class="transaction-history">
						<div class="transaction">
							<div class="table-responsive">
								<table class="table table-sm table-hover">
								    <thead class="thead-dark">
								        <tr>
								            <th scope="col">Transaction Type</th>
								            <th scope="col">Amount</th>
								            <th scope="col">Post Date</th>
								        </tr>
								    </thead>
								    <tbody>
									    <c:forEach items="${account.transactionLogs}" var="transaction" varStatus="status">
											<tr>
												<c:if test="${status.count <= 7}">
													<td scope="row"><c:out value="${transaction.transactionType.transactionTypeName}"/></td>
													<td scope="row"><fmt:formatNumber type="currency" maxIntegerDigits="8" value="${transaction.amount}" /></td>
													<td scope="row"><fmt:formatDate pattern="MM-dd-yyyy hh:mm a" value="${transaction.postDate}"/></td>
												</c:if>
											</tr>
										</c:forEach>
								    </tbody>
								</table>
							</div>
						</div>
						
						<form action="accounts/${account.id}" method="post">
				   			<input type="hidden" name="_method" value="delete">
				    		<input class="btn btn-danger mr-2 pull-right" type="submit" value="Delete"/>
						</form>
						
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	${error}
	

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


</body>
</html>