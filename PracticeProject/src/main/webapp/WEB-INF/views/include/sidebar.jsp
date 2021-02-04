<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Sidebar -->

<div id="sidebar">
	<div class="inner">
		<c:if test="${login == null}">
		<form>
		<h3>로그인</h3><label id="sign_result"></label>
			<div class="row gtr-uniform">
				<div class="col-12">
					<input type="text" maxlength="14" id="sign_account" name="sign_account" placeholder="ID"/>
					<input type="password" maxlength="16" id="sign_password" name="sign_password" placeholder="Password" />
					<input type="button" id="signIn-btn" value="로그인" class="primary" />
					<a href="<c:url value='/user/register' />" class="button primary" style="margin-left: 5px;">회원가입</a>
				</div>
				<div class="col-6 col-12-small">
					<input type="checkbox" id="auto-login" name="autoLogin"/> 
					<label for="auto-login">자동 로그인</label>
				</div>
			</div>
		</form>
		</c:if>
		<c:if test="${login != null}">
		<div class="row gtr-uniform">
		<p><label style="font-size: 20px;">${login.account}님 환영합니다!</label>
		<a href="/user/logout" class="button primary" >로그아웃</a>
		<a href="/user/modifyUserInfo" class="button primary" style="padding: 0 20px 0 20px;">회원정보변경</a>
		</p>
		</div>
		</c:if>
		<!-- Menu -->
		<nav id="menu">
			<header class="major">
				<h2>Menu</h2>
			</header>
			<ul>
				<li><a href="<c:url value='/' />">Homepage</a></li>
				<li><a href="<c:url value='/version' />">Version</a></li>
				<li><a href="<c:url value='/elements' />">Elements</a></li>
				<li><span class="opener">Submenu</span>
					<ul>
						<li><a href="http://www.naver.com" target="_blank">naver</a></li>
					</ul></li>
				<li><a href="<c:url value='/board/list'/>" >Board</a></li>


			</ul>
		</nav>
		<!-- Section -->
		<section>
			<header class="major">
				<h2>Ante interdum</h2>
			</header>
			<div class="mini-posts">
				<article>
					<a href="#" class="image"><img src="<c:url value='/resources/images/pic07.jpg' />" alt="" /></a>
					<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper
						dolore aliquam.</p>
				</article>
				<article>
					<a href="#" class="image"><img src="<c:url value='/resources/images/pic08.jpg' />" alt="" /></a>
					<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper
						dolore aliquam.</p>
				</article>
				<article>
					<a href="#" class="image"><img src="<c:url value='/resources/images/pic09.jpg' />" alt="" /></a>
					<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper
						dolore aliquam.</p>
				</article>
			</div>
			<ul class="actions">
				<li><a href="#" class="button">More</a></li>
			</ul>
		</section>

		<!-- Section -->
		<section>
			<header class="major">
				<h2>Get in touch</h2>
			</header>
			<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare
				velit lacus, ac varius enim lorem ullamcorper dolore. Proin sed
				aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus
				aliquam.</p>
			<ul class="contact">
				<li class="icon solid fa-envelope"><a href="#">qhrmsqhrms12@naver.com</a></li>
				<li class="icon solid fa-phone">(000) 000-0000</li>
				<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
					Nashville, TN 00000-0000
				</li>
			</ul>
		</section>

		<!-- Footer -->
		<footer id="footer">
			<p class="copyright">
				&copy; Untitled. All rights reserved. Demo Images: <a
					href="https://unsplash.com">Unsplash</a>. Design: <a
					href="https://html5up.net">HTML5 UP</a>.
			</p>
		</footer>

	</div>
</div>

	<!-- Scripts -->
	<script src="<c:url value='/resources/assets/js/jquery.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/browser.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/breakpoints.min.js' />"></script>
	<script src="<c:url value='/resources/assets/js/util.js' />"></script>
	<script src="<c:url value='/resources/assets/js/main.js' />"></script>
	<script src="<c:url value='/resources/assets/js/login.js' />"></script>
