<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="section-title">
	<div class="container">
		<span class="caption d-block small">Categories</span>
		<h2>Politics</h2>
	</div>
</div>
	<div class="sideContainer d-md-flex align-items-stretch">
		<div id="content" class="p-4 p-md-5 pt-5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>글 제목</th>
						<th>작성자</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>인스타에 사진 3000장 올려주세요</td>
						<td>김콩</td>
					</tr>
					<tr>
						<td>2</td>
						<td>골골송 한번만 불러주세요</td>
						<td>양갱</td>
					</tr>
				</tbody>
			</table>
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
		<nav id="sidebar">
			<div class="p-4 pt-5">
				<!-- <span style="color:black"><h5>Categories</h5></span> -->
				<ul class="list-unstyled components mb-5">
					<li><a href="#pageSubmenu1">회원 정보 수정</a></li>
          			<li>
			            <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">내가 쓴 글</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu2">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
	          		<li>ㄴ
			            <a href="#pageSubmenu3" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">내가 쓴 댓글</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu3">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
	          		<li>
			            <a href="#pageSubmenu4" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">북마크</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu4">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
	          		<li>
			            <a href="#pageSubmenu5" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">장바구니</a>
			            <ul class="collapse list-unstyled" id="pageSubmenu5">
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>정보 게시판</a></li>
			                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>질문 게시판</a></li>
			            </ul>
	          		</li>
				</ul>
			</div>
		</nav>
	</div>