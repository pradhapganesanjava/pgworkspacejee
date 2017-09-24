var app = angular.module('plunker', []);

app.controller('MainCtrl', function($scope) {
  $scope.name = 'World';
  
  
  $scope.product = {
    name:"TV",
    ctg:"Entertain"
  };

  //User json
  
  $scope.user = {
    name:"Pradhap Ganesan",
    address:{
      street:"9805 NW",
      house:"Apt",
      city:"Doral",
      state:"FL"
    },
    friends:[{name:"Friend_A"},
             {name:"Friend_B"},
             {name:"Friend_C"}]
    
  }
  
});

app.directive("pgMyTag",function(){
  return {
    restrict:"E",
    template:'<B>My Tag Template Exampl'
  }
})

app.directive('pgTemplate',function(){
  return {
    template:'<p> Name: <b>{{product.name}}</b> </p> <p> Category: <b>{{product.ctg}}</b> </p>'
  }
})

app.directive('pgTemplateUrl',function(){
  return {
    templateUrl:"prodTemplate.html"
  }
})


app.directive('pgLink',function(){
  return {
    template:'<p> Name: <b>{{product.name}}</b> </p> <p> Category: <b>{{product.ctg}}</b> </p>',
    link:function($scope,element,attrs){
      element.bind('click',function(){
        console.log('clicked');
      });
    }
  }
})

app.directive('pgUserTemplateUrl',function(){
  return {
    templateUrl:"userTemplate.html"
  }
})

app.directive('pgController',function(){
  return {
    
  }
})