package android.nnbinh.hcmus.vietnam_player.fragment;

import android.graphics.Color;
import android.nnbinh.hcmus.vietnam_player.Custom.CustomTab;
import android.nnbinh.hcmus.vietnam_player.Custom.CustomTabLayout;
import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.adapter.MyPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class MainFragment extends BaseFragment {
    private MyPagerAdapter mAdapter;
    private ViewPager mVp_pager;
    private ArrayList<CustomTab> mTabs;
    private CustomTabLayout tabLayout;
    private int mNormalColor = Color.BLUE;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(getString(R.string.app_name));
    }

    public void init(View view){
        mTabs = getCustomTabs();
        mAdapter = new MyPagerAdapter(getContext(), getActivity().getSupportFragmentManager(), mTabs);
        mVp_pager = (ViewPager) view.findViewById(R.id.vp_pager);
        mVp_pager.setAdapter(mAdapter);
        settingTabLayout(view);
        mAdapter.notifyDataSetChanged();
    }

    private void settingTabLayout(View view){
        tabLayout = (CustomTabLayout) view.findViewById(R.id.sliding_tabs);
        tabLayout.setTabsPerPage(3);
        tabLayout.setupWithViewPager(mVp_pager);
    }


    private ArrayList<CustomTab> getCustomTabs(){
        ArrayList<CustomTab>  tabs = new ArrayList<CustomTab>();
        tabs.add(new CustomTab(getString(R.string.tab_media_title),R.mipmap.ic_song, Color.RED));
        tabs.add(new CustomTab(getString(R.string.tab_album_title),R.mipmap.ic_album,Color.RED));
        tabs.add(new CustomTab(getString(R.string.tab_singer_title),R.mipmap.ic_artist,Color.RED));
        tabs.add(new CustomTab(getString(R.string.tab_playlist_title),R.mipmap.ic_playlist,Color.RED));

        return tabs;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
