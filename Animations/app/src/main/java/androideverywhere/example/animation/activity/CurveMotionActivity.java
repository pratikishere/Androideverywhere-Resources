package androideverywhere.example.animation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.ActivityCurveMotionBinding;
import androideverywhere.example.animation.fragment.CurveMotionImageFragment;
import androideverywhere.example.animation.fragment.CurveMotionLineFragment;
import androideverywhere.example.animation.fragment.CurveMotionQuadFragment;
import androideverywhere.example.animation.fragment.CurveMotionRectangleFragment;


public class CurveMotionActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = CurveMotionActivity.class.getSimpleName();

    ActivityCurveMotionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_curve_motion);
        binding.btnImage.setOnClickListener(this);
        binding.btnRectangle.setOnClickListener(this);
        binding.btnQuad.setOnClickListener(this);
        binding.btnLine.setOnClickListener(this);

        replaceFragment(CurveMotionImageFragment.newInstance());
    }

    public void replaceFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.flContainerFragment.getId(),fragment)
                .commit();
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnImage){
            replaceFragment(CurveMotionImageFragment.newInstance());
        }
        else if(view == binding.btnRectangle){
            replaceFragment(CurveMotionRectangleFragment.newInstance());
        }
        else if(view == binding.btnQuad){
            replaceFragment(CurveMotionQuadFragment.newInstance());
        }
        else if(view == binding.btnLine){
            replaceFragment(CurveMotionLineFragment.newInstance());
        }
    }

}
