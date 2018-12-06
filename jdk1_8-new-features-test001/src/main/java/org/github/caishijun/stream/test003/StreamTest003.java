package org.github.caishijun.stream.test003;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/*
来源网址：https://www.cnblogs.com/andywithu/p/7404101.html

TIP：
当我们操作一个流的时候，并不会修改流底层的集合（即使集合是线程安全的），如果想要修改原有的集合，就无法定义流操作的输出。
由于stream的延迟执行特性，在聚合操作执行前修改数据源是允许的。
 */
public class StreamTest003 {

    List<String> wordList;

    @Before
    public void init() {
        wordList = new ArrayList<String>() {
            {
                add("a");
                add("b");
                add("c");
                add("d");
                add("e");
                add("f");
                add("g");
            }
        };
    }

    /**
     * 延迟执行特性，在聚合操作之前都可以添加相应元素
     */
    @Test
    public void test1() {
        Stream<String> words = wordList.stream();
        wordList.add("END");
        long n = words.distinct().count();
        System.out.println(n);  //最后打印的结果是8
    }


    /**
     * 如下代码是错误的
     * 延迟执行特性，会产生干扰
     * nullPointException
     */
    @Test
    public void test2(){
        Stream<String> words1 = wordList.stream();
        words1.forEach(s -> {
            System.out.println("s->"+s);
            if (s.length() < 4) {
                System.out.println("select->"+s);
                wordList.remove(s);
                System.out.println(wordList);       //结果报空指针异常
            }
        });
    }

}
