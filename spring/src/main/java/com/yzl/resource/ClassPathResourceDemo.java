package com.yzl.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author admin
 * @date 2020-08-19 9:19
 */
public class ClassPathResourceDemo {

    public static void main(String[] args) throws IOException {
        //String classPath = "META-INF\\spring\\user.properties";
        String classPath = "com\\yzl\\metadata\\users.xsd";
        ClassPathResource classPathResource =   new ClassPathResource(classPath);

        EncodedResource encodedResource = new EncodedResource(classPathResource, "UTF-8");

        try (Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }

    }

}


