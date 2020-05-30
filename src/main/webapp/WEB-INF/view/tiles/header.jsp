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
               <div class="col-12 col-lg-6 ml-auto d-flex">
                  <div class="ml-md-auto top-social d-none d-lg-inline-block">
                       <a href="${pageContext.request.contextPath}/signIn">로그인</a> &nbsp;&nbsp; | &nbsp;&nbsp;
                       <a href="${pageContext.request.contextPath}/signUp">회원가입</a>
                  </div>
          </div>
          </div>
          <div class="container">
	          <ul id="nav4" class="nav justify-content-between">
	          <li class="nav-item"> <a class="nav-link active" href="#"><span style="color:black">질문게시판</span></a> </li> 
	          <li class="nav-item"> <a class="nav-link" href="#"><span style="color:black">정보게시판</span></a> </li> 
	          <li class="nav-item"> <a class="nav-link" href="#"><span style="color:black">공구게시판</span></a> </li> 
	          <li class="nav-item"> <a class="nav-link" href="${pageContext.request.contextPath}/secondhand"><span style="color:black">중고게시판</span></a> </li> 
	          <li class="dropdown">
	          	<a href="#" class="dropdown-toggle" data-toggle="dropdown"><span style="color:black">펫시터게시판</span></a>
				<ul class="dropdown-menu">
					<li class="navbar-dark"><a href="#"><span style="color:black">구인게시판</span></a></li> 
	            	<li class="navbar-dark"><a href="#"><span style="color:black">후기게시판</span></a></li> 
				</ul>
	          </li>
	          </ul>
          </div>
		</div>
	</div>
	</div>