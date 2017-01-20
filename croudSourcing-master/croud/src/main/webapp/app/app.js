var mainApp = angular.module('superMod', [ 'ngRoute','ngResource','ngCookies','ui.bootstrap' ]);

mainApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.

	when('/createTask', {
		templateUrl : 'partials/taskForm.html',
		controller : 'taskCtrl'
	}).
	when('/login', {
		templateUrl : 'partials/loginForm.html',
		controller : 'loginCtrl'
	}).
	when('/adminDashboard', {
		templateUrl : 'partials/adminDashboard.html',
		controller : 'adminDashboardCtrl'
	}).
	when('/createCategory', {
		templateUrl : 'partials/categoryForm.html',
		controller : 'categoryCtrl'
	}).
	when('/createClient', {
		templateUrl : 'partials/clientForm.html',
		controller : 'clientCtrl'
	}).	when('/recommendationForm', {
		templateUrl : 'partials/recommendationForm.html',
		controller : 'clientCtrl'
	}).
	when('/createWorker', {
		templateUrl : 'partials/workerForm.html',
		controller : 'workerCtrl'
	}).
	when('/clientDashboard', {
		templateUrl : 'partials/clientDashboard.html',
		controller : 'clientDashboardCtrl'
	}).
	when('/workerDashboard', {
		templateUrl : 'partials/workerDashboard.html',
		controller : 'workerDashboardCtrl'
	}).
	when('/logout', {
		templateUrl : 'partials/loginForm.html',
		controller : 'mainController'
	}).
	when('/homePage', {
		templateUrl : 'partials/homePage.html',
		controller : 'mainController'
	}).
	otherwise({
		redirectTo : '/'
	});
} ]);

