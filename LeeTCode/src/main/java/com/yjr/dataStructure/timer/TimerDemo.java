package com.yjr.dataStructure.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yangjiuran
 * @Date 2020/11/27
 */
public class TimerDemo {
    Timer timer;
    Calendar calendar ;
    SimpleDateFormat simpleDateFormat;
    public TimerDemo(int seconds) {
        timer = new Timer();
        calendar=Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timer.schedule(new RemindTask(),0, seconds*1000);
    }

    class RemindTask extends TimerTask {

        public void run() {
            Date date = calendar.getTime();
            String format = simpleDateFormat.format(date);
            System.out.println(format+":雷电预警计算中");
            System.out.println(format+":山火预警计算中");
            System.out.println(format+":雷达预警计算中");
            System.out.println(format+":覆冰预警计算中");
            System.out.println(format+":台风预警计算中");
            System.out.println(format+":微气象在线监测预警阈值预警计算中");
            System.out.println(format+":导线温度在线监测预警阈值预警计算中");
            System.out.println(format+":计算完成");
            System.out.println(format+":数据共享开始");
            System.out.println(format+":数据已共享至过掉！预警线路0条，预警变电站0座");
            System.out.println(format+":数据共享完毕");

//            timer.cancel(); //Terminate the timer thread
        }
    }

    public static void main(String args[]) {
        System.out.println("About to schedule task.");
        TimerDemo timer = new TimerDemo(15);
        System.out.println("Task scheduled.");
    }
}
