package cn.enncy.tomcat.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * //TODO
 * <br/>Created in 16:34 2021/5/3
 *
 * @author: enncy
 */
public class TimeUtils {

    public static String getGMTTime(){
        SimpleDateFormat sdf = new SimpleDateFormat(
                "EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        return sdf.format(new Date());
    }

}
