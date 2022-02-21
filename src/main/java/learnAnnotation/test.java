package learnAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class test {
    @myAnnotation()
    public void test() {}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation{
    /** 类型 + 参数 + ()
     * 只有一个注解，以value命名*/
    String value() default "";
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface myAnnotation2{
    String name() default "ban";
    int id() default -1;
    String[] schools() default {"gaozhong", "daxue"};
}