package org.github.caishijun.generics;

public class TestWrapperUtilTest007 {
    public static void main(String[] args) {
        ObjectWrapperTest007<Object> w1 = new ObjectWrapperTest007<>("hello");
        ObjectWrapperTest007<Integer> w2 = new ObjectWrapperTest007<>(100);

        WrapperUtilTest007.printObject(w1);
        //WrapperUtilTest007.printObject(w2);     因为 ObjectWrapperTest007<Integer> 不能转型为 ObjectWrapperTest007<Object> 所以该方法会报错，w2 无法传入。
        WrapperUtilTest007.print(w2);       //

    }
}
