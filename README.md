1、要使用querydsl 需先导入依赖
```
<!--QueryDSL支持-->
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-apt</artifactId>
    <scope>provided</scope>
</dependency>
<!--QueryDSL支持-->
<dependency>
    <groupId>com.querydsl</groupId>
    <artifactId>querydsl-jpa</artifactId>
</dependency>
```
2、需要生成Q开头的类
pom文件加入maven 插件
```
<plugin>
    <groupId>com.mysema.maven</groupId>
    <artifactId>apt-maven-plugin</artifactId>
    <version>1.1.3</version>
    <executions>
        <execution>
            <goals>
                <goal>process</goal>
            </goals>
            <configuration>
                <outputDirectory>target/generated-sources/java</outputDirectory>
                <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
            </configuration>
        </execution>
    </executions>
</plugin>
```

3、使用示例请看com.dsl.service.TestService.java

注： 通过Projections.bean(列1，列2....)的方法可直接返回dto
转载博客：https://juejin.cn/post/6844903955240058887



