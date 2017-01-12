package com.ann.test;
/**
 * Created by Administrator on 2017/1/9 0009.
 */
@Description(tableName="Xuhuawei")
public class Child implements People {
    @Override
    @Description(desc="name")
    public String name() {
        return null;
    }

    @Override
    @Description(age=10)
    public int age() {
        return 0;
    }

    @Override
    @Description(author="majinfeng")
    public void sing() {

    }
}
