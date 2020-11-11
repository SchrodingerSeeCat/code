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

```
sudo mkdir ~/.pip
sudo vim ~/.pip/pip.conf
```

粘贴

```
[global]
index-url = https://mirrors.aliyun.com/pypi/simple
```

