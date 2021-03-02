(function($) {
	
	const formElement = $("#btnForm");
	

	$("#updateBtn").click(function() {
		formElement.attr("action","/board/modifyPost");
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
	

	$('#comment_btn').click(function(){
		const postNo = $('#postNo').val();
		const account = $('#account').val();
		const commentContent = $('#commentContent').val();
		const nickname = $('#nickname').val();
		const commentInfo = {
			postNo : postNo,
			commentWriter : account,
			commentContent : commentContent,
			nickname : nickname
		};
		$.ajax({
			type: "POST",
				url: "/board/setComment",
				headers: {
					"Content-type" : "application/json"
				},
				dataType: 'text',
				data: JSON.stringify(commentInfo),
				success: function(result) {
					if(result == "OK"){
						window.location.reload();
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
		});
	});
	
	//TextArea AutoSize
	$("textarea.autosize").on('keydown keyup', function () {
  		$(this).height(32).height( $(this).prop('scrollHeight')+12 );	
	});
	$("textarea.autosize").click(function () {
  		$(this).height(32).height( $(this).prop('scrollHeight')+12 );	
	});
	
	// Comment.
		var $comment = $('#comment'),
			$comment_openers = $comment.children('ul').find('.opener');

		// Openers.
			$comment_openers.each(function() {

				var $this = $(this);

				$this.on('click', function(event) {

					// Prevent default.
						event.preventDefault();

					// Toggle.
						$comment_openers.not($this).removeClass('active');
						$this.toggleClass('active');

				});

			});

})(jQuery);

// Modal.
function openModal(modalname) {
	document.get
	$("#modal").fadeIn(50);
	$("." + modalname).fadeIn(50);
	$("textarea.autosize").click();
}

$("#modal, .close").on('click', function() {
	$("#modal").fadeOut(50);
	$(".modal-con").fadeOut(50);
});

//Comment Delete
function delComment(delNo){
	const account = $('#account').val();
	const delCommentInfo = {
		commentWriter : account,
		commentNo : delNo
		};
	$.ajax({
			type: "POST",
				url: "/board/deleteComment",
				headers: {
					"Content-type" : "application/json"
				},
				dataType: 'text',
				data: JSON.stringify(delCommentInfo),
				success: function(result) {
					if(result == "OK"){
						window.location.reload();
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
		});
}



 

 
