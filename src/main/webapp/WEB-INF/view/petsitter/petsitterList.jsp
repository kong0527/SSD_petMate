<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
						<input type="radio" name="inlineRadioOptions" id="petSize" value="option1"> 소형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petSize" value="option1"> 중형
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petSize" value="option1"> 대형
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요일</span></td>
				<td align="center">
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 월요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 화요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 수요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 목요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 금요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 토요일
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petDay" value="option1"> 일요일
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">요금</span></td>
				<td align="center">
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petPrice" value="option1"> \5000-\7000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petPrice" value="option1"> \7100-\9000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petPrice" value="option1"> \9100-\11000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petPrice" value="option1"> \11000-\13000
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="radio-inline">
						<input type="radio" name="inlineRadioOptions" id="petPrice" value="option1"> \13100-\15000
					</label>
				</td>
			</tr>
			<tr>
				<td align="center"><span style="font-weight:bold;">지역</span></td>
				<td align="center">
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 서울
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 경기도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 강원도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 충청남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 충청북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 전라남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 전라북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 경상남도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 경상북도
					</label>
					&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="checkbox-inline">
	  					<input type="checkbox" id="petLocal" value="option1"> 제주도
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
					<tr>
						<td>1</td>
						<td>당산역 근처 펫시터 가능합니다.</td>
						<td>김콩</td>
					</tr>
					<tr>
						<td>2</td>
						<td>동덕여자대학교 부근 펫시터입니다.</td>
						<td>양갱</td>
					</tr>
				</tbody>
			</table>
			<table class="text-right" align="right">
				<tr>
					<td>
						<form:form action="petsitterForm" method="get">
							<input type="submit" class="btn" value="글 작성" />
						</form:form>
					</td>
					<!--<td><button type="button" onclick="location='/petMate/petsitterForm'" class="btn">글 작성</button></td>-->
				</tr>
			</table>
		</div>
	</div>
</div>