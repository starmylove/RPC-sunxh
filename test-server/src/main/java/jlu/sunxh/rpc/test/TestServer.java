package jlu.sunxh.rpc.test;

import jlu.sunxh.rpc.api.HelloService;
import jlu.sunxinghui.rpc.server.RpcServer;

public class TestServer {
    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(helloService,9000);
    }
}
