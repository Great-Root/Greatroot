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
<title>용수철 게시판</title>
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
				<header id="header">
				<span class="label"><a href="<c:url value='/board/write'/>" ${login == null ? "onclick=\"return confirm('로그인을 먼저 해주세요~')\"" : "" } class="button primary">글 작성</a></span>
					
					

					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Search -->
			
				<form method="get" action="<c:url value='/board/list'/>" style="margin-bottom: 0;">
					<div class="table-wrapper" >
						<table class="search" style="margin-bottom: 0;">
							<tr>
								<td width="200"><select id="condition" name="condition">
	
										<option value="title"
											${param.condition == 'title' ? 'selected' : ''}>제목</option>
										<option value="content"
											${param.condition == 'content' ? 'selected' : ''}>내용</option>
										<option value="writer"
											${param.condition == 'writer' ? 'selected' : ''}>작성자</option>
										<option value="titleContent"
											${param.condition == 'titleContent' ? 'selected' : ''}>제목+내용</option>
								</select></td>
								<td width="700"><input type="text" name="keyword" id="keyword" placeholder="Search" value="${param.keyword}"/></td>
								<td><input type="submit" value="검색" class="button primary"></td>
							</tr>
							
						</table>
					</div>
				</form>
			

				<!-- Table -->
				<div class="table-wrapper" style="margin-top: 0;">
					<table>
						<tbody>
							<c:forEach var="post" items="${boardList}">
								<tr>
									<td>${post.postNo}</td>
									<td>
									<a href="<c:url value='/board/postView/${post.postNo}${pc.makeURI(pc.paging.page)}'/>" >${post.title}</a>
									<span style="font-size: 0.7em;"><br>${post.writer} &nbsp;&bull;&nbsp; ${post.time} &nbsp;&bull;&nbsp; 조회수 ${post.views}회 &nbsp;&nbsp;&nbsp; <i class="icon for fa-thumbs-up"></i>&nbsp; ${post.likesNum} &nbsp;&nbsp;&nbsp; <i class="icon for fa-thumbs-down"></i>&nbsp;${post.dislikesNum} &nbsp;&nbsp;&nbsp; <i class="icon far fa-comment-alt"></i>&nbsp;${post.commentNum}</span>
									</td>											
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<ul class="pagination">
						<li><a href="<c:url value='/board/list${pc.makeURI(pc.beginPage-1)}' />" class="button${pc.prev ? '':' disabled'}">이전</a></li>
						<c:forEach var="pageNum" begin="${pc.beginPage}" end="${pc.endPage}">
							<li><a href="<c:url value='/board/list${pc.makeURI(pageNum)}'/>" class="page${(pc.paging.page == pageNum) ? ' active' : ''}">${pageNum}</a></li>
						</c:forEach>
						<li><a href="<c:url value='/board/list${pc.makeURI(pc.endPage+1)}' />" class="button${pc.next ? '':' disabled'}">다음</a></li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />
	</div>

</body>
</html>