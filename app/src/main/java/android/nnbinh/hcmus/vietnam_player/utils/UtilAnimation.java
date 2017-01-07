package android.nnbinh.hcmus.vietnam_player.utils;

import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/**
 * Created by nguyenngocbinh on 1/8/17.
 */

public class UtilAnimation {

    public static void rorateDiskAutomation(ImageView img) {
        RotateAnimation anim = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        anim.setInterpolator(new LinearInterpolator());
        anim.setRepeatCount(Animation.INFINITE);
        anim.setDuration(8000);

        // Start animating the image
        img.startAnimation(anim);
    }
}
