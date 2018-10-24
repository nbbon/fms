<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 60%">	
	<div class="jumbotron" style="padding-top: 15px">				
		<h2 class="alert alert-primary text-center">Booking Information</h2>		
		<h5 class="alert alert-info" role="alert">Passenger</h5>		

		<table class="table table-borderless">			  
		  <tbody>
		    <tr>
		      <th scope="row" class="w-50">First Name</th>
		      <td>${booking.passenger.firstName}</td>			      
		    </tr>
		    <tr>
		      <th scope="row">LastName</th>
		      <td>${booking.passenger.lastName}</td>		      
		    </tr>
		    <tr>
		      <th scope="row">Passport</th>
		      <td colspan="2">${booking.passenger.passportNumber}</td>		     
		    </tr>
		  </tbody>
		</table>
	
		<h5 class="alert alert-info" role="alert">Flight</h5>
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
		
	</div>	
</div>