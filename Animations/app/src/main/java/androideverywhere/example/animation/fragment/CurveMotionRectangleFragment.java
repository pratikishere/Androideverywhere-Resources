package androideverywhere.example.animation.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.Path;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentCmCommonBinding;
import androideverywhere.example.animation.databinding.FragmentCmImageBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class CurveMotionRectangleFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    public static final String TAG = CurveMotionRectangleFragment.class.getSimpleName();
    FragmentCmCommonBinding binding;
    ObjectAnimator objectAnimator;

    public static CurveMotionRectangleFragment newInstance()
    {
        CurveMotionRectangleFragment fragment = new CurveMotionRectangleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cm_common,container,false);
        GlobalLayoutUtil.setListener(this);

        GlobalLayoutUtil.setGlobalLayoutListener(binding.vSquare);
        return binding.getRoot();
    }


    @Override
    public void onViewReady(View view) {
        if(view == binding.vSquare){
            animateRect(binding.vSquare);
        }
    }

    private void animateRect(View view)
    {
        Path path = new Path();
        path.moveTo(view.getX(),view.getY());
        path.addRect(view.getX(),view.getY(),view.getX() + 250 ,view.getY() + 150, Path.Direction.CW);

        objectAnimator =
                ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        setAnimValues(objectAnimator,1200,ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    public void setAnimValues(ObjectAnimator objectAnimator,int duration,int repeatMode)
    {
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(repeatMode);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

}
