var mainApp = angular.module("mainApp");

mainApp.controller("mainCtrl", ['$scope', '$http', '$location', 'userService', 'announceService', function($scope, $http, $location, userService, announceService){
	$scope.user = userService.getUserInfo();
	$scope.newPass = {
		newPassword: "",
		reNewPassword: ""
	}

	let roles = ["student", "teacher", "boss"];
	$scope.$on("$routeChangeSuccess", function(){
		if(roles[$scope.user.role] && $location.path().split("/")[1] !== roles[$scope.user.role]){
			window.location = "";
		}
	});

	$scope.setUser = function(user){
		$scope.user = user;
	}

	$scope.changPass = function(){
		$scope.isSame = false;
		if($scope.newPass.newPassword == $scope.newPass.reNewPassword){
			var data = JSON.stringify(
				{"userPassword": $scope.newPass.newPassword, "userId": $scope.user.userId, 
				"userName": $scope.user.userName, "userMailBox": $scope.user.email,
				"userQq": $scope.user.QQ, "userTel": $scope.user.tel,
				"userRole": $scope.user.role, "userAcademy": $scope.user.academy});
			var url = "http://www.ly723.site:2048/StudentManager2/updateUser.action";
			var config = {
           		headers: {
           			'Content-Type':'application/json; charset=utf-8'
           		}	
       		};
			$http.post(url, data, config)
			.success(function(data){
				$("#change").modal("show");
			})
			.error(function(error){
				alert(error);
			});
		}else{
			$scope.isSame = true;
		}
	}

	$scope.reLogin = function(){
		sessionStorage.removeItem("user");
		sessionStorage.removeItem("activities");
		sessionStorage.removeItem("tasks");
		sessionStorage.removeItem("informs");
		window.location="";
	}

	$scope.changeInfo = function(){
		var url = 'http://www.ly723.site:2048/StudentManager2/updateUserInfo.action';
		var data = 
			JSON.stringify({"userQq": $scope.user.QQ, "userTel": $scope.user.tel, "userMailBox": $scope.user.email, "userId": $scope.user.userId});
		$.ajax({
			async: false,
			type: 'post',
			url: 'http://www.ly723.site:2048/StudentManager2/updateUserInfo.action',
			contentType: 'application/json;charset=utf-8',
			data: data,
			success: function(data){
				$scope.user.QQ = data.userQq;
				$scope.user.tel = data.userTel;
				$scope.user.email = data.userMailBox;
				userService.setUser($scope.user);
				alert("修改成功！");
				if($scope.user.role == '0'){
					window.location = "#/student";
				}else if($scope.user.role == '1'){
					window.location = "#/teacher";
				}else if($scope.user.role == '2'){
					window.location = "#/boss";
				}
			},
			error: function(error){
				console.log(error);
				alert(error);
			}
		});
	}

	$scope.announces = announceService.get();
	//$scope.announces2 = announceService.get2();
	
	$scope.selectAnnounces = function(index){
		var url = 'http://www.ly723.site:2048/StudentManager2/selectAnByAcademy.action';
		var data = "";
		if(index == 1){
			$("[name='announceNav']").hide();
			data = JSON.stringify({"type": "school"});
			$http.post(url, data).success(function(data){
				announceService.set(data);
				$scope.announces = announceService.get();
			});
		}else if(index == 2){
			$("[name='announceNav']").show();
			data = JSON.stringify({"type": $scope.user.academy});
			$http.post(url, data).success(function(data){
				announceService.set(data);
				//announceService.set2(data);
				$scope.announces = announceService.get();
				//$scope.announces2 = announceService.get2();
			});
		}
	}
}]);


/*
	登录控制器
*/
mainApp.controller("loginCtrl", ['$scope', '$http', '$location', 'userService', function($scope, $http, $location, userService){
	$scope.alert1 = false;
	$scope.alert2 = false;
	$scope.alert3 = false;

	$scope.login = function(){
		if($scope.user.userId == ""){
			$scope.alert1 = true;
		}

		if($scope.user.password == ""){
			$scope.alert2 = true;			
		}

		if($scope.user.userId != ""  && $scope.user.password != "" && $scope.user.role != ""){
						var data = JSON.stringify(
							{"userId": $scope.user.userId, "userPassword": $scope.user.password, "userRole": $scope.user.role});
						var url = "http://www.ly723.site:2048/StudentManager2/LoginValidation.action";

						$http.post(url, data)
						.success(function(data){
							if(data.success == "true"){
								var user = {
									userId: data.user.userId,
									userName: data.user.userName,
									password: data.user.userPassword,
									role: data.user.userRole,
									QQ: data.user.userQq,
									tel: data.user.userTel,
									email: data.user.userMailBox,
									academy: data.user.userAcademy
								};
								userService.setUser(user);
								$scope.setUser(user);
								if(data.user.userRole == "0"){
									if($scope.user.QQ==null || $scope.user.tel==null || $scope.user.email==null){
										$location.path("/student/personalInfo");
									}else{
										$location.path("/student");
									}
								}else if(data.user.userRole == "1"){
									if($scope.user.QQ==null || $scope.user.tel==null || $scope.user.email==null){
										$location.path("/teacher/tpersonalInfo");
									}else{
										$location.path("/teacher");
									}
								}else if(data.user.userRole == "2"){
									if($scope.user.QQ==null || $scope.user.tel==null || $scope.user.email==null){
										$location.path("/boss/bpersonalInfo");
									}else{
										$location.path("/boss");
									}	
								}
							}else{
								alert("用户名或密码错误！");
							}
						})
						.error(function(error){
							alert("error:    " + error);
						});
					}
	}
}]);

mainApp.controller("announceCtrl", ['$scope', '$http', '$filter', 'announceService', 'identificationService', function($scope, $http, $filter, announceService, identificationService){
	identificationService($scope.user);
	$scope.tabs = [true, false, false, false, false];
	$scope.chooseTab = function(index){
		for (var i = 0; i < $scope.tabs.length; i++) {
			if(index == i){
				$scope.tabs[i] = true;
			}else{
				$scope.tabs[i] = false;
			}
		}
	}
	
	$scope.changeAnnounce = function(){
		var data = "";
		var myDate = new Date();
		var currentTime = $filter("date")(myDate.getTime(), "yyyy-MM-dd HH:mm");
		for (var i = 0; i < $scope.tabs.length; i++) {
			if($scope.tabs[i]){
				if($scope.user.userId != $scope.announces[i].anCreId){
					alert("不能修改其他人发布的公告！");
					return false;
				}
				data = JSON.stringify(
					{"anCreId": $scope.user.userId, "anTitle": $scope.announces[i].anTitle, 
					"anDesc": $scope.announces[i].anDesc, "anId": $scope.announces[i].anId, 
					"anCreDate": currentTime, "anAcademy": $scope.user.academy});
			}
		}
		var config = {
           	headers: {
           		'Content-Type':'application/json; charset=utf-8'
           	}	
       	};
	    var url = "http://www.ly723.site:2048/StudentManager2/updateAn.action";
		$http.post(url, data, config)
		.success(function(data){
				if(data.success == "true"){
					alert("修改成功！");
				}else{
					alert("修改失败！")
				}
		})
		.error(function(error){
			alert(error);
		});
	}

	$scope.addAnnounce = function(){
		var myDate = new Date();
		var currentTime = $filter("date")(myDate.getTime(), "yyyy-MM-dd HH:mm");
		var data = JSON.stringify({"anTitle": $("#addAnnounce").find("input[name='anTitle']").val(),
						"anDesc": $("#addAnnounce").find("textarea[name='anDesc']").val(),
						"anAcademy": $scope.user.academy, "anCreDate": currentTime,
						"anCreId": $scope.user.userId});
		var config = {
           	headers: {
           		'Content-Type':'application/json; charset=utf-8'
           	}	
       	};
	    var url = "http://www.ly723.site:2048/StudentManager2/updateAn.action";
		$http.post(url, data, config)
		.success(function(data){
				if(data.success == "true"){
					alert("添加成功！");
					if($scope.user.academy == 'school'){
						$scope.selectAnnounces(1);
					}else{
						$scope.selectAnnounces(2);
					}
				}else{
					alert("添加失败！");
				}
		})
		.error(function(error){
			alert(error);
		});
	}
}]);

/*
	三级用户控制器
*/
mainApp.controller("sActivityCtrl", ['$scope', '$filter', '$http', '$location', '$routeParams', 'activityService', 'identificationService', function($scope, $filter, $http, $location, $routeParams, activityService, identificationService){
	identificationService($scope.user);
	$scope.activities = activityService.get();
	var url = 'http://www.ly723.site:2048/StudentManager2/student/ActivityNotOverDue.action';
	$scope.sActivityPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
                url = url.split('?')[0];
                url += '?pageNow='+$scope.sActivityPage.currentPage+'&sigPerId='+$scope.user.userId;
        		$http.get(url).success(function(data){
        			var pageInfo = data[1];
        			console.log(pageInfo);
        			$scope.sActivityPage.totalItems = pageInfo.totalCount;
        			$scope.sActivityPage.itemsPerPage = pageInfo.pageSize;
        			activityService.set(data[0]);
        			$scope.activities = data[0];
        		});
            }
    };

    $scope.chooseActivity = function(type){
    	if(type == "new"){
			url = 'http://www.ly723.site:2048/StudentManager2/student/ActivityNotOverDue.action';
			$scope.sActivityPage.onChange();
    	}else if(type == "over"){
    		url = 'http://www.ly723.site:2048/StudentManager2/student/ActivityOverDue.action';
			$scope.sActivityPage.onChange();
    	}else if(type == "applyed"){
    		url = 'http://www.ly723.site:2048/StudentManager2/student/signed.action';
    		//url = 'http://www.ly723.site:2048/StudentManager2/student/ActivityOverDue.action';
    		$scope.sActivityPage.onChange();
    	}
	}

	$scope.activity = null;
	$scope.$on("$routeChangeSuccess", function(){
		if($location.path().indexOf("/detail/") != -1){
			var id = $routeParams["id"];
			for(var i = 0; i < $scope.activities.length; i++){
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
				if($scope.activities[i].sigAcId == id){
					$scope.activity = $scope.activities[i];
					$scope.activity.acId = $scope.activities[i].sigAcId;
					break;
				}
			}
		}	
	});

	$scope.apply = function(){
		if($("#file").val() == ""){
			alert("请上传报名表！");
			return false;
		}
		var formData = new FormData($("#applyForm")[0]); 
		var myDate = new Date();
		var currentTime = myDate.getTime();
		currentTime = $filter("date")(currentTime, "yyyy-MM-dd HH:mm");
		formData.append("sigDate", currentTime);
     	$.ajax({ 
         	async: false,
         	url : 'http://www.ly723.site:2048/StudentManager2/student/insertSign.action',  
         	type : 'POST',  
         	data : formData,  
         	processData : false,     
         	contentType : false,   
         	success : function(data) {
         		if(data == 1){
         			alert("报名成功！等待审核！");
         		}else if(data == 2){
         			alert("不在可报名范围内");
         		}
         		else{
         			alert("报名失败！");
         		}
         		window.location = "#/student";
         	},  
         	error : function(result) {  
             	alert("error");
         	}  
     	});  
			
	}
}]);

/*
	二级用户控制器
*/
mainApp.controller("tReportCtrl", ['$scope', '$http', 'identificationService', function($scope, $http, identificationService){
	identificationService($scope.user);
	$scope.sendReport = function(){
		var report = $("#report").find("input");
		var reportArray = [];
		reportArray.push($scope.user.userId);
		for (var i = 0; i < report.length; i++) {
			if(report.eq(i).val() == "" || report.eq(i).val() == null)
				return false;
			reportArray.push(report.eq(i).val());
		}
		var select = $("#report").find("select");
		for (var i = 0; i < select.length; i++) {
			reportArray.push(select.eq(i).val());
		}
		var data = JSON.stringify(reportArray);
		var url = 'http://www.ly723.site:2048/StudentManager2/YearEndExcel.action';
		$http.post(url, data).success(function(data){
			if(data.url != "" && data.url != null){
				alert("报表填写成功！");
				window.location = "#/teacher";
			}else{
				alert("报表上传失败！");
			}
		})
		.error(function(error){
			alert(error);
		});
		
	}
}]);

mainApp.controller("tTaskCtrl", ['$scope', '$http', '$location', 'taskService', 'activityService', 'identificationService', function($scope, $http, $location, taskService, activityService, identificationService){
	identificationService($scope.user);
	$scope.tasks = [];
	var url = 'http://www.ly723.site:2048/StudentManager2/teacher/TaskNotOverDue.action';
	$scope.tTaskPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
            	url = url.split("?")[0];
            	url += '?pageNow=' + $scope.tTaskPage.currentPage + '&tasDueId=' + $scope.user.userId;
                $http.get(url).success(function(data){
        			var pageInfo = data.pop();
        			$scope.tTaskPage.totalItems = pageInfo.totalCount;
        			$scope.tTaskPage.itemsPerPage = pageInfo.pageSize;
        			$scope.tasks = taskService.alterTime(data);
        			for(var j=0; j < data.length; j++){
        				for(var i=0; i<data[j].tasDue.length; i++){
        					if(data[j].tasDue[i].id == $scope.user.userId){
        						$scope.tasks[j].status = data[j].tasDue[i].status;
        					}
        				}
        			}
        		});
            }
    };

    $scope.chooseTask = function(type){
    	if(type == "new"){
			url = 'http://www.ly723.site:2048/StudentManager2/teacher/TaskNotOverDue.action';
			$scope.tTaskPage.onChange();
    	}else if(type == "over"){
    		url = 'http://www.ly723.site:2048/StudentManager2/teacher/TaskOverDue.action';
			$scope.tTaskPage.onChange();
    	}
	}

	$scope.start = function(tasId, tasDueId, index){
		var url = "http://www.ly723.site:2048/StudentManager2/teacher/activeTask.action";
		var data = JSON.stringify({"tasId": tasId, "tasDueId": tasDueId});
		$http.post(url, data).success(function(data){
			if(data.success){
				$scope.tasks[index].status = 1;
			}else{
				alert("发生错误！");
			}
		});
	}

	$scope.finishTask = function(index){
			var formData = new FormData($("#finishForm"+index)[0]);
			$.ajax({
				async: false,
         		url : 'http://www.ly723.site:2048/StudentManager2/teacher/finishTask.action',  
         		type : 'POST',  
         		data : formData,  
         		processData : false,     
         		contentType : false,   
         		success : function(data) {  
               	 	if(data == 1){
               	 		$scope.tasks[index].tasStatus = 2;
               	 		alert("上传成功！");
               	 		window.location.reload();
               	 	}else{
               	 		alert("上传失败！");
               	 		window.location.reload();
               	 	}
         		},  
         		error : function(result) {  
             		alert(result);
         		} 
			});

	}
}]);

mainApp.controller("tActivityCtrl", ['$scope', '$http', '$filter', '$location', '$routeParams', 'activityService', 'identificationService', function($scope, $http, $filter, $location, $routeParams, activityService, identificationService){
	identificationService($scope.user);
	$scope.activities = activityService.get();
	
	var url1 = 'http://www.ly723.site:2048/StudentManager2/teacher/ActivityNotOverDue.action';
	$scope.tActivityPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
            	url1 = url1.split('?')[0];
                url1 += '?pageNow='+$scope.tActivityPage.currentPage;
        		$http.get(url1).success(function(data){
        			var pageInfo = data[1];
        			$scope.tActivityPage.totalItems = pageInfo.totalCount;
        			$scope.tActivityPage.itemsPerPage = pageInfo.pageSize;
        			activityService.set(data[0]);
        			$scope.activities = data[0];
        		});
            }
    };

    $scope.chooseActivity = function(type){
    	if(type == "new"){
			url1 = 'http://www.ly723.site:2048/StudentManager2/teacher/ActivityNotOverDue.action';
			$scope.tActivityPage.onChange();
    	}else if(type == "over"){
    		url1 = 'http://www.ly723.site:2048/StudentManager2/teacher/ActivityOverDue.action';
			$scope.tActivityPage.onChange();
    	}
	}

	$scope.activity = null;
	$scope.$on("$routeChangeSuccess", function(){
		if($location.path().indexOf("/dealAct/") != -1){
			var id = $routeParams["id"];
			for(var i = 0; i < $scope.activities.length; i++){
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
			}
		}

		if($location.path().indexOf("/applyDetail/") != -1){
			var id = $routeParams["id"];
			for(var i = 0; i < $scope.activities.length; i++){
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
			}
		}
	});

	$scope.applyDetail = [];
    var url2 = 'http://www.ly723.site:2048/StudentManager2/teacher/SignUnhandled.action';
	$scope.applyDetailPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
            	url2 = url2.split("?")[0];
                url2 += '?pageNow=' + $scope.applyDetailPage.currentPage + '&acId=' + $scope.activity.acId + '&userId=' + $scope.user.userId;
        		$http.get(url2).success(function(data){
        			var pageInfo = data.pop();
        			$scope.applyDetailPage.totalItems = pageInfo.totalCount;
        			$scope.applyDetailPage.itemsPerPage = pageInfo.pageSize;
        			$scope.applyDetail = data;
        		});
            }
    };

    $scope.chooseApply = function(type){
		if(type == "new"){
			console.log(type);
			url2 = 'http://www.ly723.site:2048/StudentManager2/teacher/SignUnhandled.action';
			$scope.applyDetailPage.onChange();
		}else if(type == "handled"){
			url2 = 'http://www.ly723.site:2048/StudentManager2/teacher/Signhandled.action';
			$scope.applyDetailPage.onChange();
		}
	}


    $scope.checkApply = function(acId, sigId, check){
    	var myDate = new Date();
		var currentTime = $filter("date")(myDate.getTime(), "yyyy-MM-dd HH:mm");
    	var data = '{"sigAcId": "' + acId + '", "sigId": "' + sigId + '", "sigStatus": "' + check + '", "sigHanDate": "' + currentTime + '"}';
		$.ajax({
			type: 'post',
			url: 'http://www.ly723.site:2048/StudentManager2/teacher/updateSignStatus.action',
			data: data,
			contentType: "application/json;charset=utf-8",
			async: true,
			success: function(data){
				if(data == 1){
					alert("审核成功！");
					$scope.chooseApply('new');
				}
			}
		});
		return false;
    }
}]);

mainApp.controller("tInformCtrl", ['$scope', '$http', 'informService', 'identificationService', function($scope, $http, informService, identificationService){
	identificationService($scope.user);
	$scope.informs = informService.get();
	var url = 'http://www.ly723.site:2048/StudentManager2/MessagesUnread.action?notRecId=';
	$scope.tInformPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
            	url = url.split('=')[0];
                url += '=' + $scope.user.userId + '&pageNow=' + $scope.tInformPage.currentPage;
        		$http.get(url).success(function(data){
        			var pageInfo = data.pop();
        			$scope.tInformPage.totalItems = pageInfo.totalCount;
        			$scope.tInformPage.itemsPerPage = pageInfo.pageSize;
        			informService.set(data);
        			$scope.informs = data;
        		});
            }
    };

    $scope.chooseInform = function(type){
    	if(type == "new"){
			url = 'http://www.ly723.site:2048/StudentManager2/MessagesUnread.action?notRecId=';
			$scope.tInformPage.onChange();
    	}else if(type == "readed"){
    		url = 'http://www.ly723.site:2048/StudentManager2/MessagesAlread.action?notRecId=';
			$scope.tInformPage.onChange();
    	}else if(type == "sended"){
    		url = 'http://www.ly723.site:2048/StudentManager2/MessagesAll.action?notSenId=';
			$scope.tInformPage.onChange();
    	}
	}

	$scope.read = function(notId, index){
		$.ajax({
			url: 'http://www.ly723.site:2048/StudentManager2/updateMessageStatus.action',
			type: 'post',
			data: JSON.stringify({notId: notId, notStatus: '1'}),
			contentType: "application/json;charset=utf-8",
			success: function(data){
				if(data == 1){
					$scope.chooseInform("new");
					alert("已读");
				}else{
					alert("ERROR");
				}
			}
		});
	}
}]);

mainApp.controller("tMessageCtrl", ['$scope', '$http', '$filter', 'identificationService', function($scope, $http, $filter, identificationService)
{
	identificationService($scope.user);
	$scope.selectBoss = function(){
		$.ajax({
			type: 'get',
			url: 'http://www.ly723.site:2048/StudentManager2/teacher/queryBoss.action',
			success: function(data){
				$scope.bosses = data;
			}
		});
	}

	$scope.sendMessage = function(){
		var receiver = $("#message").find("select[name='list2']").val();
		var _list = [];
		for (var i = 0; i < receiver.length; i++) {
			var myDate = new Date();
			var currentTime = $filter("date")(myDate.getTime(), "yyyy-MM-dd HH:mm");
			var data = {
				notSenId: $scope.user.userId,
				notRecId: receiver[i],
				notDet: $("#message").find("textarea").val(),
				notSenDate: currentTime
			};
			_list.push(data);			
		}
		$.ajax({
			type: 'post',
			url: 'http://www.ly723.site:2048/StudentManager2/insertMessages.action',
			data: JSON.stringify({ selectedIDs: _list }),  
			contentType: "application/json;charset=utf-8",
			success: function(data){
				if(data == 1){
					alert("发送成功！");
				}else{
					alert("发送失败！");
				}
				window.location = "#/teacher/tpersonalInfo";
			}
		});
	}

}]);

/*
	一级用户控制器
*/
mainApp.controller("bReportCtrl", ['$scope', '$http', 'identificationService', function($scope, $http, identificationService){
	identificationService($scope.user);
	$scope.getReport = function(){
		var url = 'http://www.ly723.site:2048/StudentManager2/ListYearExcel.action';
		$http.get(url).success(function(data){
			if(angular.isArray(data)){
				$scope.reports = data;
			}
		});
	}
}]);
mainApp.controller("bActivityCtrl", ['$scope', '$http', '$location', '$routeParams', 'activityService', 'identificationService', function($scope, $http, $location, $routeParams, activityService, identificationService){
	identificationService($scope.user);
	$scope.activities = activityService.get();
	var url = 'http://www.ly723.site:2048/StudentManager2/boss/ActivityNotOverDue.action';
	$scope.bActivityPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
                url = url.split("?")[0];
                url += '?pageNow=' + $scope.bActivityPage.currentPage;
                $http.get(url).success(function(data){
        			var pageInfo = data[1];
        			$scope.bActivityPage.totalItems = pageInfo.totalCount;
        			$scope.bActivityPage.itemsPerPage = pageInfo.pageSize;
        			activityService.set(data[0]);
        			$scope.activities = data[0];
        			console.log($scope.activities);
        		});
            }
    };

    $scope.chooseActivity = function(type){
    	if(type == 'new'){
    		url = 'http://www.ly723.site:2048/StudentManager2/boss/ActivityNotOverDue.action';
    		$scope.bActivityPage.onChange();
    	}else if(type == 'over'){
    		url = 'http://www.ly723.site:2048/StudentManager2/boss/ActivityOverDue.action';
    		$scope.bActivityPage.onChange();
    	}
    }


    $scope.$on("$routeChangeSuccess", function(){
		if($location.path().indexOf("/alterAct/") != -1){
			var id = $routeParams["id"];
			for (var i = 0; i < $scope.activities.length; i++) {
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
			};
		}

		if($location.path().indexOf("/applyTable/") != -1){
			var id = $routeParams["id"];
			for (var i = 0; i < $scope.activities.length; i++) {
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
			};
		}

		if($location.path().indexOf("/assignTask/") != -1){
			var id = $routeParams["id"];
			for (var i = 0; i < $scope.activities.length; i++) {
				if($scope.activities[i].acId == id){
					$scope.activity = $scope.activities[i];
					break;
				}
			};
			$.ajax({
				url: 'http://www.ly723.site:2048/StudentManager2/teacher/dueAcademy.action',
				data: '{"acId": "' + id + '"}',
				type: 'post',
				contentType: 'application/json;charset=utf-8',
				async:false,
				success: function(data){
					$scope.tasDue = data;
				}
			});
			for(var key in $scope.tasDue){
				var tasDueSelect = $("#tasDueSelect").append("<optgroup label='" + key + "'></optgroup>");
				for(var i in $scope.tasDue[key]){
					tasDueSelect.children().last().append(
						"<option value='" + $scope.tasDue[key][i].userId + "'>" + $scope.tasDue[key][i].userGrade + $scope.tasDue[key][i].userName + "</option>"
					);
				}
			}
			$(function(){
    			$("#tasDueSelect").multiselect({
        			noneSelectedText: "==请选择==",
        			checkAllText: "全选",
        			uncheckAllText: '全不选',
        			selectedList:4
    			});

			});
		}
	});

	$scope.applyDetail = [];
    var url2 = 'http://www.ly723.site:2048/StudentManager2/boss/Signhandled.action';
	$scope.applyDetailPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
            	url2 = url2.split("?")[0];
                url2 += '?pageNow=' + $scope.applyDetailPage.currentPage + '&acId=' + $scope.activity.acId;
        		$http.get(url2).success(function(data){
        			var pageInfo = data.pop();
        			$scope.applyDetailPage.totalItems = pageInfo.totalCount;
        			$scope.applyDetailPage.itemsPerPage = pageInfo.pageSize;
        			$scope.applyDetail = data;
        		});
            }
    };

    $scope.addActivity = function(){
    	var acAcademyArr = $("#acAcademy").val();
		activityService.addActivity(acAcademyArr);
	}

	$scope.deleteAct = function(acId){
		var data = '{"acId": "' + acId + '", ' 
					+ '"acCreId": "' + $scope.user.userId + '"}';
		$.ajax({
			type: 'post',
			url: 'http://www.ly723.site:2048/StudentManager2/teacher/deleteActivity.action?pageNow='+$scope.bActivityPage.currentPage,
			contentType: "application/json;charset=utf-8",
			data: data,
			success: function(data){
				if(data.success){
					alert("删除成功！");
					window.location.reload();
				}else{
					alert("删除失败！");
				}
			}
		});

		return false;
	}

	$scope.changeAct = function(){
		var formData = new FormData($("#alterActForm")[0]); 
     	$.ajax({ 
         	async: false,
         	url : 'http://www.ly723.site:2048/StudentManager2/teacher/updateActivity.action?pageNow='+$scope.bActivityPage.currentPage,  
         	type : 'POST',  
         	data : formData,  
         	processData : false,     
         	contentType : false,   
         	success : function(data) {  
               	 if(angular.isArray(data)){
               	 	alert("修改成功！");
               	 	activityService.set(data);
               	 	window.location = "#/boss";
               	 }
         	},  
         	error : function(result) {  
             	alert("error");
         	}  
     	});  
		
	}

}]);

mainApp.controller("bTaskCtrl", ['$scope', '$http', '$filter', '$location', '$routeParams', 'taskService', 'identificationService', function($scope, $http, $filter, $location, $routeParams, taskService, identificationService){
	identificationService($scope.user);
	$scope.myTask = taskService.get();

	var url = 'http://www.ly723.site:2048/StudentManager2/boss/TaskNotOverDue.action';
	$scope.bTaskPage = {
            currentPage: 1,
            totalItems: 100,
            itemsPerPage: 15,
            pagesLength: 15,
            perPageOptions: [5, 10, 15],
            onChange: function(){
                url = url.split("?")[0];
                url += '?pageNow=' + $scope.bTaskPage.currentPage + '&tasCreId=' + $scope.user.userId;
                $http.get(url).success(function(data){
        			var pageInfo = data.pop();
        			$scope.bTaskPage.totalItems = pageInfo.totalCount;
        			$scope.bTaskPage.itemsPerPage = pageInfo.pageSize;
        			taskService.set(data);
        			$scope.myTask = taskService.alterTime(data);
        		});
            }
    };
    $scope.chooseTask = function(type){
    	if(type == "new"){
			url = 'http://www.ly723.site:2048/StudentManager2/boss/TaskNotOverDue.action';
			$scope.bTaskPage.onChange();
    	}else if(type == "over"){
    		url = 'http://www.ly723.site:2048/StudentManager2/boss/TaskOverDue.action';
			$scope.bTaskPage.onChange();
    	}
	}

	$scope.$on("$routeChangeSuccess", function(){
		if($location.path().indexOf("/createTask") != -1){
			$scope.selectAllTeacher();
		}

		if($location.path().indexOf("/altTask") != -1){
			var id = $routeParams["id"];
			for (var i = 0; i < $scope.myTask.length; i++) {
				if($scope.myTask[i].tasId == id){
					$scope.task = $scope.myTask[i];
					break;
				}
			};
		}
	});
	$scope.choose = true;
	$scope.teachers = [];
	$scope.selectAllTeacher = function(){
		var url = "http://www.ly723.site:2048/StudentManager2/boss/queryTeachers.action"
		$http.get(url).success(function(data){
			if(angular.isArray(data)){
				$scope.teachers = data;
			}
		});
	}

	

	$scope.createTask = function(){
		var formData = new FormData($("#taskForm")[0]); 
		formData.append("tasCreId", $scope.user.userId);
		formData.append("tasCreName", $scope.user.userName);
		var myDate = new Date();
		var currentTime = myDate.getTime();
		currentTime = $filter("date")(currentTime, "yyyy-MM-dd HH:mm");
		formData.append("tasCreDate", currentTime);
		formData.append("users", $("#tasDueSelect").val());
		var url = 'http://www.ly723.site:2048/StudentManager2/boss/insertTaskByList.action';
     	$.ajax({ 
         	async: false,
         	url : url,  
         	type : 'POST',  
         	data : formData,  
         	processData : false,     
         	contentType : false,   
         	success : function(data) {  
         		console.log(data);
               	 if(data.condition == 0){
               	 	alert('指派成功！');
               	 window.location = "#/boss/myTask";
               	 }else if(data.condition == 1){
               	 	alert("指派失败！");
               	 }else if(data.condition == 2){
               	 	alert("插入失败！" + data.taskDue[0].name + "被重复指派，不能再次指派！");
               	 }
         	},  
         	error : function(result) {  
             	alert("error");
         	}  
     	});  
	}

	$scope.delTask = function(tasId, tasStatus){
		var url = '';
		if(tasStatus == 3 || tasStatus == 2){
			url = 'http://www.ly723.site:2048/StudentManager2/boss/deleteTaskOverDue.action';
		}else{
			url = 'http://www.ly723.site:2048/StudentManager2/boss/deleteTask.action';
		}
		var config = {
           	headers: {
           		'Content-Type':'application/json; charset=utf-8'
           	}	
       	};
     	var data = JSON.stringify({"tasCreId": $scope.user.userId, "tasId": tasId, "pageNow": $scope.bTaskPage.currentPage});
		$http.post(url, data, config).success(function(data){
			if(angular.isArray(data)){
				alert("删除成功！");
				data.pop();
				$scope.myTask = taskService.alterTime(data);
			}
		}).error(function(){
			alert("删除失败！");
		});
	}

	$scope.altTask = function(){
		var url = 'http://www.ly723.site:2048/StudentManager2/boss/updateTask.action';
		var formData = new FormData($("#changeActForm")[0]);
		formData.append("pageNow", $scope.bTaskPage.currentPage);
		$.ajax({ 
         	async: false,
         	url : url,  
         	type : 'POST',  
         	data : formData,  
         	processData : false,     
         	contentType : false,   
         	success : function(data) {  
               	 if(angular.isArray(data)){
               	 	alert('修改成功！');
               	 window.location = "#/boss/myTask";
               	 }
         	},  
         	error : function(result) {  
             	alert("error");
         	}  
     	}); 

	}

}]);
mainApp.controller("bMessageCtrl", ['$scope', '$http', '$filter', 'identificationService', function($scope, $http, $filter, identificationService){
	identificationService($scope.user);
	$scope.selectTeacher = function(){
		$.ajax({
			type: 'get',
			url: 'http://www.ly723.site:2048/StudentManager2/boss/queryTeachers.action',
			success: function(data){
				$scope.teachers = data;
			}
		});
	}

	$scope.sendMessage = function(){
		var receiver = $("#message").find("select[name='list2']").val();
		var _list = [];
		for (var i = 0; i < receiver.length; i++) {
			var myDate = new Date();
			var currentTime = $filter("date")(myDate.getTime(), "yyyy-MM-dd HH:mm");
			var data = {
				notSenId: $scope.user.userId,
				notRecId: receiver[i],
				notDet: $("#message").find("textarea").val(),
				notSenDate: currentTime
			};
			_list.push(data);			
		}
		$.ajax({
			type: 'post',
			url: 'http://www.ly723.site:2048/StudentManager2/insertMessages.action',
			data: JSON.stringify({ selectedIDs: _list }),  
			contentType: "application/json;charset=utf-8",
			success: function(data){
				if(data == 1){
					alert("发送成功！");
				}else{
					alert("发送失败！");
				}
				window.location = "#/boss/bpersonalInfo";
			}
		});
	}

}])
