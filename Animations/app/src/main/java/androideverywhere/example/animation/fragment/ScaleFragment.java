package androideverywhere.example.animation.fragment;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentScaleBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class ScaleFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady{

    FragmentScaleBinding binding;

    ObjectAnimator animTopLeft,animTopRight,animBottomLeft,animBottomRight,
            animOpenTop,animOpenBottom,animOpenLeft,animOpenRight,
            animOpenCenterX,animOpenCenterY,
            animZoomInZoomOut;

    float scaleFrom = 0f,scaleTo = 1f,scaleTo2x = 2f;

    public static final String TAG = ScaleFragment.class.getSimpleName();

    public static ScaleFragment newInstance()
    {
        ScaleFragment fragment = new ScaleFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_scale,container,false);
        GlobalLayoutUtil.setListener(this);

        initAnimTopLeft(binding.tvTopLeft);
        initAnimTopRight(binding.tvTopRight);
        initAnimBottomLeft(binding.tvBottomLeft);
        initAnimBottomRight(binding.tvBottomRight);

        initAnimOpenFromTop(binding.tvOpenFromTop);
        initAnimOpenFromBottom(binding.tvOpenFromBottom);
        initAnimOpenFromLeft(binding.tvOpenFromLeft);
        initAnimOpenFromRight(binding.tvOpenFromRight);
        initAnimOpenFromCenterX(binding.tvOpenFromCenterX);
        initAnimOpenFromCenterY(binding.tvOpenFromCenterY);

        initAnimZoomInZoomOut(binding.tvZoomInZoomOut);

        GlobalLayoutUtil.setGlobalLayoutListener(binding.tvTopLeft,binding.tvTopRight,binding.tvBottomLeft,binding.tvBottomRight,
                binding.tvOpenFromTop,binding.tvOpenFromBottom,binding.tvOpenFromLeft,binding.tvOpenFromRight,
                binding.tvOpenFromCenterX,binding.tvOpenFromCenterY,
                binding.tvZoomInZoomOut);
        return binding.getRoot();
    }

    private void initAnimTopLeft(View view) {

        animTopLeft = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animTopLeft,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimTopRight(View view) {
        animTopRight = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animTopRight,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimBottomLeft(View view) {
        animBottomLeft = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animBottomLeft,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimBottomRight(View view) {

        animBottomRight = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animBottomRight,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromTop(View view) {

        animOpenTop = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,1,1), // scaleX remains same
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animOpenTop,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromBottom(View view) {

        animOpenBottom = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,1,1), // scaleX remains same
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animOpenBottom,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromLeft(View view) {

        animOpenLeft = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,1,1)); // scaleY remains same
        setAnimValues(animOpenLeft,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromRight(View view) {

        animOpenRight = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,1,1)); // scaleY remains same
        setAnimValues(animOpenRight,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromCenterX(View view) {

        animOpenCenterX = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleFrom,scaleTo),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,1,1)); // scaleY remains same
        setAnimValues(animOpenCenterX,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimOpenFromCenterY(View view) {

        animOpenCenterY = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,1,1), // scaleX remains same
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleFrom,scaleTo));
        setAnimValues(animOpenCenterY,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }

    private void initAnimZoomInZoomOut(View view) {

        animZoomInZoomOut = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat(View.SCALE_X,scaleTo,scaleTo2x),
                PropertyValuesHolder.ofFloat(View.SCALE_Y,scaleTo,scaleTo2x));

        setAnimValues(animZoomInZoomOut,activity.getResources().getInteger(R.integer.anim_duration_too_slow),ValueAnimator.REVERSE);
    }


    @Override
    public void onViewReady(View view) {
        if(view == binding.tvTopLeft){

            // Pivot means point from which animation begins i.e. ( 0, 0 ) means animation begins from top-left corner of View
            view.setPivotX(0); // x co ordinate to view top-left
            view.setPivotY(0); // y co ordinate to view top-left

            animTopLeft.start();

            //oLog.e(TAG,"pivot x y "+view.getPivotX()+" "+view.getPivotY());
        }
        else if(view == binding.tvTopRight){

            view.setPivotX(view.getWidth()); // x co ordinate to view top-right
            view.setPivotY(0);               // y co ordinate remains same

            animTopRight.start();
        }
        else if(view == binding.tvBottomLeft){
            view.setPivotX(0);                 // x co ordinate remains same
            view.setPivotY(view.getHeight());  // y co ordinate to view bottom-left

            animBottomLeft.start();
        }
        else if(view == binding.tvBottomRight){
            view.setPivotX(view.getWidth()); // x co ordinate to view bottom-right
            view.setPivotY(view.getHeight()); // y co ordinate to view bottom-right

            animBottomRight.start();
        }
        else if(view == binding.tvOpenFromTop){
            view.setPivotX(0);
            view.setPivotY(0);

            animOpenTop.start();
        }
        else if(view == binding.tvOpenFromBottom){
            view.setPivotX(view.getHeight());
            view.setPivotY(view.getHeight());

            animOpenBottom.start();
        }
        else if(view == binding.tvOpenFromLeft){
            view.setPivotX(0);
            view.setPivotY(0);

            animOpenLeft.start();
        }
        else if(view == binding.tvOpenFromRight){
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getWidth());

            animOpenRight.start();
        }
        else if(view == binding.tvOpenFromCenterX){
            view.setPivotX(view.getWidth() / 2); // x co ordinate to view center
            view.setPivotY(view.getHeight() / 2); // y co ordinate to view center

            animOpenCenterX.start();
        }
        else if(view == binding.tvOpenFromCenterY){
            view.setPivotX(view.getWidth() / 2); // x co ordinate to view center
            view.setPivotY(view.getHeight() / 2); // y co ordinate to view center

            animOpenCenterY.start();
        }
        else if(view == binding.tvZoomInZoomOut){
            view.setPivotX(view.getWidth() / 2); // x co ordinate to view center
            view.setPivotY(view.getHeight() / 2); // y co ordinate to view center

            animZoomInZoomOut.start();
        }

    }
}
