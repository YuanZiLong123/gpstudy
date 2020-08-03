package base.classloader;

import java.net.URL;

/**
 * 启动类的加载机制
 * @author admin
 * @date 2020-06-18 13:51
 */
public class BootstrapClassLoaderTest {

    public static void main(String[] args) {
        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }


        System.out.println("***********************************");
        ClassLoader classLoader = String.class.getClassLoader();
        System.out.println(classLoader);
    }
}
