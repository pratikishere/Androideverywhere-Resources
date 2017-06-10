package androideverywhere.example.animation.utils;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

public class GlobalLayoutUtil {

    public static IOnViewReady getListener() {
        return listener;
    }

    public static void setListener(IOnViewReady listener) {
        GlobalLayoutUtil.listener = listener;
    }

    private static IOnViewReady listener;

    public interface IOnViewReady{
        void onViewReady(View view);
    }

    public static void setGlobalLayoutListener(View...views)
    {
        for (final View view:views)
        {
            view.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {

                        @SuppressLint("NewApi")
                        @SuppressWarnings("deprecation")
                        @Override
                        public void onGlobalLayout() {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                view.getViewTreeObserver()
                                        .removeGlobalOnLayoutListener(this);
                            } else {
                                view.getViewTreeObserver()
                                        .removeOnGlobalLayoutListener(this);
                            }

                            listener.onViewReady(view);
                        }
                    });
        }

    }
}
