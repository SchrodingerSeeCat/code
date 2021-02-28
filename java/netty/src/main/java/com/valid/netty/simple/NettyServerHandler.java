package com.valid.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;

/*
* 自定义Handler，需要继承自Netty的某个HandlerAdapter
* */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 读取数据的事件
    /*
    * ChannelHandlerContext 上下文对象，含有管道pipeline、通道channel和地址
    * Object 就是客户端发送的数据
    * */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server ctx = " + ctx);
        // 将msg转成一个ByteBuffer
        // ByteBuf 是 Netty提供的
//        ByteBuf buf = (ByteBuf) msg;
//        System.out.println("客户端发送消息是：" + buf.toString(CharsetUtil.UTF_8));
//        System.out.println("客户端的地址是：" + ctx.channel().remoteAddress());

        // 1. 解决用户自定义的异步任务,该任务提交到channel对应的NioEventLoop的taskQueue中
//        ctx.channel().eventLoop().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(10 * 1000);
//                    ctx.writeAndFlush(Unpooled.copiedBuffer("Hello, 客户端2", CharsetUtil.UTF_8));
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        // 2. 用户自定义的定时任务 该任务提交到scheduleTaskQueue中
        ctx.channel().eventLoop().schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5 * 1000);
                    ctx.writeAndFlush(Unpooled.copiedBuffer("Hello, 客户端3", CharsetUtil.UTF_8));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 5, TimeUnit.SECONDS);

    }

    // 数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

        // 将数据写入到缓冲，并刷新
        // 一般讲，我们对这个发送的数据进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello, 客户端", CharsetUtil.UTF_8));
    }

    // 处理异常
    // 一般需要关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
