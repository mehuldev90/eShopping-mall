var app = angular.module('ShoppingApp', []);

app.controller('ProductController', function($http){
	
	var me = this;
	
	me.mvProducts = [];
	
	me.fetchProducts = function(){
		
		$http.get('/eshoppingmall/json/data/most/viewed/products')
			.then(function(response){
				me.mvProducts = response.data;
			});
	}
});