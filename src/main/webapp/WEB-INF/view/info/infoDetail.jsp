<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="infoReply.jsp" %>
<div class="site-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 single-content">
				<h1 class="mb-4">${info.boardTitle}</h1>
				<div class="post-meta d-flex mb-5">
					<div class="vcard">
						<span class="d-block"><a href="#">${info.userID}</a></span> 
						<span class="date-read">${info.boardDate} 
						<span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
					</div>
				</div>
				${info.boardContent}	
				<!-- 추가 -->
				<div class="pt-5" align="right">
				<form>
					<input type="hidden" id="boardNum" name="boardNum" value="${info.boardNum}"/>
					<button type="submit" formaction="infoUpdate"
						class="btn">수정</button>
					<button type="submit" formaction="secondhandDetail/delete"
						class="btn">삭제</button>
				</form>
				</div>

				<div class="pt-5" align="center">
						<!-- 수정 필요 -->
						<c:if test="${userID ne null && sessionScope.userID ne info.userID}">
							<a href="javascript:void(0);" onclick="checkLike();">
								<img src="resources/img/love.png" border="0" class="zoom">
							</a>
						</c:if>
						<div id="boardLike">
							추천 수 : ${info.boardLike}
						</div>
				</div>
				<div class="pt-5" align="center">
					<a href="info"><input type="button" value="목록" class="btn" /></a>
				</div>

				<!-- comment 작성 부분 -->				
				<c:if test="${userID ne null}">
					<div class="comment-form-wrap pt-5">
						<div class="section-title">
							<h2 class="mb-5">Leave a comment</h2>
						</div>
	       				<form id="replyForm" class="p-5 bg-light">
				           <div class="form-group">
				           	   <input type="hidden" name="boardNum" id="boardNum" value="${info.boardNum}"/>
				               <textarea class="form-control" cols="10" rows="5" id="replyContent" name="replyContent" placeholder="내용을 입력하세요."></textarea>
				               <div class="form-group">	
				               		<button type="button" name="btnReply" id="btnReply" class="btn btn-primary py-3">등록</button>
				               </div>
				            </div>
				        </form>
			    	</div>
			    </c:if>

				<!-- comment 시작 부분 -->

				<div class="pt-5">
					<div class="replySection-title">
						<h2 class="mb-5">Comments</h2>
					</div>
					<ul class="comment-list">
						<div id="replyList"></div>
					</ul>
					<!-- END comment-list -->
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function checkLike() {
		var boardNum = '${info.boardNum}';
		$.ajax({
			url : '/petMate/infoLike',
			type : 'post',
			data : {'boardNum' : boardNum},
			dataType : 'json',
			success : function(data) {
				var html = ''; 
				if (data.count == 0) {
					alert('추천되었습니다.');
				} else {
					alert('추천이 취소되었습니다.');
				}
				html += '추천 수: ' + data.boardLike;
				$("#boardLike").html(html);
			}
		});
	}
</script>