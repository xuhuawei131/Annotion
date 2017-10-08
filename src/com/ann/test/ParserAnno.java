package com.ann.test;

import com.ann.sql.interfaces.Description;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class ParserAnno {


    public static void main(String[] args) {
        try {
            Class c = Class.forName("Child");
            boolean isExit = c.isAnnotationPresent(Description.class);
            if (isExit) {
                Description d = (Description) c.getAnnotation(Description.class);
                System.out.println(d.age());
                System.out.println(d.tableName());
                System.out.println(d.author());
            }
            Method methods[] = c.getMethods();

            for (Method method : methods) {
                boolean isMExit = method.isAnnotationPresent(Description.class);
                if (isMExit) {
                    Description description = method.getAnnotation(Description.class);
                    System.out.println(description.author());
                }
            }
            System.out.println("---------------------");

            for (Method method : methods) {
                method.getParameterTypes();//参数类型
                method.getParameterCount();//参数数量

                Annotation[] as = method.getAnnotations();
                for (Annotation a : as) {
                    if (a instanceof Description) {
                        Description des = (Description) a;
                        System.out.println(des.author());
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
