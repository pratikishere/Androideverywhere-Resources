package androideverywhere.example.animation;

import android.app.Application;

public class App extends Application
{
    public static final String TAG = App.class.getSimpleName();
    private static App mInstance;

    public App() {
        super();
    }

    public static synchronized App getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
