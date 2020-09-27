import java.net.URL;
import java.sql.DriverManager;

public class ClassLoaderTest {

    public static void main(String[] args) {

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@1b6d3586

        //获取其上层：获取不到引导类加载器
        ClassLoader bootStrapClassLoader = extClassLoader.getParent();
        System.out.println(bootStrapClassLoader);//null

        //当前用户自定义类的类加载器：使用系统类加载器加载
        ClassLoader classLoader0 = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader0);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //String的类加载器是使用引导类加载器进行加载的,java的核心类库都是使用引导类加载器进行加载的
        ClassLoader classLoader1 = System.class.getClassLoader();
        System.out.println(classLoader1);//null

        //BootStrapClassLoader能够加载的API的路径
        /**
         * file:/D:/Java/jdk1.8.0_211/jre/lib/resources.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/rt.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/sunrsasign.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/jsse.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/jce.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/charsets.jar
         * file:/D:/Java/jdk1.8.0_211/jre/lib/jfr.jar
         * file:/D:/Java/jdk1.8.0_211/jre/classes
         */
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url1 : urls){
            System.out.println(url1.toExternalForm());
        }


        //扩展类加载器Extension ClassLoader能够加载的API的路径
//        String extDirs = System.getProperty( java.ext.dirs);
//        for (String extDir : extDirs.split(";")){
//            System.out.println(extDir);
//        }

        //获取当前上下文的ClassLoader
        Thread.currentThread().getContextClassLoader();

    }
}
