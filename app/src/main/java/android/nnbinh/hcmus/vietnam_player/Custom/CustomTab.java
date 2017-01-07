package android.nnbinh.hcmus.vietnam_player.Custom;

/**
 * Created by nguyenngocbinh on 1/5/17.
 */

public class CustomTab {
    private String mTitle;
    private int mIcon;

    public String getTitle() {
        return mTitle;
    }

    public int getIcon() {
        return mIcon;
    }

    public int getSelectedColor() {
        return mSelectedColor;
    }

    private int mSelectedColor;

    public CustomTab(String title, int icon, int color){
        mTitle = title;
        mIcon = icon;
        mSelectedColor = color;
    }
}
