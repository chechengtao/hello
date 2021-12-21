package swing.calendar;

/**
 *将每个月的日历返回二维数组
 */

public class Dates2 {

    public static String [][] weekday(int y,int m)
    {  int [] monthDay={31,28,31,30,31,30,31,31,30,31,30,31};
        int weekOfDay=Week.dateToWeek(Integer.toString(y)+"-"+Integer.toString(m)+"-01");
        String[][] days=new String[6][7];
        //将余数转换为个数
        int countYs=0;
        if(weekOfDay>0 &&weekOfDay<=6)
        {
            for (int i = 0; i < weekOfDay - 1; i++) {
                //System.out.print("\t\t\t");
                days[0][i]="\t\t\t";
                countYs+=1;
            }
        }
        else if(weekOfDay==0)
        {
            for (int j = 0; j <6; j++) {
                //System.out.print("\t\t\t");
                days[0][j]="\t\t\t";
                countYs+=1;
            }
        }
        for (int k = 0; k < monthDay[m-1]; k++) {
            String day=((k+1)+"["+ChinaDate.oneDay2(y,m,k+1)+"]\t\t");
            //把日历信息放到二维数组中即可
            //(k+countYS)/7=行号 %7=列号
            days[(k+countYs)/7][(k+countYs)%7]=day;
        }

        return  days;
    }
}