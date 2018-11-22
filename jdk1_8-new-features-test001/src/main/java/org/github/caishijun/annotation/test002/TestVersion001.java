package org.github.caishijun.annotation.test002;

import org.github.caishijun.enumeration.test003.Season002;

@Version(
        big = 1,
        small = 0,
        name = "Tom",
        c = Integer.class,
        override = @Override,
        enumTest = Season002.SUMMER,
        nums = {9, 8, 7, 6},
        ss = {Season002.SPRING,Season002.AUTUMN,Season002.SUMMER,Season002.WINTER}      //如果数组只有一个元素可以省略大括号。
        )
public class TestVersion001 {
    public static void main(String[] args) {

    }
}
