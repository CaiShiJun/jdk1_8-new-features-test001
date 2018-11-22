package org.github.caishijun.lambda.test005;

@FunctionalInterface
public interface FuncInterface<T> {
    T m(T t);
    String toString();
}

@FunctionalInterface
interface FuncInterface1 {
    <T> T m(T t);
    String toString();
}

interface MarkerInterface{

}

class TestFuncInterface{
    void test(){
        //1、Lambda 表达式可以赋值给泛型函数式接口类型的变量。
        FuncInterface<String> f1 = s -> s + "abc" ;

        //2、但不能赋值给带有泛型方法的非泛型函数式接口类型的变量，要使用方法引用或匿名内部类。
        //FuncInterface1 f2 = s -> s + "abc" ;

        /*
            交集类型：
                1、使用 & 将多个类型连接起来就成了交集类型。
                2、一般是将标记接口和函数式接口进行连接。
         */
        MarkerInterface mi = (MarkerInterface & FuncInterface)s -> s + "abc" ;
    }
}