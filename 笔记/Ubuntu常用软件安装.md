# Ubuntu常用软件安装

## docker-ce

```shell
sudo curl -fsSL https://get.docker.com | bash -s docker --mirror Aliyun
```

配置`docker`不用`sudo`

```shell
sudo groupadd docker
sudo gpasswd -a ${USER} docker
sudo systemctl restart docker
sudo chmod a+rw /var/run/docker.sock
```

## Node.js

设置软件仓库，如果需要不同版本则修改`setup_14.x`的数字

```bash
curl -sL https://deb.nodesource.com/setup_14.x | sudo -E bash -
```

安装`node`

```bash
sudo apt-get install -y nodejs
```

设置`npm`淘宝源

```bash
npm config set registry https://registry.npm.taobao.org
```

## pip

```bash
sudo apt install python3-pip
```

更换阿里源

```bash
sudo mkdir ~/.pip
sudo vim ~/.pip/pip.conf
```

粘贴

```bash
[global]
index-url = https://mirrors.aliyun.com/pypi/simple
```

## flash

```bash
sudo apt-get install flashplugin-installer
```

## QT

```bash
sudo apt install aptitude
sudo aptitude install qt5-default qtcreator qml-module-qtquick-controls2
```

## JAVA

- [官网](https://www.oracle.com/java/technologies/javase-downloads.html)下载安装包并解压

  ```bash
  sudo tar -zxvf jdk-11.0.9_linux-x64_bin.tar.gz -C /usr/lib/jvm
  ```

- 修改环境变量

  ```bash
  sudo vim ~/.bashrc
  ```

- 抛出环境变量

  ```bash
  export JAVA_HOME=/usr/lib/jvm/jdk-11.0.9
  export CLASSPATH=.:${JAVA_HOME}/lib
  export PATH=${JAVA_HOME}/bin:$PATH
  ```

- 使其生效

  ```bash
  source ~/.bashrc
  ```

- 注册`jdk`

  ```bash
  sudo update-alternatives --install /usr/bin/java java /usr/lib/jvm/jdk-11.0.9/bin/java 300
  ```

## Tomcat

```bash
sudo apt install tomcat9
```

文件目录

```bash
# 配置文件
/etc/tomcat9/

# 启动文件
/usr/share/tomcat9

# webapps
/var/lib/tomcat9
```

## Maven

```bash
sudo apt install maven
# 安装目录 /usr/share/maven
```

配置镜像源

- 打开`settings.xml`找到`mirrors`输入以下子标签

  ```xml
  <mirror>
  	<id>nexus-aliyun</id>
  	<mirrorOf>*,!jeecg,!jeecg-snapshots</mirrorOf>
  	<name>Nexus aliyun</name>
  	<url>http://maven.aliyun.com/nexus/content/groups/public</url>   
  </mirror>
  ```

建立本地仓库

- 找到`localRepository`

  ```xml
  <localRepository>/home/valid/maven-repo</localRepository>
  ```

  

