package sun.net.www.protocol.yzl;

import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @author admin
 * @date 2020-08-19 11:28
 */
public class YzlUrlTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("yzl:/META-INF\\spring\\user.properties");
        InputStream inputStream = url.openStream();
        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));

    }

}
