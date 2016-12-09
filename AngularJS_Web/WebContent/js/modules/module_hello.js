//this module does NOT have dependencies.
var module = angular.module("import_hello_mod", []);

module.controller("import_hello_mod_cntrl", import_hello_mod_cntrl_impl);

function import_hello_mod_cntrl_impl($scope) {
	console.log("import_hello_mod_cntrl_impl ");
	$scope.import_hello_mod_ngbind_txt1 = "Hello... this imported module's cntrl";
}
