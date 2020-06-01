package net.lishaoy.music.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import net.lishaoy.lib_audio.app.AudioHelper;

public class MusicApplication extends Application {
    private static MusicApplication mApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;
        //视频SDK初始化
//        VideoHelper.init(this);
        //音频SDK初始化
        AudioHelper.init(this);
        //分享SDK初始化
//        ShareManager.initSDK(this);
        //更新组件下载
//        UpdateHelper.init(this);
        //ARouter初始化
//        ARouter.init(this);
    }

    public static MusicApplication getInstance() {
        return mApplication;
    }
}
