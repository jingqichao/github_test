package java.lang;

public class String {
    static {
        System.out.println("自定义一个String");
    }

    //错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
    //   public static void main(String[] args)
    //否则 JavaFX 应用程序类必须扩展javafx.application.Application

    //报上述错误的原因是：双亲委派机制的保护，main方法在自定义String类加载的时候，他的上层引导类加载器中没有main方法
    public static void main(String[] args) {
        System.out.println("------------------");
    }
}
