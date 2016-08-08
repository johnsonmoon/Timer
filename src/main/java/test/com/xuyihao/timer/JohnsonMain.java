package test.com.xuyihao.timer;

import com.xuyihao.timer.util.TimeUtil;

/**
 * Created by Xuyh at 2016/08/05 上午 11:37.
 */
public class JohnsonMain {
   public static void main(String args[]){
        while(true) {
            long remainedTime = TimeUtil.getRemainedTimeMillis("00:00:01");
            remainedTime = remainedTime/1000/60;
            System.out.println(remainedTime);
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
