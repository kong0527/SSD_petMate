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
				<form:form modelAttribute="gpurchase" action="gpurchaseForm">
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
							<%-- <form:input path="sdate" class="form-control form-control-lg" value="2019-06-27"/> --%>
						</div>
					</div>
					
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="edate">끝 날짜</label> 
							<form:input path="edate" class="form-control form-control-lg" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="productName">물건 이름</label>
							<form:input path="productName" class="form-control form-control-lg"/>
							<div id = "shopResult" class="auto_tx_area"></div>
						</div>
					</div>
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
									<button type="submit" id="btn" class="btn">수정</button>
								</form>
							</div>
						</c:when>
						
						<c:when test="${0 eq gpurchase.boardNum}">
							<div class="row" align="right">
								<div class="col-12">
									<input type="submit" value="등록"  id="btn" class="btn btn-primary py-3 px-5">
								</div>
							</div>
						</c:when>
					</c:choose>
				</form:form>
			</div>
		</div>
	</div>
</div>
<style>
	.auto_tx_area {
	    clear: both;
	    position: absolute;
	    z-index: 10002;
	    width: 500px;
	    background: #fff;
	}s
</style>
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "boardContent",
	sSkinURI: "resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
});

 $(document).on('click', '#btn', function(e){
    oEditors.getById["boardContent"].exec("UPDATE_CONTENTS_FIELD", []);
     var text = $("#boardContent").val().replace(/[<][^>]*[>]/gi, "");
     if(text ==""){
        alert("글 내용을 입력해 주세요.");
        oEditors.getById["boardContent"].exec("FOCUS");
        return false;
     } 
     if(text.length > 1500){
        alert("글 내용은 1500자 내로 입력해 주세요.");
        oEditors.getById["boardContent"].exec("FOCUS");
        return false;
     } 
     $("#form").submit();
});
	/* $(function() {	
		$('#sdate').datepicker({
		    format: "yyyy-mm-dd",	//데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
		    endDate: '+10d',	//달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
		    autoclose : true,	//사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
		    immediateUpdates: false,	//사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false 
		    title: "시작 날짜",	//캘린더 상단에 보여주는 타이틀
		    todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
		    toggleActive : true,	//이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
		    weekStart : 0 ,//달력 시작 요일 선택하는 것 기본값은 0인 일요일 
		    language : "ko"	//달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
		    
		});//datepicker end
	});//ready end */

	$("#sdate").datepicker({
		format: 'yyyy-mm-dd',
		startDate: '0d',
		autoclose: true,
		language : "ko"	,
		title: "시작 날짜",	//캘린더 상단에 보여주는 타이틀
		todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false   
	}).on('changeDate', function (selected) {
		var startDate = new Date(selected.date.valueOf());
		$('#edate').datepicker('setStartDate', startDate);
	}).on('clearDate', function (selected) {
		$('#edate').datepicker('setStartDate', null);
	});

	$("#edate").datepicker({
		format: 'yyyy-mm-dd',
		autoclose: true,
		language : "ko"	,
		title: "종료 날짜",	//캘린더 상단에 보여주는 타이틀
		todayHighlight : true ,	//오늘 날짜에 하이라이팅 기능 기본값 :false 
	})
	 .on('changeDate', function (selected) {
		var endDate = new Date(selected.date.valueOf());
		$('#sdate').datepicker('setEndDate', endDate);
	}).on('clearDate', function (selected) {
		$('#sdate').datepicker('setEndDate', null);
	});

	// 키보드를 누를 때마다 수행 -> 자동완성 기능
	$(document).on('keyup', '#productName', function(e){
		$("#shopResult").css('display', 'block');
		var keyword = $("#productName").val();
 	    $.ajax({
 	        url : '${pageContext.request.contextPath}/shopAPI?keyword='+ keyword,
 	        type : 'post',
 	        success : function(data){
 	        	var html = '';
 	        	html += '<div class="autoComplete">';
 	        	html += '<ul>';
 	 	        for (var i = 0 in data) {
 	 	 	        html += '<li>';
 	 	 	     	html += '<a href="javascript:void(0);" onclick="fillValue(\'' + data[i].lprice + '\');">';
 	 	 	        html += '<div>';
 	 	 	        html += '<p>';
 	 	 	        if (data[i].image == "") {
 	 	 	 	        html += '<img src="resources/img/noImage.PNG" width="80" height="100">'; // 이미지가 없는 경우 기본 이미지로 대체
 	 	 	 	    }
 	 	 	        else {
 	 					html += '<img src="' + data[i].image + '" width="70" height="100">';
 	 	 	        }
 	 	 	        html += '</p>';
 	 	 	        html += '<p>'+ data[i].title + '</p>';
 	 	 	        html += '<p>최저가: ' + data[i].lprice + '</p>';
 	 	 	        html += '</div>';
 	 	 	     	html += '</a>';
 	 	 	        html += '</li>';
 	 	 	    }
 	 	 	    html += '</ul>';
 	 	 	    html += '</div>';
 	 	 	
 	 	      	$('#shopResult').html(html);
 	        }
 	    });
	});

	function fillValue(keyword) {
		var keyword = keyword.replace(/[<][^>]*[>]/gi, "");
		$("#productName").val(keyword);
		$("#shopResult").css('display', 'none');
	}

	$("body").click(function(e) { 
	     if($("#shopResult").css("display") == "block") {
	         if(!$('#shopResult, #productName').has(e.target).length) { 
	               $("#shopResult").hide();
	          } 
	     }
	});
	
</script>