<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="site-section bg-light">
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="section-title mb-5">
					<h2>리뷰 폼</h2>
				</div>
				<form:form modelAttribute="review" action="reviewInsert" method="post">
					<div class="row">
						<div class="col-md-6 form-group">
							<label for="boardTitle">제목</label>
							<form:input path="boardTitle" class="form-control form-control-lg" />
						</div>
					</div>

					
					<!-- 나중에 이름 변경 -->
					<label for="movieScore">평점</label>
					<input type="hidden" name="movieScore" id="movieScore" value="0.5">
					<div class="row">
						<div class="col-md-6 form-group">
							<span class="starR1 on" id="star1">0.5</span> 
							<span class="starR2" id="star2">1.0</span> 
							<span class="starR1" id="star3">1.5</span>
							<span class="starR2" id="star4">2.0</span> 
							<span class="starR1" id="star5">2.5</span> 
							<span class="starR2" id="star6">3.0</span>
							<span class="starR1" id="star7">3.5</span> 
							<span class="starR2" id="star8">4.0</span> 
							<span class="starR1" id="star9">4.5</span>
							<span class="starR2" id="star10">5.0</span>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 form-group">
							<label for="boardContent">글 쓰기</label>
							<form:textarea path="boardContent" id="boardContent" cols="30"
								rows="10" class="form-control"></form:textarea>
						</div>
					</div>

					<div class="row">
						<div class="col-12">
							<input type="submit" value="등록"
								class="btn btn-primary py-3 px-5" id="btn">
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
		elPlaceHolder: "boardContent",
		sSkinURI: "resources/se2/SmartEditor2Skin.html",
		fCreator: "createSEditor2"
	});
	$(document).on('click', '#btn', function(e){
	      oEditors.getById["boardContent"].exec("UPDATE_CONTENTS_FIELD", []);   });

	$(document).on('click', '#starRating span', function(e){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');

		  var starClass1 = $('#star1').attr('class');
		  var starClass2 = $('#star2').attr('class');
		  var starClass3 = $('#star3').attr('class');
		  var starClass4 = $('#star4').attr('class');
		  var starClass5 = $('#star5').attr('class');
		  var starClass6 = $('#star6').attr('class');
		  var starClass7 = $('#star7').attr('class');
		  var starClass8 = $('#star8').attr('class');
		  var starClass9 = $('#star9').attr('class');
		  var starClass10 = $('#star10').attr('class');
		  
		  if (starClass1 == "starR1 on") {
			  $("#movieScore").val("0.5"); 
		  }
		  if (starClass2 == "starR2 on") {
			  $("#movieScore").val("1.0"); 
		  }
		  if (starClass3 == "starR1 on") {
			  $("#movieScore").val("1.5"); 
		  }
		  if (starClass4 == "starR2 on") {
			  $("#movieScore").val("2.0"); 
		  }
		  if (starClass5 == "starR1 on") {
			  $("#movieScore").val("2.5"); 
		  }
		  if (starClass6 == "starR2 on") {
			  $("#movieScore").val("3.0"); 
		  }
		  if (starClass7 == "starR1 on") {
			  $("#movieScore").val("3.5"); 
		  }
		  if (starClass8 == "starR2 on") {
			  $("#movieScore").val("4.0"); 
		  }
		  if (starClass9 == "starR1 on") {
			  $("#movieScore").val("4.5"); 
		  }
		  if (starClass10 == "starR2 on") {
			  $("#movieScore").val("5.0"); 
		  }
		  return false;
	});
</script>
<style>
	.starR1{
	    background: url('resources/img/rating.png') no-repeat -52px 0;
	    background-size: auto 100%;
	    width: 15px;
	    height: 30px;
	    float:left;
	    text-indent: -9999px;
	    cursor: pointer;
	}
	.starR2{
	    background: url('resources/img/rating.png') no-repeat right 0;
	    background-size: auto 100%;
	    width: 15px;
	    height: 30px;
	    float:left;
	    text-indent: -9999px;
	    cursor: pointer;
	}
	.starR1.on{background-position:0 0;}
	.starR2.on{background-position:-15px 0;}
</style>