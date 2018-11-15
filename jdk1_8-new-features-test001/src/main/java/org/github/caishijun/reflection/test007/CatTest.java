package org.github.caishijun.reflection.test007;

import java.lang.reflect.Array;

public class CatTest {
    public static void main(String[] args) {
        Class<Cat> c = Cat.class;
        Cat[] cats = (Cat[]) Array.newInstance(Cat.class,10);       //Array.newInstance(数组的元素类型class,数组长度);
        System.out.println("cats.length"+cats.length);
        cats[0] = new Cat();

        int[] nums1 = (int[]) Array.newInstance(int.class,5);
        //Integer[] nums2 = (Integer[]) Array.newInstance(int.class,5);       //会抛出类转换异常
        System.out.println(new String[10]);

        //创建一个3行5列的多维数组
        int[][] nums3 = (int[][]) Array.newInstance(int.class,3,5);        //Array.newInstance(数组的元素类型class,维度); 用于创建多维数组

        int[] nums4 = (int[]) Array.newInstance(int.class,5);
        //设置数组元素
        Array.set(nums4,0,10);        //set(被操作数组,被操作元素索引,设置值);
        Array.set(nums4,1,20);        //set(被操作数组,被操作元素索引,设置值);
        Array.set(nums4,2,30);        //set(被操作数组,被操作元素索引,设置值);
        Array.set(nums4,3,40);        //set(被操作数组,被操作元素索引,设置值);
        Array.set(nums4,4,50);        //set(被操作数组,被操作元素索引,设置值);
        //获取数组元素
        int element1 = (int) Array.get(nums4,3);        //get(被操作数组,被操作元素索引);
        System.out.println("element1："+element1);
        //判断一个对象是不是数组
        boolean isArray = nums4.getClass().isArray();
        if(isArray){
            String arrayElementClassName = cats.getClass().getComponentType().getName();
            System.out.println("arrayElementClassName："+arrayElementClassName);
        }
    }
}
