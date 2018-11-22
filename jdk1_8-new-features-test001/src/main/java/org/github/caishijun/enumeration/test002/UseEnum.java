package org.github.caishijun.enumeration.test002;

enum Gender{
    MALE,FEMALE;        //如果后面没有其他的语句，句尾的分号;可以省略
}

public class UseEnum {
    public static String getGender(Gender g){
        switch(g){          //如果传入的参数为 null 会在 switch(null) 抛出空指针异常 ，所以应当在 switch 语句之前判空并做处理。
            case MALE:
                return "MALE";
            case FEMALE:
                return "FEMALE";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        /*
            1、可以声明变量，但不可实例化。enum 不能 new ,枚举的实例已经在枚举声明的时候确定好了。
            2、只能将其有效实例为该变量赋值。
         */
        Gender gender = Gender.MALE;
        Gender[] genders = Gender.values();    //获得枚举中的所有实例数组。
        for (Gender genderTemp : genders){
            System.out.println(genderTemp.ordinal());       //获得枚举对象的序号
            System.out.println(genderTemp.name());      //获得枚举对象的名字
        }
        Gender gendervalueOfMale = Gender.valueOf("MALE");      //通过枚举声明字符串获得枚举实例

        System.out.println(getGender(gendervalueOfMale));
        System.out.println(getGender(Gender.FEMALE));
    }

}
