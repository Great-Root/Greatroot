(function($) {
	
	const formElement = $("#writeForm");
	
	$("#insertBtn").click(function() {
		if($('#title').val().replace(/\s/gi,"") === "" || $('#content').val().replace(/\s/gi,"") === ""){
			alert("빈칸 없이 작성해주세요");
		}else{
			formElement.attr("action","/board/write");
			formElement.submit();
		}
	});
	$("#modifyBtn").click(function() {
		if($('#title').val().replace(/\s/gi,"") === "" || $('#content').val().replace(/\s/gi,"") === ""){
			alert("빈칸 없이 작성해주세요");
		}else{
			formElement.attr("action","/board/modifyPost");
			formElement.submit();
		}
	});
	
	//TextArea AutoSize
	$("textarea.autosize").on('keydown keyup', function () {
  		$(this).height(178).height( $(this).prop('scrollHeight')+12);	
	});

})(jQuery);