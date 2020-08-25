package com.yzl.api;


import com.yzl.protocol.HttpRequestModel;
import com.yzl.protocol.HttpResponseModel;

/**
 * @author admin
 * @date 2020-05-25 16:01
 */
public interface IRpcService {


    HttpResponseModel doMethod(HttpRequestModel requestModel);

}
