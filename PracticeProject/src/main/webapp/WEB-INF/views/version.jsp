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
<title>Generic - Editorial by HTML5 UP</title>
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

					<p>홈페이지 개설일 : 2021년 1월 23일</p>

					<hr class="major" />
					
					<h2>1.0.0 (21.1.23)</h2>
					<div class="row">
						<div class="col-6 col-12-small">
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
					<h2>1.0.1 (21.1.27)</h2>
					<div class="row">
						<div class="col-6 col-12-small">
							<ul>
								<li>비회원이 게시판 클릭시 경고창 출력</li>
								<li>SSL인증서 획득 (AWS Certificate Manager)</li>
								<li>모바일에서 페이지 번호 안나오는 버그 수정</li>
								<li>게시글 용량 초과 에러 수정(DB용량 변경)</li>
								<li>List 화면 구성 변경</li>
							</ul>
						</div>
					</div>
					<h2>1.1.0</h2>
					<div class="row">
						<div class="col-6 col-12-small">
							<ul>
								<li>회원 탈퇴 기능 구현</li>
								<li>DB에 잘못된 날짜가 입력되는 버그 수정</li>
								<li>비회원 게시판 접근 허용 (게시글 작성,수정,삭제 권한 없음)</li>
							</ul>
						</div>
					</div>

					<hr class="major" />

					<h2>Magna etiam veroeros</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos. Etiam
						tristique libero eu nibh porttitor fermentum. Nullam venenatis
						erat id vehicula viverra. Nunc ultrices eros ut ultricies
						condimentum. Mauris risus lacus, blandit sit amet venenatis non,
						bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
						euismod in lectus. Pellentesque habitant morbi tristique senectus
						et netus et malesuada fames ac turpis egestas. In non lorem sit
						amet elit placerat maximus. Pellentesque aliquam maximus risus,
						vel sed vehicula.</p>
					<p>Interdum et malesuada fames ac ante ipsum primis in
						faucibus. Pellentesque venenatis dolor imperdiet dolor mattis
						sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit
						amet. Pellentesque leo mauris, consectetur id ipsum sit amet,
						fersapien risus, commodo eget turpis at, elementum convallis elit.
						Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

					<hr class="major" />

					<h2>Lorem aliquam bibendum</h2>
					<p>Donec eget ex magna. Interdum et malesuada fames ac ante
						ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
						dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas
						enim auctor sit amet. Pellentesque leo mauris, consectetur id
						ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia
						malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium
						pulvinar mauris. Curabitur sapien risus, commodo eget turpis at,
						elementum convallis elit. Pellentesque enim turpis, hendrerit.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos. Etiam
						tristique libero eu nibh porttitor fermentum. Nullam venenatis
						erat id vehicula viverra. Nunc ultrices eros ut ultricies
						condimentum. Mauris risus lacus, blandit sit amet venenatis non,
						bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
						euismod in lectus. Pellentesque habitant morbi tristique senectus
						et netus et malesuada fames ac turpis egestas. In non lorem sit
						amet elit placerat maximus. Pellentesque aliquam maximus risus,
						vel sed vehicula.</p>

				</section>

			</div>
		</div>

		<jsp:include page="include/sidebar.jsp" />

	</div>

</body>
</html>