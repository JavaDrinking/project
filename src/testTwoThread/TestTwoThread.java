package testTwoThread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hongyun.wang01@hand-china.com
 *
 * 两个线程交替打印奇偶数
 */
public class TestTwoThread {
    private static final Lock lock;
    private static final TestTwoThread testTwoThread = new TestTwoThread();
    private boolean flag;
    private  volatile int num = 0;
    private static final int count = 100000;
    static {
        lock = new ReentrantLock();
    }
    public static void main(String[] args) {
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(2, 2,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        final long start = System.currentTimeMillis();
        try {
            threadPoolExecutor.execute(new TestTwoThread.Thread1());
            threadPoolExecutor.execute(new TestTwoThread.Thread2());
        }finally {
            threadPoolExecutor.shutdown();
            try {
                //该函数所在线程会陷入阻塞，直到shutdown请求发出导致所有线程都结束、或者时间超时、或者当前线程被中断，这三个条件只要发生一个，线程就会跳出阻塞状态。
                threadPoolExecutor.awaitTermination(1, TimeUnit.HOURS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("两个线程总共用时---》"+(System.currentTimeMillis()-start));
        }

//        new Thread(new Thread1(),"thread1").start();
//        new Thread(new Thread2(),"thread2").start();

    }

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            while (testTwoThread.num < count){
                if(testTwoThread.flag){
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"-->"+testTwoThread.num++);
                        testTwoThread.flag = !testTwoThread.flag;
                    }finally {
                        lock.unlock();
                    }
                }

            }
        }
    }
    private static class Thread2 implements Runnable{
//        TestTwoThread testTwoThread = new TestTwoThread();
        @Override
        public void run() {
            while (testTwoThread.num < count){
                if(!testTwoThread.flag){
                    try {
                        lock.lock();
                        System.out.println(Thread.currentThread().getName()+"-->"+testTwoThread.num++);
                        testTwoThread.flag = !testTwoThread.flag;
                    }finally {
                        lock.unlock();
                    }
                }

            }
        }
    }

}

