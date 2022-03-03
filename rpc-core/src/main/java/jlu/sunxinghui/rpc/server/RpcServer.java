package jlu.sunxinghui.rpc.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class RpcServer {
    private final ExecutorService threadPool;

    public RpcServer(){
        int corePoolSize = 5;
        int maximumPollSize =50;
        long keepAliveTime =60;
        BlockingQueue<Runnable> workingQueue = new ArrayBlockingQueue<>(100);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        threadPool = new ThreadPoolExecutor(corePoolSize,maximumPollSize,keepAliveTime,TimeUnit.SECONDS,workingQueue,threadFactory);
    }
    public void register(Object service, int port){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket socket = serverSocket.accept();
                threadPool.execute(new WorkerThread(socket,service));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
