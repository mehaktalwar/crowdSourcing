mainApp.service('clientService', function($http, $q,$cookies) {
	
	

	this.getClientByUserName = function() {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		var user=$cookies.get('user');
		
		$http.get('http://192.168.43.34:8080/croud/rest/client/username/'
				+ user,
				config).success(function(result, status, headers, config) {

			 deferred.resolve(result);

		}).error(function(result, status, header, config) {
			 deferred.reject(result);
		});
		
		return deferred.promise

	};
	

});



	