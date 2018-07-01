<link href="${css}/bootstrap.min.css" rel="stylesheet"> 
<script src="${js}/bootstrap.min.js"></script>
<script src="${js}/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="container mt-4">
	<c:if test="${not empty message}">
		
		<div class="alert alert-info">
			
			<h3 class="text-center">
				${message}
			</h3>
			
		</div>
	</c:if>
	<c:choose>
		
		<c:when test="${not empty cartLines }">
			
			<table class="table table-hover">
                <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${cartLines}" var="cartLine">
                	<tr>
                        <td class="col-sm-8 col-md-6">
                        <div class="media">
                            <a class="thumbnail pull-left" href="#"> <img class="img-responsive cartImg" alt="${cartLine.product.name}" src="${images}/${cartLine.product.code}.jpg" style="width: 72px; height: 72px;"> </a>
                            <div class="media-body">
                                <h4 class="media-heading">${cartLine.product.name}
                                	<c:if test="${cartLine.available == false}">
                                	
                                		<strong class="unavailable">(Not Available)</strong>
                                		
                                	</c:if>
                                		
                                	</h4>
                                <h5 class="media-heading"> by >${cartLine.product.brand}</h5>
                                <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                            </div>
                        </div></td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                        <input type="number" class="form-control" min="1" max="3" id="count_${cartLine.id}" value="${cartLine.productCount}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>&#8377; ${cartLine.buyingPrice}</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>&#8377; ${cartLine.total}</strong></td>
                        <td class="col-sm-1 col-md-1">
                        <button type="button" name="refreshCart" style="width: 50px;" class="btn btn-info btn-sm" 
                        	value="${cartLine.id}"><i class="fa fa-sync" style="font-size:22px"></i>
                        </button>

                        <a href="${contextRoot}/cart/${cartLine.id}/delete" class="btn btn-danger">
                            <i class="fa fa-trash" style="font-size:24px"></i>
                        </a></td>
                    </tr>
                </c:forEach>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td class="text-right"><h4>Total &#8377;</h4></td>
                        <td><h4><strong>${userModel.cart.grandTotal}</strong></h4></td>
                    </tr>
                    <tr>
                        <td>   </td>
                        <td>   </td>
                        <td>   </td>
                        <td>
                        <a href="${contextRoot}/show/all/products" class="btn btn-warning">
                            <span class="fa fa-shopping-cart"></span> Continue Shopping
                        </a></td>
                        <td>
                        <button type="button" class="btn btn-success">
                            Checkout <span class="fa fa-play"></span>
                        </button></td>
                    </tr>
                </tbody>
            </table>
			
		</c:when>
		
		<c:otherwise>
			<div class="mt-4 jumbotron">
				
				<div class="text-center">
					
					<h1>Your Cart is Empty!</h1>
					
				</div>
				
			</div>
			
		</c:otherwise>
		
	</c:choose>
    <div class="row">
        <div class="col-sm-12 col-md-10 md-offset-1">
          	
        </div>
    </div>
</div>