/*  this is my main controller */

mainApp.controller("categoryCtrl", [
		'$scope',
		'$resource',
		'$http',
		function($scope, $resource, $http) {
			$scope.category = {};

			$scope.category.categoryName = '';
			$scope.category.categoryDesc = '';


			$scope.sendPost = function() {

				var data = angular.fromJson(angular.toJson($scope.category));

				var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}

				$http.post('http://192.168.43.34:8080/croud/rest/category/create',
						data, config).success(
						function(data, status, headers, config) {
							$scope.PostDataResponse = data;
						}).error(
						function(data, status, header, config) {
							$scope.ResponseDetails = "Data: " + data
									+ "<hr />status: " + status
									+ "<hr />headers: " + header
									+ "<hr />config: " + config;
						});
			};
		} ]);