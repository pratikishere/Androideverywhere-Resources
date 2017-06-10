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


public class CurveMotionQuadFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    public static final String TAG = CurveMotionQuadFragment.class.getSimpleName();
    FragmentCmCommonBinding binding;
    ObjectAnimator objectAnimator;

    public static CurveMotionQuadFragment newInstance()
    {
        CurveMotionQuadFragment fragment = new CurveMotionQuadFragment();
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

    private void animateQuad(View view)
    {
        Path path = new Path();
        path.moveTo(view.getX(),view.getY());

        path.cubicTo(view.getX(),view.getY(),
                view.getX() + 300,view.getY() + 200,
                view.getX() - 400,view.getY() + 500);

        objectAnimator =
                ObjectAnimator.ofFloat(view, View.X, View.Y, path);

        setAnimValues(objectAnimator,1200,ValueAnimator.REVERSE);
        objectAnimator.start();
    }


    @Override
    public void onViewReady(View view) {
        if(view == binding.vSquare){
            animateQuad(view);
        }
    }

}
