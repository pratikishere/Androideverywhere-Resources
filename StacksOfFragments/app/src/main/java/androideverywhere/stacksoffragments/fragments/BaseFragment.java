package androideverywhere.stacksoffragments.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import androideverywhere.stacksoffragments.TabsActivity;

public class BaseFragment extends Fragment {
    public TabsActivity mActivity;
    public Resources mResources;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = (TabsActivity) this.getActivity();
        mResources = mActivity.getResources();
    }

    public boolean onBackPressed() {
        return false;
    }
}
