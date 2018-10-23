<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="airport">
	   <fieldset>
	       <legend>New Airport</legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="airportnr">Airport Code</label>          
	           <form:input path="airportCode" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="airtportName">Airport Name</label>
	           <form:input path="airportName" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="city">City</label>
	           <form:input path="city" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="country">Country</label>
	           <form:input path="country" cssClass="form-control"/>
	       </div>
	       
	      
	       <div style="float:right;">
	            <a href="/" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success">New</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
