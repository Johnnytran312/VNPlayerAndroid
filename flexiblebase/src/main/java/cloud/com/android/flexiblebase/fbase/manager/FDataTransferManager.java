package cloud.com.android.flexiblebase.fbase.manager;

import android.content.Context;

import java.util.HashMap;

import cloud.com.android.flexiblebase.fbase.application.FApplication;

/**
 * Created by BinhNguyen on 1/12/2017.
 */

public class FDataTransferManager extends FManager{
    private HashMap<String, Object> mDataMaps = new HashMap<>();

    public static FDataTransferManager get(Context context) {
        return FApplication.get(context).getDataTransferManager();
    }

    public void putData(String key, Object data) {
        mDataMaps.put(key, data);
    }

    public Object getData(String key) {
        return getData(key, false);
    }

    public Object getData(String key, boolean alsoRemoveFromCache) {
        if (alsoRemoveFromCache) {
            return mDataMaps.remove(key);
        } else {
            return mDataMaps.get(key);
        }
    }
}
