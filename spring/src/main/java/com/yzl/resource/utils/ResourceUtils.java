package com.yzl.resource.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @author admin
 * @date 2020-08-19 10:38
 */
public interface ResourceUtils {

    static String getContent(Resource resource){
      return   getContentByEncoded(resource, "UTF-8");
    }

    static String getContentByEncoded(Resource resource,String charset)  {
        EncodedResource encodedResource = new EncodedResource(resource, charset);

        try (Reader reader = encodedResource.getReader()){
          return   IOUtils.toString(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
}
