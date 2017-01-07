package android.nnbinh.hcmus.vietnam_player.Custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class CustomTabLayout extends TabLayout {
    private Bitmap mImgLeft;
    private Bitmap mImgRight;
    private Paint mPaint = new Paint();
    private int mPadding = convertDp2Px(5);
    private int mPaddingTop = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;

    public CustomTabLayout(Context context) {
        this(context, null);
    }

    public CustomTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * set min width for tab
     *
     * @param width: is a min width of the tab
     * */
    public void setMinTabWidth(int width) {
        try {
            Field field = TabLayout.class.getDeclaredField("mRequestedTabMinWidth");
            field.setAccessible(true);
            field.set(this, width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set max width for tab
     *
     * @param width: is a max width of the tab
     * */
    public void setMaxTabWidth(int width) {
        try {
            Field field = TabLayout.class.getDeclaredField("mRequestedTabMaxWidth");
            field.setAccessible(true);
            field.set(this, width);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * set number of displayed tab on screen
     *
     * @param tabs: is number of displayed tab on screen
     * */
    public void setTabsPerPage(int tabs) {
        setMinTabWidth(getScreenWidth() / tabs);
        setMaxTabWidth(getScreenWidth() / tabs);
    }

    /**
     * set icon for left/right arrow
     *@param leftArrowRes : id of left arrow in resource
     *@param rightArrowRes: id of right arrow in resource
     * */
    public void setLeftRightIndicator(int leftArrowRes, int rightArrowRes){
        mImgLeft = BitmapFactory.decodeResource(getResources(), leftArrowRes);
        mImgRight = BitmapFactory.decodeResource(getResources(), rightArrowRes);
    }

    /**
     * set padding left/ right for arrow
     *@param padding : space from arrow to border
     * */
    public void setLeftRightIndicatorPadding(int padding) {
        mPadding = convertDp2Px(padding);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        ViewGroup slidingTabTrip = (ViewGroup) getChildAt(0);
        int tabStripWidth = slidingTabTrip.getWidth();
        if(tabStripWidth <= getWidth())
            return;

        if(mImgLeft != null){ // when you use your icon arrow
            mPaddingTop = getHeight() / 2 - mImgLeft.getHeight() / 2;
            if(getScrollX() > 0){
                mPaddingLeft = mPadding + (int) getScrollX();
                canvas.drawBitmap(mImgLeft, mPaddingLeft, mPaddingTop, mPaint);
            }

            if(getScrollX() < tabStripWidth - getWidth()){
                mPaddingRight = getScrollX() + getWidth() - mImgRight.getWidth() - mPadding;
                canvas.drawBitmap(mImgRight, mPaddingRight, mPaddingTop, mPaint);
            }
        }else{
            mPaint.setColor(Color.GRAY);
            mPaint.setStrokeWidth(5);
            mPaint.setAntiAlias(true);

            // coordinates of left arrow
            int squaredAngleFormula = convertDp2Px(7);
            int startX =  mPadding + (int) getScrollX();
            int startY = slidingTabTrip.getHeight()/2;

            int stopX1 = startX + squaredAngleFormula; //
            int stopY1 = startY - squaredAngleFormula; // stop x of bottom line
            int stopY2 = startY  + squaredAngleFormula; // stop y of bottom line

            if (getScrollX() > 0){
                canvas.drawLine(startX, startY, stopX1, stopY1, mPaint); // top line
                canvas.drawLine(startX, startY - convertDp2Px(1), stopX1, stopY2, mPaint);// bottom line
            }

            // coordinates of right arrow
            if (getScrollX() < tabStripWidth - getWidth()){
                int rightStopX =  getScrollX() + getWidth() - mPadding ;
                int rightStartX =  rightStopX - squaredAngleFormula;

                canvas.drawLine(rightStartX, stopY1, rightStopX, startY, mPaint); // top line
                canvas.drawLine(rightStartX, stopY2 , rightStopX, startY - convertDp2Px(1), mPaint);// bottom line
            }
        }
    }

    /**
     * set color of unselected/ selected tab
     *
     * @param normal: is color for unselected tab
     * @param selected: is color for selected tab
     * */
    public void setTabColor(int normal, int selected){
        setTabTextColors(normal,selected);
        setSelectedTabIndicatorColor(selected);
    }

    /**
     * get screen width
     *
     */
    private int getScreenWidth() {
        DisplayMetrics outMetrics = new DisplayMetrics();
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(outMetrics);
        int screenW = outMetrics.widthPixels;
        return screenW;
    }

    /**
     * convert dp values to px
     *
     * @param dp
     * @return
     */
    public int convertDp2Px(int dp) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        return (int)((dp * displayMetrics.density) + 0.5);
    }
}
