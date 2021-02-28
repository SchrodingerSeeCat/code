package com.valid.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {

        // 创建BossGroup和workerGroup
        /*
        * 1. 创建两个线程组 bossGroup和workerGroup
        * 2. bossGroup只是处理连接请求，真正和客户端的业务处理，会交给workerGroup
        * 3. 两个都是无限循环
        * 4. bossGroup和workerGroup默认子线程(NioEventLoop)的个数是CPU核心个数的2倍
        * */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            // 创建服务端的启动对象，配置参数
            ServerBootstrap bootstrap = new ServerBootstrap();

            // 使用链式编程进行设置
            bootstrap.group(bossGroup, workerGroup) // 设置两个线程组
                    .channel(NioServerSocketChannel.class) // 使用NioServerSocketChannel的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128) // 设置线程队列得到的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // 设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() { // 创建一个通道测试对象
                        // 给pipeline设置处理器
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            // 可以使用一个集合管理SocketChannel，在推送消息时，可以将业务加入到各个channel对应的NioEventLoop的taskQueue或scheduleTaskQueue任务队列中
                            channel.pipeline().addLast(new NettyServerHandler());
                        }
                    }); // 给我们的WorkerGroup的EventLoop对应的管道设置处理器

            System.out.println("服务器准备好了");

            // 绑定一个端口并且同步，生成了一个ChannelFuture对象
            // 启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();

            // 给cf注册监听器，监控我们关心的事件
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("监听端口 6688 成功");
                    } else {
                        System.out.println("监听端口 6688 失败");
                    }
                }
            });

            // 对关闭通道进行监听
            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
