<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 70%">
	<div class="form-group">
		<legend>
			<spring:message code="msg.label.airplane.addNew" />
		</legend>
		<div id="categoryForm">
			<input type="hidden" id="csrfParam" value="${_csrf.parameterName}" />
			<input type="hidden" id="csrfValue" value="${_csrf.token}" />

			<div class="form-group">
				<label for="serialNumber"><spring:message
						code="msg.label.airplane.serialNumber" /></label> <input
					id="serialNumber" type="text" class="form-control" />
			</div>
			<div class="form-group" style="float: none;">
				<label for="model"><spring:message
						code="msg.label.airplane.model" /></label> <input id="model" type="text"
					class="form-control" />
			</div>
			<div class="form-group" style="float: none;">
				<label for="capacity"><spring:message
						code="msg.label.airplane.capacity" /></label> <input id="capacity"
					type="text" class="form-control" />
			</div>

		</div>
		<div style="float: right;">
			<a href="${pageContext.request.contextPath}/admin/airplane"
				class="btn btn-outline-warning"><spring:message
					code="msg.label.flight.cancel" /></a>&nbsp;&nbsp;&nbsp;
			<button id="btnNew" onclick="saveAirplane()"
				class="btn btn-outline-success">
				<spring:message code="msg.label.btnNew" />
			</button>
		</div>
	</div>
	<div class="form-group" id="result" style="display: none;">
		<label for="timespans" class="col-sm-4 control-label">&nbsp;</label>
		<div class="col-sm-8">
			<div id="errors" class="text-danger"></div>
			<div id="success" class="text-info">
				<spring:message code='msg.label.airplane.saved' />
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<spring:url value="/resource/js/ajax.js"/>"></script>
</div>
