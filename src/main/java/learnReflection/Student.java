package learnReflection;

@Tabel("db_student")
public class Student {
    @myFiled(columnName = "db_name", type = "varchar", length = 20)
    private String name;
    @myFiled(columnName = "db_name", type = "int", length = 10)
    private int id;
    @myFiled(columnName = "db_name", type = "int", length = 10)
    private int age;
    /* commend + N 快捷键，然后选择constructor*/
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    /*创建get和set方法也是一样的快捷键*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*创建get和set方法也是一样的快捷键, mac的commend + N 选toString*/
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
