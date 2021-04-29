<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML>

<html>
<head>
<title>메일인증 결과 페이지</title>
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
								${msg}
							</h1>
						</header>
					</div>
				</section>

			</div>
		</div>

		<jsp:include page="../include/sidebar.jsp" />

	</div>

</body>
</html>