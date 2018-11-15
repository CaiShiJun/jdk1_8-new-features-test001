package org.github.caishijun.reflection.test006;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DogTest {
    public static void main(String[] args) {
        Class<Dog> c1 = Dog.class;       //或者 Class.forName("");
        try {
            Dog dog = c1.newInstance();      // newInstance() 会默认调用无参的构造方法。
        } catch (InstantiationException e) {
            //如果没有无参的构造方法，会抛出实例化异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //如果该类的构造方法是private的，会抛出非法访问异常
            e.printStackTrace();
        }

        /***************************************************************/
        Class<?> c2 = null;
        try {
            //Class.forName(""); 的方式比较常出现在框架种，因为框架常常使用 xml 配置，在 xml 中经常通过类的全限定名来表示一个类，然后通过反射来获取一个类实例。
            c2 = Class.forName("org.github.caishijun.reflection.test006.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Dog dog = (Dog) c2.newInstance();      // newInstance() 会默认调用无参的构造方法。
        } catch (InstantiationException e) {
            //如果没有无参的构造方法，会抛出实例化异常
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //如果该类的构造方法是private的，会抛出非法访问异常
            e.printStackTrace();
        }

        /***************************************************************/
        try {
            Constructor constructor = c1.getConstructor(String.class);
            Dog dog = (Dog) constructor.newInstance("旺财");

            Method m1 = c1.getDeclaredMethod("m1");      //class.getDeclaredMethod("方法名",参数类型Class);
            Object resultObj1 = m1.invoke(dog);      //method.invoke(被调用对象实例,向被调用方法传入参数);
            System.out.println("resultObj1："+resultObj1);     //因为该方法无返回值 void ，所以返回值为 null 。

            Method m2 = c1.getDeclaredMethod("m2",String.class);      //class.getDeclaredMethod("方法名",参数类型Class);
            Object resultObj2 = m2.invoke(dog,"传入的字符串参数");      //method.invoke(被调用对象实例,向被调用方法传入参数);
            System.out.println("resultObj2："+resultObj2);     //因为该方法无返回值 void ，所以返回值为 null 。

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        /***************************************************************/
        try {
            Constructor constructor = c1.getConstructor(String.class);
            Dog dog = (Dog) constructor.newInstance("旺财");
            Field f = c1.getDeclaredField("name");
            f.setAccessible(true);      //访问 private 的属性或方法。
            f.set(dog,"通过反射set进name属性的字符串");    //f.set(被调用对象实例,"通过反射set进属性的值");
            Object resultObj3 = f.get(dog);        //如果是对象属性，可以调用 get(被调用对象实例) 方法返回一个对象类型。
            //f.getInt();     //如果是基本数据类型属性，可以调用 get(被调用对象实例) 方法返回一个基本数据类型。
            System.out.println("resultObj3："+resultObj3);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}