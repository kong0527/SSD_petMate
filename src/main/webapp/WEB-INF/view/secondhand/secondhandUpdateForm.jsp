<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>중고거래 수정폼</h2>
				</div>
				<form:form modelAttribute="secondhand" action="secondhandUpdate">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="boardTitle">제목</label> 
							<form:input path="boardTitle" class="form-control form-control-lg" />
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
						<div class="col-md-12 form-group">
							<label for="boardContent">글 쓰기</label>
							<form:textarea path="boardContent" id="boardContent" cols="30" rows="10"
								class="form-control" style="width:120%"></form:textarea>
						</div>
					</div>
					<form:hidden path="boardNum"/>
					<form:hidden path="userID"/>
					<div class="row">
						<div class="col-12">
							<input type="submit" value="수정" class="btn btn-primary py-3 px-5">
						</div>
					</div>
				</form:form>
			${secondhand.boardNum} &nbsp; ${secondhand.boardDate} &nbsp; ${secondhand.userID} &nbsp; 
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	var oEditors = [];
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "message",
		sSkinURI: "resources/se2/SmartEditor2Skin.html",
		fCreator: "createSEditor2"
	});
</script>