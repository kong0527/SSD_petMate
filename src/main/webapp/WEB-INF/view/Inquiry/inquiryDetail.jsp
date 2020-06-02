<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
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
					<h1 class="mb-4">inquiryDetail</h1>
				<div class="post-meta d-flex mb-5">
					<div class="vcard">
						<span class="d-block"><a href="#">Dave Rogers</a> in <a
							href="#">News</a></span> <span class="date-read">Jun 14 <span
							class="mx-1">&bullet;</span> 3 min read <span class="icon-star2"></span></span>
					</div>
				</div>

				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
					Suscipit officia neque beatae at inventore excepturi numquam sint
					commodi alias, quam consequuntur corporis ex, distinctio eaque
					sapiente pariatur iure ad necessitatibus in quod obcaecati natus
					consequatur. Sed dicta maiores, eos culpa.</p>
				<p>Voluptatum animi, voluptate sint aperiam facere a nam, ex
					reiciendis eum nemo ipsum nobis, rem illum cupiditate at quaerat
					amet qui recusandae hic, atque laboriosam perspiciatis? Esse quidem
					minima, voluptas necessitatibus, officia culpa quo nulla,
					cupiditate iste vel unde magni.</p>
				<p>Nulla nesciunt eligendi ratione, atque, hic, ullam suscipit
					quos enim vitae fugiat ducimus, dolore delectus iste id culpa.
					Ducimus, iste magnam sed reprehenderit architecto perferendis odio
					voluptas molestiae quidem ab numquam debitis, dolorem incidunt,
					tempore a quod qui nobis. Voluptates!</p>
				<p>Blanditiis, ipsum sed odio reprehenderit sequi ut vitae,
					dolor minima ab! Architecto nesciunt nemo sint est aspernatur fugit
					consequatur, magnam suscipit asperiores illo eum repellendus
					officia dolorem, molestiae commodi nam voluptatem quis quia vel
					cumque quos, aliquam ex incidunt sapiente!</p>
				<p>Suscipit, officiis, vero! Perferendis accusamus quos
					voluptatum culpa, provident maiores! Illo itaque ullam fugit
					molestiae, eaque accusamus impedit autem numquam. Placeat molestias
					tempore eaque ipsam vel voluptatum velit enim quam iusto maxime
					delectus, sint sapiente ea, quo excepturi nisi! Quia.</p>
				<p>Dolores debitis excepturi maxime earum sapiente totam, quos
					dolore inventore tempore illum. Dolores explicabo sed amet aut
					atque, facere aliquid repudiandae quod possimus quo hic similique
					et voluptates fugit iure dolore quam ipsa numquam assumenda
					corporis? Dignissimos expedita fugit sapiente.</p>
				<p>Cupiditate ut, aspernatur labore obcaecati, eveniet aut velit
					nulla facere suscipit est recusandae vel error itaque earum
					doloremque hic necessitatibus dignissimos dolores libero laudantium
					ducimus! Rem dolorem ratione officia et, fugit non, fuga suscipit
					eos veritatis enim perspiciatis, magni sit!</p>

	</div>
	</div>
		</div>
		
				<!-- 추가 -->
				<div class="pt-5" align="right">
					<button type="submit" formaction="secondhandDetail/edit" class="btn">수정</button>
					<button type="submit" formaction="secondhandDetail/delete" class="btn">삭제</button>
				</div>
				
				<div class="pt-5" align="center">
					<a href="secondhandDetail/likePlus"><img src="resources/img/love.png" border="0" class="zoom"></a>
					<p>추천수 : 1 </p>
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
					<textarea class="form-control" name="addComment" id="addComment" cols="10" rows="5"></textarea>
				</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">                    
				<button class="btn btn-success btn-circle text-uppercase" type="submit" id="submitComment"><span class="glyphicon glyphicon-send"></span> Summit comment</button>
			 </div>
		</div>         
	 </form>
     </div>  
            
	<div class="container">
		<div class="media-body">
					<div class="well well-lg">
						<h4 class="media-heading text-uppercase reviews">Marco </h4>
							<ul class="media-date text-uppercase reviews list-inline">
                                <li class="dd">22</li>
                                <li class="mm">09</li>
                                <li class="aaaa">2014</li>
                              </ul> 
                              <p class="media-comment">
                                Great snippet! Thanks for sharing.
                              </p>
                              <a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
                              <a class="btn btn-warning btn-circle text-uppercase" data-toggle="collapse" href="#replyOne"><span class="glyphicon glyphicon-comment"></span> 2 comments</a>
                              <a class="btn btn-info btn-circle text-uppercase float-right" href="#" id="select">채택</a>
						</div>              
					</div>
				</div>
				
				
                    <div class="container" id="replyOne">
						<ul class="media-list">
							<li class="media media-replied"> 
								<div class="media-body">
									<div class="well well-lg">
										<h4 class="media-heading text-uppercase reviews"><span class="glyphicon glyphicon-share-alt"></span> The Hipster</h4>
											<ul class="media-date text-uppercase reviews list-inline">
                                            	<li class="dd">22</li>
                                            	<li class="mm">09</li>
                                            	<li class="aaaa">2014</li>
                                          	</ul>
                                          	<p class="media-comment">
                                            	Nice job Maria.
                                          	</p>
                                          	<a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
                                      </div>              
                                    </div>
                                </li>
                              
                                <li class="media media-replied" id="replied">
                                  
                                    <div class="media-body">
                                      <div class="well well-lg">
                                          <h4 class="media-heading text-uppercase reviews"><span class="glyphicon glyphicon-share-alt"></span> Mary</h4></h4>
                                          <ul class="media-date text-uppercase reviews list-inline">
                                            <li class="dd">22</li>
                                            <li class="mm">09</li>
                                            <li class="aaaa">2014</li>
                                          </ul>
                                          <p class="media-comment">
                                            Thank you Guys!
                                          </p>
                                          <a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
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
                              <p class="media-comment">
                                I'm looking for that. Thanks!
                              </p>
                              <a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
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
                              <p class="media-comment">
                                Yehhhh... Thanks for sharing.
                              </p>
                              <a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
                              <a class="btn btn-warning btn-circle text-uppercase" data-toggle="collapse" href="#replyTwo"><span class="glyphicon glyphicon-comment"></span> 1 comment</a>
                          </div>              
                        </div>
                      </div>
                        <div class="container" id="replyTwo">
                            <ul class="media-list">
                                <li class="media media-replied">  
                                    <div class="media-body">
                                      <div class="well well-lg">
                                          <h4 class="media-heading text-uppercase reviews"><span class="glyphicon glyphicon-share-alt"></span> Lizz</h4>
                                          <ul class="media-date text-uppercase reviews list-inline">
                                            <li class="dd">22</li>
                                            <li class="mm">09</li>
                                            <li class="aaaa">2014</li>
                                          </ul>
                                         
                                          <p class="media-comment">
                                            Classy!
                                          </p>
                                          <a class="btn btn-info btn-circle text-uppercase" href="#" id="reply"><span class="glyphicon glyphicon-share-alt"></span> Reply</a>
                                      </div>              
                                    </div>
                                </li>
                            </ul>  
                        </div>
                     

  <div class="text-center">
    <h3 class="reviews"><span class="glyphicon glyphicon-magnet"></span> Uicomments by <a href="https://twitter.com/maridlcrmn">maridlcrmn</a></h3>
  </div>
  <div class="notes text-center"><small>Image credits: uifaces.com</small></div>
  </div>