package org.github.caishijun.annotation.test004;

public @interface Annotation004 {
    String[] value() default {"a","b","c"};

    int num() default 1;
}
