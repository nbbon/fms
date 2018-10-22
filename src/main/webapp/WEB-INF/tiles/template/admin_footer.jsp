<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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