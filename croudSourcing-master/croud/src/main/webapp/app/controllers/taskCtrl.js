mainApp.controller("taskCtrl", function($scope, $http, $location, $rootScope,
		taskService, clientService, $cookies, categoryService) {
	$scope.task = {};

	$scope.task.taskStatus = 'INITIATED';

	// for hiding the tables
	$scope.showTaskTable = false;
	$scope.showWorkerDetails = false;
	$scope.categoryLst = {};
	$scope.workerTasklst = {};
	
	getCategoryLst();
	//workerDetails();

	// create new task
	$scope.createTask = function() {
		var user = $cookies.get('user');
		$scope.task.clientUsername = user;
		$scope.task.workerStatus='PENDING';
		// use $.param jQuery function to serialize data
		// from JSON
		var data = angular.fromJson(angular.toJson($scope.task));
		$cookies.put("taskCat", $scope.task.categoryCode);
		
		var promise = taskService.createTask(data);
		promise.then(function(payload) {
			$cookies.put("taskId", payload);
			//$('#mymodal').modal('show');
			alert("task created")
			workerDetails();
			
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	};

	// create new task
	function getCategoryLst() {

		var promise = categoryService.getCategories();
		promise.then(function(payload) {
			$scope.categoryLst = payload
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	}
	;

	// fetch Initiated task details
	$scope.workerDetails = function() {
		var taskCat = $cookies.get('taskCat');
		var promise = taskService.getWorkerDetails(taskCat);
		promise.then(function(payload) {

			$scope.showWorkerDetails = true;
			$scope.workerTasklst = payload;
			//$scope.$digest();
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	}
	;

	$scope.sendReqToWorker = function(workerId) {

		$scope.workerDetails = {};

		var promise = clientService.getClientByUserName();
		promise.then(function(payload) {
			var taskId = $cookies.get('taskId');
			$scope.workerDetails.clientId = payload.clientpk;
			$scope.workerDetails.workerId = workerId;
			$scope.workerDetails.taskID = taskId;
			
			

			var data = angular.fromJson(angular.toJson($scope.workerDetails));

			var promise = taskService.assignTask(data);
			promise.then(function(payload) {
				//alert('Request Send to worker');
				$location.path('/clientDashboard');
				$scope.workerTasklst = payload;

			}, function(errorPayload) {
				console.error('failure loading username' + errorPayload);
			});

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	};

});