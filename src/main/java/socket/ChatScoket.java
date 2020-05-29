package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author admin
 * @date 2020-05-29 14:09
 */
public class ChatScoket {



    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(80);

        System.out.println("服务器准备就绪~");
        System.out.println("服务端信息：" + server.getInetAddress() + "port:" + server.getLocalPort());
        // 得到客户端
        Scanner scanner = new Scanner(System.in);

            boolean flag = true;
        Socket client = server.accept();
        System.out.println("有客户端连接"+client.getInetAddress()+":"+client.getPort());
            while (flag){
            InputStream inputStream = client.getInputStream();

             byte[] bytes = new byte[1024];
             inputStream.read(bytes);
                System.out.println("客户端说：");
            System.out.println(new String(bytes));
            //PrintWriter printWriter = new PrintWriter(client.getOutputStream());
           // printWriter.println("1111");
                boolean contentEnd = true;
                System.out.println("你说：");
                while (contentEnd){
                    String content = scanner.nextLine();
                    OutputStream outputStream =  client.getOutputStream();
                    outputStream.write(content.getBytes());

                    if (content.equals("end")){
                        contentEnd = false;
                    }
                }


            // 客户端构建异步线程
           // ClientHandler clientHandler = new ClientHandler(client);
            // 启动线程
           // clientHandler.start();
                }
        }


    /**
     * 客户端消息处理
     */
    private static class ClientHandler extends Thread {
        private Socket socket;
        private boolean flag = true;
        ClientHandler (Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            super.run();
            System.out.println("新客户端连接：" + socket.getInetAddress() + "，port:" + socket.getPort());
            Scanner scanner = new Scanner(System.in);
            try {
                // 得到打印流，用于数据输出，服务器回送数据使用
                PrintStream socketOutPut = new PrintStream(socket.getOutputStream());
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                do {
                    // 客户端拿到一条数据
                    String str = socketInput.readLine();
                    if ("bye".equalsIgnoreCase(str)) {
                        flag = false;
                        // 回送
                        socketOutPut.println("bye");
                    } else {
                        // 打印到屏幕，并回数据长度
                        System.out.println("客户端发来消息：" + str);
                        String message = scanner.nextLine();
                        socketOutPut.println("回送：" + message.length());// 回送客户端
                    }
                } while (flag);
                socketInput.close();
                socketOutPut.close();
            } catch(Exception e) {
                System.out.println("连接异常断开");
            } finally {
                // 连接关闭
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("客户端已退出：" + socket.getInetAddress() + "port:" + socket.getPort());
        }
    }

}
