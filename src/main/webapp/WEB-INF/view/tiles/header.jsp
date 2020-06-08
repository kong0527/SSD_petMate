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
           <ul class="nav justify-content-between">
          	<li><a href="#"><span style="color:black">질문게시판</span></a></li>
          	<li><a href="${pageContext.request.contextPath}/info"><span style="color:black">정보게시판</span></a></li>
          	<li><a href="#"><span style="color:black">공구게시판</span></a></li>
          	<li><a href="${pageContext.request.contextPath}/secondhand"><span style="color:black">중고게시판</span></a></li>
          	<li><a href="${pageContext.request.contextPath}/cart"><span style="color:black">관리자 (임시)</span></a></li>
          	<li class="dropdown">
          		<a class="dropdown-toggle" data-toggle="dropdown"><span style="color:black">펫시터게시판</span><span class="caret"></span></a>
          		<ul class="dropdown-menu">
          			<li><a href="${pageContext.request.contextPath}/petsitterList"><span style="color:black">구인게시판</span></a></li>
          			<li><a href="#"><span style="color:black">리뷰게시판</span></a></li>
          		</ul>
          </ul>
		</div>
	</div>
	</div>