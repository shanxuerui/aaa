package reflect;

import java.lang.reflect.Modifier;

/**
 * 反射类信息
 * 作者：北京动力节点老崔
 */
public class Test02 {
    public static void main(String[] args) {
        //1)反射第一步创建Class对象,理解为获得字节码文件
//        Class claxx = ArrayList.class;
        Class claxx = String.class;

        //2)根据字节码文件claxx获得类的信息
        //2.1 修饰符, modifier
        int mod = claxx.getModifiers();         //获得类的修饰符, 方法的返回值是 int 整数
        System.out.println(mod);        //1
        //java.lang.reflect.Modifier类提供静态方法toString(int), 可以把整数转换为字符串
        String modifiers = Modifier.toString(mod);
        System.out.println(modifiers);  //public

        //2.2类名
        System.out.println( claxx.getName() );      //java.util.ArrayList, 完整类名
        System.out.println( claxx.getSimpleName()); //ArrayList     简易类名

        //2.3父类名
        Class superclass = claxx.getSuperclass();   //返回父类, 方法返回值类型是Class
//        System.out.println(superclass);
        System.out.println(superclass.getSimpleName());     //父类名

        //2.4接口名
        Class[] interfaces = claxx.getInterfaces(); //返回值是数组,类可以实现多个接口
        //如果类没有实现接口,则返回一个长度为0的数组
        for(int i = 0 ; i < interfaces.length; i++){
            System.out.println( interfaces[i].getSimpleName() );
        }
    }
}
