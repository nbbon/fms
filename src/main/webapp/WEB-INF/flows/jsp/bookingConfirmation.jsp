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
                <a class="nav-link" href="<spring:url value='/' />">|&nbsp; <spring:message code='msg.label.home'/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='/mybooking' />">|&nbsp; <spring:message code='msg.label.mybooking'/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:openOnlineSupport();"
						class="btn btn-default">|&nbsp; <spring:message code='msg.label.onlinesupport'/></a>
            </li>             
        </ul>       
    </div>
</nav>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div class="container" style="width: 60%">	
	<div class="jumbotron" style="padding-top: 15px">				
		<h2 class="alert alert-primary text-center"><spring:message code='msg.flow.title.bC'/></h2>		
		<h5 class="alert alert-info" role="alert"><spring:message code='msg.flow.title.pI'/></h5>
		
		<form:form modelAttribute="order" class="form-horizontal">
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
			<table class="table table-borderless">			  
			  <tbody>
			    <tr>
			      <th scope="row" class="w-50"><spring:message code='msg.flow.lbl.fN'/></th>
			      <td>${booking.passenger.firstName}</td>			      
			    </tr>
			    <tr>
			      <th scope="row"><spring:message code='msg.flow.lbl.lN'/></th>
			      <td>${booking.passenger.lastName}</td>		      
			    </tr>
			    <tr>
			      <th scope="row"><spring:message code='msg.flow.lbl.pp'/></th>
			      <td colspan="2">${booking.passenger.passportNumber}</td>		     
			    </tr>
			  </tbody>
			</table>
		
			<h5 class="alert alert-info" role="alert"><spring:message code='msg.flow.title.fI'/></h5>
			<table class="table table-borderless">			  
			  <tbody>
			    <tr>
			      <th scope="row"><spring:message code="msg.label.flight.flightnr" /></th>
			      <td>${booking.flight.flightnr}</td>			      
			    </tr>	
			    	
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.flight.departureDate" /></th>
			      <td>${booking.flight.departureDate}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.flight.departureTime" /></th>
			      <td>${booking.flight.departureTime}</td>			      
			    </tr>	  
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.flight.arrivalDate" /></th>
			      <td>${booking.flight.arrivalDate}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row" class="w-50"><spring:message code="msg.label.flight.arrivalTime" /></th>
			      <td>${booking.flight.arrivalTime}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row" class="w-50"><spring:message code="msg.label.flight.airline" /></th>
			      <td>${booking.flight.airline.airlineName}</td>			      
			    </tr>	
			    
			    <tr>
	      		  <th scope="row"><spring:message code="msg.label.flight.departure" /></th>
			      <td>${booking.flight.origin.airportDetail}</td>			      
			    </tr>
			    
		     	<tr>
	      		  <th scope="row"><spring:message code="msg.label.flight.destination" /></th>
			      <td>${booking.flight.destination.airportDetail}</td>			      
			    </tr>			    
			     
			  </tbody>
			</table>
			
			<p>&nbsp;</p>
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}" />
			
			<button id="btnCancel" class="btn btn-default" name="_eventId_cancel"><spring:message code='msg.flow.btn.cancel'/></button>
			
			<button id="back" class="btn btn-warning" name="_eventId_backToPassengerInfo"><spring:message code='msg.flow.btn.back'/></button>
	
			<button type="submit" class="btn btn-success float-right" name="_eventId_bookingConfirmed"><spring:message code='msg.flow.btn.confirm'/></button>
			
		</form:form>		
	</div>	
</div>
<!-- /.container -->
<footer id="footerContainer" class="footer">
	<div class="container">
		<span class="text-muted">Prof. Joe Bruen ::: Saigonese Group
			(CS545)</span><span style="float: right;" class="text-muted">&copy
			October 2018</span>
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
