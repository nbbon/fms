// pathname is contextRoot/path/path/ so we want to get [1] 
// that is where contextRoot is
// [0] has "" as a result of split 
var contextRoot = "/" + window.location.pathname.split( '/' )[1];

function addCategory() {
//	$("#categoryForm").reset();
	$("#categoryForm").show();
	$("#categoryName").focus();
	return false;
}

function saveCategory(){
   	var dataToSend = JSON.stringify({
   		id: '0',
   		categoryName: $("#categoryName").val(),
   		description: ''
   	});
   	var csrfParam = $("#csrfParam").val();
   	var csrfValue = $("#csrfValue").val();
   	$.ajax({
		type: 'POST',
		url: contextRoot + '/admin/category/add?' + csrfParam + '=' + csrfValue,
		dataType: "json",
 		data:dataToSend,
 		contentType: 'application/json',
		success: function(category){
			console.log('result', category);
			$('#errors').html("");
	 	    $('#result').show();
//	 	    append category to combobox
	 	    $("#doctorCategory").append(new Option(category.categoryName, category.id, true, true));
	 	    setTimeout(function() {
	 	    	$("#result").hide();
	 	    }, 2000);
		},
		error: function(errorObject) {
			console.log('errorObject', errorObject);
			$('#result').show();
			$('#success').hide();
			if (errorObject.responseJSON.errorType == "ValidationError") {
  			    var errorList = errorObject.responseJSON.errors;
 	 	        $.each(errorList,  function(i,error) {			   
 		    		$("#errors").append( error.message + '<br>');
		    	});
			}
			else {
				alert(errorObject.responseJSON.errors(0));   // "non" Validation Error
			}
			
			setTimeout(function() {
	 	    	$("#result").hide();
	 	    }, 2000);
 		}
	});
}


 