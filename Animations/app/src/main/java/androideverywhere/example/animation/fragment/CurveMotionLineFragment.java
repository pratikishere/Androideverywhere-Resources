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

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentCmCommonBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class CurveMotionLineFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    public static final String TAG = CurveMotionLineFragment.class.getSimpleName();
    FragmentCmCommonBinding binding;
    ObjectAnimator objectAnimator;

    public static CurveMotionLineFragment newInstance()
    {
        CurveMotionLineFragment fragment = new CurveMotionLineFragment();
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

    /**
     * Animates view to path
     * @param view
     */
    private void animateLine(View view)
    {
        Path path = new Path();
        path.moveTo(view.getX(),view.getY());
        path.lineTo(view.getX() + 200,view.getY());

        objectAnimator =
                ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        setAnimValues(objectAnimator,1200,ValueAnimator.REVERSE);
        objectAnimator.start();
    }


    @Override
    public void onViewReady(View view) {
        if(view == binding.vSquare){
            animateLine(view);
        }
    }

}
