package cloud.com.android.flexiblebase.fbase.application;

import android.app.Application;
import android.content.Context;

import cloud.com.android.flexiblebase.fbase.manager.FDataTransferManager;

/**
 * Created by BinhNguyen on 1/12/2017.
 */

public class FApplication extends Application {
    private FDataTransferManager mDataTransferManager;

    public static FApplication get(Context context) {
        if (context == null) {
            return null;
        }
        context = context.getApplicationContext();
        if (FApplication.class.isInstance(context)) {
            return (FApplication) context;
        }
        return null;
    }

    public FDataTransferManager getDataTransferManager() {
        if (mDataTransferManager == null) {
            mDataTransferManager = new FDataTransferManager();
        }
        return mDataTransferManager;
    }
}
