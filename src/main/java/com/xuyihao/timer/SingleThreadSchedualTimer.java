package com.xuyihao.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Xuyh at 2016/08/04 上午 10:21.
 *
 * 对java.util的Timer类进行简单封装
 */
public class SingleThreadSchedualTimer {
    private Timer timer = new Timer();

    public SingleThreadSchedualTimer(){
        this.timer = new Timer();
    }

    public void stop(){
        if(this.timer == null){
            System.out.println("Error! No task to be stopped!");
        }else{
            this.timer.cancel();
        }
    }

    /**
     * 延迟delay时间后执行任务
     *
     * @param task 任务对象
     * @param delay 延迟时间
     */
    public void execute(final Task task, long delay){
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, delay);
    }

    /**
     * 延迟delay时间后以指定间隔时间重复执行任务
     *
     * @param task 任务对象
     * @param delay 延迟时间
     * @param timeInterval 执行间隔
     */
    public void execute(final Task task, long delay, long timeInterval){
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, delay, timeInterval);
    }

    /**
     * 从startTime指定的时间开始以指定间隔时间重复执行任务
     *
     * @param task 任务对象
     * @param startTime 开始时间，date对象
     * @param timeInterval 执行间隔
     */
    public void execute(final Task task, Date startTime, long timeInterval){
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, startTime, timeInterval);
    }

    /**
     * 在time时间执行任务
     *
     * @param task 任务对象
     * @param time 指定时间，date对象
     */
    public void execute(final Task task, Date time){
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, time);
    }

    /**
     * 从startTime指定的时间开始以指定间隔时间重复执行任务
     * 固定执行频率不受上一个任务执行的影响
     *
     * @param task 任务对象
     * @param firstTime 第一次执行的时间
     * @param timeInterval 执行间隔
     */
    public void executeAtFixedRate(final Task task, Date firstTime, long timeInterval){
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, firstTime, timeInterval);
    }

    /**
     * 延迟delay时间后以指定间隔时间重复执行任务
     * 固定执行频率不受上一个任务执行的影响
     *
     * @param task 任务对象
     * @param delay 延迟时间
     * @param timeInterval 执行间隔
     */
    public void executeAtFixedRate(final Task task, long delay, long timeInterval){
        this.timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                task.taskForJob();
            }
        }, delay, timeInterval);
    }
}
