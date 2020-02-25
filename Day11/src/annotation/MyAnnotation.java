package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 作者：北京动力节点老崔
 */
@Target({ElementType.TYPE,ElementType.METHOD })     //当前MyAnnotation注解可以修饰类与方法
@Retention(RetentionPolicy.RUNTIME)     //MyAnnotation注解保留到运行时
public @interface MyAnnotation {
    String role();      //定义注解中的属性
}
