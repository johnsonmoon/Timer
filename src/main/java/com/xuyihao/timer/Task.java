package com.xuyihao.timer;

/**
 * Created by Xuyh at 2016/08/04 上午 11:30.
 *
 * 具体任务虚类，使用时候继承重写taskForJob方法
 */
public abstract class Task {
    /**
     * 需要重写的逻辑任务方法，任务逻辑都写在此方法里面，供定时任务调用
     */
    public abstract void taskForJob();
}
