package org.github.caishijun.stream.test001;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

列出班上分数超过85分的学生姓名，并按照分数降序输出用户名字，在java8之前我们需要三个步骤：
1）新建一个List<Student> newList，在for循环中遍历stuList，将分数超过85分的学生装入新的集合中
2）对于新的集合newList进行排序操作
3）遍历打印newList
这三个步骤在java8中只需要两条语句，如果紧紧需要打印，不需要保存新生产list的话实际上只需要一条，是不是非常方便。
 */
public class StreamTest001 {

    private Random random;
    private List<Student001> stuList;

    @Before
    public void init() {
        random = new Random();
        stuList = new ArrayList<Student001>() {
            {
                for (int i = 0; i < 100; i++) {
                    add(new Student001("student" + i, random.nextInt(50) + 50));
                }
            }
        };
    }

    //1列出班上超过85分的学生姓名，并按照分数降序输出用户名字
    @Test
    public void test1() {
        List<String> studentList = stuList.stream()
            .filter(x -> x.getScore() > 85)
            .sorted(Comparator.comparing(Student001::getScore).reversed())
            .map(Student001::getName)
            .collect(Collectors.toList());
        System.out.println(studentList);
    }
}

class Student001 {
    private String name;
    private Integer score;

    public Student001(String name, Integer score) {
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