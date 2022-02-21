package learnEnum;

enum Color {
    RED, GREEN, BLUE;
}

public class Test01 {
    public static void main(String[] args) {
        Color c = Color.RED;
        System.out.println("Color of red: " + c);
        System.out.println(c.toString().equals("RED"));
        System.out.println("Type of color: " + c.getClass().toString());
        System.out.println("Color.RED的name is: " + c.name());

        System.out.println("迭代枚举元素： ");
        for (Color item: Color.values()){
            System.out.println(item);
            System.out.println("枚举索引:" + item.ordinal());
            System.out.println("Type: " + item.getClass().toString());
            String value = "REDD";
            try{
                System.out.println("枚举常量: "+Color.valueOf(value));
            } catch (Exception e){
                System.out.println(String.format("value %s is not exists, error: %s", value, e.getMessage()));
            }

        }
    }
}
