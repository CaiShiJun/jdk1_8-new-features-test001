package org.github.caishijun.stream.test010;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toSet;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

6）分组和分片
分组和分片的意义是，将collect的结果集展示位Map<key,val>的形式，通常的用法如下：
 */
public class StreamTest010 {

    private Student010[] students;

    @Before
    public void init(){
        students = new Student010[100];
        for (int i=0;i<30;i++){
            Student010 student = new Student010("user1",i);
            students[i] = student;
        }
        for (int i=30;i<60;i++){
            Student010 student = new Student010("user2",i);
            students[i] = student;
        }
        for (int i=60;i<100;i++){
            Student010 student = new Student010("user3",i);
            students[i] = student;
        }
    }

    @Test
    public void testGroupBy1(){
        Map<String,List<Student010>> map = Arrays.stream(students).collect(groupingBy(Student010::getName));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * 如果只有两类，使用partitioningBy会比groupingBy更有效率
     */
    @Test
    public void testPartitioningBy(){
        Map<Boolean,List<Student010>> map = Arrays.stream(students).collect(partitioningBy(x->x.getScore()>50));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * downstream指定类型
     */
    @Test
    public void testGroupBy2(){
        Map<String,Set<Student010>> map = Arrays.stream(students).collect(groupingBy(Student010::getName,toSet()));
        map.forEach((x,y)-> System.out.println(x+"->"+y));
    }

    /**
     * downstream 聚合操作
     */
    @Test
    public void testGroupBy3(){
        /**
         * counting
         */
        Map<String,Long> map1 = Arrays.stream(students).collect(groupingBy(Student010::getName,counting()));
        map1.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * summingInt
         */
        Map<String,Integer> map2 = Arrays.stream(students).collect(groupingBy(Student010::getName,summingInt(Student010::getScore)));
        map2.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * maxBy
         */
        Map<String,Optional<Student010>> map3 = Arrays.stream(students).collect(groupingBy(Student010::getName,maxBy(Comparator.comparing(Student010::getScore))));
        map3.forEach((x,y)-> System.out.println(x+"->"+y));
        /**
         * mapping
         */
        Map<String,Set<Integer>> map4 = Arrays.stream(students).collect(groupingBy(Student010::getName,mapping(Student010::getScore,toSet())));
        map4.forEach((x,y)-> System.out.println(x+"->"+y));
    }

}


class Student010 {
    private String name;
    private Integer score;

    public Student010(String name, Integer score) {
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

