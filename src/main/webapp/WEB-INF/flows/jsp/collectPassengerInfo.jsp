<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
    <link rel="stylesheet" type="text/css" href="<spring:url value='/resource/css/masterlayout.css' />"/>

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
       
    </div>
</nav>
<p>&nbsp;</p>
<p>&nbsp;</p>
<div class="container">
    <div class="row">  
		<div class="col-md-6 mx-auto">
			<form:form modelAttribute="booking.passenger" class="form-horizontal">
				<fieldset>
					<legend><spring:message code='msg.flow.title.pDetail'/></legend>
	
					<div class="form-group" >           
			           <label for="firstName"><spring:message code='msg.flow.lbl.fN'/></label>          
			           <form:errors path="firstName" cssClass="alert alert-danger" />
			           <form:input path="firstName" cssClass="form-control"/>
			       </div>	
						
				   <div class="form-group" >           
			           <label for="lastName"><spring:message code='msg.flow.lbl.lN'/></label>          
			           <form:errors path="lastName" cssClass="alert alert-danger" />
			           <form:input path="lastName" cssClass="form-control"/>
			       </div>
			       
	         	   <div class="form-group" >           
			           <label for="passportNumber"><spring:message code='msg.flow.lbl.pp'/></label>          
			           <form:errors path="passportNumber" cssClass="alert alert-danger" />
			           <form:input path="passportNumber" cssClass="form-control"/>
			       </div>	 
	
	 				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					
					<div class="form-group">											
						<button id="btnCancel" class="btn btn-default" name="_eventId_bookingCancelled"><spring:message code='msg.flow.btn.cancel'/></button>
						<input type="submit" id="btnAdd" class="btn btn-primary float-right"
							value="<spring:message code='msg.flow.btn.next'/>" name="_eventId_confirmationFlight" />						
					</div>
	
				</fieldset>
			</form:form>
		</div>
</div>
<!-- /.row -->

</div>
<!-- /.container -->
<footer id="footerContainer" class="footer">
	<div class="container">
		<span class="text-muted">Prof. Joe Bruen ::: Saigonese Group
			(CS545)</span><span style="float: right;" class="text-muted">&copy
			October 2018</span>
	</div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
        integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
        crossorigin="anonymous"></script>

</body>
</html>
