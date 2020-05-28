<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div class="site-wrap">
		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>

		<div class="header-top">
			<div class="container">
				<div class="row align-items-center">
					<div class="col-12 col-lg-6 d-flex">
						<a href="${pageContext.request.contextPath}/index" class="site-logo"> petMate </a> <a href="#"
							class="ml-auto d-inline-block d-lg-none site-menu-toggle js-menu-toggle text-black"><span
							class="icon-menu h3"></span></a>
					</div>
				</div>
			</div>

			<div
				class="site-navbar py-2 js-sticky-header site-navbar-target d-none pl-0 d-lg-block"
				role="banner">

				<div class="container">
					<div class="d-flex align-items-center">

						<div class="mr-auto">
							<nav class="site-navigation position-relative text-right" role="navigation">
								<%-- <ul
									class="site-menu main-menu js-clone-nav mr-auto d-none pl-0 d-lg-block">
									<li class="active"><a href="index.html"
										class="nav-link text-left">Home</a></li>
									<li><a href="categories.html" class="nav-link text-left">Categories</a>
									</li>
									<li><a href="${pageContext.request.contextPath}/secondhandForm" class="nav-link text-left">secondhand</a>
									</li>
									<li><a href="${pageContext.request.contextPath}/secondhandForm" class="nav-link text-left">Business</a>
									</li>
									<li><a href="categories.html" class="nav-link text-left">Health</a>
									</li>
									<li><a href="categories.html" class="nav-link text-left">Design</a></li>
									<li><a href="categories.html" class="nav-link text-left">Sport</a>
									</li>
									<li><a href="contact.html" class="nav-link text-left">Contact</a></li>
								</ul> --%>
								<div class="site-menu dropdown">
								  <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    자유 게시판
								  </a>
								  <div class="dropdown-menu">
								    <a class="dropdown-item" href="#">정보 게시판</a>
								    <a class="dropdown-item" href="#">질문 게시판</a>
								  </div>
								</div>
								
								<div class="dropdown">
								  <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    자유 게시판
								  </a>
								  <div class="dropdown-menu">
								    <a class="dropdown-item" href="#">정보 게시판</a>
								    <a class="dropdown-item" href="#">질문 게시판</a>
								  </div>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
