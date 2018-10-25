<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

</div>
<!-- /.row -->

</div>
<!-- /.container -->
<!--chat dialog-->
<div id="chatDialog" class="modal fade modeless">
	<div class="modal-dialog">
		<div class="modal-content">

			<input type="hidden" id="me" value="Client" /> <input type="hidden"
				id="other" value="Support" />

			<div class="modal-header">
				<div id="chatModalTitle">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">
						<spring:message code='msg.label.chat.support' />
					</h4>
				</div>
			</div>
			<div class="modal-body">
				<div id="chatMessageContainer"></div>
			</div>
			<div class="modal-footer">
				<div id="chatModalFooter">
					<form class="form" onsubmit="return sendMessage(this)"
						autocomplete="off">
						<input type="text" class="form-input" id='chatMessage' />
					</form>
				</div>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<footer id="footerContainer" class="footer">
	<div class="container  panel-footer">
		<span class="text-muted">Prof. Joe Bruen ::: Saigonese Group
			(CS545)</span><span style="float: right;" class="text-muted">&copy
			October 2018</span>
	</div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<!-- JQueryUI, supports dragable chat dialog -->
<script src="https://code.jquery.com/ui/1.10.1/jquery-ui.min.js"
	integrity="sha256-Nnknf1LUP3GHdxjWQgga92LMdaU2+/gkzoIUO+gfy2M="
	crossorigin="anonymous"></script>

<!-- Placed at the end of the document so the pages load faster -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>

<!-- websocket chat enable -->
<script src="http://cdn.sockjs.org/sockjs-0.3.min.js"></script>
<script src="<spring:url value="/resource/js/stomp.js"/>"></script>
<script src="<spring:url value='/resource/js/chat.js'/>"></script>

</body>
</html>