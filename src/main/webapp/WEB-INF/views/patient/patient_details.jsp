<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>
<title><spring:message code="doctordetails" /></title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1><spring:message code="patientdetails"/></h1>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="form-group form-group-sm">	
		<!-- <p><a href="?language=en" >English</a>|<a href="?language=zh_CN">Chinese</a></p> -->
		
			<p>
			<spring:message code="firstName" />:
			${patient.firstName}<br />
			<spring:message code="lastName" />:
			${patient.lastName}<br />
			<spring:message code="form.phone" />:
			${patient.phone}<br/>
			<spring:message code="form.emailAddress" />:
			${patient.emailAddress}
			</p>
			<form action='<spring:url value="/patient/register"/>' method="get">
				<%-- <input id="submit" class="btn btn-default" type="submit"
					value='<spring:message code="addMorePatient"/>' /> --%>
				<a href="<spring:url value='/' />"
						class="btn btn-default"><spring:message code="home"/></a>
				<a href="<spring:url value='/login' />"
						class="btn btn-default"><spring:message code="login"/></a>		
			</form>
		</div>
	</section>
</body>
</html>