package learnCollectors;

public class Student {
    private String name;
    private int age;
    //是否本地人
    private boolean isLocal;
    private Grade grade;
    private int score;

    public enum Grade {one, two, three}

    //构造器
    public Student(String name, int age, boolean local,Grade grade ,int score){
        this.name = name;
        this.age = age;
        this.isLocal = local;
        this.grade = grade;
        this.score = score;
    }

    @Override
    public String toString(){
        return "Student{name:" + name +
                ", age:" + age +
                ", isLocal:" + isLocal +
                ", grade:" + grade +
                ", score:" + score +
                "}";
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public boolean getIsLocal(){
        return isLocal;
    }

    public void setIsLocal(boolean local){
        this.isLocal = local;
    }
    public Grade getGrade(){
        return grade;
    }

    public void setGrade(Grade grade){
        this.grade = grade;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;
    }

}
