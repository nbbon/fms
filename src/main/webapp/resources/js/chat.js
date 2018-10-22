//Create stomp client over sockJS protocol
var ME = $('#me').val(); 
var OTHER = $('#other').val();
//console.log(MYSELF);
var socket = new SockJS("/ocr/ws");
var stompClient = Stomp.over(socket);

// Callback function to be called when stomp client is connected to server
var connectCallback = function() {
  stompClient.subscribe('/topic/chat', renderMessage);
}; 

// Render price data from server into HTML, registered as callback
// when subscribing to price topic
function renderMessage(frame) {
//  console.log('frame', frame);
  try {
	  var messageObj = JSON.parse(frame.body);
	  var sender = messageObj.sender;
	  var receiver = messageObj.receiver;
	  if (sender == ME || receiver == ME) {
		  appendMessage(messageObj);
		  $('.modal-body').scrollTop($('.modal-body').height())
	  }
	  if (receiver == 'Support') {
		  $('#chatBtn').addClass('blink');
		  console.log(frame.body);
	  }
  } catch (e) {
	  console.log(e);
  }
}

// Callback function to be called when stomp client could not connect to server
var errorCallback = function(error) {
//	console.log('errorCallback', error);
	alert(error.headers.message);
};

// Connect to server via websocket 
// with function to display stock in banner[connectCallback]
// and function to handle errors [errorCallback]
stompClient.connect("guest", "guest", connectCallback, errorCallback);
    
$("#chatDialog").draggable({
      handle: ".modal-header"
});

$('#chatDialog').on('shown.bs.modal', function () {
    $('#chatMessage').focus();
    $('.modal .modal-body').css('overflow-y', 'auto'); 
    $('.modal .modal-body').css('height', '300px');
    $('#chatBtn').removeClass('blink');
})  

function openCustomerChat() {	
	$('#chatDialog').modal({
		show: 'true',
		modal: false
	});
}
function sendMessage(form) {
	var message = $('#chatMessage').val();	
	var messageObj = {
		sender: ME,
		receiver: OTHER,
		message: message
	};
	stompClient.send("/ChatApp/send", {}, JSON.stringify(messageObj));
	
	form.reset();
	$('#chatMessage').focus();
	
	return false;
}

function appendMessage(messageObj) {
	$('#chatMessageContainer').append(formatMessage(messageObj.message, messageObj.sender));
}

function formatMessage(message, sender) {
	var html = '';
	if (sender == ME) {
		html = "<div class='container darker'>" + 
	  				"<b>Me</b>:&nbsp;" + message +   
	  			"</div>";
	} else {
		html = "<div class='container'>" + 
			"<b>" + sender + "</b>:&nbsp;" + message +   
		"</div>";
	}
	return html;
}
