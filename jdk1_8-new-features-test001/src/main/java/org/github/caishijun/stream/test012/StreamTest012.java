package org.github.caishijun.stream.test012;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

6.并行流
可以将普通顺序执行的流转变为并行流，只需要调用顺序流的parallel() 方法即可，如Stream.iterate(1, x -> x + 1).limit(10).parallel()。
1） 并行流的执行顺序
我们调用peek方法来瞧瞧并行流和串行流的执行顺序，peek方法顾名思义，就是偷窥流内的数据，peek方法声明为Stream<T> peek(Consumer<? super T> action);加入打印程序可以观察到通过流内数据，见如下代码：
 */
public class StreamTest012 {

    public void peek1(int x) {
        System.out.println(Thread.currentThread().getName() + ":->peek1->" + x);
    }

    public void peek2(int x) {
        System.out.println(Thread.currentThread().getName() + ":->peek2->" + x);
    }

    public void peek3(int x) {
        System.out.println(Thread.currentThread().getName() + ":->final result->" + x);
    }

    /**
     * peek，监控方法
     * 串行流和并行流的执行顺序
     */
    @Test
    public void testPeek() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(10);       //串行流
        stream.peek(this::peek1).filter(x -> x > 5)
            .peek(this::peek2).filter(x -> x < 8)
            .peek(this::peek3)
            .forEach(System.out::println);
    }

    @Test
    public void testPeekPal() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1).limit(10).parallel();        //并行流
        stream.peek(this::peek1).filter(x -> x > 5)
            .peek(this::peek2).filter(x -> x < 8)
            .peek(this::peek3)
            .forEach(System.out::println);
    }
    /*
        我们将stream.filter(x -> x > 5).filter(x -> x < 8).forEach(System.out::println)的过程想象成上图的管道，我们在管道上加入的peek相当于一个阀门，透过这个阀门查看流经的数据，
            1）当我们使用顺序流时，数据按照源数据的顺序依次通过管道，当一个数据被filter过滤，或者经过整个管道而输出后，第二个数据才会开始重复这一过程
            2）当我们使用并行流时，系统除了主线程外启动了七个线程（我的电脑是4核八线程）来执行处理任务，因此执行是无序的，但同一个线程内处理的数据是按顺序进行的。
            2） sorted()、distinct()等对并行流的影响
            sorted()、distinct()是元素相关方法，和整体的数据是有关系的,map，filter等方法和已经通过的元素是不相关的,不需要知道流里面有哪些元素 ，并行执行和sorted会不会产生冲突呢？
        结论：   1.并行流和排序是不冲突的，
                2.一个流是否是有序的，对于一些api可能会提高执行效率，对于另一些api可能会降低执行效率
                3.如果想要输出的结果是有序的，对于并行的流需要使用forEachOrdered(forEach的输出效率更高)
        我们做如下实验：
     */

    private List<Integer> list;

    /**
     * 生成一亿条0-100之间的记录
     */
    @Before
    public void init() {
        Random random = new Random();
        list = Stream.generate(() -> random.nextInt(100)).limit(100000000).collect(toList());
    }

    /**
     * tip
     */
    @Test
    public void test1() {
        long begin1 = System.currentTimeMillis();
        list.stream().filter(x->(x > 10)).filter(x->x<80).count();
        long end1 = System.currentTimeMillis();
        System.out.println(end1-begin1);
        list.stream().parallel().filter(x->(x > 10)).filter(x->x<80).count();
        long end2 = System.currentTimeMillis();
        System.out.println(end2-end1);

        long begin1_ = System.currentTimeMillis();
        list.stream().filter(x->(x > 10)).filter(x->x<80).distinct().sorted().count();
        long end1_ = System.currentTimeMillis();
        System.out.println(end1-begin1);
        list.stream().parallel().filter(x->(x > 10)).filter(x->x<80).distinct().sorted().count();
        long end2_ = System.currentTimeMillis();
        System.out.println(end2_-end1_);

        /*
        可见，对于串行流.distinct().sorted()方法对于运行时间没有影响，
        但是对于并行流，会使得运行时间大大增加，因此对于包含sorted、distinct()等与全局数据相关的操作，不推荐使用并行流。
         */
    }

}
