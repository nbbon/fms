<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="airplane">
	   <fieldset>
	       <legend><spring:message code="msg.label.airplane.addNew" /></legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="serialNumber"><spring:message code="msg.label.airplane.serialNumber" /></label>          
	           <form:input path="serialNumber" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="model"><spring:message code="msg.label.airplane.model" /></label>
	           <form:input path="model" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="capacity"><spring:message code="msg.label.airplane.capacity" /></label>
	           <form:input path="capacity" cssClass="form-control"/>
	       </div>
	      
	      
	       <div style="float:right;">
	            <a href="${pageContext.request.contextPath}/admin/airplane" class="btn btn-outline-warning"><spring:message code="msg.label.flight.cancel" /></a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success"><spring:message code="msg.label.btnNew" /></button>
	        </div>
	    </fieldset>
	</form:form>
</div>
