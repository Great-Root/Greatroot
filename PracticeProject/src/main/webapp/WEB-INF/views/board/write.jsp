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
<title>게시판 글쓰기</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/main.css'/>" />
	<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
<style>
div.write {
	width: 100%;
	margin-top: 10px;
}
</style>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<jsp:include page="../include/header.jsp" />

				<!-- Form -->
				<form id="writeForm" action="#" method="post">
					<div class="row gtr-uniform">
						<div class="write">
						
							<input type="text" name="writer" value="${login.account}" readonly />
							<input type="text" name="title" value="${post.title}" maxlength="80" placeholder="제목을 작성해주세요~" />
							<textarea name="content" rows="10" placeholder="내용을 입력해 주세요~" maxlength="800">${post.content}</textarea><br>
							
						</div>
					</div>
					<div class="col-12">
						<ul class="actions">
							<li>
							<c:if test="${post == null}"><input type="button" id="insertBtn" value="등록" class="primary" /></c:if>
							<c:if test="${post != null}">
							<input type="hidden" name="postNo" value="${post.postNo}" />
							<input type="hidden" name="page" value="${search.page}" />
							<input type="hidden" name="countPerPage" value="${search.countPerPage}" />
							<input type="hidden" name="keyword" value="${search.keyword}" />
							<input type="hidden" name="condition" value="${search.condition}" />
							<input type="hidden" name="result" value=true />
							<input type="button" id="modifyBtn" value="완료" class="primary" />
							</c:if>
							</li>
						</ul>
					</div>
				</form>


			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />
	</div>
	<script src="<c:url value='/resources/assets/js/write.js' />"></script>
</body>
</html>
