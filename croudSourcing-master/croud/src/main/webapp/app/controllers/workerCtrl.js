/*  this is my main controller */

mainApp.controller("workerCtrl", function($scope, $resource, $http, $location,
		categoryService, login) {
	$scope.worker = {};

	$scope.worker.workerName = '';
	$scope.worker.workeraddress = '';
	$scope.worker.workerPassword = '';
	$scope.worker.expertiseArea = '';
	$scope.worker.levelExpertise = '';
	$scope.worker.servicefee = '';
	$scope.worker.workerEmail = ' ';
	$scope.worker.availabilityFlag = false;

	getCategoryLst();

	function getCategoryLst() {

		var promise = categoryService.getCategories();
		promise.then(function(payload) {
			$scope.categoryLst = payload
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	}
	;
	$scope.createWorker = function() {

		var data = angular.fromJson(angular.toJson($scope.worker));

		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}

		$http.post('http://192.168.43.34:8080/croud/rest/worker/create', data,
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

		if (email != undefined) {

			$scope.myForm.workerEmail.$setValidity("sameName", true);
			var promise = login.verifyLogin(email);
			promise.then(function(payload) {

				if (payload.identifier != 'not a user') {
					$scope.myForm.workerEmail.$setValidity("sameName", false);
				}

			}), function(error) {

			}
		}

	};

	$scope.workerTaskLst = function() {

		var config = {
			headers : {
				'Content-Type' : 'application/json'
			}
		}

		$http.get('http://192.168.43.34:8080/croud/rest/worker/workerLst', config)
				.success(function(data, status, headers, config) {
					$scope.workerPendingReqlst = data;
				}).error(
						function(data, status, header, config) {
							$scope.ResponseDetails = "Data: " + data
									+ "<hr />status: " + status
									+ "<hr />headers: " + header
									+ "<hr />config: " + config;
						});
	};
});