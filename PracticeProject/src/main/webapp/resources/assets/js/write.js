(function($) {
	
	const formElement = $("#writeForm");
	
	$("#insertBtn").click(function() {
		formElement.attr("action","/board/write");
		formElement.submit();
	});
	$("#modifyBtn").click(function() {
		formElement.attr("action","/board/modifyPost");
		formElement.submit();
	});

})(jQuery);