<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<div class="container">

	<div class="row">
		
		<c:if test="${not empty message}">

			<div class="col-xs-12">
				
				<div class="alert alert-success alert-dismissible">
					
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					
					${message}
					
				</div>
				
			</div>
		</c:if>

		<div class="mt-4 col-md-offset-2 col-md-12">

			<div class="card">

				<div class="card-header">

					<h4>Product Management</h4>

				</div>

				<div class="card-body">
				
				<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="product"
						action="${contextRoot}/manage/products" method="POST" enctype="multipart/form-data">
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="name">Enter Product Name</label> 
							
							<div class="col-md-9">
								
								<sf:input type="text" path="name" id="name" placeholder="Product Name" class="form-control" />
								<sf:errors path="name" cssClass="help-block" element="em" />
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="brand">Enter Brand Name</label> 
							
							<div class="col-md-9">
								
								<sf:input type="text" path="brand" id="brand" placeholder="Brand Name" class="form-control" />
								<sf:errors path="brand" cssClass="help-block" element="em" />
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="description">Product Description</label> 
							
							<div class="col-md-9">
								
								<sf:textarea path="description" id="description" rows="4" class="form-control"></sf:textarea>
								<sf:errors path="description" cssClass="help-block" element="em" />
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="unitPrice">Enter Unit Price</label> 
							
							<div class="col-md-9">
								
								<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price in &#8377;" class="form-control" />
								<sf:errors path="unitPrice" cssClass="help-block" element="em" />
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="quantity">Quantity Available</label> 
							
							<div class="col-md-9">
								
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control" />
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="file">Select an Image</label> 
							
							<div class="col-md-9">
								
								<sf:input type="file" path="file" id="file" class="form-control" />
								<sf:errors path="file" cssClass="help-block" element="em" />
							
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<label class="control-label col-md-3" for="categoryId">Select Category</label> 
							
							<div class="col-md-9">
								
								<sf:select path="categoryId" id="categoryId" class="form-control"
									items="${categories}" itemLabel="name" itemValue="id" >
									
								</sf:select>
								<c:if test="${product.id == 0}">
									<div class="text-right">
										<br/>
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning">Add Category</button>
									</div>
								</c:if>
								
							</div>
							
						</div>
						
						<div class="row form-group">
							
							<div class="col-md-3"></div>
							<div class="col-md-9">
								
								<input type="submit" name="submit" value="Submit" class="btn" />
								
								<!-- Hidden Fields -->
								<sf:hidden path="id" />
								<sf:hidden path="code" />
								<sf:hidden path="supplierId" />
								<sf:hidden path="active" />
								<sf:hidden path="purchases" />
								<sf:hidden path="views" />
								
							</div>
							
						</div>
						
					</sf:form>

				</div>

			</div>

		</div>

	</div>
	
	<div class="row">
		
		<div style="width:110%" class="col-xs-12">
			<hr/>
			<h3>Available Products</h3>
			<hr/>
			
		</div>
	</div>
	<div class=" row">
		<div style="width:100%" class="col-xs-12">
			
			<div style="overflow:auto">
				
				<!-- Products table for Admin -->
				<table id="adminProductsTable" class="table table-striped table-bordered">
					
					<thead>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					</thead>
					
					<tfoot>
						<tr>
							<th>Id</th>
							<th>&#160;</th>
							<th>Name</th>
							<th>Brand</th>
							<th>Quantity</th>
							<th>Unit Price</th>
							<th>Active</th>
							<th>Edit</th>
						</tr>
					
					</tfoot>
					
				</table>
				
			</div>
			
		</div>
		
	</div>

<!-- The Modal -->
<div class="modal fade" id="myCategoryModal" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">Add New Category</h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        
        <!-- Category Form -->
        <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
        	
        	<div class="form-group">
					<label class="control-label col-md-4">Name</label>
					<div class="col-md-8 validate">
						<sf:input type="text" path="name" class="form-control"
							placeholder="Category Name" /> 
					</div>
				</div>
       			
       			<div class="form-group">				
					<label class="control-label col-md-4">Description</label>
					<div class="col-md-8 validate">
						<sf:textarea path="description" class="form-control"
							placeholder="Enter category description here!" /> 
					</div>
				</div>	        	        
	        
	        
				<div class="form-group">				
					<div class="col-md-offset-4 col-md-4">					
						<input type="submit" name="submit" value="Save" class="btn btn-danger"/>						
					</div>
				</div>
        	
        </sf:form>
      </div>

    </div>
  </div>
</div>

</div>