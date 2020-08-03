package base.classloader;

import base.leetcode.questionofinterview.Zingfront.Test;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Objects;

/**
 * 系统类的加载机制
 * @author admin
 * @date 2020-06-18 13:25
 */
public class AppClassLoaderTest {

    public static void main(String[] args) throws Exception {

        URLClassLoader appClassLoader = (URLClassLoader)ClassLoader.getSystemClassLoader();

        System.out.println(appClassLoader);
        System.out.println("应用(系统)类加载器 的加载路径: ");

        URL[] urls = appClassLoader.getURLs();
        for(URL url : urls){
            System.out.println(url);
        }

        System.out.println("----------------------------");


        System.out.println(ClassLoader.getSystemClassLoader());

        String classPath = System.getProperty("java.class.path");
        for (String path : classPath.split(";")) {
            System.out.println(path);
        }

        System.err.println("****************************************************");

        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
    }

    private static class Test {

    }

}
