package org.github.caishijun.stream.test008;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

4）Optional类型
通常聚合操作会返回一个Optional类型。
Optional表示一个安全的指定结果类型，
所谓的安全指的是避免直接调用返回类型的null值而造成空指针异常，
调用optional.ifPresent()可以判断返回值是否为空，
或者直接调用ifPresent(Consumer<? super T> consumer)在结果部位空时进行消费操作；
调用optional.get()获取返回值。
通常的使用方式如下：

Optional的创建
采用Optional.empty()创建一个空的Optional，
使用Optional.of()创建指定值的Optional。
同样也可以调用Optional对象的map方法进行Optional的转换，
调用flatMap方法进行Optional的迭代
 */
public class StreamTest008 {

    /**
     * 可以将 Optional 类型的对象元素添加进 List 中。
     */
    @Test
    public void testOptional() {
        List<String> list = new ArrayList<String>() {
            {
                add("user1");
                add("user2");
            }
        };
        Optional<String> opt = Optional.of("andy with u");
        opt.ifPresent(list::add);
        list.forEach(System.out::println);
    }

    /**
     * 使用Optional可以在没有值时指定一个返回值，例如
     */
    @Test
    public void testOptional2() {
        Integer[] arr = new Integer[]{4,5,6,7,8,9};
        Integer result = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElse(-1);
        System.out.println(result);
        Integer result1 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseGet(()->-1);
        System.out.println(result1);
        Integer result2 = Stream.of(arr).filter(x->x>9).max(Comparator.naturalOrder()).orElseThrow(RuntimeException::new);
        System.out.println(result2);
    }

    /**
     * Optional的创建
     * 采用Optional.empty()创建一个空的Optional，
     * 使用Optional.of()创建指定值的Optional。
     * 同样也可以调用Optional对象的map方法进行Optional的转换，
     * 调用flatMap方法进行Optional的迭代
     */
    @Test
    public void testStream1() {
        Optional<Student008> studentOptional = Optional.of(new Student008("user1",21));
        Optional<String> optionalStr = studentOptional.map(Student008::getName);
        System.out.println(optionalStr.get());
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

    /**
     * Optional的迭代
     */
    @Test
    public void testStream2() {
        double x = 4d;
        Optional<Double> result1 = inverse(x).flatMap(StreamTest008::squareRoot);
        result1.ifPresent(System.out::println);
        Optional<Double> result2 = Optional.of(4.0).flatMap(StreamTest008::inverse).flatMap(StreamTest008::squareRoot);
        result2.ifPresent(System.out::println);
    }
}


class Student008 {
    private String name;
    private Integer score;

    public Student008(String name, Integer score) {
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