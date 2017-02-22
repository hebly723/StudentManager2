var customService =  angular.module("customService", []);
customService.service("userService", ['$http', '$location', function($http, $location){
		var userService = {};
				userService.setUser = function(user){
					sessionStorage.setItem("user", JSON.stringify(user));
				}

				userService.getUserInfo = function(){
					var user = sessionStorage.getItem("user");
					user = JSON.parse(user);
					if(user == null || user == ""){
						user = {
							userId: "",
							userName: "",
							password: "",
							role: "", 
							QQ: "",
							tel: "",
							email: "",
							academy: ""
						};
					}
					return user;
				}

				return userService;
	}]);

customService.service("announceService", [function(){
	var announceService = {};

	announceService.set = function(annos){
		if(angular.isArray(annos)){
			var announces = "";
			for (var i = 0; i < annos.length; i++) {
				announces += JSON.stringify(annos[i]);
				if(i != annos.length-1)
					announces += "~";
			}

			sessionStorage.setItem("announces", announces);
		}
	}

	announceService.get = function(){
		var announces = sessionStorage.getItem("announces");
		if(announces != null && announces != ""){
			announces = sessionStorage.getItem("announces").split("~");
			for (var i = 0; i < announces.length; i++) {
				announces[i] = JSON.parse(announces[i]);
			}
		}else{
			var announces = new Array(5);
		}
		
		return announces;
	}

	announceService.set2 = function(annos){
		if(angular.isArray(annos)){
			var announces = "";
			for (var i = 0; i < annos.length; i++) {
				announces += JSON.stringify(annos[i]);
				if(i != annos.length-1)
					announces += "~";
			}

			sessionStorage.setItem("announces2", announces);
		}
	}

	announceService.get2 = function(){
		var announces = sessionStorage.getItem("announces2");
		if(announces != null && announces != ""){
			announces = sessionStorage.getItem("announces2").split("~");
			for (var i = 0; i < announces.length; i++) {
				announces[i] = JSON.parse(announces[i]);
			}
		}else{
			var announces = new Array(5);
		}
		
		return announces;
	}

	return announceService;
}]);

customService.service("activityService", ['$filter', function($filter){
	var activityService = {};

	activityService.set = function(acts){
		if(angular.isArray(acts)){
			var activities = "";
			for (var i = 0; i < acts.length; i++) {
				acts[i].acCreDate = $filter("date")(acts[i].acCreDate, "yyyy-MM-dd HH:mm");
				acts[i].acDueDate = $filter("date")(acts[i].acDueDate, "yyyy-MM-dd HH:mm");
				acts[i].acSigDueDate = $filter("date")(acts[i].acSigDueDate, "yyyy-MM-dd HH:mm");
				if(acts[i].sigDate){
					acts[i].sigDate = $filter("date")(acts[i].sigDate, "yyyy-MM-dd HH:mm");
				}
				activities += JSON.stringify(acts[i]);
				if(i != acts.length-1){
					activities += "~";
				}
			}

			sessionStorage.setItem("activities", activities);
		}
	}

	activityService.get = function(){
		var activities = sessionStorage.getItem("activities");
		if(activities != null && activities != ""){
			activities = sessionStorage.getItem("activities").split("~");
			for (var i = 0; i < activities.length; i++) {
				activities[i] = JSON.parse(activities[i]);
			}
		}else{
			activities = [];
		}
		return activities;
	}

	activityService.addActivity = function(academyArr){
		var formData = new FormData($("#activityForm")[0]); 
		var myDate = new Date();
		var currentTime = myDate.getTime();
		currentTime = $filter("date")(currentTime, "yyyy-MM-dd HH:mm");
		formData.append("tasCreDate", currentTime);
		formData.append("academys", academyArr);
     	$.ajax({ 
         	async: false,
         	url : 'http://www.ly723.site:2048/StudentManager2/teacher/insertActivity.action',  
         	type : 'POST',  
         	data : formData,  
         	processData : false,     
         	contentType : false,   
         	success : function(data) { 
               	if(angular.isArray(data)){
               		alert("添加成功！");
					activityService.set(data);
					window.location.reload();
				}else{
					alert("fail");
				}
         	},  
         	error : function(result) {  
             	alert(result);
         	}  
     	});
	}


	return activityService;
}]);

customService.service("taskService", ['$filter', function($filter){
	var taskService = {};

	taskService.set = function(taskArray){
		if(angular.isArray(taskArray)){
			var tasks = "";
			for (var i = 0; i < taskArray.length; i++) {
				taskArray[i].tasCreDate = $filter("date")(taskArray[i].tasCreDate, "yyyy-MM-dd HH:mm");
				taskArray[i].tasDueDate = $filter("date")(taskArray[i].tasDueDate, "yyyy-MM-dd HH:mm");
				tasks += JSON.stringify(taskArray[i]);
				if(i != taskArray.length-1){
					tasks += "~";
				}
			}
			sessionStorage.setItem("tasks", tasks);
		}
	};

	taskService.get = function(){
		var tasks = sessionStorage.getItem("tasks");
		if(tasks != null && tasks != ''){
			tasks = sessionStorage.getItem("tasks").split("~");
			for (var i = 0; i < tasks.length; i++) {
				tasks[i] = JSON.parse(tasks[i]);
			}
		}else{
			tasks = [];
		}
		return tasks;
	}

	// taskService.setMyTask = function(myTask){
	// 	if(angular.isArray(myTask)){
	// 		var tasks = "";
	// 		for (var i = 0; i < myTask.length; i++) {
	// 			myTask[i].tasCreDate = $filter("date")(myTask[i].tasCreDate, "yyyy-MM-dd HH:mm");
	// 			myTask[i].tasDueDate = $filter("date")(myTask[i].tasCreDate, "yyyy-MM-dd HH:mm");
	// 			tasks += JSON.stringify(myTask[i]);
	// 			if(i != myTask.length-1){
	// 				tasks += "~";
	// 			}
	// 		}
	// 		sessionStorage.setItem("myTask", tasks);
	// 	}
	// }

	// taskService.getMyTask = function(){
	// 	if(sessionStorage.getItem("myTask") == null)
	// 		return null;
	// 	var myTask = sessionStorage.getItem("myTask").split("~");
	// 	for (var i = 0; i < myTask.length; i++) {
	// 		myTask[i] = JSON.parse(myTask[i]);	
	// 	}
	// 	return myTask;
	//}

	taskService.alterTime = function(task){
		for (var i = 0; i < task.length; i++) {
			task[i].tasCreDate = $filter("date")(task[i].tasCreDate, "yyyy-MM-dd HH:mm");
			task[i].tasDueDate = $filter("date")(task[i].tasDueDate, "yyyy-MM-dd HH:mm");
		}
		return task;
	}

	return taskService;

}]);

customService.service("informService", ['$filter', function($filter){
	var informService = {};

	informService.set = function(informArray){
		if(angular.isArray(informArray)){
			var informs = "";
			for (var i = 0; i < informArray.length; i++) {
				informArray[i].notSenDate = $filter("date")(informArray[i].notSenDate, "yyyy-MM-dd HH:mm");
				informs += JSON.stringify(informArray[i]);
				if(i != informArray.length-1){
					informs += "~";
				}
			}
			sessionStorage.setItem("informs", informs);
		}
	};

	informService.get = function(){
		var informs = sessionStorage.getItem("informs");
		if(informs != null && informs != ''){
			informs = sessionStorage.getItem("informs").split("~");
			for (var i = 0; i < informs.length; i++) {
				informs[i] = JSON.parse(informs[i]);
			}
		}else{
			informs = [];
		}
		return informs;
	}

	return informService;

}]);

customService.service("identificationService", [function(){
	var identification = function(user){
		if(user.userId == "" || user.userName == "" || user.password == ""){
			window.location.href = "/StudentManager2";
		}
	}

	return identification;
}])

