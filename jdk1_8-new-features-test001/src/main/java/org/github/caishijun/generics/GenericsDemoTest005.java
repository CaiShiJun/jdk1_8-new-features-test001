package org.github.caishijun.generics;

public class GenericsDemoTest005<T> {

    GenericsDemoTest005(){
    }

    <V> GenericsDemoTest005(V v){
    }

    //如果指定了泛型方法，但没有使用泛型的话，那该方法就等同于一个普通方法。
    public <V> void m(){
        System.out.println("m()");
    }

    public <V> void m(V v){
        System.out.println("m()");
    }

    public <V> void m(V v,T t){
        System.out.println("m()");
    }

    public static <V> V staticMethod(V v){
        System.out.println("m()");
        return null;
    }

    public static void main(String[]  args){
        GenericsDemoTest005 demo = new GenericsDemoTest005();
        demo.m();

        demo.m("abc");      //泛型自动推断用法
        demo.<String>m("abc");      //泛型显式声明类型用法

        demo.m("abc","efg");

        GenericsDemoTest005<String> demo2 = new <Float>GenericsDemoTest005<String>(2.0F);
        GenericsDemoTest005<Integer> demo3 = new <Long>GenericsDemoTest005<Integer>(200L);

    }
}
