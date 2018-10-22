<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section class="container">
	<h1><spring:message code="doctordetails" /></h1>
	<div class="form-group form-group-sm">	
		<p>
		<img height="200" src="<spring:url value='/data/doctor_${doctor.id}.png'/>" alt = "Doctor picture"/>
		<p>
		<spring:message code="firstName" />:
		${doctor.firstName}<br />
		<spring:message code="lastName" />:
		${doctor.lastName}<br />
		<spring:message code="form.phone" />:
		${doctor.phone}
		</p>
		
		<a href="<spring:url value='/admin/doctors/list' />"
			class="btn btn-default"><spring:message code="doctorList"/>
		</a>
		<a href="<spring:url value='/admin/doctors/add'/>"
			class="btn btn-default"></span><spring:message code="addMoreDoctor"/>
		</a>
		<a href="<spring:url value='/' />"
					class="btn btn-default"><spring:message code="home"/>
		</a>
		
	</div>
</section>