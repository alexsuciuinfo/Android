package com.alex0x123.baloonboom;


import android.app.Activity;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

import com.android.vending.billing.*;

/**
 * Created by Alexandru on 28.06.2015.
 */
public class GetCoins extends  Activity{

    IInAppBillingService mService;


    protected void onCreate(Bundle saveStateInstance)
    {
        super.onCreate(saveStateInstance);

        ServiceConnection mServiceConn = new ServiceConnection() {
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }

            @Override
            public void onServiceConnected(ComponentName name,
                                           IBinder service) {
                mService = IInAppBillingService.Stub.asInterface(service);
            }
        };
    }
}
