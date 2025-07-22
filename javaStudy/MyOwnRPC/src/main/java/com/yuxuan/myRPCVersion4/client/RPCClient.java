package com.yuxuan.myRPCVersion4.client;

import com.yuxuan.myRPCVersion4.common.RPCRequest;
import com.yuxuan.myRPCVersion4.common.RPCResponse;

public interface RPCClient {
    RPCResponse sentRequest(RPCRequest request);
}
