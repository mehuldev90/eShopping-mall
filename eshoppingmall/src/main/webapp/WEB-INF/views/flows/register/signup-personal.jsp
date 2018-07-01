<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>


<div class="container">

	<div class="mt-4 card">

		<div class="card-header">

			<h4>Sign-Up Personal</h4>

		</div>

		<div class="card-body">

			<sf:form method="POST" id="registerForm" modelAttribute="user">

				<div class="row form-group">
					<label class="col-md-3">First Name</label>
					<div class="col-md-9">
						<sf:input path="firstName" type="text" class="form-control"
							placeholder="First Name" />
						<sf:errors path="firstName" cssClass="help-block" element="em" />
					</div>
				</div>

				<div class="row form-group">
					<label class="col-md-3">Last Name</label>
					<div class="col-md-9">
						<sf:input type="text" path="lastName" class="form-control"
							placeholder="Last Name" />
						<sf:errors path="lastName" cssClass="help-block" element="em" />
					</div>
				</div>

				<div class="row form-group">
					
					<label class="col-md-3">Email</label>
					<div class="col-md-9">
						<sf:input type="text" path="email" class="form-control"
							placeholder="abc@zyx.com" />
						<sf:errors path="email" cssClass="help-block" element="em"/> 									
					</div>
					
				</div>

				<div class="row form-group">
					<label class="col-md-3">Contact Number</label>
					<div class="col-md-9">
						<sf:input type="text" path="contactNumber" class="form-control"
							placeholder="XXXXXXXXXX" maxlength="10" />
						<sf:errors path="contactNumber" cssClass="help-block" element="em"/> 
					</div>
				</div>

				<div class="row form-group">
					<label class="col-md-3">Password</label>
					<div class="col-md-9">
						<sf:input type="password" path="password" class="form-control"
							placeholder="Password" />
						<sf:errors path="password" cssClass="help-block" element="em"/> 
					</div>
				</div>

				<div class="row form-group">
					<label class="col-md-3">Confirm Password</label>
					<div class="col-md-9">
						<sf:input type="password" path="confirmPassword" class="form-control"
							placeholder="Re-enter password" />
						<sf:errors path="confirmPassword" cssClass="help-block" element="em"/>										 
					</div>
				</div>

				<div class="row form-group">
					<label class="col-md-3">Select Role</label>
					<div class="col-md-9">
						<label class="radio-inline">
							<sf:radiobutton path="role" value="USER" checked="checked"/> User 				
						</label>
						<label class="radio-inline">
							<sf:radiobutton path="role" value="SUPPLIER"/> Supplier
						</label>
					</div>
				</div>
				
				<div class="row form-group">
					<div class="form-group">
						<div class="col-md-8">
							<button type="submit" name="_eventId_billing" class="btn btn-primary">
								Next - Billing</span>
							</button>																	 
						</div>
					</div>
				</div>

			</sf:form>

		</div>

		<div class="card-footer">Footer</div>
	</div>
</div>

<%@include file="../shared/flows-footer.jsp"%>