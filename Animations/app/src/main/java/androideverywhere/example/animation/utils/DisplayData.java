package androideverywhere.example.animation.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class DisplayData {

    private DisplayMetrics metrics;

    public DisplayData(Activity activity) {
        initDisplay(activity);
    }

    private void initDisplay(Activity activity) {
        metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
    }

    public int getScreenWidth() {
        return metrics.widthPixels;
    }

    public int getScreenHeight() {
        return metrics.heightPixels;
    }

}
