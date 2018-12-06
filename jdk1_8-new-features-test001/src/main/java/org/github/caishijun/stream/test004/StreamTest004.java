package org.github.caishijun.stream.test004;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

3.创建stream
1）通过数组创建
2）通过集合创建流
3）创建空的流
4）创建无限流
5）创建规律的无限流


Arrays.stream(studentArr)
Stream.of(1,2,34,5,65);
strs.stream();      //创建普通流
strs.parallelStream();      //创建并行流
Stream.empty();     //创建一个空的stream
Stream.generate(()->"number"+new Random().nextInt()).limit(100).forEach(System.out::println);   //创建无限流
Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);    //创建规律的无限流

 */
public class StreamTest004 {
    /**
     * 1）通过数组创建
     */
    @Test
    public void testArrayStream(){
        //1.通过Arrays.stream
        //1.1基本类型
        int[] arr = new int[]{1,2,34,5};
        IntStream intStream = Arrays.stream(arr);
        //1.2引用类型
        Student004[] studentArr = new Student004[]{new Student004("s1",29),new Student004("s2",27)};
        Stream<Student004> studentStream = Arrays.stream(studentArr);
        //2.通过Stream.of
        Stream<Integer> stream1 = Stream.of(1,2,34,5,65);
        //注意生成的是int[]的流
        Stream<int[]> stream2 = Stream.of(arr,arr);

        studentStream.forEach(System.out::println);
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
    }

    /**
     * 2）通过集合创建流
     */
    @Test
    public void testCollectionStream(){
        List<String> strs = Arrays.asList("11212","dfd","2323","dfhgf");
        //创建普通流
        Stream<String> stream  = strs.stream();
        //创建并行流
        Stream<String> stream1 = strs.parallelStream();
    }

    /**
     * 3）创建空的流
     */
    @Test
    public void testEmptyStream(){
        //创建一个空的stream
        Stream<Integer> stream  = Stream.empty();
    }

    /**
     * 4）创建无限流
     */
    @Test
    public void testUnlimitStream(){
        //创建无限流，通过limit提取指定大小
        Stream.generate(()->"number"+new Random().nextInt()).limit(100).forEach(System.out::println);
        Stream.generate(()->new Student004("name",10)).limit(20).forEach(System.out::println);
    }

    /**
     * 5）创建规律的无限流
     * 产生规律的数据
     */
    @Test
    public void testUnlimitStream1(){
        Stream.iterate(0,x->x+1).limit(10).forEach(System.out::println);
        Stream.iterate(0,x->x).limit(10).forEach(System.out::println);
        //Stream.iterate(0,x->x).limit(10).forEach(System.out::println);与如下代码意思是一样的
        Stream.iterate(0, UnaryOperator.identity()).limit(10).forEach(System.out::println);
    }
}

class Student004 {
    private String name;
    private Integer score;

    public Student004(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    //-----getters and setters-----
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student004{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}