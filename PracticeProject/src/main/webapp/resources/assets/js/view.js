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
	
	$("#likeBtn").click(function() {
		const postNo = $('#postNo').val();
		const account = $('#account').val();

		if(account == ""){
			alert("로그인 해주세요~");
		}else{
			$.ajax({
				type: "POST",
				url: "/board/postLike?postNo="+postNo,
				headers: {
					"Content-type" : "application/json"
				},
				dataType: 'json',
				data: account,
				success: function(result) {
					$("#likes").html('<b class="icon">'+result.likeNum+'</b>');
					$("#dislikes").html('<b class="icon">'+result.dislikeNum+'</b>');
					console.log(result.like);
					if(result.like == true && result.dislike == false){
						$("#likeIcon").removeClass("far");
						$("#likeIcon").addClass("fas");
						$("#dislikeIcon").removeClass("fas");
						$("#dislikeIcon").addClass("far");
					}else if(result.like == false && result.dislike == true){
						$("#likeIcon").removeClass("fas");
						$("#likeIcon").addClass("far");
						$("#dislikeIcon").removeClass("far");
						$("#dislikeIcon").addClass("fas");
					}else{
						$("#likeIcon").removeClass("fas");
						$("#likeIcon").addClass("far");
						$("#dislikeIcon").removeClass("fas");
						$("#dislikeIcon").addClass("far");
					}
				},
				error: function() {
					console.log("통신 실패!");
				}

			});
		}
	});
	
	$("#dislikeBtn").click(function() {
		const postNo = $('#postNo').val();
		const account = $('#account').val();

		if(account == ""){
			alert("로그인 해주세요~");
		}else{
			$.ajax({
				type: "POST",
				url: "/board/postDislike?postNo="+postNo,
				headers: {
					"Content-type" : "application/json"
				},
				dataType: 'json',
				data: account,
				success: function(result) {
					$("#likes").html('<b class="icon">'+result.likeNum+'</b>');
					$("#dislikes").html('<b class="icon">'+result.dislikeNum+'</b>');
					console.log(result.like);
					console.log(result.dislike);
					if(result.like == true && result.dislike == false){
						$("#likeIcon").removeClass("far");
						$("#likeIcon").addClass("fas");
						$("#dislikeIcon").removeClass("fas");
						$("#dislikeIcon").addClass("far");
					}else if(result.like == false && result.dislike == true){
						$("#likeIcon").removeClass("fas");
						$("#likeIcon").addClass("far");
						$("#dislikeIcon").removeClass("far");
						$("#dislikeIcon").addClass("fas");
					}else{
						$("#likeIcon").removeClass("fas");
						$("#likeIcon").addClass("far");
						$("#dislikeIcon").removeClass("fas");
						$("#dislikeIcon").addClass("far");
					}
				},
				error: function() {
					console.log("통신 실패!");
				}

			});
		}
	});
	
	

})(jQuery);