mainApp.service('workerService', function($http, $q, $rootScope, $cookies) {

	this.getWorkerDetailsByUsername = function() {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		var user= $cookies.get('user');
		
		$http.get(
				'http://192.168.43.34:8080/croud/rest/worker/username/'
				+ user, config).success(
				function(result, status, headers, config) {

					deferred.resolve(result);

				}).error(function(result, status, header, config) {
			deferred.reject(result);
		});

		return deferred.promise

	};

	// pending requests
	this.getPendingRequests = function() {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		var workerId= $cookies.get('workerId');
		$http.get(
				'http://192.168.43.34:8080/croud/rest/workerTaskDetails/pendingReq/workerId/'
						//+ $rootScope.loginWorkerId, config).success(
				+workerId, config).success(
				function(result, status, headers, config) {

					deferred.resolve(result);

				}).error(function(result, status, header, config) {
			deferred.reject(result);
		});

		return deferred.promise

	};

	this.assignTaskReq = function(data) {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		var workerId= $cookies.get('workerId')
		$http.post(
				'http://192.168.43.34:8080/croud/rest/workerTaskDetails/assignTask/workerId/'
					
				+workerId, data, config).success(
				//+ $rootScope.loginWorkerId, data, config).success(
				function(result, status, headers, config) {

					deferred.resolve(result);

				}).error(function(result, status, header, config) {
			deferred.reject(result);
		});

		return deferred.promise

	};

	this.getCompletedTasks = function() {
		var deferred = $q.defer();
		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}
		var workerId= $cookies.get('workerId')
		$http.get(
				'http://192.168.43.34:8080/croud/rest/workerTaskDetails/id/'
				+ workerId, config).success(		
				function(result, status, headers, config) {

					deferred.resolve(result);

				}).error(function(result, status, header, config) {
			deferred.reject(result);
		});

		return deferred.promise

	};
});
