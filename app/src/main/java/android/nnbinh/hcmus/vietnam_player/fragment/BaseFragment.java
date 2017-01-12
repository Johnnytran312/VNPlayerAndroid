package android.nnbinh.hcmus.vietnam_player.fragment;


import android.content.Intent;
import android.nnbinh.hcmus.vietnam_player.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import cloud.com.android.flexiblebase.fbase.fragment.FBaseFragment;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class BaseFragment extends FBaseFragment implements View.OnClickListener{
    private int mResLayoutId;

    public void setLayout(int resLayoutId) {
        mResLayoutId = resLayoutId;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(mResLayoutId, container, false);
        return view;
    }

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
    }

    @Override
    public void onClick(View view) {

    }
}
