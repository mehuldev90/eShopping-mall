$(function() {
	

	// code for jquery dataTable
	
	var $table = $('#productListTable');

	// execute the below code only when we have this table
	if ($table.length) {
		// console.log('Inside the table!');

		var jsonUrl = '';
		if (window.categoryId == '') {
			jsonUrl = window.contextRoot + '/json/data/all/products';
		} else {
			jsonUrl = window.contextRoot + '/json/data/category/'
					+ window.categoryId + '/products';
		}
		
		$table.DataTable({
			
			lengthMenu: [[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength: 5,
			ajax: {
				url: jsonUrl,
				dataSrc: '',
			},
			columns: [

				{
					data : 'code',
					bSortable: false,
					mRender : function(data, type, row) {

						return '<img class="dataTableImage" src="'
								+ window.contextRoot
								+ '/resources/images/' + data
								+ '.jpg"/>';
					}

				},

				{
					data : 'name',
				},
				{
					data : 'brand',
				},
				{
					data : 'unitPrice',
					mRender : function(data, type, row) {

						return '&#8377; ' + data
					}
				},
				{
					data : 'quantity',
					mRender : function(data, type, row) {

						if (data < 1) {

							return '<span style="color:red">Out Of Stock!</span>';

						}

						return data;

					}
				},
				{
					data : 'id',
					bSortable: false,
					mRender : function(data, type, row) {

						var str = '';
						str += '<a href="'
								+ window.contextRoot
								+ '/show/'
								+ data
								+ '/product" class="btn btn-primary"><span class="fa fa-eye"></span></a> &#160;';
						
						if(userRole !== 'ADMIN') {
							if (row.quantity < 1) {
								str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="fa fa-shopping-cart"></span></a>';
							} else {

								str += '<a href="'
										+ window.contextRoot
										+ '/cart/add/'
										+ data
										+ '/product" class="btn btn-success"><span class="fa fa-shopping-cart"></span></a>';
							}
						}
						else {
							str += '<a href="'
								+ window.contextRoot
								+ '/manage/'
								+ data
								+ '/product" class="btn btn-warning"><span class="fa fa-pencil"></span></a>';
						}
						
						return str;
					}
				} ],
		});
		
	}
	
	
	// dismissing the alert after 3 seconds

	var $alert = $('.alert');

	if ($alert.length) {

		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

	
	// **********************
	// data table for admin
	// **********************

	var $adminProductsTable = $('#adminProductsTable');

	// execute the below code only when we have this table

	if ($adminProductsTable.length) {

		// console.log("Inside the table!");

		var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [
							[ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records',
									'All Records' ] ],
					pageLength : 30,
					ajax : {

						url : jsonUrl,
						dataSrc : ''
					},
					columns : 
						[
							{
								data : 'id',
							},
							{
								data : 'code',
								bSortable : false,
								mRender : function(data, type, row) {

									return '<img class="adminDataTableImg" src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" />';
								}

							},

							{
								data : 'name',
							},
							{
								data : 'brand',
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {

									if (data < 1) {

										return '<span style="color:red">Out Of Stock!</span>';

									}

									return data;

								}
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {

									return '&#8377; ' + data
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									
									if(data) {											
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <span class="slider round"> </span></label>';
										
									}else {
										str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <span class="slider round"> </span></label>';
									}
									
									return str;

								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'+window.contextRoot+'/manage/'+
										data + '/product" class="btn btn-warning">';
									str += '<span>Edit</span></a>';

									return str;
								}
							}, 
						],
						
						initComplete: function(){
							var api = this.api();
							api.$('.switch input[type="checkbox"]').on('change', function() {

								var checkbox = $(this);

								var checked = checkbox.prop('checked');

								var dMsg = (checked) ? 'You want to activate the product'
														: 'You want to deactivate the product';

								var value = checkbox.prop('value');

								bootbox.confirm({
											size : "medium",
											title : "Product Activation & Deactivation",
											message : dMsg,
											buttons : {
												cancel : {
													label : '<i class="fa fa-times"></i> Cancel'
												},
												confirm : {
													label : '<i class="fa fa-check"></i> Confirm'
												}
											},
											callback : function(confirmed) {
												
												if (confirmed) {
													console.log(value);
													var activationUrl = window.contextRoot + '/manage/product/' + value + '/activation';
													$.post(activationUrl, function(data){
														bootbox.alert({

															size : 'medium',
															title : 'Information',
															message : data

														});
													});
													
													
												} else {
													checkbox.prop("checked", !checked);
												}

											}
										});

							});
						}
				});

	}
	// *********************
	
	//validation code for category
	
		$categoryForm = $('#categoryForm');
		
		$categoryForm.validate({
			rules: {
				name : "required",
				description:{
					required: true,
					minlength: 2
				}
			},
		});
	//===================
	
	
		$loginForm = $('#loginForm');
		
		if($loginForm.length) {
			
			$loginForm.validate({			
					rules: {
						username: {
							required: true,
							email: true
							
						},
						password: {
							required: true
						}				
					},
					messages: {					
						username: {
							required: 'Please enter your email!',
							email: 'Please enter a valid email address!'
						},
						password: {
							required: 'Please enter your password!'
						}					
					},
					errorElement : "em",
					errorPlacement : function(error, element) {
						// Add the 'help-block' class to the error element
						error.addClass("help-block");
						
						// add the error label after the input element
						error.insertAfter(element);
					}				
				}
			
			);
			
		}
		
		// for handling CSRF token
		var token = $('meta[name="_csrf"]').attr('content');
		var header = $('meta[name="_csrf_header"]').attr('content');
		
		if((token!=undefined && header !=undefined) && (token.length > 0 && header.length > 0)) {		
			// set the token header for the ajax request
			$(document).ajaxSend(function(e, xhr, options) {			
				xhr.setRequestHeader(header,token);			
			});				
		}
	//------------------
		//handling the click event of refresh cart button
		
		$('button[name="refreshCart"]').click(function(){
			//fetch the cart line id
			var cartLineId = $(this).attr('value');
			
			var countElement = $('#count_' + cartLineId);
			
			var originalCount = countElement.attr('value');
			
			var currentCount = countElement.val();
			
			// work only when count has changed
			
			if(currentCount !== originalCount){
				
				if(currentCount < 1 || currentCount > 3){
					//reverting back to the original count when user has given value below 1 or above 3
					
					countElement.val(originalCount);
					
					bootbox.alert({
						size: 'medium',
						title: 'Error',
						message: 'Product should be minimum 1 and maximum 3',
					});
				}
				else
					{
						
					var updateUrl = window.contextRoot + '/cart/' + cartLineId + '/update?count='+ currentCount;
					//forward it to the controller now
					window.location.href = updateUrl;
					
					}
			}
			
		});
		
	//-------------------
});