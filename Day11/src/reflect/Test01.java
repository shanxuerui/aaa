package reflect;

/**
 * 创建Class对象
 *      可以简单的理解为获得字节码文件
 * 作者：北京动力节点老崔
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1)每个类都有class属性
        Class claxx = String.class;

        //2)每个对象都有getClass()方法 (从Object类继承的)
        Class claxx2 = "hello".getClass();

        //3)Class.forName("完整类名),这种方式会把字节码文件加载内存,会执行静态代码块, JDBC
        Class claxx3 = Class.forName("java.lang.String");

        //不管通过哪个方式都是拿到String类的字节码文件, String字节码文件只有一份
        System.out.println( claxx == claxx2 );  //true
        System.out.println( claxx == claxx3 );  //true

        //4)基本类型
        Class claxx4 = int.class;
        Class claxx5 = Integer.TYPE;
        System.out.println(claxx4 == claxx5);
    }
}
