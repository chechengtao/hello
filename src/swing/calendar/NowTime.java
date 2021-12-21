package swing.calendar;

//输出实时的时间 年月日以及农历
import java.text.SimpleDateFormat;
import java.util.Date;

class NowTime {
    static String Now()
    {
       // System.out.println( chinaDate.today());
        SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
        String otime=time.format(new Date());
        //System.out.println(otime);
        return ChinaDate.today()+"\t"+otime;
    }
}
