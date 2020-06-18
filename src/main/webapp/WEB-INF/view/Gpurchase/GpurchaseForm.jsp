<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>공동구매 폼</h2>
				</div>
				<form:form modelAttribute="gpurchase" action="gpurchaseInsert">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="boardTitle">제목</label> 
							<form:input path="boardTitle" class="form-control form-control-lg" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="sdate">시작날짜</label> 
							<form:input path="sdate" class="form-control form-control-lg" />
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="edate">끝 날짜</label> 
							<form:input path="edate" class="form-control form-control-lg" />
						</div>
					</div>
					<%-- <div class="row">
						<div class="col-md-6 form-group">
							<label for="boardName">물건 이름</label>
							<form:input path="boardName" class="form-control form-control-lg" />
						</div>
					</div> --%>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="price">가격</label> 
							<form:input path="price" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="goalNum">목표 인원 수</label> 
							<form:input path="goalNum" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="boardContent">글 쓰기</label>
							<form:textarea path="boardContent" id="boardContent" cols="30" rows="10"
								class="form-control" style="width:120%"></form:textarea>
						</div>
					</div>
					<%-- <c:if test="${empty gpurchase.boardNum}">
					<div class="row">
						<div class="col-12">
							<input type="submit" value="등록" class="btn btn-primary py-3 px-5">
						</div>
					</div>
					</c:if> --%>
					
					${gpurchase.boardNum} 
					<c:choose>
						<c:when test="${0 ne gpurchase.boardNum}">
							<div class="pt-5" align="right">
								<form>
									<input type="hidden" id="boardNum" name="boardNum" value="${gpurchase.boardNum}"/>
									<!-- <a href="secondhandUpdateForm"><input type="submit" class="btn" value="수정" /></a> -->
									<button type="submit" formaction="gpurchaseUpdate"
									class="btn">수정</button>
									<button type="submit" formaction="gpurchaseDelete"
									class="btn">삭제</button>
								</form>
							</div>
						</c:when>
						
						<c:when test="${0 eq gpurchase.boardNum}">
							<div class="row" align="right">
								<div class="col-12">
									<input type="submit" value="등록" class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</c:when>
					</c:choose>
				</form:form>
				
			</div>
		</div>
	</div>
</div>