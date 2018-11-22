package org.github.caishijun.annotation.test002;

import org.github.caishijun.enumeration.test003.Season002;

public @interface Version {
    int big();      //看起来是一个抽象方法声明，但其实它是一个属性，它的类型是 int ，名称是 big 。
    //int big(int num);     //会报错，注解的属性不能有参数
    int small();

    String name() default "";
    Class c() default String.class;
    Override override() default @Override;
    Season002 enumTest() default Season002.SPRING;
    int[] nums() default {1,2,3,4,5};
    Season002[] ss();
}
