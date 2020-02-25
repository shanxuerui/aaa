package annotation;

/**
 * 通过反射获得注解的信息
 * 作者：北京动力节点老崔
 */

@MyAnnotation(role = "hehe")        //使用自定义注解修饰Test02类
public class Test02 {
//    @MyAnnotation(role = "xx")        //不能修饰字段
    int x;

    @MyAnnotation( role = "jj")
    public static void main(String[] args) {
        //在程序运行时,可以通过反射获得注解中的信息
        Class<Test02> claxx = Test02.class;

        //反射注解
        MyAnnotation annotation = claxx.getAnnotation(MyAnnotation.class);
        //读取注解中的信息
        if ( annotation != null){
            System.out.println( annotation.role());
        }
    }
}
