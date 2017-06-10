package androideverywhere.example.animation.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentTranslateBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class TranslateFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    public static final String TAG = TranslateFragment.class.getSimpleName();

    FragmentTranslateBinding binding;
    ObjectAnimator animX,animTranslationX,animY,animTranslationY;
    AnimatorSet animSetXY;

    public static TranslateFragment newInstance()
    {
        TranslateFragment fragment = new TranslateFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_translate,container,false);
        GlobalLayoutUtil.setListener(this);

        initTranslationX(binding.tvTranslationX);
        initX(binding.tvX);
        initTranslationY(binding.tvTranslationY);
        initY(binding.tvY);
        initAnimatorSet(binding.tvAnimatorSet);

        GlobalLayoutUtil.setGlobalLayoutListener(binding.tvTranslationX,binding.tvX,binding.tvTranslationY,binding.tvY,binding.tvAnimatorSet);
        return binding.getRoot();
    }

    private void initTranslationX(View view) {
        animTranslationX = ObjectAnimator.ofFloat(view,View.TRANSLATION_X, 0, 150);
        setAnimValues(animTranslationX,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
    }

    private void initX(View view) {
        animX = ObjectAnimator.ofFloat(view,View.X, 0, 150);
        setAnimValues(animX,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
    }

    private void initTranslationY(View view) {
        animY = ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,0,150);
        setAnimValues(animY,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
    }

    private void initY(View view) {
        animTranslationY = ObjectAnimator.ofFloat(view,View.Y,0,150);
        setAnimValues(animTranslationY,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
    }

    private void initAnimatorSet(View view) {
        animSetXY = new AnimatorSet();
        ObjectAnimator y = ObjectAnimator.ofFloat(view,View.TRANSLATION_Y,view.getY(), 100);
        setAnimValues(y,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
        ObjectAnimator x = ObjectAnimator.ofFloat(view,View.TRANSLATION_X, view.getX(), 100);
        setAnimValues(x,activity.getResources().getInteger(R.integer.anim_duration_medium),ValueAnimator.REVERSE);
        animSetXY.playTogether(x, y);
    }

    @Override
    public void onViewReady(View view) {
        if(view == binding.tvX){
            animX.start();
        }
        else if(view == binding.tvTranslationX){
            animTranslationX.start();
        }
        else if(view == binding.tvY){
            animY.start();
        }
        else if(view == binding.tvTranslationY){
            animTranslationY.start();
        }
        else if(view == binding.tvAnimatorSet){
            animSetXY.start();
        }
    }
}
