package cn.song.bio.fourstep;


import java.util.concurrent.*;

/**
 * 自定义执行Socket读取任务的线程池
 */
public class SocketThreadPool {

    //线程池
    private ExecutorService executorService;

    //初始化线程池
    /**
       int corePoolSize, 线程池中核心线程数的最大值
       int maximumPoolSize, 线程池中能拥有最多线程数
       long keepAliveTime, 线程存活时长
       TimeUnit unit, 时长单位
       BlockingQueue<Runnable> workQueue 阻塞队列长度
     */
    public SocketThreadPool(int maximumPoolSize,int queueSize) {
        this.executorService = new ThreadPoolExecutor(3,
                maximumPoolSize,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }


    public void excute(Runnable runnable){
        executorService.execute(runnable);
    }



}
