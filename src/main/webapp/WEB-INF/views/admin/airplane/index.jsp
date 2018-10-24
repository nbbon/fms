<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/airplane/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.airplane.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.airplane.serialNumber" /></th>
				<th><spring:message code="msg.label.airplane.model" /></th>
				<th><spring:message code="msg.label.airplane.capacity" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${airplanes}" var="airplane">
				<tr>
					<td>${airplane.serialNumber}</td>
					<td>${airplane.model}</td>
					<td>${airplane.capacity}</td>
					
					<td><a href="<spring:url value='/admin/airplane/edit/${airplane.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.airplane.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>