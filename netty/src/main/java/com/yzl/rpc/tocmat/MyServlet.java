package com.yzl.rpc.tocmat;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/20
 */
public interface MyServlet {


    void doGet(MyHttpRequest request,MyHttpResponse response);

    void doPost(MyHttpRequest request,MyHttpResponse response);
}
