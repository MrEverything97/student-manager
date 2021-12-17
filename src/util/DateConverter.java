package util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class DateConverter {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date fromString(String d) {
        try {
            return sdf.parse(d);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
