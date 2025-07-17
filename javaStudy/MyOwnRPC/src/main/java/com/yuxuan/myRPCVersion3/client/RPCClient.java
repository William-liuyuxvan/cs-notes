package com.yuxuan.myRPCVersion3.client;

import com.yuxuan.myRPCVersion3.common.RPCRequest;
import com.yuxuan.myRPCVersion3.common.RPCResponse;

public interface RPCClient {
    RPCResponse sentRequest(RPCRequest request);
}
