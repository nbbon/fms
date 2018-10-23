<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Passenger</h1>
				<p>Passenger details</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="booking.passenger" class="form-horizontal">
			<fieldset>
				<legend>Passenger Details</legend>

		  		<p>
		  		     <form:errors path="*" cssStyle="color : red;" /> 
		        </p>
  

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="customerId" >Passenger Id</label>
					<div class="col-lg-10">
						<form:input id="passengerId" path="passengerId" type="text" class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name</label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large" />
					</div>
				</div>
 
				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName">Passport Number</label>
					<div class="col-lg-10">
						<form:input id="passportNumber" path="passport" type="text"
							class="form:input-large" />
					</div>
				</div>

 				<%-- <div class="form-group">
					<label class="control-label col-lg-2" for="state">State</label>
					<div class="col-lg-10">
						<form:input id="state" path="address.state" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country</label>
					<div class="col-lg-10">
						<form:input id="country" path="address.country" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">Zip Code</label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="address.zipCode" type="text"
							class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-lg-2" for="phoneNumber">Phone Number</label>
					<div class="col-lg-10">
						<form:input id="phoneNumber" path="phoneNumber" type="text"
							class="form:input-large" />
					</div>
				</div> --%>

				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" name="_eventId_passengerInfoCollected" />
						<button id="btnCancel" class="btn btn-default" name="_eventId_bookingCancelled">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
