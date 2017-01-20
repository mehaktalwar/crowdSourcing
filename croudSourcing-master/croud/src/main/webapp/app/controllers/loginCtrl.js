/*  this is my main controller */

mainApp.controller("loginCtrl", function($scope, $http, $location, $rootScope,
		$cookies, login, clientService, workerService) {
	$scope.login = {};
	$scope.login.username = '';
	$scope.login.password = '';
	$scope.login.identifier = '';

	$scope.verifyUser = function() {
		
		/*$('#myModal').modal('show');*/

		if ($scope.login.username == 'admin@inse.com'
				&& $scope.login.password == "12345") {
			$cookies.put('identifier', 'admin');

			$location.path('/adminDashboard');

		} else {

			//var data = angular.fromJson(angular.toJson($scope.login));

			var promise = login.verifyLogin($scope.login.username);
			promise.then(function(payload) {

				if (payload.username != null && payload.username != '') {

					if ($scope.login.username == payload.username
							&& $scope.login.password == payload.password) {
						//$rootScope.loginUserName = payload.username;
						//	$rootScope.loginIdentifier = payload.identifier;
						//	$rootScope.loginStatus = true;
						$cookies.put('loginState', true);
						$cookies.put('identifier', payload.identifier);
						$cookies.put('user', payload.username);

						if (payload.identifier == "worker") {
							
							var promise = workerService.getWorkerDetailsByUsername();

							promise.then(function(payload) {
								$cookies.put('workerId', payload.pkWorker);
								$location.path('/workerDashboard');

							}, function(errorPayload) {
								console.error('failure loading username'
										+ errorPayload);
							});
							
							
						} else if (payload.identifier == "client") {

							var promise = clientService.getClientByUserName();

							promise.then(function(payload) {
								$cookies.put('clientId', payload.clientpk);
								$location.path('/clientDashboard');

							}, function(errorPayload) {
								console.error('failure loading username'
										+ errorPayload);
							});

						} else {
							alert('login details are not correct');
						}
					} else {
						alert('login details are not correct');
					}
				} else {
					alert('username not found in database');
				}
			},

			function(errorPayload) {

				console.error('failure loading username', errorPayload);

			});

		}
	};
});
