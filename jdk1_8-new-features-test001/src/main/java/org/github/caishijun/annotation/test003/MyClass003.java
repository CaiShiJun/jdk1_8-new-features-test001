package org.github.caishijun.annotation.test003;

import org.github.caishijun.annotation.test001.Annotation001;

import java.lang.annotation.Annotation;

public class MyClass003 implements Annotation001 {
    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
