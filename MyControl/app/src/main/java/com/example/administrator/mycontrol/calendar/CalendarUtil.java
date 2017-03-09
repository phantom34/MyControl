package com.example.administrator.mycontrol.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtil {

    private static Integer[] ShowDaysOfMonth = {28, 35, 42};
    private static Integer[] weekDay = {0, 1, 2,3,4,5,6,0};

    //获取一月的第一天是星期几
    public static int getDayOfWeek(int y, int m, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(y, m - 1, day);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    //获取一月最大天数
    public static int getDayOfMonth(int y, int m) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, 1);
        int dateOfMonth = cal.getActualMaximum(Calendar.DATE);
        return dateOfMonth;
    }

    public static int getMothOfMonth(int y, int m) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, 1);
        int dateOfMonth = cal.get(Calendar.MONTH);
        return dateOfMonth + 1;
    }

    public static int[] getYMD(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return new int[]{cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE)};
    }

    public static int getShowDaysoOfMonth(int y, int m, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(y, m - 1, day);
        int showDays = cal.getActualMaximum(Calendar.DATE);
        showDays += getDayOfWeek(y, m, day)-1;
        for(int i=0;i<3;i++)
            if(showDays<=ShowDaysOfMonth[i]){
                showDays=ShowDaysOfMonth[i];
                break;
            }
        return showDays;
    }
}
