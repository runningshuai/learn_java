package IOStream;

import java.io.Reader;
import java.io.Writer;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;

public class fileReaderDemo {
    public static void main(String[] args) throws IOException {
        Reader reader = new FileReader("src/main/java/IOStream/introduce.txt");
        char[] ch = new char[5];
        int len;
        while(true){
            len = reader.read(ch);
            if(len != -1) {
                String s = new String(ch, 0, len);
                System.out.println(s);
            }else{
                break;
            }
        }
        reader.close();

        Writer writer = new FileWriter("src/main/java/IOStream/introduce2.txt");
        writer.write("第一行");
        writer.close();

    }

}
