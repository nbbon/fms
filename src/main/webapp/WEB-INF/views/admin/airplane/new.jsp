<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<form:form action="new" method="post" modelAttribute="airplane">
	   <fieldset>
	       <legend>New Airplane</legend>
			<form:errors path="*" cssStyle="color:red;" />
	       <div class="form-group" >           
	           <label for="serialNumber">Serial Number</label>          
	           <form:input path="serialNumber" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="model">Model</label>
	           <form:input path="model" cssClass="form-control"/>
	       </div>
	       <div class="form-group" style="float:none;">
	           <label for="capacity">capacity</label>
	           <form:input path="capacity" cssClass="form-control"/>
	       </div>
	      
	      
	       <div style="float:right;">
	            <a href="/" class="btn btn-outline-warning">Cancel</a>&nbsp;&nbsp;&nbsp;
	            <button id="btnNew" type="submit" name="edit" class="btn btn-outline-success">New</button>
	        </div>
	    </fieldset>
	</form:form>
</div>
