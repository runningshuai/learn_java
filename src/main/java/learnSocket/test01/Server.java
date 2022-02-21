package learnSocket.test01;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*注意，先启动server，再启动client*/

public class Server {
    public static void main(String[] args) throws Exception {
        //监听端口
        int port = 10086;
        ServerSocket server = new ServerSocket(port);

        //accept接收client的socket
        Socket socket = server.accept();
        System.out.println("已连接");

        //从socket获取输入流
        InputStream inputStream = socket.getInputStream();
        //建立缓冲区进行读取
        byte[] bytes = new byte[1024];

        int num;
        StringBuilder sb = new StringBuilder();
        //从输入流中读入数据，并存到bytes中
        while ((num = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, num, "UTF-8"));
        }
        //从server传来的数据，直接打印到屏幕，并没有返回到Server
        System.out.println("fetch message from client: " + sb);
        inputStream.close();
        socket.close();
        server.close();

    }
}
