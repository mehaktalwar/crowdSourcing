//service style, probably the simplest one
mainApp.service('login', function($http, $q) {
	
	this.verifyLogin = function(data) {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		$http.get('http://192.168.43.34:8080/croud/rest/details/verifyUser/' + data,
				config).success(function(result, status, headers, config) {

			 deferred.resolve(result);

		}).error(function(result, status, header, config) {
			 deferred.reject(result);
		});
		
		return deferred.promise

	};
	
	
	this.getLoginIdByUsername = function(data) {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		$http.post('http://192.168.43.34:8080/croud/rest/details/verifyUser', data,
				config).success(function(result, status, headers, config) {

			 deferred.resolve(result);

		}).error(function(result, status, header, config) {
			 deferred.reject(result);
		});
		
		return deferred.promise

	};
	
});