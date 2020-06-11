<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="site-section">
	<div class="container">
		<div class="section-title">
			<span class="caption d-block small">Categories</span>
			<h2>질문 게시판</h2>
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
				<c:forEach var="inquiryList" items="${inquiryList}">
					<tr>
						<td>${inquiryList.boardNum}</td>
						<td><a href="<c:url value="/inquiryDetail">
						<c:param name="boardNum" value="${inquiryList.boardNum}"/>
						</c:url>">${inquiryList.boardTitle}</a></td>
						<td>${inquiryList.userID}</td>
						<td>${inquiryList.answerCnt}</td>
						<td>${inquiryList.boardLike}</td>
						<td>${inquiryList.boardHit}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table class="text-right" align="right">
				<tr>
					<td>
						<a href="inquiryForm"><input type="submit" class="btn" value="글 작성" /></a>
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
