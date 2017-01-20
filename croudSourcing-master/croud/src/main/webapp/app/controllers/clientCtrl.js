/*  this is my main controller */

mainApp.controller("clientCtrl", function($scope, $resource, $http, $location,
		login) {
	$scope.client = {};

	$scope.client.clientName
	$scope.client.clientEmail
	$scope.client.password
	$scope.client.paymentMethod
	$scope.client.paymentInfo

	$scope.createClient = function() {
		var data = angular.fromJson(angular.toJson($scope.client));

		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}

		$http.post('http://192.168.43.34:8080/croud/rest/client/create', data,
				config).success(function(data, status, headers, config) {
			$scope.PostDataResponse = data;
			$location.path('/login');
		}).error(
				function(data, status, header, config) {
					$scope.ResponseDetails = "Data: " + data + "<hr />status: "
							+ status + "<hr />headers: " + header
							+ "<hr />config: " + config;
				});
	};

	$scope.validateUsername = function(email) {
		$scope.myForm.clientEmail.$setValidity("sameName", true);
		if (email != undefined) {
			var promise = login.verifyLogin(email);
			promise.then(function(payload) {

				if (payload.identifier != 'not a user') {
					$scope.myForm.clientEmail.$setValidity("sameName", false);
				}

			}), function(error) {

			}
		}

	};
});