package LearnSLF4J;


import lombok.extern.slf4j.Slf4j;

//注解，自动生成log对象，可以直接用，不用每次都写
@Slf4j
public class Test2 {
    public static void main(String[] args){
        //自动生成log，直接拿来用
        log.info("test annotation Slf4j");
    }

}
