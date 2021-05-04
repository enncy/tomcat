package cn.enncy.tomcat.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * //TODO
 * <br/>Created in 12:27 2021/5/3
 *
 * @author: enncy
 */
public class Server {

    public static  void startup(int port,Class[] classes,Runnable callback) throws IOException {
        //创建线程池
        ThreadPool threadPool = new ThreadPool(1000,1000,1000);
        //开启服务器
        ServerSocket serverSocket = new ServerSocket(port);
        //回调
        callback.run();
        while(true){
            //获取请求
            Socket accept = serverSocket.accept();
            //创建新的任务  Runnable
            RequestRunnable requestTaskRunnable = new RequestRunnable(accept,classes);
            //开启新的线程去执行
            threadPool.execute(requestTaskRunnable);
        }
    }
}
