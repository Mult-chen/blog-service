# 使用官方Java运行时环境作为父镜像
FROM eclipse-temurin:21-jre-jammy


# 将jar包添加到容器中并更名为app.jar
COPY target/blog-1.0.0-*.jar /usr/app/blog-service.jar

# 为jar包文件设置执行权限
RUN sh -c 'touch /usr/app/trade-service.jar'

# 指定容器启动时执行的命令
ENTRYPOINT ["java","-jar","/usr/app/blog-service.jar"]