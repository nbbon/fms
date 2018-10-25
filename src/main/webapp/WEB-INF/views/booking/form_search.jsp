<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="container" style="width: 80%">
	<div class="jumbotron" style="padding-top: 15px">
		<h1 class="alert alert-info">View My Booking</h1>
		<p>&nbsp;</p>		
		<div class="row">
			<div class="col-md-5 mx-auto">
				 <form id="searchForm" method="post" action="<spring:url value="/mybooking"></spring:url>" class="form-inline my-2 my-lg-0">
			            <input id="criteriaInput" name="cCode" class="form-control mr-sm-2" 
			            		type="text" placeholder="Confirmation Code" aria-label="Search"
			            		value = "${cCode }">
			            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Get</button>
			            <security:csrfInput />
			     </form>
			     <c:if test="${cCode != null }">				     
				     <h6 class="alert alert-danger" style="margin-top: 8px;">Please insert correct code!!!</h6>
			     </c:if>
		     </div>
	     </div>
     </div>
</div>
