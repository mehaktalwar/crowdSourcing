mainApp
		.service(
				'taskService',
				function($http, $q, $rootScope,$cookies) {

					this.createTask = function(data) {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http.post(
								'http://192.168.43.34:8080/croud/rest/task/create',
								data, config).success(
								function(result, status, headers, config) {

									deferred.resolve(result);

								}).error(
								function(result, status, header, config) {
									deferred.reject(result);
								});

						return deferred.promise

					};
					
					var user= $cookies.get('user');

					this.getTaskDetails = function() {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http
								.get(
										'http://192.168.43.34:8080/croud/rest/task/initiatedTask/'
										+ user,
										config)
								.success(
										function(result, status, headers,
												config) {
											deferred.resolve(result);
										})
								.error(
										function(result, status, header, config) {
											deferred.reject(result);
										});

						return deferred.promise

					};

					this.getWorkerDetails = function(taskCategory) {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http
								.get(
										'http://192.168.43.34:8080/croud/rest/worker/workerLstbyCat/'+taskCategory,
										config)
								.success(
										function(result, status, headers,
												config) {
											deferred.resolve(result);
										})
								.error(
										function(result, status, header, config) {
											deferred.reject(result);
										});

						return deferred.promise

					};

					this.assignTask = function(data) {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http
								.post(
										'http://192.168.43.34:8080/croud/rest/workerTaskDetails/assignTaskReq',
										data, config)
								.success(
										function(result, status, headers,
												config) {
											deferred.resolve(result);
										})
								.error(
										function(result, status, header, config) {
											deferred.reject(result);
										});

						return deferred.promise

					};

					this.getAllTaskByClient = function() {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						var clientId= $cookies.get('clientId');
						$http
								.get(
										'http://192.168.43.34:8080/croud/rest/task/clientId/'
												+ clientId,
												//+ $rootScope.loginClientId,
										config)
								.success(
										function(result, status, headers,
												config) {
											deferred.resolve(result);
										})
								.error(
										function(result, status, header, config) {
											deferred.reject(result);
										});

						return deferred.promise

					};

					this.getTaskDetailsByTaskId = function(taskId) {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http.get(
								'http://192.168.43.34:8080/croud/rest/task/taskId/'
										+ taskId, config).success(
								function(result, status, headers, config) {
									deferred.resolve(result);
								}).error(
								function(result, status, header, config) {
									deferred.reject(result);
								});

						return deferred.promise

					};

					this.transferMoney = function(data) {
						var deferred = $q.defer();
						var config = {
							headers : {
								'Content-Type' : 'application/json'
							}
						}
						$http
								.post(
										'http://192.168.43.34:8080/croud/rest/task/payment/',
										data, config)
								.success(
										function(result, status, headers,
												config) {
											deferred.resolve(result);
										})
								.error(
										function(result, status, header, config) {
											deferred.reject(result);
										});

						return deferred.promise

					};

				});
