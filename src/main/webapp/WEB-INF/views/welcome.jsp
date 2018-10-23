<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix = "spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" 
	href="<spring:url value='/resource/css/chat.css'/>"/>	
<link rel="stylesheet" 
	href="<spring:url value='/resource/css/modelless.css'/>"/>	
<title><spring:message code="msg.app.title"/></title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="col-sm-10"><spring:message code="msg.label.welcome"/></h1>
				<h4 class="col-sm-2"><a href="?language=en_US">English</a>|<a href="?language=es_ES">Spanish</a></h4>
			</div>
			
			<div class="container">
				<!-- chat is common for all -->
				<security:authorize access="isAnonymous()">
					<%-- <a href="<spring:url value='/patient/register' />"
						class="btn btn-default"><spring:message code='form.addPatient'/></a> --%>
					<a href="<spring:url value='/flights' />"
						class="btn btn-default"><spring:message code='msg.label.flights'/></a>
				</security:authorize>
				<%-- <a href="<spring:url value='/appointment/add' />"
					class="btn btn-default"> <span
					class="glyphicon-hand-left glyphicon"></span><spring:message code='makeAppointment'/>
				</a> --%>
				<a href="<spring:url value='/booking' />"
					class="btn btn-default"> <span
					class="glyphicon-hand-left glyphicon"></span><spring:message code='msg.label.bookTicket'/>
				</a>
				<a href="javascript:openCustomerChat();"
						class="btn btn-default"><spring:message code='msg.label.onlinesupport'/></a>
				<security:authorize access="isAnonymous()">
					<a href="<spring:url value='/login' />"
						class="btn btn-default"><spring:message code='login'/></a>
				</security:authorize>
				
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
	<!--chat dialog-->
	<div id="chatDialog" class="modal fade modeless">
	    <div class="modal-dialog">
	        <div class="modal-content">
	        	<!-- 
	        	<c:set var="sessionid" scope="session" value ="${pageContext.session.id}"/>
	        	<c:set var="len" scope="session" value ="${fn:length(sessionid)}"/>
	        	 -->
	        	<input type="hidden" id="me" value="Client"/>
	        	<input type="hidden" id="other" value="Support"/>
	        	
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title"><spring:message code='chatWithSupport'/></h4>
	            </div>
	            <div class="modal-body">
	                <div id="chatMessageContainer">
					</div>
	            </div>
	            <div class="modal-footer">
	            	<form class = "form" onsubmit = "return sendMessage(this)" autocomplete="off">
	            		<input type="text" class="form-input" id='chatMessage'/>
	            	</form>
	            </div>
	        </div>
	        <!-- /.modal-content -->
	    </div>
	    <!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript"	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<!-- JQueryUI, supports dragable chat dialog -->
	<script src="https://code.jquery.com/ui/1.10.1/jquery-ui.min.js"
  			integrity="sha256-Nnknf1LUP3GHdxjWQgga92LMdaU2+/gkzoIUO+gfy2M="
  			crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<!-- websocket chat enable -->
	<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
	<script src="<spring:url value="/resource/js/stomp.js"/>"></script>
	<script src="<spring:url value='/resource/js/chat.js'/>"></script>
</body>
</html>
