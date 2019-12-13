package testBloom;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestMyBloomFilter {
    private  static String TEST = "aga";
    public static void main(String[] args) {
        MyBloomFilter myBloomFilter = new MyBloomFilter();
        List<String> list = new ArrayList<>();
        char[] chars = new char[]{'a','b','c','d','e','f','g','h','i'};
        for(int i=0;i<100;i++){
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<3; j++){
                int index = random.nextInt(9);
                sb.append(chars[index]);
            }
//            System.out.print(sb.toString()+"  ");
            myBloomFilter.add(sb.toString());
            list.add(sb.toString());
        }
//        System.out.println();
        long start1 = System.currentTimeMillis();
        boolean a = myBloomFilter.contains(TEST);
        System.out.println(a);
        System.out.println("MyBloomFilter-->"+(System.currentTimeMillis()-start1));
        long start2 = System.currentTimeMillis();
        boolean b = list.contains(TEST);
        System.out.println(b);
        System.out.println("list->"+(System.currentTimeMillis()-start1));
    }
}
