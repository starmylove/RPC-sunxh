package jlu.sunxh.test;

import jlu.sunxh.rpc.api.HelloObject;
import jlu.sunxh.rpc.api.HelloService;
import jlu.sunxinghui.rpc.client.RpcClientProxy;

public class TestClient {
    public static void main(String[] args) {
        RpcClientProxy rpcClientProxy = new RpcClientProxy("127.0.0.1",9000);
        HelloObject helloObject = new HelloObject(12,"This is a message");
        HelloService helloService = rpcClientProxy.getProxy(HelloService.class);
        String res = helloService.hello(helloObject);
        System.out.println(res);
    }
}
