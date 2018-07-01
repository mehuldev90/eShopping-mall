<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@include file="../shared/flows-header.jsp" %>
		<div class="container">
			
			<div class="mt-4 card">
				
				<div class="card-header">

					<h4>Sign Up - Address</h4>
		
				</div>
				
				<div class="card-body">
				
					<sf:form method="POST" id="billingForm" modelAttribute="billing">
						
						<div class="row form-group">
							
							<label class="col-md-3" for="addressLineOne">Address Line One</label>
							<div class="col-md-9">
								<sf:input type="text" path="addressLineOne" class="form-control"
									placeholder="Enter Address Line One" />
								<sf:errors path="addressLineOne" cssClass="help-block" element="em"/>
							</div>
							
						</div>
						
						<div class="row form-group">
							<label class="control-label col-md-3" for="addressLineTwo">Address Line Two</label>
							<div class="col-md-9">
								<sf:input type="text" path="addressLineTwo" class="form-control"
									placeholder="Enter Address Line Two" />
								<sf:errors path="addressLineTwo" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="row form-group">
							<label class="control-label col-md-3" for="city">City</label>
							<div class="col-md-9">
								<sf:input type="text" path="city" class="form-control"
									placeholder="Enter City Name" />
								<sf:errors path="city" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="row form-group">
							<label class="control-label col-md-3" for="postalCode">Postal Code</label>
							<div class="col-md-9">
								<sf:input type="text" path="postalCode" class="form-control"
									placeholder="XXXXXX" />
								<sf:errors path="postalCode" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="row form-group">
							<label class="control-label col-md-3" for="state">State</label>
							<div class="col-md-9">
								<sf:input type="text" path="state" class="form-control"
									placeholder="Enter State Name" />
								<sf:errors path="state" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="row form-group">
							<label class="control-label col-md-3" for="country">Country</label>
							<div class="col-md-9">
								<sf:input type="text" path="country" class="form-control"
									placeholder="Enter Country Name" />
								<sf:errors path="country" cssClass="help-block" element="em"/> 
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" name="_eventId_personal" class="btn btn-primary">
								Back - Personal</button>
								<button type="submit" name="_eventId_confirm" class="btn btn-primary">
								Next - Confirm</button>																	 
							</div>
						</div>
						
					</sf:form>		
				</div>
			
			</div>
			
		</div>
		
	</div>
	
	<!-- /.container -->
	

<%@include file="../shared/flows-footer.jsp" %>