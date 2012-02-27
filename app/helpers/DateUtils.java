package helpers;

import java.text.SimpleDateFormat;

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
}
