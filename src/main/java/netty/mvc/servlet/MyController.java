package netty.mvc.servlet;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/21
 */
public class MyController {



    public String getName(Integer id) {
        String name = "";
        switch (id){
            case  1:
                name="tom";
                break;
            case  2:
                name="mic";
                break;
            case  3:
                name="james";
                break;
            case  4:
                name="seven";
                break;
            default:
                name="nopeople";
                break;
        }
        return name;
    }

}
