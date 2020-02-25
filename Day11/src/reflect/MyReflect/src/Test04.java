import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * Author:单雪瑞
 * 2019/7/25
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        //1 反射第一步创建class对象，简单来说就是获得字节码文件

        Class<?> claxx = "shanxuerui".getClass();
        Class<String> stringClass = String.class;
        Class<?> aClass = Class.forName("java.lang.String");

        //2实例方法在调用时，用对象调用，所以先创建实例方法
        //2.1 直接实例化claxx
        Object object = claxx.newInstance();
        //2.2 先反射构造方法，再通过构造方法创建实例对象
        Constructor<?> constructor = claxx.getConstructor(String.class);
        Constructor<?> constructor1 = claxx.getConstructor(byte[].class);
        Constructor<?> constructor2 = claxx.getConstructor();
        //再通过构造方法创建实例对象
        Object s2 = constructor.newInstance("birenshanxuerui");
        Object s3 = constructor1.newInstance(new byte[]{48,49,50,51,52,53,54,55,56});
        Object s4 = constructor2.newInstance();
        //3 反射方法，引用方法、
        Method length = claxx.getMethod("length");
        Object invoke = length.invoke(s2, null);
        System.out.println(invoke);

        Method length1 = stringClass.getMethod("length", null);
        Object invoke1 = length1.invoke(s3);
        System.out.println(invoke1);

        Method substring = aClass.getMethod("substring", int.class, int.class);
        Object invoke2 = substring.invoke(s2, 3, 13);
        System.out.println(invoke2);
        //反射静态方法
        Method valueOf = claxx.getMethod("valueOf", int.class);
        Object invoke3 = valueOf.invoke(null, 110);//把110转换为字符串
        System.out.println(invoke3);
        System.out.println(invoke instanceof String);
        System.out.println(invoke3 instanceof String);



    }
}
