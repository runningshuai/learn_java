package IOStream;

import java.io.File;
import java.io.IOException;

public class file {
    public static void main(String[] args) throws IOException {
        File file1 = new File("/Users/banshuaiyin/IdeaProjects/learn_java/src/main/java/IOStream/introduce.txt");
        System.out.println(file1);

        File file2 = new File("/Users/banshuaiyin/IdeaProjects/learn_java/src/main/java/IOStream/",
                "introduce.txt");
        System.out.println(file2);

        File file3 = new File("/Users/banshuaiyin/IdeaProjects/learn_java/src/main/java/IOStream/");
        File file4 = new File(file3, "introduce.txt");
        System.out.println(file4);

        System.out.println("--------------------------");
        //创建文件夹，创建成功返回true，不成功返回false，已经存在返回false
        File file5 = new File("/Users/banshuaiyin/IdeaProjects/learn_java/src/main/java/IOStream/test/a");
        boolean flag1 = file5.mkdirs();
        System.out.println("file5 创建是否成功： " + flag1);

        boolean flag2 = file5.isDirectory();
        System.out.println("file5 is directory: " + flag2);

        System.out.println("--------------------------");
        //获取绝对路径
        File file6 = new File("src/main/java/IOStream/introduce.txt");
        String path1 = file6.getAbsolutePath();
        System.out.println("path1 " + path1);
        //获取相对路径，相对于项目的路径
        String path2 = file6.getPath();
        System.out.println("path2 " + path2);
        String  filename = file6.getName();
        System.out.println("path name " + filename);

        //返回文件名字，字符串
        File file8 = new File("src/main/java/IOStream/test");
        String[] arr1 = file8.list();
        for(String name: arr1){
            System.out.println("文件名字" + name);
        }

        //返回文件对象，可调用文件对象的方法
        File[] arr2 = file8.listFiles();
        for(File file: arr2){
            System.out.println("文件对象 " + file);
        }








    }
}
