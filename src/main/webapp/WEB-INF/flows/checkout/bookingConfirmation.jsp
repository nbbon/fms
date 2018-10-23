<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Flight Booking Confirmation</title>
</head>

<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Booking</h1>
				<p>Booking Confirmation</p>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<form:form modelAttribute="booking" class="form-horizontal">
				<input type="hidden" name="_flowExecutionKey"
					value="${flowExecutionKey}" />

				<div
					class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
					<div class="text-center">
						<h1>Receipt</h1>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong>Passenger Information</strong> <br>
								${booking.passenger.name}<br>
								<br>
								${booking.passenger.passportNumber}
								<br>
							</address>
						</div>
						<%-- <div class="col-xs-6 col-sm-6 col-md-6 text-right">
							<p>
								<em>Shipping DateDate: <fmt:formatDate type="date"
										value="${order.shippingDetail.shippingDate}" /></em>
							</p>
						</div> --%>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
								<strong>Billing Information</strong> <br>
								${booking.creditCard.name}   
								<br>
								${booking.creditCard.billingAddress.streetName}
								<br>
								${booking.creditCard.billingAddress.state},${order.creditCard.billingAddress.zipCode}
								<br>
								${booking.creditCard.billingAddress.country}
								<br> <abbr title="Phone">Phone:</abbr>
								${booking.passenger.phoneNumber}
								<br> <abbr title="CC Number">CC Number:</abbr>
								
								${booking.creditCard.number}
							</address>
						</div>

					</div>
					<div class="row">

						<table class="table table-hover">
							<thead>
								<tr>
									<th>Flight</th>
									<th>#</th>
									<th class="text-center">Flight #</th>
									<th class="text-center">Deprt Date</th>
									<th class="text-center">Arrival Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="flight" items="${booking.flights}">
									<tr>
										<td class="col-md-9"><em>${flight.flightnr}</em></td>
										<td class="col-md-1" style="text-align: center">
											${flight.departureDate}</td>
										<td class="col-md-1 text-center">$${flight.arrivalDate}</td>
									</tr>
								</c:forEach>

								<tr>
									<td> </td>
									<td> </td>
									<td class="text-right"><h4>
											<strong>Grand Total: </strong>
										</h4></td>
									<td class="text-center text-danger"><h4>
											<strong>$${booking.price}</strong>
										</h4></td>
								</tr>
							</tbody>
						</table>
						<button id="back" class="btn btn-default"
							name="_eventId_backToCreditCard">Back</button>

						<button type="submit" class="btn btn-success"
							name="_eventId_bookingConfirmed">
							Confirm   <span class="glyphicon glyphicon-chevron-right"></span>
						</button>
						<button id="btnCancel" class="btn btn-default"
							name="_eventId_cancel">Cancel</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>
