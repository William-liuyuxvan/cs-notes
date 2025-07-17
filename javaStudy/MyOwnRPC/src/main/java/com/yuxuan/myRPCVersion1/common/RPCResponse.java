package com.yuxuan.myRPCVersion1.common;

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
public class RPCResponse implements Serializable {
    // 状态信息
    private int code;
    private String msg;
    // 具体数据
    private Object data;

    public static RPCResponse success(Object data) {
        return RPCResponse.builder().code(200).msg("ok").data(data).build();
    }

    public static RPCResponse fail() {
        return RPCResponse.builder().code(500).msg("服务器发生错误").build();
    }
}
