package NIODemo;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;
import java.nio.charset.Charset;

public class file {
    public static final Charset UTF_8 = StandardCharsets.UTF_8;
    public static void main(String[] args) {
        String s = "ban";
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8)));
        Path path = Paths.get("src/main/java/IOStream/introduce2.txt");
        //文件复制,这个文件不能存在，存在的话会报错
        try {
//            Path path2 = Files.copy(path, Paths.get("src/main/java/NIODemo/introduce2.txt"));
//            System.out.println(path2);
            Stream<String> stream = Files.lines(Paths.get("src/main/java/IOStream/introduce2.txt"));
            System.out.println(stream);
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
