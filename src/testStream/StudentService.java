package testStream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class StudentService {
    public List<Student> add(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(1,18,"zhangsan"));
        list.add(new Student(2,19,"zhangsan1"));
        list.add(new Student(2,119,"zhangsan11111"));
        list.add(new Student(3,20,"zhangsan2"));
        list.add(new Student(4,18,"zhangsan4"));
        return list;
    }
}
