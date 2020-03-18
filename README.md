# springboot_demo
springboot 练习
数据库：sql server

1,http://localhost:8080/TimeValue/SelectAll 第一版表格

2,http://localhost:8080/huk/index  表格数据 未实现完成

3,http://localhost:8080/huk/index_test 父子表格 包含

4,http://localhost:8080/huk/task 控制定时任务的开关

5,http://localhost:8080/login 扫码登录，定时监听，使用了redis存储数据

	打开浏览器f12，找到其中一条的一直请求数据，新打开浏览器窗口输入 比如
	http://localhost:8080/login/getResponse/35df4408-a192-4853-a155-26dc1f78499c
	改为
	http://localhost:8080/login/setUser/35df4408-a192-4853-a155-26dc1f78499c/huk 回车就行
	操作演示 图片 (扫码登录演示图.gif)
