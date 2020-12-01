# Docker基本命令

### 概念

**镜像**：镜像是一种轻量级、可执行的独立软件包，用来打包软件运行环境和基于运行环境开发的软件，它包含运行某个软件所需的所有内容，包括代码、运行时、库、环境变量和配置文件

### 镜像命令

1. 列出本地的所有镜像

   ```
   docker images
   ```

   参数 

   ```
   -a 列出所有镜像包括中间仓库
   -q 只显示镜像的ID
   --digests 显示镜像的摘要信息
   --no-trunc 显示镜像的完整ID
   ```

   表头信息

   ```
   REPOSITORY: 表示镜像的仓库源
   TAG: 镜像的标签
   IMAGE ID: 镜像ID
   CREATED: 镜像创建的时间
   SIZE: 镜像的大小
   DIGEST: 镜像摘要
   ```

2. `docker search 镜像名称` 在dockerhub上搜索镜像

   ```
   docker search mysql
   ```

   参数

   ```
   docker search -s 30 mysql
   列出star不小于30的mysql镜像
   
   docker search --no-trunc mysql
   显示完整描述
   
   --automated 
   只列出automated build类型的镜像
   ```

3. `docker pull 镜像:tag` 拉取指定tag的镜像 tag可省略默认`latest` 最新版

   ```
   docker pull mysql
   ```

4. `docker rmi 镜像:tag` 删除指定镜像 默认删除最新版

   ```
   docker rmi hello-world
   ```

   参数 

   ```
   -f
   docker rmi -f hello-world
   强制删除
   ```

   组合命令清空所有镜像

   ```
   docker rmi -f $(docker images -qa)
   ```

### 容器命令

1. `docker run 参数 镜像` 以某镜像启动一个容器

   ```
   docker run -it cedef0cc26e8
   ```

   参数

   ```
   -i 以交互模式运行容器，通常与-t同时使用
   -t 为容器重新分配一个伪输入终端
   -P 随机端口映射
   -p 指定端口映射 -p 主机端口:容器端口
   -d 后台运行容器，并返回容器ID，即启动守护式容器
   ```

2. 运行指定容器到指定端口

   ```
   docker run -it -p 8888:8080 容器ID
   ```

3. `docker ps`

   ```
   查找当前docker中正在运行的容器
   ```

   参数

   ```
   上一次运行的容器
   docker ps -l 
   
   以上三次运行的容器
   docker ps -n 3
   
   只显示容器的编号
   docker ps -lp
   ```

4. `exit` 

   ```
   退出并停止此容器
   ```

5. 退出不停止容器

   ```
   CTRL+P+Q
   ```

6. 启动已经关闭过的容器

   ```
   docker start ID或容器名
   ```

7. 重启容器

   ```
   docker restart ID或容器名
   ```

8. 停止容器

   ```
   docker stop 容器ID或容器名
   ```

9. 强制停止容器

   ```
   docker kill 容器ID或容器名
   ```

10. 删除已停止的容器

    ```
    docker rm 容器ID或容器名
    ```

11. **注意**

    ```
    docker run -d 容器ID
    docker容器后台运行
    但是docker容器后台运行就必须有一个前台进程
    容器运行的容器如果不是那些一直挂起的容器(比如运行top,tail)就会自动退出
    ```

12. 日志

    ```
    docker logs -t 容器ID
    
    -t 时间戳
    -f 实时查看日志
    --tail 3 查看末尾三条日志
    ```

13. 查看容器内的进程

    ```
    docker top 容器ID
    ```

14. 查看当前容器的结构

    ```
    docker inspect 容器ID
    ```

15. 进入当前正在运行的容器

    ```
    docker attach 容器ID
    ```

16. 在某个容器内执行某条命令

    ```
    docker exec -t 容器ID ls -l /tmp(并没有进入容器)
    
    docker exec -i 容器ID /bin/bash 进入容器
    ```

17. 文件拷贝

    ```
    docker cp 容器ID:文件路径 拷贝到主机的路径
    ```

18. 提交当前容器作为一个新的镜像

    ```
    docker commit -a="作者" -m="描述" 容器ID 命名空间/镜像名字:tag
    ```

### 容器数据卷

卷就是目录或文件，存在于一个或多个容器中，由docker挂载到容器，但不属于联合文件系统，一次能够绕过Union File System提供一些用于持续存储或共享数据的特性

卷的设计目的就是数据的持久化，完全独立于容器的生存周期，因此Docker不会在容器删除时删除其挂载的数据卷

特点：

1：数据卷可在容器之间共享或宠用数据

2：卷中的更改可以直接生效

3：数据卷中的更改不会包含在镜像的更新中

4：数据卷的声明周期一直持续到没有容器使用它为止

1. 添加容器数据卷

   ```
   docker run -it -v /宿主机绝对路径:/容器内目录 镜像名
   ```

   容器停止后主机修改的数据在容器重新打开后依旧会生效

2. 添加数据卷的权限

   ```
   docker run -it -v /宿主机绝对路径:/容器绝对路径:文件权限 镜像名
   
   文件权限 是对容器而言，主机不影响
   ro 只读
   ```

### DockerFile

**概念**

DockerFile是用来构建Docker镜像的构建文件，是由一系列的命令和参数构成的脚本

**结构**：以centos8为例

```dockerfile
# scratch 所有镜像的根镜像
FROM scratch
ADD CentOS-8-Container-8.1.1911-20200113.3-layer.x86_64.tar.xz  /

LABEL org.label-schema.schema-version="1.0" \
    org.label-schema.name="CentOS Base Image" \
    org.label-schema.vendor="CentOS" \
    org.label-schema.license="GPLv2" \
    org.label-schema.build-date="20200114" \
    org.opencontainers.image.title="CentOS Base Image" \
    org.opencontainers.image.vendor="CentOS" \
    org.opencontainers.image.licenses="GPL-2.0-only" \
    org.opencontainers.image.created="2020-01-14 00:00:00-08:00"

# 运行镜像时的默认命令
CMD ["/bin/bash"]  
```

**基础**

1. 每个保留字指令必须为大写字母且后面至少要跟一个参数
2. 指令按照从上到下，顺序执行
3. #表示注释
4. 每条指令都会创建一个新的镜像层，并对镜像进行提交

**DockerFile的构建过程**

1. docker从基础镜像运行一个容器
2. 执行一条指令并对容器做出修改
3. 执行类似于docker commit的操作提交一个新的镜像层
4. docker再基于刚提交的镜像运行一个新容器
5. 执行dockerfile中的下一条指令直到所有指令都执行完成DockerFIle

**保留字指令**

1. `FROM` 基础镜像，当前新镜像是基于哪个镜像的
2. `MAINTAINER`镜像维护者的姓名和邮箱地址
3. `RUN`容器构建时需要运行的命令
4. `EXPOSE`当前容器对外暴露出的端口号
5. `WORKDIR`容器完成之后停留的工作目录
6. `ENV`用来在构建镜像过程中设置环境变量
7. `ADD`将宿主机目录下的文件拷贝进镜像且ADD命令会自动处理URL和解压tar压缩包
8. `COPY`类似于ADD只会将源文件拷贝的目标文件 COPY src dest
9. `VOLUME`容器数据卷，用于数据保存和持久化工作
10. `CMD` 指定一个容器启动时要运行的命令 可以有多个CMD命令，但只会有一个生效，CMD 会被之后docker run 之后的参数替换
11. `ENTRYPOINT` 类似于CMD但命令不会替换而是追加
12. `ONBUILD`当构建一个被继承的DockerFile时运行命令，父镜像在被子继承后父镜像的onbuild被触发

**步骤**

1. 进入根目录新建`mydockerfile` 文件夹

2. 书写dockerfile

3. build后生成新的镜像

   ```
   docker build -f /dockerfile目录 -t 命名空间/镜像名称 .
   ```

**dockerfile实例**

```dockerfile
# 指定基础镜像
FROM centos
# 指定作者
MAINTAINER valid<123@163.com>

# 设置环境变量
ENV MYPATH /user/local
# 设置工作目录
WORKDIR $MYPATH

# 安装vim
RUN yum -y install vim
# 安装 net-tools
RUN yum -y install net-tools

# 暴露80端口
EXPOSE 80

CMD echo $MYPATH
CMD echo "succcess --------"
CMD /bin/bash
```



### 容器数据继承共享

```
docker run -it --name 容器1
docker run -it --name 容器2 --volumes-from 容器1 镜像
docker run -it --name 容器3 --volumes-from 容器1 镜像

容器1，2，3之间数据卷共享
数据卷的生命周期一直持续到没有容器使用它为止
```

### Docker常用镜像安装

1. mysql

   ```
   docker run -p 3306:3306 --name mysql -v /valid/mysql/conf:/etc/mysql/conf.d -v /valid/mysql/logs:/logs -v /valid/mysql/data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql
   ```

   进入mysql的容器

   ```cmd
   docker exec -it mysqlID /bin/bash
   ```

   导出msql容器的数据到宿主机

   ```
   docker exec 容器ID sh -c ' exec mysqldump --all-databases -uroot -p"123456" ' > /valid/mysql/all-data.sql
   ```

2. redis

   ```
   docker run -p 6379:6379 -v /valid/redis/data:/data -v /valid/redis/conf/redis.conf:/usr/local/etc/redis/redis.conf -d redis redis-serve /usr/local/etc/redis/redis.conf --appendonly yes
   ```

### 镜像推送

1. 本地提交容器版本

   ```
   docker commit -a 作者 -m "描述" 容器ID 镜像名字
   ```


### 镜像提交至阿里云镜像仓库

1. 登陆

   ```
   sudo docker login --username=小猫的夕阳 registry.cn-hangzhou.aliyuncs.com
   ```

2. 取别名

   ```
   sudo docker tag [ImageId] registry.cn-hangzhou.aliyuncs.com/dingwanli/mc:[镜像版本号]
   ```

3. 提交

   ```
   sudo docker push registry.cn-hangzhou.aliyuncs.com/dingwanli/mc:[镜像版本号]
   ```

4. 拉取镜像

   ```
   sudo docker pull registry.cn-hangzhou.aliyuncs.com/dingwanli/mc:[镜像版本号]
   ```

   