package androideverywhere.example.animation.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.animation.LinearInterpolator;

import androideverywhere.example.animation.activity.CurveMotionActivity;
import androideverywhere.example.animation.activity.PropertyAnimationsActivity;


public class BaseFragment extends Fragment {

    public Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(getActivity() instanceof PropertyAnimationsActivity)
            activity = (PropertyAnimationsActivity)context;
        else if((getActivity() instanceof CurveMotionActivity))
            activity = (CurveMotionActivity)context;
    }

    public void setAnimValues(ObjectAnimator objectAnimator,int duration,int repeatMode)
    {
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(repeatMode);
        objectAnimator.setInterpolator(new LinearInterpolator());
    }
}
