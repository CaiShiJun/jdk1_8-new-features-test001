package org.github.caishijun.annotation.test006;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRun {
    public static void main(String[] args) {
        Class<TestAnnotation> c = TestAnnotation.class;
        Method[] ms = c.getDeclaredMethods();

        for(Method method : ms){
            Test t = method.getAnnotation(Test.class);  //获取该遍历到的方法的 @Test 注解。
            if(null != t){
                int num = t.num();      //获取 @Test 注解中的 num 属性值。
                System.out.println("@Test.num ："+num);
            }
            if(method.isAnnotationPresent(Test.class)){     //判断该遍历到的方法有没有被 Test 注解修饰。
                try {
                    method.invoke(c.newInstance());     //如果该遍历到的方法是被 Test 注解修饰，则通过反射获取实例并执行该方法。
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
