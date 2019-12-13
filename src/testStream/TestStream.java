package testStream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class TestStream {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        List<Student> list = studentService.add();
        //得到所有学生姓名的集合
        List<String> names = list.stream().map(student -> student.getName()).collect(Collectors.toList());
        System.out.println("names->"+names);
        //得到年龄大于18的学生的集合
        List<Student> students = list.stream().filter(student -> student.getAge() > 18).collect(Collectors.toList());
        System.out.println("students->"+students);
        //按年龄从小到大排序
        List<Student> studentList = list.stream().sorted((Student s1, Student s2) -> s1.getAge() - s2.getAge()).collect(Collectors.toList());
        System.out.println("sorted students->"+studentList);
        //年龄最小的两名学生
        List<Student> students1 = list.stream().sorted((Student s1, Student s2) -> s1.getAge() - s2.getAge()).limit(2).collect(Collectors.toList());
        System.out.println(students1);
        //遍历学生年龄加10
        list.forEach(student->{
            student.setAge(student.getAge()+10);
        });
        System.out.println("change list->"+list);
        //判断是否所有学生id>1
        boolean allMatch = list.stream().allMatch(student -> student.getId() > 1);
        System.out.println(allMatch);
        //判断是否有学生id<1或年龄大于18
        boolean anyMatch = list.stream().anyMatch(student -> student.getId() < 1 || student.getAge()>18);
        System.out.println(anyMatch);
        //获得学生总数
        long count = list.stream().count();
        System.out.println(count);
        //跳过两个学生得到后面的记录
        List<Student> students2 = list.stream().skip(2).collect(Collectors.toList());
        System.out.println(students);

//        Map<Integer, Student> studentMap = list.stream().collect(Collectors.toMap(student -> student.getId(), student -> student));
//        System.out.println("student Map - >" + studentMap);
        Map<Integer,Student> map = new HashMap<>();
        list.forEach(student -> {
            map.computeIfAbsent(student.getId(),id->student);
        });
//        map.forEach((Integer id,Student student)->{
//            if(id>1 && id<4){
//                System.out.println("["+id+"="+student+"]");
//            }
//        });
        System.out.println(map.values());
    }
}
