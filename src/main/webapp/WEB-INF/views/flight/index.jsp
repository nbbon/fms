<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="container">
	<h1>
		<spring:message code="msg.label.flights" />
	</h1>
	<div class="form-group form-group-sm">
		<table class="table table-striped">
			<thead>
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
						<td><a href="<spring:url value='/flight/${flight.id}'/>"
							class="btn btn-default"><spring:message
									code="msg.label.detail" /></a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="6"><a
						href="<spring:url value='/admin/flight/add'/>"
						class="btn btn-default"><spring:message
								code="msg.label.flight.addNew" /></a> <a
						href="<spring:url value='/' />" class="btn btn-default"><spring:message
								code="home" /></a></td>
				</tr>
			</tbody>
		</table>
	</div>
</section>