<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<link href="resources/css/meranda/style.css" rel="stylesheet">
<link href="resources/css/comment.css" rel="stylesheet">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="site-section">
	<div class="container">
		<div class="row">
			<div class="col-lg-8 single-content">
				<div class="box">
					<h1 class="mb-4">${inquiry.boardTitle}</h1>
					<div class="post-meta d-flex mb-5">
						<div class="vcard">
							<span class="d-block"><a href="#">${inquiry.userID}</a> </span> 
							<span class="date-read">${inquiry.boardDate} 
							<span class="mx-1">&bullet;</span> 조회 ${inquiry.boardHit} 
							<span class="icon-star2"></span></span>
						</div>
					</div>
					<P>${inquiry.boardContent}</P>
				</div>
			</div>
		</div>

		<!-- 추가 -->
		<div class="pt-5" align="right">
			<button type="submit" formaction="inquiryDetail/edit" class="btn">수정</button>
			<button type="submit" formaction="inquiryDetail/delete" class="btn">삭제</button>
		</div>

		<div class="pt-5" align="center">
			<a href="inquiryDetail/likePlus"><img
				src="resources/img/love.png" border="0" class="zoom"></a>
			<p>추천수 : ${inquiry.boardLike}</p> <br/>
			<a href="inquiry"><input type="button" value="목록" class="btn" /></a>
		</div>
		<div class="pt-5" align="center">
		<!-- 공백용 div -->
		</div>
		
	</div>

	<div class="col-sm-10 col-sm-offset-1">
		<h2 class="mb-3">Leave a comment</h2>
	</div>

	<div class="container well well-lg">
		<form action="#" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="comment" class="col-sm-2 control-label">Comment</label>
				<div class="col-sm-10">
					<textarea class="form-control" name="addComment" id="addComment"
						cols="10" rows="5"></textarea>
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-success btn-circle text-uppercase"
						type="submit" id="submitComment">
						<span class="glyphicon glyphicon-send"></span> Summit comment
					</button>
				</div>
			</div>
		</form>
	</div>

	<div class="container">
		<div class="media-body">
			<div class="well well-lg">
				<h4 class="media-heading text-uppercase reviews">Marco</h4>
				<ul class="media-date text-uppercase reviews list-inline">
					<li class="dd">22</li>
					<li class="mm">09</li>
					<li class="aaaa">2014</li>
				</ul>
				<p class="media-comment">Great snippet! Thanks for sharing.</p>
				<a class="btn btn-info btn-circle text-uppercase" href="#"
					id="reply"><span class="glyphicon glyphicon-share-alt"></span>
					Reply</a> <a class="btn btn-warning btn-circle text-uppercase"
					data-toggle="collapse" href="#replyOne"><span
					class="glyphicon glyphicon-comment"></span> 2 comments</a> <a
					class="btn btn-info btn-circle text-uppercase float-right" href="#"
					id="select">채택</a>
			</div>
		</div>
	</div>


	<div class="container" id="replyOne">
		<ul class="media-list">
			<li class="media media-replied">
				<div class="media-body">
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">
							<span class="glyphicon glyphicon-share-alt"></span> The Hipster
						</h4>
						<ul class="media-date text-uppercase reviews list-inline">
							<li class="dd">22</li>
							<li class="mm">09</li>
							<li class="aaaa">2014</li>
						</ul>
						<p class="media-comment">Nice job Maria.</p>
						<a class="btn btn-info btn-circle text-uppercase" href="#"
							id="reply"><span class="glyphicon glyphicon-share-alt"></span>
							Reply</a>
					</div>
				</div>
			</li>

			<li class="media media-replied" id="replied">

				<div class="media-body">
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">
							<span class="glyphicon glyphicon-share-alt"></span> Mary
						</h4>
						</h4>
						<ul class="media-date text-uppercase reviews list-inline">
							<li class="dd">22</li>
							<li class="mm">09</li>
							<li class="aaaa">2014</li>
						</ul>
						<p class="media-comment">Thank you Guys!</p>
						<a class="btn btn-info btn-circle text-uppercase" href="#"
							id="reply"><span class="glyphicon glyphicon-share-alt"></span>
							Reply</a>
					</div>
				</div>
			</li>
		</ul>
	</div>


	<div class="container">
		<div class="media-body">
			<div class="well well-lg">
				<h4 class="media-heading text-uppercase reviews">Nico</h4>
				<ul class="media-date text-uppercase reviews list-inline">
					<li class="dd">22</li>
					<li class="mm">09</li>
					<li class="aaaa">2014</li>
				</ul>
				<p class="media-comment">I'm looking for that. Thanks!</p>
				<a class="btn btn-info btn-circle text-uppercase" href="#"
					id="reply"><span class="glyphicon glyphicon-share-alt"></span>
					Reply</a>
			</div>
		</div>

	</div>
	<div class="container">
		<div class="media-body">
			<div class="well well-lg">
				<h4 class="media-heading text-uppercase reviews">Kriztine</h4>
				<ul class="media-date text-uppercase reviews list-inline">
					<li class="dd">22</li>
					<li class="mm">09</li>
					<li class="aaaa">2014</li>
				</ul>
				<p class="media-comment">Yehhhh... Thanks for sharing.</p>
				<a class="btn btn-info btn-circle text-uppercase" href="#"
					id="reply"><span class="glyphicon glyphicon-share-alt"></span>
					Reply</a> <a class="btn btn-warning btn-circle text-uppercase"
					data-toggle="collapse" href="#replyTwo"><span
					class="glyphicon glyphicon-comment"></span> 1 comment</a>
			</div>
		</div>
	</div>
	<div class="container" id="replyTwo">
		<ul class="media-list">
			<li class="media media-replied">
				<div class="media-body">
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">
							<span class="glyphicon glyphicon-share-alt"></span> Lizz
						</h4>
						<ul class="media-date text-uppercase reviews list-inline">
							<li class="dd">22</li>
							<li class="mm">09</li>
							<li class="aaaa">2014</li>
						</ul>

						<p class="media-comment">Classy!</p>
						<a class="btn btn-info btn-circle text-uppercase" href="#"
							id="reply"><span class="glyphicon glyphicon-share-alt"></span>
							Reply</a>
					</div>
				</div>
			</li>
		</ul>
	</div>


	<div class="text-center">
		<h3 class="reviews">
			<span class="glyphicon glyphicon-magnet"></span> Uicomments by <a
				href="https://twitter.com/maridlcrmn">maridlcrmn</a>
		</h3>
	</div>
	<div class="notes text-center">
		<small>Image credits: uifaces.com</small>
	</div>
</div>