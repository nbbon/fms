<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="form.addPatient"/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="form.addPatient"/></h1>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="patient" class="form-horizontal" action='register?${_csrf.parameterName}=${_csrf.token}' method = "POST" enctype="multipart/form-data">
			
				<div class="form-group form-group-sm">
					<!-- left column -->
            		<div class="col-sm-6">
            			<div class="form-group">
							<label class="control-label col-sm-4" for="firstName"><spring:message code="form.firstName"/></label>
							<div class="col-sm-8">
								<form:input id="firstName" path="firstName" class="form-control"/>
								<form:errors path="firstName" cssClass="text-danger"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="firstName"><spring:message code="form.lastName"/></label>
							<div class="col-sm-8">
								<form:input id="lastName" path="lastName" class="form-control"/>
								<form:errors path="lastName" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="emailAddress"><spring:message code="form.emailAddress"/></label>
							<div class="col-sm-8">
								<form:input id="email" path="emailAddress" class="form-control"/>
								<form:errors path="emailAddress" cssClass="text-danger"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="ssn"><spring:message code="form.ssn"/></label>
							<div class="col-sm-8">
								<form:input id="ssn" path="ssn" class="form-control"/>
								<form:errors path="ssn" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="ssn"><spring:message code="form.dob"/></label>
							<div class="col-sm-8">
								<form:input id="dob" path="dob" class="form-control"/>
								<form:errors path="dob" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4" for=""><spring:message code="form.phone"/></label>
							<div class="col-sm-2">
								<form:input id="area" path="phone.area" class="form-control"/>								
							</div>
							<div class="col-sm-2">
								<form:input id="prefix" path="phone.prefix" class="form-control"/>								
							</div>
							<div class="col-sm-3">
								<form:input id="number" path="phone.number" class="form-control"/>								
							</div>
							<div class="col-sm-2"></div>
						</div>
						<div class="form-group">
							<div class="col-sm-4">&nbsp;</div>
							<div class="col-sm-8">
								<form:errors path="phone.*" cssClass="text-danger"/>
							</div>
						</div>
						<p class="lead">Address</p>
						<div class="form-group">
		                    <label for="street" class="col-sm-4 control-label"><spring:message code="form.street"/></label>
		                    <div class="col-sm-8">
		                        <form:input id="street" path = "address.street" class="form-control"/>
		                        <form:errors path="address.street" cssClass="text-danger"/>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="city" class="col-sm-4 control-label"><spring:message code="form.city"/></label>
		                    <div class="col-sm-8">
		                        <form:input id="city" path="address.city" class="form-control"/>
		                        <form:errors path="address.city" cssClass="text-danger"/>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="state" class="col-sm-4 control-label"><spring:message code="form.state"/></label>
		                    <div class="col-sm-8">
		                        <form:input id="state" path="address.state" class="form-control"/>
		                        <form:errors path="address.state" cssClass="text-danger"/>
		                    </div>
		                </div>
		                <div class="form-group">
		                    <label for="zip" class="col-sm-4 control-label"><spring:message code="form.zip"/></label>
		                    <div class="col-sm-8">
		                        <form:input id="zip" path="address.zip" class="form-control"/>
		                        <form:errors path="address.zip" cssClass="text-danger"/>
		                    </div>
		                </div>
		                
            		</div>
            		<!-- right column -->
            		<div class="col-sm-6">
            		
            			<div class="form-group">
							<label class="control-label col-sm-4" for="ssn"><spring:message code="form.userName"/></label>
							<div class="col-sm-8">
								<form:input id="userName" path="credentials.username" class="form-control"/>
								<form:errors path="credentials.username" cssClass="text-danger"/>
							</div>
						</div>
						<div class="form-group">
							<label class="control-label col-sm-4" for="ssn"><spring:message code="form.password"/></label>
							<div class="col-sm-8">
								<form:input id="password" type="password" path="credentials.password" class="form-control"/>
								<form:errors path="credentials.password" cssClass="text-danger"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="control-label col-sm-4" for="ssn"><spring:message code="form.verifyPassword"/></label>
							<div class="col-sm-8">
								<form:input id="verifyPassword" type="password" path="credentials.verifyPassword" class="form-control"/>
								<form:errors path="credentials" cssClass="text-danger"/>
							</div>
						</div>
						
						
            			<!-- submit -->
            			<div class="form-group">
            				<div class="col-sm-4">&nbsp;</div>
							<div class="col-sm-8"">
								<input type="submit" id="btnAdd" class="btn btn-primary" value ="Register" class="form-control"/>
							</div>
						</div>		
            		</div>
				</div>

		</form:form>
	</section>
</body>
</html>
