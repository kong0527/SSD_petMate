<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="GpurchaseReply.jsp" %>
<div class="site-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 single-content">
				<h1 class="mb-4">GpurchaseDetail</h1>
				<div class="post-meta d-flex mb-5">
					<div class="vcard">
						<span class="d-block"><a href="#">${gpurchase.userID}</a></span> 
						<span class="date-read">${gpurchase.boardDate} 
						<span class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
					</div>
				</div>
				${gpurchase.boardContent} &nbsp;
				${gpurchase.boardNum}  &nbsp;
				${gpurchase.price}  &nbsp;
				${gpurchase.boardDate}  &nbsp;
				${gpurchase.userID}  &nbsp;
				${gpurchase.edate}  &nbsp;
				${gpurchase.sdate}  &nbsp;
				${gpurchase.cartAdded}  &nbsp;
				

				<!-- 추가 -->
				<div class="pt-5" align="right">
				<form>
					<input type="hidden" id="boardNum" name="boardNum" value="${gpurchase.boardNum}"/>
					<c:if test="${sessionScope.userID ne null}">
						<c:if test="${sessionScope.userID eq gpurchase.userID}">
							<button type="submit" formaction="gpurchaseForm" class="btn">수정</button>
							<input type="button" class="btn" value="삭제" onclick="del(${gpurchase.boardNum})" />
						</c:if>
						<c:if test="${sessionScope.userID eq 'admin'}">
							<input type="button" class="btn" value="삭제" onclick="del(${gpurchase.boardNum})" />
						</c:if>
					</c:if>
				</form>
				</div>
				
				
				<div class="pt-5" align="center">
						<c:if test="${sessionScope.userID eq null}">
							<a href="signIn" onclick="alert('로그인이 필요합니다.')">
								<img src="resources/img/love.png" border="0" class="zoom">
							</a>
						</c:if>
						<c:if test="${sessionScope.userID ne null}">
							<c:if test="${sessionScope.userID ne gpurchase.userID}">
								<a href="javascript:void(0);" onclick="checkCart();">
									<img src="resources/img/love.png" border="0" class="zoom">
								</a>
							</c:if>
							<c:if test="${sessionScope.userID eq gpurhcase.userID}">
								<a href="#" onclick="alert('자신의 글에는 추천을 누를 수 없습니다.')">
									<img src="resources/img/love.png" border="0" class="zoom">
								</a>
							</c:if>
						</c:if>
						<div id="cartAdded">
							장바구니 담은 수 : ${gpurchase.cartAdded}
						</div>
				</div>

				<div class="pt-5" align="center">
					<a href="gpurchase"><input type="button" value="목록" class="btn" /></a>
				</div>

				<!-- comment 작성 부분 -->		
				
				
				<div class="comment-form-wrap pt-5">
						<div class="replySection-title">
							<h2 class="mb-5">Leave a comment</h2>
						</div>
	       				<form id="replyForm" class="p-5 bg-light">
				           <div class="form-group">
				           	   <input type="hidden" name="boardNum" id="boardNum" value="${gpurchase.boardNum}"/>
				               <textarea class="form-control" cols="10" rows="5" id="replyContent" name="replyContent" placeholder="내용을 입력하세요."></textarea>
				               <c:if test="${sessionScope.userID ne null}">
					               <div class="form-group">	
					               		<button type="button" name="btnReply" id="btnReply" class="btn btn-primary py-3">등록</button>
					               </div>
				               </c:if>
				               <c:if test="${sessionScope.userID eq null}">
				               		<a href="signIn" onclick="alert('로그인이 필요합니다.')"><input type="button" class="btn" value="글 작성" /></a>
				               </c:if>
				            </div>
				        </form>
			    </div>

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
	function checkCart() {
		var boardNum = '${gpurchase.boardNum}';
		$.ajax({
			url : '/petMate/gpurchaseCartAdded',
			type : 'post',
			data : {'boardNum' : boardNum},
			dataType : 'json',
			success : function(data) {
				var html = ''; 
				if (data.count == 0) {
					alert('장바구니에 추가되었습니다.');
				} else {
					alert('이미 담은 상품입니다.');
				}
				html += '장바구니 담은 수: ' + data.cartAdded;
				$("#cartAdded").html(html);
			}
		});
	}

	function del(boardNum) {
		var chk = confirm("정말 삭제하시겠습니까?");
		if (chk) {
			location.href='gpurchaseDetail/delete?boardNum='+boardNum;
		}
	}
</script>