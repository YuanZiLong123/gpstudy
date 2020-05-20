
package com.yzl.springcloud.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SayHello", targetNamespace = "http://webservice.springcloud.yzl.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SayHello {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://webservice.springcloud.yzl.com/", className = "com.yzl.springcloud.webservice.SayHello_Type")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://webservice.springcloud.yzl.com/", className = "com.yzl.springcloud.webservice.SayHelloResponse")
    @Action(input = "http://webservice.springcloud.yzl.com/SayHello/sayHelloRequest", output = "http://webservice.springcloud.yzl.com/SayHello/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
