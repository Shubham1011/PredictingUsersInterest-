
var App = angular.module('app',['ui.router']);

App.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, 
		$urlRouterProvider){

	//if any url does not match with states, it will redirect to login
	$urlRouterProvider.otherwise("/home")
	
	$stateProvider
	.state('home', { //state for login
		url: "/home",
		templateUrl: "views/dashboard.html",
		controller: "DashboardController"
	})
	.state('fillform', { //state for login
		url: "/fillform",
		templateUrl: "views/fillform.html",
		controller: "FillformController"
	})


}])

.controller("DashboardController", function( $rootScope,$scope,$http,$location,$window) {
	
	$rootScope.user="shubham";
	
	 
 })
 .controller("FillformController", function( $rootScope,$scope,$http,$location,$window) {
	
	 $rootScope.user="palkar";
	 $scope.att={}
	 $scope.showinterest=false;
	 $scope.reset= function(){
	 
	$scope.showinterest=false;
	$scope.att={};
	document.getElementById("predictbutton").style.display="block";
	document.getElementById("resetbutton").style.display="none";
	 },
	 
	 $scope.process = function() {
		 $scope.showinterest=true;
         
			
			$http(
					{

						method : "POST",
						url : "http://localhost:1234/trainmodel",
						data : angular.toJson($scope.att),
						headers : {
							'Content-Type' : 'application/json'
						}
					}).then(_success2, _error2);
			function _success2(response) {
				
				$scope.interestlist=response.data;
				document.getElementById("predictbutton").style.display="none";
				document.getElementById("resetbutton").style.display="block";
			}

			function _error2(response) {
				// document.getElementById("business-button-fail").style.display="block";
				// document.getElementById("business-button-sending").style.display="none";
				
				alert("somethng went wrong"+$scope.interestlist);
			}
		}

	 
 })

