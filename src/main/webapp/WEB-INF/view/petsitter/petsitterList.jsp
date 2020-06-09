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
						<input type="radio" name="sizeOptions" id="petSize" value="size"> 소형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="sizeOptions" id="petSize" value="size"> 중형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="sizeOptions" id="petSize" value="size"> 대형
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요일</span></td>
				<td align="center">
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 월요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 화요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 수요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 목요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 금요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 토요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="day"> 일요일
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요금</span></td>
				<td align="center">
					<label class="radio-inline">
						<input type="radio" name="priceOptions" id="petPrice" value="price"> \5000-\7000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="priceOptions" id="petPrice" value="price"> \7100-\9000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="priceOptions" id="petPrice" value="price"> \9100-\11000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="priceOptions" id="petPrice" value="price"> \11000-\13000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="priceOptions" id="petPrice" value="price"> \13100-\15000
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">지역</span></td>
				<td align="center">
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 서울
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 경기도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 강원도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 충청남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 충청북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 전라남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 전라북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 경상남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 경상북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="local"> 제주도
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