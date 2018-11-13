package org.github.caishijun.reflection.test001;

public class ReflectionDemoTest001 {

    static void create1(){
        new User();
    }

    static void create2(){
        Class<User> c = User.class;     //java5之前会执行 User 中的 static 代码块。java 1.5 以上版本不会在加载类的时候执行 User 中的 static 代码块
    }

    static void create3(){
        try {
            //Class c1 = Class.forName("User");        //抛出 ClassNotFoundException 找不到
            //Class c2 = Class.forName("org.github.caishijun.reflection.test001.User");        //加载类的时候执行 User 中的 static 代码块
            //Class c3 = Class.forName("org.github.caishijun.reflection.test001.User",true,ReflectionDemoTest001.class.getClassLoader());      //加载类的时候执行 User 中的 static 代码块
            Class c3 = Class.forName("org.github.caishijun.reflection.test001.User",false,ReflectionDemoTest001.class.getClassLoader());      //加载类的时候不会执行 User 中的 static 代码块
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {

        //1、类的 class 静态属性（字面量）。
        Class<String> c = String.class;

        //2、实例的 getClass() 方法。
        String s = "";
        Class<?> c1 = s.getClass();
        Class c2 = s.getClass();

        //3、使用其静态方法 forName() 方法。
        Class<?> c3 = Class.forName("java.lang.String");
        Class c4 = Class.forName("java.lang.String");

        //create1();
        //create2();
        //create3();

        System.out.println("int.class==Integer.TYPE?  " + (int.class==Integer.TYPE));
    }
}

class User{
    static {
        System.out.println("User init ...");
    }
}