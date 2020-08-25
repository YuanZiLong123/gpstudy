package com.yzl.converter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.PropertyEditor;

/**
 * @author admin
 * @date 2020-08-25 10:13
 */
public class PropertiesEditorDemo {

    public static void main(String[] args) {
        // 模拟 Spring Framework 操作
        // 有一段文本 address = wuhan
        //                description = the centre city of hubei province;
        String text = "address = wuhan\n" +
                "                description = the centre city of hubei province";

        PropertyEditor propertyEditor = new StringToPropertiesPropertyEditor();
        // 传递 String 类型的内容
        propertyEditor.setAsText(text);

        System.out.println(propertyEditor.getValue());

        System.out.println(propertyEditor.getAsText());
    }
}
