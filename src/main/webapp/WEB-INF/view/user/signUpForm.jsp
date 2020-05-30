<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>회원가입</h2>
				</div>
				<form method="post">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="id">아이디</label> <input type="text" id="id"
								class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="pwd">비밀번호</label> <input type="password"
								id="pwd" class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="cofirm">비밀번호 확인</label> <input type="password"
								id="confirm" class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="email">이메일</label> <input type="email" id="email"
								class="form-control form-control-lg">
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="userType">
								펫시터<input type="radio" id="userType" name="userType" value="0">
								&nbsp&nbsp
								일반회원<input type="radio" id="userType" name="userType" value="1">
							</label> 
						</div>
					</div>
					<div class="row">
						<div class="col-12">
						<!-- 가운데 정렬시 클래스에 text-center -->
							<input type="submit" value="회원가입"
								class="btn btn-primary py-3 px-5">
								<!-- 오른쪽 정렬시 버튼 클래스에 btn float-right -->
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>