package com.yuxuan.myRPCVersion4.server;

import com.yuxuan.myRPCVersion4.codec.JsonSerializer;
import com.yuxuan.myRPCVersion4.codec.MyDecode;
import com.yuxuan.myRPCVersion4.codec.MyEncode;
import com.yuxuan.myRPCVersion4.codec.ObjectSerializer;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import lombok.AllArgsConstructor;

/**
 * @ClassName NettyServerInitializer
 * @Description 初始化，主要负责序列化的编码解码，需要解决netty的粘包问题
 * @Author eeekuu
 * @Date 2025/6/27 4:33
 */
@AllArgsConstructor
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServiceProvider serviceProvider;

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyDecode());
        pipeline.addLast(new MyEncode(new JsonSerializer()));
        pipeline.addLast(new NettyRPCServerHandler(serviceProvider));
    }
}
