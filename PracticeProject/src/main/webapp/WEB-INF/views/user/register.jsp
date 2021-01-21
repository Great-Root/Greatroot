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
<title>회원가입 페이지</title>
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
							<h3>회원가입</h3>
							<div class="table-wrapper">
							<table class="for">
							
							<tr>
								<td colspan="3"><input type="text" maxlength="14" id="account" name="account" value="${user.account}" ${user == null ? "" : "readonly" }  placeholder="ID(숫자와 영어로 4-14자)" style="margin: 0;"/></td>
								<td width="10%"><input type="button" id="idCheck" value="중복검사" class="for"/></td>
							</tr>
							<tr>
								<td colspan="4" height="30"><span id="result" style="margin: 0;"></span></td>
							</tr>
							<tr>
								<td colspan="3"><input type="text" id="nickname" name="nickname" value="${user.nickname}" maxlength="12" placeholder="닉네임" style="margin: 0;"/></td>
								<td><input type="button" id="nickCheck" value="중복검사" class="for"/></td>
							</tr>
							<tr>
								<td colspan="4" height="30"><span id="result2" style="margin: 0;"></span></td>
							</tr>
							
							<tr>
								<td colspan="4"><input type="password" id="password" name="password" maxlength="16" placeholder="비밀번호" style="margin: 0;"/>
								<input type="password" id="password_check" name="passwordcheck" maxlength="16" placeholder="비밀번호 확인" style="margin: 5px 0 0 0;"/></td>
							</tr>
							<tr>
								<td colspan="4" height="30"><span id="result3" style="margin: 0;"></span></td>
							</tr>
							<tr>
								<td colspan="3"><input type="text" id="email" name="email" value="${user.email}" ${user == null ? "" : "readonly" } maxlength="50"  placeholder="이메일" style="margin: 0;"/></td>
								<td><input type="button" id="mailCheck" value="메일인증" class="for"/></td>
							</tr>
							<tr>
								<td colspan="4" height="30"><span id="result4" style="margin: 0;"></span></td>
							</tr>
							
							<tr>
								<td colspan="4">생년월일<input type="date" id="birthday" name="birthday" value="${user.birthday}" placeholder="생일" style="margin-left: 50px"/></td>
							</tr>
							<tr>
								<td colspan="4"><input type="button" id="signup-btn" value="회원가입" class="primary" style="margin-top: 15px;"/></td>
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
	<script src="<c:url value='/resources/assets/js/jquery.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/browser.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/breakpoints.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/util.js' />"></script>
	<script src="<c:url value='/resources/assets/js/main.js' />"></script>
	<script src="<c:url value='/resources/assets/js/register.js' />"></script>
</body>
</html>
