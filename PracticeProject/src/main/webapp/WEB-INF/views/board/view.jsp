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
									<div style="font-size: 0.8em;">&bull;&nbsp; 작성일 : ${post.regDate} &nbsp;&bull;&nbsp; 조회수 ${post.views}회  &nbsp;&nbsp;&nbsp; <i class="icon far fa-comment-alt"></i>&nbsp;${post.commentNum}</div>
									<div class="box">
										<pre style="font-family: Noto Sans KR; font-size: 20px; word-wrap: break-word; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-break: break-all;">${post.content}</pre>
									</div>

									<form id="btnForm" action="/board/deletePost" method="post">
										<input type="hidden" id="account" value="${login.account}" />
										<ul class="icons" style="text-align: center; font-size: 35px; margin-bottom: 15px;">
											<li><a href="#" id="likeBtn" class="icon"><i id="likeIcon" class="${post.like ? 'fas' : 'far' } fa-thumbs-up"></i></a> 
											<span id="likes"><b class="icon"> ${post.likesNum}</b></span></li>
											<li><a href="#" id="dislikeBtn" class="icon"><i id="dislikeIcon" class="${post.dislike ? 'fas' : 'far' } fa-thumbs-down"></i></a>
											<span id="dislikes"><b class="icon">${post.dislikesNum}</b></span></li>
										</ul>

										<a href="<c:url value='/board/list?page=${search.page}&countPerPage=${search.countPerPage}&keyword=${search.keyword}&condition=${search.condition}'/>" class="button primary">목록</a> 
										<input type="hidden" id="postNo" name="postNo" value="${post.postNo}" /> 
										<input type="hidden" name="page" value="${search.page}" /> 
										<input type="hidden" name="countPerPage" value="${search.countPerPage}" /> 
										<input type="hidden" name="keyword" value="${search.keyword}" /> 
										<input type="hidden" name="condition" value="${search.condition}" />
										<input type="hidden" name="result" value=false />
										<input type="hidden" id="nickname" value="${login.nickname}"/>
										<input type="hidden" name="writer" value="${post.writer}"/> 
										<c:if test="${login.account == post.writer}">
											<input type="button" value="수정" id="updateBtn" class="button primary" />
											<input type="submit" value="삭제" id="deleteBtn" class="button primary" onclick="return confirm('정말로 삭제하시겠습니까?')" />
										</c:if>
									</form>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="table-wrapper">
						<table>
							<tbody>
								<tr>
									<td colspan="3">
									<nav id="comment">
									<ul>
										<li><span class="opener">댓글 작성</span>
									<ul>
										<li>   
											<strong>${login.nickname} ( ${login.account == null ? '비회원' :''}${login.account} )</strong>
											<textarea id="commentContent" class="autosize" rows="3" placeholder="${login == null ? '로그인을 해주세요~':'댓글을 입력해주세요!' }" maxlength="300" ${login == null ? 'disabled':'' } style="resize: none;"></textarea>
											<input type="button" class="primary" id="comment_btn" value="입력" ${login == null ? 'disabled':'' }/>
										</li>
									</ul>
									</li>
									</ul>
									</nav>		
									
								</tr>
								<c:forEach var="comment" items="${commentList}">
								<tr>
									<td></td>
									<td>
										<c:if test="${post.writer == comment.commentWriter}">
										<i class="fas fa-user-edit" id="writerIcon" style="color: #F56A6A;"></i>
										</c:if>
										<strong>${comment.nickname} ( ${comment.commentWriter} ) &nbsp;&bull;&nbsp; ${comment.time}&nbsp;&nbsp;<span style="color: gray;">${comment.ismodify}</span>
										<c:if test="${login.account == comment.commentWriter}">
										&nbsp;&nbsp;&nbsp;<a href="javascript:openModal('modal${comment.commentNo}');" id="commentEdit" class="icon" ><i class="fas fa-edit" ></i></a>
										&nbsp;&nbsp;&nbsp;<a href="javascript:delComment('${comment.commentNo}');" id="commentDelete"class="icon" onclick="return confirm('댓글을 정말로 삭제하시겠습니까?')"><i class="far fa-trash-alt" ></i></a>
										</c:if>
										</strong>
											<pre style="font-family: Noto Sans KR; font-size: 1em; word-wrap: break-word; white-space: pre-wrap; white-space: -moz-pre-wrap; white-space: -pre-wrap; white-space: -o-pre-wrap; word-break: break-all;">${comment.commentContent}</pre>
											<div id="modal"></div>
											<div class="modal-con modal${comment.commentNo}" style="z-index: 1;">
												<div class="con">
												<i class="fas fa-user-edit" id="writerIcon" style="color: #F56A6A;"></i>
												<strong>${comment.nickname} ( ${comment.commentWriter} ) &nbsp;&bull;&nbsp; ${comment.time}</strong>
												<form action="/board/updateComment" method="post">
												<input type="hidden" name="postNo" value="${comment.postNo}"/>
												<input type="hidden" name="commentNo" value="${comment.commentNo}"/>
												<input type="hidden" name="commentWriter" value="${comment.commentWriter}"/> 
												<textarea name="commentContent" class="autosize" style="margin-top:1em; resize: none;" maxlength="300" ${comment.commentWriter == login.account ? '':'disabled' }>${comment.commentContent}</textarea>
												<input type="submit" value="수정" />
												</form>
												</div>
											</div>
											
										<ul class="icons" style="text-align: left; font-size: 1em; margin-bottom: 0;">
											<li><a id="commentLikeBtn" class="icon" onclick="return confirm('현재 구현중입니다 조금만 기다려주세요~')"><i id="likeIcon" class="far fa-thumbs-up"></i></a> 
											<span id="likes"><b class="icon">0</b></span></li>
											<li><a id="commentDislikeBtn" class="icon" onclick="return confirm('현재 구현중입니다 조금만 기다려주세요~')"><i id="dislikeIcon" class="far fa-thumbs-down"></i></a>
											<span id="dislikes"><b class="icon">0</b></span></li>
											<li><a id="replyBtn" class="icon" onclick="return confirm('현재 구현중입니다 조금만 기다려주세요~')"><i class="far fa-comment-alt"></i></a>
											<span id="replyNum"><b class="icon">0</b></span></li>
										</ul>
									</td>
									<td>${comment.regDate}</td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />
	</div>
	<script src="<c:url value='/resources/assets/js/view.js' />"></script>

</body>
</html>