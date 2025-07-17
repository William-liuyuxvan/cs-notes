package com.yuxuan.myRPCVersion1.client;

import com.yuxuan.myRPCVersion1.common.RPCRequest;
import com.yuxuan.myRPCVersion1.common.RPCResponse;
import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName ClientProxy
 * @Description 传入参数Service接口的class对象，反射封装成一个request
 * @Author eeekuu
 * @Date 2025/6/23 14:46
 */
@AllArgsConstructor
public class ClientProxy implements InvocationHandler{
    // 对request进行封装，不同的service需要进行不同的封装， 客户端只知道Service接口，需要一层动态代理根据反射封装不同的Service
    private String host;
    private int port;

    // jdk 动态代理， 每一次代理对象调用方法，会经过此方法增强（反射获取request对象，socket发送至客户端）
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // request的构建，使用了lombok中的builder，代码简洁
        RPCRequest request = RPCRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .paramsTypes(method.getParameterTypes())
                .params(args).build();

        // 数据传输
        RPCResponse response = IOClient.sentRequest(host, port, request);

        return response.getData();
    }

    // 获取动态代理对象
    <T> T getProxy(Class<T> clazz) {
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T) o;
    }
}
