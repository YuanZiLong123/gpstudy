package sun.net.www.protocol.yzl;

import org.springframework.core.io.ClassPathResource;
import sun.net.www.URLConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author admin
 * @date 2020-08-19 11:25
 */
public class YzlUrlConnection extends URLConnection {

    private final ClassPathResource resource;

    public YzlUrlConnection(URL url) {
        super(url);
        this.resource = new ClassPathResource(url.getPath());
    }

    @Override
    public void connect() throws IOException {

    }

    @Override
    public InputStream getInputStream() throws IOException {
        return  resource.getInputStream();
    }
}
