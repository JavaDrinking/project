package testStream;

/**
 * @author hongyun.wang01@hand-china.com
 */
public class Student {
    private Integer id;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    private String name;

    public Integer getId() {
        return id;
    }

    public Student() {
    }

    public Student(Integer id, Integer age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
