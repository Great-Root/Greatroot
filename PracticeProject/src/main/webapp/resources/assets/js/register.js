(function($) {
	
	const getIdCheck= RegExp(/^[a-zA-Z0-9]{4,14}$/);
	const getPwCheck= RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	const getNickName= RegExp(/^[a-zA-Z0-9]{0,12}$/);
	const getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	let chk1 = false, chk2 = false, chk3 = false, chk4 = false, idchk = false;
	
	//ID 입력값 검증
	$("#account").on('keyup', function() {
		
		if($("#account").val() === "") {
			$("#account").css("background-color", "pink");
			$("#result").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디는 필수 정보에요!</b>');
			chk1 = false;
			idchk = false;
		}
		//아이디 유효성 검사
		else if(!getIdCheck.test($("#account").val())) {
			$("#account").css("background-color", "pink");
			$("#result").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디는 영문자 또는 숫자를 사용해서 4-14자로 작성해주세요!</b>');
			chk1 = false;
			idchk = false;
		}else{
			$("#account").css("background-color", "white");
			$("#result").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디 중복검사를 해주세요!</b>');
			idchk = true;
		}
			

	});
	
	//아이디 중복검사
	$("#idCheck").click(function() {
		if(idchk){
			const account = $('#account').val();
			
			$.ajax({
				type: "POST", 
				url: "/user/checkId", 
				headers: {
					"Content-Type" : "application/json"
				}, 
				dataType: "text", 
				data: account, 
				success: function(result) { 
					if(result === "OK") {
						$("#account").css("background-color", "#D9E5FF");
						$("#result").html('<b style="font-size:14px; color:green;">&nbsp&nbsp아이디 사용이 가능합니다!</b>');
						chk1 = true;
					} else if(result === "NO"){
						$("#account").css("background-color", "pink");
						$("#result").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당 아이디가 이미 사용중입니다.</b>');
						chk1 = false;
						idchk = false;
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			}); 		
		}else{
			$("#account").css("background-color", "pink");
			$("#result").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디를 다시 확인해주세요</b>');
			chk1 = false;
		}
	});
	
	
	//비밀번호 입력값 검증.
	$('#password').on('keyup', function() {
		//password 재입력시 비밀번호 확인란 초기화
		if($('#password_check').val() != ""){
			$('#password_check').val("");
	        $('#password_check').css("background-color", "pink");
	        $('#password_check').attr("placeholder","비밀번호 확인(다시 작성해주세요!)");
		    chk2 = false;
		}
		//비밀번호란 공백 확인
		if($('#password').val() === "") {
			$('#password').css("background-color", "pink");
			$('#result3').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호는 필수 정보입니다!</b>');
			chk2 = false;
		}
		//비밀번호 유효성 검사.
		else if(!getPwCheck.test($('#password').val()) || $('#password').val().length < 8) {
			$('#password').css("background-color", "pink");
			$('#result3').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호는 특수문자 포함하여 8자 이상 입력해 주세요!</b>');
			chk2 = false;
		} else {
			$('#password').css("background-color", "#D9E5FF");
			$('#result3').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호 확인을 해주세요!</b>');
			chk2 = true;
		}
		
	}); 
	
	//비밀번호 확인란 입력값 검증.
	$('#password_check').on('keyup', function() {
		//비밀번호 확인란 공백 확인
		if(!chk2){
			$('#password_check').css("background-color", "pink");
			$('#result3').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호를 먼저 작성해주세요</b>');
			chk3 = false;
		}
		else if($("#password_check").val() === ""){
		    $('#password_check').css("background-color", "pink");
			$('#result3').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호 확인란을 입력해주세요!</b>');
			chk3 = false;
		}		         
		//비밀번호 확인란 유효성검사
		else if($("#password").val() != $("#password_check").val()){
		    $('#password_check').css("background-color", "pink");
			$('#result3').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호 입력 정보가 다릅니다</b>');
			chk3 = false;
		} else {
			$('#password_check').css("background-color", "#D9E5FF");
			$('#result3').html('<b style="font-size:14px;color:green;">&nbsp&nbsp비밀번호 확인이 완료됐습니다!</b>');
			chk3 = true;
		}
		
	});
	
	//닉네임 값 검증
	$('#nickname').on('keyup', function() {
		//닉네임 값 공백 확인
		if($("#nickname").val() === ""){
		    $('#nickname').css("background-color", "pink");
			$('#result2').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임은 필수정보 입니다!</b>');
			chk4 = false;
		}		         
		//닉네임 값 유효성검사
		else if(!getNickName.test($("#nickname").val())){
		    $('#nickname').css("background-color", "pink");
			$('#result2').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임은 영어와 숫자로 최대 12글자로 작성해주세요</b>');
			chk4 = false;
		} else {
			$('#nickname').css("background-color", "white");
			$('#result2').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임 중복검사를 해주세요!</b>');
			chk4 = true;
		}
		
	});
	
	//닉네임 중복검사
	$("#nickCheck").click(function() {
		if(chk4){
			const nickname = $('#nickname').val();
			
			$.ajax({
				type: "POST", 
				url: "/user/checkNickName", 
				headers: {
					"Content-Type" : "application/json"
				}, 
				dataType: "text", 
				data: nickname, 
				success: function(result) {
					if(result === "OK") {
						$("#nickname").css("background-color", "#D9E5FF");
						$("#result2").html('<b style="font-size:14px; color:green;">&nbsp&nbsp닉네임 사용이 가능합니다!</b>');
						chk3 = true;
					} else if(result === "NO"){
						$("#nickname").css("background-color", "pink");
						$("#result2").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당 닉네임이 이미 사용중입니다.</b>');
						chk3 = false;
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			}); 		
		}else{
			$("#nickname").css("background-color", "pink");
			$("#result2").html('<b style="font-size:14px; color:red;">&nbsp&nbsp닉네임을 다시 확인해주세요</b>');
		}
});
	
	//사용자가 회원가입 버튼을 눌렀을 때 이벤트 처리
	$('#signup-btn').click(function() {
		if(chk1 && chk2 && chk3 && chk4) {
			const id = $('#account').val();
			const pw = $('#password').val();
			const name = $('#nickname').val();
			const email = $('#email').val();
			const birthday = $('#birthday').val();
			
			const user = {
				account: id,
				password: pw,
				nickname: name,
				email: email,
				birthday: birthday
			};
			
			$.ajax({
				type: "POST",
				url: "/user/register",
				headers: {
					"Content-type" : "application/json"
				},
				dataType: "text",
				data: JSON.stringify(user),
				success: function(result) {
					if(result === "joinSuccess") {
						alert("회원 가입에 성공했습니다!");
						location.href="/";
					} else {
						alert("회원 가입에 실패했습니다.");
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			
			});
			
		} else {
			alert('입력 정보를 다시 확인하세요!');
		}
		
	}); 
	
	
})(jQuery);