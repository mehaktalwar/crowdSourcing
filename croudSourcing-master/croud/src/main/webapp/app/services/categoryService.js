mainApp.service('categoryService', function($http, $q,$cookies) {
	
	

	this.getCategories = function() {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		
		$http.get('http://192.168.43.34:8080/croud/rest/category/categoryLst',
				config).success(function(result, status, headers, config) {

			 deferred.resolve(result);

		}).error(function(result, status, header, config) {
			 deferred.reject(result);
		});
		
		return deferred.promise

	};
	

});



	