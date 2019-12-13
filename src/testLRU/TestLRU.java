package testLRU;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestLRU {
    public static void main(String[] args) {
        LRUCache<Integer,String> lruCache = new LRUCache<>(2);
        lruCache.put(1,"1111");
        lruCache.put(2,"222");
        lruCache.put(2,"223");
        lruCache.put(3,"222");
        System.out.println(lruCache.get(2).value);
    }
}
