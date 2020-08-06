package dubbo.protocol;

/**
 * @author admin
 * @date 2020-05-25 16:02
 */
public class HttpResponseModel {

    private String code;

    private Object object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }


}
