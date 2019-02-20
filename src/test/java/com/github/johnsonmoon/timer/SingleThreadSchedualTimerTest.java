package com.github.johnsonmoon.timer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Xuyh at 2016/08/04 下午 03:16.
 */
public class SingleThreadSchedualTimerTest {
    public static void test(String args[]) {
        //testExecute1();
        //testExecute2();
        //testExecute3();
        //testExecute4();
        //testExecute5();
        //testExecute6();
    }

    public static void testExecute1() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        timer.execute(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, 3000);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute2() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        timer.execute(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, 2000, 1000);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute3() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 50);
        Date date = calendar.getTime();
        timer.execute(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, date);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute4() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 50);
        calendar.set(Calendar.SECOND, 50);
        Date date = calendar.getTime();
        timer.execute(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, date, 3000);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute5() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 15);
        calendar.set(Calendar.MINUTE, 49);
        calendar.set(Calendar.SECOND, 50);
        Date date = calendar.getTime();
        timer.executeAtFixedRate(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, date, 2000);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute6() {
        SingleThreadScheduleTimer timer = new SingleThreadScheduleTimer();
        timer.executeAtFixedRate(new Task() {
            @Override
            public void taskForJob() {
                System.out.println("执行！");
            }
        }, 5000, 2000);
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
