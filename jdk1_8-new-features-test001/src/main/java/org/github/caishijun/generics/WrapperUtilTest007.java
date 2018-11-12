package org.github.caishijun.generics;

public class WrapperUtilTest007 {

    public static void printObject(ObjectWrapperTest007<Object> wrapper){

    }

    public static void print(ObjectWrapperTest007<?> wrapper){

    }

    public static void getValue(ObjectWrapperTest007<? extends Number> wrapper){
        int v = wrapper.get().intValue();
    }
}
