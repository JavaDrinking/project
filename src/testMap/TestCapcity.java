package testMap;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestCapcity {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        int cap = getHashMapCapacity(hashMap);
        System.out.println("init:" + getHashMapCapacity(hashMap));
        for (int i = 0; i < 30; i++) {
            hashMap.put(String.valueOf(i), "");
            if (cap != getHashMapCapacity(hashMap)) {
                System.out.println("扩容---->扩容后\t" + "size = " + hashMap.size() + "\t容量 = " + (cap = getHashMapCapacity(hashMap)));
            }
        }
        System.out.println(String.format("hashmap 的 size 是 %s",hashMap.size()));
    }
    public static int getHashMapCapacity(HashMap<?, ?> hashMap) {
        Class<HashMap> hashMapClass = HashMap.class;
        try {
            Method capacity = hashMapClass.getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            return (int) capacity.invoke(hashMap);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
