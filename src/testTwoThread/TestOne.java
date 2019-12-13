package testTwoThread;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestOne {
    private volatile int num = 0;
    private int count = 100000;

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TestOne testOne = new TestOne();
        testOne.print();
        System.out.println("单线程所用时间---》"+(System.currentTimeMillis()-start));
    }
    public void print(){
        for(int i=0; i<count; i++){
            System.out.println("--->"+num++);
        }
    }

}
