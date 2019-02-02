/**
 * 
 */
var app = angular.module('myApp', []);
app.config(['$httpProvider', function($httpProvider){
    $httpProvider.defaults.timeout=30000;
}]);

app.controller('myCtrl', function($scope, $http) {
    this.retrieve = function() {
        // console.log('Retrieve button was clicked');
        $http.get('http://localhost:8855/api/issues/locations')
        .then(function(response){
            console.log('inside success' + response);
            $scope.locations = response.data;
        }, function(response) {
            console.log('Something went wrong, hence came here');
    
        });
    }
});