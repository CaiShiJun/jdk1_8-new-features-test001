package org.github.caishijun.stream.test002;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

2.stream的特性
我们首先列出stream的如下三点特性，在之后我们会对照着详细说明
1.stream不存储数据
2.stream不改变源数据
3.stream的延迟执行特性
通常我们在数组或集合的基础上创建stream，stream不会专门存储数据，对stream的操作也不会影响到创建它的数组和集合,对于stream的聚合、消费或收集操作只能进行一次，再次操作会报错，如下代码：
 */
public class StreamTest002 {

    private Random random;
    private List<Student002> stuList;

    @Before
    public void init() {
        random = new Random();
        stuList = new ArrayList<Student002>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student002("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    @Test
    public void test1(){
        Stream<String> stream = Stream.generate(()->"user").limit(20);
        stream.forEach(System.out::println);        //程序在正常完成一次打印工作后报错。
        stream.forEach(System.out::println);
    }


    /*
    stream的操作是延迟执行的，在列出班上超过85分的学生姓名例子中，在collect方法执行之前，filter、sorted、map方法还未执行，只有当collect方法执行时才会触发之前转换操作
看如下代码：

    我们将filter中的逻辑抽象成方法，在方法中加入打印逻辑，如果stream的转换操作是延迟执行的，那么split会先打印，否则后打印，代码运行结果为：
        split-------------------------------------
        begin compare
        begin compare
        begin compare
        begin compare
        begin compare

    可见stream的操作是延迟执行的。
     */
    @Test
    public void test2() {
        //Stream<Student002> stream = Stream.of(stuArr).filter(this::filter);
        Stream<Student002> stream = stuList.stream().filter(this::filter);
        System.out.println("split-------------------------------------");
        List<Student002> studentList = stream.collect(toList());
    }

    public boolean filter(Student002 s) {
        System.out.println("begin compare");
        return s.getScore() > 85;
    }
}

class Student002 {
    private String name;
    private Integer score;

    public Student002(String name, Integer score) {
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
}