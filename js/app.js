var mainApp = angular.module("mainApp", ["ngRoute", "customService", "tm.pagination"]);

mainApp.config(function($routeProvider, $locationProvider){

	//$locationProvider.html5Mode(true);

	$routeProvider.when("/student", {
		templateUrl: "student/student.html"
	})
	.when("/student/detail/:id", {
		templateUrl: "student/student_article.html"
	})
	.when("/student/personalInfo", {
		templateUrl: "student/student_personal.html"
	})
	.when("/teacher", {
		templateUrl: "teacher/teacher.html"
	})
	.when("/teacher/tpersonalInfo", {
		templateUrl: "teacher/teacher_personal.html"
	})
	.when("/teacher/applyDetail/:id", {
		templateUrl: "teacher/applyDetail.html"
	})
	.when("/boss/applyTable/:id", {
		templateUrl: "boss/applyTable.html"
	})
	.when("/boss", {
		templateUrl: "boss/boss.html"
	})
	.when("/boss/alterAct/:id", {
		templateUrl: "boss/alterAct.html"
	})
	.when("/boss/createTask", {
		templateUrl: "boss/boss_article.html"
	})
	.when("/boss/assignTask/:id", {
		templateUrl: "boss/assignTask.html"
	})
	.when("/boss/myTask", {
		templateUrl: "boss/taskDetail.html"
	})
	.when("/boss/altTask/:id", {
		templateUrl: "boss/altTask.html"
	})
	.when("/boss/bpersonalInfo", {
		templateUrl: "boss/boss_personal.html"
	})
	.otherwise({
		templateUrl: "login.html",
		resolve: {
			data: function(){
				sessionStorage.removeItem("user");
				sessionStorage.removeItem("activities");
				sessionStorage.removeItem("tasks");
				sessionStorage.removeItem("informs");
			}
		}
	});
});
