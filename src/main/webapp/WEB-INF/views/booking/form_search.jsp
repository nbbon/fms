<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container" style="width: 80%">
	<div class="jumbotron">
		<div class="row">
			<div class="col-md-5 mx-auto">
				 <form id="searchForm" method="post" action="flight/search" class="form-inline my-2 my-lg-0">
			            <input id="criteriaInput" name="criteria" class="form-control mr-sm-2" type="text" placeholder="Confirmation Code" aria-label="Search">
			            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Get</button>
			     </form>
		     </div>
	     </div>
     </div>
</div>
