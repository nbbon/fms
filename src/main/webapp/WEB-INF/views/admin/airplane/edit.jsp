<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<spring:url value='/admin/airplane/edit/${airplane.id}' var='actionURL'/>
<div class="container" style="width: 70%">
	<form:form action="${actionURL}" method="post" modelAttribute="airplane">
	   <fieldset>
	       <legend><spring:message code="msg.label.airplane.edit" /></legend>
	       <form:errors path="*" cssStyle="color:red;" />
	       <input type="hidden" name="Id" value="${airplane.id}" />
	
	       <div class="form-group" >           
	           <label for="airportnr"><spring:message code="msg.label.airplane.serialNumber" /></label>          
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
	            <a href="${pageContext.request.contextPath}/admin/airplane" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnEdit" type="submit" name="edit" class="btn btn-outline-success">Update</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
