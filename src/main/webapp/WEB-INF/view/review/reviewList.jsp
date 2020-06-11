<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="site-section">
	<div class="container">
		<div class="section-title">
			<span class="caption d-block small">Categories</span>
			<h2>리뷰 게시판</h2>
		</div>
		<div class="table-wrapper">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>글 제목</th>
						<th>작성자</th>
						<th>덧글수</th>
						<th>추천수</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="reviewList" items="${reviewList}">
					<tr>
						<td>${reviewList.boardNum}</td>
						<td><a href="<c:url value="/reviewDetail">
						<c:param name="boardNum" value="${reviewList.boardNum}"/>
						</c:url>">${reviewList.boardTitle}</a></td>
						<td>${reviewList.userID}</td>
						<td>${reviewList.replyCnt}</td>
						<td>${reviewList.boardLike}</td>
						<td>${reviewList.boardHit}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table class="text-right" align="right">
				<tr>
					<td>
						<a href="reviewForm"><input type="submit" class="btn" value="글 작성" /></a>
					</td>
				</tr>
			</table>
		</div>
		<div class="pagination-row" style="text-align: center;">
			<ul class="custom-pagination list-unstyled">
				<li><a href="#">1</a></li>
				<li class="active"><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">></a></li>
			</ul>
		</div>
	</div>
</div>
