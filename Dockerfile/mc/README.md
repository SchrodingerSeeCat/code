进入根目录

执行

```cmd
sudo docker build -t minecraft:1.0 .

sudo docker run -itd -p 25565:25565 minecraft:1.0
```

查看容器的ID

```
sudo docker ps
```

查看容器的默认数据卷位置

```
sudo docker inspect 容器ID
```

找到

```
"Source": "/var/lib/docker/volumes/658a2a5abb19c879798f6c72d79ba93255d8e34cf19f9a682cc35a91ef5d42af/_data"
```

查看

```
sudo ls -l /var/lib/docker/volumes/658a2a5abb19c879798f6c72d79ba93255d8e34cf19f9a682cc35a91ef5d42af/_data
```

相信接下来就很熟悉了，修改配置文件之前先停止容器

```
sudo docker stop 容器ID
```

修改`游戏版本`和`jvm`配置在`config`

```
vim config
```

修改之后启动

```
sudo docker start 容器ID
```

