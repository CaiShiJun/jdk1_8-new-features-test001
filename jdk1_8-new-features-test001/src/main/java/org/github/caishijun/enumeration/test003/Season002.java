package org.github.caishijun.enumeration.test003;

public enum Season002 {
    SPRING("spring"),SUMMER("summer"),AUTUMN("autumn"),WINTER("winter");

    public String name;

    private Season002(String name){       //在枚举类中的构造方法只允许使用 private 访问修饰符。
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class TestSeason002{
    public static void main(String[] args) {
        Season002 season002 = Season002.SPRING;
        String season002Str = season002.getName();
        System.out.println(season002Str);
    }
}
