package com.yzl.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author admin
 * @date 2020-08-19 9:06
 */
public class EncodeResourceDemo {

    public static void main(String[] args) throws IOException {

        String filePath = System.getProperty("user.dir")+"\\spring\\src\\main\\java\\com\\yzl\\resource\\EncodeResourceDemo.java";

        FileSystemResource fileSystemResource = new FileSystemResource(filePath);

        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");


        try (Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }

    }

}
