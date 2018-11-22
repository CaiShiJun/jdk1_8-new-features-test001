package org.github.caishijun.lambda.test008;

import java.util.function.Consumer;

public class ScopDemo008 {

    void m() {
        int num = 10;
    }

    //Lambda 表达式没有定义自己的作用域。它存在于外围作用域中，称为词法作用域。
    static int num = 20;

    public static void main(String[] args) {
        //int num = 20;

        Consumer<Integer> c1 = n -> System.out.println(num + n);
        c1.accept(40);

    }
}
