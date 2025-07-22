package com.yuxuan.myRPCVersion4.client;

import com.yuxuan.myRPCVersion4.codec.JsonSerializer;
import com.yuxuan.myRPCVersion4.codec.MyDecode;
import com.yuxuan.myRPCVersion4.codec.MyEncode;
import com.yuxuan.myRPCVersion4.codec.ObjectSerializer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @ClassName NettyClientInitializer
 * @Description 同样的与服务端解码和编码格式
 * @Author eeekuu
 * @Date 2025/6/27 4:53
 */
public class NettyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyDecode());
        pipeline.addLast(new MyEncode(new JsonSerializer()));
        pipeline.addLast(new NettyClientHandler());
    }
}
