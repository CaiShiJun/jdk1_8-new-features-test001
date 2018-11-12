package org.github.caishijun.generics;

public class ObjectWrapperTest007<T> {
    private T data;

    public ObjectWrapperTest007(T data){
        this.data = data;
    }

    public T get(){
        return data;
    }
}
