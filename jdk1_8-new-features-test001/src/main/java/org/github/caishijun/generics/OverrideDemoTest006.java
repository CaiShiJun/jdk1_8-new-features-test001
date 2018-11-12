package org.github.caishijun.generics;

class Parent<T>{
    public void test(T t){
    };
}

class Son extends Parent<String>{
    @Override
    public void test(String s) {
        super.test(s);
    }
}

public class OverrideDemoTest006 {
}
