package androideverywhere.example.animation.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.ActivityPropertyAnimationsBinding;
import androideverywhere.example.animation.fragment.AlphaFragment;
import androideverywhere.example.animation.fragment.RotateFragment;
import androideverywhere.example.animation.fragment.ScaleFragment;
import androideverywhere.example.animation.fragment.TranslateFragment;


public class PropertyAnimationsActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityPropertyAnimationsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_property_animations);

        binding.btnTranslate.setOnClickListener(this);
        binding.btnScale.setOnClickListener(this);
        binding.btnRotate.setOnClickListener(this);
        binding.btnAlpha.setOnClickListener(this);

        replaceFragment(TranslateFragment.newInstance());
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnTranslate){
            replaceFragment(TranslateFragment.newInstance());
        }
        else if(view == binding.btnScale){
            replaceFragment(ScaleFragment.newInstance());
        }
        else if(view == binding.btnRotate){
            replaceFragment(RotateFragment.newInstance());
        }
        else if(view == binding.btnAlpha){
            replaceFragment(AlphaFragment.newInstance());
        }
    }

    public void replaceFragment(Fragment fragment)
    {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.flContainerFragment.getId(),fragment)
                .commit();
    }
}
