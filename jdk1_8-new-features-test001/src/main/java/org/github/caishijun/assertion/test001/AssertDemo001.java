package org.github.caishijun.assertion.test001;

public class AssertDemo001 {
    public static void main(String[] args) {
        int num = 10;
        // 对于 assert 断言关键字，在 Java 使用它的时候，默认是禁用的。如果要使用断言就要使用 java 命令启用断言。

        // assert 断言的条件如果是 true 则程序就会自动往下执行；如果是 false 程序就会中断。
        assert num == 10;
        assert num == 15 : "断言条件结果为 false 情况下输出的描述字符串";
        System.out.println("AssertDemo001---");
    }
}
