// Code goes here

// Creating a Module
var myApp = angular.module("myApp", []);

// Controllers
myApp.controller("hellocntrl", function($scope) {
  $scope.fname = "John";
  $scope.lname = "Smith";
})

myApp.controller("statecntrl", function($scope) {
  
  $scope.data = ['NY', 'NJ', 'TX'];
  
  $scope.addState = function() {
    console.log("==>" + $scope.newstate);
    $scope.data.push($scope.newstate);
    $scope.newstate = "";
  }
  
  $scope.delState = function(tempState) {
    var index = $scope.data.indexOf(tempState);
    $scope.data.splice(index, 1);
  }
  
})



