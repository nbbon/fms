<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="description" content="">
    <meta name="author" content="Aha">
    <link rel="icon" href="favicon.ico">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
          integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    
    <link rel="stylesheet" href="<spring:url value='/resource/css/masterlayout.css'/>"/>
    <link rel="stylesheet" href="<spring:url value='/resource/css/chat.css'/>"/>
    <link rel="stylesheet" href="<spring:url value='/resource/css/modelless.css'/>"/>

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
    <a class="navbar-brand" href="<spring:url value='/' />">Saigonese Flight</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
            aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">            
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='/' />">|&nbsp; <spring:message code='msg.label.home'/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<spring:url value='/mybooking' />">|&nbsp; <spring:message code='msg.label.mybooking'/></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="javascript:openOnlineSupport();"
						class="btn btn-default">|&nbsp; <spring:message code='msg.label.onlinesupport'/></a>
            </li>             
        </ul>
        <c:if test="${not empty SpecialBlurb}">
	        <ul class="navbar-nav mr-auto">  
	        	<li class="nav-item">
	               	<p class="text-center text-warning">${SpecialBlurb}</p>
	           	</li>
        	</ul>
        </c:if>
       	<ul class="navbar-nav mr-auto">    
			<li class="nav-item">
               	<a class="nav-link" href="?language=en">English</a>
           	</li> 
           	<li class="nav-item">
               	<a class="nav-link" href="?language=vi_VN">Việt Nam</a>
           	</li>
		</ul>
    </div>
</nav>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div id="container" class="container">
    <div class="row">   