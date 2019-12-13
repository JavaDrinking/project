package testMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestComputeIfPresent {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>(1<<3);
        map.put("zhangasan",2);
        map.computeIfPresent("zhangasan",(k,v)->1);
        map.computeIfPresent("liahi",(k,v)->1);
        System.out.println(map);
    }
}
