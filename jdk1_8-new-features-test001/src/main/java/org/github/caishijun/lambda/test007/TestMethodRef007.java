package org.github.caishijun.lambda.test007;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@FunctionalInterface
interface ToInt<T> {
    int convert(T t);
}

@FunctionalInterface
interface Interface3 {
    <T> T m(T t);
}

class MyClass007 {
    static <T> T n(T t) {
        return t;
    }

    ;
}

public class TestMethodRef007 {
    public static void main(String[] args) {
        ToInt<String> t1 = s -> s.length();
        System.out.println(t1.convert("Tom"));

        ToInt<String> t2 = Integer::parseInt;     //方法引用
        System.out.println(t2.convert("123"));

        //使用 lambda 表达式调用 String 对象 ，无参数有返回值的方法
        Supplier<Integer> s1 = ""::length;
        s1.get();

        //使用 lambda 表达式调用 PrintStream 有参数无返回值方法。
        Consumer<String> s2 = System.out::println;
        s2.accept("ddddd");

        //使用 lambda 表达式调用 String 对象 ，无参数有返回值的方法
        Function<String, Integer> f1 = String::length;
        f1.apply("sdfasdfasfasdfasdf");     // 等价于 "sdfasdfasfasdfasdf".length();

        Son son = new Son();
        son.m();

        //使用 lambda 表达式调用无参的构造方法创建实例
        Supplier<Son> sonSupplier = Son::new;
        Son son1 = sonSupplier.get();

        //使用 lambda 表达式调用有参的构造方法创建实例
        Function<String, Son> fun1 = Son::new;
        Son son2 = fun1.apply("zhangwu");

        //使用 lambda 表达式创建数组
        Function<Integer, int[]> fun2 = int[]::new;
        fun2.apply(5);
        Function<Integer, int[]> fun3 = size -> new int[size];
        fun3.apply(6);

        //使用 lambda 表达式调用类的静态方法
        Interface3 i3 = MyClass007::n;
        String i3Str = i3.m("泛型方法");
        System.out.println("i3Str ：" + i3Str);
    }
}

class Parent007 {
    private String name = "张三";

    String getName() {
        return this.name;
    }
}

class Son extends Parent007 {
    private String name = "张四";

    public Son() {
    }

    public Son(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }

    void m() {
        //使用 lambda 表达式调用当前类中的方法
        Supplier<String> s1 = this::getName;
        //使用 lambda 表达式调用父类中的方法
        Supplier<String> s2 = Son.super::getName;

        System.out.println(s1.get());
        System.out.println(s2.get());
    }
}