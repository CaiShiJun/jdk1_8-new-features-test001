package org.github.caishijun.gc.test003;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

class BigObject{
    private long[] nums = new long[4096];

    private long id;

    public BigObject(long id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(id + "被回收");
    }
}

public class SoftRefDemo003 {

    public static void main(String[] args) {
        BigObject bigObject = new BigObject(0);
        /*
            1、软引用：
                a、当系统内存充足时和强引用没有太多区别，但内存不足时会回收软引用的对象。
         */
        SoftReference<BigObject> softReference = new SoftReference<>(bigObject);       //使用 java.lang.ref.SoftReference 来创建软引用。
        bigObject = null;      //如果不将 bigObject 变量赋值为 null ，则会因为 bigObject 实例同时存在着 softReference 的软引用和 BigObject bigObject = new BigObject(0); 的强引用，而无法被回收。

        List<BigObject> list = new ArrayList<>();
        long i = 1;
        while (true){
            list.add(new BigObject(i++));
        }
    }
}
