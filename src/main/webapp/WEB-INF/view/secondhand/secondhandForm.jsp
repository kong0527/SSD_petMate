<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>중고거래 폼</h2>
				</div>
				<form method="post">

					<div class="row">
						<div class="col-md-6 form-group">
							<label for="fname">제목</label> <input type="text" id="fname"
								class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="eaddress">가격</label> <input type="text" id="eaddress"
								class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="eaddress">물건 이름</label> <input type="text"
								id="eaddress" class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="message">글 쓰기</label>
							<textarea name="" id="message" cols="30" rows="10"
								class="form-control"></textarea>
						</div>
					</div>

					<div class="row">
						<div class="col-12">
							<input type="submit" value="Send Message"
								class="btn btn-primary py-3 px-5">
						</div>
					</div>
				</form>
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