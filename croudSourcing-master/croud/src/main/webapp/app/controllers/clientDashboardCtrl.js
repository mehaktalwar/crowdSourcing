/*  this is my main controller */

mainApp.controller("clientDashboardCtrl", function($scope, $resource, $http,
		 taskService, clientService,$cookies) {

	// needs attention`````````````````

/*	$scope.initiatedtask = {};
	$scope.taskHistoryLst = {};*/

	// status list for dropdown
	$scope.statusList = [ "INITIATED", "COMPLETED" ];
	$scope.feedbackList = [ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ];
	
	$scope.showTask= false;

	$scope.dropdownChange = function(item) {
		if (item === "COMPLETED") {
			$scope.finishFlag = true;
		}
	};
	$scope.showTaskLst = function() {
		$scope.showTask= false;
	};
	
	
	$scope.editTask = function(task) {

		$scope.showTask= true;
		
		var promise = taskService.getTaskDetailsByTaskId(task.taskpk);
		promise.then(function(payload) {

			$scope.initiatedtask = payload;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});

	};

	/* transfer money to worker */

	$scope.transferMoney = function() {

		var data = angular.fromJson(angular.toJson($scope.initiatedtask));
		var promise = taskService.transferMoney(data);
		promise.then(function(payload) {
			//$cookies.put('clientId', payload.clientpk);
			//$rootScope.loginClientId = payload.clientpk;
			getAllClientTasks();
			$scope.showTask= false;
		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		})
	};

	function init() {

		var promise = clientService.getClientByUserName();
		promise.then(function(payload) {
			//$cookies.put('clientId', payload.clientpk);
			//$rootScope.loginClientId = payload.clientpk;
			getAllClientTasks();

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);
		});
	}

	init();

	function getAllClientTasks() {

		var promise = taskService.getAllTaskByClient();
		promise.then(function(payload) {

			$scope.taskHistoryLst = payload;

		}, function(errorPayload) {
			console.error('failure loading username' + errorPayload);

		});

	}
	;

});