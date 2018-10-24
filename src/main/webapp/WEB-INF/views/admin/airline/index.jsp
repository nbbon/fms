<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="col-lg-2">            
     <div class="list-group">
         <a href="<spring:url value='/admin/airline/new'/>" class="list-group-item d-flex justify-content-between align-items-center">
             <spring:message code="msg.label.airline.addNew" />
         </a>         
     </div>
</div> <!-- /.col-lg-3 -->

<div class="col-lg-10">
	<table class="table table-striped">
		<thead class="thead-dark">
			<tr>
				<th><spring:message code="msg.label.airline.airlineName" /></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${airlines}" var="airline">
				<tr>
					<td>${airline.airlineName}</td>
					
					<td><a href="<spring:url value='/admin/airline/edit/${airline.id}'/>"
						class="btn btn-default"><spring:message code="msg.label.airline.edit" /></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</div>