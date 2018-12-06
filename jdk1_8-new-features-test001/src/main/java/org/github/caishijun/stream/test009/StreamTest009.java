package org.github.caishijun.stream.test009;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

5）收集结果
 */
public class StreamTest009 {

    private Student009[] students;

    @Before
    public void init(){
        students = new Student009[100];
        for (int i=0;i<30;i++){
            Student009 student = new Student009("user",i);
            students[i] = student;
        }
        for (int i=30;i<60;i++){
            Student009 student = new Student009("user"+i,i);
            students[i] = student;
        }
        for (int i=60;i<100;i++){
            Student009 student = new Student009("user"+i,i);
            students[i] = student;
        }
    }

    @Test
    public void testCollect1(){
        /**
         * 生成List
         */
        List<Student009> list = Arrays.stream(students).collect(toList());
        list.forEach((x)-> System.out.println(x));
        /**
         * 生成Set
         */
        Set<Student009> set = Arrays.stream(students).collect(toSet());
        set.forEach((x)-> System.out.println(x));
        /**
         * 如果包含相同的key，则需要提供第三个参数，否则报错
         */
        Map<String,Integer> map = Arrays.stream(students).collect(toMap(Student009::getName,Student009::getScore,(s, a)->s+a));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * 生成数组
     */
    @Test
    public void testCollect2(){
        Student009[] s = Arrays.stream(students).toArray(Student009[]::new);
        for (int i=0;i<s.length;i++)
            System.out.println(s[i]);
    }

    /**
     * 指定生成的类型
     */
    @Test
    public void testCollect3(){
        HashSet<Student009> s = Arrays.stream(students).collect(toCollection(HashSet::new));
        s.forEach(System.out::println);
    }

    /**
     * 统计
     */
    @Test
    public void testCollect4(){
        IntSummaryStatistics summaryStatistics = Arrays.stream(students).collect(Collectors.summarizingInt(Student009::getScore));
        System.out.println("getAverage->"+summaryStatistics.getAverage());
        System.out.println("getMax->"+summaryStatistics.getMax());
        System.out.println("getMin->"+summaryStatistics.getMin());
        System.out.println("getCount->"+summaryStatistics.getCount());
        System.out.println("getSum->"+summaryStatistics.getSum());
    }
}


class Student009 {
    private String name;
    private Integer score;

    public Student009(String name, Integer score) {
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
        return "Student009{" +
            "name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}