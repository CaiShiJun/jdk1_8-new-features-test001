package org.github.caishijun.lambda.test006;

import java.util.function.Predicate;

public class SumDemo006 {

    //累加数组中的所有元素
    public static int add1(int[] nums){
        int r = 0;
        for (int num : nums){
            r += num;
        }
        return  r;
    }

    //累加数组中的偶数元素
    public static int add2(int[] nums){
        int r = 0;
        for (int num : nums){
            if(num%2==0){
                r += num;
            }
        }
        return  r;
    }

    //累加数组中的是3的倍数的元素
    public static int add3(int[] nums){
        int r = 0;
        for (int num : nums){
            if(num%2==0){
                r += num;
            }
        }
        return  r;
    }

    //使用策略模式来优化累加方法
    public static int add4(int[] nums, Predicate<Integer> p){
        int r = 0;
        for (int num : nums){
            if(p.test(num)){
                r += num;
            }
        }
        return  r;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        //累加数组中的所有元素
        int r1 = add4(nums,(num) -> true);
        System.out.println("r1 ："+r1);

        //累加数组中的偶数元素
        int r2 = add4(nums, (num) -> num%2 == 0);
        System.out.println("r2 ："+r2);

        //累加数组中的是3的倍数的元素
        int r3 = add4(nums, (num) -> num%3 == 0);       //add4(nums, (形式参数) -> 表达式);
        System.out.println("r3 ："+r3);
    }
}