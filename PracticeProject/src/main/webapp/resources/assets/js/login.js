(function($) {
	
	//로그인 버튼을 클릭 이벤트
	$('#signIn-btn').click(function() {
		const id = $('#sign_account').val();
		const pw = $('#sign_password').val();
			
		if(id !== "" || pw !== ""){
		const autoLogin = $("input[name=autoLogin]").is(":checked");
			
		const userInfo = { 
				account : id,
				password : pw,
				autoLogin : autoLogin
				};
			
		$.ajax({
			type: "POST",
			url: "/user/login",
			headers: {
				"Content-Type" : "application/json"
			},
			dataType: "text",
			data: JSON.stringify(userInfo),
			success: function(data) {
				if(data === "loginFail") {
					$('#sign_account').css("background-color", "pink");
					$('#sign_password').css("background-color", "pink");
					$('#sign_result').html('<b style="font-size:14px; color:red;">회원 정보가 없습니다.</b>');
					$('#sign_password').val("");
					$('#sign_account').focus();
				} else if(data === "loginSuccess") {
					self.location = "/";
				}
					
			},
			error: function() {
				console.log("통신 실패!");
			}
				
		}); 
		}else{
			$('#sign_result').html('<b style="font-size:14px; color:red;">입력정보를 확인해주세요</b>');
		}	
	});
})(jQuery);