package base.time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2020/5/22
 */
public class LocalTimeTest {



    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormat =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime =   LocalDateTime.now();
        System.out.println(dateTimeFormat.format(localDateTime));

    }

}
