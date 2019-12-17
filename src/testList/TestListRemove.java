package testList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestListRemove {
    private static List<String> list;

    public static void main(String[] args) {
        list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("222");
        list.add("333");
        //直接遍历删除抛出java.util.ConcurrentModificationException异常
//        for(String str:list){
//            if("111".equals(str)){
//                list.remove(str);
//            }
//        }
        //使用迭代器遍历删除可以正常删除
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if("222".equals(iterator.next())){
                iterator.remove();

            }
        }
        System.out.println(list);
    }
}
