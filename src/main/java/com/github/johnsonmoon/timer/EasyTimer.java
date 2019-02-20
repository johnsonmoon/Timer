package com.github.johnsonmoon.timer;

/**
 * Created by Xuyh at 2016/08/04 上午 10:23.
 * <p>
 * 简单定时器
 * 开启一条线程执行简单的定时循环任务
 * 通过线程睡眠达到延时作用
 */
public class EasyTimer {
    /**
     * 间隔时间
     */
    private long timeInterval = 0;

    /**
     * 是否结束任务执行
     */
    private boolean interrupt = false;

    /**
     * constructor
     */
    public EasyTimer() {

    }

    /**
     * constructor
     *
     * @param timeInterval 设置时间间隔
     */
    public EasyTimer(long timeInterval) {
        this.timeInterval = timeInterval;
    }

    /**
     * 停止任务的执行
     */
    public void stop() {
        this.interrupt = true;
    }

    /**
     * 执行任务
     */
    public void execute(final Task task) {
        new Thread(new Runnable() {
            public void run() {
                while (!EasyTimer.this.interrupt) {
                    task.taskForJob();
                    try {
                        Thread.sleep(EasyTimer.this.timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    /**
     * 设置间隔时间并执行任务
     *
     * @param timeInterval
     */
    public void execute(final Task task, long timeInterval) {
        this.timeInterval = timeInterval;
        this.execute(task);
    }
}
