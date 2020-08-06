package dubbo.customer.controller;

import dubbo.api.IRpcService;
import dubbo.protocol.HttpRequestModel;

import javax.annotation.Resource;

/**
 * @author admin
 * @date 2020-05-25 16:17
 */
public class RpcController {


    //@Autowired
    @Resource
    private IRpcService rpcService;


    public  void doController(){
        HttpRequestModel requestModel = new HttpRequestModel();
        rpcService.doMethod(requestModel);
    }

}
