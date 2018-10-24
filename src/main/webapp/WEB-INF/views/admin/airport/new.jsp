<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="airport">
	   <fieldset>
	       <legend><spring:message code="msg.label.airport.addNew" /></legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="airportnr"><spring:message code="msg.label.airport.code" /></label>          
	           <form:input path="airportCode" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="airtportName"><spring:message code="msg.label.airport.airportName" /></label>
	           <form:input path="airportName" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="city"><spring:message code="msg.label.airport.city" /></label>
	           <form:input path="city" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="country"><spring:message code="msg.label.airport.country" /></label>
	           <form:input path="country" cssClass="form-control"/>
	       </div>
	       
	      
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/airport" class="btn btn-outline-warning"><spring:message code="msg.label.flight.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.btnNew" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
