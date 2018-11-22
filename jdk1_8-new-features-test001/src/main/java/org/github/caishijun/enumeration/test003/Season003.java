package org.github.caishijun.enumeration.test003;

public enum Season003 {
    SPRING("spring"){
        /*
        这里可以理解为 Season003 里面有一个匿名内部类，该匿名内部类中。
        使用的方法就是在枚举类中声明一个抽象方法，
        这样枚举类中每一个枚举实例都必须实现该抽象方法，
        就可以实现不同枚举实例实现不同的方法。
         */
        @Override
        public void m2() {

        }
    },SUMMER("summer"){
        @Override
        public void m2() {

        }
    },AUTUMN("autumn"){
        @Override
        public void m2() {

        }
    },WINTER("winter"){
        @Override
        public void m2() {

        }
    };

    public abstract void m2();

    public String name;

    private Season003(String name){       //在枚举类中的构造方法只允许使用 private 访问修饰符。
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

class TestSeason003{
    public static void main(String[] args) {
        Season003 seasonSpring = Season003.SPRING;
        String seasonSpring003Str = seasonSpring.getName();
        System.out.println(seasonSpring003Str);

        seasonSpring.m2();

        Season003 seasonSummer = Season003.SUMMER;
        System.out.println(seasonSpring == seasonSummer);
        System.out.println(seasonSpring.equals(seasonSummer));

        Season003 seasonSummer1 = Season003.SUMMER;
        System.out.println(seasonSummer == seasonSummer1);
        System.out.println(seasonSummer.equals(seasonSummer1));

    }
}
