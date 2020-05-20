package com.yzl.springcloud.tocmat;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/20
 */
public class FirstServlet implements MyServlet {

    public  void doGet(MyHttpRequest request, MyHttpResponse response) {
        doPost(request, response);
    }

    public void doPost(MyHttpRequest request, MyHttpResponse response) {

        String param = "name";
        String str = request.getParameter(param);
        response.write(param + ":" + str,200);
    }
}
