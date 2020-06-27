<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal HTML -->
<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div class="modal-header">				
				<h4 class="modal-title">비밀번호 확인</h4>
			</div>
			<div class="modal-body">
				<form method="post"
				class="login100-form validate-form flex-sb flex-w">
					<span class="txt1 p-b-11"> 
						비밀번호 
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input type="password" id="pwd" name="pwd" class="input100"/>
						<span class="focus-input100"></span>
					</div>
					<span class="txt1 p-b-11"> 
						비밀번호 확인
					</span>
					<div class="wrap-input100 validate-input m-b-36">
						<input type="password" id="confirmPwd" name="confirmPwd" class="input100"/>
						<span class="focus-input100"></span>
					</div>
					<div class="container-login100-form-btn">
						<button type="submit" value="확인"
								class="login100-form-btn" id="btnConfirm" name="btnConfirm">확인</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div> 
<script>
$("#btnConfirm").on("click", function(){
	var pass1 = $("#pwd").val();
	var pass2 = $("#confirmPwd").val();
	if (pass1 == "" || pass2 == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if(pass1 != pass2) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#pwd").focus();
		return false;
	}
	var confirmPwd = $("#pwd").val();
	$.ajax({
        url : '${pageContext.request.contextPath}/confirmPwd',
        type : 'post',
        data : {'confirmPwd' : confirmPwd},
       /* 	async: false, */
        success : function(data){
            alert(data);
        	if (data == 1) {
        		location.href="${pageContext.request.contextPath}/index";
        	}
        	else {
        		alert('비밀번호가 틀렸습니다.');
        		return false;
	        }
        }
    });
});
</script>