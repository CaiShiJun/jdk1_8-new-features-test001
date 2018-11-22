package org.github.caishijun.gc.test001;

public class GCDemo001 {
    public static void main(String[] args) {
        long m1;        //当前可用内存
        long m2;
        long m3;

        Runtime runtime = Runtime.getRuntime();
        for (int i = 0; i < 3; i++) {
            m1 = runtime.freeMemory();      //获取当前可用内存
            createObjects(2000);
            m2 = runtime.freeMemory();
            System.gc();
            m3 = runtime.freeMemory();

            System.out.println("m1:"+m1);
            System.out.println("m2:"+m2);
            System.out.println("m3:"+m3);
            System.out.println("Recovery of memory:"+(m3-m2));
        }
    }

    public static void createObjects(int num) {
        for (int i = 0; i < num; i++) {
            new Object();       //创建没有引用的垃圾对象
        }
    }
}
