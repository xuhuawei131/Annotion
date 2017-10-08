package com.ann.sql.interfaces;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/1/9 0009.
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String tableName() default "name";
    String desc() default "haha";
    String author()  default "nihao";
    int age() default 18;
}
