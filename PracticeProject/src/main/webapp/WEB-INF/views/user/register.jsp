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
										<a class="button primary" id="idCheck" style="margin: -7px 0 0 0;">중복검사</a>
									</c:if>
									<span id="idResult" ></span>
								</td>
							</tr>
							<tr>
								<td>
									<c:if test="${user != null}">
									닉네임 <input type="hidden" id="preNick" value="${user.nickname}"/>
									</c:if>
									<input type="text" id="nickname" name="nickname" value="${user.nickname}" maxlength="12" placeholder="닉네임" style="margin: 15px 0 0 0;"/>
								</td>
							</tr>
							<tr>
								<td>
									<a class="button primary" id="nickCheck"  style="margin: 6px 0 0 0;">중복검사</a>
									<span id="nickResult"></span>
								</td>
							</tr>
							
							<tr>
								<td >
									<c:if test="${user != null}">
										<input type="password" id="prePassword" name="prePassword" maxlength="16" placeholder="기존 비밀번호" style="margin: 15px 0 0 0;"/>
									</c:if>
									<input type="password" id="password" name="password" maxlength="16" placeholder="비밀번호" style="margin: 15px 0 0 0;"/>
									<input type="password" id="password_check" name="passwordcheck" maxlength="16" placeholder="비밀번호 확인" style="margin: 5px 0 0 0;"/>
								</td>
							</tr>
							<tr>
								<td height="30"><span id="pwResult"></span></td>
							</tr>
							<tr>
								<td>
									<input type="text" id="email" name="email" value="${user.email}" ${user == null ? "" : "readonly" } maxlength="50"  placeholder="이메일"/>
								</td>
							</tr>
							<tr>
								<td height="60"><!-- <a class="button primary" id="mailCheck" >메일인증</a><span id="mailResult"></span> --></td>
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
										<input type="button" id="modify-btn" value="회원정보 변경완료" class="primary" style="margin-top: 15px;"/>
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
