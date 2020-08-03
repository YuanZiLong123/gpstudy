package dubbo.provide.impl;

import dubbo.api.IRpcService;
import dubbo.protocol.HttpRequestModel;
import dubbo.protocol.HttpResponseModel;

/**
 * @author admin
 * @date 2020-05-25 16:12
 */
public class IRpcServiceImpl implements IRpcService {
    @Override
    public HttpResponseModel doMethod(HttpRequestModel requestModel) {
       //do Server

        return null;
    }
}
