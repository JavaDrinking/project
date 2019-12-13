package testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestComputeIfAbsent {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(1<<1);
        map.put("zhangsan",null);
        map.computeIfAbsent("zhangsan",k->sum(1,2));
        map.computeIfAbsent("lishi",k->sum(2,3));
        map.computeIfAbsent("zhangsan",k->sum(3,4));
        map.computeIfAbsent("wangwu",k->sum(3,4));
        for(Map.Entry<String,Integer> entry:map.entrySet()){
            System.out.println(entry);
        }
    }

    private static Integer sum(int a,int b){
        return a+b;
    }
}
