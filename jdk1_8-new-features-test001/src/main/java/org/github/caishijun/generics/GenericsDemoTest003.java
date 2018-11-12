package org.github.caishijun.generics;

class MyImplementsTest003_0 implements GenericsInterfaceTest003<String>{

    public String test(String s) {
        return null;
    }

}

class MyImplementsTest003_1<T> implements GenericsInterfaceTest003<T>{

    public T test(T s) {
        return null;
    }

}

public class GenericsDemoTest003 {

    public static void main(String[]  args){

        GenericsInterfaceTest003<String> w1 = new MyImplementsTest003_0();
        String d1 = w1.test("One");
    }
}