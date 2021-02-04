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
  
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<jsp:include page="../include/header.jsp" />

				<div class="table-wrapper">
					<table class="alt">
						<tbody>
							<tr>
								<td width="150">작성자</td>
								<td>${post.writer}</td>
							</tr>
							<tr>
								<td width="150">제목</td>
								<td>${post.title}</td>
							</tr>
							<tr>
								<td colspan="2">
								<div class="box">
									<pre style="font-family:Noto Sans KR; font-size: 20px; word-wrap: break-word;white-space: pre-wrap;
									white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-break:break-all;">${post.content}</pre>
								</div>
									
									<form id="btnForm" action="" method="post">
									<input type="hidden" id="account" value="${login.account}"/>
									<ul class="icons" style="text-align: center; font-size: 35px; margin-bottom: 15px;">
										<li>
										<a href="#" id="likeBtn"class="icon" ><i id="likeIcon" class="${post.like ? 'fas' : 'far' } fa-thumbs-up"></i></a>
										<span id="likes"><b class="icon"> ${post.likesNum}</b></span>
										</li>
										<li>
										<a href="#" id="dislikeBtn"class="icon" ><i id="dislikeIcon" class="${post.dislike ? 'fas' : 'far' } fa-thumbs-down"></i></a>
										<span id="dislikes"><b class="icon"> ${post.dislikesNum}</b></span>
										</li>
									</ul>
									
										<a href="<c:url value='/board/list?page=${search.page}&countPerPage=${search.countPerPage}&keyword=${search.keyword}&condition=${search.condition}'/>" class="button primary">목록</a>
										<input type="hidden" id="postNo" name="postNo" value="${post.postNo}" />
										<input type="hidden" name="page" value="${search.page}" />
										<input type="hidden" name="countPerPage" value="${search.countPerPage}" />
										<input type="hidden" name="keyword" value="${search.keyword}" />
										<input type="hidden" name="condition" value="${search.condition}" />
										<input type="hidden" name="result" value=false />
										<c:if test="${login.account == post.writer}">
										<input type="button" value="수정" id="updateBtn" class="button primary"/>
										<input type="button" value="삭제" id="deleteBtn" class="button primary" onclick="return confirm('정말로 삭제하시겠습니까?')"/>
										</c:if>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
				</div>



			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />
	</div>
	<script src="<c:url value='/resources/assets/js/view.js' />"></script>

</body>
</html>