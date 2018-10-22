<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="appointmentdetails" /></title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="appointmentdetails"/></h1>
				<!-- <h4 style="padding: 6px 12px;" class="pull-right"><a href="?language=en_US">English</a>|<a href="?language=es_ES">Spanish</a></h4> -->
			</div>
		</div>
	</section>
	<section class="container">
		<div class="form-group form-group-sm">	
		<!-- <p><a href="?language=en" >English</a>|<a href="?language=zh_CN">Chinese</a></p> -->
			<h3>
			<spring:message code="patient" />: ${appointment.patient.firstName}&nbsp;${appointment.patient.lastName}<br />
			<spring:message code="date" />: ${appointment.date}<br />
			<spring:message code="time" />: ${appointment.timeSpan}<br />
			<spring:message code="doctor" />: ${appointment.doctor.fullName} <br />
			</h3>
			<br/>
			<p>
				<a href="<spring:url value='/' />"
							class="btn btn-default"><spring:message code="home"/>
				</a>
			</p>
		</div>
	</section>
</body>
</html>