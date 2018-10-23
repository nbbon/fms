<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/flight/add'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.flight.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.flight.name" /></th>
				<th><spring:message code="msg.label.flight.departureCity" /></th>
				<th><spring:message code="msg.label.flight.departureDate" /></th>
				<th><spring:message code="msg.label.flight.departureTime" /></th>
				<th><spring:message code="msg.label.flight.arrivalCity" /></th>
				<th><spring:message code="msg.label.flight.arrivalDate" /></th>
				<th><spring:message code="msg.label.flight.arrivalTime" /></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${flights}" var="flight">
				<tr>
					<td>${flight.flightnr}</td>
					<td>${flight.origin.city}</td>
					<td>${flight.departureDate}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.destination.city}</td>
					<td>${flight.arrivalDate}</td>
					<td>${flight.arrivalTime}</td>
					<td><a href="<spring:url value='/admin/flight/${flight.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.flight.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>