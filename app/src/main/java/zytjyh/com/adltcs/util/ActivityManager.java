package zytjyh.com.adltcs.util;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZYTJYH on 13/1/2018.
 */

public class ActivityManager extends Application {

    //存放所有Activity的链表
    private List<Activity> activityList=new LinkedList<Activity>();
    //单例设计模式
    private static ActivityManager instance;

    //构造函数私有化
    private ActivityManager(){

    }
    //获取实例
    public static ActivityManager getInstance(){
        if(instance==null)
        {
            instance=new ActivityManager();
        }
        return instance;
    }

    //添加Activity
    public void addActivity(Activity activity){
        activityList.add(activity);
    }

    //整个app退出时候调用
    public void exit(){
        for (Activity activity : activityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        int id = android.os.Process.myPid();
        if (id != 0) {
            android.os.Process.killProcess(id);
        }
    }
}
