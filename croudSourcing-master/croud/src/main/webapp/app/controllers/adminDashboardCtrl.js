/*  this is my main controller */

mainApp.controller("adminDashboardCtrl",
		function($scope, $resource, $http, categoryService) {
			$scope.category = {};

			$scope.category.categoryName = '';
			$scope.category.categoryDesc = '';
			$scope.categoryLst = {};
			$scope.showCategoryTable = false;

			getCategories();
			$scope.sendPost = function() {
				// use $.param jQuery function to serialize data from JSON

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

							getCategories();
							$scope.showCategoryTable = true;
						}).error(
						function(data, status, header, config) {
							$scope.ResponseDetails = "Data: " + data
									+ "<hr />status: " + status
									+ "<hr />headers: " + header
									+ "<hr />config: " + config;
						});
			};
			
			$scope.deleteCategory = function(categorypk) {
				// use $.param jQuery function to serialize data from JSON

				//var data = angular.fromJson(angular.toJson($scope.category));

				var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}

				$http['delete']('http://192.168.43.34:8080/croud/rest/category/delete/id/'+
						categorypk, config).success(
						function(data, status, headers, config) {
							$scope.PostDataResponse = data;

							getCategories();
							$scope.showCategoryTable = true;
						}).error(
						function(data, status, header, config) {
							$scope.ResponseDetails = "Data: " + data
									+ "<hr />status: " + status
									+ "<hr />headers: " + header
									+ "<hr />config: " + config;
						});
			};

			function getCategories() {
				// use $.param jQuery function to serialize data from JSON
				var config = {
					headers : {
						'Content-Type' : 'application/json'
					}
				}

				$http.get('http://192.168.43.34:8080/croud/rest/category/categoryLst'
					, config).success(
						function(data, status, headers, config) {
							$scope.categoryLst = data;
						}).error(
						function(data, status, header, config) {
							$scope.ResponseDetails = "Data: " + data
									+ "<hr />status: " + status
									+ "<hr />headers: " + header
									+ "<hr />config: " + config;
						});

			}
			;

		} );