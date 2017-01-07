package android.nnbinh.hcmus.vietnam_player.fragment;

import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.model.MediaModel;
import android.nnbinh.hcmus.vietnam_player.utils.UtilAnimation;
import android.nnbinh.hcmus.vietnam_player.utils.UtilTime;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Calendar;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class PlayerMediaFragment extends BaseFragment {
    private static MediaModel mMedia;
    private ImageView mImageDisk;
    private ImageView mBtnPause;
    private ImageView mBtnPlay;
    private ImageView mBtnEqualizer;
    private ProgressBar mProgressBar;
    private Runnable mUpdateProgressBar;
    private Handler mHandler = new Handler();
    private long mTotalTime = 0;
    private long mSizeMedia = 0;
    public static PlayerMediaFragment start(MediaModel media){
        PlayerMediaFragment fragment = new PlayerMediaFragment();
        mMedia = media;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUpdateProgressBar = new Runnable() {
            @Override
            public void run() {
                long currentTime = Calendar.getInstance().getTimeInMillis();
                long temp = mTotalTime - currentTime;
                int percent = (int)((temp * 100) / mSizeMedia);
                percent = 100 - percent;
                if (percent > 100 || percent < 0) {
                    mHandler.removeCallbacks(mUpdateProgressBar);
                    mUpdateProgressBar = null;
                    if (mBtnPlay == null || mBtnPause == null) {
                        // nothing
                    }else {
                        mBtnPlay.setVisibility(View.VISIBLE);
                        mBtnPause.setVisibility(View.GONE);
                    }
                }else {
                    mProgressBar.setProgress(percent);
                }

                mHandler.postDelayed(this, 1000);
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player_media, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageDisk = (ImageView) view.findViewById(R.id.iv_disk);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mBtnPause = (ImageView) view.findViewById(R.id.iv_action_pause);
        mBtnPause.setOnClickListener(this);
        mBtnPlay = (ImageView) view.findViewById(R.id.iv_action_play);
        mBtnPlay.setOnClickListener(this);
        mBtnEqualizer = (ImageView) view.findViewById(R.id.iv_action_equalizer);
        mBtnEqualizer.setOnClickListener(this);

        UtilAnimation.rorateDiskAutomation(mImageDisk);
        mSizeMedia = UtilTime.convertMinuteToMillis(1);
        mTotalTime = Calendar.getInstance().getTimeInMillis() + mSizeMedia;
        mHandler.post(mUpdateProgressBar);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.iv_action_equalizer:
                goToFragment(new EqualizerFragment());
                break;
            case R.id.iv_action_play:
                mBtnPlay.setVisibility(View.GONE);
                mBtnPause.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_action_pause:
                mBtnPause.setVisibility(View.GONE);
                mBtnPlay.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        setLayout(R.layout.fragment_player_media);
        setTitle(mMedia.getName());
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mImageDisk.clearAnimation();
        mHandler.removeCallbacks(mUpdateProgressBar);
        mUpdateProgressBar = null;
        mBtnPause = null;
        mBtnPlay = null;
        mMedia = null;
    }
}
