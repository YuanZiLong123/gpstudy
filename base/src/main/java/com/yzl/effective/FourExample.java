package effective;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class FourExample {

    private final  Date birthDate;


    public FourExample(Date birthDate) {
        this.birthDate = birthDate;
    }

    private static  final  Date BOOM_START;

    private static  final  Date BOOM_END;

    static {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946,calendar.JANUARY,1,0,0,0);
        BOOM_START = calendar.getTime();
        calendar.set(1965,calendar.JANUARY,1,0,0,0);
        BOOM_END= calendar.getTime();
    }


    public static void main(String[] args) {
        Date date = new Date();
        FourExample fourExample = new FourExample(date);
        long time1 = System.currentTimeMillis();
        for (int i = 0;i<10000;i++){
            fourExample.isBabyBooner();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(time2-time1);

        long time3 = System.currentTimeMillis();
        for (int i = 0;i<10000;i++){
            fourExample.isBabyBooner2();
        }
        long time4= System.currentTimeMillis();

        System.out.println(time4-time3);
    }


    public  boolean isBabyBooner(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946,calendar.JANUARY,1,0,0,0);
        Date boomStart = calendar.getTime();
        calendar.set(1965,calendar.JANUARY,1,0,0,0);
        Date boomEnd = calendar.getTime();

        return  birthDate.compareTo(boomStart)>=0&&
                birthDate.compareTo(boomEnd)<0;

    }

    public  boolean isBabyBooner2(){
        return  birthDate.compareTo(BOOM_START)>=0&&
                birthDate.compareTo(BOOM_END)<0;
    }

}
