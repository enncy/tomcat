package cn.enncy.tomcat.server;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * //TODO
 * <br/>Created in 12:30 2021/5/3
 *
 * @author: enncy
 */
public class ThreadPool extends  ThreadPoolExecutor{

    public ThreadPool(int corePoolSize, int maximumPoolSize,  long keepAliveTime) {
        super(  corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                new WorkThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

}
class WorkThreadFactory implements ThreadFactory {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        int c = atomicInteger.incrementAndGet();
        //通过计数器，可以更好的管理线程
        return new Thread(r,"pool-1-thread-"+c);
    }
}