package learnReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * ORM
 * Object relationship Mapping -> 对象关系映射
 * 类和表结构对应
 * 属性和字段对应
 * 对象和记录对应
 */

public class orm {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        /*获得类对象*/
        Class c1 = Class.forName("learnReflection.Student");

        /*通过反射获得注解*/
        Annotation[] annotations = c1.getAnnotations();
        for(Annotation annotation:annotations){
            System.out.println(annotation);
        }

        /*获取注解的value的值*/
        Tabel t1 = (Tabel)c1.getAnnotation(Tabel.class);
        String value = t1.value();
        System.out.println(value);
        System.out.println();

        /*获得字段的注解*/
        Field f = c1.getDeclaredField("id");
        myFiled annotation = f.getAnnotation(myFiled.class);
        System.out.println(annotation.columnName());        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}


