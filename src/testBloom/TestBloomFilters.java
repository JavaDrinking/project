package testBloom;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestBloomFilters {
    public static void main(String[] args) {
        BloomFilters bloomFilters = new BloomFilters(100000000);
        for (int i=0;i<10000000;i++){
            bloomFilters.add(i+"");
        }
        System.out.println("999->"+bloomFilters.check("999"));
        System.out.println("1000000002->"+bloomFilters.check(1000000002+""));
    }
}
