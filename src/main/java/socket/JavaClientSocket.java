package socket;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author admin
 * @date 2020-05-29 14:26
 */
public class JavaClientSocket extends Thread {

    private static boolean flag = false;
    public static Socket socket = new Socket();

    public static void main(String[] args) throws IOException {
        try {
            connect();
            String bookAlarm = "POST /merlin/BookAlarmCenter.cgi HTTP/1.1\r\n" +
                    "Content-Length: 0\r\n" +
                    "Content-Type: application/json\r\n" +
                    "User-Agent: 172.18.30.120:80\r\n" +
                    "Connection: keep-alive\r\n" +
                    "Authorization: Basic YWRtaW46MTIzNDU2\r\n";
            // 向服务端发消息
            sendMessage(bookAlarm);
            // 持续接受服务端消息
            receiveMessage();
        } catch (Exception e) {
        }
        socket.close();
    }


    /**
     * 接受服务端消息
     * @throws IOException
     */
    private static void receiveMessage() throws IOException {
        // 得到socket输入流，并转换为BufferedReader
        InputStream inputStream = socket.getInputStream();

        String tag = "\r\n\r\n";
        String tag2 = "\r\n";
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int n;
        while ((n = inputStream.read()) != -1) {
            if (flag) {
                output = new ByteArrayOutputStream();
                flag = false;
            }
            output.write(n);
            String headStr = output.toString();
            int contentLength = 0;
            if (headStr.contains(tag)) {
                String[] split = headStr.split(tag2);
                for (String contentLine : split) {
                    if (contentLine.contains("Content-Length:")) {
                        contentLength = Integer.parseInt(contentLine.split("Content-Length:")[1].trim());
                        break;
                    }
                }
                int count = 0;
                while ((n = inputStream.read()) != -1) {
                    output.write(n);
                    count++;
                    if (count == contentLength) {
                        System.out.println(output.toString());
                        System.out.println("========================================================================================================");
                        flag = true;
                        break;
                    }
                }
            }
        }
    }

    private static void connect() {
        try {
            // 超时时间
            socket.setSoTimeout(30 * 1000);
            // 连接本地，超时时间3s
            socket.connect(new InetSocketAddress("172.18.30.107", 80), 30 * 1000);
        } catch (Exception e) {
        }
    }


    /**
     * 向服务端发消息
     * @param message
     * @throws IOException
     */
    public static void sendMessage(String message) {
        // 得到socket输出流，并转换为打印流
        OutputStream outputStream;
        PrintStream socketPrintStream;
        try {
            outputStream = socket.getOutputStream();
            // 用此方法发送可收到回包
            socketPrintStream = new PrintStream(outputStream);
            socketPrintStream.println(message);
        } catch (Exception e) {
        }
    }


}
