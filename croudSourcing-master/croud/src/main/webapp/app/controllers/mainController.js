/*  this is my main controller */



mainApp.controller('mainController', function($scope,$http, $cookies){
	
$cookies.remove('user');
$cookies.remove('clientId');
$cookies.remove('workerId');
$cookies.remove('taskId');
$cookies.remove('taskCat');

	
});