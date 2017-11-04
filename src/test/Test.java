package test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Test {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(sdf.format(d));
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        java.sql.Date datesql = new java.sql.Date(d.getTime());
        System.out.println(datesql);
    }
}
