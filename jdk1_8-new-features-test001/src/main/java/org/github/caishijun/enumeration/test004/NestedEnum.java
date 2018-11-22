package org.github.caishijun.enumeration.test004;

public class NestedEnum {
    /*
    枚举可以作为内部类声明。调用方式为：在外部类中 NestedEnum.Gender.FEMALE 。
    也就是说当枚举被作为内部类声明时默认为静态的。
     */
    enum Gender{
        MALE,FEMALE
    }
}

interface InterfaceTest001{
    void m();
}

enum Enum2Test001 implements InterfaceTest001{
    /*
        当类中有方法的时候，即使没有声明枚举实例，也应当保留分号;
     */
    ;

    @Override
    public void m() {

    }
}


