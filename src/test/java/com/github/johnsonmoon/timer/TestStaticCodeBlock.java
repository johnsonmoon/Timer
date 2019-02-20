package com.github.johnsonmoon.timer;

/**
 * Created by Xuyh at 2016/08/05 上午 11:39.
 */
public class TestStaticCodeBlock {
    private static MultiThreadSchedualTimer multiThreadSchedualTimer = new MultiThreadSchedualTimer(2);

    static {
        System.out.println(123);
        multiThreadSchedualTimer.execute(new Task() {
            private int i = 0;

            @Override
            public void taskForJob() {
                i++;
                System.out.println("Execute! " + i);
            }
        }, 1000, 2000);
    }

    public static void abcd() {

    }
}
