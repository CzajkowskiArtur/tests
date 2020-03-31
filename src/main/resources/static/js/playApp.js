(function() {

	var app = angular.module("playQuizApp", []);

	var playQuizCtrl;
	playQuizCtrl = function ($scope, $http) {

		$scope.Math = window.Math;

		var questions = [];
		var answers = [];

		$scope.totalQuestions = 0;
		$scope.questionCount = 0;

		$scope.isPlaying = true;

		$scope.initialize = function () {
			if ($scope.quizId == 0)
				return;

			$scope.playing = true;

			$http.get("/api/quiz/" + $scope.quizId + "/questions")
				.then(
					function (response) {
						questions = questions.concat(response.data);
						$scope.totalQuestions = questions.length;
						$scope.setQuestion($scope.questionCount);
					},
					function (reason) {
						$scope.error = "Could not fetch the data.";
					}
				);
		}

		$scope.setQuestion = function (questionNumber) {

			$http.get("/api/quiz/" + $scope.questionCount + "/answers")
				.then(
					function (response) {
						$scope.currentQuestion = questions[questionNumber];
						$scope.currentAnswers = response.data;
					},
					function (reason) {
						$scope.error = "Could not fetch the data.";
					}
				);
		}

		$scope.answerQuestion = function (selection) {

			console.log(selection);

			answers.push({
				question: $scope.currentQuestion,
				selectedAnswer: selection,
		});

			$scope.questionCount++;
			if ($scope.questionCount == $scope.totalQuestions) {
				$scope.submitAnswers();
			} else {
				$scope.selectedAnswer == null;
					$scope.setQuestion($scope.questionCount);
			}
		}

		$scope.submitAnswers = function () {
			$http.post("/api/quiz/" + $scope.quizId + "/submitAnswers",
				JSON.stringify(answers))
				.then(
					function (response) {
						$scope.results = response.data;
						$scope.playing = false;
					},
					function (reason) {
						$scope.error = "Could not fetch the data.";
					}
				);
		}

		$scope.initialize();
	};

	app.controller("PlayQuizCtrl", ["$scope", "$http", playQuizCtrl]);

}());