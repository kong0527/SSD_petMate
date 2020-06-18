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
						<c:if test="${petsitterChk < 0}" >
							<a href="signIn" onclick="alert('로그인이 필요합니다.')"><input type="submit" class="btn" value="글 작성" /></a>
						</c:if>
						<c:if test="${petsitterChk == 1}">
							<a href="#" onclick="alert('펫시터 회원만 작성할 수 있습니다.')"><input type="submit" class="btn" value="글 작성" /></a>
						</c:if>
						<c:if test="${petsitterChk == 0}">
							<a href="petsitterForm"><input type="submit" class="btn" value="글 작성" /></a>
						</c:if>
					</td>
				</tr>
			</table>
		</div>
		<div class="pagination-row" style="text-align: center;">
			<ul class="custom-pagination list-unstyled">
				<c:if test="${boardSearch.prev}">
					<li>
					<a onClick="fn_pagination('${boardSearch.getStartPage() - 1}', '${boardSearch.getContentNum()}', '${boardSearch.getSearchType()}', '${boardSearch.getKeyword()}');">
							<i class="fa fa-long-arrow-left"></i> Previous
					</a>
					</li>
				</c:if>

				<c:if test="${boardSearch.totalCount ne 0}">
					<c:forEach begin="${boardSearch.getStartPage()}"
						end="${boardSearch.getEndPage()}" var="idx">
						<li
							${boardSearch.pageNum == idx - 1 ? 'class=active' : ''}>
							<a id="page"
							onClick="fn_pagination('${idx}', '${boardSearch.getContentNum()}', '${boardSearch.getSearchType()}', '${boardSearch.getKeyword()}');">${idx}</a>
						</li>
					</c:forEach>
				</c:if>

				<c:if test="${boardSearch.next}">
					<li><a
						onClick="fn_pagination('${boardSearch.getEndPage() + 1}', '${boardSearch.getContentNum()}', '${boardSearch.getSearchType()}', '${boardSearch.getKeyword()}');">
							Next <i class="fa fa-long-arrow-right"></i>
					</a></li>
				</c:if>
			</ul>
		</div>
		<!-- 검색  -->
		<div class="d-flex justify-content-center" >
			<select class="form-control form-control-sm" name="searchType" id="searchType" style="width : 10%">
				<option value="boardTitle">글 제목</option>
				<option value="boardContent">글 내용</option>
				<option value="userID">작성자</option>
			</select>
	        <input type="text" class="form-control" placeholder="Search..." id="keyword" name="keyword" style="width : 25%">
	        <button type="submit" class="btn btn-secondary" id="btnSearch" name="btnSearch"><span class="icon-search"></span></button>
       </div>
	</div>
</div>
<script>
	/* 검색을 수행하기 위하여 키워드와 타입을 정한 후 검색 버튼을 클릭하면 링크로 이동 -> 컨트롤러에서 이후의 일을 처리하도록 함 */
	$(document).on('click', '#btnSearch', function(e) {
		e.preventDefault();
		var url = "${pageContext.request.contextPath}/petsitterList";
		url = url + "?searchType=" + $('#searchType').val();
		url = url + "&keyword=" + $('#keyword').val();

		location.href = url;
	});

	/* 페이지 인덱스를 누를 때마다 해당 인덱스로 페이지가 전환 */
	function fn_pagination(pageNum, contentNum, searchType, keyword) {
		var url = "${pageContext.request.contextPath}/petsitterList";
		url = url + "?pageNum=" + pageNum;
		url = url + "&contentNum=" + contentNum;
		url = url + "&searchType=" + searchType;
		url = url + "&keyword=" + keyword;
		location.href = url;
	}

	function isPetsitter(userID) {
		
	}
</script>