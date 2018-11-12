package org.github.caishijun.generics;

/**
 *  通过定义一个包装类，可以持有任意数据类型
 */
class WrapperTest001{
    private Object data;

    public WrapperTest001(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class NoGenericsDemoTest001 {

    public static void main(String[]  args){
        WrapperTest001 w1 = new WrapperTest001("One");
        WrapperTest001 w2 = new WrapperTest001(new Integer(100));
        WrapperTest001 w3 = new WrapperTest001(200);

        Object d1 = (String)w1.getData();
        Integer d2 = (Integer) w1.getData();        //这里会发生 java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer 。
        //如果不使用泛型很容易出现类型转换错误。
    }

}
