package androideverywhere.example.animation.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import androideverywhere.example.animation.R;

public class BaseActivity extends AppCompatActivity {

    public void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void showToolbarBack(final Activity activity,Toolbar toolbar)
    {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onBackPressed();
            }
        });
    }

    public void setToolbarTitle(Toolbar toolbar, String title)
    {
        ((TextView)toolbar.findViewById(R.id.toolbar_tvTitle)).setText(title);
    }
}
