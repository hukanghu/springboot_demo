	
	$("#report").bootstrapTable({
		url:'/TimeValue/gettimeday',
		method:'POST',
		dataType:"json",
		contentType : "application/x-www-form-urlencoded",
		sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
		toolbar : '#toolbar', //工具按钮用哪个容器
		search : false, //是否显示表格搜索
		showFooter : false, //显示底部，默认不显示
		sortName : 'dayvalue',
		sortOrder : "asc", //排序方式	
		striped : true, //是否显示行间隔色
		cache : false, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		pagination : true, //是否显示分页（*）
		showPaginationSwitch : true, //显示切换分页
		showFullscreen : false, //显示全屏
		showExport : true, //显示导出
		showHeader : true, //显示头部，默认显示
		showColumns : true, //是否显示所有的列（选择显示的列）
		showRefresh : true, //是否显示刷新按钮
		sortable : true, //是否启用排序
		pageNumber : 1, //初始化加载第一页，默认第一页,并记录
		pageSize : 3, //每页的记录行数（*）
		pageList : [ 3, 6, 9 ], //可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, //最少允许的列数
		clickToSelect : true, //是否启用点击选中行
		uniqueId : "pid", //每一行的唯一标识，一般为主键列
		showToggle : true, //是否显示详细视图和列表视图的切换按钮
		cardView : false, //是否显示详细视图
		queryParams:queryParam,
		detailView:true,//父子表,为true会在父数据前面添加“+”
		columns:[
			{field:'pid',title:'pid'},
			{field:'yearvalue',title:'年'},
			{field:'monthvalue',title:'月'},
			{field:'dayvalue',title:'日',sortable: true}
		],
		//注册加载子表的事件。注意下这里的三个参数！ row会传递数据到子表
        onExpandRow: function (index, row, $detail) {
            InitSubTable(index, row, $detail);
        },
        exportOptions : {
            ignoreColumn: [0]
        }
		
	});
	
	function queryParam(params){
    	var param = {
    			limit : this.limit, // 页面大小
    	        offset : this.offset, // 页码
    	        pageNumber : this.pageNumber,
    	        pageSize : this.pageSize
    	};
    	return param;
    }
	
	
	
	//初始化子表格(无线循环)
    InitSubTable = function (index, row, $detail) {
        var parentid = row.business_id;
        var yearvalue = row.yearvalue;
        var monthvalue = row.monthvalue;
        var dayvalue = row.dayvalue;
        var cur_table = $detail.html('<table></table>').find('table');
        $(cur_table).bootstrapTable({
            url: '/TimeValue/getbysomevalue',
            method: 'get',
            dataType:"json",
            contentType : "application/x-www-form-urlencoded; charset=UTF-8",
            sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
            search : true, //是否显示表格搜索
            pagination : true, //是否显示分页（*）
            showPaginationSwitch : true, //显示切换分页
            queryParams:function(params) {
            	var param = {
            			limit : this.limit, // 页面大小
            	        offset : this.offset, // 页码
            	        pageNumber : this.pageNumber,
            	        pageSize : this.pageSize,
            	        yearvalue:yearvalue,
            	        monthvalue:monthvalue,
            	        dayvalue:dayvalue
            	};
            	return param;
            },
            uniqueId: "pid",
            sortName : 'timeValue',
    		sortOrder : "desc", //排序方式	
    		striped : true, //是否显示行间隔色
            showHeader : true, //显示头部，默认显示
        	showExport : true, //显示导出
        	showColumns : true, //是否显示所有的列（选择显示的列）
        	showRefresh : true, //是否显示刷新按钮
        	sortable : true, //是否启用排序
            pageNumber : 1, //初始化加载第一页，默认第一页,并记录
            pageSize: 10,
            pageList: [10, 25],
            columns: [
            	{field: 'pid',title: 'pid'},
            	{field: 'yearvalue',title: 'yearvalue'},
            	{field: 'monthvalue',title: 'monthvalue'},
            	{field: 'dayvalue',title: 'dayvalue'},
            	{field: 'hourvalue',title: 'hourvalue'},
            	{field: 'mivalue',title: 'mivalue'},
            	{field: 'ssvalue',title: 'ssvalue'},
            	{field: 'weekvalue',title: 'weekvalue'},
            	{field: 'qValue',title: 'qValue'},
            	{field: 'wwValue',title: 'wwValue'},
            	{field: 'dValue',title: 'dValue'},
            	{field: 'dddValue',title: 'dddValue'},
            	{field: 'timeValue',title: 'timeValue',sortable: true,formatter:function (value, row, index) {
                    return changeDateFormat(value)
                }}
            	
            ]
            //无线循环取子表，直到子表里面没有记录
            /*onExpandRow: function (index, row, $Subdetail) {
                InitSubTable(index, row, $Subdetail);
            }*/
            
            
        });
	
      //修改——转换日期格式(时间戳转换为datetime格式)
        function changeDateFormat(cellval) {
            if (cellval != null) {
                var date = new Date(parseInt(cellval));
                var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
                var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
                
                var hh24 = date.getHours();
                var mi = date.getMinutes();
                var ss = date.getSeconds();
                
                return date.getFullYear() + "-" + month + "-" + currentDate+" "+ hh24 +":"+mi+":"+ss;
            }
        }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}