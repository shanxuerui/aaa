package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 * 作者：北京动力节点老崔
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        //1)反射第一步,获得字节码文件
//        Class<?> claxx = String.class;      //泛型中的?是通配符,
        Class<String> claxx = String.class;      //泛型

        //2)实例方法在调用时,通过对象名调用,先创建对象
        //2.1 直接通过字节码文件创建对象
        Object s1 = claxx.newInstance();    //默认调用类的无参构造方法,如果对应类没有无参构造,运行异常

        //2.2先反射构造方法Sring(String), 再通过构造方法创建对象
        // claxx.getConstructor( String.class )  反射公共的指定参数列表的构造方法
        Constructor<?> constructor = claxx.getConstructor(String.class);
        //反射String(byte[])
        Constructor<?> constructor2 = claxx.getConstructor(byte[].class);
        //反射String()无参构造
//        Constructor<?> constructor3 = claxx.getConstructor();
        Constructor<String> constructor3 = claxx.getConstructor();

        //再通过构造方法创建对象
        Object s2 = constructor.newInstance("hello");
        Object s3 = constructor2.newInstance(new byte[]{65, 66, 67, 68, 69, 70});
//        Object s4 = constructor3.newInstance();
        String s4 = constructor3.newInstance();

        //3.1 反射方法length(),  class.getMethod(方法名, 形参列表)
        Method lengthmethod = claxx.getMethod("length");
        //3.2 调用方法, method.invoke(实例名,方法实参列表)
        Object invoke = lengthmethod.invoke(s2 );
        System.out.println(invoke);         //5
        System.out.println( lengthmethod.invoke(s3, null));
        System.out.println( lengthmethod.invoke(s4, null));

        //3.2 substring(from, to)
        Method substring = claxx.getMethod("substring", int.class, int.class);
        Object sub = substring.invoke(s2, 0, 2);
        System.out.println(sub);
        sub = substring.invoke(s3, 0, 4);
        System.out.println(sub);

        //3.3 反射静态方法valueOf(int)
        Method valueOf = claxx.getMethod("valueOf", int.class);
        //调用静态方法时,在对象名位置传递null
        Object result = valueOf.invoke(null, 123);  //把整数123转换为字符串
        System.out.println( result );       //123
        System.out.println( result instanceof  String );        //true
    }
}
