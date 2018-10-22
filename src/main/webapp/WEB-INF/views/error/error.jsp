<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
  
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
    <title><spring:message code="error"/></title>
  </head>
  <body>

<center>

<img src="<spring:url value='/resource/images/error_page.jpg'/>"/>
 
 <h2>${errorMessage}</h2>
 ${requestScope['javax.servlet.error.message']}
 <p>
 
 <a href="<spring:url value='/' />"
						class="btn btn-default"><spring:message code='home'/></a>
 </p>

</center> 
  </body>
</html>