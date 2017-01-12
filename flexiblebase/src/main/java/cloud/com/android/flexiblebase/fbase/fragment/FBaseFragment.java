package cloud.com.android.flexiblebase.fbase.fragment;

import android.support.v4.app.Fragment;
import android.content.Intent;

/**
 * Created by BinhNguyen on 1/12/2017.
 */

public class FBaseFragment extends Fragment {
    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public void goToActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }

}
