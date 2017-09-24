var app = angular.module('plunker', []);

app.controller('MainCtrl', function($scope, $http) {
  $scope.name = 'World';
  
  $http.get("http://api.openweathermap.org/data/2.5/find?lat=45.5&lon=45.5&cnt=10&appid=a30ebb5af6b78e566e1797db9855606e").success(function(data) {
    $scope.weatherinfo = data.list;
    console.log($scope.weatherinfo);
    $scope.sortColumn = "name";
  });
  
  $scope.reverseSort = false;
  
  $scope.sortData = function(column) {
    $scope.reverseSort = ($scope.sortColumn == column) ? !$scope.reverseSort : false;
    $scope.sortColumn = column;
    
  }
  
  $scope.getSortClass = function(column) {
    if($scope.sortColumn == column) {
      return $scope.reverseSort ? 'arrow-down' : 'arrow-up';
    }
    return '';
  }
  
});
