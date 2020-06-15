<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<!-- <a href="secondhandUpdateForm"><input type="submit" class="btn" value="수정" /></a> -->
						<button type="submit" formaction="gpurchaseUpdateForm"
						class="btn">수정</button>
						<button type="submit" formaction="gpurchaseDelete"
						class="btn">삭제</button>
					</form>
				</div>

				<div class="pt-5" align="center">
					<!-- <a href="secondhandDetail/likePlus">
						<img src="resources/img/love.png" border="0" class="zoom"></a> -->
						<!-- 수정 필요 -->
						<c:if test="${userID ne null && sessionScope.userID ne gpurchase.userID}">
							<a href="javascript:void(0);" onclick="checkCart();">
								<img src="resources/img/love.png" border="0" class="zoom">
							</a>
						</c:if>
						<div id="cartAdded">
							장바구니 담은 수 : ${gpurchase.cartAdded}
						</div>
				</div>
				<div class="pt-5" align="center">
					<a href="info"><input type="button" value="목록" class="btn" /></a>
				</div>

				<!-- comment 작성 부분 -->
				<div class="comment-form-wrap pt-5">
					<div class="section-title">
						<h2 class="mb-5">Leave a comment</h2>
					</div>
					<form action="#" class="p-5 bg-light">
						<div class="form-group">
							<label for="message">&nbsp&nbsp댓글 쓰기</label>
							<textarea name="" id="message" cols="10" rows="5"
								class="form-control"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" value="등록" class="btn btn-primary py-3">
						</div>
					</form>
				</div>

				<!-- comment 시작 부분 -->

				<div class="pt-5">
					<div class="section-title">
						<h2 class="mb-5">6 Comments</h2>
					</div>
					<ul class="comment-list">
						<li class="comment">
							<div class="vcard bio">
								<img src="images/person_1.jpg" alt="Image placeholder">
							</div>
							<div class="comment-body">
								<h3>Jean Doe</h3>
								<div class="meta">January 9, 2018 at 2:21pm</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Pariatur quidem laborum necessitatibus, ipsam impedit vitae
									autem, eum officia, fugiat saepe enim sapiente iste iure! Quam
									voluptas earum impedit necessitatibus, nihil?</p>
								<p>
									<a href="#" class="reply">Reply</a>
								</p>
							</div>
						</li>

						<li class="comment">
							<div class="vcard bio">
								<img src="images/person_1.jpg" alt="Image placeholder">
							</div>
							<div class="comment-body">
								<h3>Jean Doe</h3>
								<div class="meta">January 9, 2018 at 2:21pm</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Pariatur quidem laborum necessitatibus, ipsam impedit vitae
									autem, eum officia, fugiat saepe enim sapiente iste iure! Quam
									voluptas earum impedit necessitatibus, nihil?</p>
								<p>
									<a href="#" class="reply">Reply</a>
								</p>
							</div>

							<ul class="children">
								<li class="comment">
									<div class="vcard bio">
										<img src="images/person_1.jpg" alt="Image placeholder">
									</div>
									<div class="comment-body">
										<h3>Jean Doe</h3>
										<div class="meta">January 9, 2018 at 2:21pm</div>
										<p>Lorem ipsum dolor sit amet, consectetur adipisicing
											elit. Pariatur quidem laborum necessitatibus, ipsam impedit
											vitae autem, eum officia, fugiat saepe enim sapiente iste
											iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
										<p>
											<a href="#" class="reply">Reply</a>
										</p>
									</div>


									<ul class="children">
										<li class="comment">
											<div class="vcard bio">
												<img src="images/person_1.jpg" alt="Image placeholder">
											</div>
											<div class="comment-body">
												<h3>Jean Doe</h3>
												<div class="meta">January 9, 2018 at 2:21pm</div>
												<p>Lorem ipsum dolor sit amet, consectetur adipisicing
													elit. Pariatur quidem laborum necessitatibus, ipsam impedit
													vitae autem, eum officia, fugiat saepe enim sapiente iste
													iure! Quam voluptas earum impedit necessitatibus, nihil?</p>
												<p>
													<a href="#" class="reply">Reply</a>
												</p>
											</div>

											<ul class="children">
												<li class="comment">
													<div class="vcard bio">
														<img src="images/person_1.jpg" alt="Image placeholder">
													</div>
													<div class="comment-body">
														<h3>Jean Doe</h3>
														<div class="meta">January 9, 2018 at 2:21pm</div>
														<p>Lorem ipsum dolor sit amet, consectetur adipisicing
															elit. Pariatur quidem laborum necessitatibus, ipsam
															impedit vitae autem, eum officia, fugiat saepe enim
															sapiente iste iure! Quam voluptas earum impedit
															necessitatibus, nihil?</p>
														<p>
															<a href="#" class="reply">Reply</a>
														</p>
													</div>
												</li>
											</ul>
										</li>
									</ul>
								</li>
							</ul>
						</li>

						<li class="comment">
							<div class="vcard bio">
								<img src="images/person_1.jpg" alt="Image placeholder">
							</div>
							<div class="comment-body">
								<h3>Jean Doe</h3>
								<div class="meta">January 9, 2018 at 2:21pm</div>
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
									Pariatur quidem laborum necessitatibus, ipsam impedit vitae
									autem, eum officia, fugiat saepe enim sapiente iste iure! Quam
									voluptas earum impedit necessitatibus, nihil?</p>
								<p>
									<a href="#" class="reply">Reply</a>
								</p>
							</div>
						</li>
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
					alert('장바구니에 삭되었습니다.');
				}
				html += '장바구니 담은 수: ' + data.cartAdded;
				$("#cartAdded").html(html);
			}
		});
	}
</script>