<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>펫시터 구인 폼</h2>
				</div>
				<form:form modelAttribute="petsitter" action="petsitterInsert" method="post">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="boardTitle">제목</label> 
							<form:input path="boardTitle" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="petPrice">가격</label> 
							<form:input path="petPrice" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="petLocal">지역</label> 
							<form:input path="petLocal" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="petDay">날짜</label>
							<form:input path="petDay" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="petSize">사이즈</label>
							<form:input path="petSize" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="boardContent">글 쓰기</label>
							<form:textarea path="boardContent" id="boardContent" cols="30" rows="10"
								class="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-12">
							<input type="submit" value="등록"
								class="btn btn-primary py-3 px-5">
						</div>
					</div>
				</form:form>
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