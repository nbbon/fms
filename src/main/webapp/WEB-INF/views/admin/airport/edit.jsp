<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value='/admin/airport/edit/${airport.id}' var='actionURL'/>
<div class="container" style="width: 70%">
	<form:form action="${actionURL}" method="post" modelAttribute="airport">
	   <fieldset>
	       <legend>Edit Airport</legend>
	       <form:errors path="*" cssStyle="color:red;" />
	       <input type="hidden" name="Id" value="${airport.id}" />
	
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
	            <a href="${pageContext.request.contextPath}/admin/airport" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success">Update</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
