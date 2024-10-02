package org.example.javalab;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateBean {
    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }
}