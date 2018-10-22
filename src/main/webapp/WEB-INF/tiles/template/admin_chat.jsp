<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--chat dialog-->
	<div id="chatDialog" class="modal fade modeless">
	    <div class="modal-dialog">
	        <div class="modal-content">
	        	<input type="hidden" id="me" value="Support"/>
	        	<input type="hidden" id="other" value="Client"/>
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4 class="modal-title"><spring:message code='chatWithClient'/></h4>
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