import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class Test1 {
    public static void main(String[] args) {
        /*Map<Integer,String> map1 = new TreeMap<>();
        map1.put(1,"zhagnsan");
        map1.put(2,"zhagnsan");
        map1.put(4,"zhagnsan");
        map1.put(1,"lish");
        System.out.println(map1);*/

        List<Integer> list = Arrays.asList(2, 1, 3, 4,4, 5);
        list.forEach(System.out::println);
        Set<Integer> set = list.stream().filter(o->o>1).collect(Collectors.toSet());
        list.stream().filter(o->o>1).collect(Collectors.toList()).forEach(t-> System.out.print(t+" "));
        System.out.println();
        System.out.println(set);

//        Optional.ofNullable(list).filter()
    }
}
