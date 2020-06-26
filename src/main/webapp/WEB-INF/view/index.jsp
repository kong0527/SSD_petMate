<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>
<div class="site-section py-0">
	<div class="owl-carousel hero-slide owl-style">
	<div class="site-section">
			<div class="container">
				<div class="half-post-entry d-block d-lg-flex bg-light">
					<div class="img-bg"
						style="background-image: url('resources/img/kong.jpg')"></div>
					<div class="contents">
						<span class="caption">Today's Best</span>
						<h2>
							<a href="<c:url value="/infoDetail">
							<c:param name="boardNum" value="${dailyBestInfo.boardNum}"/>
							</c:url>">${dailyBestInfo.boardTitle}</a>
						</h2>
						<p class="mb-3">
							<c:choose>
								<c:when test="${fn:length(dailyBestInfo.boardContent) > 200}">
									${fn:substring(dailyBestInfo.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 200)}...
								</c:when>
								<c:otherwise>
									${dailyBestInfo.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
								 </c:otherwise> 
							 </c:choose>
						</p>

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
						style="background-image: url('resources/img/yang.jpg')"></div>
					<div class="contents">
						<span class="caption">Today's Best</span>
						<h2>
							<a href="<c:url value="/inquiryDetail">
							<c:param name="boardNum" value="${dailyBestInquiry.boardNum}"/>
							</c:url>">${dailyBestInquiry.boardTitle}</a>
						</h2>
						<p class="mb-3">
							<c:choose>
								<c:when test="${fn:length(dailyBestInquiry.boardContent) > 200}">
									${fn:substring(dailyBestInquiry.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 200)}...
								</c:when>
								<c:otherwise>
									${dailyBestInquiry.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
								 </c:otherwise> 
							 </c:choose>
						</p>
						<div class="post-meta">
							<span class="d-block">${dailyBestInquiry.userID}</span> 
							<span class="date-read">${dailyBestInquiry.boardDate} <span class="mx-1">&bullet;</span> 
								${dailyBestInquiry.boardLike} <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="site-section">
			<div class="container">
				<div class="half-post-entry d-block d-lg-flex bg-light">
					<div class="img-bg"
						style="background-image: url('resources/img/kong2.jpg')"></div>
					<div class="contents">
						<span class="caption">Today's Best</span>
						<h2>
							<a href="<c:url value="/reviewDetail">
							<c:param name="boardNum" value="${dailyBestReview.boardNum}"/>
							</c:url>">${dailyBestReview.boardTitle}</a>
						</h2>
						<p class="mb-3">
							<c:choose>
								<c:when test="${fn:length(dailyBestReview.boardContent) > 200}">
									${fn:substring(dailyBestReview.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 200)}...
								</c:when>
								<c:otherwise>
									${dailyBestReview.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
								 </c:otherwise> 
							 </c:choose>
						</p>
						<div class="post-meta">
							<span class="d-block">${dailyBestReview.userID}</span> 
							<span class="date-read">${dailyBestReview.boardDate} <span class="mx-1">&bullet;</span> 
								${dailyBestReview.boardLike} <span class="icon-star2"></span></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		
			<div class="site-section">
			<div class="container">
				<div class="half-post-entry d-block d-lg-flex bg-light">
					<div class="img-bg"
						style="background-image: url('resources/img/yang2.jpg')"></div>
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
		 		<!-- <div class="thumbnail"
						style="background-image: url('resources/img/second.png')"></div> -->
					<div class="contents">
						<h2>
							<a href="<c:url value="/infoDetail">
						<c:param name="boardNum" value="${infoList.boardNum}"/>
						</c:url>">${infoList.boardTitle}</a>
						</h2>
						<p class="mb-3">
							<c:choose>
								<c:when test="${fn:length(infoList.boardContent) > 100}">
									${fn:substring(infoList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 100)}...
								</c:when>
								<c:otherwise>
									${infoList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
								</c:otherwise> 
							 </c:choose>
						</p>
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
					<h2>질문 게시판</h2>
				</div>
				<c:forEach var="inquiryList" items="${weeklyBestInquiry}">
					<div class="post-entry-2 d-flex">
			 		<!-- <div class="thumbnail"
							style="background-image: url('resources/img/second.png')"></div> -->
						<div class="contents">
							<h2>
								<a href="<c:url value="/inquiryDetail">
							<c:param name="boardNum" value="${inquiryList.boardNum}"/>
							</c:url>">${inquiryList.boardTitle}</a>
							</h2>
							<p class="mb-3">
								<c:choose>
									<c:when test="${fn:length(inquiryList.boardContent) > 100}">
										${fn:substring(inquiryList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 100)}...
									</c:when>
									<c:otherwise>
										${inquiryList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
									 </c:otherwise> 
							 	</c:choose>
							</p>
							<div class="post-meta">
								<span class="d-block">${inquiryList.userID}</span> 
								<span class="date-read">
									${inquiryList.boardDate}
								<span class="mx-1">&bullet;</span> ${inquiryList.boardLike} <span class="icon-star2"></span></span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-lg-6">
				<div class="section-title">
					<h2>펫시터 리뷰 게시판</h2>
				</div>
				<c:forEach var="reviewList" items="${weeklyBestReview}">
					<div class="post-entry-2 d-flex">
			 		<!-- <div class="thumbnail"
							style="background-image: url('resources/img/second.png')"></div> -->
						<div class="contents">
							<h2>
								<a href="<c:url value="/reviewDetail">
							<c:param name="boardNum" value="${reviewList.boardNum}"/>
							</c:url>">${reviewList.boardTitle}</a>
							</h2>
							<p class="mb-3">
								<c:choose>
									<c:when test="${fn:length(reviewList.boardContent) > 100}">
										${fn:substring(reviewList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""),0, 100)}...
									</c:when>
									<c:otherwise>
										${reviewList.boardContent.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "")}
									 </c:otherwise> 
							 	</c:choose>
							</p>
							<div class="post-meta">
								<span class="d-block">${reviewList.userID}</span> 
								<span class="date-read">
									${reviewList.boardDate}
								<span class="mx-1">&bullet;</span> ${reviewList.boardLike} <span class="icon-star2"></span></span>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</body>
<style>
.selector img{
	position: absolute; top:0; left: 0;
	width: 100%;
	height: 100%;
}
</style>