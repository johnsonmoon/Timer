package com.github.johnsonmoon.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xuyh at 2016/08/04 上午 10:21.
 * <p>
 * 对scheduledExecutorService进行简单封装的类
 */
public class MultiThreadScheduleTimer {
    private ScheduledExecutorService scheduledExecutorService;
    private ScheduledFuture scheduledFutureHandler;

    /**
     * constructor
     *
     * @param threadCount 线程数量
     */
    public MultiThreadScheduleTimer(int threadCount) {
        if (threadCount == 1) {
            this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        } else if (threadCount > 1) {
            this.scheduledExecutorService = Executors.newScheduledThreadPool(threadCount);
        } else {
            System.out.println("Error! Thread count can not be less than 1 !");
        }
    }

    public void stop() {
        if (!(this.scheduledFutureHandler == null)) {
            scheduledFutureHandler.cancel(true);
        }
    }

    public void execute(final Task task, long delay, long timeInterval) {
        if (this.scheduledExecutorService != null) {
            this.scheduledFutureHandler = this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                public void run() {
                    task.taskForJob();
                }
            }, delay, timeInterval, TimeUnit.MILLISECONDS);
        } else {
            System.out.println(" null");
        }
    }
}
