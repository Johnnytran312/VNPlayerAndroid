package android.nnbinh.hcmus.vietnam_player.fragment;

import android.nnbinh.hcmus.vietnam_player.R;
import android.nnbinh.hcmus.vietnam_player.activity.EqualizerActivity;
import android.nnbinh.hcmus.vietnam_player.model.MediaModel;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Calendar;

/**
 * Created by nguyenngocbinh on 1/7/17.
 */

public class PlayerMediaFragment extends BaseFragment {
    private static MediaModel mMedia;
    private static final String MEDIA_MODEL_KEY = "MEDIA_MODEL_KEY";
    private ImageView mImageDisk;
    private ImageView mBtnPause;
    private ImageView mBtnPlay;
    private ImageView mBtnEqualizer;
    private ProgressBar mProgressBar;
    private Runnable mUpdateProgressBar;
    private Handler handler = new Handler();
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
        mBtnPlay = (ImageView) view.findViewById(R.id.iv_action_play);
        mBtnEqualizer = (ImageView) view.findViewById(R.id.iv_action_equalizer);
        mBtnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnPause.setVisibility(View.GONE);
                mBtnPlay.setVisibility(View.VISIBLE);
            }
        });

        mBtnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBtnPlay.setVisibility(View.GONE);
                mBtnPause.setVisibility(View.VISIBLE);
            }
        });

        mBtnEqualizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(EqualizerActivity.class);
            }
        });
        //rorateDiskAutomation(mImageDisk);
        mSizeMedia = convertMinuteToMillis(1);
        mTotalTime = Calendar.getInstance().getTimeInMillis() + mSizeMedia;
        mUpdateProgressBar = new Runnable() {
            @Override
            public void run() {
                long currentTime = Calendar.getInstance().getTimeInMillis();
                long temp = mTotalTime - currentTime;
                int percent = (int)((temp * 100) / mSizeMedia);
                percent = 100 - percent;
                if (percent > 100 || percent < 0) {
                    handler.removeCallbacks(mUpdateProgressBar);
                    mUpdateProgressBar = null;
//                    mImageDisk.startAnimation(null);
                    mBtnPlay.setVisibility(View.VISIBLE);
                    mBtnPause.setVisibility(View.GONE);

                }else {
                    mProgressBar.setProgress(percent);
                }

                handler.postDelayed(this, 1000);
            }
        };
        mUpdateProgressBar.run();
    }

    @Override
    public void onResume() {
        super.onResume();
        setTitle(mMedia.getName());
    }

    private void rorateDiskAutomation(ImageView img) {
        RotateAnimation anim = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(4000);

        // Start animating the image
        img.startAnimation(anim);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.iv_action_equalizer:
                goToActivity(EqualizerActivity.class);
                break;
            case R.id.iv_action_pause:
                mBtnPause.setVisibility(View.GONE);
                mBtnPlay.setVisibility(View.VISIBLE);
                break;
            case R.id.iv_action_play:
                mBtnPlay.setVisibility(View.GONE);
                mBtnPause.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
//        mImageDisk.startAnimation(null);
    }
    public long convertMinuteToMillis(int minute) {
        return minute * 60 *1000;
    }

    private View.OnClickListener mEqualizerOnClicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToActivity(EqualizerActivity.class);

        }
    };
}
