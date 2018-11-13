package org.github.caishijun.reflection.test005;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MethodInfoTest005 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Class2> c = Class2.class;
        Method[] methods1 = c.getMethods();      //获取所有 public方法 数组，包括继承而来的方法，例如：m1
        for (Method method : methods1){
            System.out.println(method.getName());
            method.getReturnType();     //获取返回值类型
            method.getParameterTypes(); //获取参数类型;
            method.getGenericParameterTypes();  //跟泛型相关的
            method.getAnnotatedParameterTypes();    //跟注解相关的
            method.getExceptionTypes();     //跟异常相关
        }

        Method[] methods2 = c.getDeclaredMethods();      //获取所有 本类自己声明的方法 数组，不包括继承而来的方法，例如：m1、m2、m3、m4
        for (Method method : methods2){
            System.out.println(method.getName());
        }

        Method method3 = c.getDeclaredMethod("m1");      //获取 本类自己声明的方法，不包括继承而来的方法。
        System.out.println(method3.getName());
        Method method4 = c.getDeclaredMethod("m1",int.class);      //获取 本类自己声明的方法，不包括继承而来的方法。
        System.out.println(method4.getName());
        Method method5 = c.getDeclaredMethod("m1",int.class,String.class);      //获取 本类自己声明的方法，不包括继承而来的方法。
        System.out.println(method5.getName());

        Method method6 = c.getMethod("m1");      //获取 public方法，包括继承而来的方法。
        System.out.println(method6.getName());
        Method method7 = c.getMethod("m1",int.class);      //获取 public方法，包括继承而来的方法。
        System.out.println(method7.getName());
        Method method8 = c.getMethod("m1",int.class,String.class);      //获取 public方法，包括继承而来的方法。
        System.out.println(method8.getName());

        Constructor<?>[] constructors1 = Class3.class.getConstructors();       //获取 public构造方法 数组，不包括父类的构造方法。因为构造方法无法被继承。
        for (Constructor<?> constructor : constructors1){
            System.out.println(constructor.getName());
        }

        Constructor<?>[] constructors2 = Class3.class.getDeclaredConstructors();       //获取所有 本类自己声明的构造方法 数组，不包括父类的构造方法。因为构造方法无法被继承。
        for (Constructor<?> constructor : constructors2){
            System.out.println(constructor.getName());
        }
    }
}

abstract class Class2{

    public Class2(){

    }

    public Class2(int num){

    }

    public void m1(){

    }

    public void m1(int i){

    }

    public void m1(int i,String str){

    }

    private void m2(){

    }

    static void m3(){

    }

    abstract void m4();
}

class Class3 extends Class2{

    @Override
    void m4() {

    }
}