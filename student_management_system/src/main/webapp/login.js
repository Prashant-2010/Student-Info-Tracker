let x=angular.module("myModule",[]);
x.controller("myController",function($scope,$http){

	$scope.loginData={};
	$scope.bioData={};
	
	$scope.saveInfo=function(){
		$http({
			method:"POST",
			url:"saveloginServlet",
			data:JSON.stringify($scope.loginData)
		})
		.then(function(response){
			
		})
	}
		$scope.savebiodata=function(){
		$http({
			method:"POST",
			url:"SaveBiodata",
			data:JSON.stringify($scope.bioData)
		})
		.then(function(response){
			
		})
	}
})