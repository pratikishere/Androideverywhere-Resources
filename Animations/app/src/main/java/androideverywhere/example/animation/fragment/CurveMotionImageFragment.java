package androideverywhere.example.animation.fragment;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.databinding.DataBindingUtil;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;

import androideverywhere.example.animation.R;
import androideverywhere.example.animation.databinding.FragmentCmImageBinding;
import androideverywhere.example.animation.utils.GlobalLayoutUtil;


public class CurveMotionImageFragment extends BaseFragment implements GlobalLayoutUtil.IOnViewReady,View.OnClickListener{

    public static final String TAG = CurveMotionImageFragment.class.getSimpleName();
    FragmentCmImageBinding binding;
    ObjectAnimator objectAnimator;

    // This is path array which contains original x,y points i.e. for lightning_bolt image in drawable of size 240*318
    Point[] path = {
            new Point(44, 43),
            new Point(164, 136),
            new Point(76, 165),
            new Point(196, 273)
    };

    public static CurveMotionImageFragment newInstance()
    {
        CurveMotionImageFragment fragment = new CurveMotionImageFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cm_image,container,false);
        GlobalLayoutUtil.setListener(this);
        binding.btnStart.setOnClickListener(this);
        GlobalLayoutUtil.setGlobalLayoutListener(binding.ivLightningBolt);
        return binding.getRoot();
    }

    private double getScaleFactor()
    {
        // This gets information from image so that we can get original width and height data i.e 240*318 of lighting_bolt.png
        BitmapFactory.Options dimensions = new BitmapFactory.Options();
        dimensions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.lightning_bolt, dimensions);
        int originalHeight = dimensions.outHeight;
        int originalWidth =  dimensions.outWidth;

        Log.e(TAG,"Image original width: "+originalWidth);
        Log.e(TAG,"Image original height: "+originalHeight);

        // Gets screen image width and height irrespective size of ImageView
        int imageHeight = binding.ivLightningBolt.getDrawable().getIntrinsicHeight();
        int imageWidth =  binding.ivLightningBolt.getDrawable().getIntrinsicWidth();

        Log.e(TAG,"Image width: "+imageWidth);
        Log.e(TAG,"Image height: "+imageHeight);

        return imageHeight / originalHeight;
    }

    /**
     * Moves view to particular ( x , y )
     * @param view
     * @param topLeftX x co ordinate
     * @param topLeftY y co ordinate
     */
    private void moveViewToStartPoint(View view,int topLeftX,int topLeftY)
    {
        view.setX(topLeftX);
        view.setY(topLeftY);
    }

    @Override
    public void onViewReady(View view) {
        if(view == binding.ivLightningBolt){
            // Need to calculate scale factor as image is in drawable folder it size varies from device to device
            double scaleFactor = getScaleFactor();
            Log.e(TAG,"Scale factor: "+scaleFactor);

            // Gets image top-left co ordinate values ( x , y )
            int imageX = binding.ivLightningBolt.getLeft();
            int imageY = binding.ivLightningBolt.getTop();

            // Cahnges points positions on screen by applying apply scale factor and adding image ( x , y ) as by default it is relatvie to ( 0 , 0 )
            for (int i = 0; i < path.length ; i++) {
                path[i].set((int)scaleFactor * path[i].x + imageX,(int)scaleFactor * path[i].y + imageY);
            }

            moveViewToStartPoint(binding.vSquare, path[0].x, path[0].y);
        }
    }

    /**
     * Animates view to path
     * @param view
     */
    private void animateCurveMotion(View view)
    {
        Path path = new Path();

        path.moveTo(this.path[0].x, this.path[0].y);

        for (int i = 1; i < this.path.length; i++) {
            path.lineTo(this.path[i].x, this.path[i].y);
        }

        objectAnimator =
                ObjectAnimator.ofFloat(view, View.X, View.Y, path);
        setAnimValues(objectAnimator,1200,ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    public void setAnimValues(ObjectAnimator objectAnimator,int duration,int repeatMode)
    {
        objectAnimator.setDuration(duration);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(repeatMode);
        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    }

    @Override
    public void onClick(View view) {
        if(view == binding.btnStart){
            animateCurveMotion(binding.vSquare);
        }
    }
}
