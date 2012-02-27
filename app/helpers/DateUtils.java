package helpers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * User: mseid
 * Date: 2/26/12
 * Time: 9:00 PM
 * Company: StudyBook
 * Property of OpenEdu LLC. All rights reserved.
 */
public class DateUtils {
    public static SimpleDateFormat getFormatter(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        return simpleDateFormat;
    }
    public static HashMap calculateDifference(Date time1, Date time2){
        long milliseconds1 = time1.getTime();
        long milliseconds2 = time2.getTime();
        long diff = milliseconds2 - milliseconds1;
        HashMap<String, Long> object = new HashMap<String, Long>();
        object.put("second", diff / 1000);
        object.put("minutes", diff / (60 * 1000));
        object.put("hours", diff / (60 * 60 * 1000));
        object.put("days", diff / (24 * 60 * 60 * 1000));
        return object;
    }
}
