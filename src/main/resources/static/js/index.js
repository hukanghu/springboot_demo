$("input[type='button']").click(function(){
	$("bootstrap-table").bootstrapTable("refresh");
});

$("#bootstrap-table").bootstrapTable({
	url:"/TimeValue/pageInfo",
	dataType:"json",
	// 此间是与client不一样的地方=======================开始
	contentType : "application/x-www-form-urlencoded; charset=UTF-8",
	sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
	//修改请求参数，不设置则有默认值 ，返回值必须是一个对象
	method : 'POST', //请求方式（*）
	toolbar : '#toolbar', //工具按钮用哪个容器
	toolbarAlign:'left',
	search : false, //是否显示表格搜索
	showFooter : false, //显示底部，默认不显示
	sortName : 'pid',
	sortOrder : "desc", //排序方式
	// 此间是与client不一样的地方=======================结束
	 
	striped : true, //是否显示行间隔色
	cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	pagination : true, //是否显示分页（*）
	showPaginationSwitch : true, //显示切换分页
	 
	showFullscreen : false, //显示全屏
	showHeader : true, //显示头部，默认显示
	showExport : true, //显示导出
	 
	showColumns : true, //是否显示所有的列（选择显示的列）
	showRefresh : true, //是否显示刷新按钮
	sortable : true, //是否启用排序
	pageNumber : 1, //初始化加载第一页，默认第一页,并记录
	pageSize : 15, //每页的记录行数（*）
	pageList : [ 15, 30, 45,'ALL' ], //可供选择的每页的行数（*） ALL 导出所有数据
	queryParams:queryParam,
	strictSearch : true,
	minimumCountColumns : 2, //最少允许的列数
	clickToSelect : true, //是否启用点击选中行
	uniqueId : "pid", //每一行的唯一标识，一般为主键列
	showToggle : true, //是否显示详细视图和列表视图的切换按钮
	cardView : false, //是否显示详细视图
	detailView : false, //是否显示父子表
	});
	 
	 
	function queryParam(params){
			
		 if(params.offset.toString()==="NaN"){
			var param = {
	    			limit : $('#bootstrap-table').bootstrapTable('getOptions').totalRows, // 页面大小
	    	        offset : 1, // 页码
	    	        pageNumber : 1,
	    	        pageSize : $('#bootstrap-table').bootstrapTable('getOptions').totalRows
	    	};
	    	return param;
			
		}else{  
			var param = {
	    			limit : params.limit, // 页面大小
	    	        offset : params.offset, // 页码
	    	        pageNumber : this.pageNumber,
	    	        pageSize : this.pageSize
	    	};
	    	return param;
			
		 }
		
	    	
	    }
	//转换日期格式(时间戳转换为datetime格式)
	function changeDateFormat(cellval) {
	    var dateVal = cellval + "";
	    if (cellval != null) {
	        var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
	        var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
	        var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
	        var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
	        var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
	        var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
	        return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
	    }

	}
	
var html =$("#model").html();

$("body > div > div.bootstrap-table.bootstrap3 > div.fixed-table-toolbar").prepend(html);
	

function exportall(){
	location.href="/util/excelExport_object";
}
	
	
	