package dubbo.api;

import dubbo.protocol.HttpRequestModel;
import dubbo.protocol.HttpResponseModel;

/**
 * @author admin
 * @date 2020-05-25 16:01
 */
public interface IRpcService {


    HttpResponseModel doMethod(HttpRequestModel requestModel);

}
