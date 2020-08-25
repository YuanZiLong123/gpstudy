package effective;

import java.io.*;

public class SerializableTest {


    public static void main(String[] args) {
        try {
            /*File file = new File("C:\\Users\\admin\\Desktop\\songleton.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file) {
            });
            TwoSingleton twoSingleton = TwoSingleton.getInstance();
            twoSingleton.setName("单例测试");
            objectOutputStream.writeObject(twoSingleton);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            TwoSingleton serizlizableTwoSingleton = (TwoSingleton) objectInputStream.readObject();
            System.out.println(serizlizableTwoSingleton==twoSingleton);*/

            File file = new File("C:\\Users\\admin\\Desktop\\songleton.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file) {
            });
            OtherSerializable twoSingleton = new OtherSerializable("1");
            objectOutputStream.writeObject(twoSingleton);
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
            OtherSerializable serizlizableTwoSingleton = (OtherSerializable) objectInputStream.readObject();
            System.out.println(serizlizableTwoSingleton==twoSingleton);
            System.out.println(serizlizableTwoSingleton.getName());
        }catch (Exception e){

        }



    }
}
