package testThreadLocal;

import java.util.concurrent.*;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestThreadLocal {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("main");
        ExecutorService executorService = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        try {

            executorService.execute(()->{
                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            });
            executorService.execute(()->{
                threadLocal.set(Thread.currentThread().getName());
                System.out.println(threadLocal.get());
            });
        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            System.out.println("线程运行结束");
            executorService.shutdown();
        }
        /*new Thread(()->{
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        },"thread1").start();
        new Thread(()->{
            threadLocal.set(Thread.currentThread().getName());
            System.out.println(threadLocal.get());
        },"thread2").start();*/
        System.out.println(threadLocal.get());
    }
}
