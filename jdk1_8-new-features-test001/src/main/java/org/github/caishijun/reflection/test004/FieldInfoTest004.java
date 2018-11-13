package org.github.caishijun.reflection.test004;

import java.lang.reflect.Field;

public class FieldInfoTest004 {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<MyClass> c = MyClass.class;
        Field[] fields1 = c.getFields();     //获取所有 public属性 数组，包括继承而来的属性。
        for(Field field : fields1){
            System.out.println(field.getName());        //获取属性名，这里并不能输出全部属性，只能输出访问修饰符为 public 的属性。如： num3、NUM、name 。
        }

        Field[] fields2 = c.getDeclaredFields();     //获取所有 本类自己声明的属性 数组，不包括继承而来的属性。
        for(Field field : fields2){
            System.out.println(field.getName());        //获取属性名，这里可以输出： num2、num3、num4 。
        }

        Field f1 = c.getField("num3");      //获取 public属性，包括继承而来的属性。
        Field f2 = c.getDeclaredField("num2");           //获取 本类自己声明的属性，不包括继承而来的属性。
    }
}

interface Interface1{
    int NUM = 10;
}

class Class1{
    int num1;
    public String name;
}

class MyClass extends Class1 implements Interface1{
    int num2;
    public int num3;
    private int num4;
}