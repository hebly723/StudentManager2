//修改时间
$('#start_time').datetimepicker({
		language: 'zh-CN',
		format: "yyyy-MM-dd hh:ii",
		weekStart: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 1,
		forceParse: 0,
		todayBtn:true,
	});
	$('#end_time').datetimepicker({
		language:  'zh-CN',
		format: "yyyy-MM-dd hh:ii",
		weekStart: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 1,
		forceParse: 0,
		todayBtn:true,
	});
// 	$('#start_join').datetimepicker({
// 		language:  'zh-CN',
// 		format: "yyyy-MM-dd hh:ii",
// 		weekStart: 1,
// 		autoclose: 1,
// 		todayHighlight: 1,
// 		startView: 1,
// 		minView: 1,
// 		forceParse: 0,
// 		todayBtn:true,
// 	}).on("click",function(ev){
//     $("#start_join").datetimepicker("setEndDate", $("#end_join").val());
// });
	$('#end_join').datetimepicker({
		language:  'zh-CN',
		format: "yyyy-MM-dd hh:ii",
		weekStart: 1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 1,
		minView: 1,
		forceParse: 0,
		todayBtn:true,
	});

//修改标题、内容
var textarea_cg = function (obj){
	var content1 = $("#content1");
	if(content1.attr("id") == undefined) return false;
	var content = content1.text();
	content1.remove();
	var str = "<textarea cols='100' rows='5' resize='false' id='content2' name='acDesc'>"
					  + content + "</textarea><br />";
	$(obj).before(str);
	return false;
}

var  input_cg = function(obj){
	var title1 = $("#title1");
	if(title1.attr("id") == undefined) return false;
	var title = title1.text();
	title1.remove();
	var str = "<input id='title2' type='text' name='acTitle' value='"+ title +"' />";
	$(obj).before(str);
	return false;
}

//选择发送通知对象
function moveAllOption(e1, e2){ 
	var fromObjOptions=e1.options; 
	for(var i=0;i<fromObjOptions.length;i++){ 
		fromObjOptions[0].selected=true; 
		e2.appendChild(fromObjOptions[i]); 
		i--; 
	} 
}

function moveOption(e1, e2){ 
	var fromObjOptions=e1.options; 
	for(var i=0;i<fromObjOptions.length;i++){ 
		if(fromObjOptions[i].selected){ 
			e2.appendChild(fromObjOptions[i]); 
			i--; 
		} 
	} 
} 
