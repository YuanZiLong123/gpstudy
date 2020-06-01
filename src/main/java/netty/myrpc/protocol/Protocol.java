package netty.myrpc.protocol;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author admin
 * @date 2020-06-01 14:38
 */
public class Protocol implements Serializable {

    //接口
    private String className;

    //方法
    private String method;

    //参数类型
    private Class<?>[] args;

    //参数列表
    private Object[] values;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class[] getArgs() {
        return args;
    }

    public void setArgs(Class[] args) {
        this.args = args;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }
}
