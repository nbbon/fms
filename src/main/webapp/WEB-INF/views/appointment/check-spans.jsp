<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title><spring:message code="form.addAppointment" /></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>
					<spring:message code="form.addNewAppointment" />
				</h1>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newAppointment" class="form-horizontal"
			action='save?${_csrf.parameterName}=${_csrf.token}' method="POST"
			enctype="multipart/form-data">

			<div class="form-group form-group-sm">
				<!-- left column -->
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label col-sm-4" for="category"><spring:message
								code="form.appointment.doctorCategory" /></label>
						<div class="col-sm-8">
							<form:select class="form-control" id="category"
								path="category" items="${categories}" itemValue="id"
								itemLabel="categoryName" />
						</div>
						<form:errors path="category" cssClass="text-danger" />
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="doctor"><spring:message
								code="form.appointment.doctor" /></label>
						<div class="col-sm-8">
							<form:select class="form-control" id="doctor" path="doctor"
								items="${doctors}" itemValue="id" itemLabel="fullName" />
						</div>
						<form:errors path="doctor" cssClass="text-danger" />
					</div>

					<div class="form-group">
						<label for="street" class="col-sm-4 control-label"><spring:message
								code="form.appointment.date" /></label>
						<div class="col-sm-8">
							<form:input id="street" path="date"
								class="form-control" />
							<form:errors path="date" cssClass="text-danger" />
						</div>
					</div>
					<!-- submit -->
					<div class="form-group">
						<div class="col-sm-4">&nbsp;</div>
						<div class="col-sm-8">
								<spring:message code="form.appointment.check.submit" var="saveSubmitText"/>
                                <input type="submit" id="btnSave" class="btn btn-primary" name="btnCheck" value="${checkSubmitText}"  class="form-control"/>
						</div>
					</div>
				</div>
			</div>

		</form:form>
	</section>
</body>
</html>
