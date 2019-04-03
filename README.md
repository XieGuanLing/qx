#注意事项


##添加i18n文件
1. AppConfig里面配置

##执行sql变更
1. sql文件：db.migration
2. java版： com.ws.db.migration



##打开对应文件夹的debug模式
1. logback-spring.xml里面设置
2. 查看jpa生成的sql
   + application.yml里面设置show-sql: true
   + logback-spring.xml添加设置
```        
       <logger name="org.hibernate.type" level="trace"/>
       <logger name="org.hibernate.SQL" level="trace"/>
```