package android.nnbinh.hcmus.vietnam_player.fragment;


import android.nnbinh.hcmus.vietnam_player.R;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class BaseFragment extends Fragment {
    public void goToFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_main,fragment)
                .addToBackStack(null).commit();
    }

    public void setTitle(String title) {
        getActivity().setTitle(title);
    }
}
