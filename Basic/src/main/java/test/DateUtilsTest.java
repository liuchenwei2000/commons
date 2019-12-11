package test;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * <p>
 * Created by liuchenwei on 2018/1/25.
 */
public class DateUtilsTest {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.YEAR, 2017);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DATE, 22);
        Date dongzhi = calendar.getTime();

        Date today = new Date();


        for (int i = 1; i < 10; i++) {
            Date date = DateUtils.addDays(dongzhi, i * 9);

            if(date.after(today)){
                long time1 = date.getTime();
                long time2 = today.getTime();

                long diff = time1 - time2;

                int days = (int) (diff / (1000 * 60 * 60 * 24));
                System.out.println(i + " 九 " + (9-days) +" 天");
                break;
            }
        }

    }
}
