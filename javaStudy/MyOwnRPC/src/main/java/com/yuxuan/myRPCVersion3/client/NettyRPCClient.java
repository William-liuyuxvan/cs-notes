package com.yuxuan.myRPCVersion3.client;

import com.yuxuan.myRPCVersion3.common.RPCRequest;
import com.yuxuan.myRPCVersion3.common.RPCResponse;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.AttributeKey;

/**
 * @ClassName NettyRPCClient
 * @Description 实现RPCClient接口
 * @Author eeekuu
 * @Date 2025/6/27 4:49
 */
public class NettyRPCClient implements RPCClient {
    private static final Bootstrap BOOTSTRAP;
    private static final EventLoopGroup EVENT_LOOP_GROUP;
    private String host;
    private int port;

    public NettyRPCClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    static {
        EVENT_LOOP_GROUP = new NioEventLoopGroup();
        BOOTSTRAP = new Bootstrap();
        BOOTSTRAP.group(EVENT_LOOP_GROUP)
                .channel(NioSocketChannel.class)
                .handler(new NettyClientInitializer());
    }

    // 这里需要操作一下，因为netty的传输都是异步的，你发送request，会立刻返回一个值， 而不是想要的相应的response
    @Override
    public RPCResponse sentRequest(RPCRequest request) {
        try {
            ChannelFuture channelFuture = BOOTSTRAP.connect(host, port);
            Channel channel = channelFuture.channel();
            // 发送消息
            channel.writeAndFlush(request);
            channel.closeFuture().sync();
            // 阻塞的获得结果，通过给channel设计别名，获取特定名字下的channel中的内容（这个在hanlder中设置）
            // AttributeKey是，线程隔离的，不会由线程安全问题。
            // 实际上不应通过阻塞，可通过回调函数
            AttributeKey<RPCResponse> key = AttributeKey.valueOf("RPCResponse");
            RPCResponse respnse = channel.attr(key).get();

            System.out.println(respnse);
            return respnse;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
