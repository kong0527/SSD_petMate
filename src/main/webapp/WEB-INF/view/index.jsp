<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
<div class="site-section py-0">
	<div class="owl-carousel hero-slide owl-style">
		<div class="site-section">
			<div class="container">
				<div class="half-post-entry d-block d-lg-flex bg-light">
					<div class="img-bg"
						style="background-image: url('resources/img/big_img_1.jpg')"></div>
					<div class="contents">
						<span class="caption">Editor's Pick</span>
						<h2>
							<a href="blog-single.html">${dailyBestInfo.boardTitle}</a>
						</h2>
						<p class="mb-3">${dailyBestInfo.boardContent}</p>

						<div class="post-meta">
							<span class="d-block">${dailyBestInfo.userID}</span> 
							<span class="date-read">${dailyBestInfo.boardDate} <span class="mx-1">&bullet;</span> 
								${dailyBestInfo.boardLike} <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="site-section">
			<div class="container">
				<div class="half-post-entry d-block d-lg-flex bg-light">
					<div class="img-bg"
						style="background-image: url('resources/img/big_img_1.jpg')"></div>
					<div class="contents">
						<span class="caption">Editor's Pick</span>
						<h2>
							<a href="blog-single.html">News Needs to Meet Its Audiences
								Where They Are</a>
						</h2>
						<p class="mb-3">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Voluptate vero obcaecati natus adipisci
							necessitatibus eius, enim vel sit ad reiciendis. Enim praesentium
							magni delectus cum, tempore deserunt aliquid quaerat culpa nemo
							veritatis, iste adipisci excepturi consectetur doloribus aliquam
							accusantium beatae?</p>

						<div class="post-meta">
							<span class="d-block"><a href="#">Dave Rogers</a> in <a
								href="#">Food</a></span> <span class="date-read">Jun 14 <span
								class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- END section -->

<div class="site-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<div class="section-title">
					<h2>정보 게시판</h2>
				</div>
				<c:forEach var="infoList" items="${weeklyBestInfo}">
				<div class="post-entry-2 d-flex">
		<!-- 		<div class="thumbnail"
						style="background-image: url('resources/img/first.png')"></div> -->
					<div class="contents">
						<h2>
							<a href="<c:url value="/infoDetail">
						<c:param name="boardNum" value="${infoList.boardNum}"/>
						</c:url>">${infoList.boardTitle}</a>
						</h2>
						<p class="mb-3">${infoList.boardContent}</p>
						<div class="post-meta">
							<span class="d-block">${infoList.userID}</span> 
							<span class="date-read">
								${infoList.boardDate}
							<span class="mx-1">&bullet;</span> ${infoList.boardLike} <span class="icon-star2"></span></span>
						</div>
					
					</div>
				</div>
				</c:forEach>
			</div>
			<div class="col-lg-6">
				<div class="section-title">
					<h2>Business</h2>
				</div>
				<div class="post-entry-2 d-flex">
					<div class="thumbnail"
						style="background-image: url('resources/img/img_v_1.jpg')"></div>
					<div class="contents">
						<h2>
							<a href="blog-single.html">News Needs to Meet Its Audiences
								Where They Are</a>
						</h2>
						<p class="mb-3">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Eligendi temporibus praesentium neque,
							voluptatum quam quibusdam.</p>
						<div class="post-meta">
							<span class="d-block"><a href="#">Dave Rogers</a> in <a
								href="#">News</a></span> <span class="date-read">Jun 14 <span
								class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
				<div class="post-entry-2 d-flex">
					<div class="thumbnail"
						style="background-image: url('resources/img/img_v_2.jpg')"></div>
					<div class="contents">
						<h2>
							<a href="blog-single.html">News Needs to Meet Its Audiences
								Where They Are</a>
						</h2>
						<p class="mb-3">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Eligendi temporibus praesentium neque,
							voluptatum quam quibusdam.</p>
						<div class="post-meta">
							<span class="d-block"><a href="#">Dave Rogers</a> in <a
								href="#">News</a></span> <span class="date-read">Jun 14 <span
								class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
				<div class="post-entry-2 d-flex">
					<div class="thumbnail"
						style="background-image: url('resources/img/img_v_3.jpg')"></div>
					<div class="contents">
						<h2>
							<a href="blog-single.html">News Needs to Meet Its Audiences
								Where They Are</a>
						</h2>
						<p class="mb-3">Lorem ipsum dolor sit amet, consectetur
							adipisicing elit. Eligendi temporibus praesentium neque,
							voluptatum quam quibusdam.</p>
						<div class="post-meta">
							<span class="d-block"><a href="#">Dave Rogers</a> in <a
								href="#">News</a></span> <span class="date-read">Jun 14 <span
								class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>