package androideverywhere.example.animation.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentRotateBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class RotateFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    FragmentRotateBinding binding;

    ObjectAnimator animRotationClockwise,animRotationAntiClockwise,animRotationX,animRotationY;

    public static RotateFragment newInstance()
    {
        RotateFragment fragment = new RotateFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rotate,container,false);
        GlobalLayoutUtil.setListener(this);

        initAnimRotationClockwise(binding.ivRotatationClockwise);
        initAnimRotationCounterClockwise(binding.ivRotatationAntiClockwise);
        initAnimRotationX(binding.ivRotatationX);
        initAnimRotationY(binding.ivRotatationY);

        GlobalLayoutUtil.setGlobalLayoutListener(binding.ivRotatationClockwise,binding.ivRotatationAntiClockwise,binding.ivRotatationX,binding.ivRotatationY);
        return binding.getRoot();
    }

    private void initAnimRotationClockwise(View view) {

        animRotationClockwise = ObjectAnimator.ofFloat(view,View.ROTATION, 0f, 360f);
        setAnimValues(animRotationClockwise,activity.getResources().getInteger(R.integer.anim_duration_slow),ValueAnimator.RESTART);
    }

    private void initAnimRotationCounterClockwise(View view) {

        animRotationAntiClockwise = ObjectAnimator.ofFloat(view,View.ROTATION,360f, 0f);
        setAnimValues(animRotationAntiClockwise,activity.getResources().getInteger(R.integer.anim_duration_slow),ValueAnimator.RESTART);
    }

    private void initAnimRotationX(View view) {

        animRotationX = ObjectAnimator.ofFloat(view,View.ROTATION_X, 0f, 360f);
        setAnimValues(animRotationX,activity.getResources().getInteger(R.integer.anim_duration_slow),ValueAnimator.RESTART);
    }

    private void initAnimRotationY(View view) {

        animRotationY = ObjectAnimator.ofFloat(view,View.ROTATION_Y, 0f, 360f);
        setAnimValues(animRotationY,activity.getResources().getInteger(R.integer.anim_duration_slow),ValueAnimator.RESTART);
    }

    @Override
    public void onViewReady(View view) {
        if(view == binding.ivRotatationClockwise){
            animRotationClockwise.start();
        }
        else if(view == binding.ivRotatationAntiClockwise){
            animRotationAntiClockwise.start();
        }
        else if(view == binding.ivRotatationX){
            animRotationX.start();
        }
        else if(view == binding.ivRotatationY){
            animRotationY.start();
        }
    }
}
