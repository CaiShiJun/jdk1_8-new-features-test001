package org.github.caishijun.lambda.test001;

public class SumDemo001 {

    //累加数组中的元素
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
    public static int add4(int[] nums,Policy policy){
        int r = 0;
        for (int num : nums){
            if(policy.test(num)){
                r += num;
            }
        }
        return  r;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};

        //使用策略模式来优化累加方法
        int r1 = add4(nums, new Policy() {
            @Override
            public boolean test(int num) {
                return num%2 == 0;
            }
        });
        System.out.println(r1);

        //使用 lambda 表达式实现上述逻辑
        int r2 = add4(nums, (num) -> num%2 == 0);
        System.out.println(r2);
    }
}

//使用策略模式来优化累加方法
interface Policy{
    boolean test(int num);
}