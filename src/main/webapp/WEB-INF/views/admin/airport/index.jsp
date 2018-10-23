<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/airport/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.airport.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.airport.code" /></th>
				<th><spring:message code="msg.label.airport.airportName" /></th>
				<th><spring:message code="msg.label.airport.city" /></th>
				<th><spring:message code="msg.label.airport.country" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${airports}" var="airport">
				<tr>
					<td>${airport.airportCode}</td>
					<td>${airport.airportName}</td>
					<td>${airport.city}</td>
					<td>${airport.country}</td>
					
					<td><a href="<spring:url value='/admin/airport/edit/${airport.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.airport.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>