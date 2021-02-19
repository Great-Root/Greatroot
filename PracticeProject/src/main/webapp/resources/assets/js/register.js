(function($) {

	const getIdCheck = RegExp(/^[a-zA-Z0-9]{4,14}$/);
	const getPwCheck = RegExp(/([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
	const getNickName = RegExp(/^[a-zA-Z0-9]{0,12}$/);
	const getMailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);

	let idOverlapChk = false, pwChk = false, pwChkChk = false, nickChk = false,
		idchk = false, nickOverlapChk = false, modiChk = false, mailChk = false, mailConfirm = false;

	//ID 입력값 검증
	$("#account").on('keyup', function() {

		if ($("#account").val() === "") {
			$("#account").css("background-color", "pink");
			$("#idResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디는 필수 정보에요!</b>');
			idchk = false;
		}
		//아이디 유효성 검사
		else if (!getIdCheck.test($("#account").val())) {
			$("#account").css("background-color", "pink");
			$("#idResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디는 영문자 또는 숫자를 사용해서 4-14자로 작성해주세요!</b>');
			idchk = false;
		} else {
			$("#account").css("background-color", "white");
			$("#idResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp아이디 중복검사를 해주세요!</b>');
			idchk = true;
		}
		idOverlapChk = false;

	});

	//아이디 중복검사
	$("#idCheck").click(function() {
		if (idchk) {
			const account = $('#account').val();

			$.ajax({
				type: "POST",
				url: "/user/checkId",
				headers: {
					"Content-Type": "application/json"
				},
				dataType: "text",
				data: account,
				success: function(result) {
					if (result === "OK") {
						$("#account").css("background-color", "#D9E5FF");
						$("#idResult").html('<b style="font-size:14px; color:green;">&nbsp&nbsp아이디 사용이 가능합니다!</b>');
						idOverlapChk = true;
					} else if (result === "NO") {
						$("#account").css("background-color", "pink");
						$("#idResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당 아이디가 이미 사용중입니다.</b>');
						idOverlapChk = false;
						idchk = false;
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		} else {
			$("#account").css("background-color", "pink");
			$("#idResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp아이디를 다시 확인해주세요</b>');
			idOverlapChk = false;
		}
	});


	$('#prePassword_Btn').click(function() {
		const password = $('#prePassword').val();
		if (password != "") {
			$.ajax({
				type: "POST",
				url: "/user/modifyChk",
				headers: {
					"Content-type": "application/json"
				},
				dataType: "text",
				data: password,
				success: function(result) {
					if (result === "success") {
						$('#prePassword').css("background-color", "#D9E5FF");
						$('#prePassword').attr("disabled", "disabled");
						$('#prePassword_Btn').val("인증됨");
						$('#prePassword_Btn').removeClass('primary');
						$('#prePassword_Btn').addClass('disabled');
						modiChk = true;
						if ($('#isUsePrePw').val() == "false") {
							pwChk = false;
							pwChkChk = false;
							$('#password').removeAttr("disabled", "disabled");
							$('#password').attr("placeholder", "변경 비밀번호");
							$('#password').css("background-color", "white");
							$('#password_check').removeAttr("disabled", "disabled");
							$('#password_check').attr("placeholder", "변경 비밀번호 확인");
							$('#password_check').css("background-color", "white");
							$('#password').focus();
						}else{
							pwChk = true;
							pwChkChk = true;
						}
					} else {
						modiChk = false;
						$('#prePassword').val("");
						$('#prePassword').css("background-color", "pink");
						$('#prePassword').attr("placeholder", "비밀번호가 틀립니다.");
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		} else {
			$('#prePassword').css("background-color", "pink");
			$('#prePassword').attr("placeholder", "기존 비밀번호를 입력해주세요!");
			modiChk = false;
		}

	});

	//기존 비밀번호 사용 버튼 기능
	$('#usePrePw').click(function() {
		if ($('#isUsePrePw').val() == "false") {
			$('#usePrePw').addClass("primary");
			$('#isUsePrePw').val('true');
			$('#password').val('');
			$('#password_check').val('');
			$('#password').attr("disabled", "disabled");
			$('#password').attr("placeholder", "기존 비밀번호 사용이");
			$('#password').css("background-color", "#D5D5D5");
			$('#password_check').attr("disabled", "disabled");
			$('#password_check').attr("placeholder", "활성화 되었습니다");
			$('#password_check').css("background-color", "#D5D5D5");
			$('#pwResult').html('<b style="font-size:14px; color:green;">&nbsp&nbsp기존 비밀번호 사용</b>');
			pwChk = true;
			pwChkChk = true;
		} else if ($('#prePassword_Btn').val() == "인증됨" && $('#isUsePrePw').val() == "true") {
			$('#usePrePw').removeClass("primary");
			$('#isUsePrePw').val('false');
			$('#password').removeAttr("disabled", "disabled");
			$('#password').attr("placeholder", "변경 비밀번호");
			$('#password').css("background-color", "white");
			$('#password_check').removeAttr("disabled", "disabled");
			$('#password_check').attr("placeholder", "변경 비밀번호 확인");
			$('#password_check').css("background-color", "white");
			$('#password').focus();
			$('#pwResult').html('');
			pwChk = false;
			pwChkChk = false;
		}else{
			$('#usePrePw').removeClass("primary");
			$('#isUsePrePw').val('false');
			$('#password').attr("placeholder", "기존 비밀번호를");
			$('#password_check').attr("placeholder", "먼저 인증해 주세요!");
			$('#pwResult').html('');
			pwChk = false;
			pwChkChk = false;
		}
	});

	//비밀번호 입력값 검증.
	$('#password').on('keyup', function() {
		pwChkChk = false;
		pwChk = false;
		//password 재입력시 비밀번호 확인란 초기화
		if ($('#password_check').val() != "") {
			$('#password_check').val("");
			$('#password_check').css("background-color", "pink");
			$('#password_check').attr("placeholder", "비밀번호 확인(다시 작성해주세요!)");
			pwChk = false;
		}
		//비밀번호란 공백 확인
		if ($('#password').val() === "") {
			$('#password').css("background-color", "pink");
			$('#pwResult').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호는 필수 정보입니다!</b>');
			pwChk = false;
		}
		//비밀번호 유효성 검사.
		else if (!getPwCheck.test($('#password').val()) || $('#password').val().length < 8) {
			$('#password').css("background-color", "pink");
			$('#pwResult').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호는 특수문자 포함하여 8자 이상 입력해 주세요!</b>');
			pwChk = false;
		} else {
			$('#password').css("background-color", "#D9E5FF");
			$('#pwResult').html('<b style="font-size:14px; color:red;">&nbsp&nbsp비밀번호 확인을 해주세요!</b>');
			pwChk = true;
		}

	});

	//비밀번호 확인란 입력값 검증.
	$('#password_check').on('keyup', function() {
		pwChkChk = false;
		//비밀번호 확인란 공백 확인
		if (!pwChk) {
			$('#password_check').css("background-color", "pink");
			$('#pwResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호를 먼저 작성해주세요</b>');
			pwChkChk = false;
		}
		else if ($("#password_check").val() === "") {
			$('#password_check').css("background-color", "pink");
			$('#pwResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호 확인란을 입력해주세요!</b>');
			pwChkChk = false;
		}
		//비밀번호 확인란 유효성검사
		else if ($("#password").val() != $("#password_check").val()) {
			$('#password_check').css("background-color", "pink");
			$('#pwResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp비밀번호 입력 정보가 다릅니다</b>');
			pwChkChk = false;
		} else {
			$('#password_check').css("background-color", "#D9E5FF");
			$('#pwResult').html('<b style="font-size:14px;color:green;">&nbsp&nbsp비밀번호 확인이 완료됐습니다!</b>');
			pwChkChk = true;

		}

	});

	//닉네임 값 검증
	$('#nickname').on('keyup', function() {
		const preNick = $('#preNick').val();
		nickOverlapChk = false;
		nickChk = false;
		//닉네임 값 공백 확인
		if ($("#nickname").val() === "") {
			$('#nickname').css("background-color", "pink");
			$('#nickResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임은 필수정보 입니다!</b>');
			nickChk = false;
		}
		//닉네임 값 유효성검사
		else if (!getNickName.test($("#nickname").val())) {
			$('#nickname').css("background-color", "pink");
			$('#nickResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임은 영어와 숫자로 최대 12글자로 작성해주세요</b>');
			nickChk = false;
		}
		//회원 정보 수정시 기존의 닉네임 사용
		else if ($('#nickname').val() != null && preNick === $('#nickname').val()) {
			$('#nickname').css("background-color", "#D9E5FF");
			$('#nickResult').html('<b style="font-size:14px;color:green;">&nbsp&nbsp기존의 닉네임 입니다. 사용가능 합니다.</b>');
			nickChk = true;
			nickOverlapChk = true;
		} else {
			$('#nickname').css("background-color", "white");
			$('#nickResult').html('<b style="font-size:14px;color:black;">&nbsp&nbsp닉네임 중복검사를 해주세요!</b>');
			nickChk = true;
		}

	});

	//닉네임 중복검사
	$("#nickCheck").click(function() {
		const preNick = $('#preNick').val();
		if ($("#nickname").val() === "") {
			$('#nickname').css("background-color", "pink");
			$('#nickResult').html('<b style="font-size:14px;color:red;">&nbsp&nbsp닉네임은 필수정보 입니다!</b>');
			nickChk = false;
		}
		else if (preNick === $('#nickname').val()) {
			$('#nickname').css("background-color", "#D9E5FF");
			$('#nickResult').html('<b style="font-size:14px;color:green;">&nbsp&nbsp기존의 닉네임 입니다. 사용가능 합니다.</b>');
			nickChk = true;
			nickOverlapChk = true;
		}
		else if (nickChk) {
			const nickname = $('#nickname').val();

			$.ajax({
				type: "POST",
				url: "/user/checkNickName",
				headers: {
					"Content-Type": "application/json"
				},
				dataType: "text",
				data: nickname,
				success: function(result) {
					if (result === "OK") {
						$("#nickname").css("background-color", "#D9E5FF");
						$("#nickResult").html('<b style="font-size:14px; color:green;">&nbsp&nbsp닉네임 사용이 가능합니다!</b>');
						nickOverlapChk = true;
					} else if (result === "NO") {
						$("#nickname").css("background-color", "pink");
						$("#nickResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당 닉네임이 이미 사용중입니다.</b>');
						nickOverlapChk = false;
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		} else {
			$("#nickname").css("background-color", "pink");
			$("#nickResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp닉네임을 다시 확인해주세요</b>');
			nickOverlapChk = false;
		}
	});

	$('#usePreNick').click(function() {
		$("#nickname").val($('#preNick').val());
		$("#nickCheck").click();
	});

	//Mail 입력값 검증
	$("#email").on('keyup', function() {
		if ($("#mail").val() != "") {
			$("#mailCheck").val("메일인증");
			mailChk = false;
		}
		if ($("#email").val() === "") {
			$("#email").css("background-color", "pink");
			$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp이메일은 필수 정보에요!</b>');
			mailChk = false;
		}
		//Mail 유효성 검사
		else if (!getMailCheck.test($("#email").val())) {
			$("#email").css("background-color", "pink");
			$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp메일형식을 다시 확인해주세요!</b>');
			mailChk = false;
		} else {
			$("#email").css("background-color", "white");
			$("#mailResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp이메일 인증을 진행해주세요!</b>');
			mailChk = true;
		}
		mailConfirm = false;
	});

	//Mail 인증
	$("#mailCheck").click(function() {
		const mailCheck = $("#mailCheck").val();
		const email = $('#email').val();
		$("#email").attr("disabled", "disabled");
		if (mailChk && mailCheck == "메일인증") {
			$("#mailResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp인증메일이 발송중입니다. 잠시만 기다려주세요!</b>');
			$.ajax({
				type: "POST",
				url: "/user/sendConfirmEmail",
				headers: {
					"Content-Type": "application/json"
				},
				dataType: "text",
				data: email,
				success: function(result) {
					if (result === "OK") {
						$("#mailCheck").val("확인");
						$("#email").css("background-color", "#D9E5FF");
						$("#mailResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp인증메일이 발송되었습니다. 해당 메일을 확인해주세요! (이 페이지는 닫지 말아주세요!)&nbsp&nbsp</b>');
						$("#reConfirmNum_Btn").css("display", "");
						$("#reConfirmMail_Btn").css("display", "");
						mailConfirm = false;
					} else if (result === "NO") {
						$("#mailCheck").val("메일인증");
						$("#email").css("background-color", "pink");
						$("#email").removeAttr('disabled');
						$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당메일이 이미 등록 되어 있습니다.</b>');
						$("#reConfirmNum_Btn").css("display", "");
						$("#reConfirmMail_Btn").css("display", "");
						mailConfirm = false;
						mailchk = false;
					}

				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		} else if (mailChk && mailCheck == "확인") {
			$.ajax({
				type: "POST",
				url: "/user/isConfirmEmail",
				headers: {
					"Content-Type": "application/json"
				},
				dataType: "text",
				data: email,
				success: function(result) {
					if (result === "OK") {
						$("#email").css("background-color", "#D9E5FF");
						$("#mailResult").html('<b style="font-size:14px; color:green;">&nbsp&nbsp메일인증에 성공했습니다!</b>');
						$("#reConfirmNum_Btn").css("display", "none");
						$("#reConfirmMail_Btn").css("display", "");
						mailConfirm = true;
					} else if (result === "NO") {
						$("#email").css("background-color", "pink");
						$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp메일인증에 실패했습니다 메일을 다시 확인해주세요&nbsp&nbsp</b>');
						$("#reConfirmNum_Btn").css("display", "");
						$("#reConfirmMail_Btn").css("display", "");
						mailConfirm = false;
					}
				},
				error: function() {
					console.log("통신 실패!");
				}
			});
		} else {
			$("#email").css("background-color", "pink");
			$("#email").removeAttr('disabled');
			$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp이메일을 다시 확인해주세요</b>');
			mailConfirm = false;
		}

	});
	$('#reConfirmNum_Btn').click(function() {
		$("#mailResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp재전송중입니다. 잠시만 기다려주세요!&nbsp&nbsp</b>');
		$("#reConfirmNum_Btn").css("display", "none");
		$("#reConfirmMail_Btn").css("display", "none");
		const email = $('#email').val();
		$.ajax({
			type: "POST",
			url: "/user/sendConfirmEmail",
			headers: {
				"Content-Type": "application/json"
			},
			dataType: "text",
			data: email,
			success: function(result) {
				if (result === "OK") {
					$("#mailResult").html('<b style="font-size:14px; color:black;">&nbsp&nbsp재전송 되었습니다. 인증메일을 다시 확인해주세요!</b>');
					$("#reConfirmNum_Btn").css("display", "");
					$("#reConfirmMail_Btn").css("display", "");
					mailConfirm = false;
				} else if (result === "NO") {
					$("#mailCheck").val("메일인증");
					$("#email").css("background-color", "pink");
					$("#email").removeAttr('disabled');
					$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp해당메일이 이미 등록 되어 있습니다.</b>');
					$("#reConfirmNum_Btn").css("display", "");
					$("#reConfirmMail_Btn").css("display", "");
					mailConfirm = false;
				}
			},
			error: function() {
				console.log("통신 실패!");
			}
		});
	});

	$('#reConfirmMail_Btn').click(function() {
		$("#reConfirmNum_Btn").css("display", "none");
		$("#reConfirmMail_Btn").css("display", "none");
		const email = $("#email").val();
		$.ajax({
			type: "POST",
			url: "/user/reConfirmEmail",
			headers: {
				"Content-Type": "application/json"
			},
			dataType: "text",
			data: email,
			success: function(result) {
				if (result === "OK") {
					$("#mailCheck").val("메일인증");
					$("#email").val("");
					$("#email").css("background-color", "pink");
					$("#email").removeAttr('disabled');
					$("#mailResult").html('<b style="font-size:14px; color:red;">&nbsp&nbsp인증할 메일을 다시 작성해주세요!</b>');
					mailConfirm = false;
					mailChk = false;
				}
			},
			error: function() {
				console.log("통신 실패!");
			}
		});

	});

	//사용자가 회원가입 버튼을 눌렀을 때 이벤트 처리
	$('#signup-btn').click(function() {
		$('#idCheck').click();
		$('#nickCheck').click();
		
		if (idOverlapChk && idchk && pwChk && pwChkChk && nickChk && nickOverlapChk && mailChk && mailConfirm) {
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
					"Content-type": "application/json"
				},
				dataType: "text",
				data: JSON.stringify(user),
				success: function(result) {
					if (result === "joinSuccess") {
						alert("회원 가입에 성공했습니다!");
						location.href = "/";
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


	//회원 정보 수정 완료 버튼이 눌렸을 때
	$('#modify-btn').click(function() {
		$("#nickCheck").click();
		$('#prePassword_Btn').click();
		console.log("비밀번호 : "+ pwChk);
		console.log("비밀번호 확인 : "+ pwChkChk);
		console.log("닉네임 : "+ nickChk);
		console.log("닉네임 중복 : "+ nickOverlapChk);
		console.log("기존 비밀번호 : "+ modiChk);
		if (pwChk && pwChkChk && nickChk && nickOverlapChk && modiChk) {
			const id = $('#account').val();
			const name = $('#nickname').val();
			const email = $('#email').val();
			const birthday = $('#birthday').val();
			var pw = $('#password').val();
			if($('#isUsePrePw').val() == "true"){
				pw = $('#prePassword').val();
			}

			const user = {
				account: id,
				password: pw,
				nickname: name,
				email: email,
				birthday: birthday
			};

			$.ajax({
				type: "POST",
				url: "/user/modifyUserInfo",
				headers: {
					"Content-type": "application/json"
				},
				dataType: "text",
				data: JSON.stringify(user),
				success: function(result) {
					if (result === "modifySuccess") {
						alert("회원정보를 변경했습니다! 다시 로그인 해주세요");
						location.href = "/user/logout";
					} else {
						alert("회원정보를 변경하지 못했습니다. 입력정보를 다시한번 확인해 주세요.");
					}
				},
				error: function() {
					console.log("통신 실패!");
				}

			});

		} else {
			$('#password').val("");
			$('#password_check').val("");
			$('#password').focus();
			$("#pwResult").html('');
			pwChk = false;
			pwChkChk = false;
			alert('입력 정보를 다시 확인하세요!');
		}

	});

	//회원탈퇴 버튼이 눌렸을 때
	$('#delete-btn').click(function() {
		const id = $('#account').val();
		const pw = $('#prePassword').val();

		const delInfo = {
			account: id,
			password: pw
		};

		$.ajax({
			type: "POST",
			url: "/user/deleteUserInfo",
			headers: {
				"Content-type": "application/json"
			},
			dataType: "text",
			data: JSON.stringify(delInfo),
			success: function(result) {
				if (result === "deleteSuccess") {
					alert("회원 탈퇴 되었습니다. 다음에 또 만나요~");
					location.href = "/user/logout";
				} else {
					alert("회원 탈퇴가 안됐습니다. 비밀번호를 다시 확인해주세요!");
					$('#prePassword').val("");
					$('#prePassword').css("background-color", "pink");
					$('#prePassword').attr("placeholder", "기존 비밀번호 (다시 작성해주세요!)");
				}
			},
			error: function() {
				console.log("통신 실패!");
			}

		});

	});


})(jQuery);