package testThreadLocal;

import java.util.concurrent.*;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestVolatile {
    private static volatile int i = 0;
    private static int k = 0;
    private static final String a = "a";
    public static void main(String[] args) {
        int count = 100000000;
        handByThread(count);
        hand(count);
        System.out.println("main----->"+i);
    }
    private static void handByThread(final int count){
        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        try {

                threadPoolExecutor.execute(()->{
                    for(int j=0; j<count; j++){
                    synchronized (a) {
                        i++;
//                        System.out.println(i);
                    };
                }
            });
        }finally {
            System.out.println("多线程操作所得"+i);
            System.out.println("多线程操作所用时间---》"+(System.currentTimeMillis()-start));
            threadPoolExecutor.shutdown();
        }
    }

    private static void hand(final int count){
        final long start = System.currentTimeMillis();
        try {
            for(int j=0; j<count; j++){
                k++;
            }
        }finally {
            System.out.println(k);
            System.out.println("普通操作所用时间---》"+(System.currentTimeMillis()-start));
        }

    }
}
