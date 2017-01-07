package android.nnbinh.hcmus.vietnam_player.fragment;


import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.MainActivity;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.activity.EqualizerActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class BaseFragment extends Fragment implements View.OnClickListener{
    public void goToFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(R.id.content_main,fragment)
                .addToBackStack(null).commit();
    }

    public void setTitle(String title) {
        getActivity().setTitle(title);
    }

    public void goToActivity(Class activityClass) {
        Intent intent = new Intent(getActivity(), activityClass);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

    }
}
