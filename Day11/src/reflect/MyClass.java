package reflect;

/**
 * 作者：北京动力节点老崔
 */
public class MyClass {
    public int x;
    protected  int y;
    private  int z;
    static  int ss ;

    static {
        System.out.println("MyClass类的静态代码块");
    }
}
