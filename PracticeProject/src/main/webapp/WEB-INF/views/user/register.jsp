<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>${pageName} 페이지</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/main.css'/>" />
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<jsp:include page="../include/header.jsp" />

				<!-- Form -->
				<form action="/user/register" method="post">
					<div class="row gtr-uniform">
						<div class="col-12 col-12-xlarge">
							<h3>${pageName}</h3>
							<div class="table-wrapper">
							<table class="for">
							
							<tr>
								<td>
									<c:if test="${user != null}">
									아이디
									<h2>${user.account}</h2>
									<input type="hidden" maxlength="14" id="account" value="${login.account}"/>
									</c:if>
									<c:if test="${user == null}">
										<input type="text" maxlength="14" id="account" name="account" placeholder="ID(숫자와 영어로 4-14자)" />
									</c:if>
								</td>
							</tr>
							<tr>
								<td>
									<c:if test="${user == null}">
										<a class="button primary" id="idCheck" style="margin: -0.5em 0 0 0;">중복검사</a>
									</c:if>
									<span id="idResult" ></span>
								</td>
							</tr>
							<tr>
								<td>
									<c:if test="${user != null}">
									닉네임 &nbsp&nbsp<input type="button" class="small" id="usePreNick" value="기존 닉네임" style="${user == null ? 'display:none;' : '' }" /><input type="hidden" id="preNick" value="${user.nickname}"/>
									</c:if>
									<input type="text" id="nickname" name="nickname" value="${user.nickname}" maxlength="12" placeholder="닉네임" style="margin: 15px 0 0 0;"/>
								</td>
							</tr>
							<tr>
								<td>
									<a class="button primary" id="nickCheck"  style="margin: 0.5em 0 0 0;">중복검사</a>
									<span id="nickResult"></span>
								</td>
							</tr>
							
							<tr>
								<td >
									<c:if test="${user != null}">
									<div id="a" style="position: relative;"><input type="password" id="prePassword" name="prePassword" maxlength="16" placeholder="기존 비밀번호" style="margin: 15px 1em 0 0;"/><div id="b" style="position: absolute; top: -0.1em; right: 0%;"><input type="button" id="prePassword_Btn" class="primary" value="확인" ${user == null ? 'style="display:none;"' : '' } /></div></div>
									</c:if>
									<input type="password" id="password" name="password" maxlength="16" placeholder="${user == null ? '' : '변경 ' }비밀번호" style="margin: 15px 0 0 0;"/>
									<input type="password" id="password_check" name="passwordcheck" maxlength="16" placeholder="${user == null ? '' : '변경 ' }비밀번호 확인" style="margin: 5px 0 0 0;"/>
								</td>
							</tr>
							<tr>
								<td height="30"><span id="pwResult"></span></td>
							</tr>
							<tr>
								<td>
									<input type="text" id="email" name="email" value="${user.email}" disabled="${user == null ? '' : 'disabled' }" maxlength="50"  placeholder="이메일"/>
								</td>
							</tr>
							<tr>
								<td height="60"><input type="button" class="primary" id="mailCheck" name="mailCheck" value="메일인증" style="margin: -0.5em 0 0 0; ${user == null ? '' : 'display:none;' }" /><span id="mailResult"></span><input type="button" id="reConfirmNum_Btn" class="button small" style="display:none; margin-left: 1em;" value="재전송"/><input type="button" id="reConfirmMail_Btn" class="button small" style="display:none; margin-left: 1em;" value="재인증"/></td>
							</tr>
							
							<tr>
								<td>생년월일<input type="date" id="birthday" name="birthday" value="${user.birthday}" placeholder="생일" style="margin-left: 50px"/></td>
							</tr>
							<tr>
								<td>
									<c:if test="${user == null}">
										<input type="button" id="signup-btn" value="회원가입" class="primary" style="margin-top: 15px;"/>
									</c:if>
									<c:if test="${user != null}">
										<a class="button primary" id="modify-btn" style="margin-top: 15px;">회원정보 변경완료</a>
										<a class="button primary" id="delete-btn" style="margin: 15px 0 0 1em;" onclick="return confirm('정말 회원탈퇴를 진행 하시겠습니까?\n회원정보는 3개월간 보관된 뒤 삭제되며 그 기간 동안은 해당 아이디로 재가입이 불가능합니다.')">회원 탈퇴</a>
									</c:if>
								</td>
							</tr>
							</table>
							</div>
						</div>
					</div>
				</form>


			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />
	</div>

	<!-- Scripts -->

	<script src="<c:url value='/resources/assets/js/register.js' />"></script>
</body>
</html>
