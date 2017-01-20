/*  this is my main controller */

mainApp.controller("workerDashboardCtrl", function($scope, $resource, $http,
		workerService, $rootScope, $cookies) {
	$scope.workerDetails = {};
	$scope.workerTasklst = {};
	$scope.workerPendingReqlst = {};
	$scope.worker = {};
	$scope.tab1 = true;
	workerDetails();
	workerTaskList();
	getRequestedTask();
	$scope.showTab = function(tab) {

		switch (tab) {
		case 1:
			$scope.tab1 = true;
			$scope.tab2 = false;
			$scope.tab3 = false;
			break;
		case 2:
			$scope.tab1 = false;
			$scope.tab2 = true;
			$scope.tab3 = false;
			break;
		case 3:
			$scope.tab1 = false;
			$scope.tab2 = false;
			$scope.tab3 = true;
			break;
		default:
			$scope.tab1 = true;
			$scope.tab2 = false;
			$scope.tab3 = false;
		}
	};

	//worker Details
	function workerDetails() {

		var promise = workerService.getWorkerDetailsByUsername();
		promise.then(function(payload) {

			$scope.worker = payload;
			//$cookies.put('workerId', payload.pkWorker);
		//	$rootScope.loginWorkerId = payload.pkWorker;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);

		});
	}

	//worker Details
	function workerDetails() {

		var promise = workerService.getWorkerDetailsByUsername();
		promise.then(function(payload) {

			$scope.worker = payload;
			//$cookies.put('workerId', payload.pkWorker);
		//	$rootScope.loginWorkerId = payload.pkWorker;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);

		});
	}

	$scope.assignTask = function(assignTaskStatus, taskDetails) {
		$scope.workerDetails = taskDetails;
		$scope.workerDetails.taskStatus = assignTaskStatus;
		//$scope.workerDetails.taskID = taskid;

		var data = angular.fromJson(angular.toJson($scope.workerDetails));

		var promise = workerService.assignTaskReq(data);
		promise.then(function(payload) {

			$scope.worker = payload;
			workerDetails();
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	};

	//worker pending requests
	function getRequestedTask() {

		var promise = workerService.getPendingRequests();
		promise.then(function(payload) {

			$scope.workerPendingReqlst = payload;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	};
	//completed task List
	function workerTaskList() {

		var promise = workerService.getCompletedTasks();
		promise.then(function(payload) {

			$scope.workerTasklst = payload;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	}
	;

});