package android.nnbinh.hcmus.vietnam_player.adapter;

import android.content.Context;
import android.nnbinh.hcmus.vietnam_player.Custom.CustomTab;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.fragment.FirstFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private ArrayList<CustomTab> mTabs;
    private int mFirstSelectedIndex = 1;
    public MyPagerAdapter(Context context, FragmentManager fm, ArrayList<CustomTab> tabs){
        super(fm);
        mContext = context;
        mTabs = tabs;
    }

    public ArrayList<CustomTab> getTabs() {
        return mTabs;
    }

    public void setTabs(ArrayList<CustomTab> mTabs) {
        this.mTabs = mTabs;
    }

    @Override
    public Fragment getItem(int position) {
        return FirstFragment.newInstance(position, mTabs.get(position).getTitle());
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return  mTabs.get(position).getTitle();
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        CustomTab tab = mTabs.get(position);
        View v = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.tv_tab_title);
        tv.setText(tab.getTitle());
        if(position == mFirstSelectedIndex)
            tv.setTextColor(tab.getSelectedColor());
        ImageView img = (ImageView) v.findViewById(R.id.im_tab_icon);
        img.setImageResource(tab.getIcon());
        return v;
    }
}
