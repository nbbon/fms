<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<spring:url value='/flight' var='actionURL' />
	<form:form action="${actionURL}" method="post" modelAttribute="flight">
	   <fieldset>
	       <legend>Edit Flight</legend>
	       <input type="hidden" name="Id" value="${flight.id}" />
	
	       <div class="form-group" >           
	           <label for="flightnr">Flight Number</label>          
	           <form:errors path="flightnr" cssClass="alert alert-danger" />
	           <form:input path="flightnr" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="departureDate">Departure Date</label>
	           <form:errors path="departureDate" cssClass="alert alert-danger" />
	           <form:input path="departureDate" cssClass="form-control"/>
	       </div>
	      
	       <div style="float:right;">
	            <a href="/" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success">Update</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
