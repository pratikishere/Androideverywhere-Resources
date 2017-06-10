package androideverywhere.example.animation.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.ActivityCircularRevealAnimationsBinding;


public class CircularRevealAnimationsActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityCircularRevealAnimationsBinding binding;

    public static final int TOP_LEFT = 1;
    public static final int TOP_RIGHT = 2;
    public static final int CENTER = 3;
    public static final int BOTTOM_LEFT = 4;
    public static final int BOTTOM_RIGHT = 5;

    int positionArray [] = new int[2];
    int currentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_circular_reveal_animations);
        setListeners();
    }

    private void setListeners()
    {
        binding.btnTopLeft.setOnClickListener(this);
        binding.btnTopRight.setOnClickListener(this);
        binding.btnCenter.setOnClickListener(this);
        binding.btnBottomLeft.setOnClickListener(this);
        binding.btnBottomRight.setOnClickListener(this);
        binding.btnHide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnTopLeft){
            showWithCircularRevealAnimation(binding.vRevealEffect,TOP_LEFT);
        }
        else if(view == binding.btnTopRight){
            showWithCircularRevealAnimation(binding.vRevealEffect,TOP_RIGHT);
        }
        else if(view == binding.btnCenter){
            showWithCircularRevealAnimation(binding.vRevealEffect,CENTER);
        }
        else if(view == binding.btnBottomLeft){
            showWithCircularRevealAnimation(binding.vRevealEffect,BOTTOM_LEFT);
        }
        else if(view == binding.btnBottomRight){
            showWithCircularRevealAnimation(binding.vRevealEffect,BOTTOM_RIGHT);
        }
        else if(view == binding.btnHide){
            hideWithCircularRevealAnimation(binding.vRevealEffect,currentType);
        }
    }

    private void showWithCircularRevealAnimation(View view,int animationType)
    {
        currentType = animationType;

        int positionArray [] = getPositions(view,animationType);

        int cx = positionArray[0];
        int cy = positionArray[1];

        // get the final radius for the clipping circle
        float finalRadius = (float) Math.hypot( view.getWidth(),view.getHeight());

        Log.e("finalRadius:",""+ finalRadius);

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

        // make the view visible and start the animation
        view.setVisibility(View.VISIBLE);
        anim.start();
    }

    private void hideWithCircularRevealAnimation(final View view,int animationType)
    {
        int positionArray [] = getPositions(view,animationType);

        int cx = positionArray[0];
        int cy = positionArray[1];

        // get the initial radius for the clipping circle
        float initialRadius = (float) Math.hypot( view.getWidth(),view.getHeight());

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);
        anim.setDuration(getResources().getInteger(R.integer.anim_duration_medium));

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();
    }

    private void hideWithRevealEffect(final View view)
    {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

        // get the initial radius for the clipping circle
        float initialRadius = (float) Math.hypot( view.getWidth(),view.getHeight());

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();
    }

    private int [] getPositions(View view, int animationType)
    {
        int cx=0,cy=0;

        if(animationType == TOP_RIGHT)
        {
            cx = view.getWidth();
        }
        else if(animationType == CENTER)
        {
            cx = view.getWidth() / 2;
            cy = view.getHeight() / 2;
        }
        else if(animationType == BOTTOM_LEFT)
        {
            cy = view.getHeight();
        }
        else if(animationType == BOTTOM_RIGHT)
        {
            cx =  view.getWidth();
            cy =  view.getHeight();
        }

        positionArray[0] = cx;
        positionArray[1] = cy;

        return positionArray;
    }
}
