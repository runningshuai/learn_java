package LearnSLF4J;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class test {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(test.class);
        logger.info("Hello World !");
        logger.info("a: {}, b:{}", 1, 2);
    }
}
