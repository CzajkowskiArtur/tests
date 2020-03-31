(function() {

	var app = angular.module("editApp", ['dndLists']);

	var editCtrl = function($scope, $http) {
		
		$scope.isQuizSaving = false;
		$scope.isPublishing = false;
		
		$scope.refreshQuizData = function() {
			if ($scope.quizId == 0)
				return;

			$http.get("/api/quiz" + $scope.quizId)
			.then(
					function(response) {
						$scope.quiz = response.data;
					}, 
					function(reason) {
						console.log(reason.data);
					}
			);
		}

		$scope.refreshQuestions = function() {
			if ($scope.quizId == 0)
				return;

			$http.get("/api/quiz/" + $scope.quizId + "/questions/")
			.then(
					function(response) {
						$scope.questions = response.data;
						$scope.newQuestion = "";
					}, 
					function(reason) {
						console.log(reason.data);
					}
			);
		}

		$scope.saveQuestion = function(questionId, questionText) {
			var url = "/api/questions";
			
			if (questionId != 0) {
				url = url + "/" + questionId;
			}

			$http.post(url + "?text=" + questionText + "&quiz_id=" + $scope.quizId)
			.then(
					function(response) {
						console.log(response.data);
						if (questionId == 0) {
							$scope.questions.push(response.data);
							$scope.newQuestion = "";
						}
					}, 
					function(reason) {
						console.log(reason.data);
					}
			);
		}

		$scope.refreshQuizData();
		$scope.refreshQuestions();
	};

	app.controller("EditCtrl", ["$scope", "$http", editCtrl]);

}());