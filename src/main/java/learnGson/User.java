package learnGson;

import com.google.gson.annotations.SerializedName;

public class User {
    //提供备选属性名，public类型不用写get，set方法，调用直接用object.
    @SerializedName(value="name", alternate = {"Name", "NAME"})
    public String name;
    private int age;
    private double score;

    public User(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
