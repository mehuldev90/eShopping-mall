<%@include file="../shared/flows-header.jsp"%>
<div class="container">

	<div class="mt-4 card">

		<div class="card-header">

			<h4>Personal Details</h4>

		</div>

		<div class="card-body">

			<div class="text-center">
				
				<h4>${registerModel.user.firstName} ${registerModel.user.lastName}</h4>
				
				<h5>Email: ${registerModel.user.email}</h5>
				
				<h5>Contact Number: ${registerModel.user.contactNumber}</h5>
				
				<h5>Role: ${registerModel.user.role}</h5>
				
				
				<a href="${flowExecutionUrl}&_eventId_personal"
					class="btn btn-primary">Edit</a>

			</div>

		</div>

	</div>

	<div class="mt-4 card">

		<div class="card-header">

			<h4>Billing Address</h4>

		</div>

		<div class="card-body">

			<div class="text-center">
				
				
				<h4>${registerModel.billing.addressLineOne}</h4>
				
				<h5>${registerModel.billing.addressLineTwo}</h5>
				
				<h5>${registerModel.billing.city} ${registerModel.billing.postalCode}</h5>
				
				<h5>${registerModel.billing.state} ${registerModel.billing.country}</h5>
				
				
				<a href="${flowExecutionUrl}&_eventId_billing"
					class="btn btn-primary">Edit</a>

			</div>

		</div>

	</div>
	<div class="row">
	
		<div class="col-sm-4 col-sm-offset-4">
	
			<div class="text-center">
	
				<a href="${flowExecutionUrl}&_eventId_submit"
					class="btn btn-lg btn-primary">Confirm</a>
	
			</div>
	
		</div>
	
	
	</div>
</div>


<!-- /.container -->


<%@include file="../shared/flows-footer.jsp"%>