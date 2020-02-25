package reflect;

import java.lang.reflect.Field;

/**
 * 通过反射技术访问字段
 * 作者：北京动力节点老崔
 */
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        //1)获得字节码文件
//        Class claxx = MyClass.class;      //可以获得字节码文件,没有执行静态代码块
        Class claxx = Class.forName("reflect.MyClass");     //执行了静态代码块

        //2)反射public修饰的公共字段, claxx.getField("字段名") 注意只能反射公共字段
        Field xx = claxx.getField("x");  //如果x没有使用public修饰就异常

        //x字段是一个实例变量, 必须先创建对象,然后才实例变量的存在, 实例变量是属于某个具体对象的
        //3) 直接通过字节码文件claxx创建MyClass对象
        Object obj = claxx.newInstance();

        //4)设置字段的值,  field.set(实例名, 字段值)
        xx.set(obj, 123);       //把obj对象的xx字段设置为123

        //5)返回字段的值, field.get(实例名)
        System.out.println( xx.get(obj));

        //6)每个对象都有自己的字段
        Object obj2 = claxx.newInstance();      //创建新的MyClass对象
        System.out.println( xx.get(obj2)) ;     //返回obj2对象的xx字段值  0
        xx.set(obj2, 369);
        System.out.println( xx.get(obj2)) ;     //返回obj2对象的xx字段值  369

        //7)反射的字段如果不是public公共的, claxx.getDeclaredField("字段名") 返回任意权限的字段
        Field zz = claxx.getDeclaredField("z");     //反射私有字段
        //8)设置字段的可访问性,在java中,没有严格意义上的封装
        zz.setAccessible(true);
        zz.set(obj, 123);
        System.out.println(zz.get(obj));
        zz.set(obj2, 369);
        System.out.println(zz.get(obj2));

        //9)反射静态字段ss
        Field ss = claxx.getDeclaredField("ss");
        //访问静态字段时,在对象名位置传递null
        ss.set(null, 147);
        System.out.println(ss.get(null));
    }
}
