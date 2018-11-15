package org.github.caishijun.reflection.test008;

import java.lang.reflect.*;

class Bird<T>{
    void m(T t){
        System.out.println(t);
    }
}

public class TestReflection {

    Bird<String> b1 = new Bird<>();
    Bird<? extends Integer> b2 = new Bird<>();

    <V> void m(){

    }

    Bird<String>[] bs = new Bird[10];

    public static void main(String[] args) throws Exception {
        Class<TestReflection> c = TestReflection.class;
        Field f1 = c.getDeclaredField("b1");

        String  f1TypeName = f1.getType().getName();
        System.out.println("f1TypeName："+f1TypeName);       //原生类型：org.github.caishijun.reflection.test008.Bird

        String  f1GenericTypeName1 = f1.getGenericType().getTypeName();
        System.out.println("f1GenericTypeName1："+f1GenericTypeName1);     //泛型类型：org.github.caishijun.reflection.test008.Bird<java.lang.String>

        if(f1.getGenericType() instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType)f1.getGenericType();
            String  f1AtualTypeArguments = p.getActualTypeArguments()[0].getTypeName();
            System.out.println("f1AtualTypeArguments："+f1AtualTypeArguments);       //f1AtualTypeArguments：java.lang.String
        }

        System.out.println("******************************************************************");
        Field f2 = c.getDeclaredField("b2");
        if(f2.getGenericType() instanceof ParameterizedType){
            ParameterizedType p = (ParameterizedType)f2.getGenericType();
            String  f2AtualTypeArguments = p.getActualTypeArguments()[0].getTypeName();
            System.out.println("f2AtualTypeArguments："+f2AtualTypeArguments);       //f2AtualTypeArguments：? extends java.lang.Integer
            if (p.getActualTypeArguments()[0] instanceof WildcardType){
                WildcardType w = (WildcardType) p.getActualTypeArguments()[0];
                String f2UpperBoundsTypeName = w.getUpperBounds()[0].getTypeName();
                System.out.println("f2UpperBoundsTypeName："+f2UpperBoundsTypeName);     //f2UpperBoundsTypeName：java.lang.Integer
            }
        }

        System.out.println("******************************************************************");
        Method m = c.getDeclaredMethod("m");
        TypeVariable<Method> methodTypeVariable = m.getTypeParameters()[0];
        System.out.println("methodTypeVariable："+methodTypeVariable.getName());     //methodTypeVariable：V

        System.out.println("******************************************************************");
        Field f3 = c.getDeclaredField("bs");
        if(f3.getGenericType() instanceof GenericArrayType){
            String genericArrayComponentTypeName = ((GenericArrayType) f3.getGenericType()).getGenericComponentType().getTypeName();
            System.out.println("genericArrayComponentTypeName："+genericArrayComponentTypeName);     //genericArrayComponentTypeName：org.github.caishijun.reflection.test008.Bird<java.lang.String>
        }

        System.out.println("******************************************************************");
        Bird<String> b1 = new Bird<>();
        b1.m("abc");
        //b1.m(111);

        Class<?> c2 = b1.getClass();
        Method m2 = c2.getDeclaredMethod("m",Object.class);
        m2.invoke(b1,"efg");
        m2.invoke(b1,111);

    }
}
