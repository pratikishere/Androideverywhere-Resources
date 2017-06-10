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
import androideverywhere.example.animation.databinding.FragmentAlphaBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class AlphaFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady {

    FragmentAlphaBinding binding;

    private final String PROPERTY_ALPHA   = "alpha";

    ObjectAnimator animFadeIn,animFadeOut;

    public static AlphaFragment newInstance()
    {
        AlphaFragment fragment = new AlphaFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_alpha,container,false);
        GlobalLayoutUtil.setListener(this);

        initAnimFadeIn(binding.tvFadeIn);
        initAnimFadeOut(binding.tvFadeOut);

        GlobalLayoutUtil.setGlobalLayoutListener(binding.tvFadeIn,binding.tvFadeOut);
        return binding.getRoot();
    }

    private void initAnimFadeIn(View view) {

        animFadeIn = ObjectAnimator.ofFloat(view,PROPERTY_ALPHA, 1f,0f);
        setAnimValues(animFadeIn,activity.getResources().getInteger(R.integer.anim_duration_too_slow_2x),ValueAnimator.RESTART);
    }

    private void initAnimFadeOut(View view) {

        animFadeOut = ObjectAnimator.ofFloat(view,PROPERTY_ALPHA, 0f,1f);
        setAnimValues(animFadeOut,activity.getResources().getInteger(R.integer.anim_duration_too_slow_2x),ValueAnimator.RESTART);
    }


    @Override
    public void onViewReady(View view) {
        if(view == binding.tvFadeIn){
            animFadeIn.start();
        }
        else if(view == binding.tvFadeOut){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            animFadeOut.start();
        }
    }
}
