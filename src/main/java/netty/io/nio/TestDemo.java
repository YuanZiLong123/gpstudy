package netty.io.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestDemo {

    public static void main(String[] args) {
        String fileName = "F:\\train\\src";
        FileOutputStream fileOutputStream = null;
        try {

        File file = new File("D:\\train_code.txt");
        file.createNewFile();
        fileOutputStream = new FileOutputStream(file);
        File orgi = new File(fileName);
       write(orgi, fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write(File file, FileOutputStream fileOutputStream) throws IOException {
        FileInputStream fileInputStream = null;
        //指定读写格式为gbk
        try {
            if (file.isDirectory()){
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    // 如果还是文件夹 递归获取里面的文件 文件夹
                    if (files[i].isDirectory()) {
                        write(files[i], fileOutputStream);
                    }else {
                        File codeFile = files[i];
                        if (codeFile.getName().endsWith(".java")||codeFile.getName().endsWith(".xml")||codeFile.getName().endsWith(".pom")){
                            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(codeFile), "utf-8"));
                            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));
                            String temp;
                            while ((temp = br.readLine()) != null) {
                                //每次写入一行.
                                bw.write(temp);
                                //并且进行换行
                                bw.newLine();
                                bw.flush();
                            }
                        }
                    }
                }
            }else {
            if (file.getName().endsWith(".java")||file.getName().endsWith(".xml")||file.getName().endsWith(".pom")){
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));
                String temp;
                while ((temp = br.readLine()) != null) {
                    //每次写入一行.
                    bw.write(temp);
                    //并且进行换行
                    bw.newLine();
                    bw.flush();
                }
            }
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (null!=fileInputStream){
                fileInputStream.close();
            }
        }

    }

}
