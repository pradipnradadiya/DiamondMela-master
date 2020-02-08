package com.dealermela;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.onesignal.OneSignal;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Fresco.initialize(this);
//        Fresco.initialize(this);

        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
    }
}
