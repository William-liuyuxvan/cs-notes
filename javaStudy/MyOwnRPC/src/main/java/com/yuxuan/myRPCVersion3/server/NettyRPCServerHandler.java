package com.yuxuan.myRPCVersion3.server;

import com.yuxuan.myRPCVersion3.common.RPCRequest;
import com.yuxuan.myRPCVersion3.common.RPCResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName NettyRPCServerHandler
 * @Description
 *    因为是服务器端，我们知道接受到请求格式是RPCRequest
 *    Object类型也行，强制转型就行
 * @Author eeekuu
 * @Date 2025/6/27 4:40
 */
@AllArgsConstructor
public class NettyRPCServerHandler extends SimpleChannelInboundHandler<RPCRequest > {
    private ServiceProvider serviceProvider;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RPCRequest msg) throws Exception {
        RPCResponse response = getResponse(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private RPCResponse getResponse(RPCRequest msg) {
        // 得到服务名
        String interfaceName = msg.getInterfaceName();
        // 得到服务端相应服务实现类
        Object service = serviceProvider.getService(interfaceName);
        // 反射调用方法
        Method method = null;
        try {
            method = msg.getClass().getMethod(msg.getMethodName(), msg.getParamsTypes());
            Object invoke = method.invoke(service, msg.getParams());
            return RPCResponse.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            System.out.println("方法执行错误");
            return RPCResponse.fail();
        }
    }
}
