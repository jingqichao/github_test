public class LoaderTest {

    private static int num =1;
    static {
        num = 2;
        number = 20;
        System.out.println(num);
        //System.out.println(number);//报错：非法的前向引用
    }
    private static int number =10;//在类的准备阶段开始前，number就已经被赋值为0了，所以初始化过程是0->20->10

    /**
     *  0 iconst_1
     *  1 putstatic #3 <LoaderTest.num>
     *  4 iconst_2
     *  5 putstatic #3 <LoaderTest.num>
     *  8 bipush 20
     * 10 putstatic #5 <LoaderTest.number>
     * 13 bipush 10
     * 15 putstatic #5 <LoaderTest.number>
     * 18 return
     */
    public static void main(String[] args) {
        System.out.println(LoaderTest.num);//2
        System.out.println(LoaderTest.number);//10
    }
}
