<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" 
	href="<spring:url value='/resource/css/chat.css'/>"/>	
<link rel="stylesheet" 
	href="<spring:url value='/resource/css/modelless.css'/>"/>
<title><spring:message code = 'adminWelcome'/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="col-sm-10"><spring:message code="admin.welcome" /></h1>
				<h4 class="col-sm-2"><a href="?language=en_US">English</a>|<a href="?language=es_ES">Spanish</a></h4>
			</div>
			<div class="container">
				<a href="<spring:url value='/admin/doctors/list' />"
					class="btn btn-default"> <span
					class="glyphicon-hand-right glyphicon"></span><spring:message code="doctorList"/>
				</a>
				
				<a href="<spring:url value='/admin/doctors/add' />"
					class="btn btn-default"> <span
					class="glyphicon-hand-right glyphicon"></span><spring:message code="addNewDoctor"/>
				</a>
				
				<a id="chatBtn" href="javascript:openCustomerChat();"
						class="btn btn-default"><spring:message code='chatWithClient'/></a>
						
				<security:authorize access="isAuthenticated()">
					<spring:url value="/dologout" var="logout_url" />
					<a href="javascript: $('#logoutForm').submit();"
					class="btn btn-default"> <span
					class="glyphicon-hand-right glyphicon"></span>Logout
					</a>
					<form:form action="${logout_url}" class="form-horizontal"
						method="POST" id="logoutForm">
					</form:form>
				</security:authorize>
				
			</div>
		</div>
	</section>