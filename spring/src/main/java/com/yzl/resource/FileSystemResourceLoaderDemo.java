package com.yzl.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author admin
 * @date 2020-08-19 9:28
 */
public class FileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        String loaderPath =  System.getProperty("user.dir")+"\\spring\\src\\main\\java\\com\\yzl\\resource\\FileSystemResourceLoaderDemo.java";
        FileSystemResourceLoader fileSystemResourceLoader = new FileSystemResourceLoader();

        Resource resource = fileSystemResourceLoader.getResource(loaderPath);

        EncodedResource encodedResource  = new EncodedResource(resource, "UTF-8");

        try(Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }


    }

}
