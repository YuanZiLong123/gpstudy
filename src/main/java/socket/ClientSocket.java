package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author admin
 * @date 2020-05-29 14:20
 */
public class ClientSocket {


    public static void main(String[] args) throws IOException{
//        Socket socket = new Socket();
        Socket socket = new Socket("127.0.0.1", 80);
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        while (flag){
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("请输入：");
            String content = scanner.nextLine();
            outputStream.write(content.getBytes());

            InputStream  inputStream  = socket.getInputStream();

            byte[] bytes = new byte[1024];
            inputStream.read(bytes);
            String str
                     = new String(bytes);
            System.out.println("服务器说：");
            System.out.println(str);
            if ("byte".equals(str)){
                flag = false;
            }
        }


        socket.close();
        System.out.println("客户端已退出~");
    }


}
