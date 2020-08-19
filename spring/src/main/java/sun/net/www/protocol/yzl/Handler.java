package sun.net.www.protocol.yzl;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @author admin
 * @date 2020-08-19 11:24
 */
public class Handler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new YzlUrlConnection(u);
    }
}
