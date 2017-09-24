var app = angular.module('plunker', []);

app.controller('MainCtrl', function($scope) {
  $scope.name = 'World';
  $scope.product = {
    name: 'USB',
    category: 'Storage'
  };
  
  $scope.user = {
    name: "James Bond",
    address: {
      street: "Royal Dr",
      city: "Piscataway",
      state: "NJ"
    },
    friends: [
        'John',
        'Johny',
        'Janardhan'
      ]
  }
  
});

app.directive("helloCustomDirective", function() {
  return {
    restrict: 'E',
    template: '<h3>Hello from custom directive!!</h3>'
  }
})

app.directive("sampleProduct", function() {
  return {
    templateUrl: 'product.html',
    link: function($scope, element, attrs) {
      element.bind('click', function() {
        console.log('You clicked!');
      });
      element.bind('mouseenter', function() {
        element.css('background-color','yellow');
      });
      element.bind('mouseleave', function() {
        element.css('background-color','white');
      });
    }
  }
})

app.directive("userInfoCard", function() {
  return {
    templateUrl: 'userinfo.html',
    controller: function($scope) {
      $scope.collapsed = false;
      $scope.toAdmin = function(user) {
        user.role = "Admin";
      }
      $scope.collapse = function() {
        $scope.collapsed = !$scope.collapsed;
      }
    }
  }
})

app.directive('address', function() {
  return {
    templateUrl: 'address.html',
    scope: true,
    controller: function($scope) {
      $scope.collapsed = false;
      $scope.collapseAddress = function() {
        $scope.collapsed = true;
      }
      $scope.expandAddress = function() {
        $scope.collapsed = false;
      }
    }
  }
});




