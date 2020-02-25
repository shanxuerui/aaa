package annotation;

/**
 * 作者：北京动力节点老崔
 */
public class Test01 {
    public static void main(String[] args) {
        MyInterface i1 = new MyInterface() {
            @Override
            public void mm() {
                System.out.println("给接口引用匿名内部类对象");
            }
        };
        i1.mm();

        //直接给接口引用赋值Lambda表达式
        i1 = ()->System.out.println("给接口引用赋值Lambda表达式");
        i1.mm();
System.out.println("sxr");
    }
}
