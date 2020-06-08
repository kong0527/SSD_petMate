<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="section-title">
	<div class="container">
		<span class="caption d-block small">Categories</span>
		<h2>Cart</h2>
	</div>
</div>
<div class="sideContainer d-md-flex align-items-stretch">
<div style="width:100%">
	<div id="content" class="p-4 p-md-5 pt-5">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>#</th>
						<th>Product</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Total</th>
						<th>&nbsp;</th>		
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="checkbox" name="gpurchase" value="1" checked /></td>
						<td><img src="resources/img/love.png" border="0"> &nbsp; 강아지 삑삑이</td>
						<td>10,000₩</td>
						<td>1</td>
						<td>10,000₩</td>
						<td><button type="submit" formaction="cart/delete" class="btn">x</button></td>
					</tr>
					<tr>
						<td><input type="checkbox" name="gpurchase" value="1" checked /></td>
						<td><img src="resources/img/love.png" border="0"> &nbsp; 강아지 삑삑이</td>
						<td>15,000₩</td>
						<td>1</td>
						<td>15,000₩</td>
						<td><button type="submit" formaction="cart/delete" class="btn">x</button></td>
					</tr>
				</tbody>
			</table>
	</div>
	
	<div class="table-wrapper">
			<table class="text-right table-cart" align="right">
				<tr>
					<td>총상품금액</td>
					<td>&nbsp;</td>
					<td>25,000₩</td>
				</tr>
				<tr>
					<td>배송비</td>
					<td>&nbsp;</td>
					<td>2500₩</td>
				</tr>
				<tr>
					<td>결제예상금액</td>
					<td>&nbsp;</td>
					<td>27,500₩</td>
				</tr>
				<tr>
					<td><button type="submit" formaction="cart/cancle" class="btn">cancle</button></td>
					<td>&nbsp;</td>
					<td><button type="submit" formaction="cart/cancle" class="btn">order</button></td>
				</tr>
			</table>
	</div>
</div>

	<nav id="sidebar">
		<div class="p-4 pt-5">
	        <ul class="list-unstyled components mb-5">
	          <li>
	            <a href="#pageSubmenu1" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Mens Shoes</a>
	            <ul class="collapse list-unstyled" id="pageSubmenu1">
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Casual</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Football</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Jordan</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Lifestyle</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Running</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Soccer</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span> Sports</a></li>
	            </ul>
	          </li>
	          <li>
	            <a href="#pageSubmenu2" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Mens Shoes</a>
	          </li>
	          <li>
	            <a href="#pageSubmenu3" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Accessories</a>
	          </li>
	          <li>
	            <a href="#pageSubmenu4" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Clothes</a>
	          </li>
	        </ul>
	     </div>
    </nav>
</div>

<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/popper.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/main.js"></script>