package base.classloader;

/**
 * 扩展类的加载机制
 * @author admin
 * @date 2020-06-18 13:50
 */
public class ExtClassLoaderTest {

    public static void main(String[] args) {
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }
        ClassLoader sunClassLoader = sun.security.ec.SunEC.class.getClassLoader();
        System.out.println(sunClassLoader);
        System.out.println(sunClassLoader.getParent());

          /* Class c = Class.forName("com.gupao.vip.mic.dubbo.user.IUserCoreService");
        System.out.println(c.getName());*/
    }
}
