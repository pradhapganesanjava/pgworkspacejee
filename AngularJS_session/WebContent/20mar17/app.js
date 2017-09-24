var app = angular.module('plunker', []);

app.controller('MainCtrl', function($scope, $http) {
  $scope.name = 'World';
  
  $http.get("http://api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=10&appid=a30ebb5af6b78e566e1797db9855606e").success(function(data) {
    $scope.weatherinfo = data.list;
    console.log($scope.weatherinfo);
  });
  
  
  
});
