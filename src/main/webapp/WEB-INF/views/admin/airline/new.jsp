<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="airline">
	   <fieldset>
	       <legend><spring:message code="msg.label.airline.addNew" /></legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="airlineName"><spring:message code="msg.label.airline.airlineName" /></label>          
	           <form:input path="airlineName" cssClass="form-control"/>
	       </div>
	 
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/airline" class="btn btn-outline-warning"><spring:message code="msg.label.flight.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.btnNew" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
