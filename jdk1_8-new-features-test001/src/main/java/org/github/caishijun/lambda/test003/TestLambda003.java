package org.github.caishijun.lambda.test003;

interface Divable{
    int div(int num1, int num2);
}

interface Divable1{
    String div(String num1, String num2);
}

interface Divable2{
    String div(String num1);
}

interface Divable3{
    void div();
}

public class TestLambda003 {
    public static void main(String[] args) {
        //匿名内部类写法
        Addable a1 = new Addable() {
            @Override
            public int add(int num1, int num2) {
                return 0;
            }
        };

        //lambda 表达式写法
        Addable a2 = (int num1, int num2) -> { return num1 + num2;};
        Divable d1 = (int num1, int num2) -> { return num1 + num2;};
        Divable d2 = (num1,num2) -> { return num1 + num2;};
        Divable1 d3 = (num1,num2) -> { return num1 + num2;};
        Divable1 d4 = (String num1, String num2) -> { return num1 + num2;};
        Divable2 d5 = (String msg) -> { return msg + "adc"; };
        Divable2 d6 = msg -> { return msg + "adc"; };
        Divable3 d7 = () -> { System.out.println("adc"); };
        Divable3 d8 = () ->  System.out.println("adc");
    }
}
