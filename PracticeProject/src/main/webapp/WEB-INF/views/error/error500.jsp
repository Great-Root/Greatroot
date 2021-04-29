<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>
<html>
<head>
<title>에러 페이지</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="<c:url value='/resources/assets/css/main.css'/>">
<link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<jsp:include page="../include/header.jsp" />

				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
							<h1>
								게시글을 찾을 수가 없어요<br>
								다시 확인해주세요! 
							</h1>
							<h2><a href='<c:url value="/"/>' class="button">홈페이지로 가기</a>
							<a href='<c:url value="/board/list"/>' class="button">게시판로 가기</a></h2>
							<h2>문의 메일 <a href="#" id="copy_btn" ><input type="text" id="email" value="qhrmsqhrms12@naver.com"></a></h2>
						</header>

					</div>
				</section>
			</div>
		</div>
		<jsp:include page="../include/sidebar.jsp" />

	</div>
<script type="text/javascript">
$(function(){
	$('#copy_btn').click(function(){
		$('#email').select(); //복사할 텍스트를 선택
		document.execCommand("copy"); //클립보드 복사 실행
		alert('복사완료');
	});
});
</script>
</body>
</html>