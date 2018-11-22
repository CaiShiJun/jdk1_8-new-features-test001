package org.github.caishijun.enumeration.test003;

public enum Season001 {
    SPRING,SUMMER,AUTUMN,WINTER;

    public String name;

    private Season001(){       //在枚举类中的构造方法只允许使用 private 访问修饰符。
    }

    public String getName(){
        return this.name;
    }
}
