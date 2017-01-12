package com.ann.sql;

import com.ann.sql.interfaces.Column;
import com.ann.sql.interfaces.Table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/1/11 0011.
 */
public class OrmLiteDemo {

    public static void main(String args[]) {
        Filter filter1 = new Filter();
        filter1.setId(10);//查询id为10的用户

        Filter filter2 = new Filter();
        filter2.setUserName("lucy");//模糊查询用户名为lucy的用户

        Filter filter3 = new Filter();
        filter3.setEmail("liuhui@126.com,zh@163.com,7777@qq.com");//查询邮箱为其中任意一个的用户


        String sql1 = querry(filter1);
        String sql2 = querry(filter2);
        String sql3 = querry(filter3);

        System.out.println("sql1 " + sql1);
        System.out.println("sql2 " + sql2);
        System.out.println("sql3 " + sql3);
    }

    private static String querry(Filter filter) {
        StringBuilder sb = new StringBuilder();
        Class c = filter.getClass();
        boolean isExist = c.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }
        Table table = (Table) c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1 ");
        Field[] fArray = c.getDeclaredFields();
        for (Field field : fArray) {
            boolean isMExist = field.isAnnotationPresent(Column.class);
            if (isMExist) {
                Column column = field.getAnnotation(Column.class);
                String columnName = column.value();//拿到字段名
                String fieldName = columnName;
//               String fieldName = field.getName();
                Object fieldValue = null;
                try {
                    field.setAccessible(true);
                    fieldValue = field.get(filter);
                } catch (Exception e) {

                }
                //或者先用下面 的方式 访问数据 通过数据的 get方法获取数据值
//                String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
//                Object fieldValue=null;
//                try {
//                    Method getMethod = c.getMethod(getMethodName);
//                    fieldValue=getMethod.invoke(filter);
//                } catch (Exception e) {
//                }
                if (fieldValue == null || (fieldValue instanceof Integer && (Integer) fieldValue == 0)) {
                    continue;
                }
                sb.append(" and ").append(fieldName);

                if (fieldValue instanceof String) {
                    String strValue = (String) fieldValue;
                    if (strValue.contains(",")) {
                        String[] strValues = strValue.split(",");
                        sb.append(" in(");
                        for (String item : strValues) {
                            sb.append("'").append(item).append("',");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append(")");
                    } else {
                        sb.append("=").append("'").append(fieldValue).append("'");
                    }
                } else if (fieldValue instanceof Integer) {
                    sb.append("=").append(fieldValue);
                }
            }
        }
        return sb.toString();
    }

}
