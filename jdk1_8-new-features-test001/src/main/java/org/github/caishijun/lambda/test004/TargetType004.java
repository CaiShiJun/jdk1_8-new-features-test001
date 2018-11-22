package org.github.caishijun.lambda.test004;

@FunctionalInterface
interface Interface1{
    void m(int num1,int num2);
}

@FunctionalInterface
interface Interface2{
    void m(int num1,int num2);
    //void m(String num1,String num2);
}

public class TargetType004 {

    static void test1(Interface1 i){

    }
    static void test1(Interface2 i){

    }

    static void test2(Interface2 i){

    }

    public static void main(String[] args) {
        Interface1 i1 = (num1,num2) -> System.out.println(num1+num2);
        Interface2 i2 = (num1,num2) -> System.out.println(num1+num2);

        test1((Interface2) (num1, num2) -> System.out.println(num1+num2));
        test2((num1,num2) -> System.out.println(num1+num2));
    }
}
