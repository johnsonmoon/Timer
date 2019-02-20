package com.github.johnsonmoon.timer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Xuyh at 2016/08/04 下午 02:01.
 */
public class EasyTimerTest {

    public static void test(String args[]) {
        //testExecute();
        //testExecute2();
    }

    public static void testExecute2() {
        EasyTimer timer = new EasyTimer(2000);
        timer.execute(new Task() {
            private int i = 0;

            @Override
            public void taskForJob() {
                i++;
                System.out.println("执行" + i + "次");
            }
        });
        try {
            if (new BufferedReader(new InputStreamReader(System.in)).readLine().equals("stop")) {
                timer.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testExecute() {
        EasyTimer timer = new EasyTimer();
        Task task = new Task() {
            private int i = 0;

            @Override
            public void taskForJob() {
                i++;
                System.out.println("执行" + i + "次");
            }
        };
        timer.execute(task, 2000);
    }
}
