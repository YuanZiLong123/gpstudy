package com.yzl.databinder;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author admin
 * @date 2020-08-25 9:33
 */
public class DataBinderDemo {

    public static void main(String[] args) {

        DataBinderPojo dataBinderPojo = new DataBinderPojo();

        DataBinder dataBinder = new DataBinder(dataBinderPojo);

        Map<String,Object> source= new HashMap<>();

        source.put("id", 1);

        source.put("name", "菜鸟");

        source.put("age", "30");

        source.put("dataBinderNestPojo.address","武汉");
        source.put("dataBinderNestPojo.description","湖北中心城市");

        //忽略不知道的属性字段
        // dataBinder.setIgnoreUnknownFields(false);


        //是否可以自动去生成嵌套类  默认为true
//        DataBinderNestPojo dataBinderNestPojo = new DataBinderNestPojo();
//        dataBinderNestPojo.setAddress("武汉");
//        dataBinderNestPojo.setDescription("湖北中心城市");
//        source.put("dataBinderNestPojo", dataBinderNestPojo);
//        dataBinder.setAutoGrowNestedPaths(false);



        PropertyValues propertyValues = new MutablePropertyValues(source);

        dataBinder.bind(propertyValues);



        System.out.println(dataBinderPojo);

        // 4. 获取绑定结果（结果包含错误文案 code，不会抛出异常）
        BindingResult result = dataBinder.getBindingResult();
        //System.out.println(result);

    }
}
