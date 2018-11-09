## 操作步骤

	1. 启动 HelloMain ，注意输出 class 文件的存放目录 classDir需要先配置好；
	2. 启动成功后会打印 
	            监测到新版本，需要重新装载
	            com.suns.MyClassLoader@677327b6
	            重新装载成功
	            version: A ....
	   这样的信息，说明使用的是自定义类装载器；
	3. 然后修改 Worker 中 sayHello 方法的输出结果，重新编译生成 Worker.class，并替换原有的 Worker.class文件；
	4. 可以看到控制台输出的结果变为 version：B，说明热替换生效。