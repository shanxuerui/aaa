package annotation;

/**
 * 接口中只有一个抽象方法,可以声明为函数式接口
 *  注意:
 *      函数式接口可以有static/default修饰的方法
 * 作者：北京动力节点老崔
 */
@FunctionalInterface
public interface MyInterface {
    void  mm();

    public default void dm(){
        System.out.println("这是函数式接口中default修饰的方法");
    }
}
