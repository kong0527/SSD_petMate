<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="section-title">
	<span class="caption d-block small">Categories</span>
		<h2>구인게시판</h2>
</div>
	<table class="table">
		<tbody>
			<tr>
				<td align="center"><span style="font-weight:bold;">크기</span></td>
				<td align="center">
					<label class="radio-inline">
						<input type="radio" name="petSize" id="petSize" value="소형"> 소형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petSize" id="petSize" value="중형"> 중형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petSize" id="petSize" value="대형"> 대형
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요일</span></td>
				<td align="center">
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="월요일"> 월요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="화요일"> 화요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="수요일"> 수요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="목요일"> 목요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="금요일"> 금요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="토요일"> 토요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" name="petDay" id="petDay" value="일요일"> 일요일
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요금</span></td>
				<td align="center">
					<label class="radio-inline">
						<input type="radio" name="petPrice" id="petPrice" value="price1"> \5000-\7000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petPrice" id="petPrice" value="price2"> \7100-\9000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petPrice" id="petPrice" value="price3"> \9100-\11000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petPrice" id="petPrice" value="price4"> \11000-\13000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="petPrice" id="petPrice" value="price5"> \13100-\15000
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">지역</span></td>
				<td align="center">
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="서울"> 서울
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocals" id="petLocal" value="경기도"> 경기도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="강원도"> 강원도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="충청남도"> 충청남도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="충청북도"> 충청북도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="전라남도"> 전라남도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="전라북도"> 전라북도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="경상남도"> 경상남도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="경상북도"> 경상북도
							</label>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<label class="radio-inline">
			  					<input type="radio" name="petLocal" id="petLocal" value="제주도"> 제주도
							</label>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<a href="#"><span style="color:black">선택한 조건으로 검색하기</span></a>
				</td>
			</tr>
		</tbody>
	</table>
</div>
<div class="site-section">
	<div class="container">
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
				<c:forEach var="petsitterList" items="${petsitterList}">
					<tr>
						<td>${petsitterList.boardNum}</td>
						<td><a href="<c:url value="/petsitterDetail">
						<c:param name="boardNum" value="${petsitterList.boardNum}"/>
						</c:url>">${petsitterList.boardTitle}</a></td>
						<td>${petsitterList.userID}</td>
						<td>${petsitterList.replyCnt}</td>
						<td>${petsitterList.boardLike}</td>
						<td>${petsitterList.boardHit}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<table class="text-right" align="right">
				<tr>
					<td>
						<a href="petsitterForm"><input type="submit" class="btn" value="글 작성" /></a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</div>
<div class="pagination-row" style="text-align: center;">
	<ul class="custom-pagination list-unstyled">
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#">></a></li>
	</ul>
</div>