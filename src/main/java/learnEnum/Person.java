package learnEnum;

public enum Person {

    Man("男性", 0),
    Men("女性", 1);

    //成员变量
    private String name;
    private int index;

    Person(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //普通方法
    public static boolean match(int index1, int index2) {
        return index1 + index2 == 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
