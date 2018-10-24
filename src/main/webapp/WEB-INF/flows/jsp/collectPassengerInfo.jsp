<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="author" content="Aha">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="<spring:url value='/resource/css/masterlayout.css' />"/>

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<spring:url value='/' />">Saigonese Flight</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">            
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='airport' />">|&nbsp; Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='airplane' />">|&nbsp; View Booking</a>
            </li>            
        </ul>
        <form id="searchForm" method="post" action="flight/search" class="form-inline my-2 my-lg-0">
            <input id="criteriaInput" name="criteria" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div class="container">
    <div class="row">  
		<div class="col-md-6 mx-auto">
			<form:form modelAttribute="booking.passenger" class="form-horizontal">
				<fieldset>
					<legend>Passenger Details</legend>
	
					<div class="form-group" >           
			           <label for="firstName">First Name</label>          
			           <form:errors path="firstName" cssClass="alert alert-danger" />
			           <form:input path="firstName" cssClass="form-control"/>
			       </div>	
						
				   <div class="form-group" >           
			           <label for="lastName">Last Name</label>          
			           <form:errors path="lastName" cssClass="alert alert-danger" />
			           <form:input path="lastName" cssClass="form-control"/>
			       </div>
			       
	         	   <div class="form-group" >           
			           <label for="passportNumber">Passport Number</label>          
			           <form:errors path="passportNumber" cssClass="alert alert-danger" />
			           <form:input path="passportNumber" cssClass="form-control"/>
			       </div>	 
	
	 				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					
					<div class="form-group">											
						<button id="btnCancel" class="btn btn-default" name="_eventId_bookingCancelled">Cancel</button>
						<input type="submit" id="btnAdd" class="btn btn-primary float-right"
							value="Next" name="_eventId_confirmationFlight" />						
					</div>
	
				</fieldset>
			</form:form>
		</div>
</div>
<!-- /.row -->

</div>
<!-- /.container -->
<footer class="footer">
    <div class="container">
        <span class="text-muted">Prof. Joe Bruen ::: Saigonese Group (CS545)</span><span style="float:right;"
                                                                                        class="text-muted">&copy October 2018</span>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

</body>
</html>
