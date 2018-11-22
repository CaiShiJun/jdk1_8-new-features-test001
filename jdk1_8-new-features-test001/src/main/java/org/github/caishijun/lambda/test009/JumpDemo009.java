package org.github.caishijun.lambda.test009;

import java.util.function.Consumer;

public class JumpDemo009 {

    public static void main(String[] args) {
        Consumer<int[]> c = ids -> {
            int count = 0;
            for (int id : ids) {
                if (id % 2 == 0) {
                    System.out.println(id);
                    count++;
                    continue;
                }
                if (count == 3) {
                    break;
                }
            }
        };

        c.accept(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }
}