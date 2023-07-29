# 系统需求
其功能包括：

1.添加图书信息：包括图书名、作者、价格、ISBN等。

2.删除图书信息：根据ISBN删除对应的图书信息。

3.修改图书信息：根据ISBN修改对应的图书信息。

4.查询图书信息：根据ISBN查询对应的图书信息。

5.该系统需要有一个图书类（包括图书名、作者、价格、ISBN等属性）和一个操作类（包括添加、删除、修改、查询等方法）。

6.系统需要将增删改查后的的图书馆管理数据添加到对应的Mysql中。

7.系统需要使用泛型来处理各种类型的书籍数据。

8.系统需要利用反射机制来动态添加新的图书类型。

9.系统需要使用注解来标注图书的各种信息。系统需要设计自定义异常来处理各种错误。

# 技术栈
- Java SpringBoot作为后端框架 
- mabatis作为后端与数据库交互
- thymeleaf及LayUI 作为前端模板
- ajax 作为前端数据接收
- MySQL作为数据存储

# 工具
-   编辑器：IntelliJ IDEA 
-   编辑器插件： lombok
-   编辑器包管理工具：maven

# 依赖包
- spring-boot-starter-thymeleaf 
- spring-boot-starter-web
- spring-boot-starter-parent
- mybatis-spring-boot-starter
- spring-boot-devtools
- mysql-connector-java
- spring-boot-starter-test

# 技术点
-  SpringBoot框架：集成MyBatis、日志功能（控制台、文件）、Thymeleaf模板框架、mysql数据库操作、过滤器、拦截器、自定义异常等
- 前端框架：LayUI
- 数据库：MySQL，使用mybatis中的工具编写SQL语句并写入到Mapper.xml中使用
- yml方式的SpringBoot配置文件
- 使用mybatis-generator插件辅助编辑，配合手动编辑生成实体类、dao接口、mapper文件



# 功能 （随时更新）
-   管理员登陆
-   管理所有读者信息（基本信息）
-   管理图书（增删改查）
-   借还书
