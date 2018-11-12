package org.github.caishijun.generics;


/**
 *  通过定义一个包装类，可以持有任意数据类型
 */
class GenericWrapperTest002<T>{
    private T data;

    public GenericWrapperTest002(T data){
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

public class GenericsDemoTest002 {

    public static void main(String[]  args){

        GenericWrapperTest002<String> w1 = new GenericWrapperTest002<String>("One");
        String d1 = w1.getData();
    }
}
