<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>정보게시판 글쓰기 폼</h2>
				</div>
				<form:form modelAttribute="info" action="infoInsert" method="post">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="boardTitle">제목</label> 
							<form:input path="boardTitle" class="form-control form-control-lg" />
							<form:errors path="boardTitle" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="boardContent">글 쓰기</label>
							<form:textarea path="boardContent" id="boardContent" cols="30" rows="10"
								class="form-control" style="width:120%" />
							<form:errors path="boardContent" />
						</div>
					</div>

					<c:choose>
						<c:when test="${0 ne info.boardNum}">
							<div class="pt-5" align="right">
								<form>
									<input type="hidden" id="boardNum" name="boardNum" value="${info.boardNum}"/>
									<!-- <a href="secondhandUpdateForm"><input type="submit" class="btn" value="수정" /></a> -->
									<button type="submit" formaction="infoUpdate"
									class="btn">수정</button>
								</form>
							</div>
						</c:when>
						<c:when test="${0 eq info.boardNum}">
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
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "boardContent",
		sSkinURI: "resources/se2/SmartEditor2Skin.html",
		fCreator: "createSEditor2"
	});
	$(document).on('click', '#btn', function(e){
	      oEditors.getById["boardContent"].exec("UPDATE_CONTENTS_FIELD", []);   });
</script>