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
<title>GreatRoot-Version</title>
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

				<jsp:include page="include/header.jsp" />

				<!-- Content -->
				<section>
					<header class="main">
						<h1>Version</h1>
					</header>

					<span class="image main"><img
						src="<c:url value='/resources/images/sakura.jpg' />" alt="" /></span>

					<h2>홈페이지 개설일 : 2021년 1월 23일</h2>

					<hr class="major" />

					<div class="row">
						<div class="col-12-small">
							<h2>1.5.0 (21.2.28)</h2>
							<ul>
								<li><a href="/board/postView/62">댓글 기능 구현</a></li>
							</ul>
							<h2>1.4.2 (21.2.22)</h2>
							<ul>
								<li><a href="/board/postView/61">404, 500 에러페이지 구축</a></li>
								<li><a href="/board/postView/61">조회수 버그 수정</a></li>
								<li><a href="/board/postView/61">상세글 작성날짜, 조회수 항목 추가</a></li>
							</ul>
							<h2>1.4.1 (21.2.13)</h2>
							<ul>
								<li><a href="/board/postView/60">회원 정보 변경 버그 수정</a></li>
							</ul>
							
							<h2>1.4.0 (21.2.13)</h2>
							<ul>
								<li><a href="/board/postView/59">메일 인증 기능 구현</a></li>
								<li>회원정보 변경시 기존 비밀번호 인증버튼 추가</li>
								<li>회원정보 변경시 기존 닉네임 사용버튼 추가</li>
								<li>회원정보 변경시 이메일 readonly -> disabled 로 변경</li>
							</ul>
						
							<h2>1.3.0 (21.2.4)</h2>
							<ul>
								<li><a href="/board/postView/57">좋아요 싫어요 기능 구현</a></li>
								<li>Version 메뉴바 추가</li>
							</ul>

							<h2>1.2.1 (21.2.1)</h2>
							<ul>
								<li><a href="/board/postView/29">DB서버 이전 (AWS RDS 프리티어로
										이전)</a></li>
								<li><a href="/board/postView/29">SSL인증서 변경(Certificate
										Manager -> Let's Encrypt)</a></li>
								<li><a href="/board/postView/49">게시물 제목, 내용이 Null 상태로
										서버로 전송되는 버그 수정</a></li>
								<li><a href="/board/postView/49">날짜 출력 방식 변경(0000.00.00
										-> 00일 전)</a></li>
								<li>List 화면 구성 변경</li>
							</ul>

							<h2>1.2.0 (21.1.29)</h2>
							<ul>
								<li><a href="/board/postView/27">회원 탈퇴 기능 구현</a></li>
								<li><a href="/board/postView/27">DB에 잘못된 날짜가 입력되는 버그 수정</a></li>
								<li><a href="/board/postView/28">사용자 입력값에 의한 페이지 주석처리
										버그 수정</a></li>
								<li>비회원 게시판 접근 허용 (게시글 작성,수정,삭제 권한 없음)</li>
							</ul>

							<h2>1.1.0 (21.1.25)</h2>
							<ul>
								<li><a href="/board/postView/21">회원 정보 수정 기능 구현</a></li>
								<li><a href="/board/postView/23">게시글 column 용량 초과 에러
										수정(DB column 용량 제한 변경)</a></li>
								<li><a href="/board/postView/25">SSL인증서 획득 (AWS
										Certificate Manager)</a></li>
								<li><a href="/board/postView/26">모바일에서 페이지 번호 안나오는 버그
										수정</a></li>
								<li>비회원이 게시판 클릭시 경고창 출력</li>
							</ul>

							<h2>1.0.0 (21.1.23)</h2>
							<ul>
								<li>톰캣 서버 구축 (tomcat8)</li>
								<li>오라클 DB서버 구축 (AWS RDS)</li>
								<li>도메인 호스팅 (AWS Route 53)</li>
								<li>회원가입 기능 구현</li>
								<li>로그인 기능 구현</li>
								<li>게시글 목록,글 검색,글 작성,상세보기,글 수정,글 삭제 기능 구현</li>
								<li>페이징 기능 구현</li>
								<li>회원만 게시판 접근 허가 기능 구현</li>
							</ul>
						</div>
					</div>
				</section>

			</div>
		</div>

		<jsp:include page="include/sidebar.jsp" />

	</div>

</body>
</html>