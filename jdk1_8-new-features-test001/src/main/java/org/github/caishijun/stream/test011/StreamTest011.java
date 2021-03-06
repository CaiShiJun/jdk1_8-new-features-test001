package org.github.caishijun.stream.test011;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

5.原始类型流
在数据量比较大的情况下，将基本数据类型（int,double...）包装成相应对象流的做法是低效的，因此，我们也可以直接将数据初始化为原始类型流，在原始类型流上的操作与对象流类似，我们只需要记住两点
1.原始类型流的初始化
2.原始类型流与流对象的转换

 */
public class StreamTest011 {

    private DoubleStream doubleStream;
    private IntStream intStream;

    /**
     * 原始类型流的初始化
     */
    @Before
    public void testStream1(){

        doubleStream = DoubleStream.of(0.1,0.2,0.3,0.8);
        intStream = IntStream.of(1,3,5,7,9);
        IntStream stream1 = IntStream.rangeClosed(0,100);
        IntStream stream2 = IntStream.range(0,100);
    }

    /**
     * 流与原始类型流的转换
     */
    @Test
    public void testStream2(){
        Stream<Double> stream = doubleStream.boxed();
        doubleStream = stream.mapToDouble(Double::new);
    }

}
