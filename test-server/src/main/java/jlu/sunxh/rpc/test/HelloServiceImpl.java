package jlu.sunxh.rpc.test;

import jlu.sunxh.rpc.api.HelloObject;
import jlu.sunxh.rpc.api.HelloService;

public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(HelloObject object) {
        return "这是掉用的返回值，id=" + object.getId();
    }
}
