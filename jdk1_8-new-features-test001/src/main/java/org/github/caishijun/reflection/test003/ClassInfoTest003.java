package org.github.caishijun.reflection.test003;

import java.io.Serializable;
import java.lang.reflect.Modifier;

public class ClassInfoTest003 {
    public static void main(String[] args) {
        Class<PersonTest003> c = PersonTest003.class;   //获取Class实例

        System.out.println(c.getName());    //获得类的全限定名
        System.out.println(c.getSimpleName());  //获得类的类名
        System.out.println(c.getPackage().getName());   //获得类的所在包名
        System.out.println(c.isPrimitive());    //判断 c 是不是基本数据类型
        System.out.println(c.isInterface());    //判断 c 是不是接口
        System.out.println(c.isAnnotation());   //判断 c 是不是注解
        System.out.println(c.isEnum());         //判断 c 是不是枚举

        Class<?> sc = c.getSuperclass();        //获得类的父类
        System.out.println(sc.getName());  //获得父类的类名

        Class<?>[] si = c.getInterfaces();      //获得类实现的接口
        for (Class ci : si){
            System.out.println(ci.getName());   //获得类实现接口的类名
        }

        int mod = c.getModifiers();     //获得类的访问修饰符
        System.out.println(Modifier.toString(mod));     //获得类的修饰符字符串

        System.out.println(c.toGenericString());        //获得类的简要声明字符串
    }
}

class PersonTest003 extends Thread implements Serializable {

}