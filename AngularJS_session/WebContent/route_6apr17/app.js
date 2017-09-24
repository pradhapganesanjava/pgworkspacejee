/**
 * http://usejsdoc.org/
 */

var myApp = angular.module("myApp",['ngRoute']);

myApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl: 'pages/home.html',
		controller: 	'homecntrl'
	})
	.when('/about', {
		templateUrl: 'pages/about.html',
		controller: 	'aboutcntrl'
	})
	.when('/contact', {
		templateUrl: 'pages/contact.html',
		controller: 	'contactcntrl'
	});
	
});

myApp.controller("homecntrl", function($scope) {
	$scope.message = "This is a home page...";
});

myApp.controller("aboutcntrl", function($scope) {
	$scope.message = "This is a about us page...";
});

myApp.controller("contactcntrl", function($scope) {
	$scope.message = "This is a contact us page...";
});





