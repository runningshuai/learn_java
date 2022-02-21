package learnSocket.test01;

import java.io.OutputStream;
import java.net.Socket;

/*注意，先启动server，再启动client*/

public class Client {
    public static void main(String[] args) throws Exception{
        //server的ip地址和端口
        String host = "127.0.0.1";
        int port = 10086;

        //与server建立连接
        Socket socket = new Socket(host, port);

        //建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "hello world !";

        //server和client的编码格式要一致
        outputStream.write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();

    }
}
