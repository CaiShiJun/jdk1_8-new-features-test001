package org.github.caishijun.generics;

class WrapperTest004<T>{

}

public class GenericsDemoTest004 {

    public static void main(String[]  args){
        WrapperTest004<String> w1 = new WrapperTest004<>();
        WrapperTest004<Object> w2 = new WrapperTest004<>();

        /**
         * 有继承关系的参数类型：
         * 	1、实际类型参数如果有继承关系，也不允许相互赋值。
         * 	w2 = w1  不能成功赋值
         */
        WrapperTest004 w3 = new WrapperTest004();       // raw type 原生类型。
        w2 = w3; //可以成功赋值
        w3 = w1; //可以成功赋值

    }
}
