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

