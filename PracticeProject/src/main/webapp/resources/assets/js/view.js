(function($) {
	
	const formElement = $("#btnForm");
	

	$("#updateBtn").click(function() {
		formElement.attr("action","/board/modifyPost");
		formElement.submit();
	});
	
	$("#deleteBtn").click(function() {
		formElement.attr("action","/board/deletePost");
		formElement.submit();
	});

})(jQuery);