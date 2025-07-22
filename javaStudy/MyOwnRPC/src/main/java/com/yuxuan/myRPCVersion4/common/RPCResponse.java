package com.yuxuan.myRPCVersion4.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName RPCResponse
 * @Description TODO
 * @Author eeekuu
 * @Date 2025/6/22 18:28
 */
@Data
@Builder
@AllArgsConstructor
public class RPCResponse implements Serializable {
    // 状态信息
    private int code;
    private String msg;
    // 更新,这里我们需要加入这个，不然用其它序列化方式（除了java Serialize）得不到data的type
    private Class<?> dataType;
    // 具体数据
    private Object data;

    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).msg("ok").data(data).dataType(data.getClass()).build();
    }

    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).msg("服务器发生错误").build();
    }
}
