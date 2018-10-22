<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script type="text/javascript"	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

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
		<form class="form-horizontal" action="<spring:url value='/appointment/add'/>" method="GET" id="appointmentForm">
			<div class="form-group form-group-sm">
				<!-- left column -->
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label col-sm-4" for="category"><spring:message
								code="form.appointment.date" /></label>
						<div class="col-sm-8">
							<select name="date" class="form-control" onchange="javascript: $('#appointmentForm').submit()">
								<c:forEach items="${dates}" var="d">
									<option value="${d}" <c:if test="${d == date}">selected</c:if> >${d}</option>
								</c:forEach>
							</select> 
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="category"><spring:message
								code="form.appointment.doctorCategory" /></label>
						<div class="col-sm-8">
							<select name="categoryId" class="form-control" onchange="javascript: $('#appointmentForm').submit()">
								<option value="0"><spring:message code='allDoctors'/></option>
								<c:forEach items="${categories}" var="category">
									<option value="${category.id}" <c:if test="${category.id == categoryId}">selected</c:if> >${category.categoryName}</option>
								</c:forEach>
							</select> 
							
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-4" for="doctor"><spring:message
								code="form.appointment.doctor" /></label>
						<div class="col-sm-8">
							<!-- doctors -->
							<select name="doctorId" class="form-control" onchange="javascript: $('#appointmentForm').submit()">
								<c:forEach items="${doctors}" var="doctor">
									<option value="${doctor.id}" <c:if test="${doctor.id == doctorId}">selected</c:if> > ${doctor.fullName}</option>
								</c:forEach>
								<c:if test = "${doctors.size() == 0}">
									<option value="0">[No doctor available]</option>
								</c:if>
							</select>
						</div>
					</div>

					<%-- <div class="form-group">
						<label for="date" class="col-sm-4 control-label"><spring:message
								code="form.appointment.date" /></label>
						<div class="col-sm-8">
							<input id="date" name="date" value="${date}" class="form-control" />
						</div>
					</div> --%>
					<!-- timespans -->
					<div class="form-group">
						<label for="date" class="col-sm-4 control-label"><spring:message
								code="time" /></label>
						<div class="col-sm-8">
							<c:forEach items="${timespans}" var="timespan">
								<div class="radio">
							    	<label><input <c:if test="${!timespan.available}">disabled</c:if> type="radio" name="timespanId" value="${timespan.id}" class="form-check-input"/> ${timespan.value}</label>
							     </div>
							</c:forEach>
						</div>
					</div>
					<!-- submit -->
					<div class="form-group">
						<div class="col-sm-4">&nbsp;</div>
						<div class="col-sm-8">
							<spring:message code="form.appointment.check.submit" var="checkSubmitText"/>
                             <input <c:if test="${timespans.size() == 0}">disabled</c:if> type="submit" id="btnCheck" class="btn btn-primary" name="btnFinalSubmit" value="${checkSubmitText}"  class="form-control"/>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>
</body>
</html>