package androideverywhere.example.animation.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.btnTweenAnim.setOnClickListener(this);
        binding.btnCircularReveal.setOnClickListener(this);
        binding.btnCurveMotion.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnTweenAnim){
            goToActivity(PropertyAnimationsActivity.class);
        }
        else if(view == binding.btnCircularReveal){
            goToActivity(CircularRevealAnimationsActivity.class);
        }
        else if(view == binding.btnCurveMotion){
            goToActivity(CurveMotionActivity.class);
        }
    }

    private void goToActivity(Class activityName){
        Intent intent = new Intent(this,activityName);
        startActivity(intent);
    }
}
