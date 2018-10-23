<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Customer</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Credit Card</h1>
				<p>Billing details</p>
			</div>
		</div>
	</section>
	<section class="container">
 		<form:form modelAttribute="creditCardAddressForm" class="form-horizontal">
			<fieldset>
 				<div class="form-group">
 					<div class="col-lg-12">
						<form:checkbox path="useHome" />
 						<label class="control-label col-lg-2" for="home">Use  Home  Address </label>							
					</div>
				</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
 								${customerAddress.streetName}
								<br>
								${customerAddress.state},${customerAddress.zipCode}
								<br>
								${customerAddress.country}
 							</address>
						</div>
				     </div>
 				<div class="form-group">
 					<div class="col-lg-12">
						<form:checkbox path="useShipping" />
 						<label class="control-label col-lg-2 " for="shipping">Use Shipping Address</label>							
					</div>
				</div>
					<div class="row">
						<div class="col-xs-6 col-sm-6 col-md-6">
							<address>
 								${shipAddress.streetName}
								<br>
								${shipAddress.state},${shipAddress.zipCode}
								<br>
								${shipAddress.country}
 							</address>
						</div>
				</div>
				<div class="form-group">
 					<div class="col-lg-12">
						<form:checkbox path="useBilling" />
 						<label class="control-label col-lg-2" for="another">Use Another Address</label>							
					</div>
				</div>
 
		  		<p>
		  		     <form:errors path="*" cssStyle="color : red;" /> 
		        </p>
  
				<div class="form-group">
					<label class="control-label col-lg-2" for="streetName">Street Name</label>
					<div class="col-lg-10">
						<form:input id="streetName" path="billingAddress.streetName" type="text"
							class="form:input-large" />
					</div>
				</div>

 				<div class="form-group">
					<label class="control-label col-lg-2" for="state">State</label>
					<div class="col-lg-10">
						<form:input id="state" path="billingAddress.state" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="country">Country</label>
					<div class="col-lg-10">
						<form:input id="country" path="billingAddress.country" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="zipCode">Zip Code</label>
					<div class="col-lg-10">
						<form:input id="zipCode" path="billingAddress.zipCode" type="text"
							class="form:input-large" />
					</div>
				</div>
				
 
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add" name="_eventId_billingAddressComplete" />
						<button id="btnCancel" class="btn btn-default" name="_eventId_cancel">Cancel</button>
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
