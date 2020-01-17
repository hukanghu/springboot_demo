$(function(){
	$("#switch1").bootstrapSwitch({
        onText: "开启",
        offText: "关闭",
		offColor:"danger",
		onColor:"success",
        onSwitchChange: function (event, state) {
            //监听switch change事件，可以根据状态把相应的业务逻辑代码写在这里
            if (state == true) {
                starttask1();
            } else {
                stoptask1();
            }
        }
    });
	$("#switch2").bootstrapSwitch({
	    onText: "开启",
	    offText: "关闭",
		offColor:"danger",
		onColor:"success",
	    onSwitchChange: function (event, state) {
	        //监听switch change事件，可以根据状态把相应的业务逻辑代码写在这里
	        if (state == true) {
	        	starttask2();
	        } else {
	        	stoptask2();
	        }
	    }
	});
});

function starttask1(){
	$.ajax({
		type: "post",
		url: "/task/startCron1",
		data: {},
		dataType:"json",
		success : function(data) {
			alert(data);
		}
	});
	
}

function stoptask1(){
	$.ajax({
		type: "post",
		url: "/task/stopCron1",
		data: {},
		dataType:"json",
		success : function(data) {
			alert(data);
		}
	});
	
	
}

function starttask2(){
	$.ajax({
		type: "post",
		url: "/task/startCron2",
		data: {},
		dataType:"json",
		success : function(data) {
			alert(data);
		}
	});
	
}

function stoptask2(){
	$.ajax({
		type: "post",
		url: "/task/stopCron2",
		data: {},
		dataType:"json",
		success : function(data) {
			alert(data);
		}
	});
	
	
}
